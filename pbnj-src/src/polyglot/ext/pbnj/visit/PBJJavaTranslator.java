package polyglot.ext.pbnj.visit;

import polyglot.ext.pbnj.tologic.*;

import polyglot.visit.*;
import polyglot.ast.*;
import polyglot.ext.jl.ast.*;
import polyglot.ext.jl5.ast.*;
import polyglot.ext.pbnj.ast.*;
import polyglot.types.*;
import polyglot.ext.pbnj.types.*;
import polyglot.ext.jl5.types.*;
import polyglot.util.*;

import kodkod.ast.Formula;
import kodkod.ast.Decl;
import kodkod.ast.Decls;
import kodkod.ast.Expression;
import kodkod.ast.Formula;
import kodkod.ast.IntConstant;

import polyglot.frontend.Job;

import java.util.*;

/** Visitor that translates ESJ AST nodes to Java AST nodes, for
    subsequent output. **/
public class PBJJavaTranslator extends ContextVisitor {

    // String for mangling the name of each dispatchee method
    protected static String dispatcheeStr = "$body";
    
    // String for making the formal names of the dispatcher method
    public static String argStr = "arg$";
    
    protected ESJNodeFactory nf;
    protected JL5TypeSystem ts;

    //FIXME 
    // Globals:
    static List emptyArgs = new TypedList(new LinkedList(), Expr.class, false);
    static FlagAnnotations emptyFlags = new FlagAnnotations(); 
    static {
	emptyFlags.classicFlags(Flags.NONE);
	emptyFlags.annotations(new TypedList(new LinkedList(), AnnotationElem.class, false));
    }

    static List<String> quantVars;
    static HashMap<Object, String> ToKodkodOp = new HashMap<Object, String>();
    static TypeNode LogMapTN, ClassTN, StringTN;
    static TypeNode currClassRawTN;
    public PBJJavaTranslator(Job job, TypeSystem ts, NodeFactory jlnf) {
	super(job, ts, jlnf);
	this.nf = (ESJNodeFactory) jlnf;
	this.ts = (JL5TypeSystem) ts;

	//System.out.println("init Translating...");
	// kodkod binaries
	ToKodkodOp.put(Unary.NOT, "not");
	ToKodkodOp.put(Unary.NEG, "negate");
	ToKodkodOp.put(Binary.BIT_AND, "and");
	ToKodkodOp.put(Binary.SHL, "shl");
	ToKodkodOp.put(Binary.SHR, "shr");
	ToKodkodOp.put(Binary.ADD, "plus");
	ToKodkodOp.put(Binary.SUB, "minus");
	ToKodkodOp.put(Binary.MUL, "multiply");
	ToKodkodOp.put(Binary.DIV, "divide");
	ToKodkodOp.put(Binary.COND_AND, "and");
	ToKodkodOp.put(Binary.COND_OR, "or");
	ToKodkodOp.put(FormulaBinary.COND_IMPLIES, "implies");
	ToKodkodOp.put(FormulaBinary.COND_IFF, "iff");
	ToKodkodOp.put(Binary.NE, "eq");
	ToKodkodOp.put(Binary.EQ, "eq");
	ToKodkodOp.put(Binary.LT, "lt");
	ToKodkodOp.put(Binary.LE, "lte");
	ToKodkodOp.put(Binary.GT, "gt");
	ToKodkodOp.put(Binary.GE, "gte");
	ToKodkodOp.put(Binary.ADD, "plus");
	ToKodkodOp.put(Binary.SUB, "minus");
	ToKodkodOp.put(Binary.MUL, "multiply");
	ToKodkodOp.put(Binary.DIV, "divide");
	try {
	    this.LogMapTN = nf.CanonicalTypeNode(null, ts.typeForName("polyglot.ext.pbnj.tologic.LogMap"));
	    this.StringTN = this.nf.CanonicalTypeNode(null, ts.String());
	    this.ClassTN = nf.CanonicalTypeNode(null, ts.Class());
	} catch (Exception e) {
	    System.exit(1);
	}
    }

    public ESJFieldDecl DesugarESJFieldDecl(ESJFieldDecl fieldDecl) throws SemanticException {	
	return (ESJFieldDecl) clearSpecFlag(fieldDecl);
    }

    public JL5ConstructorDecl DesugarJL5ConstructorDecl(JL5ConstructorDecl constrDecl) throws SemanticException {
	// don't add for enums
	if (constrDecl.flags().isPrivate() || hasCallToThis(constrDecl))
	    return constrDecl;
	JL5ParsedClassType clTp = (JL5ParsedClassType) constrDecl.constructorInstance().container();
	boolean isGeneric = clTp.isGeneric(); //FIXME
	if (isGeneric)
	    return constrDecl;
	List args = new TypedList(new LinkedList(), Expr.class, false);
	List body = new TypedList(new LinkedList(), Stmt.class, false);
	body.addAll(constrDecl.body().statements());
	body.add(nf.Eval(null, nf.Call(null, nf.This(null), "addInstance", args)));
	return (JL5ConstructorDecl) constrDecl.body(nf.Block(null, body));
    }
      
