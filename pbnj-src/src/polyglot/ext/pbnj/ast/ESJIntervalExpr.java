package polyglot.ext.pbnj.ast;

import java.util.*;

import polyglot.types.*;
import polyglot.ast.*;
import polyglot.ext.jl5.ast.*;

// an ast expression node for representing a range between two integers 
public interface ESJIntervalExpr extends Expr {
    public Expr lower();
    public Expr upper();

}

