package polyglot.ext.pbnj.tologic;

import polyglot.ext.pbnj.primitives.*;

import java.util.AbstractCollection;
import java.util.Map;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
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

public class LogProblem {
    public HashMap<String, Boolean> modifiableFields;
    public HashSet<Integer> problemAtoms;  // kodkod atoms
    public Bounds problemBounds; // kodkod bounds
    public TupleFactory problemFactory; // kodkod factory
    public Formula problemFunDefs;
    public ArrayList problemUnknowns;
    public HashMap problemRels; // Holds relations for given problem
    public Instance problemModel; // stores solution
    public HashMap<String,Class> InvolvedClasses; // 
    public HashMap<String,List<Integer>> ClassAtoms; // Holds atoms for each class
    public HashMap<String,List> Enums; // Holds enums
    public HashMap<String,List> classInstances2; // Holds instances of each class reachable from falling back object
    public HashMap<Object,Relation> classRels; // Holds kodkod relations for each class
    public HashMap<String,List> classNewInstAtoms; // Holds atoms for new instances for each class
    public HashMap<Class,List<Class>> InvolvedSuperClasses; // mark superclasses
    public HashMap<Class,Class> InvolvedSubClasses; // mark subclasses
    public HashMap<Class,List<Class>> SuperClassFreshInstances; // to know which subclass to instantiate
    private static HashMap<String,Iterator<Solution>> solvedSolutions = new HashMap<String,Iterator<Solution>>();
    private static HashMap<String,Bounds> solvedProblemBounds = new HashMap<String,Bounds>();
    private static HashMap<String,ArrayList> solvedProblemUnknowns = new HashMap<String,ArrayList>();

    public int atomCtr; // mapping of objs to number ids
    public static int relationizerStep; // time steps get incremented when ensured mtd is run
    public IdentityHashMap<Object,Integer> JtoLog;  // Java Objs to Solver Atoms
    public HashMap<Integer,Object> LogtoJ;  
    public HashMap<String,Integer> freshInstances;
    public HashMap<Object,TupleSet> classTupleSetsWithNull; 
    public HashMap<Object,TupleSet> classTupleSetsNoNull; 
    public LogProblem(HashMap<String,Class> InvolvedClasses, HashMap<String,List> Enums) {
	this.Enums = Enums;
	this.InvolvedClasses = InvolvedClasses;
	this.JtoLog = new IdentityHashMap<Object,Integer>();
	this.LogtoJ = new HashMap<Integer,Object>();
	this.problemAtoms = new HashSet();       
	this.classRels = new HashMap<Object,Relation>(); 
	this.classNewInstAtoms = new HashMap<String,List>();
	this.problemRels = new HashMap();
	relationizerStep++;
	this.classInstances2 = new HashMap<String,List>();
	PBJInternInteger.setBitWidth(this, LogMap.SolverOpt_IntBitWidth);
	this.atomCtr = this.setNullAndBooleanAtomsAt(PBJInternInteger.MAX_VALUE+1);	
	this.ClassAtoms = new HashMap<String,List<Integer>>();
	for (String c : InvolvedClasses.keySet())
	    this.classInstances2.put(c, new ArrayList());
	classTupleSetsWithNull = new HashMap<Object,TupleSet>();
	classTupleSetsNoNull = new HashMap<Object,TupleSet>();
	this.InvolvedSuperClasses = new HashMap<Class,List<Class>>();
	this.InvolvedSubClasses = new HashMap<Class,Class>();
	this.SuperClassFreshInstances = new HashMap<Class,List<Class>>();
    }

    public int relationizerStep() { return relationizerStep; }
    public void incrRelationizerStep() { relationizerStep++; }
    public HashMap problemRels() { return problemRels; }
    public TupleFactory problemFactory() { return problemFactory; }
    public Bounds problemBounds() { return problemBounds; }
    public HashMap<Object,Relation> classRels() { return classRels; }

