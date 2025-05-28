package polyglot.ext.pbnj.ast;

import polyglot.ast.*;
import polyglot.ext.pbnj.types.ESJTypeSystem;
import polyglot.ext.jl5.ast.*;
import polyglot.types.*;

import java.util.*;

import polyglot.ext.jl5.ast.*;

/** a method decl including an ensures clause as a post condition assertion **/
public interface ESJEnsuredMethodDecl extends JL5MethodDecl {

    public Expr requiresExpr();
    public Expr ensuresExpr();
    public JL5Formal catchFormal();
    public boolean ensuresExprHasOld();
    public boolean isFreshResult(); // does it have to return a new instance?
    public boolean isUniqueResults(); // is it suppose to give a different result on each call?
    public List modifiableFields();
    public Expr modifiableObjects();
    public List addedObjects();
    public ESJEnsuredMethodDecl ensuresExpr(Expr e);
    public ESJEnsuredMethodDecl requiresExpr(Expr e);
    public String fullName();

    // this method already exists in MethodDecl, but it is protected.
    // making it public allows it to be accessed by PredJTranslator.
    public MethodInstance makeMethodInstance(ClassType ct, TypeSystem ts)
        throws SemanticException;

}


