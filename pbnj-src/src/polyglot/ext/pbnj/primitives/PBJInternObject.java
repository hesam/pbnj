package polyglot.ext.pbnj.primitives;

import polyglot.ext.pbnj.tologic.*;
import java.lang.reflect.Method;
import java.lang.reflect.Constructor;
import java.util.*;

import kodkod.ast.Expression;

public interface PBJInternObject extends Cloneable {

    public PBJInternObject old();
    public void fallback_atomize(LogProblem problem, 
				 String typeArgsStr,
				 String[] typeArgs);
    public void fallback_relationizeOld(LogProblem problem, 
					String typeArgsStr,
					String[] typeArgs);
    public Object fallback_clone();
    public void fallback_field_result(Object r);
    public void fallback_field_resultArray(Object[] r);
    public void fallback_updateField(Method m, Object[] args);
    public Object fallback_newInstance(java.lang.reflect.Constructor cons, Object[] args, String[] typeParamNames);
    public Object fallback_setTypeArgs(String[] args);

}
