package polyglot.ext.pbnj.ast;

import polyglot.ast.*;
import polyglot.types.*;
import polyglot.ext.jl.ast.*;
import polyglot.types.*;
import polyglot.ext.pbnj.types.*;
import polyglot.util.*;
import java.util.*;
import polyglot.ext.jl5.ast.*;
import polyglot.ext.jl5.parse.JL5Name;
import polyglot.ext.jl5.types.FlagAnnotations;

/**
 * NodeFactory for esj extension.
 */
public interface ESJNodeFactory extends JL5NodeFactory {
    // TODO: Declare any factory methods for new AST nodes.

    ESJParameterizedNew ESJParameterizedNew(Position pos, Expr qualifier, TypeNode tn, List arguments, ClassBody body,List typeArguments);

    ESJEnsuredClassDecl ESJEnsuredClassDecl(Position pos, FlagAnnotations fl, String name, 
					    TypeNode superType, List interfaces, ClassBody body, 
					    List<ParamTypeNode> paramTypes, Expr ensuresExpr, 
					    boolean isPrimitive);

    ESJMethodDecl ESJMethodDecl(Position pos, FlagAnnotations flags,
				TypeNode returnType, String name,
				List formals,
				List throwTypes, Block body, List paramTypes);

    ESJConstructorDecl ESJConstructorDecl(Position pos, FlagAnnotations flags,
				String name,
				List formals,
				List throwTypes, Block body, List paramTypes);

    ESJPredMethodDecl ESJPredMethodDecl(Position pos, FlagAnnotations flags,
					TypeNode returnType, String name,
					List formals, List throwTypes, Block body, 
					List paramTypes, String quantMtdId, 
					FormulaBinary.Operator quantKind, String quantVarN, 
					List quantVarD, Expr quantListExpr, 
					Expr quantClauseExpr,
					boolean isSetComprehension, boolean isSingleComprehension);


    ESJLogPredMethodDecl ESJLogPredMethodDecl(Position pos, FlagAnnotations flags,
						TypeNode returnType, String name,
						List formals, List throwTypes, Block body, 
						List paramTypes, List quantVarD, List quantVarD2, 
						boolean isFallBack); 
   
    ESJEnsuredMethodDecl ESJEnsuredMethodDecl(Position pos, FlagAnnotations flags,
					      TypeNode returnType, String name,
					      List formals, List throwTypes, Block body, 
					      List paramTypes, Expr requiresExpr, Expr ensuresExpr, 
					      JL5Formal catchFormal, JL5LocalDecl resultVar,
					      List modifiableFields, Expr modifiableObjets,
					      List addedObjects, boolean isFreshResult, boolean isUniqueResults);

    ESJQuantifyExpr ESJQuantifyExpr(Position pos, FormulaBinary.Operator quantKind, String quantVarN, List quantVarD, List quantVarD2, Expr quantListExpr, Expr quantClauseExpr);

    ESJLogQuantifyExpr ESJLogQuantifyExpr(Position pos, FormulaBinary.Operator quantKind, String quantVarN, List quantVarD, List quantVarD2, Expr quantListExpr, Expr quantClauseExpr, ESJLogPredMethodDecl parentMethod, boolean isSetComprehension, boolean isSingleComprehension);

    ESJQuantifyTypeExpr ESJQuantifyTypeExpr(Position pos, TypeNode theListType);

    ESJBinary ESJBinary(Position pos, Expr left, Binary.Operator op, Expr right);
    ESJBinary ESJBinary(Position pos, Expr left, Binary.Operator op, Expr right, String kodkodOp);

    FormulaBinary FormulaBinary(Position pos, Expr left, Binary.Operator op, Expr right);
    FormulaBinary FormulaBinary(Position pos, Expr left, Binary.Operator op, Expr right, String kodkodOp);
    CmpBinary CmpBinary(Position pos, Expr left, Binary.Operator op, Expr right);
    CmpBinary CmpBinary(Position pos, Expr left, Binary.Operator op, Expr right, String kodkodOp);
    ESJModifiableField ESJModifiableField(Position pos, TypeNode fieldClass, String fieldName);
    ESJFieldDecl ESJFieldDecl(Position pos, FlagAnnotations flags, TypeNode type, String name, Expr init, boolean isResultField, boolean isResultFieldFresh);

    ESJFieldClosure ESJFieldClosure(Position pos, Receiver target, String name, FormulaBinary.Operator kind, List multiNames, String theType);

    ESJFieldCall ESJFieldCall(Position pos, Receiver target, String name, List arguments);

    ESJFieldClosureCall ESJFieldClosureCall(Position pos, Receiver target, String name, List arguments, FormulaBinary.Operator kind, boolean isIntSet);

    ESJNewArray ESJNewArray(Position pos, TypeNode baseType, List dims, int addDims, ArrayInit init);

    ESJIntervalExpr ESJIntervalExpr(Position pos, Expr lower, Expr upper);

    ESJIf ESJIf(Position pos, Expr cond, Stmt consequent, Stmt alternative);

    ESJBlock ESJBlock(Position pos, List statements);

    ESJField ESJField(Position pos, Receiver target, String name);

    ESJResultField ESJResultField(Position pos, Receiver target, String name, ESJEnsuredMethodDecl method);

    ESJLocalDecl ESJLocalDecl(Position pos, FlagAnnotations flags, TypeNode type, String name, Expr init, ESJEnsuredMethodDecl enclosingMethod);

    ESJCall ESJCall(Position pos, Receiver target, String name, List arguments);

    ESJAssume ESJAssume(Position pos, Expr cond);

}
