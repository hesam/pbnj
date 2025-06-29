package polyglot.ext.pbnj.visit;

import polyglot.visit.*;
import polyglot.ast.*;
import polyglot.ext.jl.ast.*;
import polyglot.ext.pbnj.ast.*;
import polyglot.types.*;
import polyglot.ext.pbnj.types.*;
import polyglot.ext.jl5.types.*;
import polyglot.util.*;

import polyglot.frontend.Job;

//import polyglot.ext.pbnj.util.toJavaExpr;

import java.util.*;

/** Visitor that translates ESJ AST nodes to Java AST nodes, for
    subsequent output. **/
public class ESJTesting extends ContextVisitor {

	// String for mangling the name of each dispatchee method
    protected static String dispatcheeStr = "$body";

	// String for making the formal names of the dispatcher method
    public static String argStr = "arg$";
    
    public ESJTesting(Job job, TypeSystem ts, NodeFactory nf) {
	super(job, ts, nf);
    }


    protected Node leaveCall(Node n) throws SemanticException {
	//System.out.println("testing..." + n);
	    return super.leaveCall(n);
    }
}

