package polyglot.ext.pbnj.ast;

import polyglot.ast.*;
import polyglot.ext.jl.ast.*;
import polyglot.ext.jl5.ast.*;
import polyglot.ext.jl5.types.*;
import polyglot.util.*;
import polyglot.types.*;
import polyglot.ext.pbnj.types.ESJTypeSystem;
import polyglot.visit.*;

import polyglot.ext.jl5.types.FlagAnnotations;
import polyglot.ext.jl5.visit.JL5AmbiguityRemover;

import polyglot.ext.jl5.ast.JL5MethodDecl_c;

import java.util.*;

/** Adds a predicate to method declarations. **/
public class ESJMethodDecl_c extends JL5MethodDecl_c 
    implements ESJMethodDecl {

    public ESJMethodDecl_c(Position pos, FlagAnnotations flags,
			   TypeNode returnType, String name,
			   List formals,
			   List throwTypes, Block body, List paramTypes) {
	super(pos, flags, returnType, name, formals, throwTypes, body, paramTypes);	
    }
    /*
    protected MethodDecl_c reconstruct(TypeNode returnType, List formals,
				       List throwTypes, Block body) {
	if (returnType != this.returnType ||
	    ! CollectionUtil.equals(formals, this.formals) ||
	    ! CollectionUtil.equals(throwTypes, this.throwTypes) ||
	    body != this.body) {
	    ESJMethodDecl_c n = (ESJMethodDecl_c) copy();
	    n.formals = formals; //TypedList.copyAndCheck(throwTypes, Formal.class, true);
	    n.throwTypes = TypedList.copyAndCheck(throwTypes, TypeNode.class, true);
	    n.body = body;
	    return n;
	}

	return this;
    }

    // Visit the children of the method. 
    public Node visitChildren(NodeVisitor v) {
	TypeNode returnType = (TypeNode) visitChild(this.returnType, v);
	List formals = visitList(this.formals, v);
	List throwTypes = visitList(this.throwTypes, v);
	System.out.println("here..." + " " + name);
	Block body = (Block) visitChild(this.body, v);
	System.out.println("done..." + " " + name);
	return reconstruct(returnType, formals, throwTypes, body);
    }
    */

    // this method already exists in MethodDecl, but it is protected.
    // making it public allows it to be accessed by PredJTranslator.
    public MethodInstance makeMethodInstance(ClassType ct, TypeSystem ts)
        throws SemanticException {
        return super.makeMethodInstance(ct, ts);
    }



}
