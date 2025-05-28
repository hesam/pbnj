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
import kodkod.ast.IntExpression;

import polyglot.frontend.Job;

import java.util.*;

/** Visitor that translates ESJ AST nodes to Java AST nodes, for
    subsequent output. **/
public class PBJLogicTranslator extends ContextVisitor {

    // String for mangling the name of each dispatchee method
    protected static String dispatcheeStr = "$body";

    // String for making the formal names of the dispatcher method
    public static String argStr = "arg$";
    
    protected ESJNodeFactory nf;
    protected JL5TypeSystem ts;

    //FIXME 
    // Globals:
    static List emptyArgs = new TypedList(new LinkedList(), Expr.class, false);
    static List emptyTypeNodes = new TypedList(new LinkedList(), TypeNode.class, false);
    static Expr loc; 
    static FlagAnnotations emptyFlags = new FlagAnnotations(); 
    static {
	emptyFlags.classicFlags(Flags.NONE);
	emptyFlags.annotations(new TypedList(new LinkedList(), AnnotationElem.class, false));
    }

    static List<String> quantVars;
    static HashMap LogMtdRetTypes = new HashMap();
    static HashMap<Object, String> ToKodkodOp = new HashMap<Object, String>();
    TypeNode LogMapTN;
    TypeNode LogProblemTN;
    TypeNode IntExprTN;
    TypeNode ExprTN;
    TypeNode LogExprTN;
    TypeNode FormulaTN;
    TypeNode varTN;
    TypeNode pbjIntTN;
    TypeNode intConstTN;
    Type arrayListTp;
    static TypeNode currClassRawTN;
    static JL5ParsedClassType currClassTp;
    public PBJLogicTranslator(Job job, TypeSystem ts, NodeFactory jlnf) {
	super(job, ts, jlnf);
	this.nf = (ESJNodeFactory) jlnf;
	this.ts = (JL5TypeSystem) ts;
	LogMtdRetTypes.put("boolean","LogFormula");
	LogMtdRetTypes.put("java.lang.Integer","LogInt");
	LogMtdRetTypes.put("int","LogInt");

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
	    this.LogProblemTN = this.nf.CanonicalTypeNode(null, ts.typeForName("polyglot.ext.pbnj.tologic.LogProblem"));
	    this.LogExprTN = this.nf.CanonicalTypeNode(null, ts.typeForName("polyglot.ext.pbnj.tologic.LogExpr"));
	    this.IntExprTN = nf.CanonicalTypeNode(null, ts.typeForName("kodkod.ast.IntExpression"));
	    this.intConstTN = nf.CanonicalTypeNode(null, ts.typeForName("kodkod.ast.IntConstant"));
	    this.ExprTN = nf.CanonicalTypeNode(null, ts.typeForName("kodkod.ast.Expression"));
	    this.FormulaTN = nf.CanonicalTypeNode(null, ts.typeForName("kodkod.ast.Formula"));
	    this.varTN = nf.CanonicalTypeNode(null, ts.typeForName("kodkod.ast.Variable"));
	    this.pbjIntTN = nf.CanonicalTypeNode(null, ts.typeForName("polyglot.ext.pbnj.primitives.PBJInternInteger"));
	    this.arrayListTp = ts.typeForName("java.util.ArrayList"); 
	} catch (Exception e) {
	    System.exit(1);
	}
	loc = nf.Local(null, "fallback_problem");
    }


    protected NodeVisitor enterCall(Node parent, Node n) throws SemanticException {
	if (n instanceof ESJEnsuredClassDecl) {
	    ESJEnsuredClassDecl classDecl = (ESJEnsuredClassDecl) n;
	    currClassTp = (JL5ParsedClassType) classDecl.type();
	    currClassRawTN = nf.CanonicalTypeNode(null, currClassTp);
	} 
	return super.enterCall(parent,n);
    }

    protected Node leaveCall(Node n) throws SemanticException {
	if (n instanceof ESJLogPredMethodDecl) {	    
	    return super.leaveCall(DesugarLogPredMethodDecl((ESJLogPredMethodDecl)n));
	} else
	    return super.leaveCall(n);
    }

    public ESJLogPredMethodDecl DesugarLogPredMethodDecl(ESJLogPredMethodDecl methodDecl) throws SemanticException {
	//HACK FIXME
	Type t = methodDecl.returnType().type();
	String tN = t instanceof ParameterizedType ? 
	    ((ParsedClassType) ((ParameterizedType)t).baseType()).name() : 
	    t.toString(); 
	ESJLogPredMethodDecl res = (ESJLogPredMethodDecl) toLogicExpr(methodDecl);
	return res;
    }

    public Node toLogicExpr(Node r) throws SemanticException {
//    	System.out.println("have: " + r.getClass() + " " + r);
	if (r instanceof ESJLogPredMethodDecl) {	 
	    ESJLogPredMethodDecl methodDecl = (ESJLogPredMethodDecl) r;
	    Block methodDeclBody = methodDecl.body();
	    List formals = new TypedList(new LinkedList(), Formal.class, false);

	    // HACK FIXME
	    List inits = new TypedList(new LinkedList(), Stmt.class, false);
	    quantVars = new ArrayList(); //FIXME
	    Block block;
	    if (methodDecl.isFallback()) {
		List<Formal> frms = (List<Formal>) methodDecl.formals();
		for (int i = 0; i < frms.size(); i++) {
		    Formal f = frms.get(i);
		    TypeNode fTp = f.type();
		    formals.add(f);
		    LocalDecl dC = nf.JL5LocalDecl(null, emptyFlags, nf.CanonicalTypeNode(null, ts.Boolean()), f.name()+"_isOld", nf.BooleanLit(null, false));			
		    dC = dC.localInstance(ts.localInstance(null, dC.flags(), dC.declType(), dC.name()));
		    inits.add(dC);

		}
		int ctr = 0;
		List body = new TypedList(new LinkedList(), Stmt.class, false);
		for (Stmt s : (List<Stmt>) methodDeclBody.statements())
		    body.add(s instanceof ESJLocalDecl ? (Stmt) toLogicExpr(s) : s);
		block = nf.Block(null, body);
	    } else {
		List<Formal> frms = (List<Formal>) methodDecl.formals();
		Formal aFormal = nf.JL5Formal(null, emptyFlags, this.LogProblemTN, "fallback_problem");
		formals.add(aFormal.localInstance(ts.localInstance(null, aFormal.flags(), aFormal.declType(), aFormal.name())));
		int idx = 4;
// 		if (methodDecl.flags().isStatic()) {
// 		    idx = 0;
// 		} else {
		    formals.add(frms.get(0).type(this.LogExprTN));
		    formals.add(frms.get(1));
		    formals.add(frms.get(2));
		    formals.add(frms.get(3).type(nf.CanonicalTypeNode(null, ts.Boolean())));
// 		}
		for (int i = idx; i < frms.size(); i++) { 
		    Formal f = frms.get(i);		   
		    if (i % 2 == 0) {
			TypeNode fTN = f.type();			
			Type fTp = fTN.type();  
			formals.add(f.type(getLogType(fTp))); 
		    } else
			formals.add(f);
		}
		for (Stmt s : (List<Stmt>) methodDeclBody.statements()) {
		    Expr e;
		    if (s instanceof Return)
			e = ((Return) s).expr();
		    else if (s instanceof LocalDecl)
			e = ((LocalDecl) s).init();
		    else
			continue; //FIXME?
		    List both = getQuantVarDs(e); //FIXME	
		    List quantVarD = (List) both.get(0); 
		    List quantExprs = (List) both.get(1); 
		    for (LocalDecl l : (List<LocalDecl>) quantVarD) {
			TypeNode logVarTN;
			TypeNode tn = l.type();
			quantVars.add(l.name());
			List args2 = new TypedList(new LinkedList(), Receiver.class, false);
			List args3 = new TypedList(new LinkedList(), Receiver.class, false);
			args3.add(nf.StringLit(null, l.name()));
			Expr kVExp = newLogExpr(nf.Call(null, this.varTN, "unary", args3));
			LocalDecl dC = nf.JL5LocalDecl(null, emptyFlags, nf.CanonicalTypeNode(null, ts.Boolean()), l.name()+"_isOld", nf.BooleanLit(null, false));			
			dC = dC.localInstance(ts.localInstance(null, dC.flags(), dC.declType(), dC.name()));
			inits.add(dC);
			if (tn.type().isInt()) {
			    String vN = "fallback_var_" + l.name();
			    String qVN = "quantVar_" + l.name();
			    LocalDecl dA = nf.JL5LocalDecl(null, emptyFlags, this.LogExprTN, qVN, kVExp);
			    LocalDecl dB = nf.JL5LocalDecl(null, emptyFlags, this.LogExprTN, l.name(), newLogExpr(
														  nf.Call(null, 
														  nf.Local(null, qVN), 
															  "expr", emptyArgs)
														  ));

			    dA = dA.localInstance(ts.localInstance(null, dA.flags(), dA.declType(), dA.name()));
			    dB = dB.localInstance(ts.localInstance(null, dB.flags(), dB.declType(), dB.name()));

			    inits.add(dA);
			    inits.add(dB);
			    logVarTN = this.pbjIntTN;
			    kVExp = nf.Local(null, qVN);
			    args2.add(kVExp);
			    l = l.name(vN);
			} else {
			    //HACK FIXME: if quantified var type is Object, change type to the cast type
			    //            that should be found inside the quantified clause...
			    logVarTN = tn;
			    if (tn.type() == ts.Object()) { 
				TypeNode tnc = ((ESJLogQuantifyExpr) quantExprs.get(0)).getCastType();
				if (tnc != null)
				    logVarTN = tnc;
			    }
			}
			inits.add(l.type(this.LogExprTN).init(kVExp));
		    }
		}
		block = (Block) toLogicExpr(methodDeclBody);
	    }
		    
	    //HACK FIXME:
	    inits.addAll(block.statements());
	    List args = new TypedList(new LinkedList(), Receiver.class, false);
	    args.add(nf.StringLit(null, ""));
	    FlagAnnotations fl = makeFlagAnnotations(); 
	    fl.classicFlags(Flags.NONE);
	    fl.annotations(new TypedList(new LinkedList(), AnnotationElem.class, false));
	    if (!methodDecl.isFallback()) {
		TypeNode retTp = methodDecl.returnType(); 
		String retTpN = retTp.toString();
		Type retTpT = retTp.type();
		TypeNode tpNf = getLogType(retTpT);
		methodDecl = (ESJLogPredMethodDecl) methodDecl.returnType(tpNf).flags(methodDecl.flags().Static());
	    }
	    return methodDecl.formals(formals).body(nf.Block(null,inits));
	    				    
	} else if (r instanceof Block) {
	    List body = new TypedList(new LinkedList(), Stmt.class, false);
	    for (Stmt s : (List<Stmt>) ((Block) r).statements()) {
		Stmt sl = (Stmt) toLogicExpr(s); 
		body.add(sl);
		if (s instanceof LocalDecl) {
		    LocalDecl l = (LocalDecl) s;
		    LocalDecl dC = nf.JL5LocalDecl(null, emptyFlags, nf.CanonicalTypeNode(null, ts.Boolean()), l.name()+"_isOld" , nf.BooleanLit(null, false));			
		    dC = dC.localInstance(ts.localInstance(null, dC.flags(), dC.declType(), dC.name()));
		    body.add(dC);
		}
	    }

	    return nf.Block(null, body);
	} else if (r instanceof FormulaBinary) {
	    FormulaBinary b = (FormulaBinary) r;
	    List args = new TypedList(new LinkedList(), Receiver.class, false);
	    args.add((Receiver) toLogicExpr(b.right()));
	    return nf.Call(null,(Receiver) toLogicExpr(b.left()), ToKodkodOp.get(b.operator()), args);

	} else if (r instanceof CmpBinary) {
	    CmpBinary b = (CmpBinary) r;
	    CmpBinary.Operator bop = b.operator();
	    String op = ToKodkodOp.get(bop);
	    Expr lf = b.left();
	    Expr rt = b.right();
	    Type lft = lf.type();
	    Type rtt = rt.type();	    
	    Receiver lfLog = (Receiver) toLogicExpr(b.left());
	    Receiver rtLog = (Receiver) toLogicExpr(b.right());	  
	    boolean eq = bop.equals(Binary.EQ);
	    boolean neq = bop.equals(Binary.NE);
	    List empty = new TypedList(new LinkedList(), Receiver.class, false);
	    List args = new TypedList(new LinkedList(), Receiver.class, false);
	    boolean noMod = true;
	    Receiver rcv = lfLog;
	    // in kodkod cannot do array =/!= null because of arity mismatch. fix:
	    if (neq || eq) {
		if (lft.isArray() && rtt.isNull())
		    noMod = false;
		else if (rtt.isArray() && lft.isNull()) {
		    noMod = false;
		    rcv = rtLog;
		}
		    
	    }
	    if (noMod)
		args.add(rtLog);
	    else 
		op = "no";
	    Call c = nf.Call(null, rcv, op, args);
	    return neq ? nf.Call(null, c, "not", empty) : c;
	} else if (r instanceof ESJBinary) {
	    ESJBinary b = (ESJBinary) r;
	    List args = new TypedList(new LinkedList(), Receiver.class, false);
	    Expr lf = b.left();
	    Expr rt = b.right();
	    Receiver lfLog = (Receiver) toLogicExpr(b.left());
	    Receiver rtLog = (Receiver) toLogicExpr(b.right());
	    args.add(rtLog);
	    return nf.Call(null, lfLog, ToKodkodOp.get(b.operator()), args);
	} else if (r instanceof Binary) {
	    Binary b = (Binary) r;
	    
	    return (Receiver) toLogicExpr(nf.ESJBinary(null,b.left(), b.operator(), b.right(), ToKodkodOp.get(b.operator())));
	} else if (r instanceof Unary) {
	    Unary u = (Unary) r;
	    List args = new TypedList(new LinkedList(), Receiver.class, false);
	    return nf.Call(null,(Receiver) toLogicExpr(u.expr()), ToKodkodOp.get(u.operator()), args);
	} else if (r instanceof JL5Conditional) {
	    JL5Conditional c = (JL5Conditional) r;
	    if (c.alternative() instanceof ESJFieldClosureCall) // FIXME ?
		return (Receiver) toLogicExpr(c.alternative());
	    List args = new TypedList(new LinkedList(), Expr.class, false);
	    Expr con = (Expr) toLogicExpr(c.consequent());
	    Expr alt = (Expr) toLogicExpr(c.alternative());
	    Expr cond = (Expr) toLogicExpr(c.cond());
	    if (c.consequent().type().isBoolean()) {
		List args1 = new TypedList(new LinkedList(), Expr.class, false);
		List args2 = new TypedList(new LinkedList(), Expr.class, false);
		args.add(con);
		args2.add(alt);
		args1.add(nf.Call(null, nf.Call(null, cond, "not", emptyArgs), "and", args2));
		return nf.Call(null, nf.Call(null, cond, "and", args), "or", args1);
	    } else {
		args.add(con);
		args.add(alt);
		return nf.Call(null, cond, "thenElse", args);
	    }
	} else if (r instanceof ESJLogQuantifyExpr) { 
	    ESJLogQuantifyExpr q = (ESJLogQuantifyExpr) r;
	    boolean quantKindIsaCount = q.quantKind() == FormulaBinary.ONE ||
		q.quantKind() == FormulaBinary.LONE;
	    boolean isComprehension = q.isComprehension();
	    boolean isSingleComprehension = q.isSingleComprehension();
	    List args = new TypedList(new LinkedList(), Receiver.class, false);
	    Type quantListTp = q.quantListExpr().type();
	    // FIXME
	    if (quantListTp == null)
		quantListTp = this.arrayListTp;
	    Expr quantListExpr = q.quantListExpr().type(quantListTp);
	    // FIXME
	    Receiver qListExpr = (quantListExpr instanceof Special) ? 
		nf.Call(null, null, "range_log", emptyArgs) : 
		(Receiver) toLogicExpr(quantListExpr);
	    // FIXME: how to know the representative set for the Iterable obj -> call its toPBJSet_log() method
		if (quantListTp instanceof ParameterizedType) { 
		List argsb = new TypedList(new LinkedList(), Receiver.class, false);
		argsb.add(nf.Local(null, "fallback_problem"));
		argsb.add(qListExpr);
		argsb.add(PBJAddExtraClassMembers.typeParametersAsString((ParameterizedType) quantListTp, nf));
		argsb.add(PBJAddExtraClassMembers.typeParametersAsStringArray((ParameterizedType) quantListTp, nf));
		argsb.add(nf.Local(null, "fallback_target_isOld"));
		qListExpr = nf.Call(null, nf.CanonicalTypeNode(null, ts.typeForName(((ParameterizedType) quantListTp).fullName())), "toPBJInternSet_log", argsb);
	    }
	    String opM;
	    Expr dExp;
	    args.add(qListExpr);
	    if (isComprehension) {
		opM = "setComprehensionOp";
	    } else {
		opM = "quantifyOp";
		args.add(nf.BooleanLit(null, quantKindIsaCount));
		args.add(nf.StringLit(null, q.quantKind().toString()));
	    }
	    args.add(nf.Local(null, (((LocalDecl) q.quantVarD().get(0)).declType().isInt() ? "fallback_var_" : "") + q.quantVarN()));
	    args.add((Receiver) toLogicExpr(q.quantClauseExpr()));
            Expr res = nf.Call(null, LogExprTN, opM, args);
	    //FIXME
	    List args0 = new TypedList(new LinkedList(), Expr.class, false);
	    args0.add(nf.Local(null, "fallback_problem"));
	    return isSingleComprehension ? nf.Call(null, res, "get_log", args0) : res; 
	} else if (r instanceof ESJQuantifyTypeExpr) {
	    List args = new TypedList(new LinkedList(), Receiver.class, false);
	    TypeNode tpp = ((ESJQuantifyTypeExpr) r).theListType();
	    Type tppTp = tpp.type();
	    Expr a0 = null;
	    if (tppTp instanceof TypeVariable) {
		List argstti = new TypedList(new LinkedList(), Expr.class, false);	    
		argstti.add(this.nf.ClassLit(null, currClassRawTN));
		argstti.add(nf.StringLit(null, ((TypeVariable)tppTp).name()));
		Expr tti = nf.Call(null, this.LogMapTN, "getTypeVariableIndex", argstti);
		a0 = nf.ArrayAccess(null, nf.Local(null, "fallback_targetTypeArgs"), tti);
	    } else
		a0 = nf.StringLit(null, tppTp.toString()); 
	    args.add(a0);
	    args.add(nf.BooleanLit(null, false));
	    return nf.Call(null, nf.Local(null, "fallback_problem"), "allInstances_log", args);

	} else if (r instanceof Return) {
	    Expr e = ((Return) r).expr();
	    // FIXME:
	    Expr e2 = e;
	    if (!((e instanceof JL5Cast) && ((JL5Cast) e).expr() instanceof JL5Cast && ((JL5Cast) e).expr() instanceof ESJResultField))
		e2 = (Expr) toLogicExpr(e);
	    return nf.JL5Return(null, e2);
	} else if (r instanceof ESJIf) {
	    ESJIf c = (ESJIf) r;
	    List args = new TypedList(new LinkedList(), Expr.class, false);
	    Stmt cCon = c.consequent();
	    Stmt cAlt = c.alternative();
	    Expr cond = (Expr) toLogicExpr(c.cond());
	    Expr con = cCon instanceof Block ? (Expr) toLogicExpr(c.exprConsequent()) : 
		cCon instanceof Return ? (Expr) toLogicExpr(((Return) cCon).expr()) : 
		((Return) toLogicExpr(cCon)).expr();
	    Expr alt = cAlt instanceof Block ? (Expr) toLogicExpr(c.exprAlternative()) : 
		cAlt instanceof Return ? (Expr) toLogicExpr(((Return) cAlt).expr()) : 
		((Return) toLogicExpr(cAlt)).expr();
	    if (c.isBoolean()) {
		List args1 = new TypedList(new LinkedList(), Expr.class, false);
		List args2 = new TypedList(new LinkedList(), Expr.class, false);
		args.add(con);
		args2.add(alt);
		args1.add(nf.Call(null, nf.Call(null, cond, "not", emptyArgs), "and", args2));
		return nf.JL5Return(null, nf.Call(null, nf.Call(null, cond, "and", args), "or", args1));
	    } else {
		args.add(con);
		args.add(alt);
		return nf.JL5Return(null, nf.Call(null, cond, "thenElse", args));
	    }
	} else if (r instanceof Eval) {
	    return r;
	} else if (r instanceof JL5Assert) {
	    return r;
	} else if (r instanceof ESJFieldClosure) {
	    ESJFieldClosure c = (ESJFieldClosure) r;
	    return fieldGetClosureGet_log(c);
	} else if (r instanceof Call) {	    
	    Call c = (Call) r;
	    List args = new TypedList(new LinkedList(), Receiver.class, false);
	    List args0 = null;
	    Receiver rc = c.target();
	    Type rct = rc.type();
	    Type rctb = rct;
	    String m = c.name() + "_log"; //FIXME
	    Receiver tLog = (Receiver) toLogicExpr(rc);
	    //HACK FIXME: check for set type
	    boolean isSetType = isPBJPrimitiveCollectionType(rct);
	    boolean isTypeVar = false;
	    if (rct instanceof TypeVariable) {
		isTypeVar = true;
		args0 = new TypedList(new LinkedList(), Receiver.class, false);
		//Local loc = nf.Local(null, "fallback_problem");
		args0.add(loc);
		args0.add(nf.ClassLit(null, currClassRawTN));
		args0.add(nf.StringLit(null, ((TypeVariable)rct).name()));
	    }
	    args.add(nf.Local(null, "fallback_problem"));
	    //HACK FIXME
	    if (!isSetType) {
		args.add(tLog);
		Expr a1, a2;
		//HACK FIXME
		if (rct == currClassTp || (rct instanceof ParameterizedType && ((ParameterizedType) rct).baseType() == currClassTp)) { 
		    a1 = nf.Local(null, "fallback_targetTypeArgsStr");
		    a2 = nf.Local(null, "fallback_targetTypeArgs");
		} else {
		    if (rct instanceof ParameterizedType) {
			a1 = PBJAddExtraClassMembers.typeParametersAsString((ParameterizedType) rct, nf);
			a2 = PBJAddExtraClassMembers.typeParametersAsStringArray((ParameterizedType) rct, nf);
		    } else {
			a1 = nf.StringLit(null, "");
			a2 = nf.NullLit(null);
		    }
		}
		args.add(a1);
		args.add(a2);
		args.add(hasOldTarget(c) ? nf.BooleanLit(null, true) : 
			 rc instanceof Local ? nf.Local(null, ((Local)rc).name() + "_isOld") : 
			 nf.Local(null, "fallback_target_isOld"));
	    }
	    if (rct instanceof ParameterizedType)
		rctb = ((ParameterizedType) rct).baseType();

	    if (r instanceof ESJCall) {
		for (Expr e : (List<Expr>) c.arguments()) {
		    Type et = e.type();
		    List argsC = new TypedList(new LinkedList(), Receiver.class, false);
		    argsC.add(e);
		    String mLog;
		    if (et.isNumeric()) {
			mLog = "intToSingletonRelation_log";
		    } else if (et.isBoolean()) {
			mLog = "booleanToSingletonRelation_log";
		    } else if (et.isArray()) {
			mLog = "arrayToRelation_log";
		    } else {
			mLog = "objToSingletonRelation_log";
		    }
		    args.add(nf.Call(null, nf.Local(null, "fallback_problem"), mLog, argsC));
		    args.add(hasOldTarget(e) ? nf.BooleanLit(null, true) : 
			     e instanceof Local ? nf.Local(null, ((Local) e).name() + "_isOld") :
			     nf.Local(null, "fallback_target_isOld"));
		}
	    } else {
		for (Expr e : (List<Expr>) c.arguments()) {
		    args.add((Receiver) toLogicExpr(e));
		    args.add(hasOldTarget(e) ? nf.BooleanLit(null, true) : 
			     e instanceof Local ? nf.Local(null, ((Local) e).name() + "_isOld") :
			     nf.Local(null, "fallback_target_isOld"));
		}
	    }
	    return nf.Call(null, (isSetType ? tLog : nf.CanonicalTypeNode(null, rctb)), m, args);
	} else if (r instanceof Field) {
	    Field f = (Field) r;
	    if (f.name().equals("old")) {
		return toLogicExpr(f.target());
            }
	    List args = new TypedList(new LinkedList(), Receiver.class, false);
	    args.add(nf.Local(null, "fallback_problem"));
	    Receiver t = (Receiver) toLogicExpr(f.target());
	    Receiver rc = f.target();
	    Type rct = rc.type();
	    Type rctb = rct;
	    boolean isSetType = rct instanceof JL5ArrayType;
	    if (rct instanceof ParameterizedType)
		rctb = ((ParameterizedType) rct).baseType();
	    if (!isSetType) {
		args.add(t);
		Expr a1, a2;
		if (rct == currClassTp || (rct instanceof ParameterizedType && ((ParameterizedType) rct).baseType() == currClassTp)) {
		    a1 = nf.Local(null, "fallback_targetTypeArgsStr");
		    a2 = nf.Local(null, "fallback_targetTypeArgs");
		} else {
		    a1 = (rct instanceof ParameterizedType) ? PBJAddExtraClassMembers.typeParametersAsString((ParameterizedType) rct, nf) : nf.StringLit(null, ""); 
		    if (rct instanceof ParameterizedType) {
			a1 = PBJAddExtraClassMembers.typeParametersAsString((ParameterizedType) rct, nf);
			a2 = PBJAddExtraClassMembers.typeParametersAsStringArray((ParameterizedType) rct, nf);
		    } else {
			a1 = nf.StringLit(null, "");
			a2 = nf.NullLit(null);
		    }

		}
		args.add(a1);
		args.add(a2);
		args.add(hasOldTarget(f) ? nf.BooleanLit(null, true) : 
			 rc instanceof Local ? nf.Local(null, ((Local) rc).name() + "_isOld") :
			 nf.Local(null, "fallback_target_isOld"));
	    }
	    String m = f.name() + (f instanceof ESJResultField ? ("_" + ((ESJResultField) f).method().fullName()) : "")  + "_get_log"; //FIXME
	    return nf.Call(null, isSetType ? t : nf.CanonicalTypeNode(null, rctb), m, args);
	} else if (r instanceof ArrayAccess) {
	    ArrayAccess a = (ArrayAccess) r;
	    Expr accIdx = a.index();
	    Receiver idxLog = accIdx instanceof Local ? accIdx : (Receiver) toLogicExpr(accIdx);
	    List args = new TypedList(new LinkedList(), Receiver.class, false);
	    args.add(nf.Local(null, "fallback_problem"));
	    args.add(idxLog);
	    args.add(nf.BooleanLit(null, false));
	    return nf.Call(null, (Receiver) toLogicExpr(a.array()), "get_log", args);
	} else if (r instanceof JL5LocalDecl) { // spec assignment
	    LocalDecl l = (LocalDecl) r;
	    List args = new TypedList(new LinkedList(), Receiver.class, false);
	    Expr initL = (Expr) toLogicExpr(l.init());
	    Expr probFormula;
	    probFormula = initL;
	    Type t = l.declType();
	    String tn = t.toString();
	    TypeNode tN = getLogType(t);
	    return l.type(tN).init(probFormula);
	} else if (r instanceof LocalDecl) {
	    return r;
	} else if (r instanceof Local) {
	    return r;
	}  else if (r instanceof Special) {
	    return nf.Local(null, "fallback_target");
	} else if (r instanceof IntLit) {
	    List args = new TypedList(new LinkedList(), Receiver.class, false);
	    args.add(r);
	    return newLogExpr(nf.Call(null, this.intConstTN, "constant", args));
	} else if (r instanceof CharLit) {
	    List args = new TypedList(new LinkedList(), Receiver.class, false);
	    args.add(nf.IntLit(null, IntLit.INT, ((CharLit) r).value() + 0));
	    return newLogExpr(nf.Call(null, this.intConstTN, "constant", args));
	}  else if (r instanceof StringLit) {
	    return r;
	} else if (r instanceof ClassLit) {
	    return r;
	} else if (r instanceof NullLit) {
	    List args = new TypedList(new LinkedList(), Receiver.class, false);
	    return nf.Call(null, nf.Local(null, "fallback_problem"), "null_log", args);
	} else if (r instanceof BooleanLit) {
	    return newLogExpr(nf.JL5Field(null, this.FormulaTN, ((BooleanLit) r).value() ? "TRUE" : "FALSE"));
	} else if (r instanceof ESJIntervalExpr) {
	    ESJIntervalExpr a = (ESJIntervalExpr) r;
	    List args = new TypedList(new LinkedList(), Expr.class, false);
	    args.add(a.lower());
	    args.add(a.upper());
	    return toLogicExpr(nf.Call(null, this.pbjIntTN, "range", args));
	} else if (r instanceof JL5Cast) {
	    JL5Cast c = (JL5Cast) r;
	    Expr e = c.expr();
	    Expr e2 = e;
	    return (Receiver) toLogicExpr(e2);
	} else if (r instanceof JL5Instanceof) {
	    JL5Instanceof i = (JL5Instanceof) r;
	    //Local loc = nf.Local(null, "fallback_problem");
	    List args1 = new TypedList(new LinkedList(), Receiver.class, false);
	    List args3 = new TypedList(new LinkedList(), Receiver.class, false);
	    args3.add(nf.StringLit(null, i.compareType().toString()));
	    args3.add(nf.BooleanLit(null, false));
	    args1.add(loc);
	    args1.add((Receiver) toLogicExpr(i.expr()));
	    args1.add(nf.BooleanLit(null, false));
	    return nf.Call(null, nf.Call(null, loc, "allInstances_log", args3), "contains_log", args1);
	} else if (r instanceof New) {
	    return r;
	} else if (r instanceof TypeNode) {
	    List args = new TypedList(new LinkedList(), Receiver.class, false);
	    args.add(nf.ClassLit(null, (TypeNode) r));
	    return nf.Call(null, nf.Local(null, "fallback_problem"), "class_log", args);
	}
	else {
	    throw new RuntimeException("Don't know how to convert " + r.getClass() + "(" + r + ")" +
				       " to a Logic expression.");
	}
    }

    // FIXME
    public Node fieldGetClosureGet_log(ESJFieldClosure f) throws SemanticException {
	List args = new TypedList(new LinkedList(), Expr.class, false);
	ESJFieldClosure fc = f;
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
	Expr res1 = nf.JL5New(null, nf.CanonicalTypeNode(null, fc.type()), emptyArgs, null, emptyTypeNodes);
	ESJFieldClosureCall res2 = (ESJFieldClosureCall) nf.ESJFieldClosureCall(null, r, m, args, fc.kind(), fc.isIntSet()).type(f.type());
	return fieldGetClosureGetH_log(res2);
    }

    public Node fieldGetClosureGetH_log(ESJFieldClosureCall c) throws SemanticException {
	List instVarGetArgs = new TypedList(new LinkedList(), Expr.class, false);
	instVarGetArgs.add(nf.Local(null, "fallback_problem"));
	List origArgs = c.arguments();
	Type clTp = c.target().type();
	TypeNode clTN = nf.CanonicalTypeNode(null,  clTp);
	Expr s0 = nf.StringLit(null, PBJAddExtraClassMembers.typeFullName(clTp));
	Expr s1 = nf.StringLit(null, "");
	if (c.isSetFieldsMap()) {
	    instVarGetArgs.add((Expr) toLogicExpr((Expr) origArgs.get(0)));
	    instVarGetArgs.add(s0);
	    instVarGetArgs.add(s1);
	    instVarGetArgs.add(nf.Local(null, "fallback_target_isOld"));
	    instVarGetArgs.add(nf.BooleanLit(null, false));
	    instVarGetArgs.add(nf.BooleanLit(null, false));
	    for (int i=1;i<origArgs.size();i++)
		instVarGetArgs.add((Expr) origArgs.get(i));
	} else if (c.isSimple()) {
	    instVarGetArgs.add((Expr) (toLogicExpr(c.target())));
	    instVarGetArgs.add(s0);
	    instVarGetArgs.add(s1);
	    instVarGetArgs.add(nf.Local(null, "fallback_target_isOld"));
	    instVarGetArgs.add(nf.BooleanLit(null, c.isSimple()));
	    instVarGetArgs.add(nf.BooleanLit(null, false));
	    instVarGetArgs.addAll(origArgs);
	} else {
	    instVarGetArgs.add((Expr) toLogicExpr((Expr) origArgs.get(0)));
	    instVarGetArgs.add(s0);
	    instVarGetArgs.add(s1);
	    instVarGetArgs.add(nf.Local(null, "fallback_target_isOld"));
	    instVarGetArgs.add(nf.BooleanLit(null, false));
	    for (int i=1;i<origArgs.size();i++)
		instVarGetArgs.add((Expr) origArgs.get(i));
	}
	return nf.Call(null, LogMapTN, "fieldGetClosure_log", instVarGetArgs);
    }
    
    public List getQuantVarDs(Expr e) {

	List both = new TypedList(new LinkedList(), List.class, false);
	List quantVarD = new TypedList(new LinkedList(), LocalDecl.class, false);
	List quantExprs = new TypedList(new LinkedList(), ESJLogQuantifyExpr.class, false);
	getQuantVarDsHelper(e, quantVarD, quantExprs);
	both.add(quantVarD);
	both.add(quantExprs);
	return both;
    }
    
    void getQuantVarDsHelper(Expr e, List quantVarD, List quantExprs) {
	if (e instanceof FormulaBinary) {
	    FormulaBinary b = (FormulaBinary) e;
	    getQuantVarDsHelper(b.left(), quantVarD, quantExprs);
	    getQuantVarDsHelper(b.right(), quantVarD, quantExprs);
	} else if (e instanceof Conditional) {
	    Conditional c = (Conditional) e;
	    getQuantVarDsHelper(c.consequent(), quantVarD, quantExprs);
	    getQuantVarDsHelper(c.alternative(), quantVarD, quantExprs);
	} else if (e instanceof ESJLogQuantifyExpr) {
	    ESJLogQuantifyExpr e2 = (ESJLogQuantifyExpr) e;
	    quantVarD.addAll(e2.quantVarD());
	    quantVarD.addAll(e2.quantVarD2());
	    quantExprs.add(e2);
	}
    }

    public boolean hasOldTarget(Node r)  {
	if (r instanceof Field) {
	    Field f = (Field) r;	    
	    return f.name().equals("old") || hasOldTarget(f.target());
	} else if (r instanceof Call) {
	    Call f = (Call) r;
	    return f.name().equals("old") || hasOldTarget(f.target());
	}
	return false;
    }

    public boolean isPBJPrimitiveCollectionType(Type rct) {
	String rctN = rct instanceof ParameterizedType ? 
	    ((ParameterizedType) rct).name() : shortTypeName(rct.toString());
	return rctN.equals("PBJInternSet");
    }

    private Expr newLogExpr(Expr e) {
	List args = new TypedList(new LinkedList(), Expr.class, false);
	args.add(loc);
	args.add(e);
	return nf.JL5New(null, LogExprTN, args, null, emptyTypeNodes);
    }

    // FIXME
    public TypeNode getLogType(Type t) {
	TypeNode res = this.LogExprTN;
	return res;
    }

    FlagAnnotations makeFlagAnnotations() {
	FlagAnnotations fl2 = new FlagAnnotations(); 
	fl2.classicFlags(Flags.NONE);
	fl2.annotations(new TypedList(new LinkedList(), AnnotationElem.class, false));
	return fl2;
    }	      

    public String shortTypeName(String longName) { 
	int pi = longName.lastIndexOf(46); // char '.'
	return pi == -1 ? longName : longName.substring(pi+1);
    }

}



