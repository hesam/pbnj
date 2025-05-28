package polyglot.ext.pbnj.ast;

import java.util.*;
import polyglot.ast.*;
import polyglot.ext.jl5.parse.JL5Name;

public interface ESJModifiableField extends Node {
    public TypeNode fieldClass();
    public String fieldName();
    public ESJModifiableField fieldClass(TypeNode n);
}

