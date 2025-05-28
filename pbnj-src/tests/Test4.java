import polyglot.ext.pbnj.tologic.*;

public class Test4 implements polyglot.ext.pbnj.primitives.PBJInternObject {
    static int Y;
    
    public String toString() {
        return " Y=" +
        Y;
    }
    
    static int getY() {
        return Test4.Y;
    }
    
    public void m3_orig() {
        
    }
    
    public void m3b_orig() {
        
    }
    
    public static void main(String[] args) {
        LogMap.SolverOpt_IntBitWidth =
          6;
        Test4 t1 =
          new Test4();
        System.out.println(t1);
        t1.m3();
        System.out.println(t1);
    }
    
    public Test4 old;
    
    public boolean fallback_pbnj;
    
    Object fallback_field_result;
    
    public void fallback_field_result(Object r) {
        this.fallback_field_result =
          r;
    }
    
    public Test4() {
        super();
        this.addInstance();
    }
    
    public Test4(LogExpr dontcare) {
        super();
        this.addInstance();
    }
    
    Object[] fallback_field_resultArray;
    
    public void fallback_field_resultArray(Object[] r) {
        this.fallback_field_resultArray =
          r;
    }
    
    public boolean fallback_checkInvariants() {
        return true;
    }
    
    public void addInstance() {
        LogMap.addInstance(Test4.class,
                           this);
    }
    
    public void addInstanceForProblem(Test4 toAdd,
                                      LogProblem fallback_problem,
                                      String fallback_targetTypeArgsStr) {
        fallback_problem.addToClassInstances(toAdd,
                                             Test4.class,
                                             "Test4",
                                             fallback_targetTypeArgsStr);
    }
    
    long startMethodTime;
    
    boolean isOld;
    
    Object fallback_consistencyLock;
    
    int fallback_updateTime;
    
    public Test4 old() {
        return this.old;
    }
    
    String[] fallback_typeArgs;
    
    public Test4 fallback_setTypeArgs(String[] args) {
        this.fallback_typeArgs =
          args;
        return this;
    }
    
    int clonerStep =
      0;
    
    int atomizerStep =
      0;
    
    boolean isCloned() {
        return this.clonerStep ==
          LogMap.clonerStep();
    }
    
    boolean isAtomized(LogProblem fallback_problem) {
        return this.atomizerStep ==
          fallback_problem.relationizerStep();
    }
    
    int relationizerStep =
      0;
    
    boolean isRelationized(LogProblem fallback_problem) {
        return this.relationizerStep ==
          fallback_problem.relationizerStep();
    }
    
    public static int classRelationizerStep =
      0;
    
    public static boolean isClassRelationized(LogProblem fallback_problem) {
        return Test4.classRelationizerStep ==
          fallback_problem.relationizerStep();
    }
    
    public static int classAtomizerStep =
      0;
    
    public static boolean isClassAtomized(LogProblem fallback_problem) {
        return Test4.classAtomizerStep ==
          fallback_problem.relationizerStep();
    }
    
    public static int classClonerStep =
      0;
    
    public static boolean isClassCloned() {
        return Test4.classClonerStep ==
          LogMap.clonerStep();
    }
    
    void initEnsuredMethod() {
        this.startMethodTime =
          System.currentTimeMillis();
        LogMap.incrClonerStep();
        fallback_clone();
    }
    
    public void fallback_updateField(java.lang.reflect.Method updaterMtd,
                                     Object[] args) {
        try {
            updaterMtd.invoke(this,
                              args);
        }
        catch (Exception rte) {
            rte.printStackTrace();
        }
    }
    
    public Object fallback_newInstance(java.lang.reflect.Constructor cons,
                                       Object[] args,
                                       String[] typeParamNames) {
        try {
            return ((polyglot.ext.pbnj.primitives.PBJInternObject)
                      cons.newInstance(args)).fallback_setTypeArgs(typeParamNames);
        }
        catch (Exception rte) {
            rte.printStackTrace();
            return null;
        }
    }
    
