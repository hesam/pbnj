package polyglot.ext.pbnj.ast;

import polyglot.ast.*;
import polyglot.types.*;
import polyglot.ext.jl.ast.*;
import polyglot.visit.*;
import polyglot.types.*;
import polyglot.util.*;

// binary expressions appearing in predicates
public class FormulaBinary_c extends Binary_c implements FormulaBinary {

    protected String kodkodOp;

    public FormulaBinary_c(Position pos, Expr left, Operator op, Expr right) {
	this(pos, left, op, right, null);
    }

    public FormulaBinary_c(Position pos, Expr left, Operator op, Expr right, String kodkodOp) {
	super(pos, left, op, right);
	this.kodkodOp = kodkodOp;
    }

    public String kodkodOp() { return kodkodOp; }

    public Node typeCheck(TypeChecker tc) throws SemanticException {

        TypeSystem ts = tc.typeSystem();

        Type l = left.type();
	Type r = right.type();

	if (op == COND_OR || op == COND_AND || op == COND_IMPLIES || op == COND_IFF) {
	    if (! l.isBoolean()) {
		throw new SemanticException("The " + op +
		    " operator must have boolean operands.", left.position());
	    }

	    if (! r.isBoolean()) {
		throw new SemanticException("The " + op +
		    " operator must have boolean operands.", right.position());
	    }

	    return type(ts.Boolean());
	}

	return super.typeCheck(tc);
    }
    
    public String toString() {
	String res = super.toString();	
	return op == COND_IMPLIES || op == COND_IFF ? ("(" + res + ")") : res;
    }

}
