package polyglot.ext.pbnj.ast;

import polyglot.ast.*;
import polyglot.types.Context;
import polyglot.ext.pbnj.types.ESJTypeSystem;

import java.util.*;

import polyglot.ext.jl5.ast.*;

/** JL5LocalDecl  **/
public interface ESJLocalDecl extends JL5LocalDecl {

    public ESJEnsuredMethodDecl enclosingMethod();

}
