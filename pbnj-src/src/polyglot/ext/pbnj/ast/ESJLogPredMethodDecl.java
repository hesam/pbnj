package polyglot.ext.pbnj.ast;

import polyglot.ast.*;
import polyglot.types.*;
import polyglot.ext.pbnj.types.ESJTypeSystem;

import java.util.*;

import polyglot.ext.jl5.ast.JL5MethodDecl;

/** the relational logic counterpart of the predicate method decl **/
public interface ESJLogPredMethodDecl extends ESJMethodDecl {

    public boolean isFallback();
    public List quantVarD();
    public List quantVarD2();
    public void quantVarD(List quantVarD);
    public void quantVarD2(List quantVarD2);
    public void addQuantVarD(List quantVarD);
    public void addQuantVarD2(List quantVarD2);
}