    public boolean m3_checkContract() {
        return this.fallback_checkInvariants() &&
                 this.m3_checkFieldsInvariants() &&
          this.Y !=
            0;
    }
    
    public void m3_assertContract() {
        assert m3_checkContract();
    }
    
    public void m3_commitModel(LogProblem fallback_problem) {
        fallback_problem.commitModel(this);
    }
    
    LogProblem m3_planb() {
        System.out.println("\n" +
                             (this +
                                (" (" +
                                   (Thread.currentThread() +
                                      (": m3" +
                                         ") initiated plan b...")))));
        LogProblem fallback_problem =
          LogMap.initRelationize();
        String fallback_targetTypeArgsStr =
          "";
        String[] fallback_targetTypeArgs =
          null;
        old.fallback_atomize(fallback_problem,
                             "",
                             null);
        fallback_problem.ObjToAtomMap();
        old.fallback_relationizeOld(fallback_problem,
                                    "",
                                    null);
        fallback_problem.initRelations();
        LogExpr fallback_target =
          fallback_problem.objToSingletonRelation_log(this);
        boolean fallback_target_isOld =
          false;
        LogExpr fallback_formula =
          Test4.m3_checkContract_log(fallback_problem,
                                     fallback_target,
                                     fallback_targetTypeArgsStr,
                                     fallback_targetTypeArgs,
                                     fallback_target_isOld);
        boolean isSatisfiable =
          fallback_problem.solve("m3",
                                 this,
                                 fallback_formula.formula(),
                                 null,
                                 false,
                                 false,
                                 this.startMethodTime,
                                 false);
        assert isSatisfiable: "Formula UNSAT! Recovery failed...";
        return fallback_problem;
    }
    
    public void m3() {
        m3_ensured();
    }
    
    public void m3_ensured() {
        initEnsuredMethod();
        try {
            m3_orig();
            m3_assertContract();
        }
        catch (Throwable rte) {
            {
                rte.printStackTrace();
                LogProblem fallback_problem =
                  m3_planb();
                m3_commitModel(fallback_problem);
            }
        }
    }
    
    public boolean m3_checkFieldsInvariants() {
        return true;
    }
    
    public boolean m3b_checkContract() {
        return this.fallback_checkInvariants() &&
                 this.m3b_checkFieldsInvariants() &&
          getY() !=
            0;
    }
    
    public void m3b_assertContract() {
        assert m3b_checkContract();
    }
    
    public void m3b_commitModel(LogProblem fallback_problem) {
        fallback_problem.commitModel(this);
    }
    
    LogProblem m3b_planb() {
        System.out.println("\n" +
                             (this +
                                (" (" +
                                   (Thread.currentThread() +
                                      (": m3b" +
                                         ") initiated plan b...")))));
        LogProblem fallback_problem =
          LogMap.initRelationize();
        String fallback_targetTypeArgsStr =
          "";
        String[] fallback_targetTypeArgs =
          null;
        old.fallback_atomize(fallback_problem,
                             "",
                             null);
        fallback_problem.ObjToAtomMap();
        old.fallback_relationizeOld(fallback_problem,
                                    "",
                                    null);
        fallback_problem.initRelations();
        LogExpr fallback_target =
          fallback_problem.objToSingletonRelation_log(this);
        boolean fallback_target_isOld =
          false;
        LogExpr fallback_formula =
          Test4.m3b_checkContract_log(fallback_problem,
                                      fallback_target,
                                      fallback_targetTypeArgsStr,
                                      fallback_targetTypeArgs,
                                      fallback_target_isOld);
        boolean isSatisfiable =
          fallback_problem.solve("m3b",
                                 this,
                                 fallback_formula.formula(),
                                 null,
                                 false,
                                 false,
                                 this.startMethodTime,
                                 false);
        assert isSatisfiable: "Formula UNSAT! Recovery failed...";
        return fallback_problem;
    }
    
    public void m3b() {
        m3b_ensured();
    }
    
    public void m3b_ensured() {
        initEnsuredMethod();
        try {
            m3b_orig();
            m3b_assertContract();
        }
        catch (Throwable rte) {
            {
                rte.printStackTrace();
                LogProblem fallback_problem =
                  m3b_planb();
                m3b_commitModel(fallback_problem);
            }
        }
    }
    
