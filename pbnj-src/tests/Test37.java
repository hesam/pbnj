import polyglot.ext.pbnj.tologic.*;

public class Test37 implements polyglot.ext.pbnj.primitives.PBJInternObject {
    int x;
    
    public Test37() {
        super();
        this.addInstance();
    }
    
    public String toString() {
        return " x=" +
        x;
    }
    
    public void foo() {
        System.out.println(x);
        this.fallback_assume_0();
        System.out.println(x);
        this.fallback_assume_1();
        System.out.println(x);
        this.fallback_assume_2();
        System.out.println(x);
    }
    
    public static void main(String[] args) {
        LogMap.SolverOpt_IntBitWidth =
          5;
        Test37 t1 =
          new Test37();
        t1.foo();
    }
    
    public Test37 old;
    
    public boolean fallback_pbnj;
    
    Object fallback_field_result;
    
    public void fallback_field_result(Object r) {
        this.fallback_field_result =
          r;
    }
    
    public Test37(LogExpr dontcare) {
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
        LogMap.addInstance(Test37.class,
                           this);
    }
    
    public void addInstanceForProblem(Test37 toAdd,
                                      LogProblem fallback_problem,
                                      String fallback_targetTypeArgsStr) {
        fallback_problem.addToClassInstances(toAdd,
                                             Test37.class,
                                             "Test37",
                                             fallback_targetTypeArgsStr);
    }
    
    long startMethodTime;
    
    boolean isOld;
    
    Object fallback_consistencyLock;
    
    int fallback_updateTime;
    
    public Test37 old() {
        return this.old;
    }
    
    String[] fallback_typeArgs;
    
    public Test37 fallback_setTypeArgs(String[] args) {
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
        return Test37.classRelationizerStep ==
          fallback_problem.relationizerStep();
    }
    
    public static int classAtomizerStep =
      0;
    
    public static boolean isClassAtomized(LogProblem fallback_problem) {
        return Test37.classAtomizerStep ==
          fallback_problem.relationizerStep();
    }
    
    public static int classClonerStep =
      0;
    
