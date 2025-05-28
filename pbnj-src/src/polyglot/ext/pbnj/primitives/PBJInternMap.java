package polyglot.ext.pbnj.primitives;

import polyglot.ext.pbnj.tologic.*;

import java.util.HashMap;

public class PBJInternMap<K,V> extends HashMap<K,V> {

    protected LogRelation rel_log;
    protected PBJInternMap old;
    int relationizerStep = 0;    

    // Constructor
    public PBJInternMap() { super(); }


    // keep my pre-state copy in old field 

    public PBJInternMap<K,V> fallback_clone() {
	PBJInternMap<K,V> res = (PBJInternMap<K,V>) super.clone();
	for (Object e : values())
	    if (e instanceof PBJInternObject)
		((PBJInternObject)e).fallback_clone();
	this.old = res;
	return res;
	}

    boolean isRelationized(LogProblem problem) { return this.relationizerStep == problem.relationizerStep(); }

    // relationize me and my old
    public void fallback_relationizeOld(LogProblem problem, String type, String[] typeArgs) {
	if (!isRelationized(problem)) { 
	    this.relationizerStep++;
	    // FIXME
	    for (Object e : values())
		if (e instanceof PBJInternObject)
		    ((PBJInternObject) e).fallback_relationizeOld(problem, typeArgs[0], null);
	}
    }
    
    public PBJInternMap<K,V> old() { return old; }
    
    public LogRelation rel_log() {
	return rel_log;
    }

    

}
