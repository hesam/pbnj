package polyglot.ext.pbnj.ast;

import polyglot.ast.*;
import polyglot.types.*;
import polyglot.ext.jl.ast.*;
import polyglot.visit.*;
import polyglot.types.*;
import polyglot.util.*;

// binary expressions appearing in predicates
public class ESJBinary_c extends Binary_c implements ESJBinary {

    protected String kodkodOp;

    public ESJBinary_c(Position pos, Expr left, Operator op, Expr right) {
	this(pos, left, op, right, null);
    }

    public ESJBinary_c(Position pos, Expr left, Operator op, Expr right, String kodkodOp) {
	super(pos, left, op, right);
	this.kodkodOp = kodkodOp;
    }

    public String kodkodOp() { return kodkodOp; }


}