    public void ObjToAtomMap() {
	if (LogMap.SolverOpt_debug2) {
	    System.out.println("classes: " + InvolvedClasses);
	    if (freshInstances != null)
		System.out.println("fresh instances: " + freshInstances);

	}
	for (String c : InvolvedClasses.keySet()) {
	    boolean isSubclass = false;
	    // mark a subclass...
	    Class ic = InvolvedClasses.get(c);
	    Type st = ic.getGenericSuperclass();
	    Class sc = null;
	    if (st instanceof Class) {
		sc = (Class) st;
		if (sc != Object.class) {
		    isSubclass = true;
		    List<Class> scs;
		    if (InvolvedSuperClasses.containsKey(sc))
			scs = InvolvedSuperClasses.get(sc);
		    else {
			scs = new ArrayList<Class>();
			InvolvedSuperClasses.put(sc, scs);
		    }
		    InvolvedSubClasses.put(ic, sc);
		    scs.add(ic);
		}
	    }

	    // make atoms from objs
	    boolean isEnum = Enums.containsKey(c); //c.isEnum();
	    // reset rels FIXME	   
	    if (!isEnum) 
		for (LogRelation r : LogMap.InstVarRels.get(c).values())
		    r.clear();
	    ClassAtoms.put(c, new ArrayList());
	    boolean newObjsAllowed = freshInstances != null && freshInstances.containsKey(c);
	    if (newObjsAllowed) {
		classNewInstAtoms.put(c, new ArrayList());
		if (isSubclass) {
		    List<Class> scs;
		    if (SuperClassFreshInstances.containsKey(sc))
			scs = SuperClassFreshInstances.get(sc);
		    else {
			scs = new ArrayList<Class>();
			SuperClassFreshInstances.put(sc, scs);
		    }
		    scs.add(ic);
		    if (LogMap.SolverOpt_debug2)
			System.out.println(sc + " can instantiate new obj of subclass " + ic);

		}
	    }
	    if (LogMap.SolverOpt_debug2 && newObjsAllowed)
		System.out.println(c + " can instantiate " + freshInstances.get(c) + " new obj.");
	    newAtoms(c, isEnum, newObjsAllowed ? freshInstances.get(c) : 0);
	}
	if (LogMap.SolverOpt_debug2) {
	    System.out.println(" JtoLog --> " + JtoLog);
	    System.out.println(" InstVarRels  --> " + LogMap.InstVarRels);
	    System.out.println(" InvolvedClasses  --> " + InvolvedClasses);
	}
    }


    public void newAtoms(String c, boolean isEnum, int newInstances) { // FIXME?
	if (LogMap.SolverOpt_debug2)
	    System.out.println("initing class: " + c + " (ctr=" + atomCtr + ")" + "\n");
	List<Integer> classAs = ClassAtoms.get(c);
	LogtoJ.put(atomCtr, c);
	put1(c, atomCtr++);
	try {
	    List objs = isEnum ? Enums.get(c) : classInstances2.get(c);
	    if (LogMap.SolverOpt_debug2)
		System.out.println("objs: " + objs);	    
	    // let the instance do updating for class static fields:
	    if (objs.size() > 0)
		LogtoJ.put(atomCtr - 1, objs.get(0));
	    Class ic = InvolvedClasses.get(c);
	    boolean isSubclass = false;
	    boolean isSuperclass = false;
	    String sc = null;
	    if (InvolvedSubClasses.containsKey(ic)) {
		isSubclass = true;
		sc = InvolvedSubClasses.get(ic).getCanonicalName();
	    } else if (InvolvedSuperClasses.containsKey(ic)) 
		isSuperclass = true;
	    boolean isSubtyping = isSubclass || isSuperclass;
	    for (Object obj : objs) {
		// if obj is subtype of another class it may have been already atomized here: 
		if (isSubtyping && JtoLog.containsKey(obj)) {
		    classAs.add(get1(obj));
		} else {
		    classAs.add(atomCtr);
		    LogtoJ.put(atomCtr,obj);
		    put1(obj,atomCtr);
		    if (!isEnum) {
			PBJInternObject o = (PBJInternObject) obj;
			if (o.old() != null)
			    put1(o.old(), atomCtr);
		    }
		    atomCtr++;
		}
	    }
	    // include subclass instances for superclass
	    if (isSubclass) {
		List<Integer> sClassAs;
		if (ClassAtoms.containsKey(sc))
		    sClassAs = ClassAtoms.get(sc);
		else {
		    sClassAs = new ArrayList();
		    ClassAtoms.put(sc, sClassAs);
		}
		sClassAs.addAll(classAs);
	    }
	    int i = newInstances;
	    if (i > 0) {
		List classNIAs = classNewInstAtoms.get(c);
		Class icp = ic;
		// FIXME: if its a superclass mark to instantiate a subclass 
		if (isSuperclass && SuperClassFreshInstances.containsKey(ic))
		    icp = SuperClassFreshInstances.get(ic).get(0); //HACK FIXME: picking first one!
		while (i-- > 0) {
		    int a = atomCtr++;
		    problemAtoms.add(a);
		    classAs.add(a);
		    classNIAs.add(a);
		    LogtoJ.put(a, icp);
		}
		// include subclass instances for superclass
		if (isSubclass) {
		    List sClassNIAs; 
		    if (classNewInstAtoms.containsKey(sc))  
			sClassNIAs = classNewInstAtoms.get(sc);
		    else {
			sClassNIAs = new ArrayList();
			classNewInstAtoms.put(sc, sClassNIAs);
		    }
		    sClassNIAs.addAll(classNIAs);
		}
	    }

	} catch (Exception e) { e.printStackTrace(); System.exit(1); }
    }

