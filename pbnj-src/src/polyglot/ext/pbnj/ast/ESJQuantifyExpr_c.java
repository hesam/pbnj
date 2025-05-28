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
public class ESJQuantifyExpr_c extends Expr_c implements ESJQuantifyExpr {

    protected static int idCtr = 0;
    protected FormulaBinary.Operator quantKind;
    protected String id,quantVarN;
    protected List quantVarD, quantVarD2;
    protected Expr quantListExpr;
    protected Expr quantClauseExpr;
    protected JL5MethodDecl parentMethod;
    protected boolean isComprehension;
    protected boolean isSetComprehension;
    protected boolean isSingleComprehension;
    protected int statementLocation;

    public ESJQuantifyExpr_c(Position pos, FormulaBinary.Operator quantKind, String quantVarN, List quantVarD, List quantVarD2, Expr quantListExpr, Expr quantClauseExpr) {
	super(pos);
	this.isComprehension = false;
	this.isSetComprehension = false;
	this.isSingleComprehension = false;
	this.id = (quantKind == FormulaBinary.ALL ? "univQuantify_": "existQuantify_") + Integer.toString(idCtr++);
	this.quantKind = quantKind;
	this.quantVarN = quantVarN;
	this.quantVarD = quantVarD;
	this.quantVarD2 = quantVarD2;
	this.quantListExpr = quantListExpr;
	this.quantClauseExpr = quantClauseExpr;
    }

    public ESJQuantifyExpr convertToComprehension() {
	this.isComprehension = true;
	this.isSetComprehension = quantKind == FormulaBinary.ALL;
	this.isSingleComprehension = !this.isSetComprehension;
	this.id = "setComprehension_" + Integer.toString(idCtr-1);

	return this;
    }

    public static int idCtr() { return idCtr; }

    public Expr quantListExpr() {
	return quantListExpr;
    }

    public Expr quantClauseExpr() {
	return quantClauseExpr;
    }

    public ESJQuantifyExpr quantClauseExpr(Expr quantClauseExpr) {
	this.quantClauseExpr = quantClauseExpr;
	return this;
    }

    public String id() {
	return id;
    }

    public FormulaBinary.Operator quantKind() {
	return quantKind;
    }

    public String quantVarN() {
	return quantVarN;
    }

    public List quantVarD() {
	return quantVarD;
    }

    public List quantVarD2() {
	return quantVarD2;
    }

    public JL5MethodDecl parentMethod() {
	return parentMethod;
    }

    public boolean isComprehension() {
	return isComprehension;
    }

    public boolean isSetComprehension() {
	return isSetComprehension;
    }

    public boolean isSingleComprehension() {
	return isSingleComprehension;
    }

    public void parentMethod(JL5MethodDecl m) {
	this.parentMethod = m;
    }

    public void quantVarD2(List quantVarD2) {
	this.quantVarD2 = quantVarD2;
    }

    public int statementLocation() { return statementLocation; }
    public void statementLocation(int i) { statementLocation = i; }

    public List acceptCFG(CFGBuilder v, List succs) {
	return new ArrayList();
    }
    
    public Term entry() {
	return null;
    }

    // Reconstruct the pred expr.
    protected ESJQuantifyExpr_c reconstruct(FormulaBinary.Operator quantKind, String quantVarN, List quantVarD, List quantVarD2, Expr quantListExpr, Expr quantClauseExpr) {
	
	if (quantListExpr != this.quantListExpr || quantClauseExpr != this.quantClauseExpr) {
	    ESJQuantifyExpr_c n = (ESJQuantifyExpr_c) copy();
	    n.quantKind = quantKind;
	    n.quantVarN = quantVarN;
	    n.quantVarD = quantVarD; //TypedList.copyAndCheck(quantVarD, LocalDecl.class, true);
	    n.quantVarD2 = quantVarD2;
	    n.quantListExpr = quantListExpr;
	    n.quantClauseExpr = quantClauseExpr;
	    return n;
	}
	return this;
    }

    // Visit the children of the method. 

    public Node visitChildren(NodeVisitor v) {
	//System.out.println("ESJQuantifyExpr visit..." +  quantClauseExpr);
	List quantVarD = (List) visitList(this.quantVarD, v);
	Expr quantListExpr = (Expr) visitChild(this.quantListExpr, v);
	Expr quantClauseExpr = (Expr) visitChild(this.quantClauseExpr, v);
	return reconstruct(this.quantKind, this.quantVarN, quantVarD, this.quantVarD2, quantListExpr, quantClauseExpr);
    }

    public Node typeCheck(TypeChecker tc) throws SemanticException {
	JL5TypeSystem ts = (JL5TypeSystem) tc.typeSystem();
	NodeFactory nf = tc.nodeFactory();
	ESJQuantifyExpr n = (ESJQuantifyExpr) super.typeCheck(tc);
	Type f;
	if (isComprehension) {
	    Type b = ((LocalDecl) quantVarD.get(0)).declType();
	    if (isSetComprehension) {
		Type t = ts.typeForName("polyglot.ext.pbnj.primitives.PBJInternSet"); 
		ParameterizedType pt = ts.parameterizedType((JL5ParsedClassType) t);
		ArrayList<Type> at = new ArrayList<Type>();
		// HACK FIXME
		at.add(b.toString().equals("int") ? ts.typeForName("java.lang.Integer") : b);
		pt.typeArguments(at);
		f = pt;
	    } else {
		f = b;
	    }
	} else {
	    f = ts.Boolean();
	}
	n = (ESJQuantifyExpr)n.type(f);	
	return n;
    }
    
}

