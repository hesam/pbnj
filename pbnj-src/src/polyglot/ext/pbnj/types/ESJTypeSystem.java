package polyglot.ext.pbnj.types;

import polyglot.types.*;
import polyglot.ast.Binary;
import polyglot.ast.Unary;
import polyglot.ast.Special;
import polyglot.util.*;
import java.util.*;
import polyglot.ext.jl5.types.JL5TypeSystem;

public interface ESJTypeSystem extends JL5TypeSystem  {
    public Flags Spec();
    public Flags Pure();
    public Flags Fresh();
    public Flags UniqueResults();
    public Flags Primitive();
}

