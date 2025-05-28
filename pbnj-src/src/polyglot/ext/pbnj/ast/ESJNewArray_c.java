package polyglot.ext.pbnj.ast;

import polyglot.ast.*;
import polyglot.ext.jl.ast.*;
import polyglot.util.*;
import polyglot.types.*;
import polyglot.visit.*;
import java.util.*;

public class ESJNewArray_c extends NewArray_c implements ESJNewArray {

    public ESJNewArray_c(Position pos, TypeNode baseType, List dims, int addDims, ArrayInit init){
        super(pos, baseType, dims, addDims, init);
    }
}