    public void addToClassInstances(Object o, Class c, String type0, String typeArgs) { 	
	String type = type0 + typeArgs;
	if (LogMap.SolverOpt_debug3) {
	    System.out.println("add to class insts: " + o + " " + c  + " " + type);
	    System.out.println(classInstances2.get(type) + " ? " + classInstances2.get(type).contains(o));
	}
	classInstances2.get(type).add(o); 
    }


    public void initRelations() {

	// init kodkod problem
	Universe universe = new Universe(problemAtoms);
	this.problemFactory = universe.factory();
	this.problemBounds = new Bounds(universe);

	// integer, char, boolean bounds
	this.primitiveTypeBounds_log();

	HashMap<String,Boolean> seen = new HashMap<String,Boolean>();
	for (String c : InvolvedClasses.keySet()) {	    
	    // a singleton relation for class itself (used for static fields)
	    Class ic = InvolvedClasses.get(c);
	    String rn = ic.toString();
	    if (seen.containsKey(rn))
		continue;
	    Relation classRel = Relation.unary(rn);
	    TupleSet classRel_upper = problemFactory.noneOf(1);
	    classRel_upper.add(problemFactory.tuple(get1(c)));
	    problemBounds.boundExactly(classRel, classRel_upper);
	    classRels.put(rn, classRel);
	    seen.put(rn, true);
	}
	if (LogMap.SolverOpt_debug2)
	    System.out.println(classRels);	
    }

    public LogExpr objToSingletonRelation_log(Object obj) {
	Relation objRel;
	if (classRels.containsKey(obj))
	    objRel = classRels.get(obj);
	else {
	    Integer objAtom = get1(obj);
	    objRel = Relation.unary("A" + objAtom);
	    TupleSet obj_upper = problemFactory.noneOf(1);
	    obj_upper.add(problemFactory.tuple(objAtom));
	    problemBounds.boundExactly(objRel, obj_upper);
	    classRels.put(obj, objRel);
	}
	return new LogExpr(this, objRel); 
    }
    
    public LogExpr intToSingletonRelation_log(Integer i) {
        return new LogExpr(this, IntConstant.constant(i));
    }

    public LogExpr intToSingletonRelation_log(Short i) {
        return new LogExpr(this, IntConstant.constant((int) i));
    }

    public LogExpr intToSingletonRelation_log(Byte i) {
        return new LogExpr(this, IntConstant.constant((int) i));
    }

    public LogExpr booleanToSingletonRelation_log(boolean i) {
        return new LogExpr(this, kodkodBoolean_log(i));
    }

    public LogExpr arrayToRelation_log(Object[] obj) {
	return arrayToRelation_log0(obj, null, obj.length, false);
    }

    public LogExpr arrayToRelation_log(int[] obj) {
	return arrayToRelation_log0(null, obj, obj.length, true);
    }

    public LogExpr arrayToRelation_log0(Object[] obj0, int[] obj1, int len, boolean isInt) {
	return new LogExpr(this, arrayToRelationH_log(obj0, obj1, len, isInt));
    }
    public Relation arrayToRelationH_log(Object[] obj0, int[] obj1, int len, boolean isInt) {
	Object obj = isInt ? obj1 : obj0;
	Relation objRel;
	if (classRels.containsKey(obj))
	    objRel = classRels.get(obj);
	else {
	    objRel = Relation.nary("A" + atomCtr++, 2);
	    TupleSet obj_upper = problemFactory.noneOf(2);
	    if (isInt) {
		for (int i = 0; i < len; i++)
		    obj_upper.add(problemFactory.tuple(get1(i)).product(problemFactory.tuple(get1(obj1[i]))));
	    } else {
		for (int i = 0; i < len; i++)
		    obj_upper.add(problemFactory.tuple(get1(i)).product(problemFactory.tuple(get1(obj0[i]))));
	    }
	    problemBounds.boundExactly(objRel, obj_upper);
	    classRels.put(obj, objRel);
	}
	return objRel; 
    }

