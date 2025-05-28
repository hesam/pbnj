package polyglot.ext.pbnj.ast;

import java.util.*;

import polyglot.types.*;
import polyglot.ast.*;
import polyglot.ext.jl5.ast.*;

// an ast node for representing an expression in a predicate method
public interface ESJLogQuantifyExpr extends Expr {

    public String id();
    public FormulaBinary.Operator quantKind();
    public String quantVarN();
    public List quantVarD();
    public List quantVarD2();
    public TypeNode getCastType();
    public Expr quantListExpr();
    public Expr quantClauseExpr();
    public ESJLogPredMethodDecl parentMethod();
    public void parentMethod(ESJLogPredMethodDecl m);
    public void quantVarD2(List quantVarD2);
    public boolean isComprehension();
    public boolean isSetComprehension(); 
    public boolean isSingleComprehension();
}


