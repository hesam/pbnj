package polyglot.ext.pbnj.ast;

import java.util.*;

import polyglot.types.*;
import polyglot.ast.*;
import polyglot.ext.jl5.ast.*;

// an ast node for representing an expression in a predicate method
public interface ESJQuantifyExpr extends Expr {

    public String id();
    public FormulaBinary.Operator quantKind();
    public String quantVarN();
    public List quantVarD();
    public List quantVarD2();
    public Expr quantListExpr();
    public Expr quantClauseExpr();
    public ESJQuantifyExpr quantClauseExpr(Expr quantClauseExpr);
    public JL5MethodDecl parentMethod();
    public void parentMethod(JL5MethodDecl m);
    public void quantVarD2(List quantVarD2);
    public boolean isComprehension();
    public boolean isSetComprehension();
    public boolean isSingleComprehension();
    public ESJQuantifyExpr convertToComprehension();
    public int statementLocation();
    public void statementLocation(int i);

}

