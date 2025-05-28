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

public class ESJAssume_c extends JL5Assert_c
    implements ESJAssume {
    
    static int internMethodCtr = 0;
    String internMethodName;
    

    public ESJAssume_c(Position pos, Expr cond) {
        super(pos, cond, null);
	this.internMethodName = "fallback_assume_" + internMethodCtr++;
    }

    public String internMethodName() { return internMethodName; }
}