    public void primitiveTypeBounds_log() {
      
      Relation Ints = Relation.unary("java.lang.Integer"); 
      TupleSet Ints_upper = problemFactory.noneOf(1);

      int i;      
      Relation Chars = Relation.unary("Chars");
      TupleSet Chars_upper = problemFactory.noneOf(1);
      for(i=PBJInternInteger.MIN_VALUE;i<0;i++) {
	  Object ti = i;
	  problemBounds.boundExactly(i,problemFactory.range(problemFactory.tuple(ti),problemFactory.tuple(ti)));
	  Ints_upper.add(problemFactory.tuple(ti));
      }
      if (PBJInternInteger.MAX_VALUE >= 128)
	  for(;i<128;i++) {
	      Object ti = i;
	      problemBounds.boundExactly(i,problemFactory.range(problemFactory.tuple(ti),problemFactory.tuple(ti)));
	      Ints_upper.add(problemFactory.tuple(ti));
	      Chars_upper.add(problemFactory.tuple(ti));
	  }
      for(;i<=PBJInternInteger.MAX_VALUE;i++) {
	  Object ti = i;
	  problemBounds.boundExactly(i,problemFactory.range(problemFactory.tuple(ti),problemFactory.tuple(ti)));
	  Ints_upper.add(problemFactory.tuple(ti));
      }
      
      problemBounds.boundExactly(Ints, Ints_upper);
      classRels.put("int", Ints); 
      classRels.put("java.lang.Integer", Ints);
      classRels.put("short", Ints); 
      classRels.put("java.lang.Short", Ints);
      classRels.put("byte", Ints); 
      classRels.put("java.lang.Byte", Ints);

      if (LogMap.SolverOpt_IncludeCharType) {
	  problemBounds.boundExactly(Chars, Chars_upper);
	  classRels.put("char", Chars); 
	  classRels.put("Character", Chars);
      }

      // add Null relation
      Relation Null = Relation.unary("Null");
      TupleSet Null_upper = problemFactory.noneOf(1);
      Null_upper.add(problemFactory.tuple(get1(null))); 
      problemBounds.boundExactly(Null, Null_upper);
      classRels.put(null,Null);
      
      // add True, False, Boolean relation
      Relation True = Relation.unary("True");
      TupleSet True_upper = problemFactory.noneOf(1);
      True_upper.add(problemFactory.tuple(get1(true)));
      problemBounds.boundExactly(True, True_upper);
      classRels.put(true, True);
      Relation False = Relation.unary("False");
      TupleSet False_upper = problemFactory.noneOf(1);
      False_upper.add(problemFactory.tuple(get1(false)));
      problemBounds.boundExactly(False, False_upper);
      classRels.put(false, False);
      Relation Boolean = Relation.unary("Boolean");
      TupleSet Boolean_upper = problemFactory.noneOf(1);
      Boolean_upper.add(problemFactory.tuple(get1(true)));
      Boolean_upper.add(problemFactory.tuple(get1(false)));
      problemBounds.boundExactly(Boolean, Boolean_upper);
      classRels.put("boolean",Boolean);
      classRels.put("Boolean",Boolean);

    }


    public void put0(Object key, int value) { 
	JtoLog.put(key, value);
    }

    public void put1(Object key, int value) { 
	JtoLog.put(key, value);
	problemAtoms.add(value);
    }

    public void put1p(Object key, int value) { 
	problemAtoms.add(value);
    }

    public int get1(Object key) {
	// HACK FIXME: boxed primitives (Integer > 127) doesnt have same id every time! 
	if (key instanceof Integer || key instanceof Byte || key instanceof Short) 
	    return (Integer) key;
	if (LogMap.SolverOpt_debug3) {
	    System.out.println("get1: " + key);
	    System.out.println(" --> " + JtoLog.get(key));
	    //System.out.println(JtoLog);
	}
	Object res = JtoLog.get(key);
	if (res == null) {
	    Class kc = key.getClass();
	    System.out.println(key + " : " + kc + " is not in Java-to-Logic pointer map." + ((kc == Integer.class) ? " Since this is a number consider increasing Integer bit width for solver by invoking polyglot.ext.pbnj.tologic.LogMap.SolverOpt_IntBitWidth(int) method." : ""));
	    System.out.println(JtoLog);
	    new Throwable().printStackTrace();
	    System.exit(1);	    
	}
	return (Integer) res;
    }

    public void put2(int key, Object value) { 
	LogtoJ.put(key, value);
    }

    public Object get2(int key) { 
	if (LogMap.SolverOpt_debug3) {
	    System.out.println("get2: " + key);
	    //System.out.println(" --> " + LogtoJ.get(key));
	    //System.out.println(LogtoJ);
	}
	return LogtoJ.get(key);
    }

    public int setNullAndBooleanAtomsAt(int i) {
	LogtoJ.put(i,null);
	put1(null,i++);
	LogtoJ.put(i,true);
	put1(true,i++);
	LogtoJ.put(i,false);
	put1(false,i);
	return i+1;
    }


    public LogExpr null_log() { return new LogExpr(this, classRels.get(null)); }
    public LogExpr true_log() { return new LogExpr(this, classRels.get(true)); }
    public LogExpr false_log() { return new LogExpr(this, classRels.get(false)); }
    public Formula kodkodBoolean_log(boolean b) { return b ? kodkod.ast.Formula.TRUE : kodkod.ast.Formula.FALSE; }
    public LogExpr ints_log() { return new LogExpr(this, classRels.get("int")); }
    public LogExpr class_log(Class c) { return new LogExpr(this, classRels.get(c.toString())); } //c.getName() + ".class")); }
    public LogExpr freshInstances_log(Class c) { return new LogExpr(this, classRels.get(c.getName() + " fresh")); }

