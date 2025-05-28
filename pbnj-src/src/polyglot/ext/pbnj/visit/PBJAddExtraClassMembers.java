package polyglot.ext.pbnj.visit;

import polyglot.ext.pbnj.tologic.*;
import polyglot.ext.pbnj.PBnJMain;

import polyglot.visit.*;
import polyglot.ast.*;
import polyglot.ext.jl.ast.*;
import polyglot.ext.jl5.ast.*;
import polyglot.ext.pbnj.ast.*;
import polyglot.types.*;
import polyglot.ext.pbnj.types.*;
import polyglot.ext.jl5.types.*;
import polyglot.util.*;
import polyglot.parse.VarDeclarator;

import kodkod.ast.Formula;
import kodkod.ast.Decl;
import kodkod.ast.Decls;
import kodkod.ast.Expression;
import kodkod.ast.Formula;
import kodkod.ast.IntConstant;
import kodkod.ast.IntExpression;

import polyglot.frontend.Job;

import java.util.*;

/** Visitor that translates PBJ AST nodes to Java AST nodes, for
    subsequent output. **/
public class PBJAddExtraClassMembers extends ContextVisitor {

	// String for mangling the name of each dispatchee method
    protected static String dispatcheeStr = "$body";

	// String for making the formal names of the dispatcher method
    public static String argStr = "arg$";
    
    protected ESJNodeFactory nf;
    protected JL5TypeSystem ts;

    //FIXME 
    // Globals:
    static ClassType currClassTp;
    static List classInits;
    static HashMap<String,Boolean> innerClassesInit = new HashMap<String,Boolean>();
    static List carryOverClassInits = new TypedList(new LinkedList(), Eval.class, false);
    static HashMap<Type,Boolean> genericTypeSpecFields = new HashMap<Type,Boolean>();
    static HashMap<TypeNode,Boolean> instantiatedGenericClasses = new HashMap<TypeNode,Boolean>(); 
    static HashMap<String,Boolean> pbjObjClassImpls = new HashMap<String,Boolean>(); 
    static List emptyArgs = new TypedList(new LinkedList(), Expr.class, false);
    static List emptyFormals = new TypedList(new LinkedList(), Formal.class, false);
    static List emptyTypeNodes = new TypedList(new LinkedList(), TypeNode.class, false);
    static List emptyLocalDecls = new TypedList(new LinkedList(), LocalDecl.class, false);    
    // l2: static defs passed down from any inner classes
    static List l2 = new TypedList(new LinkedList(), ClassMember.class, false); 
    static FlagAnnotations emptyFlags = new FlagAnnotations(); 
    static PBnJMain.MemoryModel SharedMemoryModel = PBnJMain.SharedMemoryModel;
    static int Model_level = SharedMemoryModel.level;
    static boolean Model_0 = Model_level == 0;
    static boolean Model_1 = Model_level == 1;
    static boolean Model_2 = Model_level == 2;
    static boolean Model_level1 = Model_level >= 1;
    static boolean Model_level2 = Model_level >= 2;

    static TypeNode VoidTN, BooleanTN, booleanTN, IntTN, intTN, ShortTN, shortTN, ByteTN, byteTN, CharTN, charTN, StringTN, StringArrayTN, ObjectTN, ClassTN, PBJObjTN, LogMapTN, LogRelTN, LogProblemTN, LogExprTN, IntExprTN, ExprTN, FormulaTN, SystemTN, ThreadTN, SetTN, CollectionTN, PBJInternIntTN, MethodTN, ConstructorTN;
    static Type ArrayListTP, PBJInternSetTP, FieldTP, IteratorTP;
    public PBJAddExtraClassMembers(Job job, TypeSystem ts, NodeFactory jlnf) {
	super(job, ts, jlnf);
	this.nf = (ESJNodeFactory) jlnf;
	this.ts = (JL5TypeSystem) ts;
	try {
	    this.VoidTN = nf.CanonicalTypeNode(null, ts.Void());
	    this.booleanTN = nf.CanonicalTypeNode(null, ts.Boolean());
	    this.charTN = nf.CanonicalTypeNode(null, ts.Char());
	    this.ObjectTN = nf.CanonicalTypeNode(null, ts.Object());
	    this.ClassTN = nf.CanonicalTypeNode(null, ts.Class());
	    this.SystemTN = this.nf.CanonicalTypeNode(null, ts.typeForName("java.lang.System"));
	    this.StringTN = this.nf.CanonicalTypeNode(null, ts.String());
	    this.StringArrayTN = nf.CanonicalTypeNode(null, ts.arrayOf(ts.String()));
	    this.ThreadTN = nf.CanonicalTypeNode(null, ts.typeForName("java.lang.Thread"));
	    this.intTN = nf.CanonicalTypeNode(null, ts.Int());
	    this.shortTN = nf.CanonicalTypeNode(null, ts.Short());
	    this.byteTN = nf.CanonicalTypeNode(null, ts.Byte());
	    this.IntTN = this.nf.CanonicalTypeNode(null, ts.typeForName("java.lang.Integer"));
	    this.BooleanTN = this.nf.CanonicalTypeNode(null, ts.typeForName("java.lang.Boolean"));
	    this.ShortTN = this.nf.CanonicalTypeNode(null, ts.typeForName("java.lang.Short"));
	    this.ByteTN = this.nf.CanonicalTypeNode(null, ts.typeForName("java.lang.Byte"));
	    this.CharTN = this.nf.CanonicalTypeNode(null, ts.typeForName("java.lang.Character"));
	    this.PBJObjTN = this.nf.CanonicalTypeNode(null, ts.typeForName("polyglot.ext.pbnj.primitives.PBJInternObject"));
	    this.LogMapTN = this.nf.CanonicalTypeNode(null, ts.typeForName("polyglot.ext.pbnj.tologic.LogMap"));
	    this.LogRelTN = this.nf.CanonicalTypeNode(null, ts.typeForName("polyglot.ext.pbnj.tologic.LogRelation"));
	    this.LogProblemTN = this.nf.CanonicalTypeNode(null, ts.typeForName("polyglot.ext.pbnj.tologic.LogProblem"));
	    this.LogExprTN = this.nf.CanonicalTypeNode(null, ts.typeForName("polyglot.ext.pbnj.tologic.LogExpr"));
	    this.IntExprTN = nf.CanonicalTypeNode(null, ts.typeForName("kodkod.ast.IntExpression"));
	    this.ExprTN = nf.CanonicalTypeNode(null, ts.typeForName("kodkod.ast.Expression"));
	    this.FormulaTN = nf.CanonicalTypeNode(null, ts.typeForName("kodkod.ast.Formula"));
	    this.SetTN = nf.CanonicalTypeNode(null, ts.typeForName("java.util.Set"));
	    this.CollectionTN = nf.CanonicalTypeNode(null, ts.typeForName("java.util.Collection"));
	    this.MethodTN = nf.CanonicalTypeNode(null, ts.typeForName("java.lang.reflect.Method"));
	    this.ConstructorTN = nf.CanonicalTypeNode(null, ts.typeForName("java.lang.reflect.Constructor"));
	    this.PBJInternIntTN = nf.CanonicalTypeNode(null, ts.typeForName("polyglot.ext.pbnj.primitives.PBJInternInteger"));
	    this.ArrayListTP = ts.typeForName("java.util.ArrayList");
	    this.PBJInternSetTP = ts.typeForName("polyglot.ext.pbnj.primitives.PBJInternSet");
	    this.FieldTP = ts.typeForName("java.lang.reflect.Field");
	    this.IteratorTP = ts.typeForName("java.util.Iterator");

	} catch (Exception e) {
	    e.printStackTrace();
	    System.exit(1);
	}
	emptyFlags.classicFlags(Flags.NONE);
	emptyFlags.annotations(new TypedList(new LinkedList(), AnnotationElem.class, false));
    }

    /*
    protected NodeVisitor enterCall(Node parent, Node n) throws SemanticException {
	return super.enterCall(parent,n);
    }
    */

    protected Node leaveCall(Node n) throws SemanticException {
	//System.out.println("leave: " + n.getClass() + " " + n);

	if (n instanceof ESJEnsuredClassDecl)    	    
	    return super.leaveCall(addMembersForClassDecl((ESJEnsuredClassDecl)n));
	else if (n instanceof JL5ClassDecl) {
	    JL5ClassDecl classDecl = (JL5ClassDecl) n;
	    Flags f = classDecl.flags();
	    if (JL5Flags.isEnumModifier(f))
		return super.leaveCall(addMembersForEnumDecl(classDecl));
// 	    else if (f.isInterface())
// 		return super.leaveCall(addMembersForInterfaceDecl(classDecl));
	} else if (n instanceof ESJParameterizedNew) {
	    JL5New np = (JL5New) n;
	    TypeNode tn = np.objectType();
	    Type tp = tn.type();
	    if (tp instanceof ParameterizedType) {		
		ParameterizedType tpp = (ParameterizedType) tp;
		Type t = tpp.typeArguments().get(0);
		if (!(t instanceof TypeVariable || t == ts.Object())
		    && !instantiatedGenericClasses.containsKey(tn)
		    ) { 
		    instantiatedGenericClasses.put(tn, false);
		}
	    }
	    return super.leaveCall(n);
	    } 
	return super.leaveCall(n);
    }

    public ESJEnsuredClassDecl addMembersForClassDecl(ESJEnsuredClassDecl classDecl) throws SemanticException {

	currClassTp = classDecl.type();
	boolean isOuter = currClassTp.outer() == null;
	
	List l = new TypedList(new LinkedList(), ClassMember.class, false); //non-static
	List l1 = new TypedList(new LinkedList(), ClassMember.class, false); //static
	l.addAll(classDecl.body().members());

	FlagAnnotations fl = makePublicFlagAnnotations();
	FlagAnnotations fl1 = makePublicFlagAnnotationsPlus(Flags.STATIC);
	FlagAnnotations fl2 = makePublicFlagAnnotationsPlus(Flags.SYNCHRONIZED);
	TypeNode currClassRawTN = nf.CanonicalTypeNode(null, currClassTp);
	TypeNode currClassTN = getGenericTypeNode(currClassTp);       
	String currClassRawName = currClassTp.fullName();
	ReferenceType currClassSuperTp = (ReferenceType) currClassTp.superType();
	boolean hasSuperType = currClassSuperTp != ts.Object();
	boolean isPbjClassSubtype = implementsPBJInternObject(currClassSuperTp);
	boolean isPrimitiveClass = classDecl.isPrimitive();
	List all = findMembersOfInterest(classDecl);
	List specFields = (List) all.get(0);
	List specRefFields = (List) all.get(1);
	List ensuredMtds = (List) all.get(2);
	List specMtds = (List) all.get(3);
	HashMap specMtdsMap = (HashMap) all.get(4);
	List specRefMutexes = (List) all.get(5);
	List finFieldsWithoutInit = (List) all.get(6);
	List assumeStmts = (List) all.get(7);

	// add implements PBJInternObject 
	List f = classDecl.interfaces();       	
	f.add(PBJObjTN);	
	// init class static initializer
	initClassInits(currClassRawTN, isOuter);
	// define a dummy constructor only for fallback instantiating new objs
	addPBJConstructor(fl, l, classDecl, finFieldsWithoutInit, hasSuperType, isPbjClassSubtype);
	// define resultArray field
	addResultArrayField(fl , l);
	// define verifyInvariants()
	if (isOuter) {
	    addVerifInvariantsMtd(fl, l, classDecl, specMtds, true);
	}
	addAddInstanceMtd(fl, l, classDecl, currClassRawTN, currClassRawName, isPbjClassSubtype);
	// define startMethodTime field
	addStartMethodTimeField(fl, l);
	// define an old field, isOld()
	addOldFieldAndMtds(fl, l, currClassRawTN);	
	// define isCloned(), isAtomized(), and isRelationized()
	addIsRelationizedAndClonedMtds(fl, fl1, l, currClassRawTN, isOuter);
	// define initEnsuredMethod()
	addInitEnsuredMtd(fl, l, currClassTN);
	// define fallback_updateField()	
	addFallbackUpdMtd(fl, l);
	// define fallback_newInstance()
	addFallbackNewInstMtd(fl, l);
	// add intern methods for each assume stmt in any method body
	addInternMtdsForAssumeStmts(fl, l, classDecl, assumeStmts, ensuredMtds);
	// add <mtd>_planb() mtds for ensured methods
	addFallbackMtdForEnsuredMtds(fl, fl2, l, classDecl, currClassTN, currClassRawName, ensuredMtds, specFields, specRefMutexes, specMtds, specMtdsMap);
	// define relationize(), relationizeOld(), clone(), and commit()
	addRelationizeCloneCommitMtds(fl, fl1, fl2, l, classDecl, currClassTN, currClassRawTN, currClassRawName, isOuter, specFields, isPbjClassSubtype, isPrimitiveClass);	
	// define various per field methods (see inside mtd below)
	addFieldSpecificMtds(fl, fl1, fl2, l, l1, currClassRawTN, currClassRawName, specFields);
	// init class static initializer: generic specific	
	initClassInitsGenerics(currClassRawTN, isOuter);

	// add class inits (field relation defs)
	addFieldRelationDefs(classDecl, fl1, l1, isOuter);
	// add extra mtds for each spec method (including its logic translation <mtd>_log())
	addExtraMtdsForSpecMtds(l, l1, classDecl, specMtds);

	// if its inner class, send its static methods to its outer
	List lAll = l;
	if (isOuter) {
	    lAll.addAll(l2);
	    lAll.addAll(l1);
	    l2 = new TypedList(new LinkedList(), ClassMember.class, false);
	} else
	    l2.addAll(l1);

	return (ESJEnsuredClassDecl) classDecl.body(nf.JL5ClassBody(null, lAll)).interfaces(f);
    }

    public JL5ClassDecl addMembersForEnumDecl(JL5ClassDecl classDecl) throws SemanticException {

	currClassTp = classDecl.type();
	TypeNode currClassTN = nf.CanonicalTypeNode(null, currClassTp);
	FlagAnnotations fl1 = makePublicFlagAnnotationsPlus(Flags.STATIC);
	ClassBody b = classDecl.body();
	List enumCs = ((JL5ParsedClassType) classDecl.type()).enumConstants();
	Local loc = nf.Local(null, "fallback_problem");
	List frms = new TypedList(new LinkedList(), Formal.class, false);
	Formal aFormal = nf.JL5Formal(null, emptyFlags, this.LogProblemTN, "fallback_problem");
	frms.add(aFormal);
	aFormal = nf.JL5Formal(null, emptyFlags, this.LogExprTN, "fallback_target");
	frms.add(aFormal);
	aFormal = nf.JL5Formal(null, emptyFlags, this.StringTN, "fallback_targetTypeArgsStr");
	frms.add(aFormal);
	aFormal = nf.JL5Formal(null, emptyFlags, this.StringArrayTN, "fallback_targetTypeArgs");
	frms.add(aFormal);
	aFormal = nf.JL5Formal(null, emptyFlags, this.booleanTN, "isOld");
	frms.add(aFormal);
	for (EnumInstance e0 : (List<EnumInstance>) enumCs) {
	    String n = e0.name();
	    List argsA = new TypedList(new LinkedList(), Expr.class, false);
	    Field f0 = nf.Field(null, currClassTN, n); 		
	    argsA.add(f0.fieldInstance(ts.fieldInstance(null, (ReferenceType) f0.type(), fl1.classicFlags(), currClassTp, f0.name())));
	    b = b.addMember(JL5MethodDeclHelper(null, fl1, this.LogExprTN, n + "_get_log", frms, emptyTypeNodes, this.nf.Block(null, nf.JL5Return(null, nf.Call(null, loc, "objToSingletonRelation_log", argsA)))));
	}
	return (JL5ClassDecl) classDecl.body(b);
    }

    public JL5ClassDecl addMembersForInterfaceDecl(JL5ClassDecl classDecl) throws SemanticException {
	currClassTp = classDecl.type();	
	TypeNode currClassTN = getGenericTypeNode(currClassTp);
	FlagAnnotations fl = makePublicFlagAnnotationsPlus(Flags.ABSTRACT);

	// add implements PBJInternObject 
	List f = classDecl.interfaces();
	f.add(PBJObjTN);	
	// define fallback_clone()
	List bl = new TypedList(new LinkedList(), ClassMember.class, false); 
	bl.addAll(classDecl.body().members());
	List frms = new TypedList(new LinkedList(), Formal.class, false);
	bl.add(JL5MethodDeclHelper(null, fl, currClassTN, "fallback_clone", emptyFormals, emptyTypeNodes, null));
	addVerifInvariantsMtd(fl, bl, classDecl, null, false);
	bl.add(JL5MethodDeclHelper(null, fl, currClassTN, "fallback_checkInvariants_log", frms, emptyTypeNodes, null));
	return (JL5ClassDecl) classDecl.body(nf.JL5ClassBody(null, bl)).interfaces(f);
    }

    public void addFallbackMtdForEnsuredMtds(FlagAnnotations fl, FlagAnnotations fl2, List l, JL5ClassDecl classDecl, TypeNode currClassTN, String currClassRawName, List ensuredMtds, List specFields, List specRefMutexes, List specMtds, HashMap specMtdsMap) throws SemanticException {

	for (ESJEnsuredMethodDecl methodDecl : (List<ESJEnsuredMethodDecl>) ensuredMtds) {
	    String methodName = methodDecl.fullName();
	    // augment ensures clause to check class invariants
	    boolean hasPBJArgs = addInvariantCheckToEnsuresClause(specMtds, fl, l, methodDecl, methodName);
	    // define <ensured mtd>_planb()
	    definePrePostCondCheckForEnsuredMtd(specMtds, fl, l, methodDecl, methodName);
	    defineCheckCommitForEnsuredMtd(specRefMutexes, fl, l, methodDecl, methodName, currClassTN);
	    l.add(definePlanBMtdForEnsuredMtd(methodDecl, methodName, currClassTN, currClassRawName));
	    l.add(defineWrapperForEnsuredMtd(methodDecl, methodName));
	    l.add(defineEnsuredWrapperForEnsuredMtd(specRefMutexes, methodDecl, methodName, currClassTN));
	    defineVerifInvariantsForArgsAndFieldsMtdForEnsuredMtd(fl, l, methodDecl, methodName, specMtds, specMtdsMap);
	    TypeNode retTp = methodDecl.returnType();
	    if (!retTp.type().isVoid()) {
		ESJFieldDecl d = nf.ESJFieldDecl(null, emptyFlags, retTp, "fallback_field_result_" + methodName, null, true, methodDecl.isFreshResult());
		specFields.add(d);
		l.add(d);
	    }
	}
    }

    public void definePrePostCondCheckForEnsuredMtd(List specMtds, FlagAnnotations fl,  List l, ESJEnsuredMethodDecl methodDecl, String methodName) throws SemanticException {
    	List extraMtdBody = new TypedList(new LinkedList(), Stmt.class, false);
	Expr postCond = methodDecl.ensuresExpr();
	extraMtdBody.add(nf.Return(null, postCond));
	List<Formal> frms = methodDecl.formals();
	JL5MethodDecl m = JL5MethodDeclHelper(null, fl, this.booleanTN, methodName + "_checkContract", frms, emptyTypeNodes, nf.Block(null, extraMtdBody));
	specMtds.add(m);
	l.add(m);
	Expr preCond = methodDecl.requiresExpr();
	if (preCond != null) { 
	    List extraMtdBody1 = new TypedList(new LinkedList(), Stmt.class, false);
	    extraMtdBody1.add(nf.Return(null, preCond));
	    JL5MethodDecl m1 = JL5MethodDeclHelper(null, fl, this.booleanTN, methodName + "_checkPrecondition", frms, emptyTypeNodes, nf.Block(null, extraMtdBody1));
	    l.add(m1);
	    
	}	
    }

    public void defineCheckCommitForEnsuredMtd(List specRefMutexes, FlagAnnotations fl2, List l, ESJEnsuredMethodDecl methodDecl, String methodName, TypeNode currClassTN) throws SemanticException {
	String m1 = methodName + "_assertContract";
	String m2 = methodName + "_commitModel";
	List argsCC = new TypedList(new LinkedList(), Expr.class, false);
	List newFrms = new TypedList(new LinkedList(), Formal.class, false);
	for (Formal f : (List<Formal>) methodDecl.formals()) {
	    newFrms.add(f);
	    argsCC.add(nf.Local(null, f.name()));
	}
	Expr constLock = nf.Local(null, "fallback_consistencyLock");
	List commitBody = new TypedList(new LinkedList(), Stmt.class, false);
	Expr assertExpr = nf.Call(null, null, methodName + "_checkContract", argsCC);
	Stmt assrt = nf.JL5Assert(null, assertExpr, null);
	List commitBody2 = new TypedList(new LinkedList(), Stmt.class, false);
	List args0 = new TypedList(new LinkedList(), Expr.class, false);
	args0.add(nf.This(null));
	Local loc = nf.Local(null, "fallback_problem");
	Stmt commitStmt = nf.Eval(null, nf.Call(null, loc, "commitModel", args0));
	commitBody2.add(commitStmt);
	Stmt commitToOld0 = nf.Eval(null, nf.Call(null, null, "fallback_commit", emptyArgs));
	Stmt commitToOld1 = commitToOld0;
	Stmt commitToOld2 = commitToOld0;
	commitBody.add(assrt);
	JL5Formal lf = nf.JL5Formal(null, emptyFlags, this.LogProblemTN, "fallback_problem");	
	Block b1 = nf.Block(null, commitBody);
	Block b2 = nf.Block(null, commitBody2);
	if (methodDecl.requiresExpr() != null) {
	    String m3 = methodName + "_assertPrecondition";
	    List commitBody3 = new TypedList(new LinkedList(), Stmt.class, false);
	    Expr assertExpr3 = nf.Call(null, null, methodName + "_checkPrecondition", argsCC);
	    Stmt assrt3 = nf.JL5Assert(null, assertExpr3, null);
	    commitBody3.add(assrt3);
	    Block b3 = nf.Block(null, commitBody3);
	    l.add(JL5MethodDeclHelper(null, fl2, this.VoidTN, m3, newFrms, emptyTypeNodes, b3));
	}
	l.add(JL5MethodDeclHelper(null, fl2, this.VoidTN, m1, newFrms, emptyTypeNodes, b1));
	newFrms.add(lf.localInstance(ts.localInstance(null, lf.flags(), lf.declType(), lf.name())));
	l.add(JL5MethodDeclHelper(null, fl2, this.VoidTN, m2, newFrms, emptyTypeNodes, b2));
    }

