import polyglot.ext.pbnj.tologic.LogMap;

public class IntSqrt implements polyglot.ext.pbnj.primitives.PBJInternObject {
    public int IntSqrt_int_orig(int i) {
        return 1;
    }
    
    public static void main(String[] args) {
        IntSqrt t1 =
          new IntSqrt();
        System.out.println(t1.IntSqrt(10));
    }
    
    public IntSqrt old;
    
    public boolean fallback_pbnj;
    
    Object fallback_field_result;
    
    public void fallback_field_result(Object r) {
        this.fallback_field_result =
          r;
    }
    
    public IntSqrt() {
        super();
        this.addInstance();
    }
    
    public IntSqrt(polyglot.ext.pbnj.tologic.LogExpr dontcare) {
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
        LogMap.addInstance(IntSqrt.class,
                           this);
    }
    
    public void addInstanceForProblem(IntSqrt toAdd,
                                      polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                      String fallback_targetTypeArgsStr) {
        fallback_problem.addToClassInstances(toAdd,
                                             IntSqrt.class,
                                             "IntSqrt",
                                             fallback_targetTypeArgsStr);
    }
    
    long startMethodTime;
    
    boolean isOld;
    
    Object fallback_consistencyLock;
    
    int fallback_updateTime;
    
    public IntSqrt old() {
        return this.old;
    }
    
    String[] fallback_typeArgs;
    
