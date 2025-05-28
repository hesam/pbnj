package polyglot.ext.pbnj.tologic;

import polyglot.ext.pbnj.primitives.*;

import java.util.Hashtable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.Iterator;
import java.io.CharArrayWriter;

import kodkod.ast.Relation;
import kodkod.ast.Expression;
import kodkod.ast.IntExpression;
import kodkod.ast.IntConstant;
import kodkod.ast.Formula;
import kodkod.ast.Variable;
import kodkod.ast.Decls;
import kodkod.instance.Bounds;
import kodkod.instance.Tuple;
import kodkod.instance.TupleSet;
import kodkod.instance.TupleFactory;

public class LogRelation extends Hashtable {

    static int RelCtr = 0;

    protected String id;
    protected Relation kodkodRel;
    protected String instVar;
    protected Class domain;
    protected String shortName;
    protected String domainName;
    protected Class range;
    protected String rangeName;
    protected String[] domainTypeParamNamesArray;
    protected String domainTypeParamNames;
    protected int fixedSize;
    protected boolean isRangeTypeVar;
    protected boolean isStatic;
    protected boolean isResultVar;
    protected boolean isFreshResultVar;
    protected boolean isOld;
    protected boolean isUnknown;
    protected boolean isArray;
    protected int arity;
    protected boolean isRangeEnum;
    protected LogRelation old;
    protected LogRelation anew;

    public LogRelation(String instVar, 
		       Class domain, String domainName,
		       Class range, String rangeName,
		       String[] domainTypeParamNamesArray,
		       Relation kodkodRel,
		       boolean isRangeTypeVar, 
		       boolean isStatic, boolean isArray, int arity, boolean isOld, boolean isUnknown, boolean isResultVar, boolean isFreshResultVar, int fixedSize) {
	super();
	this.instVar = instVar;
	this.domain = domain;
	this.domainName = domainName;
	this.range = range;
	this.rangeName = rangeName;
	this.domainTypeParamNamesArray = domainTypeParamNamesArray;
	this.shortName = domainName + "." + instVar;
	this.fixedSize = fixedSize;
	this.isOld = isOld;
	this.isUnknown = isUnknown;
	this.isResultVar = isResultVar;
	this.isFreshResultVar = isFreshResultVar;
	this.isRangeTypeVar = isRangeTypeVar;
	this.isStatic = isStatic;
	this.kodkodRel = kodkodRel;
	this.arity = arity;
	this.isArray = isArray;
	this.id = isResultVar ? "s0" : ((isArray ? ("m" + arity + "_") : "r") + this.RelCtr++);
	this.isRangeEnum = range.isEnum();
	this.range = range;
	if (LogMap.SolverOpt_debug2)
	    System.out.println("new relation " + this + " old: " + isOld);
    }

    public String toString() { return "Rel " + shortName + (isOld ? "_old" : ""); }
    public String instVar() { return instVar; }
    public String id(LogProblem p) { p.addAsProblemRel(this,id); return id; }
    public String getId() { return id; }
    public Relation kodkodRel() { return kodkodRel; }
    public Relation kodkodRel(LogProblem p) { p.addAsProblemRel(this,id); return kodkodRel; }
    public void kodkodRel(Relation rel) { this.kodkodRel = rel; }
    public String domainTypeParamNames() { return domainTypeParamNames; }
    public String[] domainTypeParamNamesArray() { return domainTypeParamNamesArray; }
    public void domainTypeParamNames(String n) { domainTypeParamNames = n; }
    public Class domain() { return domain; }
    public String domainName() { return domainName; }
    public String shortName() { return shortName; }
    public void shortName(String n) { shortName = n; }
    public Class range() { return range; }
    public int fixedSize() { 
	return 
	    Math.max(fixedSize + LogMap.SolverOpt_ArrayMaxSizeGrowth, //always allow for growing array size by this amount
		     LogMap.SolverOpt_ArrayMaxSize); //HACK FIXME
    }
    public boolean isOld() { return isOld; }
    public boolean isUnknown() { return isUnknown; }
    public boolean isArray() { return isArray; }
    public int arity() { return arity; }
    public boolean isResultVar() { return isResultVar; }
    public boolean isFreshResultVar() { return isFreshResultVar; }
    public boolean isStatic() { return isStatic; }
    public boolean isRangeTypeVar() { return isRangeTypeVar; }
    public boolean isRangeEnum() { return isRangeEnum; }
    public boolean hasFixedSize() { return fixedSize != 0; }
    public LogRelation old() { return old; }
    public void old(LogRelation o) { o.anew = this; old = o; }
    public LogRelation anew() { return anew; }
    public void anew(LogRelation o) { anew = o; }
    public void fixedSize(int s) { fixedSize = s; }
    public void incrFixedSize() { fixedSize++; }
    public void range(Class range) { this.range = range; }
    public static int RelCtr() { return RelCtr; }

