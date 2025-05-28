package polyglot.ext.pbnj.ast;

import java.util.*;
import polyglot.ast.*;
import polyglot.ext.jl.ast.*;
import polyglot.ext.jl5.ast.*;
import polyglot.util.*;
import polyglot.types.*;
import polyglot.ext.jl5.types.*;
import polyglot.ext.pbnj.types.ESJTypeSystem;
import polyglot.visit.*;


// A temporary class used for passing an ordered dispatch method declaration.
public class ESJIntervalExpr_c extends Expr_c implements ESJIntervalExpr {

    protected Expr lower;
    protected Expr upper;

    public ESJIntervalExpr_c(Position pos, Expr lower, Expr upper) {
	super(pos);
	this.lower = lower;
	this.upper = upper;
    }

    public Expr lower() {
	return lower;
    }

    public Expr upper() {
	return upper;
    }


    public List acceptCFG(CFGBuilder v, List succs) {
	return new ArrayList();
    }
    
    public Term entry() {
	return null;
    }


    // Reconstruct the pred expr.
    protected ESJIntervalExpr_c reconstruct(Expr lower, Expr upper) {
	
	if (lower != this.lower || upper != this.upper) {
	    ESJIntervalExpr_c n = (ESJIntervalExpr_c) copy();
	    n.lower = lower;
	    n.upper = upper;
	    return n;
	}
	return this;
    }

    // Visit the children of the method. 

    public Node visitChildren(NodeVisitor v) {
	Expr lower = (Expr) visitChild(this.lower, v);
	Expr upper = (Expr) visitChild(this.upper, v);
	return reconstruct(lower, upper);
    }


    public Node typeCheck(TypeChecker tc) throws SemanticException {
	JL5TypeSystem ts = (JL5TypeSystem) tc.typeSystem();
	NodeFactory nf = tc.nodeFactory();
	ESJIntervalExpr n = (ESJIntervalExpr) super.typeCheck(tc);
        if (! lower.type().isInt()){
            throw new SemanticException("Interval expression lower bound is not numeric");
        }

        if (! upper.type().isInt()){
            throw new SemanticException("Interval expression lower bound is not numeric");
        }
	Type t = ts.typeForName("polyglot.ext.pbnj.primitives.PBJInternSet"); 
	ParameterizedType pt = ts.parameterizedType((JL5ParsedClassType) t);
	ArrayList<Type> at = new ArrayList<Type>();
	at.add(ts.typeForName("java.lang.Integer"));
	pt.typeArguments(at);
	
	n = (ESJIntervalExpr)n.type(pt);	
	return n;
    }
    

}

