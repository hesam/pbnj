package polyglot.ext.pbnj.ast;

import java.util.*;
import polyglot.ast.*;
import polyglot.ext.jl.ast.*;
import polyglot.ext.jl5.ast.*;
import polyglot.ext.jl5.parse.JL5Name;
import polyglot.util.*;
import polyglot.types.*;
import polyglot.ext.pbnj.types.ESJTypeSystem;
import polyglot.ext.jl5.types.*;
import polyglot.visit.*;


// A temporary class used for passing an ordered dispatch method declaration.
public class ESJQuantifyTypeExpr_c extends Expr_c implements ESJQuantifyTypeExpr {

    protected TypeNode theListType;

    public ESJQuantifyTypeExpr_c(Position pos, TypeNode theListType) {
	super(pos);
	this.theListType = theListType;
    }

    public TypeNode theListType() {
	return theListType;
    }

    public List acceptCFG(CFGBuilder v, List succs) {
	return new ArrayList();
    }
    
    public Term entry() {
	return null;
    }

    protected ESJQuantifyTypeExpr_c reconstruct(TypeNode theListType) {
	if (theListType != this.theListType) {
	    ESJQuantifyTypeExpr_c n = (ESJQuantifyTypeExpr_c) copy();
	    n.theListType = theListType;
	    return n;
	}
	return this;
    }
    
    public Node visitChildren(NodeVisitor v) {
	TypeNode theListType = (TypeNode) visitChild(this.theListType, v);	    
	return reconstruct(theListType);
    }
    

    public Node typeCheck(TypeChecker tc) throws SemanticException {
	//System.out.println("ESJQuantifyTypeExpr tc...");
	//System.out.println("ESJQuantifyTypeExpr tc done");
	ESJQuantifyTypeExpr n = (ESJQuantifyTypeExpr) super.typeCheck(tc);

	n = (ESJQuantifyTypeExpr)n.type(tc.typeSystem().typeForName("polyglot.ext.pbnj.primitives.PBJInternList"));

	return n;
    } 

    public String toString() {
	return "a " + getClass() +  ": type= " + theListType;
    }

}


