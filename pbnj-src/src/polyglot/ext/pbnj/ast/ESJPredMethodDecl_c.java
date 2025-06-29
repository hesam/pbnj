package polyglot.ext.pbnj.ast;

import polyglot.ast.*;
import polyglot.ext.jl.ast.*;
import polyglot.ext.jl5.ast.*;
import polyglot.ext.jl5.types.*;
import polyglot.util.*;
import polyglot.types.*;
import polyglot.ext.pbnj.types.ESJTypeSystem;
import polyglot.visit.*;

import polyglot.ext.jl5.types.FlagAnnotations;
import polyglot.ext.jl5.visit.JL5AmbiguityRemover;

import polyglot.ext.jl5.ast.JL5MethodDecl_c;

import java.util.*;

/** Adds a predicate to method declarations. **/
public class ESJPredMethodDecl_c extends ESJMethodDecl_c
    implements ESJPredMethodDecl {

    protected String quantMtdId;
    protected FormulaBinary.Operator quantKind;
    protected String quantVarN;
    protected List quantVarD;
    protected Expr quantListExpr;
    protected Expr quantClauseExpr;
    protected boolean isComprehension;
    protected boolean isSetComprehension;
    protected boolean isSingleComprehension;

    public ESJPredMethodDecl_c(Position pos, FlagAnnotations flags,
			       TypeNode returnType, String name,
			       List formals,
			       List throwTypes, Block body, List paramTypes, String quantMtdId,
			       FormulaBinary.Operator quantKind, String quantVarN, List quantVarD, 
			       Expr quantListExpr, Expr quantClauseExpr, 
			       boolean isSetComprehension, boolean isSingleComprehension) {
	super(pos, flags, returnType, name, formals, throwTypes, body, paramTypes);
	this.isSetComprehension = isSetComprehension;
	this.isSingleComprehension = isSingleComprehension;
	this.isComprehension = isSetComprehension || isSingleComprehension;
	this.quantMtdId = quantMtdId;
	this.quantKind = quantKind;
	this.quantVarN = quantVarN;
	this.quantVarD = quantVarD;
	this.quantListExpr = quantListExpr;
	this.quantClauseExpr = quantClauseExpr;
    }
    
    public String id() {
	return quantMtdId;
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

    public Expr quantListExpr() {
	return quantListExpr;
    }

    public Expr quantClauseExpr() {
	return quantClauseExpr;
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

    public ESJPredMethodDecl quantVarD(List l) {
	this.quantVarD = l;
	return this;
    }


    /** Reconstruct the method. */
    protected MethodDecl_c reconstruct(TypeNode returnType, List formals,
				       List throwTypes, Block body,  
				       FormulaBinary.Operator quantKind, String quantVarN, 
				       List quantVarD, Expr quantListExpr, 
				       Expr quantClauseExpr) {
	if (returnType != this.returnType ||
	    ! CollectionUtil.equals(formals, this.formals) ||
	    quantListExpr != this.quantListExpr ||
	    quantClauseExpr != this.quantClauseExpr ||
	    ! CollectionUtil.equals(throwTypes, this.throwTypes) ||
	    body != this.body) {
	    ESJPredMethodDecl_c n = (ESJPredMethodDecl_c) copy();
	    n.formals = formals; //TypedList.copyAndCheck(throwTypes, Formal.class, true);
	    n.throwTypes = TypedList.copyAndCheck(throwTypes, TypeNode.class, true);
	    n.quantKind = quantKind;
	    n.quantVarN = quantVarN;
	    n.quantListExpr = quantListExpr;
	    n.quantClauseExpr = quantClauseExpr;
	    n.quantVarD = TypedList.copyAndCheck(quantVarD, LocalDecl.class, true);
	    n.body = body;
	    return n;
	}

	return this;
    }
    
    // Visit the children of the method. 
    public Node visitChildren(NodeVisitor v) {
	TypeNode returnType = (TypeNode) visitChild(this.returnType, v);	
	List formals = visitList(this.formals, v);
	List quantVarD = visitList(this.quantVarD, v);
	Expr quantListExpr = (Expr) visitChild(this.quantListExpr, v);
	Expr quantClauseExpr = (Expr) visitChild(this.quantClauseExpr, v);
	List throwTypes = visitList(this.throwTypes, v);
	Block body = (Block) visitChild(this.body, v);
	return reconstruct(returnType, formals, throwTypes, body, this.quantKind, this.quantVarN , quantVarD, quantListExpr, quantClauseExpr);
    }

    public Node typeCheck(TypeChecker tc) throws SemanticException {
	    // findout what type is quantListExpr list of (can be a subtype a generic...)
	JL5TypeSystem ts = (JL5TypeSystem) tc.typeSystem();
	    Type t = (Type) quantListExpr().type();

	    if (t instanceof JL5ParsedClassType) {
		while (! ((JL5ParsedClassType) t).isGeneric()) {
		    t = (ReferenceType) ts.superType((ReferenceType) t);
		}
	    }
	    if (t instanceof ParameterizedType) {
		List newVarD = new TypedList(new LinkedList(), LocalDecl.class, false);
		for (LocalDecl d : (List<LocalDecl>) quantVarD) {
		    newVarD.add(d.type(d.type().type((Type) ((ParameterizedType) t).typeArguments().get(0))));
		}
		this.quantVarD = newVarD;
	    }

	    ESJPredMethodDecl n = (ESJPredMethodDecl) super.typeCheck(tc);
	    return n;
    }


    public Context enterScope(Node child, Context c) {
	if (child instanceof Expr) {
	    for (Formal f : (List<Formal>) formals) {
		c.addVariable(c.typeSystem().localInstance(null, flags(),f.declType(), f.name()));
	    }
	    
	}

	return super.enterScope(child, c);
	}

}