    public IntSqrt fallback_setTypeArgs(String[] args) {
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
    
    boolean isAtomized(polyglot.ext.pbnj.tologic.LogProblem fallback_problem) {
        return this.atomizerStep ==
          fallback_problem.relationizerStep();
    }
    
    int relationizerStep =
      0;
    
    boolean isRelationized(polyglot.ext.pbnj.tologic.LogProblem fallback_problem) {
        return this.relationizerStep ==
          fallback_problem.relationizerStep();
    }
    
    public static int classRelationizerStep =
      0;
    
    public static boolean isClassRelationized(polyglot.ext.pbnj.tologic.LogProblem fallback_problem) {
        return IntSqrt.classRelationizerStep ==
          fallback_problem.relationizerStep();
    }
    
    public static int classAtomizerStep =
      0;
    
    public static boolean isClassAtomized(polyglot.ext.pbnj.tologic.LogProblem fallback_problem) {
        return IntSqrt.classAtomizerStep ==
          fallback_problem.relationizerStep();
    }
    
    public static int classClonerStep =
      0;
    
    public static boolean isClassCloned() {
        return IntSqrt.classClonerStep ==
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
    
    public boolean IntSqrt_int_checkContract(int i) {
        return this.fallback_checkInvariants() &&
                 this.IntSqrt_int_checkFieldsInvariants() &&
          ((Integer)
             this.fallback_field_result >
             0 &&
             (Integer)
               this.fallback_field_result <=
               i /
                 (Integer)
                   this.fallback_field_result &&
             (Integer)
               this.fallback_field_result +
               1 >
               i /
                 ((Integer)
                    this.fallback_field_result +
                    1));
    }
    
    public boolean IntSqrt_int_checkPrecondition(int i) {
        return i >=
          0;
    }
    
    public void IntSqrt_int_assertPrecondition(int i) {
        assert IntSqrt_int_checkPrecondition(i);
    }
    
    public void IntSqrt_int_assertContract(int i) {
        assert IntSqrt_int_checkContract(i);
    }
    
    public void IntSqrt_int_commitModel(int i,
                                        polyglot.ext.pbnj.tologic.LogProblem fallback_problem) {
        fallback_problem.commitModel(this);
    }
    
    polyglot.ext.pbnj.tologic.LogProblem IntSqrt_int_planb(int i) {
        boolean i_isOld =
          false;
        System.out.println("\n" +
                             (this +
                                (" (" +
                                   (Thread.currentThread() +
                                      (": IntSqrt" +
                                         ") initiated plan b...")))));
        polyglot.ext.pbnj.tologic.LogProblem fallback_problem =
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
        fallback_problem.newModifiableFields();
        polyglot.ext.pbnj.tologic.LogExpr fallback_target =
          fallback_problem.objToSingletonRelation_log(this);
        boolean fallback_target_isOld =
          false;
        polyglot.ext.pbnj.tologic.LogExpr fallback_formula =
          IntSqrt.IntSqrt_int_checkContract_log(fallback_problem,
                                                fallback_target,
                                                fallback_targetTypeArgsStr,
                                                fallback_targetTypeArgs,
                                                fallback_target_isOld,
                                                fallback_problem.intToSingletonRelation_log(i),
                                                i_isOld);
        boolean isSatisfiable =
          fallback_problem.solve("IntSqrt_int",
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
    
    public int IntSqrt(int i) {
        return IntSqrt_int_ensured(i);
    }
    
    public int IntSqrt_int_ensured(int i) {
        int fallback_result;
        IntSqrt_int_assertPrecondition(i);
        initEnsuredMethod();
        try {
            fallback_result =
              IntSqrt_int_orig(i);
            this.fallback_field_result =
              fallback_result;
            IntSqrt_int_assertContract(i);
            return fallback_result;
        }
        catch (Throwable rte) {
            {
                rte.printStackTrace();
                polyglot.ext.pbnj.tologic.LogProblem fallback_problem =
                  IntSqrt_int_planb(i);
                IntSqrt_int_commitModel(i,
                                        fallback_problem);
                return (Integer)
                         this.fallback_field_result;
            }
        }
    }
    
    public boolean IntSqrt_int_checkFieldsInvariants() {
        return true;
    }
    
    int fallback_field_result_IntSqrt_int;
    
    public void fallback_atomize(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                 String fallback_targetTypeArgsStr,
                                 String[] fallback_targetTypeArgs) {
        if (!isAtomized(fallback_problem)) {
            this.atomizerStep =
              fallback_problem.relationizerStep();
            IntSqrt.fallback_classAtomize(fallback_problem,
                                          fallback_targetTypeArgsStr,
                                          fallback_targetTypeArgs);
            this.addInstanceForProblem(this.old,
                                       fallback_problem,
                                       fallback_targetTypeArgsStr);
        }
    }
    
    public void fallback_relationizeOld(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                        String fallback_targetTypeArgsStr,
                                        String[] fallback_targetTypeArgs) {
        if (!isRelationized(fallback_problem)) {
            this.relationizerStep =
              fallback_problem.relationizerStep();
            IntSqrt.fallback_classRelationizeOld(fallback_problem,
                                                 fallback_targetTypeArgsStr,
                                                 fallback_targetTypeArgs);
        }
    }
    
    public static void fallback_classAtomize(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                             String fallback_targetTypeArgsStr,
                                             String[] fallback_targetTypeArgs) {
        if (!isClassAtomized(fallback_problem)) {
            IntSqrt.classAtomizerStep =
              fallback_problem.relationizerStep();
        }
    }
    
    public static void fallback_classRelationizeOld(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                    String fallback_targetTypeArgsStr,
                                                    String[] fallback_targetTypeArgs) {
        if (!isClassRelationized(fallback_problem)) {
            IntSqrt.classRelationizerStep =
              fallback_problem.relationizerStep();
        }
    }
    
    public static void fallback_classClone() {
        if (isClassCloned())
            return;
    }
    
    public IntSqrt fallback_clone() {
        if (isCloned())
            return old;
        IntSqrt res =
          null;
        IntSqrt.fallback_classClone();
        try {
            res =
              (IntSqrt)
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
    
    public static polyglot.ext.pbnj.tologic.LogExpr fallback_field_result_IntSqrt_int_get_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                                              polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                                              String fallback_targetTypeArgsStr,
                                                                                              String[] fallback_targetTypeArgs,
                                                                                              boolean isOld) {
        return LogMap.resultGet_log(fallback_problem,
                                    fallback_target,
                                    "IntSqrt",
                                    fallback_targetTypeArgsStr,
                                    "fallback_field_result_IntSqrt_int");
    }
    
    public static void fallback_initClassDefs() {
        
    }
    
    static {
               LogMap.newClassForLog(IntSqrt.class,
                                     true);
               LogMap.newInstVarRel("fallback_field_result_IntSqrt_int",
                                    IntSqrt.class,
                                    "IntSqrt",
                                    Integer.class,
                                    "int",
                                    null,
                                    null,
                                    false,
                                    false,
                                    0,
                                    true,
                                    true,
                                    false,
                                    false,
                                    false);
           }
    
    public static polyglot.ext.pbnj.tologic.LogExpr fallback_checkInvariants_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                                 polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                                 String fallback_targetTypeArgsStr,
                                                                                 String[] fallback_targetTypeArgs,
                                                                                 boolean fallback_target_isOld) {
        return new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                     kodkod.ast.Formula.TRUE);
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr IntSqrt_int_checkContract_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                                  polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                                  String fallback_targetTypeArgsStr,
                                                                                  String[] fallback_targetTypeArgs,
                                                                                  boolean fallback_target_isOld,
                                                                                  polyglot.ext.pbnj.tologic.LogExpr i,
                                                                                  boolean i_isOld) {
        return IntSqrt.fallback_checkInvariants_log(fallback_problem,
                                                    fallback_target,
                                                    fallback_targetTypeArgsStr,
                                                    fallback_targetTypeArgs,
                                                    fallback_target_isOld).and(IntSqrt.IntSqrt_int_checkFieldsInvariants_log(fallback_problem,
                                                                                                                             fallback_target,
                                                                                                                             fallback_targetTypeArgsStr,
                                                                                                                             fallback_targetTypeArgs,
                                                                                                                             fallback_target_isOld)).and(IntSqrt.fallback_field_result_IntSqrt_int_get_log(fallback_problem,
                                                                                                                                                                                                           fallback_target,
                                                                                                                                                                                                           fallback_targetTypeArgsStr,
                                                                                                                                                                                                           fallback_targetTypeArgs,
                                                                                                                                                                                                           fallback_target_isOld).gt(new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                           kodkod.ast.IntConstant.constant(0))).and(IntSqrt.fallback_field_result_IntSqrt_int_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                      fallback_target,
                                                                                                                                                                                                                                                                                                                                                                      fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                      fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                      fallback_target_isOld).lte(i.divide(IntSqrt.fallback_field_result_IntSqrt_int_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                            fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                                            fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                                            fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                                            fallback_target_isOld)))).and(IntSqrt.fallback_field_result_IntSqrt_int_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            fallback_target_isOld).plus(new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              kodkod.ast.IntConstant.constant(1))).gt(i.divide(IntSqrt.fallback_field_result_IntSqrt_int_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 fallback_target_isOld).plus(new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   kodkod.ast.IntConstant.constant(1)))))));
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr IntSqrt_int_checkFieldsInvariants_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                                          polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                                          String fallback_targetTypeArgsStr,
                                                                                          String[] fallback_targetTypeArgs,
                                                                                          boolean fallback_target_isOld) {
        return new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                     kodkod.ast.Formula.TRUE);
    }
}