    public boolean isModifiable(HashMap modifiableFields) {
	if (LogMap.SolverOpt_debug3)
	    System.out.println("check modifiable: " + modifiableFields +"\n (" + shortName + ") " + this);
	return modifiableFields == null || isResultVar ||
	    modifiableFields.containsKey(shortName);
    }

    public Relation domain_log(LogProblem p) { 
	return isStatic ? (Relation) p.class_log(domain).expr() : 
	    p.bounds_log(domainName);
    }

    public Relation range_log(LogProblem p) { 
	// have to add 'null' to the set of possible values for the ref field
	return p.bounds_log(rangeName);
    }

    public Expression rangePlusNull_log(LogProblem p, 
					Set<?> modifiableObjects) { 
	Expression res = range_log(p);
	boolean addNull = !(isPrimitiveRange(range));
	return addNull ? res.union(p.null_log().expr()) : res;
    }

    public TupleSet fullDomainRange_log(LogProblem p, Set<?> modifiableObjects, TupleSet lower, boolean fromOld) {
	TupleSet dB;
	TupleSet rB;
	boolean addNull = !(isPrimitiveRange(range));
	if (addNull)
	    rB = p.tupleSetBounds_log(rangeName, true, this);
	else {
	    Relation r = range_log(p);
	    rB = p.problemBounds.upperBound(r);
	}
	TupleSet res;
	if (isResultVar) {
	    if (isArray) {
		dB = p.problemBounds.upperBound(arrayInstVarDomain_log(p, PBJInternInteger.MAX_VALUE));
		res = dB.product(rB);
	    } else if (isFreshResultVar)
		res = p.problemBounds.upperBound(p.newInstBounds_log(rangeName,
								     true));
	    else
		res = rB;
	} else {
	if (LogMap.SolverOpt_debug3)
	    System.out.println("trying to find domain bound... " + fromOld + ":" + modifiableObjects);
	
	    if (fromOld) // if its fromOld only gets here if we have adds clause...
		dB = p.problemBounds.upperBound(p.newInstBounds_log(domainName, false));
	    else if (modifiableObjects == null) {
		Relation d = domain_log(p);
		dB = p.problemBounds.upperBound(d);
	    } else {
		dB = p.tupleSetBounds_log(domainName, false, this);
	    }
	    if (isArray) {
		dB = dB.product(p.problemBounds.upperBound(arrayInstVarDomain_log(p, this.old().fixedSize()-1))); 
	    }
	    res = dB.product(rB);
	}
	if ((fromOld || modifiableObjects != null) && lower != null)
	    res.addAll(lower);
	return res;
    }


    public Relation arrayInstVarDomain_log(LogProblem p, int s) {
	int repeat = arity - 2;
	String n = "Ints0To" + s + " X" + repeat;
	if (p.classRels.containsKey(n))
	    return p.classRels.get(n);
	TupleFactory factory = p.problemFactory();
	Relation cRel = Relation.nary(n, repeat);
      	TupleSet cRel_upper = null;
	while (repeat-- > 0) {
	    TupleSet cRel_upper_tmp = factory.noneOf(1);	
	    for (int i=0;i<=s;i++)
		cRel_upper_tmp.add(factory.tuple(i));
	    cRel_upper = cRel_upper == null ? cRel_upper_tmp : cRel_upper_tmp.product(cRel_upper);
	}
	p.problemBounds.bound(cRel, cRel_upper);	
	p.classRels.put(n, cRel);
	return cRel;
    }

