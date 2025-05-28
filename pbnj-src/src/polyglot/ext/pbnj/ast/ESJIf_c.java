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

/** JL5If **/
public class ESJIf_c extends JL5If_c
    implements ESJIf {

    //protected boolean isBoolean;
    protected Expr exprConsequent;
    protected Expr exprAlternative;
    protected ESJBlock enclosingBlock;
    protected int statementLocation;

    public ESJIf_c(Position pos, Expr cond, Stmt consequent, Stmt alternative) {
	super(pos, cond, consequent, alternative);
    }
    
    //public boolean isBoolean() { return isBoolean; }
    public boolean isBoolean() {
	return exprConsequent != null ? exprConsequent.type().isBoolean() :
	    consequent instanceof Return ? ((Return) consequent).expr().type().isBoolean() :
	    ((ESJIf) consequent).isBoolean();
    }
 

    public Expr exprConsequent() { return exprConsequent; }
    public Expr exprAlternative() { return exprAlternative; }
    public ESJBlock enclosingBlock() { return enclosingBlock; }
    //public void isBoolean(boolean b) { isBoolean = b; }
    public void exprConsequent(Expr e) { exprConsequent = e; }
    public void exprAlternative(Expr e) { exprAlternative = e; }
    public void enclosingBlock(ESJBlock b) { enclosingBlock = b; }
    public int statementLocation() { return statementLocation; }
    public void statementLocation(int i) { statementLocation = i; }


    /** Reconstruct the statement. */
    protected ESJIf_c reconstruct(Expr cond, Stmt consequent, Stmt alternative, Expr exprConsequent, Expr exprAlternative) {	
	if (cond != this.cond || consequent != this.consequent || alternative != this.alternative || 
	    exprConsequent != this.exprConsequent || exprAlternative != this.exprAlternative) {

	    ESJIf_c n = (ESJIf_c) copy();
	    n.cond = cond;
	    n.consequent = consequent;
	    n.alternative = alternative;
	    n.exprConsequent = exprConsequent;
	    n.exprAlternative = exprAlternative;
	    return n;
	}

	return this;
    }

    /** Visit the children of the statement. */
    public Node visitChildren(NodeVisitor v) {
	Expr cond = (Expr) visitChild(this.cond, v);
	Stmt consequent = (Stmt) visitChild(this.consequent, v);
	Stmt alternative = (Stmt) visitChild(this.alternative, v);
	Expr exprConsequent = (Expr) visitChild(this.exprConsequent, v);
	Expr exprAlternative = (Expr) visitChild(this.exprAlternative, v);
	return reconstruct(cond, consequent, alternative, exprConsequent, exprAlternative);
    }

    /*
    public Node typeCheck(TypeChecker tc) throws SemanticException {
	JL5TypeSystem ts = (JL5TypeSystem) tc.typeSystem();
	NodeFactory nf = tc.nodeFactory();
	ESJIf n = (ESJIf) super.typeCheck(tc);
	//FIXME
	n.isBoolean(n.exprConsequent() != null ? n.exprConsequent().type().isBoolean() :
		    n.consequent() instanceof Return ? ((Return) n.consequent()).expr().type().isBoolean() :
		    ((ESJIf) n.consequent()).isBoolean());
        return n;
    }
    */
}