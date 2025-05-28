import polyglot.ext.pbnj.tologic.LogMap;

public class Test39 implements polyglot.ext.pbnj.primitives.PBJInternObject {
    public int m_int_orig(int i) {
        int j =
          i *
            53 /
          20;
        return j;
    }
    
    public int max_int_int_orig(int i,
                                int j) {
        return 0;
    }
    
    public int maxArr_int_orig(int[] arr) {
        return 0;
    }
    
    public static void main(String[] args) {
        Test39 t =
          new Test39();
        System.out.println(t.maxArr(new int[] { 1, 2, 5, 4, 2 }));
    }
    
    public Test39 old;
    
    public boolean fallback_pbnj;
    
    Object fallback_field_result;
    
    public void fallback_field_result(Object r) {
        this.fallback_field_result =
          r;
    }
    
    public Test39() {
        super();
        this.addInstance();
    }
    
    public Test39(polyglot.ext.pbnj.tologic.LogExpr dontcare) {
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
        LogMap.addInstance(Test39.class,
                           this);
    }
    
    public void addInstanceForProblem(Test39 toAdd,
                                      polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                      String fallback_targetTypeArgsStr) {
        fallback_problem.addToClassInstances(toAdd,
                                             Test39.class,
                                             "Test39",
                                             fallback_targetTypeArgsStr);
    }
    
    long startMethodTime;
    
    boolean isOld;
    
    Object fallback_consistencyLock;
    
    int fallback_updateTime;
    
    public Test39 old() {
        return this.old;
    }
    
    String[] fallback_typeArgs;
    
    public Test39 fallback_setTypeArgs(String[] args) {
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
        return Test39.classRelationizerStep ==
          fallback_problem.relationizerStep();
    }
    
    public static int classAtomizerStep =
      0;
    
    public static boolean isClassAtomized(polyglot.ext.pbnj.tologic.LogProblem fallback_problem) {
        return Test39.classAtomizerStep ==
          fallback_problem.relationizerStep();
    }
    
    public static int classClonerStep =
      0;
    