    public void array_put_log(LogProblem p, Object key, Object value) {
	if (LogMap.SolverOpt_debug3())
	    System.out.println("rel " + id + " trying put key " + key + " value " + value);
	ArrayList l = new ArrayList();
	if (value != null) { 
	    Object[] vs = (Object[]) value;	
	    if (LogMap.SolverOpt_debug3())
		System.out.println("fixed size array: " + this.instVar + " " + vs.length);
	    fixedSize(vs.length);
	    if (arity <= 3) { 
		for(int i=0;i<vs.length;i++)
		    l.add(p.get1(vs[i]));
	    } else {
		for(int i=0;i<vs.length;i++) {
		    ArrayList l2 = new ArrayList();
		    Object[] vs2 = (Object[]) vs[i];	
		    for(int j=0;j<vs2.length;j++)
			l2.add(p.get1(vs2[j]));		    
		    l.add(l2);
		}

	    }
	}
	put(p.get1(key), l);	
	if (LogMap.SolverOpt_debug3())
	    System.out.println("id: " + id + " contents: " + this);
    }

    public void int1_array_put_log(LogProblem p, Object key, int[] value) {
	if (LogMap.SolverOpt_debug3())
	    System.out.println("rel " + id + " trying put key " + key + " value " + value);
	ArrayList l = new ArrayList();
	if (value != null) { 
	    int[] vs = (int[]) value;	
	    if (LogMap.SolverOpt_debug3())
		System.out.println("fixed size array: " + this.instVar + " " + vs.length);
	    fixedSize(vs.length);
	    for(int i=0;i<vs.length;i++)
		l.add(p.get1(vs[i]));
	}
	put(p.get1(key), l);	
	if (LogMap.SolverOpt_debug3())
	    System.out.println("id: " + id + " contents: " + this);
    }

    public void Integer1_array_put_log(LogProblem p, Object key, Integer[] value) {
	if (LogMap.SolverOpt_debug3())
	    System.out.println("rel " + id + " trying put key " + key + " value " + value);
	ArrayList l = new ArrayList();
	if (value != null) { 
	    Integer[] vs = (Integer[]) value;	
	    if (LogMap.SolverOpt_debug3())
		System.out.println("fixed size array: " + this.instVar + " " + vs.length);
	    fixedSize(vs.length);
	    for(int i=0;i<vs.length;i++)
		l.add(p.get1(vs[i]));
	}
	put(p.get1(key), l);	
	if (LogMap.SolverOpt_debug3())
	    System.out.println("id: " + id + " contents: " + this);
    }

    public void int2_array_put_log(LogProblem p, Object key, int[][] value) {
	if (LogMap.SolverOpt_debug3())
	    System.out.println("rel " + id + " trying put key " + key + " value " + value);
	ArrayList l = new ArrayList();
	if (value != null) { 
	    int[][] vs = (int[][]) value;	
	    if (LogMap.SolverOpt_debug3())
		System.out.println("fixed size array: " + this.instVar + " " + vs.length);
	    fixedSize(vs.length);
	    for(int i=0;i<vs.length;i++) {
		ArrayList l2 = new ArrayList();
		int[] vs2 = (int[]) vs[i];	
		for(int j=0;j<vs2.length;j++)
		    l2.add(p.get1(vs2[j]));		    
		l.add(l2);
	    }
	}
	put(p.get1(key), l);	
	if (LogMap.SolverOpt_debug3())
	    System.out.println("id: " + id + " contents: " + this);
    }

