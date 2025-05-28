package polyglot.ext.pbnj.primitives;

import polyglot.ext.pbnj.tologic.*;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import kodkod.ast.Expression;
import kodkod.ast.IntExpression;

public class PBJInternSet<E> extends HashSet<E> {

    public Integer dontcare;
    int relationizerStep = 0;    
    public PBJInternSet<E> old;
    
    public PBJInternSet() {
	super();
    }

    boolean isRelationized(LogProblem problem) { return this.relationizerStep == problem.relationizerStep(); }
    public PBJInternSet<E> old() { return old; }

    public PBJInternSet<E> fallback_clone() {
	PBJInternSet<E> res = (PBJInternSet<E>) super.clone();
	for (Object e : (PBJInternSet<Object>) this)
	    if (e instanceof PBJInternObject)
		((PBJInternObject)e).fallback_clone();
	this.old = res;
	return res;
    }

    public void fallback_relationizeOld(LogProblem problem, 
					String typeArgsStr,
					String[] typeArgs) { 
	if (!isRelationized(problem)) { 
	    this.relationizerStep++;
	    // FIXME
	    for (Object e : (PBJInternSet<Object>) this)
		if (e instanceof PBJInternObject)
		    ((PBJInternObject) e).fallback_relationizeOld(problem, typeArgs[0], null);
	} 
    }   

    public E get() throws IndexOutOfBoundsException {
	if (size() == 0)
	    throw new IndexOutOfBoundsException("getting from empty set");

	Random rand = new Random();
	int n = rand.nextInt(size());
	Iterator<E> i = iterator();
	while (n-- > 0)
	    i.next();
	return i.next();
    }

    public PBJInternSet<E> plus(E e) {
	add(e);
	return this;
    }

    public PBJInternSet<E> minus(E e) {
	remove(e);
	return this;
    }

    public boolean containsPtrEqCmp(Object o) {
	for (Object e : (PBJInternSet<Object>) this)
	    if (e == o) 
		return true;	
	return false;
    }

    public static LogExpr toPBJInternSet_log(LogProblem p, LogExpr target, String targetTypeArgsStr, String[] targetTypeArgs, boolean target_isOld) {
	return target;
    }

}
