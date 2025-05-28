package polyglot.ext.pbnj.ast;

import polyglot.ast.*;
import polyglot.ext.jl5.ast.*;
import polyglot.types.*;
import polyglot.ext.pbnj.types.ESJTypeSystem;

import java.util.*;

import polyglot.ext.jl5.ast.JL5ConstructorDecl;

/** a method decl w/ a body of a quantify expr... will be desugared to a foreach stmt. **/
public interface ESJConstructorDecl extends JL5ConstructorDecl {

    // this method already exists in ConstructorDecl, but it is protected.
    // making it public allows it to be accessed by PredJTranslator.
    public ConstructorInstance makeConstructorInstance(ClassType ct, TypeSystem ts)
        throws SemanticException;
    
}