    public boolean m3b_checkFieldsInvariants() {
        return true;
    }
    
    public void fallback_atomize(LogProblem fallback_problem,
                                 String fallback_targetTypeArgsStr,
                                 String[] fallback_targetTypeArgs) {
        if (!isAtomized(fallback_problem)) {
            this.atomizerStep =
              fallback_problem.relationizerStep();
            Test4.fallback_classAtomize(fallback_problem,
                                        fallback_targetTypeArgsStr,
                                        fallback_targetTypeArgs);
            this.addInstanceForProblem(this.old,
                                       fallback_problem,
                                       fallback_targetTypeArgsStr);
        }
    }
    
    public void fallback_relationizeOld(LogProblem fallback_problem,
                                        String fallback_targetTypeArgsStr,
                                        String[] fallback_targetTypeArgs) {
        if (!isRelationized(fallback_problem)) {
            this.relationizerStep =
              fallback_problem.relationizerStep();
            Test4.fallback_classRelationizeOld(fallback_problem,
                                               fallback_targetTypeArgsStr,
                                               fallback_targetTypeArgs);
        }
    }
    
    public static void fallback_classAtomize(LogProblem fallback_problem,
                                             String fallback_targetTypeArgsStr,
                                             String[] fallback_targetTypeArgs) {
        if (!isClassAtomized(fallback_problem)) {
            Test4.classAtomizerStep =
              fallback_problem.relationizerStep();
        }
    }
    
    public static void fallback_classRelationizeOld(LogProblem fallback_problem,
                                                    String fallback_targetTypeArgsStr,
                                                    String[] fallback_targetTypeArgs) {
        if (!isClassRelationized(fallback_problem)) {
            Test4.classRelationizerStep =
              fallback_problem.relationizerStep();
            Test4.Y_old_get_log(fallback_problem,
                                fallback_targetTypeArgsStr,
                                fallback_targetTypeArgs).put_log(fallback_problem,
                                                                 "Test4",
                                                                 Test4.Y);
        }
    }
    
    public static void fallback_classClone() {
        if (isClassCloned())
            return;
    }
    
    public Test4 fallback_clone() {
        if (isCloned())
            return old;
        Test4 res =
          null;
        Test4.fallback_classClone();
        try {
            res =
              (Test4)
                super.clone();
            res.isOld =
              true;
            this.old =
              res;
            res.old =
              this;
            this.fallback_consistencyLock =
              new Object();
            this.clonerStep =
              LogMap.clonerStep();
        }
        catch (Exception rte) {
            rte.printStackTrace();
            System.exit(1);
        }
        return res;
    }
    
    public static LogExpr Y_get_log(LogProblem fallback_problem,
                                    LogExpr fallback_target,
                                    String fallback_targetTypeArgsStr,
                                    String[] fallback_targetTypeArgs,
                                    boolean isOld) {
        return LogMap.fieldGet_log(fallback_problem,
                                   fallback_target,
                                   "Test4",
                                   fallback_targetTypeArgsStr,
                                   "Y",
                                   false);
    }
    
    public static LogRelation Y_old_get_log(LogProblem fallback_problem,
                                            String fallback_targetTypeArgsStr,
                                            String[] fallback_targetTypeArgs) {
        return LogMap.oldFieldGet_log(fallback_problem,
                                      "Test4",
                                      fallback_targetTypeArgsStr,
                                      "Y");
    }
    
    public int fallback_updateField_Y(Integer newVal) {
        return Test4.Y =
          newVal;
    }
    
    public static void fallback_initClassDefs() {
        
    }
    
    static {
               LogMap.newClassForLog(Test4.class,
                                     true);
               LogMap.newInstVarRel("Y",
                                    Test4.class,
                                    "Test4",
                                    Integer.class,
                                    "int",
                                    null,
                                    null,
                                    false,
                                    true,
                                    0,
                                    true,
                                    false,
                                    false,
                                    false,
                                    false);
           }
    
