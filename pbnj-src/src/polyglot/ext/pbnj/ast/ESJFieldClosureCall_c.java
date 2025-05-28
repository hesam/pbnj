package polyglot.ext.pbnj.ast;

import polyglot.ast.*;
import polyglot.ext.jl.ast.*;
import polyglot.types.*;
import polyglot.util.*;

import java.util.List;

public class ESJFieldClosureCall_c extends Call_c implements ESJFieldClosureCall {

    protected FormulaBinary.Operator kind;
    protected boolean isIntSet;

    public ESJFieldClosureCall_c(Position pos, Receiver target, String name, List arguments, FormulaBinary.Operator kind, boolean isIntSet) {
        super(pos, target, name, arguments);
	this.kind = kind;
	this.isIntSet = isIntSet;
    }

    public FormulaBinary.Operator kind() { return kind; }

    public boolean isSimple() { return kind == FormulaBinary.SIMP; }
    
    public boolean isReflexive() { return kind == FormulaBinary.RFLX; }

    public boolean isSetFieldsMap() { return kind == FormulaBinary.MAP; }

    public boolean isIntSet() { return isIntSet; }

}