    //define verify invariants for args
    // go through ensures clause, find out what fields are involved, then conjugate 
    // the final formula with the verifyInvariants() for each 
    public void defineVerifInvariantsForArgsAndFieldsMtdForEnsuredMtd(FlagAnnotations fl,  List l, ESJEnsuredMethodDecl methodDecl, String methodName, List specMtds, HashMap specMtdsMap) throws SemanticException {
	Expr probFormula = methodDecl.ensuresExpr();
	List extraMtdBody = new TypedList(new LinkedList(), Stmt.class, false);
	Collection involvedFields = getInvolvedFields(probFormula, specMtdsMap);
	Expr fieldInvs = nf.BooleanLit(null, true);
	for (Field f : (Collection<Field>) involvedFields) {
	    fieldInvs = nf.FormulaBinary(null, fieldInvs, Binary.COND_AND, nf.FormulaBinary(null, nf.ESJBinary(null, f, Binary.EQ, nf.NullLit(null)), Binary.COND_OR, nf.Call(null, f, "fallback_checkInvariants", emptyArgs).type(ts.Boolean()), "and"), "or");
	}
	fieldInvs = fieldInvs.type(ts.Boolean());
	extraMtdBody.add(nf.Return(null, fieldInvs));
	JL5MethodDecl res = JL5MethodDeclHelper(null, fl, this.booleanTN, methodName + "_checkFieldsInvariants", emptyArgs, emptyTypeNodes, nf.Block(null, extraMtdBody));
	specMtds.add(res);
	specMtdsMap.put(res.name(), res);
	l.add(res);
    }
    
    public boolean addInvariantCheckToEnsuresClause(List specMtds, FlagAnnotations fl, List l, ESJEnsuredMethodDecl methodDecl, String methodName) throws SemanticException {
	boolean hasPBJArgs = false;
	Expr probFormula = methodDecl.ensuresExpr();
	Expr theThis = nf.This(null);
	theThis = theThis.type(currClassTp);
	Expr call1 = nf.Call(null, theThis, "fallback_checkInvariants", emptyArgs).type(ts.Boolean());
	Expr call2 = nf.Call(null, theThis, methodName + "_checkFieldsInvariants", emptyArgs).type(ts.Boolean());
	// args should keep invariants valid...
	List modFs = methodDecl.modifiableFields();
	if (modFs == null || modFs.size() > 0) {
	    List stmts1 = new TypedList(new LinkedList(), Stmt.class, false);
	    List frms = methodDecl.formals();
	    for (Formal f : (List<Formal>) frms) {
		Type ft = f.declType();
		if (ft.isReference() && !isPrimitive(ft) && !ft.isArray() && !isEnum(ft)
		    && !(ft instanceof TypeVariable) && implementsPBJInternObject((ReferenceType) ft)) {
		    Expr loc = nf.Local(null, f.name()).type(ft);
		    call2 = nf.FormulaBinary(null, call2, Binary.COND_AND, nf.Call(null, loc, "fallback_checkInvariants", emptyArgs).type(ts.Boolean()), "and");
		}
	    }
	}
	Expr call = nf.FormulaBinary(null, call1, Binary.COND_AND, call2, "and");

	// also add result.fallback_checkInvariants() if its 'pure fresh' return value
	TypeNode retTN = methodDecl.returnType();
	Type retTp = retTN.type();
	if (!retTp.isBoolean()) { 
	    if (!(retTp.isPrimitive() || retTp.isInt() || retTp.isArray() ||
		  retTp instanceof TypeVariable || !implementsPBJInternObject((ReferenceType)retTp))) {
		Expr res = nf.ESJResultField(null, theThis, "fallback_field_result", methodDecl);
		res = res.type(ts.Object());
		Expr castExp = nf.JL5Cast(null, retTN, res);
		castExp = castExp.type(retTp);
		Expr call3 = nf.FormulaBinary(null, nf.ESJBinary(null, res, Binary.EQ, nf.NullLit(null)), Binary.COND_OR, nf.Call(null, castExp, "fallback_checkInvariants", emptyArgs).type(ts.Boolean()), "or");
		call = nf.FormulaBinary(null, call, Binary.COND_AND, call3, "and");
	    }
	}
	if (probFormula != null)
	    call = nf.FormulaBinary(null, call, Binary.COND_AND, probFormula, "and");
	call = call.type(ts.Boolean());
	methodDecl.ensuresExpr(call); 
	return hasPBJArgs;
    }

    public JL5MethodDecl defineWrapperForEnsuredMtd(ESJEnsuredMethodDecl methodDecl, String methodName) throws SemanticException {
	List l = new TypedList(new LinkedList(), Stmt.class, false);
	List args = new TypedList(new LinkedList(), Expr.class, false);
	List frms = methodDecl.formals();
	for (Formal f : (List<Formal>) frms)
	    args.add(nf.Local(null, f.name()));
	Expr call = nf.Call(null, null, methodName + "_ensured", args);
	TypeNode retTN = methodDecl.returnType();
	l.add(retTN.type().isVoid() ? nf.Eval(null, call) : nf.Return(null, call));
	FlagAnnotations fl = copyJL5MethodDeclFlagAnnotations((JL5MethodDecl_c) methodDecl, false);
	return JL5MethodDeclHelper(null, fl, retTN, methodDecl.name(), methodDecl.formals(), methodDecl.throwTypes(), nf.Block(null, l));	
    }

    public JL5MethodDecl defineEnsuredWrapperForEnsuredMtd(List specRefMutexes, ESJEnsuredMethodDecl methodDecl, String methodName, TypeNode currClassTN) throws SemanticException {
	Type retTp = methodDecl.returnType().type();
	boolean isVoid = retTp.isVoid();
	boolean isArrayRetTp = retTp.isArray();
	TypeNode enclosingClassTN = nf.CanonicalTypeNode(null, methodDecl.methodInstance().container());
	List args = new TypedList(new LinkedList(), Expr.class, false);
	List args3 = new TypedList(new LinkedList(), Expr.class, false);
	List extraMtdBody = new TypedList(new LinkedList(), Stmt.class, false);
	List<Formal> frms = (List<Formal>) methodDecl.formals();
	List<Formal> newFrms = new TypedList(new LinkedList(), Formal.class, false);
	Expr constLock = nf.Local(null, "fallback_consistencyLock");
	for (Formal f : frms) {
	    String fName = f.name();
	    newFrms.add(f);
	    Local l0 = nf.Local(null, fName); 
	    args.add(l0);
	    args3.add(l0);	
	}
	Expr origMtdCall = nf.Call(null, null, methodName + "_orig", args);
	Stmt check = nf.Eval(null, nf.Call(null, null, methodName + "_assertContract", args));
	List stms = methodDecl.body().statements();
	Expr resFld = null;
	if (isVoid) {
	    extraMtdBody.add(nf.Eval(null, origMtdCall));
	    extraMtdBody.add(check);
	} else {
	    resFld = nf.JL5Field(null, nf.This(null), isArrayRetTp ? "fallback_field_resultArray" : "fallback_field_result");
	    int j = stms.size() - 1;
	    extraMtdBody.add(nf.Eval(null, nf.Assign(null, nf.Local(null, "fallback_result"), Assign.ASSIGN, origMtdCall)));
	    extraMtdBody.add(nf.Eval(null, nf.Assign(null, resFld, Assign.ASSIGN, nf.Local(null, "fallback_result"))));
	    extraMtdBody.add(check);
	    extraMtdBody.add(nf.JL5Return(null, nf.Local(null, "fallback_result")));
	}
	List catches = new TypedList(new LinkedList(), Catch.class, false);
	Block extraMtdBlock = nf.Block(null, extraMtdBody);
	List catchBody = new TypedList(new LinkedList(), Stmt.class, false);
	List catchBodyElse = new TypedList(new LinkedList(), Stmt.class, false);
	List args2i = new TypedList(new LinkedList(), Expr.class, false);
	TypeNode pbjIntTN = this.PBJInternIntTN;
	Local loc = nf.Local(null, "fallback_problem");
	List argClones = new TypedList(new LinkedList(), Stmt.class, false);
	List fiNs = new TypedList(new LinkedList(), VarDeclarator.class, false);
	String fiN = "i_fallback";
	VarDeclarator fiNV = new VarDeclarator(null, fiN);
	fiNV.init = nf.IntLit(null, IntLit.INT, 0);
	fiNs.add(fiNV);
	List varDs = variableDeclarators(this.intTN, fiNs, emptyFlags.classicFlags());
	List forIfUpd = new TypedList(new LinkedList(), Eval.class, false);
	forIfUpd.add(nf.Eval(null, nf.Unary(null, Unary.POST_INC, nf.Local(null, fiN))));
	for (Formal f : frms) {
	    String fName = f.name();
	    // HACK FIXME
	    Type ft = f.type().type();
	    Expr fL = nf.Local(null, fName); 
	    if (ft.isPrimitive()) {
		List argsa = new TypedList(new LinkedList(), Expr.class, false);
		argsa.add(fL);
	    } else if (!(ft == ts.String() || isEnum(ft) || fName.equals("modifiableObjects"))) {  //FIXME
		List argsa = new TypedList(new LinkedList(), Expr.class, false);
		argsa.add(fL);
		Expr argPart1 = nf.Binary(null, fL, Binary.NE, nf.NullLit(null));
		if (ft.isArray()) {
		    Type ftb = ((ArrayType) ft).base();
		    if (!(isPrimitive(ftb) || isEnum(ftb))) {
			Expr lenExpr0 = nf.JL5Field(null, fL, "length");
			Expr forPart4 = nf.Binary(null, nf.Local(null, fiN), Binary.LT, lenExpr0);
			Expr elm = nf.ArrayAccess(null, fL, nf.Local(null, fiN));
			Stmt forIfStmt0 = nf.Eval(null, nf.Call(null, nf.JL5Cast(null, this.PBJObjTN, elm), "fallback_clone", emptyArgs));
			Stmt forIfStmt = nf.For(null, varDs, forPart4, forIfUpd, forIfStmt0);
			argClones.add(nf.JL5If(null, argPart1, forIfStmt, null)); 
		    }		    
		} else {		    
		    if (!implementsPBJInternObject((ReferenceType) ft)) {
			argPart1 = nf.FormulaBinary(null, argPart1, Binary.COND_AND, nf.Instanceof(null, fL, PBJObjTN), "and");
			fL = nf.JL5Cast(null, this.PBJObjTN, fL);
		    }
			
		    Stmt argIfStmt = nf.JL5If(null, argPart1, nf.Eval(null, nf.Call(null, fL, "fallback_clone", emptyArgs)), null);
		    argClones.add(argIfStmt);
		}
	    }
	    args2i.add(nf.Local(null, fName));
	}
 	Expr modExpr = methodDecl.modifiableObjects();
 	if (modExpr != null) 
 	    args2i.add(fixModifiableObjectsExpr(modExpr));
	Expr fbL2Call = nf.Call(null, null, methodName + "_planb", args2i);
	LocalDecl d3 = nf.JL5LocalDecl(null, emptyFlags, LogProblemTN, "fallback_problem", fbL2Call);
	d3 = d3.localInstance(ts.localInstance(null, d3.flags(), d3.declType(), d3.name()));
	catchBodyElse.add(nf.Eval(null, nf.Call(null, nf.Local(null,"rte"), "printStackTrace", emptyArgs)));
	catchBodyElse.add(d3);
	args.add(nf.Local(null, "fallback_problem"));
	Stmt checkCommitAtomic = nf.Eval(null, nf.Call(null, null, methodName + "_commitModel", args));
	catchBodyElse.add(checkCommitAtomic);
	if (!isVoid) {
	    Expr resFldCst = nf.JL5Cast(null, nf.CanonicalTypeNode(null, retTp.isPrimitive() ? ts.typeForName(ts.wrapperTypeString((PrimitiveType) retTp)) : retTp), resFld);
	    catchBodyElse.add(nf.JL5Return(null, resFldCst));
	}
	Block catchBlockElse = nf.Block(null, catchBodyElse);
	catchBody.add(catchBlockElse);
	Block catchBlock = nf.Block(null, catchBody);
	catches.add(nf.JL5Catch(null, methodDecl.catchFormal(), catchBlock));
	List mainBody = new TypedList(new LinkedList(), Stmt.class, false);
	if (!isVoid) {
	    LocalDecl d1 = nf.JL5LocalDecl(null, emptyFlags, methodDecl.returnType(), "fallback_result", null);
	    d1 = d1.localInstance(ts.localInstance(null, d1.flags(), d1.declType(), d1.name()));
	    mainBody.add(d1);
	}
	if (methodDecl.requiresExpr() != null) {
	    Stmt check1 = nf.Eval(null, nf.Call(null, null, methodName + "_assertPrecondition", args3));
	    mainBody.add(check1);
	}
	Stmt d2 = nf.Eval(null, nf.Call(null, null, "initEnsuredMethod", emptyArgs));
	mainBody.add(d2);
	mainBody.addAll(argClones);
	mainBody.add(nf.Try(null, extraMtdBlock, catches));
	FlagAnnotations fl = copyJL5MethodDeclFlagAnnotations((JL5MethodDecl_c) methodDecl, false);
	return JL5MethodDeclHelper(null, fl, methodDecl.returnType(), methodName + "_ensured", newFrms, methodDecl.throwTypes(), nf.Block(null, mainBody));	
    }

    public JL5MethodDecl definePlanBMtdForEnsuredMtd(ESJEnsuredMethodDecl methodDecl, String methodName, TypeNode currClassTN, String currClassRawName) throws SemanticException {
	List modifiableFields = methodDecl.modifiableFields();
	Expr modifiableObjects = methodDecl.modifiableObjects();
	List addedObjects = methodDecl.addedObjects();
	TypeNode retTpN = methodDecl.returnType();
	Type retTp = retTpN.type();
	Local loc = nf.Local(null, "fallback_problem");
	Local loc1 = nf.Local(null, "fallback_targetTypeArgsStr");
	Local loc2 = nf.Local(null, "fallback_targetTypeArgs");
	if (retTp instanceof ParameterizedType)
	    retTpN = nf.CanonicalTypeNode(null, ((ParameterizedType) retTp).baseType());
	else if (retTp.isArray())
	    retTpN = nf.CanonicalTypeNode(null, ((ArrayType) retTp).base());
	else if (retTp instanceof TypeVariable)
	    retTpN = ObjectTN;
	boolean isVoid = retTp.isVoid();
	FlagAnnotations fl = emptyFlags; 
	List args = new TypedList(new LinkedList(), Expr.class, false);
	List args2 = new TypedList(new LinkedList(), Expr.class, false);
	List args3 = new TypedList(new LinkedList(), Expr.class, false);
	List sArgs = new TypedList(new LinkedList(), Expr.class, false);
	sArgs.add(loc);
	sArgs.add(loc1);
	sArgs.add(loc2);
	Expr tdExpr =  nf.Call(null, this.ThreadTN, "currentThread", emptyArgs);
	args.add(nf.Binary(null, nf.StringLit(null, "\n"), Binary.ADD, nf.Binary(null, nf.This(null), Binary.ADD, nf.Binary(null, nf.StringLit(null, " ("), Binary.ADD, nf.Binary(null, tdExpr, Binary.ADD, nf.Binary(null, nf.StringLit(null, ": " + methodDecl.name()), Binary.ADD, nf.StringLit(null, ") initiated plan b...")))))));
	Local locf = nf.Local(null,"fallback_formula");
	args2.add(locf);
	args3.add(nf.StringLit(null, methodName));
	args3.add(nf.This(null));
	args3.add(nf.Call(null, locf, "formula", emptyArgs));
	args3.add(modifiableObjects == null ? nf.NullLit(null) : nf.Local(null, "modifiableObjects"));
	args3.add(nf.BooleanLit(null, methodDecl.isFreshResult()));
	args3.add(nf.BooleanLit(null, methodDecl.isUniqueResults()));
	args3.add(nf.JL5Field(null, nf.This(null), "startMethodTime"));
	args3.add(nf.BooleanLit(null, false));
	List l = new TypedList(new LinkedList(), Stmt.class, false);
	LocalDecl d2 = nf.LocalDecl(null, fl.classicFlags(), this.booleanTN, "isSatisfiable", nf.Call(null, loc, "solve", args3));
	l.add(nf.Eval(null, nf.Call(null, nf.JL5Field(null, SystemTN, "out"), "println", args))); 

	List catchBodyFormalAtomizes = new TypedList(new LinkedList(), Stmt.class, false);
	List catchBodyFormalRelationalizes = new TypedList(new LinkedList(), Stmt.class, false);
	List frms = new TypedList(new LinkedList(), Formal.class, false);
	List argsB = new TypedList(new LinkedList(), Expr.class, false);
	List fiNs = new TypedList(new LinkedList(), VarDeclarator.class, false);
	String fiN = "i_fallback";
	VarDeclarator fiNV = new VarDeclarator(null, fiN);
	fiNV.init = nf.IntLit(null, IntLit.INT, 0);
	fiNs.add(fiNV);
	List varDs = variableDeclarators(this.intTN, fiNs, emptyFlags.classicFlags());
	List forIfUpd = new TypedList(new LinkedList(), Eval.class, false);
	forIfUpd.add(nf.Eval(null, nf.Unary(null, Unary.POST_INC, nf.Local(null, fiN))));
		    
	for (Formal f : (List<Formal>) methodDecl.formals()) {
	    Type ft = f.type().type();
	    frms.add(f);
	    argsB.add(nf.Local(null, f.name()).type(ft));
	    // HACK FIXME
	    Local fL = nf.Local(null, f.name()); 
	    Expr fLOld = nf.Call(null, fL, "old", emptyArgs);
	    if (ft.isArray()) {
		Type bTp = ((ArrayType) ft).base();
		if (!(isPrimitive(bTp) || isEnum(bTp))) {
		    List args6p = new TypedList(new LinkedList(), Expr.class, false);
		    args6p.add(loc);
		    args6p.add(nf.StringLit(null, ""));
		    args6p.add(nf.NullLit(null));
		    Expr argPart1 = nf.Binary(null, fL, Binary.NE, nf.NullLit(null));
		    Expr lenExpr0 = nf.JL5Field(null, fL, "length");
		    Expr forPart4 = nf.Binary(null, nf.Local(null, fiN), Binary.LT, lenExpr0);
		    Expr elm = nf.ArrayAccess(null, fL, nf.Local(null, fiN));
		    Stmt forIfStmt0A = nf.Eval(null, nf.Call(null, nf.Call(null, elm, "old", emptyArgs), "fallback_atomize", args6p));
		    Stmt forIfStmt0B = nf.Eval(null, nf.Call(null, nf.Call(null, elm, "old", emptyArgs), "fallback_relationizeOld", args6p));
		    Stmt forIfStmtA = nf.For(null, varDs, forPart4, forIfUpd, forIfStmt0A);
		    Stmt forIfStmtB = nf.For(null, varDs, forPart4, forIfUpd, forIfStmt0B);
		    Stmt s0 = nf.JL5If(null, argPart1, forIfStmtA, null);
		    Stmt s1 = nf.JL5If(null, argPart1, forIfStmtB, null);
		    catchBodyFormalAtomizes.add(s0);
		    catchBodyFormalRelationalizes.add(s1);
		}
	    } else if (!(isPrimitive(ft) || f.name().equals("modifiableObjects") || isEnum(ft))) {
		List argsC = new TypedList(new LinkedList(), Expr.class, false);
		argsC.add(loc);
		Expr arg3;
		Expr e1, e2;
		if (ft instanceof ParameterizedType) {
		    e1 = typeParametersAsString((ParameterizedType) ft, nf);
		    e2 = typeParametersAsStringArray((ParameterizedType) ft, nf);
		} else {
		    e1 = nf.StringLit(null, "");
		    e2 = nf.NullLit(null);
		}
		argsC.add(e1);
		argsC.add(e2);
		Stmt s0;
		Stmt s1;
		Expr iof = nf.Binary(null, fL, Binary.NE, nf.NullLit(null));
		Expr itm = fLOld;
		if (ft instanceof TypeVariable || (!implementsPBJInternObject((ReferenceType) ft))) {
		    itm = nf.Call(null, nf.JL5Cast(null, PBJObjTN, fL), "old", emptyArgs);
		    iof = nf.FormulaBinary(null, iof, Binary.COND_AND, nf.Instanceof(null, fL, PBJObjTN), "and");
		}
		s0 = nf.JL5If(null, iof, nf.Eval(null, nf.Call(null, itm, "fallback_atomize", argsC)), null);
		s1 = nf.JL5If(null, iof, nf.Eval(null, nf.Call(null, itm, "fallback_relationizeOld", argsC)), null);
		catchBodyFormalAtomizes.add(s0);
		catchBodyFormalRelationalizes.add(s1);
	    }
	}
	Expr probFormula = nf.ESJCall(null, nf.This(null).type(currClassTN.type()), methodName + "_checkContract", argsB).type(ts.Boolean()); 
	ESJLocalDecl d1 = nf.ESJLocalDecl(null, fl, this.booleanTN, "fallback_formula", probFormula, methodDecl);
	List lc0 = new TypedList(new LinkedList(), Stmt.class, false);
	List lc1 = new TypedList(new LinkedList(), Stmt.class, false);
	List lc2 = new TypedList(new LinkedList(), Stmt.class, false);
	//HACK FIXME: if fresh objects belong to classes not referred to before, 
	// we might not have included class as involvedClass ...
	if (addedObjects != null) {
	    for(int kk=0; kk < addedObjects.size(); kk += 2) {
		TypeNode addedTN = (TypeNode) addedObjects.get(kk);
		TypeNode addedRawTN = addedTN;
		Type addedTp = addedTN.type();
		if (addedTp instanceof ParameterizedType)
		    addedRawTN = nf.CanonicalTypeNode(null, ((ParameterizedType) addedTp).baseType());
		l.add(nf.Eval(null, nf.Call(null, addedRawTN, "fallback_initClassDefs", emptyArgs)));
		lc0.add(nf.Eval(null, nf.Call(null, addedRawTN, "fallback_classClone", emptyArgs)));
		lc1.add(nf.Eval(null, nf.Call(null, addedRawTN, "fallback_classAtomize", sArgs)));
		lc2.add(nf.Eval(null, nf.Call(null, addedRawTN, "fallback_classRelationizeOld", sArgs)));
	    }
	}
	LocalDecl dp = nf.LocalDecl(null, fl.classicFlags(), LogProblemTN, "fallback_problem", nf.Call(null, LogMapTN, "initRelationize", emptyArgs));	    
	l.add(dp.localInstance(ts.localInstance(null, dp.flags(), dp.declType(), dp.name())));
	LocalDecl d6 = nf.LocalDecl(null, fl.classicFlags(), this.StringTN, "fallback_targetTypeArgsStr", nf.StringLit(null, ""));
	LocalDecl d7 = nf.LocalDecl(null, fl.classicFlags(), this.StringArrayTN, "fallback_targetTypeArgs", nf.NullLit(null));
	l.add(d6.localInstance(ts.localInstance(null, d6.flags(), d6.declType(), d6.name())));
	l.add(d7.localInstance(ts.localInstance(null, d7.flags(), d7.declType(), d7.name())));
	if (addedObjects != null) {
	    l.add(nf.Eval(null, nf.Call(null, loc, "newFreshInstances", emptyArgs)));
	    for(int kk=0; kk < addedObjects.size(); kk += 2) {
		TypeNode addedTN = (TypeNode) addedObjects.get(kk);
		ClassType addedTp = (ClassType) addedTN.type();
		List as = new TypedList(new LinkedList(), Expr.class, false);
		Expr tpArgs = nf.NullLit(null);
		List l0 =  new TypedList(new LinkedList(), Expr.class, false);
		as.add(nf.StringLit(null, typeFullName(addedTp)));
		as.add((Expr) addedObjects.get(kk+1));
		l.add(nf.Eval(null, nf.Call(null, loc, "setFreshInstances", as)));
	    }
	}
	Expr old = nf.Local(null, "old");
	Expr theThis = nf.This(null);
	List args5p = new TypedList(new LinkedList(), Expr.class, false);
	args5p.add(loc);
	args5p.add(nf.StringLit(null, "")); 
	args5p.add(nf.NullLit(null));
	l.add(nf.Eval(null, nf.Call(null, old, "fallback_atomize", args5p)));
	l.addAll(lc0);
	l.addAll(lc1);
	l.addAll(catchBodyFormalAtomizes);
	List args5 = new TypedList(new LinkedList(), Expr.class, false);
	l.add(nf.Eval(null, nf.Call(null, loc, "ObjToAtomMap", args5)));
	l.add(nf.Eval(null, nf.Call(null, old, "fallback_relationizeOld", args5p)));
	l.addAll(catchBodyFormalRelationalizes);
	l.addAll(lc2);
	l.add(nf.Eval(null, nf.Call(null, loc, "initRelations", emptyArgs)));
	
	if (modifiableFields != null) {
	    int sz = modifiableFields.size();
	    l.add(nf.Eval(null, nf.Call(null, loc, "newModifiableFields", emptyArgs)));
	    for(int i = 0; i < sz; i++) {
		ESJModifiableField s = (ESJModifiableField) modifiableFields.get(i);
		List as = new TypedList(new LinkedList(), Expr.class, false);
		as.add(nf.StringLit(null, s.fieldClass() + "." + s.fieldName()));
		l.add(nf.Eval(null, nf.Call(null, loc, "setModifiableField", as)));
	    }
	}
	
	List argsA = new TypedList(new LinkedList(), Expr.class, false);
	argsA.add(nf.This(null));
	LocalDecl d3 = nf.LocalDecl(null, fl.classicFlags(), this.LogExprTN, "fallback_target", nf.Call(null, loc, "objToSingletonRelation_log", argsA));
	LocalDecl d4 = nf.LocalDecl(null, fl.classicFlags(), this.booleanTN, "fallback_target_isOld", nf.BooleanLit(null, false));
	l.add(d3.localInstance(ts.localInstance(null, d3.flags(), d3.declType(), d3.name())));
	l.add(d4.localInstance(ts.localInstance(null, d4.flags(), d4.declType(), d4.name())));
	l.add(d1.localInstance(ts.localInstance(null, d1.flags(), d1.declType(), d1.name())));
	l.add(d2.localInstance(ts.localInstance(null, d2.flags(), d2.declType(), d2.name())));
	l.add(nf.JL5Assert(null, nf.Local(null, "isSatisfiable"), nf.StringLit(null, "Formula UNSAT! Recovery failed...")));

	l.add(nf.Return(null, nf.Local(null, "fallback_problem")));
	if (modifiableObjects != null) {

	    TypeNode collectiontn = this.CollectionTN;
	    JL5Formal lf = nf.JL5Formal(null, emptyFlags, collectiontn, "modifiableObjects");
	    frms.add(lf.localInstance(ts.localInstance(null, lf.flags(), lf.declType(), lf.name())));

	}
	return ESJLogPredMethodDeclHelper(null, fl,
					  this.LogProblemTN,
					  methodName + "_planb", 
					  frms, 
					  methodDecl.throwTypes(), 
					  nf.Block(null, l),
					  emptyLocalDecls, 
					  emptyLocalDecls, 
					  true);
	
    }
    

