package polyglot.ext.pbnj.ast;

import polyglot.ast.*;
import polyglot.ext.jl5.ast.*;
import polyglot.types.*;
import polyglot.ext.pbnj.types.ESJTypeSystem;

import java.util.*;

import polyglot.ext.jl5.ast.JL5MethodDecl;

/** a method decl w/ a body of a quantify expr... will be desugared to a foreach stmt. **/
public interface ESJPredMethodDecl extends ESJMethodDecl {

    public String id();	  
    public FormulaBinary.Operator quantKind();
    public String quantVarN();    
    public List quantVarD();
    public Expr quantListExpr();
    public Expr quantClauseExpr();
    public ESJPredMethodDecl quantVarD(List l);
    public boolean isComprehension();
    public boolean isSetComprehension();
    public boolean isSingleComprehension();
}
