package polyglot.ext.pbnj.ast;

import polyglot.ast.*;
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
public class ESJNodeFactory_c extends JL5NodeFactory_c
    implements ESJNodeFactory {

    // TODO:  Implement factory methods for new AST nodes.
    // TODO:  Override factory methods for overriden AST nodes.
    // TODO:  Override factory methods for AST nodes with new extension nodes.

    public ESJParameterizedNew ESJParameterizedNew(Position pos, Expr qualifier, TypeNode tn, List arguments, ClassBody body,List typeArguments) {
        return new ESJParameterizedNew_c(pos, qualifier, tn, arguments, body, typeArguments);
    }


    public ESJEnsuredClassDecl ESJEnsuredClassDecl(Position pos, FlagAnnotations fl, 
						   String name, TypeNode superType, 
						   List interfaces, ClassBody body, 
						   List<ParamTypeNode> paramTypes,
						   Expr ensuresExpr, boolean isPrimitive) {
	return new ESJEnsuredClassDecl_c(pos, fl, name, superType, interfaces, body, paramTypes, ensuresExpr, isPrimitive);
    }

    public ESJMethodDecl ESJMethodDecl(Position pos, FlagAnnotations flags,
				       TypeNode returnType, String name,
				       List formals,
				       List throwTypes, Block body, List paramTypes) {
	return new ESJMethodDecl_c(pos, flags, returnType, name, formals, throwTypes, body, paramTypes);
    }

    public ESJConstructorDecl ESJConstructorDecl(Position pos, FlagAnnotations flags,
				       String name,
				       List formals,
				       List throwTypes, Block body, List paramTypes) {
	return new ESJConstructorDecl_c(pos, flags, name, formals, throwTypes, body, paramTypes);
    }

    public ESJPredMethodDecl ESJPredMethodDecl(Position pos, FlagAnnotations flags, 
					       TypeNode returnType, String name, List formals, 
					       List throwTypes, Block body, List paramTypes, 
					       String quantMtdId, FormulaBinary.Operator quantKind, 
					       String quantVarN, List quantVarD,
					       Expr quantListExpr, 
					       Expr quantClauseExpr, 
					       boolean isSetComprehension, boolean isSingleComprehension) {	
    	return new ESJPredMethodDecl_c(pos, flags, returnType, name, formals, throwTypes, body, paramTypes, quantMtdId, quantKind, quantVarN, quantVarD, quantListExpr, quantClauseExpr, isSetComprehension, isSingleComprehension);
    }


    public ESJLogPredMethodDecl ESJLogPredMethodDecl(Position pos, FlagAnnotations flags, 
						       TypeNode returnType, String name, 
						       List formals, List throwTypes, Block body, 
						       List paramTypes, List quantVarD, 
						       List quantVarD2, boolean isFallBack) {	
    	return new ESJLogPredMethodDecl_c(pos, flags, returnType, name, formals, throwTypes, body, paramTypes, quantVarD, quantVarD2, isFallBack);
    }

    public ESJEnsuredMethodDecl ESJEnsuredMethodDecl(Position pos, FlagAnnotations flags,
						     TypeNode returnType, String name,
						     List formals, List throwTypes, Block body, 
						     List paramTypes, Expr requiresExpr, 
						     Expr ensuresExpr, JL5Formal catchFormal, 
						     JL5LocalDecl resultVar,
						     List modifiableFields, 
						     Expr modifiableObjets, 
						     List addedObjects, boolean isFreshResult, boolean isUniqueResults) {
	return new ESJEnsuredMethodDecl_c(pos, flags, returnType, name, formals, throwTypes, body, paramTypes, requiresExpr, ensuresExpr, catchFormal, resultVar, modifiableFields, modifiableObjets, addedObjects, isFreshResult, isUniqueResults);

    }

    public ESJQuantifyExpr ESJQuantifyExpr(Position pos, FormulaBinary.Operator quantKind, 
					   String quantVarN, 
					   List quantVarD, List quantVarD2, 
					   Expr quantListExpr, Expr quantClauseExpr) {
	return new ESJQuantifyExpr_c(pos, quantKind, quantVarN, quantVarD, quantVarD2, quantListExpr, quantClauseExpr);
    }

    public ESJLogQuantifyExpr ESJLogQuantifyExpr(Position pos, FormulaBinary.Operator quantKind,
						 String quantVarN, List quantVarD, 
						 List quantVarD2, Expr quantListExpr, 
						 Expr quantClauseExpr, 
						 ESJLogPredMethodDecl parentMethod, 
						 boolean isSetComprehension, 
						 boolean isSingleComprehension) {
	return new ESJLogQuantifyExpr_c(pos, quantKind, quantVarN, quantVarD, quantVarD2, quantListExpr, quantClauseExpr, parentMethod, isSetComprehension, isSingleComprehension);
    }

    public ESJQuantifyTypeExpr ESJQuantifyTypeExpr(Position pos, TypeNode theListType) {
	return new ESJQuantifyTypeExpr_c(pos, theListType);
    }

    public ESJBinary ESJBinary(Position pos, Expr left, Binary.Operator op, Expr right, String kodkodOp) {
	return new ESJBinary_c(pos, left, op, right, kodkodOp);
    }

    public ESJBinary ESJBinary(Position pos, Expr left, Binary.Operator op, Expr right) {
	return new ESJBinary_c(pos, left, op, right);
    }

    public FormulaBinary FormulaBinary(Position pos, Expr left, Binary.Operator op, Expr right, String kodkodOp) {
	return new FormulaBinary_c(pos, left, op, right, kodkodOp);
    }

    public FormulaBinary FormulaBinary(Position pos, Expr left, Binary.Operator op, Expr right) {
	return new FormulaBinary_c(pos, left, op, right);
    }

    public CmpBinary CmpBinary(Position pos, Expr left, Binary.Operator op, Expr right, String kodkodOp) {
	return new CmpBinary_c(pos, left, op, right, kodkodOp);
    }

    public CmpBinary CmpBinary(Position pos, Expr left, Binary.Operator op, Expr right) {
	return new CmpBinary_c(pos, left, op, right);
    }
    
    public ESJModifiableField ESJModifiableField(Position pos, TypeNode fieldClass, String fieldName) {
	return new ESJModifiableField_c(pos, fieldClass, fieldName);
    }
    public ESJFieldDecl ESJFieldDecl(Position pos, FlagAnnotations flags, TypeNode type, String name, Expr init, boolean isResultField, boolean isResultFieldFresh) {
	return new ESJFieldDecl_c(pos, flags, type, name, init, isResultField, isResultFieldFresh);
    }

    public ESJFieldClosure ESJFieldClosure(Position pos, Receiver target, String name, FormulaBinary.Operator kind, List multiNames, String theType) {
	return new  ESJFieldClosure_c(pos, target, name, kind, multiNames, theType);
    }

    public ESJFieldCall ESJFieldCall(Position pos, Receiver target, String name, List arguments) {
	return new ESJFieldCall_c(pos, target, name, arguments);
    }

    public ESJFieldClosureCall ESJFieldClosureCall(Position pos, Receiver target, String name, List arguments, FormulaBinary.Operator kind, boolean isIntSet) {
	return new ESJFieldClosureCall_c(pos, target, name, arguments, kind, isIntSet);
    }

    public ESJNewArray ESJNewArray(Position pos, TypeNode baseType, List dims, int addDims, ArrayInit init) {
	return new ESJNewArray_c(pos, baseType, dims, addDims, init);
    }

    public ESJIntervalExpr ESJIntervalExpr(Position pos, Expr lower, Expr upper) {
	return new ESJIntervalExpr_c(pos, lower, upper);
    }

    public ESJIf ESJIf(Position pos, Expr cond, Stmt consequent, Stmt alternative) {
	return new ESJIf_c(pos, cond, consequent, alternative);
    }

    public ESJField ESJField(Position pos, Receiver target, String name) {
	return new ESJField_c(pos, target, name);
    }

    public ESJResultField ESJResultField(Position pos, Receiver target, String name, ESJEnsuredMethodDecl method) {
	return new ESJResultField_c(pos, target, name, method);
    }

    public ESJBlock ESJBlock(Position pos, List statements) {
	return new ESJBlock_c(pos, statements);
    }

    public ESJLocalDecl ESJLocalDecl(Position pos, FlagAnnotations flags, TypeNode type, String name, Expr init, ESJEnsuredMethodDecl enclosingMethod) {
	return new ESJLocalDecl_c(pos, flags, type, name, init, enclosingMethod);
    }

    public ESJCall ESJCall(Position pos, Receiver target, String name, List arguments) {
	return new ESJCall_c(pos, target, name, arguments);
    }

    public ESJAssume ESJAssume(Position pos, Expr cond) {
	return new ESJAssume_c(pos, cond);
    }

}
