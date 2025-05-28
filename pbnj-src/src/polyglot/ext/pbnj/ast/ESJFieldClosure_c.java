package polyglot.ext.pbnj.ast;

import polyglot.ast.*;
import polyglot.types.*;
import polyglot.ext.jl.ast.*;
import polyglot.visit.*;
import polyglot.types.*;
import polyglot.util.*;

import polyglot.ast.*;
import polyglot.ext.jl.ast.*;
import polyglot.ext.jl5.ast.*;
import polyglot.util.*;
import polyglot.types.*;
import polyglot.ext.pbnj.types.ESJTypeSystem;
import polyglot.ext.jl5.types.*;
import polyglot.visit.*;
import polyglot.ext.jl5.visit.JL5AmbiguityRemover;



import java.util.*;

/** a field access with (reflexive) transitive closure **/
public class ESJFieldClosure_c extends JL5Field_c
    implements ESJFieldClosure {

    protected static int idCtr = 0;

    protected FormulaBinary.Operator kind;
    protected boolean isMulti;
    protected List multiNames;
    protected String id;
    protected JL5MethodDecl parentMethod;
    protected String theType;
    protected boolean isIntSet;

    public ESJFieldClosure_c(Position pos, Receiver target, String name, FormulaBinary.Operator kind, List multiNames, String theType) {
	super(pos, target, name);
	this.id = Integer.toString(idCtr++);
	this.kind = kind;
	this.isMulti = multiNames.size() > 1;
	this.multiNames = multiNames;
	this.theType = theType;
    }

    public FormulaBinary.Operator kind() {
	return kind;
    }

    public boolean isSimple() {
	return kind == FormulaBinary.SIMP;
    }
    
    public boolean isReflexive() {
	return kind == FormulaBinary.RFLX;
    }

    public boolean isSetFieldsMap() {
	return kind == FormulaBinary.MAP;
    }

    public String id() {
	return id;
    }

    public boolean isMulti() { 
	return isMulti; 
    }

    public List multiNames() {
	return multiNames;
    }

    public String theType() {
	return theType;
    }

    public boolean isIntSet() { return isIntSet; }
    public void isIntSet(boolean b) { isIntSet = b; }

    public Node typeCheck(TypeChecker tc) throws SemanticException {
	ESJFieldClosure n = (ESJFieldClosure) super.typeCheck(tc);
	n.isIntSet(n.type().isInt());
	JL5TypeSystem ts = (JL5TypeSystem) tc.typeSystem();
	Type t = ts.typeForName("polyglot.ext.pbnj.primitives.PBJInternSet"); //"java.util.HashSet");
	ParameterizedType pt = ts.parameterizedType((JL5ParsedClassType) t);
	ArrayList<Type> at = new ArrayList<Type>();
	at.add(n.type());
	pt.typeArguments(at);
	n = (ESJFieldClosure)n.type(pt);
	return n;
    }

}