    public void newModifiableFields() { 
	modifiableFields = new HashMap<String, Boolean>();	
    }

    public void setModifiableField(String f) {	    
	modifiableFields.put(f, true);
    }

    public void newFreshInstances() { 
	freshInstances = new HashMap<String,Integer>();	
    }

    public void setFreshInstances(String c, int num) {	    
	freshInstances.put(c, num);
    }

    public boolean solve(String callingMethod,
			 PBJInternObject obj, Formula formula, Collection<?> modifiableObjects, 
			 boolean isFreshResult, boolean solveAll, long startMethodTime, boolean extractCoreForDebug) {
	boolean doSolve = true;
	Solution sol = null;
	Formula finalFormula = null;
	if (solveAll) {
	    if (solvedSolutions.containsKey(callingMethod)) {
		Iterator<Solution> currentSolvedSolutions = solvedSolutions.get(callingMethod);
		doSolve = false;
		if (currentSolvedSolutions.hasNext()) {
		    sol = currentSolvedSolutions.next();
		    problemBounds = solvedProblemBounds.get(callingMethod);
		    problemUnknowns = solvedProblemUnknowns.get(callingMethod);
		} else {
		    System.out.println("getting UNSAT because already iterated over all solutions...");
		    return false;		    
		}
	    } 
	}
	if (doSolve) {
	    problemUnknowns = new ArrayList<LogRelation>();
	    String spacer = "\n";
	    Set probRels = new HashSet(problemRels.keySet());
	    if (LogMap.SolverOpt_debug1) {
		System.out.println("problem involves rels: ");
		for (Object k : probRels) {
		    LogRelation r =  (LogRelation) problemRels.get(k);
		    System.out.println(r.getId() + ": " + r.toString());
		}
		if (modifiableFields != null) 
		    System.out.println("modifiable fields: " + modifiableFields);
		if (modifiableObjects != null)
		    System.out.println("modifiable objs: " + modifiableObjects);
	    }       
	
	    for (Object k : probRels) {
		LogRelation r =  (LogRelation) problemRels.get(k);
		r.setBounds(this, r.kodkodRel(), modifiableFields, modifiableObjects != null ? get1s(modifiableObjects) : null, isFreshResult);
	    }

	    Solver solver = new Solver();
	    Options opts = solver.options();
	    opts.setSolver(LogMap.SolverOpt_Solver);
	    if (LogMap.SolverOpt_Prove) {
		opts.setLogTranslation(1);
		if (extractCoreForDebug) {
		    // encode bounds as formulas so they show up in the min unsat core:
		    Formula addFormula = null;
		    for (Object k : probRels) {
			LogRelation r =  (LogRelation) problemRels.get(k);
			if (r.isUnknown()) {
			    Relation kRel = r.kodkodRel();
			    String rN = kRel.name();
			    int relSize = kRel.arity();
			    Relation rL =  Relation.nary(rN+"_IMPL", relSize);
			    TupleSet lower = r.toTupleSet(this);
			    problemBounds.boundExactly(rL, lower); 
			    Formula adder = kRel.eq(rL);
			    addFormula = addFormula == null ? adder : 
				Formula.compose(FormulaOperator.AND, addFormula, adder);
			}
		    }
		    formula = Formula.compose(FormulaOperator.AND, formula, addFormula);
		}	    
	    }
	
	    finalFormula = problemFunDefs == null ? formula : Formula.compose(FormulaOperator.AND, problemFunDefs, formula);
	    if (LogMap.SolverOpt_debug1) {
		System.out.println("int bits: " + PBJInternInteger.bitWidth());
		System.out.println("Bounds: " + problemBounds);
		System.out.println("Formula: " + finalFormula.toString());
	    }

	    opts.setBitwidth(PBJInternInteger.bitWidth());
	    //opts.setFlatten(false);
	    //opts.setSymmetryBreaking(LogMap.SolverOpt_SymmetryBreaking);
	    //opts.setSkolemDepth(0);
	    System.out.flush();
	    System.out.println("waiting for solver Kodkod+" + LogMap.SolverOpt_Solver + "...");

	    if (solveAll) {
		Iterator<Solution> sols = solver.solveAll(finalFormula, problemBounds);
		solvedProblemBounds.put(callingMethod, problemBounds);
		solvedProblemUnknowns.put(callingMethod, problemUnknowns);
		solvedSolutions.put(callingMethod, sols);
		sol = sols.next();
	    } else
		sol = solver.solve(finalFormula, problemBounds);
	    System.out.println("solver done.");
	    System.out.println("total method invocation time: " + (System.currentTimeMillis() - startMethodTime) + " ms");

	}
	if (LogMap.SolverOpt_debug1)
	    System.out.println(sol);
	else {
	    //System.out.println(sol.stats());
	}
	Instance model = sol.instance();
	if (model==null || extractCoreForDebug) {
	    if (LogMap.SolverOpt_Prove) {
		final Proof proof = sol.proof();
		System.out.println(extractCoreForDebug ? "implementation error proof (fallback reason):" : "UNSAT fallback proof:");
		if (proof == null)
		    System.out.println(proof);
		else {
		    System.out.println("int bits: " + PBJInternInteger.bitWidth());
		    System.out.println("Bounds: " + problemBounds);
		    System.out.println("Formula: " + finalFormula.toString());
		    Map<Formula,Node> proofItems = proof.highLevelCore();
		    for(Node n : proofItems.values())
			System.out.println("UNSAT proof clause: " + n);
		}		
	    } else if (LogMap.SolverOpt_FallbackUnsatProof) {
		// since it's unsat, find out unsat core and report to user:
		LogMap.SolverOpt_EnableProver();
		solve(callingMethod, obj, formula, modifiableObjects, isFreshResult, solveAll, startMethodTime, false);
	    }
	    return false;
	} else {
	    problemModel = model;
	    // if using a prover also report why fallback was triggered by re-solving,
	    // fixing the bounds to current program state, and extracting min core:
	    if (LogMap.SolverOpt_FallbackProof) {
		solve(callingMethod, obj, formula, modifiableObjects, isFreshResult, solveAll, startMethodTime, true);
	    }
	    return true;
	}
    }

