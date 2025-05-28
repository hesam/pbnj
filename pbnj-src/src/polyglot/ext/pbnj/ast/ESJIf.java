package polyglot.ext.pbnj.ast;

import polyglot.ast.*;
import polyglot.types.Context;
import polyglot.ext.pbnj.types.ESJTypeSystem;

import java.util.*;

import polyglot.ext.jl5.ast.*;

/** JL5If  **/
public interface ESJIf extends JL5If {

    public boolean isBoolean();
    public Expr exprConsequent();
    public Expr exprAlternative();
    public ESJBlock enclosingBlock();
    //public void isBoolean(boolean b);
    public void exprConsequent(Expr e);
    public void exprAlternative(Expr e);
    public void enclosingBlock(ESJBlock b);
    public int statementLocation();
    public void statementLocation(int i);

}
