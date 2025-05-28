package polyglot.ext.pbnj.ast;

import polyglot.ast.*;
import polyglot.types.*;
import polyglot.ext.jl.ast.*;
import polyglot.visit.*;
import polyglot.types.*;
import polyglot.util.*;

// binary expressions appearing in predicates
public class CmpBinary_c extends Binary_c implements CmpBinary {

    protected String kodkodOp;

    public CmpBinary_c(Position pos, Expr left, Operator op, Expr right) {
	this(pos, left, op, right, null);
    }

    public CmpBinary_c(Position pos, Expr left, Operator op, Expr right, String kodkodOp) {
	super(pos, left, op, right);
	this.kodkodOp = kodkodOp;
    }

    public String kodkodOp() { return kodkodOp; }

}
