package polyglot.ext.pbnj.ast;

import polyglot.ast.*;
import polyglot.types.Context;
import polyglot.ext.pbnj.types.ESJTypeSystem;

import java.util.*;

import polyglot.ext.jl5.ast.*;

/** a field decl that is or isnt a old (pre-state-value)  **/
public interface ESJFieldDecl extends JL5FieldDecl {

    public boolean isResultField();
    public boolean isResultFieldFresh();
}