    public void addAsFunDef(LogRelation r, Formula f) { 
	problemFunDefs = problemFunDefs == null ? f : problemFunDefs.and(f);
	problemUnknowns.add(r);
    }

    public void addAsUnknown(LogRelation r) { 
	problemUnknowns.add(r);
    }

    public void addAsProblemRel(LogRelation r, String id) { 
	problemRels.put(id,r); 
    }

    public void commitModel(PBJInternObject obj) {
	ArrayList val = null;
	HashMap<Integer,Object> newInstances = new HashMap<Integer,Object>();
	for (LogRelation u : (ArrayList<LogRelation>) problemUnknowns) {	    
	    String instVar = u.instVar();
	    int arity = u.arity();
	    if (arity > 4) {
		System.out.println("oops haven't implemented arrays of dim > 2 !");
		System.exit(1);
	    }
	    TupleSet lower = problemBounds.lowerBound(u.kodkodRel());
	    boolean hasLower = lower.size() > 0;
	    if (LogMap.SolverOpt_debug3) {
		System.out.println("now updating field relation " + u + " " + u.isResultVar + " " + u.isArray);
		System.out.println(u + " " + u.domain() + " " + u.range());
		System.out.println("lower bounds: " + lower);

	    }
	    String updaterMtdName = "fallback_updateField_" + instVar;
	    Iterator<Tuple> iter = problemModel.tuples(u.kodkodRel()).iterator();
	    if (u.isResultVar) {
		if (u.isArray) {
		    ArrayList l = new ArrayList();
		    if (arity == 2) {
			while (iter.hasNext())
			    l.add(get2((Integer) iter.next().atom(1)));
		    } else {
			while (iter.hasNext()) {
			    Tuple itm = iter.next();
			    int idx = (Integer) itm.atom(0);			    
			    ArrayList l2 = null;
			    if (l.get(idx) == null) {
				l2 = new ArrayList();
				l.set(idx, l2);				      
			    }			    
			    l2 = (ArrayList) l.get(idx);
			    int ix2 = (Integer) itm.atom(1);
			    while (l2.size() <= ix2)
				l2.add(null);
			    Object ox2 = get2((Integer) iter.next().atom(2));
			    l2.set(ix2, ox2);			    
			}
		    }
		    obj.fallback_field_resultArray(l.toArray());
		} else {
		    Object o;	
		    Tuple itm = iter.next();
		    Integer i0 = (Integer) itm.atom(0);
 		    Object o0 = get2(i0);
		    o = getMaybeNewInstance(o0, i0, obj, newInstances, u.domainTypeParamNamesArray);
		    obj.fallback_field_result(o);
		}
		continue;
	    } else if (u.isArray) {
		Class[] paramTypes = new Class[1];
		Object[] args = new Object[1];
		paramTypes[0] = ArrayList.class;
		Class c = u.domain();
		try { 
		    Method m = c.getDeclaredMethod(updaterMtdName, paramTypes);
		    Integer lastSeen = null;
		    Object o0 = null;
		    ArrayList l = null;
		    HashMap<Integer,ArrayList> ls = new HashMap<Integer,ArrayList>();
		    //block below to handle cases where model picked an empty array (which previously wasnt)
		    TupleSet oldRelTuples = problemModel.tuples(u.old().kodkodRel());
		    if (oldRelTuples != null) {
			Iterator<Tuple> oldIter = oldRelTuples.iterator();
			while (oldIter.hasNext()) {
			    Tuple itm = oldIter.next();
			    Integer last = (Integer) itm.atom(0);
			    Integer idx = (Integer) get2((Integer) itm.atom(1));
			    if (o0 == null || lastSeen != last) {
				o0 = get2(last);
				lastSeen = last;
				l = new ArrayList();
				ls.put(last, l);
			    }
			}
		    }
		    while (iter.hasNext()) {
			Tuple itm = iter.next();
			Integer last = (Integer) itm.atom(0);
			Integer idx = (Integer) get2((Integer) itm.atom(1));
			if (o0 == null || lastSeen != last) {
			    o0 = get2(last);
			    lastSeen = last;
			    l = new ArrayList();
			    ls.put(last, l);
			}
			for (int j = l.size(); j <= idx; j++)
			    l.add(null);
			int ix = (Integer) itm.atom(2);
			Object ox = null;
			if (arity == 3) {
			    ox = get2(ix);
			    ox = getMaybeNewInstance(ox, ix, obj, newInstances, u.domainTypeParamNamesArray);
			} else { // have arity == 4 ...
			    int ix2 = (Integer) itm.atom(3);
			    ArrayList l2;
			    if (l.get(idx) == null) {
				l2 = new ArrayList();
				l.set(idx, l2);				      
			    }
			    l2 = (ArrayList) l.get(idx);
			    Object ox2 = get2(ix2);
			    ox2 = getMaybeNewInstance(ox2, ix2, obj, newInstances, u.domainTypeParamNamesArray);			    
			    while (l2.size() <= ix)
				l2.add(null);
			    l2.set(ix, ox2);
			    ox = l2;
			}
			l.set(idx, ox);			
		    }
		    for (Integer i : ls.keySet()) {
			o0 = get2(i);
			args[0] = ls.get(i);
			o0 = getMaybeNewInstance(o0, i, obj, newInstances, u.domainTypeParamNamesArray);
			((PBJInternObject)o0).fallback_updateField(m, args);
		    }
		} catch (Exception e) {
		    e.printStackTrace();
		    System.exit(1);
		}		    
	    } else {
		Class[] paramTypes = new Class[1];
		Object[] args = new Object[1];
		//HACK FIXME
		Class currRange = u.range();
		paramTypes[0] = (currRange == Character.class || currRange == Short.class 
				 || currRange == Byte.class) ? 
		    int.class : currRange;
		Class c = u.domain();
		try { 
		    Method m = c.getDeclaredMethod(updaterMtdName, paramTypes); 
		    while (iter.hasNext()) {
			Tuple itm = iter.next();
			if (hasLower) {
			    if (lower.contains(itm)) // this value cannot have changed 
				continue;
			}
			Integer i0 = (Integer) itm.atom(0);
			Integer i1 = (Integer) itm.atom(1);
			Object o0 = get2(i0);
			Object o1 = get2(i1);
			o1 = getMaybeNewInstance(o1, i1, obj, newInstances, u.domainTypeParamNamesArray);
			args[0] = o1;
			o0 = getMaybeNewInstance(o0, i0, obj, newInstances, u.domainTypeParamNamesArray);
			((PBJInternObject)o0).fallback_updateField(m, args);
		    }
		} catch (Exception e) {
		    e.printStackTrace();
		    System.exit(1);
		}
	    }
	}
    }