    private List findMembersOfInterest(ESJEnsuredClassDecl classDecl) {
	List specFields = new TypedList(new LinkedList(), ESJFieldDecl.class, false);
	List specRefFields = new TypedList(new LinkedList(), ESJFieldDecl.class, false);
	List ensuredMtds = new TypedList(new LinkedList(), ESJEnsuredMethodDecl.class, false); 
	List specMtds = new TypedList(new LinkedList(), ESJMethodDecl.class, false); 
	List specRefMutexes = new TypedList(new LinkedList(), Expr.class, false);
	List finalFields = new TypedList(new LinkedList(), FieldDecl.class, false);
	List assumeStmts = new TypedList(new LinkedList(), ESJAssume.class, false);
	HashMap specMtdsMap = new HashMap();
	for (ClassMember n : (List<ClassMember>) classDecl.body().members()) {
	    if (n instanceof FieldDecl) {
		FieldDecl fi0 = (FieldDecl) n;
		if (fi0.flags().isFinal() && fi0.init() == null) {
		    finalFields.add(n);
		}
		if (n instanceof ESJFieldDecl) {
		    ESJFieldDecl fi = (ESJFieldDecl) n;
		    specFields.add(n);
		    Type ft = fi.declType(); 
		    boolean isReference = ft.isReference() && !ft.isArray() && !isPrimitive(ft);
		    if (isReference) {
			specRefFields.add(fi);
			Local fld = nf.Local(null, fi.name());
			specRefMutexes.add(nf.JL5Conditional(null, nf.Binary(null, fld, Binary.EQ, nf.NullLit(null)), nf.JL5New(null, ObjectTN, emptyArgs, null, emptyTypeNodes), nf.Field(null, fld, "fallback_consistencyLock")));
		    }
		}
	    } else if (n instanceof ESJEnsuredMethodDecl)
		ensuredMtds.add(n);
	    else if (n instanceof ESJMethodDecl) {
		ESJMethodDecl m = (ESJMethodDecl) n;
		specMtds.add(m);
		specMtdsMap.put(m.name(), n);
	    } else if (n instanceof JL5MethodDecl) {
		JL5MethodDecl m = (JL5MethodDecl) n;
		for (Object s : m.body().statements())
		    if (s instanceof ESJAssume)
			assumeStmts.add((ESJAssume)s);
	    }
	}
	List all = new TypedList(new LinkedList(), Object.class, false); 
	all.add(specFields);
	all.add(specRefFields);
	all.add(ensuredMtds);
	all.add(specMtds);
	all.add(specMtdsMap);
	all.add(specRefMutexes);
	all.add(finalFields);
	all.add(assumeStmts);
	return all;
    }

    private void initClassInits(TypeNode currClassTN, boolean isOuter) throws SemanticException {
	String m;
	TypeNode tn;
	classInits = new TypedList(new LinkedList(), Eval.class, false);
	if (isOuter) {
	    m = "newClassForLog";
	    tn = currClassTN;
	} else {
	    m = "newClassForLogInnerClasses";
	    Type outC = currClassTp.outer();
	    String outCN = outC.toString();
	    if (innerClassesInit.containsKey(outCN)) 
		return;
	    innerClassesInit.put(outCN, true);
	    tn = nf.CanonicalTypeNode(null, outC);
	}
	List newCArgs = new TypedList(new LinkedList(), Expr.class, false);
	newCArgs.add(nf.ClassLit(null, tn));
	if (isOuter) {
	    newCArgs.add(nf.BooleanLit(null, true));
	    if (currClassTp instanceof ParsedClassType && 		
		((JL5ParsedClassType) currClassTp).typeVariables() != null) {
		JL5ParsedClassType tp = (JL5ParsedClassType) currClassTp;
		for (TypeVariable p : (List<TypeVariable>) tp.typeVariables()) {
		    newCArgs.add(nf.StringLit(null, p.toString()));
		}
	    }
	}
	classInits.add(nf.Eval(null,nf.Call(null, this.LogMapTN, m, newCArgs)));
    }

    private void initClassInitsGenerics(TypeNode currClassTN, boolean isOuter) throws SemanticException {

	if (!instantiatedGenericClasses.isEmpty()) {
	    for (TypeNode tn : instantiatedGenericClasses.keySet()) {
		if (instantiatedGenericClasses.get(tn))
		    continue;
		instantiatedGenericClasses.put(tn, true);
		ParameterizedType tp = (ParameterizedType) tn.type();
		if (genericTypeSpecFields.containsKey(tp.baseType())) {
		    List args = new TypedList(new LinkedList(), Expr.class, false);
		    args.add(nf.ClassLit(null, nf.CanonicalTypeNode(null, tp.baseType())));
		    args.add(nf.StringLit(null, tn.toString()));
		    List l0 =  new TypedList(new LinkedList(), Expr.class, false);		 
		    List l1 =  new TypedList(new LinkedList(), Expr.class, false);		 
		    for (Type ta : tp.typeArguments()) {
			l0.add(nf.ClassLit(null, nf.CanonicalTypeNode(null, ta)));
			l1.add(nf.StringLit(null, ta.toString()));
		    }
		    args.add(nf.JL5NewArray(null, ClassTN, Collections.EMPTY_LIST, 1, nf.ArrayInit(null, l0)));
		    args.add(nf.JL5NewArray(null, StringTN, Collections.EMPTY_LIST, 1, nf.ArrayInit(null, l1)));
		    classInits.add(nf.Eval(null, nf.Call(null, this.LogMapTN, "newParameterizedGenericClass", args)));
		}
	    }
	}	
    }

    // a dummy class constructor when model from constraint solving requires fresh instances
    private void addPBJConstructor(FlagAnnotations fl, List l, ESJEnsuredClassDecl classDecl, List finFieldsWithoutInit, boolean hasSuperType, boolean isPbjClassSubtype)  throws SemanticException {
	List basicFrms = new TypedList(new LinkedList(), Formal.class, false);
	List args0 = new TypedList(new LinkedList(), Expr.class, false);
	JL5Formal lf = nf.JL5Formal(null, emptyFlags, this.LogExprTN, "dontcare");
	basicFrms.add(lf.localInstance(ts.localInstance(null, lf.flags(), lf.declType(), lf.name())));
	List body = new TypedList(new LinkedList(), Stmt.class, false);
	if (hasSuperType) {
	    if (isPbjClassSubtype)
		args0.add(nf.Local(null, "dontcare"));
	    else {
		ClassType stp = (ClassType) classDecl.type().superType();
		List cs = stp.constructors();
		if (!cs.isEmpty()) {
		    ConstructorInstance ci = (ConstructorInstance) cs.get(0);
		    List formalTypes = ci.formalTypes();
		    for (Object ftp : formalTypes)
			args0.add(defaultValue((Type) ftp));
		}
	    }
	}
	body.add(nf.SuperCall(null, args0));
	for (FieldDecl fi : (List<FieldDecl>) finFieldsWithoutInit) {
	    Type fiType = fi.declType(); 
	    Expr def = defaultValue(fiType);
	    body.add(nf.Eval(null, nf.Assign(null, nf.JL5Field(null, nf.This(null), fi.name()), Assign.ASSIGN, def)));
	}
	body.add(nf.Eval(null, nf.Call(null, nf.This(null), "addInstance", emptyArgs)));
	l.add(JL5ConstructorDeclHelper(null, fl, classDecl.name(), basicFrms, emptyTypeNodes, nf.Block(null, body)));

    }

    private void addVerifInvariantsMtd(FlagAnnotations fl, List l, JL5ClassDecl classDecl, List specMtds, boolean isNotInterface) throws SemanticException {
	Block block = null;
	if (isNotInterface) {
	    List extraMtdBody = new TypedList(new LinkedList(), Stmt.class, false);
	    Expr classInvs = ((ESJEnsuredClassDecl)classDecl).ensuresExpr();
	    extraMtdBody.add(nf.Return(null, classInvs));
	    block = nf.Block(null, extraMtdBody);
	}
	MethodDecl methodDecl = JL5MethodDeclHelper(null, fl, this.booleanTN, "fallback_checkInvariants", emptyArgs, emptyTypeNodes, block);
	l.add(methodDecl);
	if (isNotInterface)
	    specMtds.add(methodDecl);
    }

    private void addAddInstanceMtd(FlagAnnotations fl, List l, ESJEnsuredClassDecl classDecl, TypeNode currClassTN, String currClassRawName, boolean isPbjClassSubtype) throws SemanticException {
	ClassType clTp = classDecl.type();
	List extraMtdBody = new TypedList(new LinkedList(), Stmt.class, false);
	List extraMtdBody2 = new TypedList(new LinkedList(), Stmt.class, false);
	List args = new TypedList(new LinkedList(), Expr.class, false);
	List args2 = new TypedList(new LinkedList(), Expr.class, false);
	ClassLit cl = nf.ClassLit(null, currClassTN);
	Local fb = nf.Local(null, "fallback_problem");
	Local tt = nf.Local(null, "fallback_targetTypeArgsStr");
	Local loca = nf.Local(null, "toAdd");
	args.add(cl);
	args.add(nf.This(null));
	args2.add(loca); 
	args2.add(cl);
	args2.add(nf.StringLit(null, currClassRawName));
	args2.add(tt);
	extraMtdBody.add(nf.Eval(null, nf.Call(null, this.LogMapTN, "addInstance", args)));
	extraMtdBody2.add(nf.Eval(null, nf.Call(null, fb, "addToClassInstances", args2)));
	Type sTp = clTp.superType();
	// FIXME: need to also mark the instance for a superclass?
	if (isPbjClassSubtype) {
	    List args2a = new TypedList(new LinkedList(), Expr.class, false);
	    List args2b = new TypedList(new LinkedList(), Expr.class, false);
	    args2a.add(loca);
	    args2a.add(fb);
	    args2a.add(this.nf.StringLit(null, sTp.toString())); //FIXME
	    extraMtdBody.add(nf.Eval(null, nf.Call(null, nf.Super(null), "addInstance", emptyArgs)));
	    args2b.add(loca);
	    args2b.add(fb);
	    args2b.add(tt);
	    extraMtdBody2.add(nf.Eval(null, nf.Call(null, nf.Super(null), "addInstanceForProblem", args2b)));
	}
	MethodDecl methodDecl = JL5MethodDeclHelper(null, fl, VoidTN, "addInstance", emptyArgs, emptyTypeNodes, nf.Block(null, extraMtdBody));
	List frms = new TypedList(new LinkedList(), Formal.class, false);
	JL5Formal lf0 = nf.JL5Formal(null, emptyFlags, currClassTN, "toAdd");
	JL5Formal lf1 = nf.JL5Formal(null, emptyFlags, LogProblemTN, "fallback_problem");
	JL5Formal lf2 = nf.JL5Formal(null, emptyFlags, StringTN, "fallback_targetTypeArgsStr");
	frms.add(lf0.localInstance(ts.localInstance(null, lf0.flags(), lf0.declType(), lf0.name())));
	frms.add(lf1.localInstance(ts.localInstance(null, lf1.flags(), lf1.declType(), lf1.name())));
	frms.add(lf2.localInstance(ts.localInstance(null, lf2.flags(), lf2.declType(), lf2.name())));
	MethodDecl methodDecl2 = JL5MethodDeclHelper(null, fl, VoidTN, "addInstanceForProblem", frms, emptyTypeNodes, nf.Block(null, extraMtdBody2));
	l.add(methodDecl);
	l.add(methodDecl2);
    }

    private void addFieldRelationDefs(ESJEnsuredClassDecl classDecl, FlagAnnotations fl1, List l1, boolean isOuter) throws SemanticException {
	if (isOuter) { 
	    if (carryOverClassInits != null) {		
		classInits.addAll(carryOverClassInits);		
		carryOverClassInits = new TypedList(new LinkedList(), Eval.class, false);
	    }
	    Block initDefBody = this.nf.Block(null, classInits);	
	    Initializer i = nf.Initializer(null, Flags.STATIC, initDefBody);
	    //HACK FIXME: static initializer current isn't run if the main entry file is other than this file being compiled. making a dummy a method to force
	    //initializations to run...
	    l1.add(JL5MethodDeclHelper(null, fl1, VoidTN, "fallback_initClassDefs", emptyFormals, emptyTypeNodes, nf.Block(null, new TypedList(new LinkedList(), Stmt.class, false))));
	    l1.add(i.initializerInstance(ts.initializerInstance(null, currClassTp, i.flags())));	    
	} else {
	    carryOverClassInits.addAll(classInits);
	}
    }

    private void addStartMethodTimeField(FlagAnnotations fl, List l) {
	l.add(nf.JL5FieldDecl(null, emptyFlags, nf.CanonicalTypeNode(null, ts.Long()),"startMethodTime", null));
    }

    private void addResultArrayField(FlagAnnotations fl, List l) throws SemanticException {
	TypeNode tn = nf.CanonicalTypeNode(null, ts.arrayOf(ts.Object()));
	l.add(nf.JL5FieldDecl(null, emptyFlags, tn, "fallback_field_resultArray", null));
	List resMtdFormals = new TypedList(new LinkedList(), Formal.class, false);
	JL5Formal lf = nf.JL5Formal(null, emptyFlags, tn, "r");
	resMtdFormals.add(lf.localInstance(ts.localInstance(null, lf.flags(), lf.declType(), lf.name())));
	l.add(JL5MethodDeclHelper(null, fl, this.VoidTN, "fallback_field_resultArray", resMtdFormals, emptyTypeNodes, nf.Block(null,nf.Eval(null, nf.Assign(null, nf.JL5Field(null, nf.This(null), "fallback_field_resultArray"), Assign.ASSIGN, nf.Local(null, "r"))))));
    }

    private void addOldFieldAndMtds(FlagAnnotations fl, List l, TypeNode currClassTN) throws SemanticException {
	l.add(nf.JL5FieldDecl(null,emptyFlags, this.booleanTN, "isOld", null));
	l.add(nf.JL5FieldDecl(null, emptyFlags, this.ObjectTN ,"fallback_consistencyLock", null));
	l.add(nf.JL5FieldDecl(null, emptyFlags, this.intTN ,"fallback_updateTime", null));
	TypeNode myTn = getGenericTypeNode(currClassTp);
	l.add(JL5MethodDeclHelper(null, fl, myTn, "old", emptyFormals, emptyTypeNodes, nf.Block(null,nf.JL5Return(null,nf.JL5Field(null, nf.This(null), "old")))));
	TypeNode tn = this.StringArrayTN;
	l.add(nf.JL5FieldDecl(null, emptyFlags, tn ,"fallback_typeArgs", null));
	List frms = new TypedList(new LinkedList(), Formal.class, false);
	JL5Formal lf = nf.JL5Formal(null, emptyFlags, tn, "args");
	frms.add(lf.localInstance(ts.localInstance(null, lf.flags(), lf.declType(), lf.name())));
	List stmts = new TypedList(new LinkedList(), Stmt.class, false);	    
	stmts.add(nf.Eval(null, nf.Assign(null, nf.JL5Field(null, nf.This(null), "fallback_typeArgs"), Assign.ASSIGN, nf.Local(null, "args"))));
	stmts.add(nf.JL5Return(null, nf.This(null)));
	l.add(JL5MethodDeclHelper(null, fl, myTn, "fallback_setTypeArgs", frms, emptyTypeNodes, nf.Block(null, stmts)));
    }