    public JL5MethodDecl DesugarEnsuredMethodDecl (ESJEnsuredMethodDecl methodDecl) throws SemanticException {
	methodDecl = (ESJEnsuredMethodDecl) methodDecl.name(methodDecl.fullName() + "_orig");
	return (JL5MethodDecl) methodDecl;
    }


    // quantify expr method desugars into a foreach stmt
    public JL5MethodDecl DesugarPredMethodDecl (ESJPredMethodDecl methodDecl) throws SemanticException {
	boolean isComprehension = methodDecl.isComprehension();
	String quantMtdId = methodDecl.id();	  
	FormulaBinary.Operator quantKind = methodDecl.quantKind();
	boolean quantKindBool1 = quantKind == FormulaBinary.ALL && !isComprehension ? true : false;
	boolean quantKindBool2 = quantKind == FormulaBinary.SOME ? false : true;
	boolean quantKindIsaCount = 
	    quantKind == FormulaBinary.ONE ||
	    quantKind == FormulaBinary.LONE;
	String quantVarN = methodDecl.quantVarN();
	Expr quantList = methodDecl.quantListExpr();
	List quantVarD = methodDecl.quantVarD();
	Expr quantExpr = methodDecl.quantClauseExpr();
	List extraMtdBody = new TypedList(new LinkedList(), Stmt.class, false);
	List quantClauseStmts = new TypedList(new LinkedList(), Stmt.class, false);
	Expr quantMainIfExpr = quantKindBool1 ? nf.Unary(null, Unary.NOT, quantExpr) : quantExpr;
	Local quantCount = nf.Local(null, "quantCount");
	Stmt ifExprPart;
	if (quantKindIsaCount)
	    ifExprPart = nf.Eval(null, nf.Unary(null, Unary.POST_INC, quantCount));
	else if (isComprehension) {
	    List argsW = new TypedList(new LinkedList(), Expr.class, false);
	    argsW.add(nf.Local(null, quantVarN));
	    ifExprPart = nf.Eval(null, nf.Call(null, nf.Local(null, "res"), "add", argsW));
	} else 
	    ifExprPart = nf.JL5Return(null, nf.BooleanLit(null, !quantKindBool2));
	Stmt quantMainStmt = nf.JL5If(null, quantMainIfExpr, ifExprPart, null);
	quantClauseStmts.add(quantMainStmt);	    
	if (quantKindIsaCount) {
	    extraMtdBody.add((Stmt) methodDecl.body().statements().get(0));
	    Expr countViolation = nf.ESJBinary(null, quantCount, Binary.GT, nf.IntLit(null, IntLit.INT, 1), "gt");
	    Stmt ifC = nf.JL5Return(null, nf.BooleanLit(null, !quantKindBool2));
	    Stmt quantMainStmt2 = nf.JL5If(null, countViolation, ifC, null);
	    quantClauseStmts.add(quantMainStmt2);	    
	} else if (isComprehension) {
	    Type sett = ts.typeForName("polyglot.ext.pbnj.primitives.PBJInternSet"); 
	    ParameterizedType pt = ts.parameterizedType((JL5ParsedClassType) sett);
	    ArrayList<Type> at = new ArrayList<Type>();
	    Type t = ((LocalDecl) quantVarD.get(0)).declType();
	    at.add(t.isInt() ? ts.typeForName("java.lang.Integer") : t);
	    pt.typeArguments(at);
	    TypeNode dTp = nf.CanonicalTypeNode(null, pt);
	    LocalDecl d1 = nf.JL5LocalDecl(null, emptyFlags, dTp, "res", nf.JL5New(null, dTp, emptyArgs, null, new TypedList(new LinkedList(), TypeNode.class, false)));
	    d1 = d1.localInstance(ts.localInstance(null, d1.flags(), d1.declType(), d1.name()));
	    extraMtdBody.add(d1);
	    methodDecl = (ESJPredMethodDecl) methodDecl.returnType(dTp);
	}
	Stmt forLoopBody = nf.Block(null, quantClauseStmts);
	Stmt forLoop = nf.ExtendedFor(null, quantVarD, quantList, forLoopBody);
	extraMtdBody.add(forLoop);
	Stmt retStmt =  
	    nf.JL5Return(null, 
			 quantKind == FormulaBinary.ONE ? 
			 nf.ESJBinary(null, quantCount, Binary.EQ, nf.IntLit(null, IntLit.INT, 1), "eq") :
			 isComprehension ? nf.Local(null, "res") :
			 nf.BooleanLit(null, quantKindBool2));
	extraMtdBody.add(retStmt);
	Block extraMtdBlock = nf.Block(null, extraMtdBody);
	methodDecl = (ESJPredMethodDecl) methodDecl.body(extraMtdBlock);

	return (JL5MethodDecl) methodDecl;

    }


