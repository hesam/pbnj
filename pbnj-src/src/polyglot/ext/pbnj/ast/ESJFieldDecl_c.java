package polyglot.ext.pbnj.ast;

import polyglot.ast.*;
import polyglot.ext.jl.ast.*;
import polyglot.ext.jl5.ast.*;
import polyglot.util.*;
import polyglot.types.*;
import polyglot.ext.pbnj.types.ESJTypeSystem;
import polyglot.visit.*;

import polyglot.ext.jl5.types.FlagAnnotations;
import polyglot.ext.jl5.visit.JL5AmbiguityRemover;

import polyglot.ext.jl5.types.JL5Context;
import polyglot.ext.jl5.types.TypeVariable;

import polyglot.ext.jl5.ast.*;


import java.util.*;

/** Adds a predicate to method declarations. **/
public class ESJFieldDecl_c extends JL5FieldDecl_c
    implements ESJFieldDecl {

    protected boolean isResultField;
    protected boolean isResultFieldFresh;

    public ESJFieldDecl_c(Position pos, FlagAnnotations flags, TypeNode type, String name, Expr init, boolean isResultField, boolean isResultFieldFresh) {
	super(pos, flags, type, name, init);

	this.isResultField = isResultField;
	this.isResultFieldFresh = isResultFieldFresh;

    }

    public boolean isResultField() { return isResultField; }
    public boolean isResultFieldFresh() { return isResultFieldFresh; } 


}