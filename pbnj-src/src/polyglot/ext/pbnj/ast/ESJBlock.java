package polyglot.ext.pbnj.ast;

import polyglot.ast.*;
import polyglot.types.Context;
import polyglot.ext.pbnj.types.ESJTypeSystem;

import java.util.*;

import polyglot.ext.jl5.ast.*;

/** JL5Block  **/
public interface ESJBlock extends Block {

    public List varDecls();
    public List varDecls(int uptoStatement);
    public void varDecls(List ds);

}