    public static boolean isClassCloned() {
        return Test39.classClonerStep ==
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
    
    public boolean m_int_checkContract(int i) {
        return this.fallback_checkInvariants() &&
                 this.m_int_checkFieldsInvariants() &&
          ((Integer)
             this.fallback_field_result >
             0 &&
             (Integer)
               this.fallback_field_result <
               5);
    }
    
    public void m_int_assertContract(int i) {
        assert m_int_checkContract(i);
    }
    
    public void m_int_commitModel(int i,
                                  polyglot.ext.pbnj.tologic.LogProblem fallback_problem) {
        fallback_problem.commitModel(this);
    }
    
    polyglot.ext.pbnj.tologic.LogProblem m_int_planb(int i) {
        boolean i_isOld =
          false;
        System.out.println("\n" +
                             (this +
                                (" (" +
                                   (Thread.currentThread() +
                                      (": m" +
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
        polyglot.ext.pbnj.tologic.LogExpr fallback_target =
          fallback_problem.objToSingletonRelation_log(this);
        boolean fallback_target_isOld =
          false;
        polyglot.ext.pbnj.tologic.LogExpr fallback_formula =
          Test39.m_int_checkContract_log(fallback_problem,
                                         fallback_target,
                                         fallback_targetTypeArgsStr,
                                         fallback_targetTypeArgs,
                                         fallback_target_isOld,
                                         fallback_problem.intToSingletonRelation_log(i),
                                         i_isOld);
        boolean isSatisfiable =
          fallback_problem.solve("m_int",
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
    
    public int m(int i) {
        return m_int_ensured(i);
    }
    
    public int m_int_ensured(int i) {
        int fallback_result;
        initEnsuredMethod();
        try {
            fallback_result =
              m_int_orig(i);
            this.fallback_field_result =
              fallback_result;
            m_int_assertContract(i);
            return fallback_result;
        }
        catch (Throwable rte) {
            {
                rte.printStackTrace();
                polyglot.ext.pbnj.tologic.LogProblem fallback_problem =
                  m_int_planb(i);
                m_int_commitModel(i,
                                  fallback_problem);
                return (Integer)
                         this.fallback_field_result;
            }
        }
    }
    
    public boolean m_int_checkFieldsInvariants() {
        return true;
    }
    
    int fallback_field_result_m_int;
    
    public boolean max_int_int_checkContract(int i,
                                             int j) {
        return this.fallback_checkInvariants() &&
                 this.max_int_int_checkFieldsInvariants() &&
          ((Integer)
             this.fallback_field_result ==
             i &&
             i >=
               j ||
             (Integer)
               this.fallback_field_result ==
               j &&
               j >=
                 i);
    }
    
    public void max_int_int_assertContract(int i,
                                           int j) {
        assert max_int_int_checkContract(i,
                                         j);
    }
    
    public void max_int_int_commitModel(int i,
                                        int j,
                                        polyglot.ext.pbnj.tologic.LogProblem fallback_problem) {
        fallback_problem.commitModel(this);
    }
    
    polyglot.ext.pbnj.tologic.LogProblem max_int_int_planb(int i,
                                                           int j) {
        boolean i_isOld =
          false;
        boolean j_isOld =
          false;
        System.out.println("\n" +
                             (this +
                                (" (" +
                                   (Thread.currentThread() +
                                      (": max" +
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
        polyglot.ext.pbnj.tologic.LogExpr fallback_target =
          fallback_problem.objToSingletonRelation_log(this);
        boolean fallback_target_isOld =
          false;
        polyglot.ext.pbnj.tologic.LogExpr fallback_formula =
          Test39.max_int_int_checkContract_log(fallback_problem,
                                               fallback_target,
                                               fallback_targetTypeArgsStr,
                                               fallback_targetTypeArgs,
                                               fallback_target_isOld,
                                               fallback_problem.intToSingletonRelation_log(i),
                                               i_isOld,
                                               fallback_problem.intToSingletonRelation_log(j),
                                               j_isOld);
        boolean isSatisfiable =
          fallback_problem.solve("max_int_int",
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
    
    public int max(int i,
                   int j) {
        return max_int_int_ensured(i,
                                   j);
    }
    
    public int max_int_int_ensured(int i,
                                   int j) {
        int fallback_result;
        initEnsuredMethod();
        try {
            fallback_result =
              max_int_int_orig(i,
                               j);
            this.fallback_field_result =
              fallback_result;
            max_int_int_assertContract(i,
                                       j);
            return fallback_result;
        }
        catch (Throwable rte) {
            {
                rte.printStackTrace();
                polyglot.ext.pbnj.tologic.LogProblem fallback_problem =
                  max_int_int_planb(i,
                                    j);
                max_int_int_commitModel(i,
                                        j,
                                        fallback_problem);
                return (Integer)
                         this.fallback_field_result;
            }
        }
    }
    
    public boolean max_int_int_checkFieldsInvariants() {
        return true;
    }
    
    int fallback_field_result_max_int_int;
    
    public boolean maxArr_int_checkContract(int[] arr) {
        return this.fallback_checkInvariants() &&
                 this.maxArr_int_checkFieldsInvariants() &&
          (maxArr_int_checkContract_existQuantify_1(arr) &&
             maxArr_int_checkContract_existQuantify_2(arr));
    }
    
    public void maxArr_int_assertContract(int[] arr) {
        assert maxArr_int_checkContract(arr);
    }
    
    public void maxArr_int_commitModel(int[] arr,
                                       polyglot.ext.pbnj.tologic.LogProblem fallback_problem) {
        fallback_problem.commitModel(this);
    }
    
    polyglot.ext.pbnj.tologic.LogProblem maxArr_int_planb(int[] arr) {
        boolean arr_isOld =
          false;
        System.out.println("\n" +
                             (this +
                                (" (" +
                                   (Thread.currentThread() +
                                      (": maxArr" +
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
        polyglot.ext.pbnj.tologic.LogExpr fallback_target =
          fallback_problem.objToSingletonRelation_log(this);
        boolean fallback_target_isOld =
          false;
        polyglot.ext.pbnj.tologic.LogExpr fallback_formula =
          Test39.maxArr_int_checkContract_log(fallback_problem,
                                              fallback_target,
                                              fallback_targetTypeArgsStr,
                                              fallback_targetTypeArgs,
                                              fallback_target_isOld,
                                              fallback_problem.arrayToRelation_log(arr),
                                              arr_isOld);
        boolean isSatisfiable =
          fallback_problem.solve("maxArr_int",
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
    
    public int maxArr(int[] arr) {
        return maxArr_int_ensured(arr);
    }
    
    public int maxArr_int_ensured(int[] arr) {
        int fallback_result;
        initEnsuredMethod();
        try {
            fallback_result =
              maxArr_int_orig(arr);
            this.fallback_field_result =
              fallback_result;
            maxArr_int_assertContract(arr);
            return fallback_result;
        }
        catch (Throwable rte) {
            {
                rte.printStackTrace();
                polyglot.ext.pbnj.tologic.LogProblem fallback_problem =
                  maxArr_int_planb(arr);
                maxArr_int_commitModel(arr,
                                       fallback_problem);
                return (Integer)
                         this.fallback_field_result;
            }
        }
    }
    
    public boolean maxArr_int_checkFieldsInvariants() {
        return true;
    }
    
    int fallback_field_result_maxArr_int;
    
    public void fallback_atomize(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                 String fallback_targetTypeArgsStr,
                                 String[] fallback_targetTypeArgs) {
        if (!isAtomized(fallback_problem)) {
            this.atomizerStep =
              fallback_problem.relationizerStep();
            Test39.fallback_classAtomize(fallback_problem,
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
            Test39.fallback_classRelationizeOld(fallback_problem,
                                                fallback_targetTypeArgsStr,
                                                fallback_targetTypeArgs);
        }
    }
    
    public static void fallback_classAtomize(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                             String fallback_targetTypeArgsStr,
                                             String[] fallback_targetTypeArgs) {
        if (!isClassAtomized(fallback_problem)) {
            Test39.classAtomizerStep =
              fallback_problem.relationizerStep();
        }
    }
    
    public static void fallback_classRelationizeOld(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                    String fallback_targetTypeArgsStr,
                                                    String[] fallback_targetTypeArgs) {
        if (!isClassRelationized(fallback_problem)) {
            Test39.classRelationizerStep =
              fallback_problem.relationizerStep();
        }
    }
    
    public static void fallback_classClone() {
        if (isClassCloned())
            return;
    }
    
    public Test39 fallback_clone() {
        if (isCloned())
            return old;
        Test39 res =
          null;
        Test39.fallback_classClone();
        try {
            res =
              (Test39)
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
    
    public static polyglot.ext.pbnj.tologic.LogExpr fallback_field_result_m_int_get_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                                        polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                                        String fallback_targetTypeArgsStr,
                                                                                        String[] fallback_targetTypeArgs,
                                                                                        boolean isOld) {
        return LogMap.resultGet_log(fallback_problem,
                                    fallback_target,
                                    "Test39",
                                    fallback_targetTypeArgsStr,
                                    "fallback_field_result_m_int");
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr fallback_field_result_max_int_int_get_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                                              polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                                              String fallback_targetTypeArgsStr,
                                                                                              String[] fallback_targetTypeArgs,
                                                                                              boolean isOld) {
        return LogMap.resultGet_log(fallback_problem,
                                    fallback_target,
                                    "Test39",
                                    fallback_targetTypeArgsStr,
                                    "fallback_field_result_max_int_int");
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr fallback_field_result_maxArr_int_get_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                                             polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                                             String fallback_targetTypeArgsStr,
                                                                                             String[] fallback_targetTypeArgs,
                                                                                             boolean isOld) {
        return LogMap.resultGet_log(fallback_problem,
                                    fallback_target,
                                    "Test39",
                                    fallback_targetTypeArgsStr,
                                    "fallback_field_result_maxArr_int");
    }
    
    public boolean maxArr_int_checkContract_existQuantify_1(int[] arr) {
        for (int i : polyglot.ext.pbnj.primitives.PBJInternInteger.range(0,
                                                                         arr.length -
                                                                           1)) {
            if ((Integer)
                  this.fallback_field_result ==
                  arr[i] &&
                  maxArr_int_checkContract_existQuantify_0(arr,
                                                           i))
                return true;
        }
        return false;
    }
    
    public boolean maxArr_int_checkContract_existQuantify_0(int[] arr,
                                                            int i) {
        for (int k : polyglot.ext.pbnj.primitives.PBJInternInteger.range(0,
                                                                         arr.length -
                                                                           1)) {
            if (k <
                  arr[i])
                return true;
        }
        return false;
    }
    
    public boolean maxArr_int_checkContract_existQuantify_2(int[] arr) {
        for (int j : polyglot.ext.pbnj.primitives.PBJInternInteger.range(0,
                                                                         arr.length -
                                                                           1)) {
            if ((Integer)
                  this.fallback_field_result <
                  1 +
                    arr[j])
                return true;
        }
        return false;
    }
    
    public static void fallback_initClassDefs() {
        
    }
    
    static {
               LogMap.newClassForLog(Test39.class,
                                     true);
               LogMap.newInstVarRel("fallback_field_result_m_int",
                                    Test39.class,
                                    "Test39",
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
               LogMap.newInstVarRel("fallback_field_result_max_int_int",
                                    Test39.class,
                                    "Test39",
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
               LogMap.newInstVarRel("fallback_field_result_maxArr_int",
                                    Test39.class,
                                    "Test39",
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
    
    public static polyglot.ext.pbnj.tologic.LogExpr m_int_checkContract_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                            polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                            String fallback_targetTypeArgsStr,
                                                                            String[] fallback_targetTypeArgs,
                                                                            boolean fallback_target_isOld,
                                                                            polyglot.ext.pbnj.tologic.LogExpr i,
                                                                            boolean i_isOld) {
        return Test39.fallback_checkInvariants_log(fallback_problem,
                                                   fallback_target,
                                                   fallback_targetTypeArgsStr,
                                                   fallback_targetTypeArgs,
                                                   fallback_target_isOld).and(Test39.m_int_checkFieldsInvariants_log(fallback_problem,
                                                                                                                     fallback_target,
                                                                                                                     fallback_targetTypeArgsStr,
                                                                                                                     fallback_targetTypeArgs,
                                                                                                                     fallback_target_isOld)).and(Test39.fallback_field_result_m_int_get_log(fallback_problem,
                                                                                                                                                                                            fallback_target,
                                                                                                                                                                                            fallback_targetTypeArgsStr,
                                                                                                                                                                                            fallback_targetTypeArgs,
                                                                                                                                                                                            fallback_target_isOld).gt(new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                                                                                                                                                                                                                            kodkod.ast.IntConstant.constant(0))).and(Test39.fallback_field_result_m_int_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                fallback_target,
                                                                                                                                                                                                                                                                                                                                                fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                fallback_target_isOld).lt(new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                kodkod.ast.IntConstant.constant(5)))));
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr m_int_checkFieldsInvariants_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                                    polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                                    String fallback_targetTypeArgsStr,
                                                                                    String[] fallback_targetTypeArgs,
                                                                                    boolean fallback_target_isOld) {
        return new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                     kodkod.ast.Formula.TRUE);
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr max_int_int_checkContract_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                                  polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                                  String fallback_targetTypeArgsStr,
                                                                                  String[] fallback_targetTypeArgs,
                                                                                  boolean fallback_target_isOld,
                                                                                  polyglot.ext.pbnj.tologic.LogExpr i,
                                                                                  boolean i_isOld,
                                                                                  polyglot.ext.pbnj.tologic.LogExpr j,
                                                                                  boolean j_isOld) {
        return Test39.fallback_checkInvariants_log(fallback_problem,
                                                   fallback_target,
                                                   fallback_targetTypeArgsStr,
                                                   fallback_targetTypeArgs,
                                                   fallback_target_isOld).and(Test39.max_int_int_checkFieldsInvariants_log(fallback_problem,
                                                                                                                           fallback_target,
                                                                                                                           fallback_targetTypeArgsStr,
                                                                                                                           fallback_targetTypeArgs,
                                                                                                                           fallback_target_isOld)).and(Test39.fallback_field_result_max_int_int_get_log(fallback_problem,
                                                                                                                                                                                                        fallback_target,
                                                                                                                                                                                                        fallback_targetTypeArgsStr,
                                                                                                                                                                                                        fallback_targetTypeArgs,
                                                                                                                                                                                                        fallback_target_isOld).eq(i).and(i.gte(j)).or(Test39.fallback_field_result_max_int_int_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                       fallback_target,
                                                                                                                                                                                                                                                                                                       fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                       fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                       fallback_target_isOld).eq(j).and(j.gte(i))));
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr max_int_int_checkFieldsInvariants_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                                          polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                                          String fallback_targetTypeArgsStr,
                                                                                          String[] fallback_targetTypeArgs,
                                                                                          boolean fallback_target_isOld) {
        return new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                     kodkod.ast.Formula.TRUE);
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr maxArr_int_checkContract_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                                 polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                                 String fallback_targetTypeArgsStr,
                                                                                 String[] fallback_targetTypeArgs,
                                                                                 boolean fallback_target_isOld,
                                                                                 polyglot.ext.pbnj.tologic.LogExpr arr,
                                                                                 boolean arr_isOld) {
        boolean i_isOld =
          false;
        polyglot.ext.pbnj.tologic.LogExpr quantVar_i =
          new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                kodkod.ast.Variable.unary("i"));
        polyglot.ext.pbnj.tologic.LogExpr i =
          new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                quantVar_i.expr());
        polyglot.ext.pbnj.tologic.LogExpr fallback_var_i =
          quantVar_i;
        boolean k_isOld =
          false;
        polyglot.ext.pbnj.tologic.LogExpr quantVar_k =
          new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                kodkod.ast.Variable.unary("k"));
        polyglot.ext.pbnj.tologic.LogExpr k =
          new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                quantVar_k.expr());
        polyglot.ext.pbnj.tologic.LogExpr fallback_var_k =
          quantVar_k;
        boolean j_isOld =
          false;
        polyglot.ext.pbnj.tologic.LogExpr quantVar_j =
          new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                kodkod.ast.Variable.unary("j"));
        polyglot.ext.pbnj.tologic.LogExpr j =
          new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                quantVar_j.expr());
        polyglot.ext.pbnj.tologic.LogExpr fallback_var_j =
          quantVar_j;
        return Test39.fallback_checkInvariants_log(fallback_problem,
                                                   fallback_target,
                                                   fallback_targetTypeArgsStr,
                                                   fallback_targetTypeArgs,
                                                   fallback_target_isOld).and(Test39.maxArr_int_checkFieldsInvariants_log(fallback_problem,
                                                                                                                          fallback_target,
                                                                                                                          fallback_targetTypeArgsStr,
                                                                                                                          fallback_targetTypeArgs,
                                                                                                                          fallback_target_isOld)).and(polyglot.ext.pbnj.tologic.LogExpr.quantifyOp(polyglot.ext.pbnj.primitives.PBJInternSet.toPBJInternSet_log(fallback_problem,
                                                                                                                                                                                                                                                                polyglot.ext.pbnj.primitives.PBJInternInteger.range_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                        fallback_problem.class_log(polyglot.ext.pbnj.primitives.PBJInternInteger.class),
                                                                                                                                                                                                                                                                                                                        "",
                                                                                                                                                                                                                                                                                                                        null,
                                                                                                                                                                                                                                                                                                                        fallback_target_isOld,
                                                                                                                                                                                                                                                                                                                        new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                              kodkod.ast.IntConstant.constant(0)),
                                                                                                                                                                                                                                                                                                                        fallback_target_isOld,
                                                                                                                                                                                                                                                                                                                        arr.length_get_log(fallback_problem).minus(new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                         kodkod.ast.IntConstant.constant(1))),
                                                                                                                                                                                                                                                                                                                        fallback_target_isOld),
                                                                                                                                                                                                                                                                "<java.lang.Integer>",
                                                                                                                                                                                                                                                                new String[] { "java.lang.Integer" },
                                                                                                                                                                                                                                                                fallback_target_isOld),
                                                                                                                                                                                                   false,
                                                                                                                                                                                                   "some",
                                                                                                                                                                                                   fallback_var_i,
                                                                                                                                                                                                   Test39.fallback_field_result_maxArr_int_get_log(fallback_problem,
                                                                                                                                                                                                                                                   fallback_target,
                                                                                                                                                                                                                                                   fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                   fallback_targetTypeArgs,
                                                                                                                                                                                                                                                   fallback_target_isOld).eq(arr.get_log(fallback_problem,
                                                                                                                                                                                                                                                                                         i,
                                                                                                                                                                                                                                                                                         false)).and(polyglot.ext.pbnj.tologic.LogExpr.quantifyOp(polyglot.ext.pbnj.primitives.PBJInternSet.toPBJInternSet_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                               polyglot.ext.pbnj.primitives.PBJInternInteger.range_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                       fallback_problem.class_log(polyglot.ext.pbnj.primitives.PBJInternInteger.class),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                       "",
                                                                                                                                                                                                                                                                                                                                                                                                                                                                       null,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                       fallback_target_isOld,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                       new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             kodkod.ast.IntConstant.constant(0)),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                       fallback_target_isOld,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                       arr.length_get_log(fallback_problem).minus(new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        kodkod.ast.IntConstant.constant(1))),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                       fallback_target_isOld),
                                                                                                                                                                                                                                                                                                                                                                                                               "<java.lang.Integer>",
                                                                                                                                                                                                                                                                                                                                                                                                               new String[] { "java.lang.Integer" },
                                                                                                                                                                                                                                                                                                                                                                                                               fallback_target_isOld),
                                                                                                                                                                                                                                                                                                                                                  false,
                                                                                                                                                                                                                                                                                                                                                  "some",
                                                                                                                                                                                                                                                                                                                                                  fallback_var_k,
                                                                                                                                                                                                                                                                                                                                                  k.lt(arr.get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                   i,
                                                                                                                                                                                                                                                                                                                                                                   false))))).and(polyglot.ext.pbnj.tologic.LogExpr.quantifyOp(polyglot.ext.pbnj.primitives.PBJInternSet.toPBJInternSet_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            polyglot.ext.pbnj.primitives.PBJInternInteger.range_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    fallback_problem.class_log(polyglot.ext.pbnj.primitives.PBJInternInteger.class),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    "",
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    null,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    fallback_target_isOld,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          kodkod.ast.IntConstant.constant(0)),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    fallback_target_isOld,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    arr.length_get_log(fallback_problem).minus(new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     kodkod.ast.IntConstant.constant(1))),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    fallback_target_isOld),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            "<java.lang.Integer>",
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            new String[] { "java.lang.Integer" },
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            fallback_target_isOld),
                                                                                                                                                                                                                                                                                                                                                                                                                               false,
                                                                                                                                                                                                                                                                                                                                                                                                                               "some",
                                                                                                                                                                                                                                                                                                                                                                                                                               fallback_var_j,
                                                                                                                                                                                                                                                                                                                                                                                                                               Test39.fallback_field_result_maxArr_int_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                               fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                               fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                               fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                               fallback_target_isOld).lt(new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               kodkod.ast.IntConstant.constant(1)).plus(arr.get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    j,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    false))))));
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr maxArr_int_checkFieldsInvariants_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                                         polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                                         String fallback_targetTypeArgsStr,
                                                                                         String[] fallback_targetTypeArgs,
                                                                                         boolean fallback_target_isOld) {
        return new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                     kodkod.ast.Formula.TRUE);
    }
}