    public void Integer2_array_put_log(LogProblem p, Object key, Integer[][] value) {
	if (LogMap.SolverOpt_debug3())
	    System.out.println("rel " + id + " trying put key " + key + " value " + value);
	ArrayList l = new ArrayList();
	if (value != null) { 
	    Integer[][] vs = (Integer[][]) value;	
	    if (LogMap.SolverOpt_debug3())
		System.out.println("fixed size array: " + this.instVar + " " + vs.length);
	    fixedSize(vs.length);
	    for(int i=0;i<vs.length;i++) {
		ArrayList l2 = new ArrayList();
		Integer[] vs2 = (Integer[]) vs[i];	
		for(int j=0;j<vs2.length;j++)
		    l2.add(p.get1(vs2[j]));		    
		l.add(l2);
	    }
	}
	put(p.get1(key), l);	
	if (LogMap.SolverOpt_debug3())
	    System.out.println("id: " + id + " contents: " + this);
    }

    //FIXME! all duplicated!
    public void short1_array_put_log(LogProblem p, Object key, short[] value) {
	if (LogMap.SolverOpt_debug3())
	    System.out.println("rel " + id + " trying put key " + key + " value " + value);
	ArrayList l = new ArrayList();
	if (value != null) { 
	    short[] vs = (short[]) value;	
	    if (LogMap.SolverOpt_debug3())
		System.out.println("fixed size array: " + this.instVar + " " + vs.length);
	    fixedSize(vs.length);
	    for(short i=0;i<vs.length;i++)
		l.add(p.get1((int) vs[i]));
	}
	put(p.get1(key), l);	
	if (LogMap.SolverOpt_debug3())
	    System.out.println("id: " + id + " contents: " + this);
    }

    public void byte1_array_put_log(LogProblem p, Object key, byte[] value) {
	if (LogMap.SolverOpt_debug3())
	    System.out.println("rel " + id + " trying put key " + key + " value " + value);
	ArrayList l = new ArrayList();
	if (value != null) { 
	    byte[] vs = (byte[]) value;	
	    if (LogMap.SolverOpt_debug3())
		System.out.println("fixed size array: " + this.instVar + " " + vs.length);
	    fixedSize(vs.length);
	    for(byte i=0;i<vs.length;i++)
		l.add(p.get1((int) vs[i]));
	}
	put(p.get1(key), l);	
	if (LogMap.SolverOpt_debug3())
	    System.out.println("id: " + id + " contents: " + this);
    }

    public void char1_array_put_log(LogProblem p, Object key, char[] value) {
	if (LogMap.SolverOpt_debug3())
	    System.out.println("rel " + id + " trying put key " + key + " value " + value);
	ArrayList l = new ArrayList();
	if (value != null) { 
	    char[] vs = (char[]) value;	
	    if (LogMap.SolverOpt_debug3())
		System.out.println("fixed size array: " + this.instVar + " " + vs.length);
	    fixedSize(vs.length);
	    for(int i=0;i<vs.length;i++)
		l.add(p.get1((int) vs[i]));
	}
	put(p.get1(key), l);	
	if (LogMap.SolverOpt_debug3())
	    System.out.println("id: " + id + " contents: " + this);
    }

    public void boolean1_array_put_log(LogProblem p, Object key, boolean[] value) {
	if (LogMap.SolverOpt_debug3())
	    System.out.println("rel " + id + " trying put key " + key + " value " + value);
	ArrayList l = new ArrayList();
	if (value != null) { 
	    boolean[] vs = (boolean[]) value;	
	    if (LogMap.SolverOpt_debug3())
		System.out.println("fixed size array: " + this.instVar + " " + vs.length);
	    fixedSize(vs.length);
	    for(int i=0;i<vs.length;i++)
		l.add(p.get1(vs[i]));
	}
	put(p.get1(key), l);	
	if (LogMap.SolverOpt_debug3())
	    System.out.println("id: " + id + " contents: " + this);
    }

    public void boolean2_array_put_log(LogProblem p, Object key, boolean[][] value) {
	if (LogMap.SolverOpt_debug3())
	    System.out.println("rel " + id + " trying put key " + key + " value " + value);
	ArrayList l = new ArrayList();
	if (value != null) { 
	    boolean[][] vs = (boolean[][]) value;	
	    if (LogMap.SolverOpt_debug3())
		System.out.println("fixed size array: " + this.instVar + " " + vs.length);
	    fixedSize(vs.length);
	    for(int i=0;i<vs.length;i++) {
		ArrayList l2 = new ArrayList();
		boolean[] vs2 = (boolean[]) vs[i];	
		for(int j=0;j<vs2.length;j++)
		    l2.add(p.get1(vs2[j]));		    
		l.add(l2);
	    }
	}
	put(p.get1(key), l);	
	if (LogMap.SolverOpt_debug3())
	    System.out.println("id: " + id + " contents: " + this);
    }

