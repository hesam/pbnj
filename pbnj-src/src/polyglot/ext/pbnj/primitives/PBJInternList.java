package polyglot.ext.pbnj.primitives;

import polyglot.ext.pbnj.tologic.*;

import java.util.ArrayList;

import kodkod.ast.Relation;
import kodkod.ast.IntExpression;
import kodkod.ast.Expression;

public class PBJInternList<E> extends ArrayList<E> {

    protected LogRelation rel_log;
    protected PBJInternList old;
    int relationizerStep = 0;    


    // Constructor
    public PBJInternList() { super(); }


    // keep my pre-state copy in old field 
    public PBJInternList<E> fallback_clone() {
	PBJInternList<E> res = (PBJInternList<E>) super.clone();
	for (Object e : (PBJInternList<Object>) this)
	    if (e instanceof PBJInternObject)
		((PBJInternObject)e).fallback_clone();
	this.old = res;
	return res;
    }

    boolean isRelationized(LogProblem problem) { return this.relationizerStep == problem.relationizerStep(); }

    // relationize me (receiver will be old)
    public void fallback_relationizeOld(LogProblem problem, String type, String[] typeArgs) {
	if (!isRelationized(problem)) { 
	    this.relationizerStep++;
	    for (Object e : (PBJInternList<Object>) this) {
		if (e instanceof PBJInternObject)
		    ((PBJInternObject) e).fallback_relationizeOld(problem, typeArgs[0], null);
	    }
	}
    }

    public PBJInternList<E> old() { return old; }
    
    public LogRelation rel_log() {
	return rel_log;
    }

    public LogExpr indices_log(LogProblem problem) {
	int s = rel_log.hasFixedSize() ? rel_log.fixedSize() : size();	
	return PBJInternInteger.zeroTo_log(problem, s);
    }

    public Expression get_log(LogProblem p, IntExpression index) {
	return index.toExpression().join(rel_log.kodkodRel(p));
    }                              

    public PBJInternList<Integer> indices() { return PBJInternInteger.range(0, size() - 1); }
    
    public PBJInternList<E> allButLast() { 
	PBJInternList<E> res = fallback_clone();
	res.remove(size()-1);
	return res;
    }
    
    public int count(E e) { int ct = 0;
                                 for (int i = 0; i < size(); i++) if (e.equals(get(i))) ct++;
                                 return ct; }

    public int sum() { int s = 0; for (int i = 0; i < size(); i++) s += (Integer) get(i); return s; }
    
    public static void main(String[] args) { PBJInternList<Integer> ta = new PBJInternList<Integer>();
                                             int[] a = { 1, 2, 3, 4, 4, 5 };
                                             for (int i = 0; i < a.length; i++) { ta.add(new Integer(a[i]));
					     }
                                             System.out.println(ta); }
    
}
