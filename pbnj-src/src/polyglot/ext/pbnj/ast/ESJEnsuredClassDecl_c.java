package polyglot.ext.pbnj.ast;

import polyglot.ast.*;
import polyglot.ext.jl.ast.*;
import polyglot.ext.jl5.ast.*;
import polyglot.util.*;
import polyglot.types.*;
import polyglot.ext.pbnj.types.ESJTypeSystem;
import polyglot.visit.*;

import polyglot.ext.jl5.types.*;
import polyglot.ext.jl5.visit.JL5AmbiguityRemover;

import polyglot.ext.jl5.ast.*;


import java.util.*;

/** Adds a predicate to method declarations. **/
public class ESJEnsuredClassDecl_c extends JL5ClassDecl_c
    implements ESJEnsuredClassDecl {

    protected Expr ensuresExpr;
    protected boolean isPrimitive;

    public ESJEnsuredClassDecl_c(Position pos, FlagAnnotations fl, String name, 
				 TypeNode superType, List interfaces, ClassBody body, 
				 List<ParamTypeNode> paramTypes, Expr ensuresExpr, boolean isPrimitive) {
        super(pos, fl, name, superType, interfaces, body, paramTypes);
	this.ensuresExpr = ensuresExpr;
	this.isPrimitive = isPrimitive;
    }
    
    public Expr ensuresExpr() {
	return ensuresExpr;
    }

    public boolean isPrimitive() { return isPrimitive; }

    public ESJEnsuredClassDecl ensuresExpr(Expr e) {
	this.ensuresExpr = e;
	return this;
    }

    protected ClassDecl reconstruct(TypeNode superClass, List interfaces, ClassBody body,
				    List annotations, List paramTypes, Expr ensuresExpr) {
        if (superClass != this.superClass || !CollectionUtil.equals(interfaces, this.interfaces)
                || body != this.body || !CollectionUtil.equals(annotations, this.annotations)
	        || ensuresExpr != this.ensuresExpr
                || !CollectionUtil.equals(paramTypes, this.paramTypes)) {
            ESJEnsuredClassDecl_c n = (ESJEnsuredClassDecl_c) copy();
            n.superClass = superClass;
            n.interfaces = TypedList.copyAndCheck(interfaces, TypeNode.class, false);
            n.body = body;
            n.annotations = TypedList.copyAndCheck(annotations, AnnotationElem.class, false);
            n.paramTypes = paramTypes;
	    n.ensuresExpr = ensuresExpr;
            return n;
        }
        return this;
    }

    public Node visitChildren(NodeVisitor v) {
        List annots = visitList(this.annotations, v);
        List paramTypes = visitList(this.paramTypes, v);
        TypeNode superClass = (TypeNode) visitChild(this.superClass, v);
        List interfaces = visitList(this.interfaces, v);
        ClassBody body = (ClassBody) visitChild(this.body, v);
	Expr ensuresExpr = (Expr) visitChild(this.ensuresExpr, v);
        return reconstruct(superClass, interfaces, body, annots, paramTypes, ensuresExpr);
    }

    protected boolean defaultConstructorNeeded() {
        if (flags().isInterface()) {
            return false;
        }
        return type().constructors().size() < 1;
    }

    protected Node addDefaultConstructor(TypeSystem ts, NodeFactory nf) {
        ConstructorInstance ci = ts.defaultConstructor(position(), this.type);
        this.type.addConstructor(ci);
        Block block = null;
        if (this.type.superType() instanceof ClassType && !JL5Flags.isEnumModifier(flags())) {
            ConstructorInstance sci = ts.defaultConstructor(position(), (ClassType) this.type.superType());
            ConstructorCall cc = nf.SuperCall(position(), Collections.EMPTY_LIST);
            cc = cc.constructorInstance(sci);
	    List stmts = new TypedList(new LinkedList(), Stmt.class, false);
	    stmts.add(cc);
	    List args = new TypedList(new LinkedList(), Expr.class, false);
	    args.add(nf.ClassLit(null, nf.CanonicalTypeNode(null, type())));
	    args.add(nf.This(null));	   
            block = nf.Block(position(), stmts);
        } else {
            block = nf.Block(position());
        }

        ConstructorDecl cd;
        FlagAnnotations fl = new FlagAnnotations();
        fl.annotations(new ArrayList());
        if (!JL5Flags.isEnumModifier(flags())) {
            fl.classicFlags(Flags.PUBLIC);
            cd = ((JL5NodeFactory) nf).JL5ConstructorDecl(position(), fl, name, Collections.EMPTY_LIST, Collections.EMPTY_LIST, block, new ArrayList());
        } else {
            fl.classicFlags(Flags.PRIVATE);
            /*
             * ArrayList formalTypes = new ArrayList(); FlagAnnotations fa = new
             * FlagAnnotations(); fa.classicFlags(Flags.NONE);
             * fa.annotations(new ArrayList());
             * formalTypes.add(((JL5NodeFactory)nf).JL5Formal(position(), fa,
             * nf.CanonicalTypeNode(position(), ts.String()), "arg0"));
             * formalTypes.add(((JL5NodeFactory)nf).JL5Formal(position(), fa,
             * nf.CanonicalTypeNode(position(), ts.Int()), "arg1"));
             */
            cd = ((JL5NodeFactory) nf).JL5ConstructorDecl(position(), fl, name, Collections.EMPTY_LIST, Collections.EMPTY_LIST, block, new ArrayList());
        }
        cd = (ConstructorDecl) cd.constructorInstance(ci);
        return body(body.addMember(cd));
    }

    public Node typeCheck(TypeChecker tc) throws SemanticException {

        ESJEnsuredClassDecl n = (ESJEnsuredClassDecl) super.typeCheck(tc);
	n = n.ensuresExpr((Expr) n.ensuresExpr().typeCheck(tc));
	return n;
    }


}