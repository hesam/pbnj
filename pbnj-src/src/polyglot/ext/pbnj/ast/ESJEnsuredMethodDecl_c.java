package polyglot.ext.pbnj.ast;

import polyglot.ast.*;
import polyglot.ext.jl.ast.*;
import polyglot.util.*;
import polyglot.types.*;
import polyglot.ext.pbnj.types.ESJTypeSystem;
import polyglot.visit.*;

import polyglot.ext.jl5.types.FlagAnnotations;
import polyglot.ext.jl5.types.ParameterizedType;
import polyglot.ext.jl5.visit.JL5AmbiguityRemover;
import polyglot.ext.jl5.types.JL5MethodInstance;
import polyglot.ext.jl5.types.JL5TypeSystem;
import polyglot.ext.jl5.types.JL5Context;
import polyglot.ext.jl5.types.TypeVariable;

import polyglot.ext.jl5.ast.*;


import java.util.*;

/** Adds a predicate to method declarations. **/
public class ESJEnsuredMethodDecl_c extends JL5MethodDecl_c
    implements ESJEnsuredMethodDecl {

    protected Expr requiresExpr;
    protected Expr ensuresExpr;
    protected JL5Formal catchFormal;
    protected List modifiableFields;
    protected Expr modifiableObjects;
    protected List addedObjects;
    protected JL5LocalDecl resultVar;
    protected boolean isFreshResult;
    protected boolean isUniqueResults;
    protected String fullName;

    public ESJEnsuredMethodDecl_c(Position pos, FlagAnnotations flags,
				  TypeNode returnType, String name,
				  List formals, List throwTypes, Block body, 
				  List paramTypes, Expr requiresExpr, Expr ensuresExpr, 
				  JL5Formal catchFormal, JL5LocalDecl resultVar,
				  List modifiableFields,
				  Expr modifiableObjects,
				  List addedObjects, boolean isFreshResult, boolean isUniqueResults) {
	super(pos, flags, returnType, name, formals, throwTypes, body, paramTypes);
	this.requiresExpr = requiresExpr;
	this.ensuresExpr = ensuresExpr;
	this.catchFormal = catchFormal;
	this.modifiableFields = modifiableFields;
	this.modifiableObjects = modifiableObjects;
	this.addedObjects = addedObjects;
	this.resultVar = resultVar;
	this.isFreshResult = isFreshResult;
	this.isUniqueResults = isUniqueResults;
    }
    
    public Expr requiresExpr() {
	return requiresExpr;
    }

    public Expr ensuresExpr() {
	return ensuresExpr;
    }

    public ESJEnsuredMethodDecl ensuresExpr(Expr e) {
	this.ensuresExpr = e;
	return this;
    }

    public ESJEnsuredMethodDecl requiresExpr(Expr e) {
	this.requiresExpr = e;
	return this;
    }

    public JL5Formal catchFormal() {
	return catchFormal;
    }

    public JL5LocalDecl resultVar() {
	return resultVar;
    }

    public List modifiableFields() {
	return modifiableFields;
    }

    public Expr modifiableObjects() {
	return modifiableObjects;
    }

    public ESJEnsuredMethodDecl modifiableFields(List l) {
	modifiableFields = l;
	return this;
    }

    public List addedObjects() { return addedObjects; }
    public boolean ensuresExprHasOld() { return ensuresExprHasOldH(ensuresExpr); }
    public boolean isFreshResult() { return isFreshResult; }
    public boolean isUniqueResults() { return isUniqueResults;}

    public String fullName() { 
	if (fullName == null)
	    fullName = getFullName();
	return fullName; 
    }


    // FIXME
    public boolean ensuresExprHasOldH(Node n) {
	if (n instanceof Binary)
	    return ensuresExprHasOldH(((Binary) n).left()) ||
		ensuresExprHasOldH(((Binary) n).left());
	else if (n instanceof Call) { 
	    if (((Call) n).name().equals("old"))
		return true;
	    for (Expr a : (List<Expr>) ((Call) n).arguments())
		if (ensuresExprHasOldH(a))
		    return true;
	    return ensuresExprHasOldH(((Call) n).target()); 
	} 
	else return false;
    }

    // Reconstruct the method.
    protected MethodDecl_c reconstruct(TypeNode returnType, List formals,
				       List throwTypes, Block body, List paramTypes, 
				       Expr requiresExpr, Expr ensuresExpr, 
				       JL5Formal catchFormal, JL5LocalDecl resultVar,
				       List modifiableFields, Expr modifiableObjects, 
				       List addedObjects) {
	if (returnType != this.returnType ||
	    ! CollectionUtil.equals(formals, this.formals) ||
	    requiresExpr != this.requiresExpr ||
	    ensuresExpr != this.ensuresExpr ||
	    ! CollectionUtil.equals(throwTypes, this.throwTypes) ||
	    body != this.body || !CollectionUtil.equals(paramTypes, this.paramTypes)	    
	    || addedObjects != this.addedObjects) {
	    ESJEnsuredMethodDecl_c n = (ESJEnsuredMethodDecl_c) copy();
	    n.returnType = returnType;
	    n.formals = TypedList.copyAndCheck(formals, Formal.class, true);
	    n.requiresExpr = requiresExpr;
	    n.ensuresExpr = ensuresExpr;
	    n.catchFormal = catchFormal;
	    n.resultVar = resultVar;
	    n.throwTypes = TypedList.copyAndCheck(throwTypes, TypeNode.class, true);
	    n.body = body;
            n.paramTypes = paramTypes;
	    if (modifiableFields != null)
		n.modifiableFields = TypedList.copyAndCheck(modifiableFields, ESJModifiableField.class, true);	   
	    n.modifiableObjects = modifiableObjects;
	    n.addedObjects = addedObjects;
	    return n;
	}

	return this;
    }

    // Visit the children of the method.
    public Node visitChildren(NodeVisitor v) {
	TypeNode returnType = (TypeNode) visitChild(this.returnType, v);
	List formals = visitList(this.formals, v);
	JL5LocalDecl resultVar = (JL5LocalDecl) visitChild(this.resultVar, v);
	Expr requiresExpr = this.requiresExpr == null ? null : 
	    (Expr) visitChild(this.requiresExpr, v);
	Expr ensuresExpr = (Expr) visitChild(this.ensuresExpr, v);
	JL5Formal catchFormal = (JL5Formal) visitChild(this.catchFormal, v);
	List throwTypes = visitList(this.throwTypes, v);
	Block body = (Block) visitChild(this.body, v);
        List paramTypes = visitList(this.paramTypes, v);
	List modifiableFields = this.modifiableFields == null ? this.modifiableFields : 
	    visitList(this.modifiableFields, v);	
	Expr modifiableObjects = (Expr) visitChild(this.modifiableObjects, v);
        List addedObjects = visitList(this.addedObjects, v);
	return reconstruct(returnType, formals, throwTypes, body, paramTypes, requiresExpr, ensuresExpr, catchFormal, resultVar, modifiableFields, modifiableObjects, addedObjects);
    }

    public Node typeCheck(TypeChecker tc) throws SemanticException {
	JL5TypeSystem ts = (JL5TypeSystem) tc.typeSystem();
	ESJEnsuredMethodDecl n = (ESJEnsuredMethodDecl) super.typeCheck(tc);	    
	if (n.requiresExpr() != null)
	    n = n.requiresExpr((Expr) n.requiresExpr().typeCheck(tc));
	n = n.ensuresExpr((Expr) n.ensuresExpr().typeCheck(tc));
	
	return n;
    }

    public Context enterScope(Node child, Context c) {
	if (child instanceof Expr)
	    for (Formal f : (List<Formal>) formals)
		c.addVariable(c.typeSystem().localInstance(null, flags(), f.declType(), f.name()));

	return super.enterScope(child, c);
    }

    public String shortTypeName(Type t) { 
	String longName;
	if (t.isArray()) {
	    //longName = t.toString(); 
	    //longName = longName.substring(0, longName.length() - 2);
	    longName = shortTypeName(((ArrayType) t).base());
	} else {
	    longName = ((Named) t).name(); 
	    if (t instanceof ParameterizedType) {
		ParameterizedType pt = (ParameterizedType) t;
		longName = pt.name();
		Type bt = pt.baseType();
		longName = shortTypeName(bt);	    
// 		for (Type tat : pt.typeArguments())
// 		    longName += "_" + shortTypeName(tat); 
	    } else {
		int pi = longName.lastIndexOf(46); // char '.'
		longName = pi == -1 ? longName : longName.substring(pi+1);
	    }
	}
	return longName;
    }

    public String getFullName() {
	String res = this.name();
	for (Formal f : (List<Formal>) this.formals()) {
	    Type fT = f.declType();
	    //HACK FIXME
	    res = res + "_" + 
		(fT == null ? f.type().toString().substring(0, f.type().toString().indexOf(123))  // char '{'
		 : shortTypeName(fT));
	}
	return res;
    }

    // this method already exists in MethodDecl, but it is protected.
    // making it public allows it to be accessed by PredJTranslator.
    public MethodInstance makeMethodInstance(ClassType ct, TypeSystem ts)
        throws SemanticException {
        return super.makeMethodInstance(ct, ts);
    }


}