    private Object getMaybeNewInstance(Object o0, int i, PBJInternObject obj, 
				       HashMap<Integer,Object> newInstances, 
				       String[] domainTypeParamNamesArray) {
	Object res = o0;
	//FIXME
	if (o0 instanceof Class) { // obj is new. must instantiate it!
	    if (newInstances.containsKey(i))
		res = newInstances.get(i);
	    else { 
		if (LogMap.SolverOpt_debug3)
		    System.out.println("instanting new: " + o0);
		res = LogMap.instantiateNewObj(obj, (Class) o0, domainTypeParamNamesArray);
		newInstances.put(i, res);
		put2(i, res);
		if (LogMap.SolverOpt_debug3)
		    System.out.println("instantiated new: " + res.getClass());
	    }
	}
	return res;
    }

    public HashSet<Integer> get1s(Collection<?> s) {
	HashSet<Integer> res = new HashSet<Integer>();
	for (Object o : s)
	    res.add(get1(o));
	return res;		    
    }

    public LogExpr allInstances_log(String c, boolean isOld) {
        return new LogExpr(this, bounds_log(c));
    }

    public Relation bounds_log(String c) {
	if (LogMap.SolverOpt_debug3) {
	    System.out.println("getting log bounds for: " + c + " -> " + classRels.get(c));
	    System.out.println(ClassAtoms);
	    System.out.println(classRels);
	}

	if (classRels.containsKey(c))
	    return classRels.get(c);
	Relation cRel = Relation.unary(c);
      	TupleSet cRel_upper = problemFactory.noneOf(1);
	List<Integer> atoms = ClassAtoms.get(c);
	if (atoms == null) {
	    atoms = new ArrayList<Integer>();
	    ClassAtoms.put(c, atoms);
	}
	for (int a : atoms)
	    cRel_upper.add(problemFactory.tuple(a));
	if (classNewInstAtoms.containsKey(c)) { 
	    List nAtoms = classNewInstAtoms.get(c);
	    for (Object a : nAtoms)
		cRel_upper.add(problemFactory.tuple(a));
	}
	    
	problemBounds.boundExactly(cRel, cRel_upper);
	classRels.put(c, cRel);
	if (LogMap.SolverOpt_debug3) {
	    System.out.println("added class rel: " + c + " -> " + cRel + " atoms: " + atoms);
	}
	return cRel;
    }

