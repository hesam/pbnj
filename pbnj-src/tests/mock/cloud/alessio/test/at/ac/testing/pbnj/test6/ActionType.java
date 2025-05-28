package at.ac.testing.pbnj.test6;

public enum ActionType {
    SCALE_UP (  ),
    
    SCALE_DOWN (  ),
    
    STAY (  ),
    
    ;
    
    
    
    
    private ActionType() {
        
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr SCALE_UP_get_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                     polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                     String fallback_targetTypeArgsStr,
                                                                     String[] fallback_targetTypeArgs,
                                                                     boolean isOld) {
        return fallback_problem.objToSingletonRelation_log(ActionType.SCALE_UP);
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr SCALE_DOWN_get_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                       polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                       String fallback_targetTypeArgsStr,
                                                                       String[] fallback_targetTypeArgs,
                                                                       boolean isOld) {
        return fallback_problem.objToSingletonRelation_log(ActionType.SCALE_DOWN);
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr STAY_get_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                 polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                 String fallback_targetTypeArgsStr,
                                                                 String[] fallback_targetTypeArgs,
                                                                 boolean isOld) {
        return fallback_problem.objToSingletonRelation_log(ActionType.STAY);
    }
}
