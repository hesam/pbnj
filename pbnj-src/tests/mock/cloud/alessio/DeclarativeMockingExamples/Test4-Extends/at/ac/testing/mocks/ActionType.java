package at.ac.testing.mocks;

enum ActionType {
    SCALE_DOWN (  ),
    
    SCALE_UP (  ),
    
    ;
    
    
    
    
    private ActionType() {
        
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr SCALE_DOWN_get_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                       polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                       String fallback_targetTypeArgsStr,
                                                                       String[] fallback_targetTypeArgs,
                                                                       boolean isOld) {
        return fallback_problem.objToSingletonRelation_log(ActionType.SCALE_DOWN);
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr SCALE_UP_get_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                     polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                     String fallback_targetTypeArgsStr,
                                                                     String[] fallback_targetTypeArgs,
                                                                     boolean isOld) {
        return fallback_problem.objToSingletonRelation_log(ActionType.SCALE_UP);
    }
}
