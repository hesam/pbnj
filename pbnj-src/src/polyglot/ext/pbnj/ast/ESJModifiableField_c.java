package polyglot.ext.pbnj.ast;

import java.util.*;
import polyglot.ast.*;
import polyglot.ext.jl.ast.*;
import polyglot.ext.jl5.ast.*;
import polyglot.ext.jl5.parse.JL5Name;
import polyglot.util.*;
import polyglot.types.*;
import polyglot.ext.pbnj.types.ESJTypeSystem;
import polyglot.ext.jl5.types.*;
import polyglot.visit.*;


public class ESJModifiableField_c extends Node_c implements ESJModifiableField {

    protected TypeNode fieldClass;
    protected String fieldName;

    public ESJModifiableField_c(Position pos, TypeNode fieldClass, String fieldName) {
	super(pos);
	this.fieldClass = fieldClass;
	this.fieldName = fieldName;
    }

    public TypeNode fieldClass() { return fieldClass; }
    public String fieldName() { return fieldName; }

    public ESJModifiableField fieldClass(TypeNode n) { fieldClass = n; return this; }


    protected ESJModifiableField_c reconstruct(TypeNode theListType) {
	if (fieldClass != this.fieldClass) {
	    ESJModifiableField_c n = (ESJModifiableField_c) copy();
	    n.fieldClass = fieldClass;
	    return n;
	}
	return this;
    }

    public Node disambiguate(AmbiguityRemover ar) throws SemanticException {
        if (ar.kind() == AmbiguityRemover.SIGNATURES) {
            Context c = ar.context();
            TypeSystem ts = ar.typeSystem();
	    NodeFactory nf = ar.nodeFactory();
            ParsedClassType ct = c.currentClassScope();
	    ESJModifiableField n = this;
	    if (fieldClass instanceof JL5AmbTypeNode) {
		List<TypeNode> mfs = new ArrayList<TypeNode>();
		JL5AmbTypeNode fc = (JL5AmbTypeNode) fieldClass;
		List<TypeNode> args = (List<TypeNode>) fc.typeArguments();
		for (TypeNode tn : args) {
		    TypeNode ntn;
		    if (tn instanceof ArrayTypeNode) {
			ArrayTypeNode tna = (ArrayTypeNode) tn;
			ntn = nf.CanonicalTypeNode(position(), ts.arrayOf(position(), ((TypeNode) tna.base().disambiguate(ar)).type()));
		    } else
			ntn = (TypeNode) tn.disambiguate(ar);
		    mfs.add(ntn);
		}
		
		n = (ESJModifiableField) fieldClass(fc.typeArguments(mfs));
	    }
	    n = (ESJModifiableField) n.fieldClass((TypeNode) fieldClass.disambiguate(ar));
	    return n;
         }
         return this;
    }
    
    public Node visitChildren(NodeVisitor v) {
	TypeNode fieldClass = (TypeNode) visitChild(this.fieldClass, v);	    
	return reconstruct(this.fieldClass);
    }
    
    public Node typeCheck(TypeChecker tc) throws SemanticException {
        // check no duplicate annotations used
        JL5TypeSystem ts = (JL5TypeSystem)tc.typeSystem();
	ESJModifiableField n = (ESJModifiableField) super.typeCheck(tc);
	n = n.fieldClass((TypeNode) n.fieldClass().typeCheck(tc));
	return n;
    }


}


