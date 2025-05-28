package polyglot.ext.pbnj.ast;

import polyglot.ast.*;
import polyglot.types.Context;
import polyglot.ext.pbnj.types.ESJTypeSystem;

import java.util.*;

import polyglot.ext.jl5.ast.*;

/** a field access with (reflexive) transitive closure **/
public interface ESJFieldClosure extends Field {

    public FormulaBinary.Operator kind();
    public boolean isSimple();
    public boolean isReflexive();
    public boolean isSetFieldsMap();
    public boolean isMulti();
    public List multiNames();
    public String id();
    public String theType();
    public boolean isIntSet();
    public void isIntSet(boolean b);

}