    private void addIsRelationizedAndClonedMtds(FlagAnnotations fl, FlagAnnotations fl1, List l, TypeNode currClassTN, boolean isOuter) throws SemanticException {
	l.add(nf.JL5FieldDecl(null, emptyFlags, this.intTN, "clonerStep", nf.IntLit(null, IntLit.INT, 0)));
	l.add(nf.JL5FieldDecl(null, emptyFlags, this.intTN, "atomizerStep", nf.IntLit(null, IntLit.INT, 0)));

	List frms = new TypedList(new LinkedList(), Formal.class, false);
	JL5Formal lf = nf.JL5Formal(null, emptyFlags, this.LogProblemTN, "fallback_problem");
	frms.add(lf.localInstance(ts.localInstance(null, lf.flags(), lf.declType(), lf.name())));

	Local p = nf.Local(null, "fallback_problem");
	l.add(JL5MethodDeclHelper(null, emptyFlags, this.booleanTN, "isCloned", emptyFormals, emptyTypeNodes, nf.Block(null,nf.JL5Return(null, nf.ESJBinary(null, nf.JL5Field(null, nf.This(null), "clonerStep"), Binary.EQ, nf.Call(null, this.LogMapTN, "clonerStep", emptyArgs))))));	
	l.add(JL5MethodDeclHelper(null, emptyFlags, this.booleanTN, "isAtomized", frms, emptyTypeNodes, nf.Block(null,nf.JL5Return(null, nf.ESJBinary(null, nf.JL5Field(null, nf.This(null), "atomizerStep"), Binary.EQ, nf.Call(null, p, "relationizerStep", emptyArgs))))));	
	l.add(nf.JL5FieldDecl(null, emptyFlags, this.intTN, "relationizerStep", nf.IntLit(null, IntLit.INT, 0)));
	l.add(JL5MethodDeclHelper(null, emptyFlags, this.booleanTN, "isRelationized", frms, emptyTypeNodes, nf.Block(null,nf.JL5Return(null, nf.ESJBinary(null, nf.JL5Field(null, nf.This(null), "relationizerStep"), Binary.EQ, nf.Call(null, p, "relationizerStep", emptyArgs))))));	
	if (isOuter) {
	    l.add(nf.JL5FieldDecl(null, fl1, this.intTN, "classRelationizerStep", nf.IntLit(null, IntLit.INT, 0)));
	    l.add(JL5MethodDeclHelper(null, fl1, this.booleanTN, "isClassRelationized", frms, emptyTypeNodes, nf.Block(null,nf.JL5Return(null, nf.ESJBinary(null, nf.JL5Field(null, currClassTN, "classRelationizerStep"), Binary.EQ, nf.Call(null, p, "relationizerStep", emptyArgs))))));
	    l.add(nf.JL5FieldDecl(null, fl1, this.intTN, "classAtomizerStep", nf.IntLit(null, IntLit.INT, 0)));
	    l.add(JL5MethodDeclHelper(null, fl1, this.booleanTN, "isClassAtomized", frms, emptyTypeNodes, nf.Block(null,nf.JL5Return(null, nf.ESJBinary(null, nf.JL5Field(null, currClassTN, "classAtomizerStep"), Binary.EQ, nf.Call(null, p, "relationizerStep", emptyArgs))))));	
	    l.add(nf.JL5FieldDecl(null, fl1, this.intTN, "classClonerStep", nf.IntLit(null, IntLit.INT, 0)));
	    l.add(JL5MethodDeclHelper(null, fl1, this.booleanTN, "isClassCloned", emptyFormals, emptyTypeNodes, nf.Block(null,nf.JL5Return(null, nf.ESJBinary(null, nf.JL5Field(null, currClassTN, "classClonerStep"), Binary.EQ, nf.Call(null, this.LogMapTN, "clonerStep", emptyArgs))))));	

	}

    }

    private void addInitEnsuredMtd(FlagAnnotations fl, List l, TypeNode currClassTN) throws SemanticException {
	List initEM = new TypedList(new LinkedList(), Stmt.class, false);
	initEM.add(nf.Eval(null, nf.Assign(null, nf.JL5Field(null, nf.This(null), "startMethodTime"), Assign.ASSIGN, nf.Call(null, SystemTN, "currentTimeMillis", emptyArgs))));
	initEM.add(nf.Eval(null, nf.Call(null, this.LogMapTN, "incrClonerStep", emptyArgs)));
	initEM.add(nf.Eval(null, nf.Call(null, null, "fallback_clone", emptyArgs)));
	ESJMethodDecl newMtd = JL5MethodDeclHelper(null, emptyFlags, VoidTN, "initEnsuredMethod", emptyFormals, emptyTypeNodes, nf.Block(null, initEM));
	l.add(newMtd);
    }

    private void addFallbackUpdMtd(FlagAnnotations fl, List l) throws SemanticException {
	List basicFrms = new TypedList(new LinkedList(), Formal.class, false);
	JL5Formal lf = nf.JL5Formal(null, emptyFlags, this.MethodTN, "updaterMtd");
	basicFrms.add(lf.localInstance(ts.localInstance(null, lf.flags(), lf.declType(), lf.name())));	
        lf = nf.JL5Formal(null, emptyFlags, nf.CanonicalTypeNode(null, ts.arrayOf(ts.Object(), 1)), "args");
	basicFrms.add(lf.localInstance(ts.localInstance(null, lf.flags(), lf.declType(), lf.name())));

	List fbUFMtdTry = new TypedList(new LinkedList(), Stmt.class, false);
	List args = new TypedList(new LinkedList(), Expr.class, false);
	args.add(nf.This(null));
	args.add(nf.Local(null, "args"));
	fbUFMtdTry.add(nf.Eval(null, nf.Call(null, nf.Local(null, "updaterMtd"), "invoke", args)));	
	List catches = new TypedList(new LinkedList(), Catch.class, false);
	List catchBody = new TypedList(new LinkedList(), Stmt.class, false);
	catchBody.add(nf.Eval(null, nf.Call(null, nf.Local(null,"rte"), "printStackTrace",
					    emptyArgs)));
	Block catchBlock = nf.Block(null,catchBody);
	Formal aFormal = nf.JL5Formal(null,  emptyFlags, nf.CanonicalTypeNode(null, ts.Exception()), "rte");
	aFormal = aFormal.localInstance(ts.localInstance(null, aFormal.flags(), aFormal.declType(), aFormal.name()));
	catches.add(nf.JL5Catch(null, aFormal, catchBlock));
	Stmt updStmt =  nf.Try(null, nf.Block(null, fbUFMtdTry), catches);
	ESJMethodDecl newMtd = JL5MethodDeclHelper(null, fl, this.VoidTN, "fallback_updateField", basicFrms, emptyTypeNodes, nf.Block(null, updStmt));
	l.add(newMtd);
    }

    private void addFallbackNewInstMtd(FlagAnnotations fl, List l) throws SemanticException {
	List basicFrms = new TypedList(new LinkedList(), Formal.class, false);
	JL5Formal lf = nf.JL5Formal(null, emptyFlags, this.ConstructorTN, "cons");
	basicFrms.add(lf.localInstance(ts.localInstance(null, lf.flags(), lf.declType(), lf.name())));
        lf = nf.JL5Formal(null, emptyFlags, nf.CanonicalTypeNode(null, ts.arrayOf(ts.Object(), 1)), "args");
	basicFrms.add(lf.localInstance(ts.localInstance(null, lf.flags(), lf.declType(), lf.name())));
        lf = nf.JL5Formal(null, emptyFlags, nf.CanonicalTypeNode(null, ts.arrayOf(ts.String(), 1)), "typeParamNames");
	basicFrms.add(lf.localInstance(ts.localInstance(null, lf.flags(), lf.declType(), lf.name())));
	List fbNIMtdTry = new TypedList(new LinkedList(), Stmt.class, false);
	List args = new TypedList(new LinkedList(), Expr.class, false);
	args.add(nf.Local(null, "args"));
	Expr call0 = nf.Call(null, nf.Local(null, "cons"), "newInstance", args);
	List args0 = new TypedList(new LinkedList(), Expr.class, false);
	args0.add(nf.Local(null, "typeParamNames"));	    
	call0 = nf.Call(null, nf.JL5Cast(null, this.PBJObjTN, call0), "fallback_setTypeArgs", args0);
	fbNIMtdTry.add(nf.Return(null, call0));
	List catches = new TypedList(new LinkedList(), Catch.class, false);
	List catchBody = new TypedList(new LinkedList(), Stmt.class, false);
	catchBody.add(nf.Eval(null, nf.Call(null, nf.Local(null,"rte"), "printStackTrace",
					    emptyArgs)));
	catchBody.add(nf.Return(null, nf.NullLit(null)));
	Block catchBlock = nf.Block(null, catchBody);
	Formal aFormal = nf.JL5Formal(null,  emptyFlags, nf.CanonicalTypeNode(null, ts.Exception()), "rte");
	aFormal = aFormal.localInstance(ts.localInstance(null, aFormal.flags(), aFormal.declType(), aFormal.name()));
	catches.add(nf.JL5Catch(null, aFormal, catchBlock));
	Stmt newInstStmt = nf.Try(null, nf.Block(null, fbNIMtdTry), catches);
	ESJMethodDecl newMtd = JL5MethodDeclHelper(null, fl, this.ObjectTN, "fallback_newInstance", basicFrms, emptyTypeNodes, nf.Block(null, newInstStmt));
	l.add(newMtd);
    }

    private void addFieldSpecificMtds(FlagAnnotations fl, FlagAnnotations fl1, FlagAnnotations fl2, List l, List l1, TypeNode currClassTN, String currClassRawName, List specFields) throws SemanticException {
	HashMap<Type,Boolean> fieldClosureDefs = new HashMap<Type,Boolean>();
	Type sett = this.PBJInternSetTP;
	Type listt = this.ArrayListTP;
	Type fldt = this.FieldTP;
	Type itert = this.IteratorTP;
	TypeNode fldtn = nf.CanonicalTypeNode(null, fldt);
	for (ESJFieldDecl fi : (List<ESJFieldDecl>) specFields) {
	    Type fiType = fi.declType(); 
	    Type fiTpW = fiType.isPrimitive() ? ts.typeForName(ts.wrapperTypeString((PrimitiveType) fiType)) : fiType; 
	    boolean isStatic = fi.flags().isStatic();
	    boolean isFinal = fi.flags().isFinal();
	    boolean isArray = fiType.isArray();
	    boolean isGeneric = fiType instanceof ParameterizedType; //FIXME
	    boolean isList = false;
	    boolean isPrimitiveArray = isArray && isPrimitive(((ArrayType) fiType).base()); 
	    boolean isInt = fiType.isNumeric();
	    boolean isBoolean = fiType.isBoolean();
	    boolean isPrimitive = isInt || isBoolean;
	    boolean isReference = fiType.isReference() && !isPrimitive;
	    boolean isEnum = isEnum(fiType);
	    boolean isResultField = fi.isResultField();
	    boolean isResultFieldFresh = fi.isResultFieldFresh();
	    if (isGeneric)
		genericTypeSpecFields.put(((ParameterizedType)fiType).baseType(), true);
	    // define <field>_get_log() for each spec field
	    defineFieldGetLogMtd(fl1, fi, l, currClassTN, currClassRawName, isStatic, isFinal, isPrimitive, isInt, isBoolean, isArray, isPrimitiveArray, isGeneric, isResultField, isResultFieldFresh);
	    // define fallback_updateField_<field>()
	    if (!isResultField) { 
		if (!isFinal)
		    defineFieldUpdateMtd(l, fl, fi, currClassTN, isStatic, isArray);
		if (!(isStatic || isArray || isGeneric)) {
		    
		    ParameterizedType pt = ts.parameterizedType((JL5ParsedClassType) sett);
		    ArrayList<Type> at = new ArrayList<Type>();
		    at.add(fiTpW);
		    pt.typeArguments(at);
		    TypeNode asettn = nf.CanonicalTypeNode(null, pt);
		    pt = ts.parameterizedType((JL5ParsedClassType) listt);
		    pt.typeArguments(at);
		    TypeNode alisttn = nf.CanonicalTypeNode(null, pt);
		    pt = ts.parameterizedType((JL5ParsedClassType) listt);
		    at = new ArrayList<Type>();
		    at.add(fldt);
		    pt.typeArguments(at);
		    TypeNode afldtn = nf.CanonicalTypeNode(null, pt);
		    pt = ts.parameterizedType((JL5ParsedClassType) sett);
		    at = new ArrayList<Type>();
		    at.add(currClassTp);
		    pt.typeArguments(at);
		    TypeNode asettn2 = nf.CanonicalTypeNode(null, pt);	 
		    pt = ts.parameterizedType((JL5ParsedClassType) sett);
		    pt = ts.parameterizedType((JL5ParsedClassType) itert);
		    pt.typeArguments(at);
		    TypeNode aitrtn = nf.CanonicalTypeNode(null, pt);
		    
		    // define <field>_setMap()
		    l1.add(defineSetMapFieldMtd(fl1, fi, asettn, asettn2, aitrtn));
		    if (!fieldClosureDefs.containsKey(fiTpW)) {
			fieldClosureDefs.put(fiTpW, true);
			// define fieldsClosure_<field type>()		
			l.add(defineFieldsClosureMtd(fl, fi, fiTpW, asettn, alisttn, fldtn, afldtn));
			// define multiFields_<field type>()		
			l.add(defineMultiFieldsMtd(fl, fi, fiTpW, asettn, alisttn, fldtn, afldtn));
		    }
		}
	    }	    
	}
    }

    private JL5MethodDecl defineSetMapFieldMtd(FlagAnnotations fl, ESJFieldDecl fi, TypeNode asettn, TypeNode asettn2, TypeNode aitrtn) throws SemanticException {

	String fN = fi.name();
	Type sett = this.PBJInternSetTP;	
	List extraMtdBody = new TypedList(new LinkedList(), Stmt.class, false);
	List frms = new TypedList(new LinkedList(), Formal.class, false);
	frms.add(nf.JL5Formal(null, emptyFlags, asettn2, "objs"));
	TypeNode strtn = this.StringArrayTN;
	frms.add(nf.JL5Formal(null, emptyFlags, strtn, "fieldNs", true));
	LocalDecl d0 = nf.JL5LocalDecl(null, emptyFlags, asettn, "res", nf.JL5New(null, asettn, emptyArgs, null, emptyTypeNodes));
	extraMtdBody.add(d0.localInstance(ts.localInstance(null, d0.flags(), d0.declType(), d0.name())));
	d0 = nf.JL5LocalDecl(null, emptyFlags, aitrtn, "i", nf.Call(null, nf.Local(null, "objs"), "iterator", emptyArgs));
	extraMtdBody.add(d0.localInstance(ts.localInstance(null, d0.flags(), d0.declType(), d0.name())));
	List whileLoopStmts = new TypedList(new LinkedList(), Stmt.class, false);
	List argsW2a = new TypedList(new LinkedList(), Expr.class, false);
	
	argsW2a.add(nf.JL5Field(null, nf.Call(null, nf.Local(null, "i"), "next", emptyArgs), fN));
	Stmt s1 = nf.Eval(null, nf.Call(null, nf.Local(null, "res"), "add", argsW2a));			
	whileLoopStmts.add(s1);
	Stmt whileLoopBody = nf.Block(null, whileLoopStmts);
	extraMtdBody.add(nf.While(null, nf.Call(null, nf.Local(null, "i"), "hasNext", emptyArgs) , whileLoopBody));
	extraMtdBody.add(nf.JL5Return(null, nf.Local(null,"res")));
	Block extraMtdBlock = nf.Block(null, extraMtdBody);
	return JL5MethodDeclHelper(null, fl, asettn, "setMap_"+fN, frms, emptyTypeNodes, extraMtdBlock);
     }

    private JL5MethodDecl defineFieldsClosureMtd(FlagAnnotations fl, ESJFieldDecl fi, Type fiTp, TypeNode asettn, TypeNode alisttn, TypeNode fldtn, TypeNode afldtn) throws SemanticException {

	TypeNode fiTN = nf.CanonicalTypeNode(null, fiTp);	
	List extraMtdBody = new TypedList(new LinkedList(), Stmt.class, false);
	LocalDecl d0 = nf.JL5LocalDecl(null, emptyFlags, nf.CanonicalTypeNode(null, ts.Class()), "c", nf.ClassLit(null, fi.type()));
	extraMtdBody.add(d0.localInstance(ts.localInstance(null, d0.flags(), d0.declType(), d0.name())));
	List frms = new TypedList(new LinkedList(), Formal.class, false);
	frms.add(nf.JL5Formal(null, emptyFlags, this.ObjectTN, "fallback_target"));
	frms.add(nf.JL5Formal(null, emptyFlags, this.booleanTN, "isReflexive"));
	TypeNode strtn = this.StringArrayTN;
	frms.add(nf.JL5Formal(null, emptyFlags, strtn, "fieldNs", true));
	d0 = nf.JL5LocalDecl(null, emptyFlags, asettn, "res", nf.JL5New(null, asettn, emptyArgs, null, emptyTypeNodes));
	extraMtdBody.add(d0.localInstance(ts.localInstance(null, d0.flags(), d0.declType(), d0.name())));
	d0 = nf.JL5LocalDecl(null, emptyFlags, alisttn, "workList", nf.JL5New(null, alisttn, emptyArgs, null, emptyTypeNodes));
	extraMtdBody.add(d0.localInstance(ts.localInstance(null, d0.flags(), d0.declType(), d0.name())));
	List argsW = new TypedList(new LinkedList(), Expr.class, false);
	argsW.add(nf.Local(null, "n"));
	
	List tryBody = new TypedList(new LinkedList(), Stmt.class, false);
	List catches = new TypedList(new LinkedList(), Catch.class, false);
	List catchBody = new TypedList(new LinkedList(), Stmt.class, false);
	catchBody.add(nf.Eval(null, nf.Call(null, nf.Local(null,"rte"), "printStackTrace", emptyArgs)));
	Block catchBlock = nf.Block(null,catchBody);
	Formal aFormal = nf.JL5Formal(null,  emptyFlags, nf.CanonicalTypeNode(null, ts.Exception()), "rte");
	aFormal = aFormal.localInstance(ts.localInstance(null, aFormal.flags(), aFormal.declType(), aFormal.name()));
	
	catches.add(nf.JL5Catch(null, aFormal, catchBlock));
	List argsW2 = new TypedList(new LinkedList(), Expr.class, false);
	List argsW0 = new TypedList(new LinkedList(), Expr.class, false);
	argsW2.add(nf.Local(null, "fallback_target"));
	argsW0.add(nf.IntLit(null, IntLit.INT, 0));
	List whileLoopStmts = new TypedList(new LinkedList(), Stmt.class, false);
	whileLoopStmts.add(nf.Eval(null, nf.Assign(null, nf.Local(null, "n"), Assign.ASSIGN, nf.Call(null, nf.Local(null, "workList"), "get", argsW0))));
	whileLoopStmts.add(nf.Eval(null, nf.Call(null, nf.Local(null, "res"), "add", argsW)));
	d0 = nf.JL5LocalDecl(null, emptyFlags, afldtn, "fields", nf.JL5New(null, afldtn, emptyArgs, null, emptyTypeNodes));
	tryBody.add(d0.localInstance(ts.localInstance(null, d0.flags(), d0.declType(), d0.name())));
	List forLoop1VarD = new TypedList(new LinkedList(), LocalDecl.class, false);
	d0 = nf.JL5LocalDecl(null, emptyFlags, nf.CanonicalTypeNode(null, ts.String()), "fN", null);
	forLoop1VarD.add(d0.localInstance(ts.localInstance(null, d0.flags(), d0.declType(), d0.name())));
	List forLoop1Stmts = new TypedList(new LinkedList(), Stmt.class, false);
	List argsW1 = new TypedList(new LinkedList(), Expr.class, false);
	List argsW1a = new TypedList(new LinkedList(), Expr.class, false);
	argsW1a.add(nf.Local(null, "fN"));
	argsW1.add(nf.Call(null, nf.Local(null, "c"), "getField", argsW1a));
	forLoop1Stmts.add(nf.Eval(null, nf.Call(null, nf.Local(null, "fields"), "add", argsW1)));
	Stmt forLoop1Body = nf.Block(null, forLoop1Stmts);
	Stmt forLoop1 = nf.ExtendedFor(null, forLoop1VarD, nf.Local(null, "fieldNs"), forLoop1Body);
	tryBody.add(forLoop1);
	
	List forLoop2VarD = new TypedList(new LinkedList(), LocalDecl.class, false);
	d0 = nf.JL5LocalDecl(null, emptyFlags, fldtn, "f", null);
	forLoop2VarD.add(d0.localInstance(ts.localInstance(null, d0.flags(), d0.declType(), d0.name())));
	
	List forLoop2Stmts = new TypedList(new LinkedList(), Stmt.class, false);
	
	List argsW2a = new TypedList(new LinkedList(), Expr.class, false);
	List argsW2b = new TypedList(new LinkedList(), Expr.class, false);
	argsW2a.add(nf.Local(null, "fallback_target"));
	argsW2b.add(nf.Local(null, "childN"));
	d0 = nf.JL5LocalDecl(null, emptyFlags, fiTN, "childN", nf.JL5Cast(null, fiTN, nf.Call(null, nf.Local(null, "f"), "get", argsW2a)));
	forLoop2Stmts.add(d0.localInstance(ts.localInstance(null, d0.flags(), d0.declType(), d0.name())));
	Expr forLoop2Ife1 = nf.Unary(null, Unary.NOT, nf.ESJBinary(null, nf.ESJBinary(null, nf.Local(null, "childN"), Binary.EQ, nf.NullLit(null)), Binary.COND_OR, nf.Call(null, nf.Local(null, "res"), "containsPtrEqCmp", argsW2b)));	 	
	Stmt forLoop2Ife2 = nf.Eval(null, nf.Call(null, nf.Local(null, "workList"), "add", argsW2b));			
	forLoop2Stmts.add(nf.JL5If(null, forLoop2Ife1, forLoop2Ife2, null));	
	Stmt forLoop2Body = nf.Block(null, forLoop2Stmts);
	Stmt forLoop2 = nf.ExtendedFor(null, forLoop2VarD, nf.Local(null, "fields"), forLoop2Body);
	tryBody.add(forLoop2);
	d0 = nf.JL5LocalDecl(null, emptyFlags, fiTN, "n",null);
	tryBody.add(d0.localInstance(ts.localInstance(null, d0.flags(), d0.declType(), d0.name())));
	argsW2a.set(0,nf.Local(null, "n"));
	d0 = nf.JL5LocalDecl(null, emptyFlags, fiTN, "childN", nf.JL5Cast(null, fiTN, nf.Call(null, nf.Local(null, "f"), "get", argsW2a)));
	forLoop2Stmts.set(0, d0.localInstance(ts.localInstance(null, d0.flags(), d0.declType(), d0.name())));
	
	forLoop2Body = nf.Block(null, forLoop2Stmts);
	forLoop2 = nf.ExtendedFor(null, forLoop2VarD, nf.Local(null, "fields"), forLoop2Body);
	whileLoopStmts.add(forLoop2);
	whileLoopStmts.add(nf.Eval(null, nf.Call(null, nf.Local(null, "workList"), "remove", argsW)));
	Block whileLoopBody = nf.Block(null, whileLoopStmts);
	tryBody.add(nf.While(null, nf.ESJBinary(null, nf.Call(null, nf.Local(null, "workList"), "size", emptyArgs), Binary.GT, nf.IntLit(null, IntLit.INT, 0)), whileLoopBody));
	List argsWA = new TypedList(new LinkedList(), Expr.class, false);
	argsWA.add(nf.JL5Cast(null, fiTN, nf.Local(null, "fallback_target")));
	
	tryBody.add(nf.JL5If(null, nf.Local(null,"isReflexive"), nf.Eval(null, nf.Call(null, nf.Local(null, "res"), "add", argsWA)), null));
	Block tryBlock = nf.Block(null, tryBody);
	extraMtdBody.add(nf.Try(null, tryBlock, catches));
	extraMtdBody.add(nf.JL5Return(null, nf.Local(null,"res")));
	Block extraMtdBlock = nf.Block(null, extraMtdBody);
	return JL5MethodDeclHelper(null, fl, asettn, "fieldsClosure_" + shortTypeName(fiTp), frms, emptyTypeNodes, extraMtdBlock);	 
    }

