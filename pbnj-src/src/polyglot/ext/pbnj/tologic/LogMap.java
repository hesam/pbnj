package polyglot.ext.pbnj.tologic;

import polyglot.ext.pbnj.primitives.*;

import java.util.AbstractCollection;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Collection;
import java.util.Iterator;

import java.io.CharArrayWriter;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import kodkod.ast.Node;
import kodkod.ast.Formula;
import kodkod.ast.operator.FormulaOperator;
import kodkod.ast.Expression;
import kodkod.ast.IntExpression;
import kodkod.ast.Relation;
import kodkod.ast.IntConstant;
import kodkod.instance.TupleFactory;
import kodkod.instance.TupleSet;
import kodkod.instance.Tuple;
import kodkod.instance.Bounds;
import kodkod.instance.Universe;
import kodkod.instance.Instance;
import kodkod.engine.Solver;
import kodkod.engine.Solution;
import kodkod.engine.Proof;
import kodkod.engine.satlab.SATFactory;
import kodkod.engine.config.Options;
import kodkod.engine.fol2sat.TranslationRecord;

public class LogMap {

    static SATFactory SolverOpt_Solver = SATFactory.Glucose;//MiniSat;
    static SATFactory[] SolverOpt_Solvers = new SATFactory[7];
    static { 
	SolverOpt_Solvers[0] = SATFactory.LightSAT4J; 
	SolverOpt_Solvers[1] = SATFactory.DefaultSAT4J; 
	SolverOpt_Solvers[2] = SATFactory.MiniSat; 
	SolverOpt_Solvers[3] = SATFactory.MiniSatProver; 
	SolverOpt_Solvers[4] = SATFactory.Glucose;//ZChaffMincost;
	SolverOpt_Solvers[5] = SATFactory.CryptoMiniSat;
	SolverOpt_Solvers[6] = SATFactory.Lingeling;
    }
    public static SATFactory SolverOpt_Prover = SATFactory.MiniSatProver;
    public static boolean SolverOpt_FallbackProof = false;
    public static boolean SolverOpt_FallbackUnsatProof = true;
    public static String SolverOpt_Host = "localhost";
    public static int SolverOpt_Port = 9128;
    public static String SolverOpt_Flatten = "false";
    public static int SolverOpt_IntBitWidth = 8;
    public static boolean SolverOpt_NaturalIntsOnly = false;
    public static boolean SolverOpt_IncludeCharType = false;
    public static int SolverOpt_SymmetryBreaking = 10;
    public static int SolverOpt_ArrayMaxSize = 10;
    public static int SolverOpt_ArrayMaxSizeGrowth = 0;
    public static int SolverOpt_debugLevel = 0;
    public static boolean SolverOpt_debug1 = false, SolverOpt_debug2 = false, SolverOpt_debug3 = false;
    public static boolean SolverOpt_Kodkod = true;
    public static boolean SolverOpt_Prove = false;

    public static int clonerStep; // time steps get incremented when ensured mtd is run