    public void put_log(LogProblem p, Object key, Object value) {
	if (LogMap.SolverOpt_debug3())
	    System.out.println("rel " + id + " trying put key " + key + " value " + value);
	put(p.get1(key), p.get1(value));
	if (LogMap.SolverOpt_debug3())
	    System.out.println("id: " + id + " contents: " + this);
    }

    
    public TupleSet lowerBound_log(LogProblem p, Set<?> modifiableObjects) {
	LogRelation r = this;
	Set s = r.keySet();
	if (isUnknown) { 
	    if (modifiableObjects == null)
		return null;	    
	    r = this.old();
	    HashSet sNew = new HashSet();
	    if (LogMap.SolverOpt_debug3())
		System.out.println("modifiables: " + modifiableObjects);
	    for (Object k : r.keySet())
		if (!modifiableObjects.contains(k))
		    sNew.add(k);
	    s = sNew;
	}
	return toTupleSet(p, r,s);
    }

    public TupleSet toTupleSet(LogProblem p) {
	return toTupleSet(p, this, this.keySet());
    }

    public TupleSet toTupleSet(LogProblem p, LogRelation r, Set s) {
	TupleFactory factory = p.problemFactory();
	TupleSet lower = factory.noneOf(kodkodRel.arity());

	Iterator itr = s.iterator();
	while (itr.hasNext()) {
	    Object k = itr.next();
	    Object v = r.get(k);
	    Tuple ktp = factory.tuple(k);
	    if (v instanceof ArrayList) {
		if (isArray) {
		    int repeat = arity - 2;
		    ArrayList lv = (ArrayList) v;
		    int lvs = lv.size() - 1;
		    if (arity == 3) {
			for(int c = 0; c <= lvs; c++)
			    lower.add(ktp.product(factory.tuple(c)).product(factory.tuple(lv.get(c))));
		    } else { //then arity == 4 ...
			for(int c = 0; c <= lvs; c++) {
			    Tuple ctp = factory.tuple(c);
			    ArrayList lv2 = (ArrayList) lv.get(c);
			    int lvs2 = lv2.size() - 1;
			    for(int c2 = 0; c2 <= lvs2; c2++) 
				lower.add(ktp.product(ctp).product(factory.tuple(c2)).product(factory.tuple(lv2.get(c2))));
			}

		    }
		} else {
		    for(Object e : (ArrayList) v)
			lower.add(factory.tuple(k).product(factory.tuple(e)));
		}
	    } else {
		lower.add(factory.tuple(k).product(factory.tuple(v)));
	    }
	}
	return lower;
    }

    public TupleSet getDomainBounds_log(LogProblem p) {
	LogRelation r = this;
	Set s = r.keySet();
	TupleFactory factory = p.problemFactory();
	TupleSet lower = factory.noneOf(1);
	Iterator itr = s.iterator();
	while (itr.hasNext()) {
	    Object k = itr.next();
	    Object v = r.get(k);
	    lower.add(factory.tuple(k));
	}
	return lower;
    }