    public JL5MethodDecl defineMultiFieldsMtd(FlagAnnotations fl, ESJFieldDecl fi, Type fiTp, TypeNode asettn, TypeNode alisttn, TypeNode fldtn, TypeNode afldtn) throws SemanticException {

	TypeNode fiTN = nf.CanonicalTypeNode(null, fiTp);	
	List extraMtdBody = new TypedList(new LinkedList(), Stmt.class, false);
	LocalDecl d0 = nf.JL5LocalDecl(null, emptyFlags, nf.CanonicalTypeNode(null, ts.Class()), "c", nf.ClassLit(null, fiTN));
	extraMtdBody.add(d0.localInstance(ts.localInstance(null, d0.flags(), d0.declType(), d0.name())));
	List frms = new TypedList(new LinkedList(), Formal.class, false);
	TypeNode strtn = this.StringArrayTN;
	frms.add(nf.JL5Formal(null, emptyFlags, strtn, "fieldNs", true));
	d0 = nf.JL5LocalDecl(null, emptyFlags, asettn, "res", nf.JL5New(null, asettn, emptyArgs, null, emptyTypeNodes));
	extraMtdBody.add(d0.localInstance(ts.localInstance(null, d0.flags(), d0.declType(), d0.name())));	
	List tryBody = new TypedList(new LinkedList(), Stmt.class, false);
	List catches = new TypedList(new LinkedList(), Catch.class, false);
	List catchBody = new TypedList(new LinkedList(), Stmt.class, false);
	catchBody.add(nf.Eval(null, nf.Call(null, nf.Local(null,"rte"), "printStackTrace",
					    emptyArgs)));
	Block catchBlock = nf.Block(null,catchBody);
	Formal aFormal = nf.JL5Formal(null,  emptyFlags, nf.CanonicalTypeNode(null, ts.Exception()), "rte");
	aFormal = aFormal.localInstance(ts.localInstance(null, aFormal.flags(), aFormal.declType(), aFormal.name()));
	catches.add(nf.JL5Catch(null, aFormal, catchBlock));	 
	List forLoop1VarD = new TypedList(new LinkedList(), LocalDecl.class, false);
	d0 = nf.JL5LocalDecl(null, emptyFlags, nf.CanonicalTypeNode(null, ts.String()), "fN", null);
	forLoop1VarD.add(d0.localInstance(ts.localInstance(null, d0.flags(), d0.declType(), d0.name())));
	List forLoop1Stmts = new TypedList(new LinkedList(), Stmt.class, false);
	List argsW1a = new TypedList(new LinkedList(), Expr.class, false);
	List argsW1b = new TypedList(new LinkedList(), Expr.class, false);
	List argsW2a = new TypedList(new LinkedList(), Expr.class, false);	
	argsW1a.add(nf.Local(null, "fN"));
	d0 = nf.JL5LocalDecl(null, emptyFlags, fldtn, "f", nf.Call(null, nf.Local(null, "c"), "getField", argsW1a));
	forLoop1Stmts.add(d0.localInstance(ts.localInstance(null, d0.flags(), d0.declType(), d0.name())));
	argsW2a.add(nf.This(null));
	argsW1b.add(nf.Local(null, "n"));
	d0 = nf.JL5LocalDecl(null, emptyFlags, fiTN, "n", nf.JL5Cast(null, fiTN, nf.Call(null, nf.Local(null, "f"), "get", argsW2a)));
	forLoop1Stmts.add(d0.localInstance(ts.localInstance(null, d0.flags(), d0.declType(), d0.name())));
	
	Expr forLoop2Ife1 = nf.ESJBinary(null, nf.Local(null, "n"), Binary.NE, nf.NullLit(null));	 	 
	Stmt forLoop2Ife2 = nf.Eval(null, nf.Call(null, nf.Local(null, "res"), "add", argsW1b)); 
	
	forLoop1Stmts.add(nf.JL5If(null, forLoop2Ife1, forLoop2Ife2, null));
	Stmt forLoop1Body = nf.Block(null, forLoop1Stmts);
	Stmt forLoop1 = nf.ExtendedFor(null, forLoop1VarD, nf.Local(null, "fieldNs"), forLoop1Body);			
	tryBody.add(forLoop1);
	Block tryBlock = nf.Block(null, tryBody);
	extraMtdBody.add(nf.Try(null, tryBlock, catches));
	extraMtdBody.add(nf.JL5Return(null, nf.Local(null,"res")));
	Block extraMtdBlock = nf.Block(null, extraMtdBody);
	return JL5MethodDeclHelper(null, emptyFlags, asettn, "multiFields_" + shortTypeName(fiTp), frms, emptyTypeNodes, extraMtdBlock);
	
    }

    private void defineFieldUpdateMtd(List l, FlagAnnotations fl2, ESJFieldDecl fi, TypeNode currClassTN, boolean isStatic, boolean isArray) throws SemanticException {
	TypeNode formalTp = null;
	List basicFrms = new TypedList(new LinkedList(), Formal.class, false);
	List updFStmts = new TypedList(new LinkedList(), Stmt.class, false);
	Receiver tgt = isStatic ? currClassTN : nf.This(null);
	Field localF = nf.JL5Field(null, tgt, fi.name());
	Expr right = nf.Local(null, "newVal");
	TypeNode fiTN = fi.type();
	Type fiTp = fi.declType();
	Expr constLock = nf.Local(null, "fallback_consistencyLock");
	if (isArray) {
	    List updFStmts2 = new TypedList(new LinkedList(), Stmt.class, false);
	    List updFStmts3 = new TypedList(new LinkedList(), Stmt.class, false);
	    Type sett = this.ArrayListTP;
	    ParameterizedType pt = ts.parameterizedType((JL5ParsedClassType) sett);
	    ArrayList<Type> at = new ArrayList<Type>();
	    Type t = ((ArrayType) fiTp).base();
	    TypeNode baseTN = nf.CanonicalTypeNode(null, t);
	    //HACK FIXME:
	    boolean baseIsArray = t.isArray();
	    int addDims = 0;
	    Type tDeepBase = t;
	    while (tDeepBase.isArray()) {
		tDeepBase = ((ArrayType) tDeepBase).base();
		addDims++;
	    }
	    boolean isIntCast = isIntCastType(tDeepBase);
	    Type tF;
	    if (isIntCast)
		tF = this.IntTN.type();
	    else
		tF = tDeepBase.isPrimitive() ? ts.typeForName(ts.wrapperTypeString((PrimitiveType) tDeepBase)) : tDeepBase;
	    at.add(tF);
	    pt.typeArguments(at);
	    if (baseIsArray) {
		int ctr1 = addDims;
		while (ctr1-- > 0) {
		    ArrayList<Type> at2 = new ArrayList<Type>();
		    at2.add(pt);
		    ParameterizedType pt2 = ts.parameterizedType((JL5ParsedClassType) sett);
		    pt2.typeArguments(at2);
		    pt = pt2;
		}
	    }
	    LocalDecl d0 = nf.JL5LocalDecl(null, emptyFlags, this.intTN, "i", nf.IntLit(null, IntLit.INT, 0)); 
	    d0 = d0.localInstance(ts.localInstance(null, d0.flags(), d0.declType(), d0.name()));
	    updFStmts2.add(d0);
	    d0 = nf.JL5LocalDecl(null, emptyFlags, this.intTN, "s", nf.Call(null, right, "size", emptyArgs)); 
	    d0 = d0.localInstance(ts.localInstance(null, d0.flags(), d0.declType(), d0.name()));
	    updFStmts2.add(d0);
	    List dimExprsArrNew = new TypedList(new LinkedList(), Expr.class, false);		
	    Local localI = nf.Local(null, "i");
	    Local localS = nf.Local(null, "s");
	    dimExprsArrNew.add(localS);
	    Expr newArrExp = t instanceof TypeVariable ?
		nf.JL5Cast(null, nf.CanonicalTypeNode(null, ts.arrayOf(tDeepBase)), nf.JL5NewArray(null,  this.ObjectTN, dimExprsArrNew, addDims, null)) :
		nf.JL5NewArray(null, nf.CanonicalTypeNode(null, tDeepBase), dimExprsArrNew, addDims, null);
	    Expr p1a = nf.FormulaBinary(null, nf.Binary(null, localF, Binary.EQ, nf.NullLit(null)), Binary.COND_OR, nf.Binary(null, nf.JL5Field(null, localF, "length"), Binary.NE, localS), "or");
	    If p1 = nf.JL5If(null, p1a, nf.Eval(null, nf.Assign(null, localF, Assign.ASSIGN, newArrExp)), null);
	    updFStmts2.add(p1);
	    List whileLoopStmts = new TypedList(new LinkedList(), Stmt.class, false);
	    List whileLoopStmts1 = new TypedList(new LinkedList(), Stmt.class, false);
	    List argsW2a = new TypedList(new LinkedList(), Expr.class, false);		
	    List argsW2b = new TypedList(new LinkedList(), Expr.class, false);
	    argsW2b.add(localI);
	    Expr p0 = nf.Call(null, right, "get", argsW2b);
	    TypeNode f3TN;
	    Expr right3;
	    if (isIntCast) {
		f3TN = this.intTN;
		TypeNode ttn = t.isChar() ? charTN : t.isShort() ? shortTN : byteTN;
		p0 = nf.JL5Cast(null, ttn, nf.Call(null, p0, "intValue", emptyArgs));
		right3 = nf.JL5Cast(null, ttn, right);
	    } else  {
		f3TN = baseTN;
		right3 = right;
	    }
	    Expr pa1 = nf.ArrayAccess(null, localF, localI);
	    if (baseIsArray) {
		//FIXME: dims > 2 not implemented!
		Local loca1 = nf.Local(null, "fallback_l"); 
		Local loca2 = nf.Local(null, "fallback_ls");
		LocalDecl d1 = nf.JL5LocalDecl(null, emptyFlags, nf.CanonicalTypeNode(null, pt.typeArguments().get(0)), "fallback_l", p0);
		LocalDecl d2 = nf.JL5LocalDecl(null, emptyFlags, this.intTN, "fallback_ls", nf.Call(null, loca1, "size", emptyArgs));
		whileLoopStmts1.add(d1.localInstance(ts.localInstance(null, d1.flags(), d1.declType(), d1.name())));
		whileLoopStmts1.add(d2.localInstance(ts.localInstance(null, d2.flags(), d2.declType(), d2.name())));
	    List dimExprsArrNew2 = new TypedList(new LinkedList(), Expr.class, false);		
	    dimExprsArrNew2.add(loca2);
	    whileLoopStmts1.add(nf.Eval(null, nf.Assign(null, pa1, Assign.ASSIGN, nf.JL5NewArray(null, nf.CanonicalTypeNode(null, tDeepBase), dimExprsArrNew2, 0, null))));
	    List fiNs2 = new TypedList(new LinkedList(), VarDeclarator.class, false);
	    String fiN2 = "j_fallback";
	    Local loca3 = nf.Local(null, fiN2);
	    VarDeclarator fiNV2 = new VarDeclarator(null, fiN2);
	    fiNV2.init = nf.IntLit(null, IntLit.INT, 0);
	    fiNs2.add(fiNV2);
	    List varDs2 = variableDeclarators(this.intTN, fiNs2, emptyFlags.classicFlags());
	    Expr forPart42 = nf.Binary(null, nf.Local(null, fiN2), Binary.LT, loca2);
	    List forIfUpd2 = new TypedList(new LinkedList(), Eval.class, false);
	    forIfUpd2.add(nf.Eval(null, nf.Unary(null, Unary.POST_INC, nf.Local(null, fiN2))));
	    Expr pa2 = nf.ArrayAccess(null, pa1, loca3);
	    List forIfStmt12Args = new TypedList(new LinkedList(), Expr.class, false);
	    forIfStmt12Args.add(loca3);
	    Stmt forIfStmt12 = nf.Eval(null, nf.Assign(null, pa2, Assign.ASSIGN, nf.Call(null, loca1, "get", forIfStmt12Args)));
	    whileLoopStmts1.add(nf.For(null, varDs2, forPart42, forIfUpd2, forIfStmt12));
	    } else {
		Stmt whileLoopStmt = nf.Eval(null, nf.Assign(null, pa1, Assign.ASSIGN, p0));
		whileLoopStmts1.add(whileLoopStmt);
	    }
	    whileLoopStmts.addAll(whileLoopStmts1);
	    Eval p2 = nf.Eval(null, nf.Unary(null, Unary.POST_INC, localI));
	    whileLoopStmts.add(p2);
	    Binary p3 = nf.Binary(null, localI, Binary.LT, localS);
	    updFStmts2.add(nf.While(null, p3, nf.Block(null, whileLoopStmts)));
	    Return p4 = nf.Return(null, localF);
	    updFStmts2.add(p4);
	    List basicFrms2 = new TypedList(new LinkedList(), Formal.class, false);
	    TypeNode formalTp2 = nf.CanonicalTypeNode(null, pt);
	    basicFrms2.add(nf.JL5Formal(null, emptyFlags, formalTp2, "newVal"));

	    List basicFrms3 = new TypedList(new LinkedList(), Formal.class, false);
	    basicFrms3.add(nf.JL5Formal(null, emptyFlags, this.intTN, "index"));
	    basicFrms3.add(nf.JL5Formal(null, emptyFlags, f3TN, "newVal"));
	    updFStmts3.add(nf.Eval(null, nf.ArrayAccessAssign(null, nf.ArrayAccess(null, localF, nf.Local(null, "index")), Assign.ASSIGN, right3)));
	    updFStmts3.add(nf.Return(null, right3));
	    Block b1 = nf.Block(null, updFStmts3);
	    Block b2 = nf.Block(null, updFStmts2);
	    l.add(JL5MethodDeclHelper(null, fl2, baseTN, "fallback_updateArrayField_" + fi.name(), basicFrms3, emptyTypeNodes, b1));
	    l.add(JL5MethodDeclHelper(null, fl2, fiTN, "fallback_updateField_" + fi.name(), basicFrms2, emptyTypeNodes, b2));

	} 
	if (isIntCastType(fiTp)) {
	    TypeNode ttn = fiTp.isChar() ? charTN : fiTp.isShort() ? shortTN : byteTN;
	    right = nf.JL5Cast(null, ttn, right);
	    formalTp = this.intTN;
	} else
	    formalTp = fiTp.isPrimitive() ? nf.CanonicalTypeNode(null, ts.typeForName(ts.wrapperTypeString((PrimitiveType) fiTp))) : fiTN;
	updFStmts.add(nf.Return(null, nf.Assign(null, localF, Assign.ASSIGN, right)));       
	basicFrms.add(nf.JL5Formal(null, emptyFlags, formalTp, "newVal"));
	Block b3 = nf.Block(null, updFStmts);
	l.add(JL5MethodDeclHelper(null, fl2, fiTN, "fallback_updateField_" + fi.name(), basicFrms, emptyTypeNodes, b3));
    }


    private void defineFieldGetLogMtd(FlagAnnotations fl, ESJFieldDecl fi, List l, TypeNode currClassTN, String currClassRawName, boolean isStatic, boolean isFinal, boolean isPrimitive, boolean isInt, boolean isBoolean, boolean isArray, boolean isPrimitiveArray, boolean isGeneric, boolean isResultField, boolean isResultFieldFresh) throws SemanticException {
	
	String fiName = fi.name();
	Expr currClLit = nf.ClassLit(null, currClassTN);
	String mtdCallN = isResultField ? "resultGet_log" : "fieldGet_log";
	Local loc = nf.Local(null, "fallback_problem");
	Local loc1 = nf.Local(null, "fallback_targetTypeArgsStr");
	Local loc2 = nf.Local(null, "fallback_targetTypeArgs");
	// add <field>_get_log()
	TypeNode mtdTp = LogExprTN;
	TypeNode idxingTp = null;
	TypeNode fiTN = fi.type();
	Type fiTp = fi.declType();
	Type baseTp0 = fiTp;
	TypeNode fiRawTN = fiTN;
	boolean isGenericClass = currClassTp instanceof JL5ParsedClassType && ((JL5ParsedClassType) currClassTp).isGeneric();
	boolean isTypeVar = false;
	List rangeTypeArgs = new TypedList(new LinkedList(), Expr.class, false);
        Expr rangeTypeArgsArray = nf.NullLit(null);
        Expr rangeTypeArgsNamesArray = nf.NullLit(null);
	int arity = 0;
	if (isArray) {
	    arity++;
	    Type baseTp = ((ArrayType) fiTp).base();
	    //HACK FIXME:
	    while (baseTp.isArray()) {
		baseTp = ((ArrayType) baseTp).base();
		arity++;
	    }
	    baseTp0 = baseTp;
	    if (baseTp instanceof TypeVariable) {
		isTypeVar = true;
		baseTp = ts.Object();
	    }
	    fiRawTN = nf.CanonicalTypeNode(null, baseTp.isPrimitive() ? ts.typeForName(ts.wrapperTypeString((PrimitiveType) baseTp)) : baseTp);
	    idxingTp = this.IntTN;
	} else if (isPrimitive) {
	    fiRawTN = nf.CanonicalTypeNode(null, fiTp.isPrimitive() ? ts.typeForName(ts.wrapperTypeString((PrimitiveType) fiTp)) : fiTp);
	} else if (isGeneric) {
	    //FIXME
	    ParameterizedType fiTp0 = (ParameterizedType) fiTp;
	    List<Type> tAs = (List<Type>) fiTp0.typeArguments();
	    Type baseT = tAs.get(tAs.size() - 1);
	    fiRawTN = nf.CanonicalTypeNode(null, fiTp0.baseType());	    
	    // fix generic relation ranges from parameter to concrete e.g. E.Class -> Point.Class            // HACK FIXME
	    if (baseT.toString().length() > 1)  {		
		for (Type ta : tAs) {
		    if (ta instanceof ParameterizedType)
			ta = ((ParameterizedType) ta).baseType();
		    TypeNode baseTN = nf.CanonicalTypeNode(null, ta);
		    rangeTypeArgs.add(nf.ClassLit(null, baseTN));
		}
	    }
	    rangeTypeArgsArray = typeParametersAsClassArray(fiTp0, nf);
	    rangeTypeArgsNamesArray = typeParametersAsStringArray(fiTp0, nf);
	} else if (fiTp instanceof TypeVariable) {
	    isTypeVar = true;
	    baseTp0 = fiTp;
	    fiRawTN = ObjectTN;
	}
	String fiTpN = typeFullName(baseTp0);
	List frms = new TypedList(new LinkedList(), Formal.class, false);
	List args3p = new TypedList(new LinkedList(), Expr.class, false);
	args3p.add(loc);
	Expr relN = this.nf.StringLit(null, fiName);
	Formal aFormal = nf.JL5Formal(null, emptyFlags, this.LogProblemTN, "fallback_problem");
	aFormal = aFormal.localInstance(ts.localInstance(null, aFormal.flags(), aFormal.declType(), aFormal.name()));	    
	frms.add(aFormal);
	aFormal = nf.JL5Formal(null, emptyFlags, this.LogExprTN, "fallback_target");
	aFormal = aFormal.localInstance(ts.localInstance(null, aFormal.flags(), aFormal.declType(), aFormal.name()));	
	frms.add(aFormal);
	aFormal = nf.JL5Formal(null, emptyFlags, this.StringTN, "fallback_targetTypeArgsStr");
	aFormal = aFormal.localInstance(ts.localInstance(null, aFormal.flags(), aFormal.declType(), aFormal.name()));	
	frms.add(aFormal);
	aFormal = nf.JL5Formal(null, emptyFlags, this.StringArrayTN, "fallback_targetTypeArgs");
	aFormal = aFormal.localInstance(ts.localInstance(null, aFormal.flags(), aFormal.declType(), aFormal.name()));	
	frms.add(aFormal);
	aFormal = nf.JL5Formal(null, emptyFlags, this.booleanTN, "isOld");
	aFormal = aFormal.localInstance(ts.localInstance(null, aFormal.flags(), aFormal.declType(), aFormal.name()));	    
	frms.add(aFormal);
	args3p.add(this.nf.Local(null, "fallback_target"));
	args3p.add(nf.StringLit(null, currClassRawName));
	args3p.add(nf.Local(null, "fallback_targetTypeArgsStr"));
	args3p.add(relN);
	if (!isResultField)
	    args3p.add(isStatic ? nf.BooleanLit(null, false) : nf.Local(null, "isOld"));
	Expr rExp = nf.Call(null, LogMapTN, mtdCallN, args3p);
	if (isInt) {
	} else if (isBoolean) {	    
	    List args4p = new TypedList(new LinkedList(), Expr.class, false);
	    args4p.add(nf.Call(null, loc, "true_log", emptyArgs));
	    rExp = nf.Call(null, rExp, "eq", args4p);
 	}
	// also add relation def for this field as static iniializer
	List args = new TypedList(new LinkedList(), Expr.class, false);
	List relDefBodyArgs = new TypedList(new LinkedList(), Expr.class, false);
	Expr rangeClLit;
	Expr sLit = this.nf.StringLit(null, fiName);
	relDefBodyArgs.add(sLit);
	relDefBodyArgs.add(currClLit); 
	relDefBodyArgs.add(this.nf.StringLit(null, currClassRawName)); 
	relDefBodyArgs.add(nf.ClassLit(null, fiRawTN));	
	relDefBodyArgs.add(nf.StringLit(null, fiTpN));
	relDefBodyArgs.add(rangeTypeArgsArray);
	relDefBodyArgs.add(rangeTypeArgsNamesArray);
	relDefBodyArgs.add(this.nf.BooleanLit(null, isTypeVar));
	relDefBodyArgs.add(this.nf.BooleanLit(null, isStatic));
	relDefBodyArgs.add(nf.IntLit(null, IntLit.INT, arity));
	relDefBodyArgs.add(this.nf.BooleanLit(null, !isFinal));
	if (isResultField) {
	    relDefBodyArgs.add(this.nf.BooleanLit(null, true));
	    relDefBodyArgs.add(this.nf.BooleanLit(null, isResultFieldFresh));
	} else {
	    relDefBodyArgs.add(this.nf.BooleanLit(null, false));
	    relDefBodyArgs.add(this.nf.BooleanLit(null, false));
	}
	relDefBodyArgs.add(this.nf.BooleanLit(null, false));
	relDefBodyArgs.add(this.nf.BooleanLit(null, false));
	String newRelM = isGenericClass ? "newGenericInstVarRel" : "newInstVarRel";
	classInits.add(this.nf.Eval(null,this.nf.Call(null, this.LogMapTN, newRelM, relDefBodyArgs)));
	l.add(JL5MethodDeclHelper(null, fl, mtdTp, fiName + "_get_log", frms, emptyTypeNodes, this.nf.Block(null, nf.JL5Return(null, rExp))));
	if (!isResultField)  {
	    mtdCallN = "oldFieldGet_log";
	    args3p.remove(1);
	    args3p.remove(args3p.size() - 1);
	    frms.remove(1);
	    frms.remove(frms.size() - 1);
	    rExp = nf.Call(null, LogMapTN, mtdCallN, args3p);
	    l.add(JL5MethodDeclHelper(null, fl, this.LogRelTN, fiName + "_old_get_log", frms, emptyTypeNodes, this.nf.Block(null, nf.JL5Return(null, rExp))));
	}
    }

