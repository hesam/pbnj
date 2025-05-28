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

import polyglot.ext.jl5.ast.JL5ConstructorDecl_c;

import java.util.*;

/** Adds a predicate to method declarations. **/
public class ESJConstructorDecl_c extends JL5ConstructorDecl_c 
    implements ESJConstructorDecl {

    public ESJConstructorDecl_c(Position pos, FlagAnnotations flags,
			   String name,
			   List formals,
			   List throwTypes, Block body, List paramTypes) { 
	super(pos, flags, name, formals, throwTypes, body, paramTypes);
	
    }
    

    // this method already exists in ConstructorDecl, but it is protected.
    // making it public allows it to be accessed by PredJTranslator.
    public ConstructorInstance makeConstructorInstance(ClassType ct, TypeSystem ts)
        throws SemanticException {
        return super.makeConstructorInstance(ct, ts);
    }


}
