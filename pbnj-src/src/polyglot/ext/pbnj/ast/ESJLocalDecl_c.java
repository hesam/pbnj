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

/** ESJLocalDecl **/
public class ESJLocalDecl_c extends JL5LocalDecl_c
    implements ESJLocalDecl {

    protected ESJEnsuredMethodDecl enclosingMethod;

    public ESJLocalDecl_c(Position pos, FlagAnnotations flags, TypeNode type, String name, Expr init, ESJEnsuredMethodDecl enclosingMethod) {
	super(pos, flags, type, name, init);
	this.enclosingMethod = enclosingMethod;
    }

    public ESJEnsuredMethodDecl enclosingMethod() { return enclosingMethod; }
}
