package polyglot.ext.pbnj.ast;

import polyglot.ast.*;
import polyglot.ext.jl5.ast.*;
import polyglot.types.*;
import polyglot.ext.pbnj.types.ESJTypeSystem;

import java.util.*;

import polyglot.ext.jl5.ast.JL5MethodDecl;

/** a method decl w/ a body of a quantify expr... will be desugared to a foreach stmt. **/
public interface ESJMethodDecl extends JL5MethodDecl {

    // this method already exists in MethodDecl, but it is protected.
    // making it public allows it to be accessed by PredJTranslator.
    public MethodInstance makeMethodInstance(ClassType ct, TypeSystem ts)
        throws SemanticException;
    
}