    private void addRelationizeCloneCommitMtds(FlagAnnotations fl, FlagAnnotations fl1, FlagAnnotations fl2, List l, JL5ClassDecl classDecl, TypeNode currClassTN, TypeNode currClassRawTN, String currClassRawName, boolean isOuter, List specFields, boolean isPbjClassSubtype, boolean isPrimitiveClass) throws SemanticException {

	ClassType cTp = classDecl.type();
	boolean isCollection = isOuter && ts.isSubtype(currClassTp, ts.rawify(ts.Iterable()));
	List cloneBody = new TypedList(new LinkedList(), Stmt.class, false);
	List classCloneBody = new TypedList(new LinkedList(), Stmt.class, false);
	LocalDecl d0 = nf.JL5LocalDecl(null, emptyFlags, currClassTN, "res", nf.NullLit(null));
	List argsz = new TypedList(new LinkedList(), Expr.class, false);
	Local loc = nf.Local(null, "fallback_problem");
	Local loc1 = nf.Local(null, "fallback_targetTypeArgsStr");
	Local loc2 = nf.Local(null, "fallback_targetTypeArgs");
	argsz.add(loc);
	cloneBody.add(nf.JL5If(null, nf.Call(null, null, "isCloned", emptyArgs), nf.JL5Return(null, nf.Local(null, "old")), null));
	classCloneBody.add(nf.JL5If(null, nf.Call(null, null, "isClassCloned", emptyArgs), nf.JL5Return(null, null), null));	
	cloneBody.add(d0.localInstance(ts.localInstance(null, d0.flags(), d0.declType(), d0.name())));
	List fbClMtdTry = new TypedList(new LinkedList(), Stmt.class, false);	
	List catches = new TypedList(new LinkedList(), Catch.class, false);
	List catchBody = new TypedList(new LinkedList(), Stmt.class, false);
	catchBody.add(nf.Eval(null, nf.Call(null, nf.Local(null,"rte"), "printStackTrace",
					    emptyArgs)));
	List argsb = new TypedList(new LinkedList(), Expr.class, false);
	argsb.add(nf.IntLit(null, IntLit.INT, 1));
	catchBody.add(nf.Eval(null, nf.Call(null, SystemTN, "exit", argsb)));
	Block catchBlock = nf.Block(null,catchBody);
	Formal aFormal = nf.JL5Formal(null,  emptyFlags, nf.CanonicalTypeNode(null, ts.Exception()), "rte");
	aFormal = aFormal.localInstance(ts.localInstance(null, aFormal.flags(), aFormal.declType(), aFormal.name()));
	catches.add(nf.JL5Catch(null, aFormal, catchBlock));	      
	Expr rhs0 = isPrimitiveClass ? nf.This(null) : nf.JL5Cast(null, currClassTN, nf.Call(null, nf.Super(null), isPbjClassSubtype ? "fallback_clone" : "clone", emptyArgs));
	fbClMtdTry.add(nf.Eval(null, nf.Assign(null, nf.Local(null, "res"), Assign.ASSIGN, rhs0)));
	fbClMtdTry.add(nf.Eval(null, nf.Assign(null, nf.JL5Field(null, nf.Local(null, "res"), "isOld"), Assign.ASSIGN, nf.BooleanLit(null, true))));
	fbClMtdTry.add(nf.Eval(null, nf.Assign(null, nf.JL5Field(null, nf.This(null), "old"), Assign.ASSIGN, nf.Local(null, "res"))));
	fbClMtdTry.add(nf.Eval(null, nf.Assign(null, nf.JL5Field(null, nf.Local(null, "res"), "old"), Assign.ASSIGN, nf.This(null))));
	fbClMtdTry.add(nf.Eval(null, nf.Assign(null, nf.JL5Field(null, nf.This(null), "fallback_consistencyLock"), Assign.ASSIGN, nf.JL5New(null, this.ObjectTN, emptyArgs, null, emptyTypeNodes))));
	fbClMtdTry.add(nf.Eval(null, nf.Assign(null, nf.JL5Field(null, nf.This(null), "clonerStep"), Assign.ASSIGN, nf.Call(null, this.LogMapTN, "clonerStep", emptyArgs))));

	List args = new TypedList(new LinkedList(), Expr.class, false);
	args.add(nf.This(null));
	List atomizeMtdBody = new TypedList(new LinkedList(), Stmt.class, false);
	List classAtomizeMtdBody = new TypedList(new LinkedList(), Stmt.class, false);
	List relationizeOldMtdBody = new TypedList(new LinkedList(), Stmt.class, false);
	List classRelationizeOldMtdBody = new TypedList(new LinkedList(), Stmt.class, false);
	List sArgs = new TypedList(new LinkedList(), Expr.class, false);
	sArgs.add(loc);
	sArgs.add(loc1);
	sArgs.add(loc2);
	if (isPbjClassSubtype) {
	    Type sTp = cTp.superType();
	    atomizeMtdBody.add(nf.Eval(null, nf.Call(null, nf.Super(null), "fallback_atomize", sArgs)));
	    relationizeOldMtdBody.add(nf.Eval(null, nf.Call(null, nf.Super(null), "fallback_relationizeOld", sArgs)));
	    classAtomizeMtdBody.add(nf.Eval(null, nf.Call(null, nf.CanonicalTypeNode(null, sTp), "fallback_classAtomize", sArgs)));
	    classRelationizeOldMtdBody.add(nf.Eval(null, nf.Call(null, nf.CanonicalTypeNode(null, sTp), "fallback_classRelationizeOld", sArgs)));
	}
	atomizeMtdBody.add(nf.Eval(null, nf.Assign(null, nf.JL5Field(null, nf.This(null), "atomizerStep"), Assign.ASSIGN, nf.Call(null, loc, "relationizerStep", emptyArgs))));
	relationizeOldMtdBody.add(nf.Eval(null, nf.Assign(null, nf.JL5Field(null, nf.This(null), "relationizerStep"), Assign.ASSIGN, nf.Call(null, loc, "relationizerStep", emptyArgs))));
	if (isOuter) {
	    cloneBody.add(nf.Eval(null, nf.Call(null, currClassRawTN, "fallback_classClone", emptyArgs)));

	    atomizeMtdBody.add(nf.Eval(null, nf.Call(null, currClassRawTN, "fallback_classAtomize", sArgs)));
	    relationizeOldMtdBody.add(nf.Eval(null, nf.Call(null, currClassRawTN, "fallback_classRelationizeOld", sArgs)));
	}
	classAtomizeMtdBody.add(nf.Eval(null, nf.Assign(null, nf.JL5Field(null, currClassRawTN, "classAtomizerStep"), Assign.ASSIGN, nf.Call(null, loc, "relationizerStep", emptyArgs))));
	classRelationizeOldMtdBody.add(nf.Eval(null, nf.Assign(null, nf.JL5Field(null, currClassRawTN, "classRelationizerStep"), Assign.ASSIGN, nf.Call(null, loc, "relationizerStep", emptyArgs))));

	List atomizeMtdSubBody = new TypedList(new LinkedList(), Stmt.class, false);
	List classAtomizeMtdSubBody = new TypedList(new LinkedList(), Stmt.class, false);
	List relationizeOldMtdSubBody = new TypedList(new LinkedList(), Stmt.class, false);
	List classRelationizeOldMtdSubBody = new TypedList(new LinkedList(), Stmt.class, false);
	List addArgs = new TypedList(new LinkedList(), Expr.class, false);
	addArgs.add(nf.JL5Field(null, nf.This(null), "old"));
	addArgs.add(loc); 
	addArgs.add(loc1);
	atomizeMtdBody.add(nf.Eval(null, nf.Call(null, nf.This(null), "addInstanceForProblem", addArgs)));
	buildRelationizeOldCloneCommitBody(relationizeOldMtdSubBody, classRelationizeOldMtdSubBody, atomizeMtdSubBody, classAtomizeMtdSubBody, relationizeOldMtdBody, classRelationizeOldMtdBody, atomizeMtdBody, classAtomizeMtdBody, fbClMtdTry, classCloneBody, currClassTN, currClassRawTN, currClassRawName, specFields);
	// if its Iterable (a collection) should relationize its elements...
	if (isCollection) {
	    List tAs = ((JL5ParsedClassType) currClassTp).typeVariables();
	    Type baseT = (Type) tAs.get(0);
	    TypeNode baseTN = nf.CanonicalTypeNode(null, baseT);

	    List forLoop1VarD = new TypedList(new LinkedList(), LocalDecl.class, false);
	    d0 = nf.JL5LocalDecl(null, emptyFlags, baseTN, "e", null);
	    forLoop1VarD.add(d0.localInstance(ts.localInstance(null, d0.flags(), d0.declType(), d0.name())));	    
	    Local eloc = nf.Local(null, "e");
	    Expr c1 = nf.JL5Cast(null, this.PBJObjTN, eloc);
	    Expr iof = nf.Instanceof(null, eloc, PBJObjTN);
	    Expr b1 = nf.Binary(null, eloc, Binary.NE, nf.NullLit(null));
	    List args6p = new TypedList(new LinkedList(), Expr.class, false);
	    args6p.add(loc);
	    List argstti = new TypedList(new LinkedList(), Expr.class, false);	    
	    argstti.add(this.nf.ClassLit(null, currClassRawTN));
	    argstti.add(nf.StringLit(null, baseT.toString()));
	    Expr tti = nf.Call(null, this.LogMapTN, "getTypeVariableIndex", argstti);
	    args6p.add(nf.ArrayAccess(null, loc2, tti));
	    args6p.add(nf.NullLit(null)); 
	    Expr call1b = nf.Call(null, c1, "fallback_relationizeOld", args6p);	   
	    relationizeOldMtdBody.add(nf.ExtendedFor(null, forLoop1VarD, nf.This(null), nf.JL5If(null, nf.FormulaBinary(null, b1, Binary.COND_AND, iof, "and"), nf.Eval(null, call1b), null)));	    
	}
	atomizeMtdBody.addAll(atomizeMtdSubBody);
	relationizeOldMtdBody.addAll(relationizeOldMtdSubBody);
	classAtomizeMtdBody.addAll(classAtomizeMtdSubBody);
	classRelationizeOldMtdBody.addAll(classRelationizeOldMtdSubBody);
	List atomizeMtdBodyF = new TypedList(new LinkedList(), Stmt.class, false);
	List classAtomizeMtdBodyF = new TypedList(new LinkedList(), Stmt.class, false);
	List relationizeOldMtdBodyF = new TypedList(new LinkedList(), Stmt.class, false);
	List classRelationizeOldMtdBodyF = new TypedList(new LinkedList(), Stmt.class, false);

	atomizeMtdBodyF.add(nf.JL5If(null, nf.Unary(null, Unary.NOT, nf.Call(null, null, "isAtomized", argsz)), nf.Block(null, atomizeMtdBody), null));
	relationizeOldMtdBodyF.add(nf.JL5If(null, nf.Unary(null, Unary.NOT, nf.Call(null, null, "isRelationized", argsz)), nf.Block(null, relationizeOldMtdBody), null));
	classAtomizeMtdBodyF.add(nf.JL5If(null, nf.Unary(null, Unary.NOT, nf.Call(null, null, "isClassAtomized", argsz)), nf.Block(null, classAtomizeMtdBody), null));
	classRelationizeOldMtdBodyF.add(nf.JL5If(null, nf.Unary(null, Unary.NOT, nf.Call(null, null, "isClassRelationized", argsz)), nf.Block(null, classRelationizeOldMtdBody), null));

	List frms = new TypedList(new LinkedList(), Formal.class, false);
	JL5Formal lf = nf.JL5Formal(null, emptyFlags, this.LogProblemTN, "fallback_problem");
	frms.add(lf.localInstance(ts.localInstance(null, lf.flags(), lf.declType(), lf.name())));
	JL5Formal lf1;
	lf1 = nf.JL5Formal(null, emptyFlags, StringTN, "fallback_targetTypeArgsStr");
	frms.add(lf1.localInstance(ts.localInstance(null, lf1.flags(), lf1.declType(), lf1.name())));
	lf1 = nf.JL5Formal(null, emptyFlags, this.StringArrayTN, "fallback_targetTypeArgs");
	frms.add(lf1.localInstance(ts.localInstance(null, lf1.flags(), lf1.declType(), lf1.name())));
	JL5MethodDecl atomizeMtdDecl = JL5MethodDeclHelper(null, fl, this.VoidTN, "fallback_atomize", frms, emptyTypeNodes, nf.Block(null, atomizeMtdBodyF));	
	JL5MethodDecl relationizeOldMtdDecl = JL5MethodDeclHelper(null, fl, this.VoidTN, "fallback_relationizeOld", frms, emptyTypeNodes, nf.Block(null, relationizeOldMtdBodyF));
	JL5MethodDecl classAtomizeMtdDecl = JL5MethodDeclHelper(null, fl1, this.VoidTN, "fallback_classAtomize", frms, emptyTypeNodes, nf.Block(null, classAtomizeMtdBodyF));
	JL5MethodDecl classRelationizeOldMtdDecl = JL5MethodDeclHelper(null, fl1, this.VoidTN, "fallback_classRelationizeOld", frms, emptyTypeNodes, nf.Block(null, classRelationizeOldMtdBodyF));
	cloneBody.add(nf.Try(null, nf.Block(null, fbClMtdTry), catches));
	cloneBody.add(nf.JL5Return(null, nf.Local(null, "res")));
	Expr consist = nf.JL5Field(null, nf.This(null), "fallback_consistencyLock");	
	JL5MethodDecl cloneMtdDecl = JL5MethodDeclHelper(null, fl, currClassTN, "fallback_clone", emptyFormals, emptyTypeNodes, nf.Block(null, cloneBody));
	JL5MethodDecl classCloneMtdDecl = JL5MethodDeclHelper(null, fl1, this.VoidTN, "fallback_classClone", emptyFormals, emptyTypeNodes, nf.Block(null, classCloneBody));
	List frms0 = new TypedList(new LinkedList(), Formal.class, false);
	l.add(atomizeMtdDecl);
	l.add(relationizeOldMtdDecl);
	if (isOuter) {
	    l.add(classAtomizeMtdDecl);
	    l.add(classRelationizeOldMtdDecl);
	    l.add(classCloneMtdDecl);
	}
	l.add(cloneMtdDecl);

    }

    private ESJMethodDecl JL5MethodDeclHelper(Position pos, FlagAnnotations flags, TypeNode returnType, String name, List formals0, List throwTypes, Block body) throws SemanticException {
	List formals = new TypedList(new LinkedList(), Formal.class, false);
	for (Formal f : (List<Formal>) formals0)
	    formals.add(f.localInstance(ts.localInstance(null, f.flags(), f.declType(), f.name())));
	ESJMethodDecl newMtd = nf.ESJMethodDecl(pos, flags, returnType, name, formals, throwTypes, body, emptyTypeNodes);
	return (ESJMethodDecl) newMtd.methodInstance(newMtd.makeMethodInstance(currClassTp, ts));
    }

    private ESJEnsuredMethodDecl ESJEnsuredMethodDeclHelper(FlagAnnotations fl, Position pos,  JL5MethodDecl m, TypeNode b,
							  Expr requiresExpr, Expr ensuresExpr, 
							  List modifiableFields, Expr modifiableObjects, 
							  List addedObjects) throws SemanticException {
	FlagAnnotations fln = new FlagAnnotations();
	Flags flags = m.flags();
	fln.classicFlags(flags);
	TypeNode cftn = this.nf.CanonicalTypeNode(null, this.ts.Throwable());
	FlagAnnotations fl0 = emptyFlags;
	JL5Formal catchFormal = this.nf.JL5Formal(null, fl0, cftn, "rte");
	catchFormal = (JL5Formal) catchFormal.localInstance(ts.localInstance(null, catchFormal.flags(), catchFormal.declType(), catchFormal.name()));
	JL5LocalDecl resultVar = nf.JL5LocalDecl(null, fl, m.returnType(), "fallback_field_result", null);
	resultVar = (JL5LocalDecl) resultVar.localInstance(ts.localInstance(null, resultVar.flags(), resultVar.declType(), resultVar.name()));
	ESJEnsuredMethodDecl newMtd = this.nf.ESJEnsuredMethodDecl(pos, fln, m.returnType(), m.name(), m.formals(), m.throwTypes(), m.body(), m.paramTypes(), requiresExpr, ensuresExpr, catchFormal, resultVar, modifiableFields, modifiableObjects, addedObjects, false, false);	 
	return (ESJEnsuredMethodDecl) newMtd.methodInstance(newMtd.makeMethodInstance(currClassTp, ts));
    }    


    private ESJConstructorDecl JL5ConstructorDeclHelper(Position pos, FlagAnnotations flags, String name, List formals0, List throwTypes, Block body) throws SemanticException {
	List formals = new TypedList(new LinkedList(), Formal.class, false);
	for (Formal f : (List<Formal>) formals0)
	    formals.add(f.localInstance(ts.localInstance(null, f.flags(), f.declType(), f.name())));
	ESJConstructorDecl newMtd = nf.ESJConstructorDecl(pos, flags, name, formals, throwTypes, body, emptyTypeNodes);
	return (ESJConstructorDecl) newMtd.constructorInstance(newMtd.makeConstructorInstance(currClassTp, ts));
    }

    private ESJPredMethodDecl ESJPredMethodDeclHelper(Position pos, FlagAnnotations flags,
						      TypeNode returnType, String name,
						      List formals0, List throwTypes, Block body, 
						      String quantMtdId, 
						      FormulaBinary.Operator quantKind, 
						      String quantVarN, List quantVarD, 
						      Expr quantListExpr, Expr quantClauseExpr,
						      boolean isSetComprehension, 
						      boolean isSingleComprehension) throws SemanticException {
	List formals = new TypedList(new LinkedList(), Formal.class, false);
	for (Formal f : (List<Formal>) formals0) 
	    formals.add(f.localInstance(ts.localInstance(null, f.flags(), f.declType(), f.name())));
	ESJPredMethodDecl newMtd = nf.ESJPredMethodDecl(pos, flags,returnType, name, formals, 
							throwTypes, body, emptyTypeNodes,
							quantMtdId, quantKind, quantVarN, 
							quantVarD, quantListExpr, 
							quantClauseExpr, isSetComprehension, 
							isSingleComprehension);
	return (ESJPredMethodDecl) newMtd.methodInstance(newMtd.makeMethodInstance(currClassTp, ts));
    }