    static HashMap<String,HashMap<String,LogRelation>> InstVarRels = new HashMap<String,HashMap<String,LogRelation>>(); // Holds inst var relations for each class
    static HashMap<String,Class> InvolvedClasses = new HashMap<String,Class>(); // Holds atoms for each class
    static HashMap<String,Class> InvolvedPrimitives = new HashMap<String,Class>(); // Holds atoms for each primitive type
    static {
	InvolvedPrimitives.put("int", Integer.class);
	InvolvedPrimitives.put("java.lang.Integer", Integer.class);
	InvolvedPrimitives.put("char", Character.class);
    }
    static HashMap ClassConstrs = new HashMap(); // Holds class constr for each class
    static HashMap<String,List> Enums = new HashMap<String,List>(); // Holds enums
    static HashMap<Class,List> ClassInstances = new HashMap<Class,List>(); // Holds instances of each class
    static HashMap<Class,HashMap<String,Integer>> GenericClassTypeVars = new HashMap<Class,HashMap<String,Integer>>(); 
    static HashMap<Class,HashMap<String,List>> newParameterizedGenericClassWaitList = new HashMap<Class,HashMap<String,List>>();
    static HashMap<String,Boolean> FixedParameterizedGenericRels = new HashMap<String,Boolean>();
    static HashMap<Class,HashMap<String,LogRelation>> GenericClassInstVars = new HashMap<Class,HashMap<String,LogRelation>>();
    public static int SolverOpt_debugLevel() { return SolverOpt_debugLevel; }
    public static boolean SolverOpt_debug1() { return SolverOpt_debug1; }
    public static boolean SolverOpt_debug2() { return SolverOpt_debug2; }
    public static boolean SolverOpt_debug3() { return SolverOpt_debug3; }
    public static boolean SolverOpt_Prove() { return SolverOpt_Prove; }
    public static boolean SolverOpt_Kodkod() { return SolverOpt_Kodkod; }
    public static void SolverOpt_Kodkod(boolean b) { SolverOpt_Kodkod = b; }
    public static void SolverOpt_Solver(SATFactory s) { SolverOpt_Solver = s; }
    public static void SolverOpt_SolverNum(int n) { 
	if (n < SolverOpt_Solvers.length) 
	    SolverOpt_Solver = SolverOpt_Solvers[n]; 
	if (SolverOpt_Solver.prover()) {
	    SolverOpt_Prove = true;	
	}
    }
    public static void SolverOpt_EnableProver() { 
	SolverOpt_Solver = SolverOpt_Prover;
	SolverOpt_Prove = true;	
    }

    public static void SolverOpt_EnableFallbackProof() { 
	SolverOpt_EnableProver();	
	SolverOpt_FallbackProof = true;	
    }

    public static void SolverOpt_SymmetryBreaking(int s) { SolverOpt_SymmetryBreaking = s; }

    public static void SolverOpt_debugLevel(int l) {
	SolverOpt_debugLevel = l;
	if (l > 0)
	    SolverOpt_debug1 = true;
	if (l > 1)
	    SolverOpt_debug2 = true;
	if (l > 2)
	    SolverOpt_debug3 = true;

    }

    public static int clonerStep() { return clonerStep; }
    public static void incrClonerStep() { clonerStep++; }

    public static HashMap<Class,List> ClassInstances() { return ClassInstances; } 
    public static HashMap<String,Class> InvolvedClasses() { return InvolvedClasses; }

    public static LogProblem initRelationize() {
	LogProblem p = new LogProblem(InvolvedClasses, Enums);	
	return p;
    }

    public static void inits() {
	PBJInternInteger.setBitWidth(null, LogMap.SolverOpt_IntBitWidth);
    }
    public static void newClassForLog(Class c, boolean ext) {
	newClassForLog(c, ext, new String[]{});
    }

    public static void newClassForLog(Class c0, boolean ext, String... typeVars) {
	String c = shortClassName(c0);
	if (SolverOpt_debug2)
	    System.out.println("new class for log: " + c);
	if (ext && typeVars.length > 0) {
	    HashMap<String,Integer> tpvs = new HashMap<String,Integer>();
	    for (int i = 0; i < typeVars.length; i++)
		tpvs.put(typeVars[i], i);
	    GenericClassTypeVars.put(c0, tpvs);
	}
	if (!(InvolvedClasses.containsKey(c) || 
	      isPrimitive(c)
	      )) {
	    ClassInstances.put(c0, new ArrayList());
	    try {
		InvolvedClasses.put(c, c0);
		if (c0.isEnum()) {
		    ArrayList es = new ArrayList();
		    for (Object e : c0.getEnumConstants())
			es.add(e);
		    Enums.put(c, es);
		}
	    } catch (Exception e) { System.out.println(e); System.exit(1); }		
	    if (!InstVarRels.containsKey(c)) {
		InstVarRels.put(c, new HashMap<String,LogRelation>());
	    }
	}
    }

