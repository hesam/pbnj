package polyglot.ext.pbnj.ast;

import polyglot.ast.*;
import polyglot.types.*;
import polyglot.ext.jl.ast.*;
import polyglot.visit.*;
import polyglot.types.*;
import polyglot.util.*;

// 
public class ESJResult_c extends Local_c implements ESJResult {
    
    public ESJResult_c(Position pos) {
	super(pos, "result");
    }

    public Node typeCheck(TypeChecker tc) throws SemanticException {
        TypeSystem ts = tc.typeSystem();
	NodeFactory nf = tc.nodeFactory();
	MethodInstance m = (MethodInstance) tc.context().currentCode();
	Type t = m.returnType();
	
	return this.type(t);
    }    

}