    private ESJLogPredMethodDecl ESJLogPredMethodDeclHelper(Position pos, FlagAnnotations flags, TypeNode returnType, String name, List formals0, List throwTypes, Block body, List quantVarD, List quantVarD2, boolean isFallBack) throws SemanticException {
	List formals = new TypedList(new LinkedList(), Formal.class, false);
	for (Formal f : (List<Formal>) formals0)
	    formals.add(f.localInstance(ts.localInstance(null, f.flags(), f.declType(), f.name())));
	
	ESJLogPredMethodDecl newMtd = nf.ESJLogPredMethodDecl(pos, flags, returnType, name, formals, throwTypes, body, emptyTypeNodes, quantVarD, quantVarD2, isFallBack);
	return (ESJLogPredMethodDecl) newMtd.methodInstance(newMtd.makeMethodInstance(currClassTp, ts));
    }

    public void buildRelationizeOldCloneCommitBody(List relationizeOldMtdSubBody, List classRelationizeOldMtdSubBody, List atomizeMtdSubBody, List classAtomizeMtdSubBody, List relationizeOldMtdBody, List classRelationizeOldMtdBody, List atomizeMtdBody, List classAtomizeMtdBody, List cloneBody, List classCloneBody, TypeNode currClassTN, TypeNode currClassRawTN, String currClassRawName, List specFields) throws SemanticException {
	Local loc = nf.Local(null, "fallback_problem");

	 for (ESJFieldDecl fi : (List<ESJFieldDecl>) specFields) {
	     if (fi.isResultField())
		 continue;
	     String fiName = fi.name();
	     Type fiType = fi.declType(); 
	     boolean isStatic = fi.flags().isStatic();
	     boolean isFinal = fi.flags().isFinal();
	     boolean isArray = fiType.isArray();
	     boolean dontAddDeepAtomize = false;
	     boolean isPrimitiveWrapper = fiType.isInt() || fiType.isBoolean() || fiType.isChar();
	     boolean isReference = fiType.isReference() && !isArray && !isPrimitiveWrapper;
	     boolean isEnum = isEnum(fiType);
	     List args6p = new TypedList(new LinkedList(), Expr.class, false);
	     args6p.add(loc);
	     Expr arg2 = nf.StringLit(null, ""); 
	     Expr arg3 = nf.NullLit(null);
	     String relUpdMtdName = "";
	     if (fiType instanceof ParameterizedType) {
		 arg2 = typeParametersAsString((ParameterizedType) fiType, nf);
		 arg3 = typeParametersAsStringArray((ParameterizedType) fiType, nf);
	     } else if (isArray) {
		 int dim = 1;
		 Type bTp = ((ArrayType) fiType).base();
		 while (bTp.isArray()) {
		     bTp = ((ArrayType) bTp).base();
		     dim++;
		 }
		 boolean deepBasePrim = false;
		 boolean bPrim = isPrimitive(bTp);
		 if (bPrim) {
		     deepBasePrim = true;
		     dontAddDeepAtomize = true;
		 } else if (isEnum(bTp)) {
		     dontAddDeepAtomize = true;
		 }
		 if (deepBasePrim) {		     
		     if (bPrim) //bTp.isPrimitive())
			 relUpdMtdName = //bTp.toString() 
			     shortTypeName(bTp)
			     + dim + "_array_";
		 } else
		     relUpdMtdName = "array_";
	     } 
	     args6p.add(arg2);
	     args6p.add(arg3);
	     List instVarGetArgs2 = new TypedList(new LinkedList(), Expr.class, false);
	     List instVarGetArgs3 = new TypedList(new LinkedList(), Expr.class, false);
	     Local theOld = nf.Local(null, "old"); 
	     Expr e0b = this.nf.StringLit(null, currClassRawName); 	     
	     Expr e0a;
	     List relationizeOldList = null, atomizeList = null, relationizeOldSubList = null, atomizeSubList = null, cloneList = null;
	     Receiver fieldGetTarget;
	     if (isStatic) {
		 e0a = e0b;
		 fieldGetTarget = currClassRawTN;
		 atomizeSubList = classAtomizeMtdSubBody;
		 atomizeList = classAtomizeMtdBody;
		 relationizeOldSubList = classRelationizeOldMtdSubBody;
		 relationizeOldList = classRelationizeOldMtdBody;
		 cloneList = classCloneBody;
	     } else {
		 e0a = nf.This(null);
		 fieldGetTarget = e0a;
		 atomizeSubList = atomizeMtdSubBody;
		 atomizeList = atomizeMtdBody;
		 relationizeOldSubList = relationizeOldMtdSubBody;
		 relationizeOldList = relationizeOldMtdBody;
		 cloneList = cloneBody;
	     }
	     Expr fldGet = nf.JL5Field(null, fieldGetTarget, fiName);
	     if (isIntCastType(fiType))
		 fldGet = nf.JL5Cast(null, this.intTN, fldGet);
	     fldGet = fldGet.type(fiType);
	     instVarGetArgs2.add(loc);
	     instVarGetArgs2.add(nf.Local(null, "fallback_targetTypeArgsStr"));
	     instVarGetArgs2.add(nf.Local(null, "fallback_targetTypeArgs"));
	     Expr e1 = nf.Call(null, currClassRawTN, fiName + "_old_get_log", instVarGetArgs2);
	     instVarGetArgs3.add(loc);
	     instVarGetArgs3.add(e0a);
	     instVarGetArgs3.add(fldGet);
	     Expr e2 = nf.Call(null, e1, relUpdMtdName + "put_log", instVarGetArgs3);
	     relationizeOldSubList.add(nf.Eval(null, e2));   
	     Expr oldFld = nf.JL5Field(null, nf.Local(null, "old"), fiName);
	     // have to do deep relationizing for reference types... 
	     if (isArray) {
		 Expr f = fldGet; 
		 Expr fieldNullCheck = nf.Binary(null, f, Binary.NE, nf.NullLit(null));
		 Expr forIfStmtE3 = nf.JL5Field(null, nf.Local(null, "res"), fiName);
		 Stmt forStmt1 = buildDeepArrayAtomizeRelationize(f, 0, args6p, fiName, "fallback_atomize");
		 Stmt forStmt2 = buildDeepArrayAtomizeRelationize(f, 0, args6p, fiName, "fallback_relationizeOld");
		 if (dontAddDeepAtomize) {
		 } else {
		     atomizeMtdBody.add(nf.JL5If(null, fieldNullCheck, forStmt1, null));
		     relationizeOldMtdBody.add(nf.JL5If(null, fieldNullCheck, forStmt2, null));
		 }
		 Block cloneListB = buildDeepArrayClone(f, forIfStmtE3, 0, args6p, fiName, isStatic, isFinal);
		 cloneList.add(nf.JL5If(null, fieldNullCheck, cloneListB, null));
	     } else if (isReference && !isEnum) {
		 Receiver rcvr = isStatic ? fieldGetTarget : nf.This(null);
		 Expr fieldExpr = nf.JL5Field(null, rcvr, fiName);
		 Expr ifC = nf.Binary(null, fieldExpr, Binary.NE, nf.NullLit(null));		 
		 Stmt ifT1 = nf.Eval(null, nf.Call(null, fieldExpr,  "fallback_atomize", args6p));
		 Stmt ifT2 = nf.Eval(null, nf.Call(null, fieldExpr,  "fallback_relationizeOld", args6p));
		 atomizeList.add(nf.JL5If(null, ifC, ifT1, null));
		 relationizeOldList.add(nf.JL5If(null, ifC, ifT2, null));
		 Expr thisFldExpr = nf.JL5Field(null, nf.Local(null, "this"), fiName);
		 Expr oldFldExpr = nf.JL5Field(null, nf.Local(null, "old"), fiName);
		 Expr ifT4 = nf.Call(null, fieldExpr, "fallback_clone", emptyArgs);
		 Expr ifT5 = (isFinal || isStatic) ? ifT4 : nf.Assign(null, nf.JL5Field(null, nf.Local(null, "res"), fiName), Assign.ASSIGN, ifT4);
		 cloneList.add(nf.JL5If(null, nf.Binary(null, fieldExpr, Binary.NE, nf.NullLit(null)), nf.Eval(null, ifT5), null));
	     } else if (!isFinal) {
		 if (!isStatic)
		     cloneList.add(nf.Eval(null, nf.Assign(null, nf.JL5Field(null, nf.Local(null, "res"), fiName), Assign.ASSIGN, nf.JL5Field(null, nf.This(null), fiName))));
	     }			    			   
	 }
	 
    }

    Stmt buildDeepArrayAtomizeRelationize(Expr target, int level, List args6p, String fiName, String mKind) {
	Stmt res;
	Type tp = target.type();
	if (tp.isArray()) {	    
	    Type baseTp = ((ArrayType) tp).base();
	    String fiN = "i" + level + "_" + fiName;
	    List fiNs = new TypedList(new LinkedList(), VarDeclarator.class, false);
	    VarDeclarator fiNV = new VarDeclarator(null, fiN);
	    fiNV.init = nf.IntLit(null, IntLit.INT, 0);
	    fiNs.add(fiNV);
	    List varDs = variableDeclarators(this.intTN, fiNs, emptyFlags.classicFlags());
	    Expr lenExpr0 = nf.JL5Field(null, target, "length");
	    Expr forPart4 = nf.Binary(null, nf.Local(null, fiN), Binary.LT, lenExpr0);
	    List forIfUpd = new TypedList(new LinkedList(), Eval.class, false);
	    forIfUpd.add(nf.Eval(null, nf.Unary(null, Unary.POST_INC, nf.Local(null, fiN))));
	    Expr forIfStmtE1 = nf.ArrayAccess(null, target, nf.Local(null, fiN)).type(baseTp);
	    Expr forPart1 = nf.Binary(null, forIfStmtE1, Binary.NE, nf.NullLit(null));
	    if (baseTp instanceof TypeVariable) {
		forPart1 = nf.FormulaBinary(null, forPart1, Binary.COND_AND, nf.Instanceof(null, forIfStmtE1, PBJObjTN), "and");	    
		forIfStmtE1 = nf.JL5Cast(null, this.PBJObjTN, forIfStmtE1).type(baseTp);
	    }
	    Stmt forIfStmt1 = nf.JL5If(null, forPart1, buildDeepArrayAtomizeRelationize(forIfStmtE1, level + 1, args6p, fiName, mKind), null);		 
	    res = nf.For(null, varDs, forPart4, forIfUpd, forIfStmt1);
	} else {
	    res = nf.Eval(null, nf.Call(null, target, mKind, args6p));
	}
	return res;
    }

    Block buildDeepArrayClone(Expr target, Expr resTarget, int level, List args6p, String fiName, boolean isStatic, boolean isFinal) {
	List cloneBodyPart = new TypedList(new LinkedList(), Stmt.class, false);
	Stmt res;
	Type tp = target.type();
	String fiN = "i" + level + "_" + fiName;
	Expr resTargetAA = nf.ArrayAccess(null, resTarget, nf.Local(null, fiN));
	if (tp.isArray()) {	    
	    Type baseTp = ((ArrayType) tp).base();
	    List fiNs = new TypedList(new LinkedList(), VarDeclarator.class, false);
	    VarDeclarator fiNV = new VarDeclarator(null, fiN);
	    fiNV.init = nf.IntLit(null, IntLit.INT, 0);
	    fiNs.add(fiNV);
	    List varDs = variableDeclarators(this.intTN, fiNs, emptyFlags.classicFlags());
	    Expr forIfStmtE1 = nf.ArrayAccess(null, target, nf.Local(null, fiN)).type(baseTp);
	    if (!(isStatic || isFinal)) {
		Expr part1 = nf.Call(null, target,  "clone", emptyArgs);		 
		part1 = nf.Assign(null, resTarget, Assign.ASSIGN,  nf.JL5Cast(null, nf.CanonicalTypeNode(null, target.type()), part1));
		cloneBodyPart.add(nf.Eval(null, part1));
	    }
	    if (!isPrimitiveOrEnumArrayOfBase(baseTp)) {
		Expr forPart1 = nf.Binary(null, forIfStmtE1, Binary.NE, nf.NullLit(null));
		if (baseTp instanceof TypeVariable)
		    forPart1 = nf.FormulaBinary(null, forPart1, Binary.COND_AND, nf.Instanceof(null, forIfStmtE1, PBJObjTN), "and");
		Stmt forIfStmt = nf.JL5If(null, forPart1, buildDeepArrayClone(forIfStmtE1, resTargetAA, level + 1, args6p, fiName, isStatic, isFinal), null);
		List forIfUpd = new TypedList(new LinkedList(), Eval.class, false);
		forIfUpd.add(nf.Eval(null, nf.Unary(null, Unary.POST_INC, nf.Local(null, fiN))));
		Expr lenExpr0 = nf.JL5Field(null, target, "length");
		Expr forPart4 = nf.Binary(null, nf.Local(null, fiN), Binary.LT, lenExpr0);
		cloneBodyPart.add(nf.For(null, varDs, forPart4, forIfUpd, forIfStmt));
	    }
	} else {
	    Expr part0 = nf.Call(null, nf.JL5Cast(null, this.PBJObjTN, target), "fallback_clone", emptyArgs);
	    if (!isStatic)
		part0 = nf.Assign(null, resTarget, Assign.ASSIGN, nf.JL5Cast(null, nf.CanonicalTypeNode(null, tp), part0));
	    cloneBodyPart.add(nf.Eval(null, part0));	
	}
	return nf.Block(null, cloneBodyPart);
    }

    public void addExtraMtdsForSpecMtds(List l, List l1, JL5ClassDecl classDecl, List specMtds) throws SemanticException {
	for (ESJMethodDecl methodDecl : (Collection<ESJMethodDecl>) specMtds)
	    addSpecMtdExtraMtds(l, l1, methodDecl, classDecl);
    }

    public void addInternMtdsForAssumeStmts(FlagAnnotations fl, List l, JL5ClassDecl classDecl, List assumeStmts, List ensuredMtds) throws SemanticException {
	for (ESJAssume assume : (List<ESJAssume>) assumeStmts) {
	    ESJEnsuredMethodDecl m = ESJEnsuredMethodDeclHelper(fl, null,  JL5MethodDeclHelper(null, fl, VoidTN, assume.internMethodName(), emptyFormals, emptyTypeNodes, nf.Block(null, new TypedList(new LinkedList(), Stmt.class, false))), VoidTN, null, assume.cond(), null, null, null);
	    ensuredMtds.add(m);
	    l.add(m);
	}
    }


    // define separate methods for each universal/existential expressions
    // also define relational-logic counterparts, to be used by external solver...
    public void addSpecMtdExtraMtds(List l, List l1, ESJMethodDecl methodDecl, JL5ClassDecl classDecl) throws SemanticException {

	// find the spec_expression subexprs within the body and mark them
	boolean isAbstract = methodDecl.flags().isAbstract();
	Block methodDeclBody = methodDecl.body();
	FlagAnnotations fl = copyJL5MethodDeclFlagAnnotations((JL5MethodDecl_c) methodDecl, isAbstract);
	if (isAbstract) {
	    List logmStmts = new TypedList(new LinkedList(), Stmt.class, false);
	    logmStmts.add(nf.JL5Return(null, nf.NullLit(null)));
	    methodDeclBody = nf.Block(null, logmStmts);
	}
	List both = getSpecExprsWithinBody(methodDecl);
	List specExprs = (List) both.get(0);
	List esjIfs = (List) both.get(1);
	List mStmts = new TypedList(new LinkedList(), Stmt.class, false);
	String mName = methodDecl.name();
	List mFormals = methodDecl.formals();
	TypeNode mReturnType = methodDecl.returnType();
	List mThrowTypes = methodDecl.throwTypes();
	mStmts.add(nf.JL5Return(null, nf.BooleanLit(null,true)));
	//FIXME
	HashMap<String,TypeNode> ambRmvr = new HashMap<String,TypeNode>();
	for (ESJQuantifyExpr a : (List<ESJQuantifyExpr>)specExprs) {
	    a.parentMethod(methodDecl);
	    String quantMtdId = a.id();
	    FormulaBinary.Operator quantKind = a.quantKind();
	    String quantVarN = a.quantVarN();
	    Expr quantList = a.quantListExpr();
	    Expr quantExpr = a.quantClauseExpr();
	    List quantVarD = a.quantVarD();
	    List quantVarD2 = a.quantVarD2();
	    boolean isSetComprehension = a.isSetComprehension();
	    boolean isSingleComprehension = a.isSingleComprehension();
	    List frms = new TypedList(new LinkedList(), Formal.class, false);
	    TypeNode rTp = this.booleanTN;
	    frms.addAll(mFormals);
	    //FIXME: statementlocaltion()
	    HashMap<String,Boolean> seenFrms = new HashMap<String,Boolean>();
	    for (Object ldo : quantVarD2) {
		LocalDecl ld0 = (LocalDecl) ldo;
		seenFrms.put(ld0.name(), true);
	    }
	    if (methodDeclBody instanceof ESJBlock)
		for (Object ldo : ((ESJBlock) methodDeclBody).varDecls(a.statementLocation())) {
		    LocalDecl ld0 = (LocalDecl) ldo;
		    String ldn = ld0.name();
		    if (!seenFrms.containsKey(ldn)) {
			seenFrms.put(ldn, true);
			quantVarD2.add(ld0);
		    }
		}
	    for(LocalDecl d : (List<LocalDecl>)quantVarD)
		ambRmvr.put(d.name(), d.type());
	    for(LocalDecl d : (List<LocalDecl>)quantVarD2) {
		TypeNode dTN = d.type();
		//FIXME
		if (dTN instanceof AmbTypeNode) 
		    dTN = ambRmvr.get(d.name());
		JL5Formal lf = nf.JL5Formal(null, emptyFlags, dTN, d.name());
		frms.add(lf.localInstance(ts.localInstance(null, lf.flags(), lf.declType(), lf.name())));
	    }
	    boolean quantKindIsaCount = quantKind == FormulaBinary.ONE ||
		quantKind == FormulaBinary.LONE;
	    List stmts = new TypedList(new LinkedList(), Stmt.class, false);
	    if (quantKindIsaCount) {
		
		LocalDecl d0 = nf.JL5LocalDecl(null, emptyFlags, this.intTN, "quantCount", nf.IntLit(null, IntLit.INT, 0));
		stmts.add(d0.localInstance(ts.localInstance(null, d0.flags(), d0.declType(), d0.name())));
	    } 
	    stmts.addAll(mStmts);
	    ESJPredMethodDecl extraMtd = 
		ESJPredMethodDeclHelper(null, fl,
					rTp, 
					mName + "_" + quantMtdId, 
					frms, 
					mThrowTypes, 
					nf.Block(null, stmts),
					quantMtdId, quantKind, quantVarN, 
					quantVarD, quantList, quantExpr, 
					isSetComprehension, isSingleComprehension);
	    l.add(extraMtd);
	    
	}
	if (esjIfs.size() > 0) { 
	    int ifCtr = 0;
	    for (ESJIf a : (List<ESJIf>)esjIfs) {
		List frmsLog = new TypedList(new LinkedList(), Formal.class, false);	      
		List frms3 = new TypedList(new LinkedList(), Formal.class, false); 
		JL5Formal lf = nf.JL5Formal(null, emptyFlags, this.LogExprTN, "fallback_target");
		frmsLog.add(lf.localInstance(ts.localInstance(null, lf.flags(), lf.declType(), lf.name())));
		lf = nf.JL5Formal(null, emptyFlags, this.StringTN, "fallback_targetTypeArgs");
		frmsLog.add(lf.localInstance(ts.localInstance(null, lf.flags(), lf.declType(), lf.name())));		
		lf = nf.JL5Formal(null, emptyFlags, this.booleanTN, "fallback_target_isOld");
		frmsLog.add(lf.localInstance(ts.localInstance(null, lf.flags(), lf.declType(), lf.name())));		
		List argsIf = new TypedList(new LinkedList(), Expr.class, false);
		for (Formal f : (List<Formal>) mFormals) {
		    Formal f1 = nf.JL5Formal(null, emptyFlags, this.booleanTN, f.name()+"_isOld");
		    frmsLog.add(f);
		    frmsLog.add(f1.localInstance(ts.localInstance(null, f1.flags(), f1.declType(), f1.name())));
		    frms3.add(f);
		    argsIf.add(nf.Local(null, f.name()));
		}		      
		if (a.enclosingBlock() != null) {
		    //FIXME: statementlocaltion()
		    for (LocalDecl ld : (List<LocalDecl>) a.enclosingBlock().varDecls(a.statementLocation())) {
			Formal f = nf.JL5Formal(null, emptyFlags, ld.type(), ld.name());
			Formal f1 = nf.JL5Formal(null, emptyFlags, this.booleanTN, f.name()+"_isOld");
			f = f.localInstance(ts.localInstance(null, f.flags(), f.declType(), f.name()));
			f1 = f1.localInstance(ts.localInstance(null, f1.flags(), f1.declType(), f1.name()));
			frmsLog.add(f);
			frmsLog.add(f1);
			frms3.add(f);
			argsIf.add(nf.Local(null, ld.name()));
		    }
		}
		if (a.consequent() instanceof Block) {
		    String ifMtdN = mName + "_" + Integer.toString(ifCtr++) ;
		    //FIXME
		    Expr c0a = nf.This(null);
		    c0a = c0a.type(classDecl.type());
		    Expr c0 = nf.Call(null, c0a, ifMtdN, argsIf);
		    c0 = c0.type(mReturnType.type());
		    a.exprConsequent(c0);
		    l.add(JL5MethodDeclHelper(null, fl, mReturnType, ifMtdN, frms3, 
						      methodDecl.throwTypes(), 
						      (Block) a.consequent()));
		    
		    l1.add(ESJLogPredMethodDeclHelper(null, fl, mReturnType, ifMtdN + "_log", 
							     frmsLog, methodDecl.throwTypes(), 
							     (Block) a.consequent(), 
							     null, null, false));
		} 
		if (a.alternative() instanceof Block) {
		    String ifMtdN = mName + "_" + Integer.toString(ifCtr++);
		    //FIXME
		    Expr c0a = nf.This(null);
		    c0a = c0a.type(classDecl.type());
		    Expr c0 = nf.Call(null, c0a, ifMtdN, argsIf);
		    c0 = c0.type(mReturnType.type());
		    a.exprAlternative(c0);
		    l.add(JL5MethodDeclHelper(null, fl, mReturnType, ifMtdN, frms3, 
						      methodDecl.throwTypes(), 
						      (Block) a.alternative()));
		    
		    l1.add(ESJLogPredMethodDeclHelper(null, fl, mReturnType, ifMtdN + "_log", 
							     frmsLog, methodDecl.throwTypes(), 
							     (Block) a.alternative(), 
							     null, null, false));
		    
		} 
	    }
	}
	
	FormulaBinary.Operator quantKind = FormulaBinary.ALL;
	String quantVarN = null;
	List quantVarD = new TypedList(new LinkedList(), LocalDecl.class, false);
	List quantVarD2 = new TypedList(new LinkedList(), LocalDecl.class, false);
	boolean isSetComprehension = false;
	boolean isSingleComprehension = false;
	if (specExprs.size() > 0) {
	    ESJQuantifyExpr a = (ESJQuantifyExpr) specExprs.get(0);
	    quantKind = a.quantKind();
	    quantVarN = a.quantVarN();
	    quantVarD = a.quantVarD();
	    quantVarD2 = a.quantVarD2();
	    isSetComprehension = a.isSetComprehension();
	    isSingleComprehension = a.isSingleComprehension();
	}
	List frms = new TypedList(new LinkedList(), Formal.class, false);
	JL5Formal lfp = nf.JL5Formal(null, emptyFlags, this.LogExprTN, "fallback_target");
	frms.add(lfp.localInstance(ts.localInstance(null, lfp.flags(), lfp.declType(), lfp.name())));
	lfp = nf.JL5Formal(null, emptyFlags, this.StringTN, "fallback_targetTypeArgsStr");
	frms.add(lfp.localInstance(ts.localInstance(null, lfp.flags(), lfp.declType(), lfp.name())));		
	lfp = nf.JL5Formal(null, emptyFlags, this.StringArrayTN, "fallback_targetTypeArgs");
	frms.add(lfp.localInstance(ts.localInstance(null, lfp.flags(), lfp.declType(), lfp.name())));		
	lfp = nf.JL5Formal(null, emptyFlags, this.booleanTN, "fallback_target_isOld");
	frms.add(lfp.localInstance(ts.localInstance(null, lfp.flags(), lfp.declType(), lfp.name())));
	for (Formal f : (List<Formal>) methodDecl.formals()) {
	    frms.add(f);
	    JL5Formal lf = nf.JL5Formal(null, emptyFlags, this.booleanTN, f.name()+"_isOld");
	    frms.add(lf.localInstance(ts.localInstance(null, lf.flags(), lf.declType(), lf.name())));
	}
	ESJLogPredMethodDecl extraLogMtd = 
	    ESJLogPredMethodDeclHelper(null, fl, mReturnType, mName + "_log",  frms, 
				       methodDecl.throwTypes(), null, quantVarD, quantVarD2, false); 
	
	//FIXME
	Block logPredBlock = this.makeESJLogPredBlock(methodDeclBody, quantVarD, quantVarN, extraLogMtd, isSetComprehension, isSingleComprehension);
	extraLogMtd = (ESJLogPredMethodDecl) extraLogMtd.body(logPredBlock);
	l1.add(extraLogMtd);
	
    }
    