    public static void newClassForLogInnerClasses(Class c) {
	for (Class innerC : c.getDeclaredClasses())
	    newClassForLog(innerC, false);
    }
    
    public static LogRelation newInstVarRel(String instVar, Class domain, String domainName, 
					    Class range, String rangeName, 
					    Class[] typeArgs, String[] typeArgNames,
					    boolean isRangeTypeVar, boolean isStatic, 
					    int arity, boolean isUnknown, 
					    boolean isResultVar, boolean isFreshResult, 
					    boolean isGeneric, boolean isOld) {
	// mark parameterized generic type
	if (!(isOld || typeArgs == null)) {
	    newParameterizedGenericClass(range, rangeName, typeArgs, typeArgNames);
	}
	boolean isArray = arity > 0;
	Boolean alsoNewOld = !(isOld || isResultVar);
	String k = instVar;
	//boolean isaIndexableCollection = isArray;
	int relSize = arity + 2; //isaIndexableCollection ? 3 : 2;
	if (isResultVar) {
	    relSize--;
	} else if (isOld) {
	    k += "_old";
	    // mark enum and class
	    newClassForLog(range, false);
	}
	String rN = domainName
	    + "." + k;
	Relation r2 = Relation.nary(rN, relSize);
	if (SolverOpt_debug2) {
	    System.out.println(instVar + " " + domain + ":" + domainName + " " + range + ":" + rangeName);
	    System.out.println(InstVarRels);
	}
	LogRelation r = new LogRelation(instVar,
					domain, domainName,
					range, rangeName,
					typeArgNames,
					r2, isRangeTypeVar,
					isStatic, isArray, relSize, isOld, isUnknown, isResultVar, isFreshResult, 0);
	if (!isGeneric) {
	    InstVarRels.get(domainName).put(k,r);
	    if (alsoNewOld) {
		r.old(newInstVarRel(instVar,
				    domain,
				    domainName,
				    range, 
				    rangeName,
				    typeArgs,
				    typeArgNames,
				    isRangeTypeVar, 
				    isStatic, arity, false, isResultVar, isFreshResult, isGeneric, true));
	    }
	}
	return r;
    }

    public static LogRelation newGenericInstVarRel(String instVar, Class domain, 
						   String domainName, Class range, 
						   String rangeName, Class[] typeArgs, 
						   String[] typeArgNames,
						   boolean isRangeTypeVar,  boolean isStatic, 
						   int arity, boolean isUnknown, 
						   boolean isResultVar, boolean isFreshResult, 
						   boolean isGeneric, boolean isOld) {
	HashMap<String,LogRelation> vars;
	if (GenericClassInstVars.containsKey(domain))
	    vars = GenericClassInstVars.get(domain);
	else {
	    vars = new HashMap<String,LogRelation>();
	    GenericClassInstVars.put(domain, vars);
	}
	LogRelation r = newInstVarRel(instVar, domain, domainName, range, rangeName, typeArgs, typeArgNames, isRangeTypeVar, isStatic, arity, isUnknown, isResultVar, isFreshResult, true, isOld);
	vars.put(instVar, r);
	if (newParameterizedGenericClassWaitList.containsKey(domain)) {
	    HashMap<String,List> ls = newParameterizedGenericClassWaitList.get(domain);
	    if (SolverOpt_debug2)
		System.out.println("there is a wait list for new generic instance: " + domain + ": " + ls);
	    for (String cn: ls.keySet()) {
		List l = ls.get(cn);
		newParameterizedGenericClass(domain, cn, (Class[]) l.get(0), (String[]) l.get(1));
	    }
	}
	return r;	
    }

