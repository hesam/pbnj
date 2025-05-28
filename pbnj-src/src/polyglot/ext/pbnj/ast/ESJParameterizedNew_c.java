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

public class ESJParameterizedNew_c extends JL5New_c
    implements ESJParameterizedNew {

    public ESJParameterizedNew_c(Position pos, Expr qualifier, TypeNode tn, List arguments, ClassBody body, List typeArguments) {
        super(pos, qualifier, tn, arguments, body, typeArguments);
    }

}