    public void setBounds(LogProblem p, Relation kodkodRel, HashMap<String, Boolean> modifiableFields, Set<?> modifiableObjects, boolean isFreshResult) {

	boolean isModifiableRelation = isModifiable(modifiableFields);
	boolean isUnknown0 = isUnknown() && isModifiableRelation;
	LogRelation myOld = null;
	if (!(isUnknown0 || isOld))
	    myOld = old();
	if (LogMap.SolverOpt_debug3) {
	    System.out.println("finding bounds for " + this + " range: " + range + " domain: " + domain + " from old: " + myOld + " isOld: " + isOld() + " isUnknown: " + isUnknown() + " isModifiableRelation: " + isModifiableRelation + " classNewInstAtoms: " + p.classNewInstAtoms);
	}
	boolean fromOld = myOld != null; 
	TupleSet lower = isResultVar ? null :
	    fromOld ? myOld.lowerBound_log(p, null) :
	    lowerBound_log(p, modifiableObjects); 
	if (!isUnknown() || (fromOld && (
					 isStatic || 
					 !p.classNewInstAtoms.containsKey(domainName)))) {
	    if (LogMap.SolverOpt_debug3)
		System.out.println("bounded exactly to " + lower);
	    p.problemBounds.boundExactly(kodkodRel, lower);
	} else {
	    TupleSet upper = fullDomainRange_log(p, modifiableObjects, lower, fromOld);
	    if (lower == null) 
		p.problemBounds.bound(kodkodRel, upper);
	    else
		p.problemBounds.bound(kodkodRel, lower, upper);
	    if (LogMap.SolverOpt_debug3)
		System.out.println("bounded to lower=" + lower + " upper=" + upper);
	    p.addAsFunDef(this, funDef_log(p));
	} 
    }

    //FIXME: fix for arbitrary dim arrays...
    public Formula funDef_log(LogProblem p) {
	if (isResultVar)
	    if (isArray) {
		// all indices should be present
		IntExpression i0 = IntConstant.constant(0);
		IntExpression i1 = IntConstant.constant(1);
		Expression idxs = kodkodRel.project(i0);
		Variable vari = Variable.unary("index");
		Decls varI = vari.oneOf(idxs);
		Expression prev = vari.sum().minus(i1).toExpression();
		Formula f1 = kodkodRel.no().or(i0.toExpression().join(kodkodRel).one());
		Formula f2 = vari.sum().eq(i0).or(prev.join(kodkodRel).one()).forAll(varI);
		return f1.and(f2);
	    } else 
		return kodkodRel.one();
	Formula f = null;
	Expression r = rangePlusNull_log(p, null);
	if (isArray) {
	    // one element per index:
	    IntExpression i0 = IntConstant.constant(0);
	    IntExpression i1 = IntConstant.constant(1);
	    Expression dl = domain_log(p).join(kodkodRel);	    
	    Variable vard = Variable.unary("collection");
	    Decls varD = vard.oneOf(domain_log(p)); 
	    Expression fh0 = vard.join(kodkodRel);
	    Variable vari = Variable.unary("index");
	    Expression d = fh0.project(i0);
	    Decls varI = vari.oneOf(d);
	    IntExpression varii = vari.sum();
	    Expression e0 = varii.minus(i1).toExpression().join(fh0);
	    Expression e1 = d.count().minus(i1).toExpression().join(fh0);
	    Formula fh1a, fh1b;
	    if (arity == 3) {
		// all indices present (when unempty):
		fh1b = varii.gt(i0).implies(e0.one());
		// one element per index (when unempty):
		fh1a = e1.one();
	    } else {
		// then arity == 4...
		// all indices present (when unempty):
		fh1b = varii.gt(i0).implies(e0.some());
		// at least one element per index (when unempty):
		fh1a = e1.some();
		Formula fh1bo;
		Variable vario = Variable.unary("index2");
		Expression fh0o = vari.join(fh0);
		Expression d2 = fh0o.project(i0);
		Decls varII = vario.oneOf(d2);
		IntExpression variio = vario.sum();
		Formula fh1b2i = d2.count().minus(i1).toExpression().join(fh0o).one();
		Formula fh1b2ii = variio.gt(i0).implies(variio.minus(i1).toExpression().join(fh0o).one());
		fh1bo = fh0o.some().implies(fh1b2i.and(fh1b2ii.forAll(varII)));
		fh1b = fh1b.and(fh1bo);
	    }
	    Formula fh1 = fh0.some().implies(fh1a.and(fh1b.forAll(varI)));
	    f = fh1.forAll(varD);
	} else {
	    Expression d = domain_log(p);	    
	    f = kodkodRel.function(d,r);
	}
	return f;
    }

    boolean isPrimitiveRange(Class c)  {
	return range == Integer.class || range == Boolean.class || range == Character.class || range == Short.class || range == Byte.class;
    }
    
}