    public static void newParameterizedGenericClass(Class c, String className, Class[] typeArgs, String[] typeArgNames) {
	if (!GenericClassInstVars.containsKey(c)) {
	    HashMap<String,List> genericClassInstances;
	    if (newParameterizedGenericClassWaitList.containsKey(c))
		genericClassInstances = newParameterizedGenericClassWaitList.get(c);
	    else {
		genericClassInstances = new HashMap<String,List>();
		newParameterizedGenericClassWaitList.put(c, genericClassInstances);
	    }
	    List l = new ArrayList();
	    l.add(typeArgs);
	    l.add(typeArgNames);
	    genericClassInstances.put(className, l);
	    return;
	}
	if (SolverOpt_debug2)
	    System.out.println("generic instance: " + c + " " + className);
	if (!InstVarRels.containsKey(className)) {
	    InstVarRels.put(className, new HashMap<String,LogRelation>());
	    InvolvedClasses.put(className, c);
	}
	HashMap<String,LogRelation> genRs = GenericClassInstVars.get(c);
	if (SolverOpt_debug2)
	    System.out.println(genRs);
	for (String v: genRs.keySet()) { 
	    LogRelation genR = genRs.get(v);
	    String rn = className + "." + genR.instVar();
	    if (FixedParameterizedGenericRels.containsKey(rn))
		continue;
	    FixedParameterizedGenericRels.put(rn, true);
	    String rangeName = genR.rangeName;
	    Class range = genR.range;
	    if (genR.isRangeTypeVar) {
		if (SolverOpt_debug2) {
		    System.out.println(InvolvedClasses);		    
		    System.out.println("have to fix range! " + rangeName);
		}
		int idx = getTypeVariableIndex(c, rangeName);
		rangeName = typeArgNames[idx];
		range = typeArgs[idx];
		if (!isPrimitive(rangeName))
		    newClassForLog(range, false);
		if (SolverOpt_debug2)
		    System.out.println("fix: " + rangeName);
	    }
	    LogRelation r = newInstVarRel(genR.instVar, genR.domain, className, range, rangeName, typeArgs, typeArgNames, false, genR.isStatic, genR.arity() - 2, genR.isUnknown, genR.isResultVar, genR.isFreshResultVar(), false, genR.isOld);
	    if (SolverOpt_debug2)
		System.out.println("produced " + r);
	}
    }

    public static Relation instVarRel_log(LogProblem p, String c0, 
					  String targetTypeArgs,
					  String instVar, 
					  boolean isOld) {
	String c = c0 + targetTypeArgs;
	LogRelation r = instVarRel_log1(p, c, instVar, isOld);
	if (SolverOpt_debug3)
	    System.out.println("look up rel: " + c + "." + instVar + " (type arg: " + targetTypeArgs + ")" + " --> " + r);
	r.id(p); // marks it involved rel
	return r.kodkodRel();
    }

    public static LogRelation instVarRel_log1(LogProblem p, String c,
					      String instVar, 
					      boolean isOld) {
	
	LogRelation r = instVarRel_log0(c, instVar);
	if (isOld)
	    r = r.old();
	return r;
    }

    //FIXME
    public static LogRelation instVarRel_log0(String c, String instVar) {
	if (SolverOpt_debug3)
	    System.out.println(InstVarRels + " ? c = " + c + " . " + instVar);
	return InstVarRels.get(c).get(instVar);
    }

    public static LogRelation instVarRelOld_log0(String c, String instVar) {
	LogRelation r = instVarRel_log0(c, instVar);
	return r.old();
    }

    public static LogExpr fieldGet_log(LogProblem p, LogExpr target, String targetType, 
				       String targetTypeArgs,
				       String instVar, 
				       boolean isOld) {
	Relation s2 = instVarRel_log(p, targetType, targetTypeArgs, instVar,
				     isOld);
	return new LogExpr(p, target.expr().join(s2));
    }

    public static LogRelation oldFieldGet_log(LogProblem p, String targetType, 
				       String targetTypeArgs,
				       String instVar) {
	return instVarRel_log1(p, targetType + targetTypeArgs, instVar, true);
    }

    public static LogExpr resultGet_log(LogProblem p, LogExpr target, String targetType, 
					String targetTypeArgs, String instVar
					) {
	return new LogExpr(p, instVarRel_log(p, targetType, targetTypeArgs, instVar,  
					  false));
    }