    public TupleSet tupleSetBounds_log(String c, boolean addNull, LogRelation r) {
	HashMap<Object,TupleSet> classTupleSets = addNull ? classTupleSetsWithNull : 
	    classTupleSetsNoNull;
	if (LogMap.SolverOpt_debug3) {
	    System.out.println(classTupleSets);
	}
	TupleFactory factory = problemFactory();	
	TupleSet rB;
	if (classTupleSets.containsKey(c))
	     rB = classTupleSets.get(c);
	else {
	    if (LogMap.SolverOpt_debug3) {
		System.out.println("getting log bounds for instances of type: " + c);
		System.out.println(ClassAtoms);
		System.out.println(classNewInstAtoms);
	    }
	    rB = factory.noneOf(1);
	    Class cc = InvolvedClasses.get(c);
	    List<Integer> atoms = ClassAtoms.get(c);
	    if (atoms == null) {
		atoms = new ArrayList<Integer>();
		ClassAtoms.put(c, atoms);
	    }
	    if (LogMap.SolverOpt_debug3) 
		System.out.println("atoms are: " + atoms);
	    for (Object a : atoms)
		rB.add(problemFactory.tuple(a));
	    if (classNewInstAtoms.containsKey(c)) { 
		List nAtoms = classNewInstAtoms.get(c);
		for (Object a : nAtoms)
		    rB.add(problemFactory.tuple(a));
	    }
	    if (addNull)
		rB.add(factory.tuple(get1(null)));
	    classTupleSets.put(c, rB);
	}
	if (LogMap.SolverOpt_debug3) {
	    System.out.println("set log bounds for instances of type: " + c + " to: " + rB);
	}
	return rB;
    }

    public TupleSet tupleSetNewInstBounds_log(String range, boolean addNull) {
	TupleFactory factory = problemFactory();
	TupleSet rB = factory.noneOf(1);
	List atoms = classNewInstAtoms.get(range);
	for (Object a : atoms)
	    rB.add(problemFactory.tuple(a));
	if (addNull)
	    rB.add(factory.tuple(get1(null)));	
	return rB;
    }

    public Relation newInstBounds_log(String c, boolean addNull) {
	if (LogMap.SolverOpt_debug3) {
	    System.out.println("getting log bounds for new instances of type: " + c);
	    System.out.println(c);
	    System.out.println(ClassAtoms);
	    System.out.println(classNewInstAtoms);
	}
	String k1 = c + " fresh";
	String k2 = k1 + "+Null";
	String k = addNull ? k2 : k1;
	if (classRels.containsKey(k))
	    return classRels.get(k);
	TupleFactory factory = problemFactory();
	Relation cRel1 = Relation.unary(c + " fresh");
	Relation cRel2 = Relation.unary(c + " fresh+Null");
	TupleSet cRel1_upper = factory.noneOf(1);
	TupleSet cRel2_upper = factory.noneOf(1);
	List atoms = classNewInstAtoms.containsKey(c) ? classNewInstAtoms.get(c) : new ArrayList();
// 	//include any subclasses
// 	Class cc = InvolvedClasses.get(c);
// 	if (InvolvedSuperClasses.containsKey(cc)) {
// 	    List<Class> scs = InvolvedSuperClasses.get(cc);
// 	    if (LogMap.SolverOpt_debug3)
// 		System.out.println("including instances of subclasses: " + scs);
// 	    for (Class sc : scs)
// 		atoms.addAll(ClassAtoms.get(sc.getCanonicalName()));
// 	}
	for (Object a : atoms) {
	    cRel1_upper.add(problemFactory.tuple(a));
	    cRel2_upper.add(problemFactory.tuple(a));
	}
	cRel2_upper.add(factory.tuple(get1(null)));		    
	problemBounds.boundExactly(cRel1, cRel1_upper);
	problemBounds.boundExactly(cRel2, cRel2_upper);
	classRels.put(k1,cRel1);
	classRels.put(k2,cRel2);
	
	return addNull ? cRel2 : cRel1;
    }


}