     public Block makeESJLogPredBlock(Block body, List quantVarD, String quantVarN, ESJLogPredMethodDecl m, boolean isSetComprehension, boolean isSingleComprehension) throws SemanticException {
	    Block newBody = (Block) makeESJLogPredBlockHelper(body, new TypedList(new LinkedList(), LocalDecl.class, false), m, isSetComprehension, isSingleComprehension);
	    return newBody;
     }    

     public Node makeESJLogPredBlockHelper(Node e, List quantVarD, ESJLogPredMethodDecl m, boolean isSetComprehension, boolean isSingleComprehension) {
     	    if (e instanceof Block) {
		List body = new TypedList(new LinkedList(), Stmt.class, false);
		for (Stmt s : (List<Stmt>) ((Block) e).statements())
		    body.add((Stmt) makeESJLogPredBlockHelper(s, quantVarD, m, isSetComprehension, isSingleComprehension));
		return nf.Block(null, body);
	    } else if (e instanceof Return) {
		return nf.JL5Return(null, (Expr) makeESJLogPredBlockHelper(((Return) e).expr(), quantVarD, m, isSetComprehension, isSingleComprehension));
     	    } else if (e instanceof JL5LocalDecl) {
		JL5LocalDecl l = (JL5LocalDecl) e;
		FlagAnnotations fl = new FlagAnnotations();
		fl = fl.classicFlags(l.flags());
		List annts = l.annotations();
		if (annts != null)
		    fl = fl.annotations(annts);
		LocalDecl d0 = nf.JL5LocalDecl(null, fl, l.type(), l.name(), (Expr) makeESJLogPredBlockHelper(l.init(), quantVarD, m, isSetComprehension, isSingleComprehension));
		return d0.localInstance(ts.localInstance(null, d0.flags(), d0.declType(), d0.name()));
	    } else if (e instanceof FormulaBinary) {
	       	  FormulaBinary b = (FormulaBinary) e;
	       	  FormulaBinary res = nf.FormulaBinary(null, (Expr) makeESJLogPredBlockHelper(b.left(),quantVarD, m, isSetComprehension, isSingleComprehension), b.operator(), (Expr) makeESJLogPredBlockHelper(b.right(), quantVarD, m, isSetComprehension, isSingleComprehension), b.kodkodOp());
		  return res.type(b.type());
	    } else if (e instanceof CmpBinary) {
	       	  CmpBinary b = (CmpBinary) e;
	       	  CmpBinary res = nf.CmpBinary(null, b.left(), b.operator(), b.right(), b.kodkodOp());
		  return res.type(b.type());
	    } else if (e instanceof ESJBinary) {
	       	  ESJBinary b = (ESJBinary) e;
	       	  ESJBinary res = nf.ESJBinary(null, b.left(), b.operator(), b.right(), b.kodkodOp());
		  return res.type(b.type());
	    } else if (e instanceof Conditional) {
		  Conditional c = (Conditional) e;
		  JL5Conditional res = nf.JL5Conditional(null, c.cond(), (Expr) makeESJLogPredBlockHelper(c.consequent(),quantVarD, m, isSetComprehension, isSingleComprehension), (Expr) makeESJLogPredBlockHelper(c.alternative(),quantVarD, m, isSetComprehension, isSingleComprehension));
		  return res.type(c.type());
	    } else if (e instanceof ESJIf) {
		  ESJIf c = (ESJIf) e;
		  ESJIf r = nf.ESJIf(null, c.cond(), (Stmt) makeESJLogPredBlockHelper(c.consequent(),quantVarD, m, isSetComprehension, isSingleComprehension), (Stmt) makeESJLogPredBlockHelper(c.alternative(),quantVarD, m, isSetComprehension, isSingleComprehension));
		  r.exprConsequent(c.exprConsequent());
		  r.exprAlternative(c.exprAlternative());
		  return r;
	    } else if (e instanceof ESJQuantifyExpr) {
	       	  ESJQuantifyExpr q = (ESJQuantifyExpr) e;
		  List quantVarD2 = new TypedList(new LinkedList(), JL5LocalDecl.class, false);
		  getQuantVarDs(q.quantClauseExpr(), quantVarD2);
		  ESJLogQuantifyExpr res = nf.ESJLogQuantifyExpr(null, q.quantKind(), q.quantVarN(), q.quantVarD(), quantVarD2, q.quantListExpr(), (Expr) makeESJLogPredBlockHelper(q.quantClauseExpr(), quantVarD, m, isSetComprehension, isSingleComprehension), m, q.isSetComprehension(), q.isSingleComprehension());
		  res = (ESJLogQuantifyExpr) res.type(q.type());
		  return res;
	    } else {
	      	   return e;
	    }
     }

    // FIXME: spec methods may have same name diff signatures
    private Collection getInvolvedFields(Node n, HashMap specMtdsMap) {
	HashMap involvedFields = new HashMap();
	HashMap seenSpecMtds = new HashMap();
	getInvolvedFieldsH(n, specMtdsMap, involvedFields, seenSpecMtds);
	return involvedFields.values();
    }

    private void getInvolvedFieldsH(Node n, HashMap specMtdsMap, HashMap involvedFields, HashMap seenSpecMtds) {
	//System.out.println("have: " + n.getClass() + " " + n);
	if (n instanceof Block) {
	    for (Stmt s : (List<Stmt>) ((Block) n).statements())
		getInvolvedFieldsH(s, specMtdsMap, involvedFields, seenSpecMtds);
	} else if (n instanceof Return) {
	    getInvolvedFieldsH(((Return) n).expr() , specMtdsMap, involvedFields, seenSpecMtds);
	} else if (n instanceof LocalDecl)
	    getInvolvedFieldsH(((LocalDecl) n).init() , specMtdsMap, involvedFields, seenSpecMtds);
	else if (n instanceof Binary) {
	    Binary c = (Binary) n;
	    getInvolvedFieldsH(c.left(), specMtdsMap, involvedFields, seenSpecMtds);
	    getInvolvedFieldsH(c.right(), specMtdsMap, involvedFields, seenSpecMtds);
	} else if (n instanceof Unary) {
	    getInvolvedFieldsH(((Unary) n).expr(), specMtdsMap, involvedFields, seenSpecMtds);
	} else if (n instanceof Cast) {
	    getInvolvedFieldsH(((Cast) n).expr(), specMtdsMap, involvedFields, seenSpecMtds);
	} else if (n instanceof Conditional) {
	    Conditional c = (Conditional) n;
	    getInvolvedFieldsH(c.consequent(), specMtdsMap, involvedFields, seenSpecMtds);
	    getInvolvedFieldsH(c.alternative(), specMtdsMap, involvedFields, seenSpecMtds);
	} else if (n instanceof Call) {
	    Call c = (Call) n;
	    if (c.target() instanceof Special) {
		String cN = c.name();
		if (specMtdsMap.containsKey(cN) && !seenSpecMtds.containsKey(cN)) {
		    seenSpecMtds.put(cN, true);
		    getInvolvedFieldsH(((MethodDecl) specMtdsMap.get(cN)).body(), specMtdsMap, involvedFields, seenSpecMtds);
		}
	    } else
		getInvolvedFieldsH(c.target(), specMtdsMap, involvedFields, seenSpecMtds);
	} else if (n instanceof ESJQuantifyExpr) {
	    ESJQuantifyExpr q = (ESJQuantifyExpr) n;
	    getInvolvedFieldsH(q.quantListExpr(), specMtdsMap, involvedFields, seenSpecMtds);
	    getInvolvedFieldsH(q.quantClauseExpr(), specMtdsMap, involvedFields, seenSpecMtds);
	} else if (n instanceof Field) {
	    Field c = (Field) n;
	    if (c.target() instanceof Special) {
		Type ct = c.type();
		if (!(isPrimitive(ct) || ct.isArray() || isEnum(ct)))
		    if (!(c.name().equals("fallback_field_result"))) //FIXME
			involvedFields.put(c.name(), n);
	    } else 
		getInvolvedFieldsH(c.target(), specMtdsMap, involvedFields, seenSpecMtds);
	}
    }

     // FIXME
     void getQuantVarDs(Node e, List quantVarD2) {
	 if (e instanceof Block) {
	     for (Stmt s : (List<Stmt>) ((Block) e).statements())
		 getQuantVarDs(s, quantVarD2);
	 } else if (e instanceof Return) {
	     getQuantVarDs(((Return) e).expr(), quantVarD2);
	 } else if (e instanceof JL5LocalDecl) {
	     getQuantVarDs(((JL5LocalDecl) e).init(), quantVarD2);
	 } else if (e instanceof FormulaBinary) {
	     FormulaBinary b = (FormulaBinary) e;
	     getQuantVarDs(b.left(), quantVarD2);
	     getQuantVarDs(b.right(), quantVarD2);		      
	 } else if (e instanceof Conditional) {
	     Conditional c = (Conditional) e;
	     getQuantVarDs(c.consequent(), quantVarD2);
	     getQuantVarDs(c.alternative(), quantVarD2);		      
	 } else if (e instanceof ESJIf) {
	     ESJIf c = (ESJIf) e;
	     getQuantVarDs(c.consequent(), quantVarD2);
	     getQuantVarDs(c.alternative(), quantVarD2); 
	 } else if (e instanceof ESJQuantifyExpr) {
	     for (JL5LocalDecl d : (List<JL5LocalDecl>) ((ESJQuantifyExpr) e).quantVarD()) {
		 JL5LocalDecl dn = nf.JL5LocalDecl(null, emptyFlags, d.type(), d.name(), null);
		 dn = (JL5LocalDecl) dn.localInstance(ts.localInstance(null, Flags.NONE,
								       d.type().type(), d.name()));
		 quantVarD2.add(dn);
	     }
	 }
     }

    public List getSpecExprsWithinBody(JL5MethodDecl methodDecl) {
	List both = new TypedList(new LinkedList(), List.class, false);
	List predSubExprs = new TypedList(new LinkedList(), ESJQuantifyExpr.class, false);
	List esjIfs = new TypedList(new LinkedList(), ESJIf.class, false);
	getSpecExprsWithinBodyHelper(methodDecl.body(), predSubExprs, esjIfs, 0);	
	both.add(predSubExprs);
	both.add(esjIfs);
	return both;
    }
    
    public void getSpecExprsWithinBodyHelper(Node n, List predSubExprs, List esjIfs, int pc) {
	 if (n instanceof Block) {
	     for (Stmt s : (List<Stmt>) ((Block) n).statements())
		 getSpecExprsWithinBodyHelper(s, predSubExprs, esjIfs, pc++);
	 } else if (n instanceof Return) {
	     getSpecExprsWithinBodyHelper(((Return)n).expr(), predSubExprs, esjIfs, pc);
	 } else if (n instanceof JL5LocalDecl) {
	     getSpecExprsWithinBodyHelper(((LocalDecl)n).init(), predSubExprs, esjIfs, pc);
	 } else if (n instanceof Binary) {
	     getSpecExprsWithinBodyHelper(((Binary)n).left(), predSubExprs, esjIfs, pc);
	     getSpecExprsWithinBodyHelper(((Binary)n).right(), predSubExprs, esjIfs, pc);
	 } else if (n instanceof Unary) {
	     getSpecExprsWithinBodyHelper(((Unary)n).expr(), predSubExprs, esjIfs, pc);
	 } else if (n instanceof Conditional) {
	     getSpecExprsWithinBodyHelper(((Conditional)n).consequent(), predSubExprs, esjIfs, pc);
	     getSpecExprsWithinBodyHelper(((Conditional)n).alternative(), predSubExprs, esjIfs, pc);
	 } else if (n instanceof ESJIf) {
	     ESJIf i = (ESJIf) n;
	     i.statementLocation(pc);
	     getSpecExprsWithinBodyHelper(i.consequent(), predSubExprs, esjIfs, pc);
	     getSpecExprsWithinBodyHelper(i.alternative(), predSubExprs, esjIfs, pc);
	     esjIfs.add(n);
	 } else if (n instanceof ESJQuantifyExpr) {
	     ESJQuantifyExpr q = (ESJQuantifyExpr) n;
	     q.statementLocation(pc);
	     predSubExprs.add(n);
	     getSpecExprsWithinBodyHelper(q.quantClauseExpr(), predSubExprs, esjIfs, pc);
	 } 
     }

     Expr fixModifiableObjectsExpr(Expr modifiableObjects) {
	 Expr res = modifiableObjects;
	 if (modifiableObjects instanceof Call) {
	     Call c = (Call) modifiableObjects;
	     if (c.target() == null || c.target() instanceof Special) 
		 res = nf.Call(null, nf.ESJField(null, nf.This(null), "old"), c.name(), c.arguments());
	 } 
	 return res;
     }

	private Expr defaultValue(Type fiType) {
	    boolean isInt = fiType.isNumeric();
	    boolean isBoolean = fiType.isBoolean();
	    Expr def = isInt ? nf.IntLit(null, IntLit.INT, 0) : 
		isBoolean ? nf.BooleanLit(null, false) :
		nf.NullLit(null);
	    return def;
	}

    private TypeNode getGenericTypeNode(Type t) {
	if (t instanceof ParsedClassType && 
	    ((JL5ParsedClassType) t).typeVariables() != null) {
	    JL5ParsedClassType tp = (JL5ParsedClassType) t;
	    ParameterizedType pt = ts.parameterizedType(tp);
	    ArrayList<Type> at = new ArrayList<Type>();
	    for (TypeVariable p : (List<TypeVariable>) tp.typeVariables())
		at.add(p);
	    pt.typeArguments(at);
	    t = pt;	    
	}
	return nf.CanonicalTypeNode(null, t);
    }

    static List<Flags> makePublicFlags() {
	List<Flags> fs3 = new ArrayList<Flags>();
	fs3.add(Flags.PUBLIC);
	return fs3;
    }

    static FlagAnnotations makePublicFlagAnnotations() {
	List<Flags> fs3 = makePublicFlags();
	return makeFlagAnnotations(fs3);
    }
    
    static FlagAnnotations makePublicFlagAnnotationsPlus(Flags f) {
	List<Flags> fs3 = makePublicFlags();
	fs3.add(f);
	return makeFlagAnnotations(fs3);
    }
            
    static FlagAnnotations makeFlagAnnotations(List<Flags> fs) {
	FlagAnnotations fl = new FlagAnnotations(); 
	for (Flags f: fs)
	    fl.classicFlags(f);
	fl.annotations(new TypedList(new LinkedList(), AnnotationElem.class, false));
	return fl;
    }	      
    
    static FlagAnnotations copyJL5MethodDeclFlagAnnotations(MethodDecl methodDecl, boolean isAbstract) {
	 FlagAnnotations fl = new FlagAnnotations();
	 Flags fs = methodDecl.flags();
	 fl = fl.classicFlags(isAbstract ? fs.clearAbstract() : fs); 
	 List annts = ((JL5MethodDecl_c) methodDecl).annotations();
	 if (annts != null)
	     fl = fl.annotations(annts);
	 return fl;
     }

    public List variableDeclarators(TypeNode a, List b, Flags flags)
    {
	List l = new TypedList(new LinkedList(), LocalDecl.class, false);
	for (Iterator i = b.iterator(); i.hasNext(); ) {
	    VarDeclarator d = (VarDeclarator) i.next();
	    LocalDecl d0 = nf.LocalDecl(null, flags, a, d.name, d.init);	    
	    l.add(d0.localInstance(ts.localInstance(null, d0.flags(), d0.declType(), d0.name())));
	}
	return l;
    }

    public static Expr typeParametersAsStringArray(ParameterizedType pt, ESJNodeFactory nf) {
	List l0 =  new TypedList(new LinkedList(), Expr.class, false);		 
	for (Type p : (List<Type>) pt.typeArguments())
	    l0.add(nf.StringLit(null, p.toString()));
	return nf.JL5NewArray(null, StringTN, Collections.EMPTY_LIST, 1, nf.ArrayInit(null, l0));
    }

    public static Expr typeParametersAsClassArray(ParameterizedType pt, ESJNodeFactory nf) {
	List l0 =  new TypedList(new LinkedList(), Expr.class, false);		 
	for (Type p : (List<Type>) pt.typeArguments())
	    l0.add(nf.ClassLit(null, nf.CanonicalTypeNode(null, p)));
	return nf.JL5NewArray(null, ClassTN, Collections.EMPTY_LIST, 1, nf.ArrayInit(null, l0));
    }

    public static StringLit typeParametersAsString(ParameterizedType pt, ESJNodeFactory nf) {
	String res = "<";
	String addr = "";
	for (Type p : (List<Type>) pt.typeArguments()) {
	    res += addr + p.toString();
	    addr = ", ";
	}
	return nf.StringLit(null, res + ">");
    }

    //HACK FIXME
    public boolean implementsPBJInternObject(ReferenceType tp) {
	boolean res;
	String tpn = tp.toString();
	if (pbjObjClassImpls.containsKey(tpn))
	    res = pbjObjClassImpls.get(tpn);
	else {
	    res = true;
	    try {
		ts.findField(tp, "fallback_pbnj");
	    } catch (SemanticException e) {
		res = false;
	    }
	    pbjObjClassImpls.put(tpn, res);
	}
	return res;
    }

    public static String typeFullName(Type t) {
	String res = "";
	if (t.isArray()) {
	    Type baseTp = ((ArrayType) t).base();
	    res = baseTp.toString();
	}  else {
	    res = t.toString();
	}
	return res;
    }

    public static String shortTypeName(Type t) { 
	String longName = t.toString();
	if (t.isArray())
	    longName = longName.substring(0, longName.length() - 2);
	int pi = longName.lastIndexOf(46); // char '.'
	longName = pi == -1 ? longName : longName.substring(pi+1);
	pi = longName.indexOf(60); // char '<'
	return pi == -1 ? longName : longName.substring(0, pi);
    }

    public boolean isPrimitive(Type t) { 
	return t.isPrimitive() || t == ts.String() || t.isNumeric() || t.isBoolean() || t.isChar();
    }

    boolean isPrimitiveOrEnumArrayOfBase(Type base) {
	while (base.isArray())
	    base = ((ArrayType) base).base();
	return isPrimitive(base) || isEnum(base);
    }

    public boolean isIntCastType(Type t) { 
	return t.isChar() || t.isShort() || t.isByte();
    }

    public boolean isEnum(Type t) {
	return t instanceof ClassType && JL5Flags.isEnumModifier(((ClassType) t).flags());
    }

}



