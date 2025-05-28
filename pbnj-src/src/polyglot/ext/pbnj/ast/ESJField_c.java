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

/** JL5Field **/
public class ESJField_c extends JL5Field_c
    implements ESJField {

    public ESJField_c (Position pos, Receiver target, String name) {
        super(pos, target, name);
    }

//     public Node typeCheck(TypeChecker tc) throws SemanticException {
//         Context c = tc.context();
//         ESJTypeSystem ts = (ESJTypeSystem)tc.typeSystem();
// 	Type tp = target.type();
// 	//FIXME: has false positives!
// // 	if (!tp.isArray()) {
// // 	    FieldInstance fi = ts.findFieldOrEnum(tp.toReference(), name, c.currentClass());
// // 	    if (!fi.flags().contains(ts.Spec()) && !name.equals("old") && !name.equals("result")) {
// // 		throw new SemanticException("Cannot access field \"" + name +
// // 					    "\" " + (target instanceof Expr
// // 						     ? "on an expression "
// // 						     : "") +
// // 					    "of non-reference type \"" +
// // 					    tp + "\" inside ensures clause, because it is not marked as \"spec\".", target.position());
// // 	    }
// // 	}
// 	return super.typeCheck(tc);        
//     }
}