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

public class ESJBlock_c extends Block_c
    implements ESJBlock {

    protected List varDecls;

    public ESJBlock_c(Position pos, List statements) {
	super(pos, statements);
	this.varDecls = new TypedList(new LinkedList(), Stmt.class, false);
    }

    public List varDecls() { return varDecls; }
    public List varDecls(int uptoStatement) {
	List res = new TypedList(new LinkedList(), Stmt.class, false);
	int i = 0;
	while (i < varDecls.size() && i < uptoStatement)
	    res.add(varDecls.get(i++));
	return res;
    }
    public void varDecls(List ds) { this.varDecls = ds; }

    public Node typeCheck(TypeChecker tc) throws SemanticException {
	JL5TypeSystem ts = (JL5TypeSystem) tc.typeSystem();
	NodeFactory nf = tc.nodeFactory();
	ESJBlock n = (ESJBlock) super.typeCheck(tc);
	List varDeclsNew = new TypedList(new LinkedList(), Stmt.class, false);
	// HACK FIXME	
	for (Stmt s : (List<Stmt>) statements) {
	    if (s instanceof ESJIf)
		((ESJIf) s).enclosingBlock(this);
	    else if (s instanceof LocalDecl)
		varDeclsNew.add((LocalDecl) s);
	}
	n.varDecls(varDeclsNew);
	return n;
    }

}