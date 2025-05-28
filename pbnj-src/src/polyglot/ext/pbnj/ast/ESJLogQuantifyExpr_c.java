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
public class ESJLogQuantifyExpr_c extends Expr_c implements ESJLogQuantifyExpr {

    protected static int idCtr = 0;
    protected FormulaBinary.Operator quantKind;
    protected String id,quantVarN;
    protected List quantVarD, quantVarD2;
    protected Expr quantListExpr;
    protected Expr quantClauseExpr;
    protected ESJLogPredMethodDecl parentMethod;
    protected boolean isComprehension;
    protected boolean isSetComprehension; 
    protected boolean isSingleComprehension;
    

    public ESJLogQuantifyExpr_c(Position pos, FormulaBinary.Operator quantKind, String quantVarN, List quantVarD, List quantVarD2, Expr quantListExpr, Expr quantClauseExpr, ESJLogPredMethodDecl parentMethod,  boolean isSetComprehension, boolean isSingleComprehension) {
	super(pos);
	this.isSetComprehension = isSetComprehension;
	this.isSingleComprehension = isSingleComprehension;
	this.isComprehension = isSetComprehension || isSingleComprehension;
	this.id = (this.isComprehension ? "setComprehension_" : quantKind == FormulaBinary.ALL ? "univQuantify_": "existQuantify_") + Integer.toString(idCtr++);
	this.quantKind = quantKind;
	this.quantVarN = quantVarN;
	this.quantVarD = quantVarD;
	this.quantVarD2 = quantVarD2;
	this.parentMethod = parentMethod;
	this.quantListExpr = quantListExpr;
	this.quantClauseExpr = quantClauseExpr;
    }

    // HACK FIXME
    public TypeNode getCastType() {
	List res = new TypedList(new LinkedList(), TypeNode.class, false);
	getCastTypeH(quantClauseExpr, res);
	return res.size() == 0 ? null : (TypeNode) res.get(0);
    }

    void getCastTypeH(Node e, List res) {
	if (e instanceof FormulaBinary) {
	     FormulaBinary b = (FormulaBinary) e;
	     getCastTypeH(b.left(), res);
	     getCastTypeH(b.right(), res);
	} else if (e instanceof CmpBinary) {
	     CmpBinary b = (CmpBinary) e;
	     getCastTypeH(b.left(), res);
	     getCastTypeH(b.right(), res);
	} else if (e instanceof Field) {
	     Field f = (Field) e;
	     getCastTypeH(f.target(), res);
	} else if (e instanceof JL5Cast) {
	    res.add(((JL5Cast)e).castType());
	}

    }


    public Expr quantListExpr() {
	return quantListExpr;
    }

    public Expr quantClauseExpr() {
	return quantClauseExpr;
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

    public ESJLogPredMethodDecl parentMethod() {
	return parentMethod;
    }

    public boolean isComprehension() {
	return isComprehension;
    }

    public boolean isSetComprehension() { return isSetComprehension; }
    public boolean isSingleComprehension() { return isSingleComprehension; }

    public void parentMethod(ESJLogPredMethodDecl m) {
	this.parentMethod = m;
    }

    public void quantVarD2(List quantVarD2) {
	this.quantVarD2 = quantVarD2;
    }

    public List acceptCFG(CFGBuilder v, List succs) {
	return new ArrayList();
    }
    
    public Term entry() {
	return null;
    }

    // Reconstruct the pred expr.
    protected ESJLogQuantifyExpr_c reconstruct(FormulaBinary.Operator quantKind, String quantVarN, List quantVarD, Expr quantListExpr, Expr quantClauseExpr) {
	
	if (quantListExpr != this.quantListExpr || quantClauseExpr != this.quantClauseExpr) {
	    ESJLogQuantifyExpr_c n = (ESJLogQuantifyExpr_c) copy();
	    n.quantKind = quantKind;
	    n.quantVarN = quantVarN;
	    n.quantVarD = quantVarD; //TypedList.copyAndCheck(quantVarD, LocalDecl.class, true);
	    n.quantListExpr = quantListExpr;
	    n.quantClauseExpr = quantClauseExpr;
	    return n;
	}
	return this;
    }

    // Visit the children of the method. 

    public Node visitChildren(NodeVisitor v) {
	List quantVarD = (List) visitList(this.quantVarD, v);
	//List quantVarD2 = (List) visitList(this.quantVarD2, v);
	Expr quantListExpr = (Expr) visitChild(this.quantListExpr, v);
	Expr quantClauseExpr = (Expr) visitChild(this.quantClauseExpr, v);
	return reconstruct(this.quantKind, this.quantVarN, quantVarD, quantListExpr, quantClauseExpr);
    }

    
    // right now ESJLogQuantifyExpr does not get type checked, gets type from its
    // ESJQuantifyExpr counterpart
    /*
    public Node typeCheck(TypeChecker tc) throws SemanticException { //FIXME

	JL5TypeSystem ts = (JL5TypeSystem) tc.typeSystem();
	NodeFactory nf = tc.nodeFactory();
	ESJLogQuantifyExpr n = (ESJLogQuantifyExpr) super.typeCheck(tc);
	Type f;
	if (isComprehension) {
	    Type b = ((LocalDecl) quantVarD.get(0)).declType();
	    if (isSetComprehension) {
		Type t = ts.typeForName("polyglot.ext.pbnj.primitives.PBJInternSet"); 
		ParameterizedType pt = ts.parameterizedType((JL5ParsedClassType) t);
		ArrayList<Type> at = new ArrayList<Type>();
		at.add(b.toString().equals("int") ? ts.typeForName("java.lang.Integer") : b);
		pt.typeArguments(at);
		f = pt;
	    } else {
		f = b;
	    }
	} else {
	    f = ts.Boolean();
	}
	n = (ESJLogQuantifyExpr)n.type(f);	

	List newQuantVarD2 = new TypedList(new LinkedList(), LocalDecl.class, false);	
	for (LocalDecl d : (List<LocalDecl>) quantVarD2) {
	    if (d.type() instanceof AmbTypeNode)
		newQuantVarD2.add((d.type() instanceof AmbTypeNode) ? 
				  d.type(nf.CanonicalTypeNode(null,ts.typeForName(((AmbTypeNode) d.type()).name()))) :
				  d);
	    else
		newQuantVarD2.add(d);  
	}
	n.quantVarD2(newQuantVarD2);
	return n;

    } 
    */

}