    // quantify expr desugars to a method call (defined above)
    public Expr DesugarQuantifyExpr (ESJQuantifyExpr a) {
	String quantId = a.parentMethod().name()  + "_" + a.id();
	List args = new TypedList(new LinkedList(), Expr.class, false);
	for(Formal f : (List<Formal>)(a.parentMethod().formals()))
	    args.add(new Local_c(null,f.name()));
	for(LocalDecl d : (List<LocalDecl>)(a.quantVarD2()))
	    args.add(new Local_c(null,d.name()));
	Expr r = nf.Call(null,null,quantId, args);
	return a.isSingleComprehension() ? nf.Call(null, r, "get", emptyArgs) : r;
    }

    public Expr DesugarQuantifyTypeExpr (ESJQuantifyTypeExpr a) throws SemanticException  {
	TypeNode tn = a.theListType();
	Type tnTp = tn.type();
	Type t = ts.typeForName("java.util.ArrayList"); 
	ParameterizedType pt = ts.parameterizedType((JL5ParsedClassType) t);
	ArrayList<Type> at = new ArrayList<Type>();
	List args = new TypedList(new LinkedList(), Expr.class, false);
	Expr e;
	Expr a0 = null;
	if (tnTp instanceof TypeVariable) {
	    List args0 = new TypedList(new LinkedList(), Expr.class, false);
	    args0.add(nf.ClassLit(null, currClassRawTN));
	    args0.add(nf.StringLit(null, ((TypeVariable)tnTp).name()));
	    args0.add(nf.Local(null, "fallback_typeArgs"));
	    a0 = nf.Call(null, LogMapTN, "getGenericParamActualArg", args0);
	} else
	    a0 = nf.StringLit(null, tnTp.toString());
	args.add(a0);	    
	at.add(tnTp);
	e = nf.Call(null, LogMapTN, "allInstances", args);
	pt.typeArguments(at);
	TypeNode ltn = nf.CanonicalTypeNode(null, pt);
	return nf.JL5Cast(null, ltn, e);

    }

    FormulaBinary desugarImpliesBinary(FormulaBinary b) {
	return nf.FormulaBinary(null, nf.Unary(null, Unary.NOT, b.left()), FormulaBinary.COND_OR, b.right());
    }

    FormulaBinary desugarIffBinary(FormulaBinary b) {
	return nf.FormulaBinary(null, b.left(), Binary.EQ, b.right());
    }

    Stmt desugarAssume(ESJAssume a) {
	return nf.Eval(null, nf.Call(null, nf.This(null), a.internMethodName(), emptyArgs));
    }

    public Expr DesugarIntervalExpr (ESJIntervalExpr a) throws SemanticException {
	List args = new TypedList(new LinkedList(), Expr.class, false);
	args.add(a.lower());
	args.add(a.upper());
	return nf.Call(null, nf.CanonicalTypeNode(null, ts.typeForName("polyglot.ext.pbnj.primitives.PBJInternInteger")), "range", args);
    }

    public Expr DesugarESJFieldClosure(ESJFieldClosure f) throws SemanticException  {
	List args = new TypedList(new LinkedList(), Expr.class, false);
	ESJFieldClosure fc = (ESJFieldClosure) f;
	boolean isSetFieldsMap =  fc.isSetFieldsMap();
	boolean isSimple =  fc.isSimple();
	Receiver r;
	String m;
	if (isSetFieldsMap) {
	    Type t = ((ParameterizedType) fc.target().type()).typeArguments().get(0);
	    r = (Receiver) nf.CanonicalTypeNode(null, t);
	    m = "setMap_" + fc.multiNames().get(0);
	    args.add(fc.target());
	} else {
	    Type t = ((ParameterizedType) f.type()).typeArguments().get(0);
	    r = fc.target();
	    if (isSimple) {
		m = "multiFields_"+t.toString();
	    } else {
		m = "fieldsClosure_"+t.toString();
		args.add(fc.target());
		args.add(nf.BooleanLit(null, fc.isReflexive()));
	    }
	}
	for (int i=0; i<fc.multiNames().size(); i++) 
	    args.add(nf.StringLit(null, (String) fc.multiNames().get(i)));
	Expr res0 = nf.ESJBinary(null, (Expr) fc.target(), Binary.EQ, nf.NullLit(null));
	Expr res1 = nf.JL5New(null, nf.CanonicalTypeNode(null, fc.type()), emptyArgs, null, new TypedList(new LinkedList(), TypeNode.class, false));
	Expr res2 = nf.ESJFieldClosureCall(null, r, m, args, fc.kind(), fc.isIntSet()).type(f.type());
	Expr res = nf.JL5Conditional(null, res0, res1, res2);
	return res;
    }