    public static boolean isClassCloned() {
        return Test37.classClonerStep ==
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
    
    public void fallback_assume_0_orig() {
        
    }
    
    public void fallback_assume_1_orig() {
        
    }
    
    public void fallback_assume_2_orig() {
        
    }
    
    public boolean fallback_assume_0_checkContract() {
        return this.fallback_checkInvariants() &&
                 this.fallback_assume_0_checkFieldsInvariants() &&
          this.x <
            0;
    }
    
    public void fallback_assume_0_assertContract() {
        assert fallback_assume_0_checkContract();
    }
    
    public void fallback_assume_0_commitModel(LogProblem fallback_problem) {
        fallback_problem.commitModel(this);
    }
    
    LogProblem fallback_assume_0_planb() {
        System.out.println("\n" +
                             (this +
                                (" (" +
                                   (Thread.currentThread() +
                                      (": fallback_assume_0" +
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
          Test37.fallback_assume_0_checkContract_log(fallback_problem,
                                                     fallback_target,
                                                     fallback_targetTypeArgsStr,
                                                     fallback_targetTypeArgs,
                                                     fallback_target_isOld);
        boolean isSatisfiable =
          fallback_problem.solve("fallback_assume_0",
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
    
    public void fallback_assume_0() {
        fallback_assume_0_ensured();
    }
    
    public void fallback_assume_0_ensured() {
        initEnsuredMethod();
        try {
            fallback_assume_0_orig();
            fallback_assume_0_assertContract();
        }
        catch (Throwable rte) {
            {
                rte.printStackTrace();
                LogProblem fallback_problem =
                  fallback_assume_0_planb();
                fallback_assume_0_commitModel(fallback_problem);
            }
        }
    }
    
    public boolean fallback_assume_0_checkFieldsInvariants() {
        return true;
    }
    
    public boolean fallback_assume_1_checkContract() {
        return this.fallback_checkInvariants() &&
                 this.fallback_assume_1_checkFieldsInvariants() &&
          this.x <
            -10;
    }
    
    public void fallback_assume_1_assertContract() {
        assert fallback_assume_1_checkContract();
    }
    
    public void fallback_assume_1_commitModel(LogProblem fallback_problem) {
        fallback_problem.commitModel(this);
    }
    
    LogProblem fallback_assume_1_planb() {
        System.out.println("\n" +
                             (this +
                                (" (" +
                                   (Thread.currentThread() +
                                      (": fallback_assume_1" +
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
          Test37.fallback_assume_1_checkContract_log(fallback_problem,
                                                     fallback_target,
                                                     fallback_targetTypeArgsStr,
                                                     fallback_targetTypeArgs,
                                                     fallback_target_isOld);
        boolean isSatisfiable =
          fallback_problem.solve("fallback_assume_1",
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
    
    public void fallback_assume_1() {
        fallback_assume_1_ensured();
    }
    
    public void fallback_assume_1_ensured() {
        initEnsuredMethod();
        try {
            fallback_assume_1_orig();
            fallback_assume_1_assertContract();
        }
        catch (Throwable rte) {
            {
                rte.printStackTrace();
                LogProblem fallback_problem =
                  fallback_assume_1_planb();
                fallback_assume_1_commitModel(fallback_problem);
            }
        }
    }
    
    public boolean fallback_assume_1_checkFieldsInvariants() {
        return true;
    }
    
    public boolean fallback_assume_2_checkContract() {
        return this.fallback_checkInvariants() &&
                 this.fallback_assume_2_checkFieldsInvariants() &&
          this.x <
            -5;
    }
    
    public void fallback_assume_2_assertContract() {
        assert fallback_assume_2_checkContract();
    }
    
    public void fallback_assume_2_commitModel(LogProblem fallback_problem) {
        fallback_problem.commitModel(this);
    }
    
    LogProblem fallback_assume_2_planb() {
        System.out.println("\n" +
                             (this +
                                (" (" +
                                   (Thread.currentThread() +
                                      (": fallback_assume_2" +
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
          Test37.fallback_assume_2_checkContract_log(fallback_problem,
                                                     fallback_target,
                                                     fallback_targetTypeArgsStr,
                                                     fallback_targetTypeArgs,
                                                     fallback_target_isOld);
        boolean isSatisfiable =
          fallback_problem.solve("fallback_assume_2",
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
    
    public void fallback_assume_2() {
        fallback_assume_2_ensured();
    }
    
    public void fallback_assume_2_ensured() {
        initEnsuredMethod();
        try {
            fallback_assume_2_orig();
            fallback_assume_2_assertContract();
        }
        catch (Throwable rte) {
            {
                rte.printStackTrace();
                LogProblem fallback_problem =
                  fallback_assume_2_planb();
                fallback_assume_2_commitModel(fallback_problem);
            }
        }
    }
    
    public boolean fallback_assume_2_checkFieldsInvariants() {
        return true;
    }
    
    public void fallback_atomize(LogProblem fallback_problem,
                                 String fallback_targetTypeArgsStr,
                                 String[] fallback_targetTypeArgs) {
        if (!isAtomized(fallback_problem)) {
            this.atomizerStep =
              fallback_problem.relationizerStep();
            Test37.fallback_classAtomize(fallback_problem,
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
            Test37.fallback_classRelationizeOld(fallback_problem,
                                                fallback_targetTypeArgsStr,
                                                fallback_targetTypeArgs);
            Test37.x_old_get_log(fallback_problem,
                                 fallback_targetTypeArgsStr,
                                 fallback_targetTypeArgs).put_log(fallback_problem,
                                                                  this,
                                                                  this.x);
        }
    }
    
    public static void fallback_classAtomize(LogProblem fallback_problem,
                                             String fallback_targetTypeArgsStr,
                                             String[] fallback_targetTypeArgs) {
        if (!isClassAtomized(fallback_problem)) {
            Test37.classAtomizerStep =
              fallback_problem.relationizerStep();
        }
    }
    
    public static void fallback_classRelationizeOld(LogProblem fallback_problem,
                                                    String fallback_targetTypeArgsStr,
                                                    String[] fallback_targetTypeArgs) {
        if (!isClassRelationized(fallback_problem)) {
            Test37.classRelationizerStep =
              fallback_problem.relationizerStep();
        }
    }
    
    public static void fallback_classClone() {
        if (isClassCloned())
            return;
    }
    
    public Test37 fallback_clone() {
        if (isCloned())
            return old;
        Test37 res =
          null;
        Test37.fallback_classClone();
        try {
            res =
              (Test37)
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
            res.x =
              this.x;
        }
        catch (Exception rte) {
            rte.printStackTrace();
            System.exit(1);
        }
        return res;
    }
    
    public static LogExpr x_get_log(LogProblem fallback_problem,
                                    LogExpr fallback_target,
                                    String fallback_targetTypeArgsStr,
                                    String[] fallback_targetTypeArgs,
                                    boolean isOld) {
        return LogMap.fieldGet_log(fallback_problem,
                                   fallback_target,
                                   "Test37",
                                   fallback_targetTypeArgsStr,
                                   "x",
                                   isOld);
    }
    
    public static LogRelation x_old_get_log(LogProblem fallback_problem,
                                            String fallback_targetTypeArgsStr,
                                            String[] fallback_targetTypeArgs) {
        return LogMap.oldFieldGet_log(fallback_problem,
                                      "Test37",
                                      fallback_targetTypeArgsStr,
                                      "x");
    }
    
    public int fallback_updateField_x(Integer newVal) {
        return this.x =
          newVal;
    }
    
    public polyglot.ext.pbnj.primitives.PBJInternSet<Integer> fieldsClosure_Integer(Object fallback_target,
                                                                                    boolean isReflexive,
                                                                                    java.lang.String ... fieldNs) {
        Class c =
          int.class;
        polyglot.ext.pbnj.primitives.PBJInternSet<Integer> res =
          new polyglot.ext.pbnj.primitives.PBJInternSet<Integer>();
        java.util.ArrayList<Integer> workList =
          new java.util.ArrayList<Integer>();
        try {
            java.util.ArrayList<java.lang.reflect.Field> fields =
              new java.util.ArrayList<java.lang.reflect.Field>();
            for (String fN : fieldNs) {
                fields.add(c.getField(fN));
            }
            for (java.lang.reflect.Field f : fields) {
                Integer childN =
                  (Integer)
                    f.get(fallback_target);
                if (!(childN ==
                        null ||
                        res.containsPtrEqCmp(childN)))
                    workList.add(childN);
            }
            Integer n;
            while (workList.size() >
                     0) {
                n =
                  workList.get(0);
                res.add(n);
                for (java.lang.reflect.Field f : fields) {
                    Integer childN =
                      (Integer)
                        f.get(n);
                    if (!(childN ==
                            null ||
                            res.containsPtrEqCmp(childN)))
                        workList.add(childN);
                }
                workList.remove(n);
            }
            if (isReflexive)
                res.add((Integer)
                          fallback_target);
        }
        catch (Exception rte) {
            rte.printStackTrace();
        }
        return res;
    }
    
    polyglot.ext.pbnj.primitives.PBJInternSet<Integer> multiFields_Integer(java.lang.String ... fieldNs) {
        Class c =
          Integer.class;
        polyglot.ext.pbnj.primitives.PBJInternSet<Integer> res =
          new polyglot.ext.pbnj.primitives.PBJInternSet<Integer>();
        try {
            for (String fN : fieldNs) {
                java.lang.reflect.Field f =
                  c.getField(fN);
                Integer n =
                  (Integer)
                    f.get(this);
                if (n !=
                      null)
                    res.add(n);
            }
        }
        catch (Exception rte) {
            rte.printStackTrace();
        }
        return res;
    }
    
    public static polyglot.ext.pbnj.primitives.PBJInternSet<Integer> setMap_x(polyglot.ext.pbnj.primitives.PBJInternSet<Test37> objs,
                                                                              java.lang.String ... fieldNs) {
        polyglot.ext.pbnj.primitives.PBJInternSet<Integer> res =
          new polyglot.ext.pbnj.primitives.PBJInternSet<Integer>();
        java.util.Iterator<Test37> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().x);
        }
        return res;
    }
    
    public static void fallback_initClassDefs() {
        
    }
    
    static {
               LogMap.newClassForLog(Test37.class,
                                     true);
               LogMap.newInstVarRel("x",
                                    Test37.class,
                                    "Test37",
                                    Integer.class,
                                    "int",
                                    null,
                                    null,
                                    false,
                                    false,
                                    0,
                                    true,
                                    false,
                                    false,
                                    false,
                                    false);
           }
    
    public static LogExpr fallback_checkInvariants_log(LogProblem fallback_problem,
                                                       LogExpr fallback_target,
                                                       String fallback_targetTypeArgsStr,
                                                       String[] fallback_targetTypeArgs,
                                                       boolean fallback_target_isOld) {
        return new LogExpr(fallback_problem,
                           kodkod.ast.Formula.TRUE);
    }
    
    public static LogExpr fallback_assume_0_checkContract_log(LogProblem fallback_problem,
                                                              LogExpr fallback_target,
                                                              String fallback_targetTypeArgsStr,
                                                              String[] fallback_targetTypeArgs,
                                                              boolean fallback_target_isOld) {
        return Test37.fallback_checkInvariants_log(fallback_problem,
                                                   fallback_target,
                                                   fallback_targetTypeArgsStr,
                                                   fallback_targetTypeArgs,
                                                   fallback_target_isOld).and(Test37.fallback_assume_0_checkFieldsInvariants_log(fallback_problem,
                                                                                                                                 fallback_target,
                                                                                                                                 fallback_targetTypeArgsStr,
                                                                                                                                 fallback_targetTypeArgs,
                                                                                                                                 fallback_target_isOld)).and(Test37.x_get_log(fallback_problem,
                                                                                                                                                                              fallback_target,
                                                                                                                                                                              fallback_targetTypeArgsStr,
                                                                                                                                                                              fallback_targetTypeArgs,
                                                                                                                                                                              fallback_target_isOld).lt(new LogExpr(fallback_problem,
                                                                                                                                                                                                                    kodkod.ast.IntConstant.constant(0))));
    }
    
    public static LogExpr fallback_assume_0_checkFieldsInvariants_log(LogProblem fallback_problem,
                                                                      LogExpr fallback_target,
                                                                      String fallback_targetTypeArgsStr,
                                                                      String[] fallback_targetTypeArgs,
                                                                      boolean fallback_target_isOld) {
        return new LogExpr(fallback_problem,
                           kodkod.ast.Formula.TRUE);
    }
    
    public static LogExpr fallback_assume_1_checkContract_log(LogProblem fallback_problem,
                                                              LogExpr fallback_target,
                                                              String fallback_targetTypeArgsStr,
                                                              String[] fallback_targetTypeArgs,
                                                              boolean fallback_target_isOld) {
        return Test37.fallback_checkInvariants_log(fallback_problem,
                                                   fallback_target,
                                                   fallback_targetTypeArgsStr,
                                                   fallback_targetTypeArgs,
                                                   fallback_target_isOld).and(Test37.fallback_assume_1_checkFieldsInvariants_log(fallback_problem,
                                                                                                                                 fallback_target,
                                                                                                                                 fallback_targetTypeArgsStr,
                                                                                                                                 fallback_targetTypeArgs,
                                                                                                                                 fallback_target_isOld)).and(Test37.x_get_log(fallback_problem,
                                                                                                                                                                              fallback_target,
                                                                                                                                                                              fallback_targetTypeArgsStr,
                                                                                                                                                                              fallback_targetTypeArgs,
                                                                                                                                                                              fallback_target_isOld).lt(new LogExpr(fallback_problem,
                                                                                                                                                                                                                    kodkod.ast.IntConstant.constant(10)).negate()));
    }
    
    public static LogExpr fallback_assume_1_checkFieldsInvariants_log(LogProblem fallback_problem,
                                                                      LogExpr fallback_target,
                                                                      String fallback_targetTypeArgsStr,
                                                                      String[] fallback_targetTypeArgs,
                                                                      boolean fallback_target_isOld) {
        return new LogExpr(fallback_problem,
                           kodkod.ast.Formula.TRUE);
    }
    
    public static LogExpr fallback_assume_2_checkContract_log(LogProblem fallback_problem,
                                                              LogExpr fallback_target,
                                                              String fallback_targetTypeArgsStr,
                                                              String[] fallback_targetTypeArgs,
                                                              boolean fallback_target_isOld) {
        return Test37.fallback_checkInvariants_log(fallback_problem,
                                                   fallback_target,
                                                   fallback_targetTypeArgsStr,
                                                   fallback_targetTypeArgs,
                                                   fallback_target_isOld).and(Test37.fallback_assume_2_checkFieldsInvariants_log(fallback_problem,
                                                                                                                                 fallback_target,
                                                                                                                                 fallback_targetTypeArgsStr,
                                                                                                                                 fallback_targetTypeArgs,
                                                                                                                                 fallback_target_isOld)).and(Test37.x_get_log(fallback_problem,
                                                                                                                                                                              fallback_target,
                                                                                                                                                                              fallback_targetTypeArgsStr,
                                                                                                                                                                              fallback_targetTypeArgs,
                                                                                                                                                                              fallback_target_isOld).lt(new LogExpr(fallback_problem,
                                                                                                                                                                                                                    kodkod.ast.IntConstant.constant(5)).negate()));
    }
    
    public static LogExpr fallback_assume_2_checkFieldsInvariants_log(LogProblem fallback_problem,
                                                                      LogExpr fallback_target,
                                                                      String fallback_targetTypeArgsStr,
                                                                      String[] fallback_targetTypeArgs,
                                                                      boolean fallback_target_isOld) {
        return new LogExpr(fallback_problem,
                           kodkod.ast.Formula.TRUE);
    }
}
