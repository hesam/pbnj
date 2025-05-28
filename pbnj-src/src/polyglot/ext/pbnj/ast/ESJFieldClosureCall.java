package polyglot.ext.pbnj.ast;

import polyglot.ast.Call;

public interface ESJFieldClosureCall extends Call {

    public FormulaBinary.Operator kind();
    public boolean isSimple();
    public boolean isReflexive();
    public boolean isSetFieldsMap();
    public boolean isIntSet();
}