    protected Node clearPureFlag(MethodDecl md) {
      return md.flags(md.flags().clear(((ESJTypeSystem)typeSystem()).Pure()));
    }

    protected Node clearSpecFlag(ESJFieldDecl md) {
      return md.flags(md.flags().clear(((ESJTypeSystem)typeSystem()).Spec()));
    }
    
    protected NodeVisitor enterCall(Node parent, Node n) throws SemanticException {
	if (n instanceof ESJEnsuredClassDecl) {
	    ESJEnsuredClassDecl classDecl = (ESJEnsuredClassDecl) n;
	    Type currClassTp = classDecl.type();
	    currClassRawTN = nf.CanonicalTypeNode(null, currClassTp);
	} 
	return super.enterCall(parent,n);
    }

    protected Node leaveCall(Node n) throws SemanticException {
	if (n instanceof ESJFieldDecl) {	    
	    return super.leaveCall(DesugarESJFieldDecl((ESJFieldDecl)n));
	}  else if (n instanceof ESJPredMethodDecl) {	    
	    return super.leaveCall(DesugarPredMethodDecl((ESJPredMethodDecl)n));
	} else if (n instanceof ESJEnsuredMethodDecl) {
	    return super.leaveCall(DesugarEnsuredMethodDecl((ESJEnsuredMethodDecl)n));
	} else if (n instanceof ESJQuantifyExpr) {
	    return super.leaveCall(DesugarQuantifyExpr((ESJQuantifyExpr)n));
	} else if (n instanceof ESJIntervalExpr) {
	    return super.leaveCall(DesugarIntervalExpr((ESJIntervalExpr)n));
	} else if (n instanceof ESJQuantifyTypeExpr) {
	    return super.leaveCall(DesugarQuantifyTypeExpr((ESJQuantifyTypeExpr)n));
	} else if (n instanceof ESJFieldClosure) {
	    return super.leaveCall(DesugarESJFieldClosure((ESJFieldClosure)n));
	} else if (n instanceof JL5ConstructorDecl && !(n instanceof ESJConstructorDecl)) {
	    return super.leaveCall(DesugarJL5ConstructorDecl((JL5ConstructorDecl)n));
	} else if (n instanceof FormulaBinary && 
	    ((FormulaBinary)n).operator() == FormulaBinary.COND_IMPLIES)
	    return super.leaveCall(desugarImpliesBinary((FormulaBinary)n));
	else if (n instanceof FormulaBinary && 
	    ((FormulaBinary)n).operator() == FormulaBinary.COND_IFF)
	    return super.leaveCall(desugarIffBinary((FormulaBinary)n));
	else if (n instanceof ESJAssume)
	    return super.leaveCall(desugarAssume((ESJAssume)n));
	else if (n instanceof ESJParameterizedNew) {
	    JL5New np = (JL5New) n;
	    TypeNode tn = np.objectType();
	    Type tp = tn.type();
	    if (tp instanceof ParameterizedType) {
		ParameterizedType tpp = (ParameterizedType) tp;
		Type t = tpp.typeArguments().get(0);
		if (!(t instanceof TypeVariable || t == ts.Object()) && 
		    PBJAddExtraClassMembers.genericTypeSpecFields.containsKey(tpp.baseType())) { //HACK FIXME
		    List args = new TypedList(new LinkedList(), Expr.class, false);	       
		    args.add(PBJAddExtraClassMembers.typeParametersAsStringArray(tpp, nf));
		    n = nf.Call(null, np, "fallback_setTypeArgs", args).type(np.type());
		}
	    }
	    return super.leaveCall(n);
	} 
	else {
	    return super.leaveCall(n);
	}
    }

    private boolean hasCallToThis(JL5ConstructorDecl constrDecl) {
	Object s = constrDecl.body().statements().get(0);
	return !(s instanceof JL5ConstructorCall) || 
	    ((JL5ConstructorCall) s).kind() == JL5ConstructorCall.THIS;
    }

    public boolean isPrimitive(Type t) { 
	return t.isPrimitive() || isString(t);
    }

    public boolean isString(Type t) { 
	return t.toString().equals("java.lang.String");
    }

}



