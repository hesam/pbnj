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

/** JL5Field **/
public class ESJResultField_c extends JL5Field_c
    implements ESJResultField {

    protected ESJEnsuredMethodDecl method;

    public ESJResultField_c (Position pos, Receiver target, String name, ESJEnsuredMethodDecl method) {
        super(pos, target, name);
	this.method = method;
    }

    public ESJEnsuredMethodDecl method() { return this.method; }
    
}