    public static LogExpr fieldGetClosure_log(LogProblem p, LogExpr obj, String targetType, String targetTypeArgs, boolean isOld, boolean isSimple, boolean isReflexive, String... instVars) {
	Expression fNs = instVarRel_log(p, targetType, targetTypeArgs, instVars[0], 
					isOld);
	for(int i=1;i<instVars.length;i++)
	    fNs = fNs.union(instVarRel_log(p, targetType, targetTypeArgs, instVars[i], 
					   isOld));
	Expression s1 = obj.expr();
	if (!isSimple)
	    if (isReflexive)
		fNs = fNs.reflexiveClosure();
	    else
		fNs = fNs.closure();
	Expression res = s1.join(fNs).difference(p.classRels.get(null));
	return new LogExpr(p, res);
    }

    public static boolean isGeneric(Class c) {
	return GenericClassTypeVars.containsKey(c);
    }

    public static int getTypeVariableIndex(Class c, String typeVar) {
	if (SolverOpt_debug3)
	    System.out.println("getTypeVariableIndex " + c + " " + typeVar + "\n" + GenericClassTypeVars);
	return GenericClassTypeVars.get(c).get(typeVar);
    }

    public static String getGenericParamActualArg(Class c, String param, String[] typeArgs) {
	int idx = getTypeVariableIndex(c, param); 
	if (SolverOpt_debug2) {
	    System.out.println("c=" + c + " param=" + param + " typeArgs=" + Arrays.toString(typeArgs));
	    System.out.println(GenericClassTypeVars);
	    System.out.println(typeArgs[idx]);
	    System.out.println(InvolvedClasses);
	    System.out.println(ClassInstances);
	}
	return typeArgs[idx];
    }
    
    public static void addInstance(Class c, Object o) { 
// 	if (SolverOpt_debug2) {
// 	    System.out.println("addInstace: c=" + c + " " + ClassInstances);
// 	}
	ClassInstances.get(c).add(o); 
    }

    //FIXME
    public static List allInstances(Class c) { 
	return 
	    isPrimitive(c) ? PBJInternInteger.allInstances() : ClassInstances.get(c); }
    public static List allInstances(String c) { return 
	    allInstances(isPrimitive(c) ? InvolvedPrimitives.get(c) : InvolvedClasses.get(c)); }
    public static Object instantiateNewObj(PBJInternObject obj, Class c, String[] domainTypeParamNamesArray) {
	Object [] args = new Object[1];
	args[0] = new LogExpr(null, null, null, null);
	Object o = null;
	try {
	    Constructor cons;	    
	    if (ClassConstrs.containsKey(c))
		cons = (Constructor) ClassConstrs.get(c);
	    else {
		Class[] parameterTypes = new Class[1];
		parameterTypes[0] = LogExpr.class;
		cons = c.getConstructor(parameterTypes);
		ClassConstrs.put(c, cons);
	    }
	    if (SolverOpt_debug2)
		System.out.println(obj.getClass() + " making new " + c + " " + Arrays.toString(domainTypeParamNamesArray));
	    o = obj.fallback_newInstance(cons, args, domainTypeParamNamesArray);
	} catch (Exception e) { e.printStackTrace(); System.exit(1); }
	return o;
    }

    public static String shortClassName(Class c) { 
	return c.getCanonicalName();
    }

    public static String shortClassName0(Class c) { 
	String longName = c.getName();
	int pi = longName.lastIndexOf('.');
	String midName = pi == -1 ? longName : longName.substring(pi+1);
	pi = midName.lastIndexOf('$');
	return pi == -1 ? midName : midName.substring(pi+1);
    }

    static boolean isPrimitive(Class c) {
	return c == Integer.class || c == Character.class;    
    }
    static boolean isPrimitive(String c) {
	return InvolvedPrimitives.containsKey(c);
    }

}