    static LogExpr getY_log(LogProblem fallback_problem,
                            LogExpr fallback_target,
                            String fallback_targetTypeArgsStr,
                            String[] fallback_targetTypeArgs,
                            boolean fallback_target_isOld) {
        return Test4.Y_get_log(fallback_problem,
                               fallback_problem.class_log(Test4.class),
                               fallback_targetTypeArgsStr,
                               fallback_targetTypeArgs,
                               fallback_target_isOld);
    }
    
    public static LogExpr fallback_checkInvariants_log(LogProblem fallback_problem,
                                                       LogExpr fallback_target,
                                                       String fallback_targetTypeArgsStr,
                                                       String[] fallback_targetTypeArgs,
                                                       boolean fallback_target_isOld) {
        return new LogExpr(fallback_problem,
                           kodkod.ast.Formula.TRUE);
    }
    
    public static LogExpr m3_checkContract_log(LogProblem fallback_problem,
                                               LogExpr fallback_target,
                                               String fallback_targetTypeArgsStr,
                                               String[] fallback_targetTypeArgs,
                                               boolean fallback_target_isOld) {
        return Test4.fallback_checkInvariants_log(fallback_problem,
                                                  fallback_target,
                                                  fallback_targetTypeArgsStr,
                                                  fallback_targetTypeArgs,
                                                  fallback_target_isOld).and(Test4.m3_checkFieldsInvariants_log(fallback_problem,
                                                                                                                fallback_target,
                                                                                                                fallback_targetTypeArgsStr,
                                                                                                                fallback_targetTypeArgs,
                                                                                                                fallback_target_isOld)).and(Test4.Y_get_log(fallback_problem,
                                                                                                                                                            fallback_target,
                                                                                                                                                            fallback_targetTypeArgsStr,
                                                                                                                                                            fallback_targetTypeArgs,
                                                                                                                                                            fallback_target_isOld).eq(new LogExpr(fallback_problem,
                                                                                                                                                                                                  kodkod.ast.IntConstant.constant(0))).not());
    }
    
    public static LogExpr m3_checkFieldsInvariants_log(LogProblem fallback_problem,
                                                       LogExpr fallback_target,
                                                       String fallback_targetTypeArgsStr,
                                                       String[] fallback_targetTypeArgs,
                                                       boolean fallback_target_isOld) {
        return new LogExpr(fallback_problem,
                           kodkod.ast.Formula.TRUE);
    }
    
    public static LogExpr m3b_checkContract_log(LogProblem fallback_problem,
                                                LogExpr fallback_target,
                                                String fallback_targetTypeArgsStr,
                                                String[] fallback_targetTypeArgs,
                                                boolean fallback_target_isOld) {
        return Test4.fallback_checkInvariants_log(fallback_problem,
                                                  fallback_target,
                                                  fallback_targetTypeArgsStr,
                                                  fallback_targetTypeArgs,
                                                  fallback_target_isOld).and(Test4.m3b_checkFieldsInvariants_log(fallback_problem,
                                                                                                                 fallback_target,
                                                                                                                 fallback_targetTypeArgsStr,
                                                                                                                 fallback_targetTypeArgs,
                                                                                                                 fallback_target_isOld)).and(Test4.getY_log(fallback_problem,
                                                                                                                                                            fallback_problem.class_log(Test4.class),
                                                                                                                                                            fallback_targetTypeArgsStr,
                                                                                                                                                            fallback_targetTypeArgs,
                                                                                                                                                            fallback_target_isOld).eq(new LogExpr(fallback_problem,
                                                                                                                                                                                                  kodkod.ast.IntConstant.constant(0))).not());
    }
    
    public static LogExpr m3b_checkFieldsInvariants_log(LogProblem fallback_problem,
                                                        LogExpr fallback_target,
                                                        String fallback_targetTypeArgsStr,
                                                        String[] fallback_targetTypeArgs,
                                                        boolean fallback_target_isOld) {
        return new LogExpr(fallback_problem,
                           kodkod.ast.Formula.TRUE);
    }
}
