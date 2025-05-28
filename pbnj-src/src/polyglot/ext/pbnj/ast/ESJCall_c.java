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

/** JL5Call **/
public class ESJCall_c extends Call_c
    implements ESJCall {

    public ESJCall_c(Position pos, Receiver target, String name, List arguments) {
	super(pos, target, name, arguments);
    }
   
}