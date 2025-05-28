import polyglot.ext.pbnj.primitives.*;
import polyglot.ext.pbnj.tologic.*;
import pbnj.awt.Point;
import pbnj.util.ArrayList;

public class Test1 implements PBJInternObject {
    ArrayList<Integer> nums1;
    
    ArrayList<Point> points3;
    
    public Test1() {
        super();
        this.nums1 =
          new ArrayList<Integer>().fallback_setTypeArgs(new String[] { "java.lang.Integer" });
        this.points3 =
          new ArrayList<Point>().fallback_setTypeArgs(new String[] { "pbnj.awt.Point" });
        this.addInstance();
    }
    
    public String toString() {
        return " nums1=" +
               nums1 +
               " points3=" +
        points3;
    }
    
    public void m0_orig() {
        
    }
    
    public static void main(String[] args) {
        LogMap.SolverOpt_IntBitWidth =
          6;
        Test1 t1 =
          new Test1();
        System.out.println(t1);
        t1.m0();
        System.out.println(t1);
    }
    
    public Test1 old;
    
    public boolean fallback_pbnj;
    
    Object fallback_field_result;
    
    public void fallback_field_result(Object r) {
        this.fallback_field_result =
          r;
    }
    
    public Test1(LogExpr dontcare) {
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
        LogMap.addInstance(Test1.class,
                           this);
    }
    
    public void addInstanceForProblem(Test1 toAdd,
                                      LogProblem fallback_problem,
                                      String fallback_targetTypeArgsStr) {
        fallback_problem.addToClassInstances(toAdd,
                                             Test1.class,
                                             "Test1",
                                             fallback_targetTypeArgsStr);
    }
    
    long startMethodTime;
    
    boolean isOld;
    
    Object fallback_consistencyLock;
    
    int fallback_updateTime;
    
    public Test1 old() {
        return this.old;
    }
    
    String[] fallback_typeArgs;
    
    public Test1 fallback_setTypeArgs(String[] args) {
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
        return Test1.classRelationizerStep ==
          fallback_problem.relationizerStep();
    }
    
    public static int classAtomizerStep =
      0;
    
    public static boolean isClassAtomized(LogProblem fallback_problem) {
        return Test1.classAtomizerStep ==
          fallback_problem.relationizerStep();
    }
    
    public static int classClonerStep =
      0;
    
    public static boolean isClassCloned() {
        return Test1.classClonerStep ==
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
            return ((PBJInternObject)
                      cons.newInstance(args)).fallback_setTypeArgs(typeParamNames);
        }
        catch (Exception rte) {
            rte.printStackTrace();
            return null;
        }
    }
    
    public boolean m0_checkContract() {
        return this.fallback_checkInvariants() &&
                 this.m0_checkFieldsInvariants() &&
          (this.nums1.size() >
             0 &&
             this.nums1.get_spec(0) ==
               4 &&
             this.points3.size() ==
               1 &&
             this.points3.get_spec(0) !=
               null);
    }
    
    public void m0_assertContract() {
        assert m0_checkContract();
    }
    
    public void m0_commitModel(LogProblem fallback_problem) {
        fallback_problem.commitModel(this);
    }
    
    LogProblem m0_planb() {
        System.out.println("\n" +
                             (this +
                                (" (" +
                                   (Thread.currentThread() +
                                      (": m0" +
                                         ") initiated plan b...")))));
        Point.fallback_initClassDefs();
        LogProblem fallback_problem =
          LogMap.initRelationize();
        String fallback_targetTypeArgsStr =
          "";
        String[] fallback_targetTypeArgs =
          null;
        fallback_problem.newFreshInstances();
        fallback_problem.setFreshInstances("pbnj.awt.Point",
                                           1);
        old.fallback_atomize(fallback_problem,
                             "",
                             null);
        Point.fallback_classClone();
        Point.fallback_classAtomize(fallback_problem,
                                    fallback_targetTypeArgsStr,
                                    fallback_targetTypeArgs);
        fallback_problem.ObjToAtomMap();
        old.fallback_relationizeOld(fallback_problem,
                                    "",
                                    null);
        Point.fallback_classRelationizeOld(fallback_problem,
                                           fallback_targetTypeArgsStr,
                                           fallback_targetTypeArgs);
        fallback_problem.initRelations();
        fallback_problem.newModifiableFields();
        fallback_problem.setModifiableField("pbnj.util.ArrayList<java.lang.Integer>.elementData");
        fallback_problem.setModifiableField("pbnj.util.ArrayList<java.lang.Integer>.size");
        fallback_problem.setModifiableField("pbnj.util.ArrayList<pbnj.awt.Point>.elementData");
        fallback_problem.setModifiableField("pbnj.util.ArrayList<pbnj.awt.Point>.size");
        LogExpr fallback_target =
          fallback_problem.objToSingletonRelation_log(this);
        boolean fallback_target_isOld =
          false;
        LogExpr fallback_formula =
          Test1.m0_checkContract_log(fallback_problem,
                                     fallback_target,
                                     fallback_targetTypeArgsStr,
                                     fallback_targetTypeArgs,
                                     fallback_target_isOld);
        boolean isSatisfiable =
          fallback_problem.solve("m0",
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
    
    public void m0() {
        m0_ensured();
    }
    
    public void m0_ensured() {
        initEnsuredMethod();
        try {
            m0_orig();
            m0_assertContract();
        }
        catch (Throwable rte) {
            {
                rte.printStackTrace();
                LogProblem fallback_problem =
                  m0_planb();
                m0_commitModel(fallback_problem);
            }
        }
    }
    
    public boolean m0_checkFieldsInvariants() {
        return true &&
                 (this.nums1 ==
                    null ||
                    this.nums1.fallback_checkInvariants()) &&
          (this.points3 ==
             null ||
             this.points3.fallback_checkInvariants());
    }
    
    public void fallback_atomize(LogProblem fallback_problem,
                                 String fallback_targetTypeArgsStr,
                                 String[] fallback_targetTypeArgs) {
        if (!isAtomized(fallback_problem)) {
            this.atomizerStep =
              fallback_problem.relationizerStep();
            Test1.fallback_classAtomize(fallback_problem,
                                        fallback_targetTypeArgsStr,
                                        fallback_targetTypeArgs);
            this.addInstanceForProblem(this.old,
                                       fallback_problem,
                                       fallback_targetTypeArgsStr);
            if (this.nums1 !=
                  null)
                this.nums1.fallback_atomize(fallback_problem,
                                            "<java.lang.Integer>",
                                            new String[] { "java.lang.Integer" });
            if (this.points3 !=
                  null)
                this.points3.fallback_atomize(fallback_problem,
                                              "<pbnj.awt.Point>",
                                              new String[] { "pbnj.awt.Point" });
        }
    }
    
    public void fallback_relationizeOld(LogProblem fallback_problem,
                                        String fallback_targetTypeArgsStr,
                                        String[] fallback_targetTypeArgs) {
        if (!isRelationized(fallback_problem)) {
            this.relationizerStep =
              fallback_problem.relationizerStep();
            Test1.fallback_classRelationizeOld(fallback_problem,
                                               fallback_targetTypeArgsStr,
                                               fallback_targetTypeArgs);
            if (this.nums1 !=
                  null)
                this.nums1.fallback_relationizeOld(fallback_problem,
                                                   "<java.lang.Integer>",
                                                   new String[] { "java.lang.Integer" });
            if (this.points3 !=
                  null)
                this.points3.fallback_relationizeOld(fallback_problem,
                                                     "<pbnj.awt.Point>",
                                                     new String[] { "pbnj.awt.Point" });
            Test1.nums1_old_get_log(fallback_problem,
                                    fallback_targetTypeArgsStr,
                                    fallback_targetTypeArgs).put_log(fallback_problem,
                                                                     this,
                                                                     this.nums1);
            Test1.points3_old_get_log(fallback_problem,
                                      fallback_targetTypeArgsStr,
                                      fallback_targetTypeArgs).put_log(fallback_problem,
                                                                       this,
                                                                       this.points3);
        }
    }
    
    public static void fallback_classAtomize(LogProblem fallback_problem,
                                             String fallback_targetTypeArgsStr,
                                             String[] fallback_targetTypeArgs) {
        if (!isClassAtomized(fallback_problem)) {
            Test1.classAtomizerStep =
              fallback_problem.relationizerStep();
        }
    }
    
    public static void fallback_classRelationizeOld(LogProblem fallback_problem,
                                                    String fallback_targetTypeArgsStr,
                                                    String[] fallback_targetTypeArgs) {
        if (!isClassRelationized(fallback_problem)) {
            Test1.classRelationizerStep =
              fallback_problem.relationizerStep();
        }
    }
    
    public static void fallback_classClone() {
        if (isClassCloned())
            return;
    }
    
    public Test1 fallback_clone() {
        if (isCloned())
            return old;
        Test1 res =
          null;
        Test1.fallback_classClone();
        try {
            res =
              (Test1)
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
            if (this.nums1 !=
                  null)
                res.nums1 =
                  this.nums1.fallback_clone();
            if (this.points3 !=
                  null)
                res.points3 =
                  this.points3.fallback_clone();
        }
        catch (Exception rte) {
            rte.printStackTrace();
            System.exit(1);
        }
        return res;
    }
    
    public static LogExpr nums1_get_log(LogProblem fallback_problem,
                                        LogExpr fallback_target,
                                        String fallback_targetTypeArgsStr,
                                        String[] fallback_targetTypeArgs,
                                        boolean isOld) {
        return LogMap.fieldGet_log(fallback_problem,
                                   fallback_target,
                                   "Test1",
                                   fallback_targetTypeArgsStr,
                                   "nums1",
                                   isOld);
    }
    
    public static LogRelation nums1_old_get_log(LogProblem fallback_problem,
                                                String fallback_targetTypeArgsStr,
                                                String[] fallback_targetTypeArgs) {
        return LogMap.oldFieldGet_log(fallback_problem,
                                      "Test1",
                                      fallback_targetTypeArgsStr,
                                      "nums1");
    }
    
    public ArrayList<Integer> fallback_updateField_nums1(ArrayList<Integer> newVal) {
        return this.nums1 =
          newVal;
    }
    
    public static LogExpr points3_get_log(LogProblem fallback_problem,
                                          LogExpr fallback_target,
                                          String fallback_targetTypeArgsStr,
                                          String[] fallback_targetTypeArgs,
                                          boolean isOld) {
        return LogMap.fieldGet_log(fallback_problem,
                                   fallback_target,
                                   "Test1",
                                   fallback_targetTypeArgsStr,
                                   "points3",
                                   isOld);
    }
    
    public static LogRelation points3_old_get_log(LogProblem fallback_problem,
                                                  String fallback_targetTypeArgsStr,
                                                  String[] fallback_targetTypeArgs) {
        return LogMap.oldFieldGet_log(fallback_problem,
                                      "Test1",
                                      fallback_targetTypeArgsStr,
                                      "points3");
    }
    
    public ArrayList<Point> fallback_updateField_points3(ArrayList<Point> newVal) {
        return this.points3 =
          newVal;
    }
    
    public static void fallback_initClassDefs() {
        
    }
    
    static {
               LogMap.newClassForLog(Test1.class,
                                     true);
               LogMap.newInstVarRel("nums1",
                                    Test1.class,
                                    "Test1",
                                    ArrayList.class,
                                    "pbnj.util.ArrayList<java.lang.Integer>",
                                    new Class[] { Integer.class },
                                    new String[] { "java.lang.Integer" },
                                    false,
                                    false,
                                    0,
                                    true,
                                    false,
                                    false,
                                    false,
                                    false);
               LogMap.newInstVarRel("points3",
                                    Test1.class,
                                    "Test1",
                                    ArrayList.class,
                                    "pbnj.util.ArrayList<pbnj.awt.Point>",
                                    new Class[] { Point.class },
                                    new String[] { "pbnj.awt.Point" },
                                    false,
                                    false,
                                    0,
                                    true,
                                    false,
                                    false,
                                    false,
                                    false);
               LogMap.newParameterizedGenericClass(ArrayList.class,
                                                   "pbnj.util.ArrayList<java.lang.Integer>",
                                                   new Class[] { Integer.class },
                                                   new String[] { "java.lang.Integer" });
               LogMap.newParameterizedGenericClass(ArrayList.class,
                                                   "pbnj.util.ArrayList<pbnj.awt.Point>",
                                                   new Class[] { Point.class },
                                                   new String[] { "pbnj.awt.Point" });
           }
    
    public static LogExpr fallback_checkInvariants_log(LogProblem fallback_problem,
                                                       LogExpr fallback_target,
                                                       String fallback_targetTypeArgsStr,
                                                       String[] fallback_targetTypeArgs,
                                                       boolean fallback_target_isOld) {
        return new LogExpr(fallback_problem,
                           kodkod.ast.Formula.TRUE);
    }
    
    public static LogExpr m0_checkContract_log(LogProblem fallback_problem,
                                               LogExpr fallback_target,
                                               String fallback_targetTypeArgsStr,
                                               String[] fallback_targetTypeArgs,
                                               boolean fallback_target_isOld) {
        return Test1.fallback_checkInvariants_log(fallback_problem,
                                                  fallback_target,
                                                  fallback_targetTypeArgsStr,
                                                  fallback_targetTypeArgs,
                                                  fallback_target_isOld).and(Test1.m0_checkFieldsInvariants_log(fallback_problem,
                                                                                                                fallback_target,
                                                                                                                fallback_targetTypeArgsStr,
                                                                                                                fallback_targetTypeArgs,
                                                                                                                fallback_target_isOld)).and(ArrayList.size_log(fallback_problem,
                                                                                                                                                               Test1.nums1_get_log(fallback_problem,
                                                                                                                                                                                   fallback_target,
                                                                                                                                                                                   fallback_targetTypeArgsStr,
                                                                                                                                                                                   fallback_targetTypeArgs,
                                                                                                                                                                                   fallback_target_isOld),
                                                                                                                                                               "<java.lang.Integer>",
                                                                                                                                                               new String[] { "java.lang.Integer" },
                                                                                                                                                               fallback_target_isOld).gt(new LogExpr(fallback_problem,
                                                                                                                                                                                                     kodkod.ast.IntConstant.constant(0))).and(ArrayList.get_spec_log(fallback_problem,
                                                                                                                                                                                                                                                                     Test1.nums1_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                         fallback_target,
                                                                                                                                                                                                                                                                                         fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                         fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                         fallback_target_isOld),
                                                                                                                                                                                                                                                                     "<java.lang.Integer>",
                                                                                                                                                                                                                                                                     new String[] { "java.lang.Integer" },
                                                                                                                                                                                                                                                                     fallback_target_isOld,
                                                                                                                                                                                                                                                                     new LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                 kodkod.ast.IntConstant.constant(0)),
                                                                                                                                                                                                                                                                     fallback_target_isOld).eq(new LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                                           kodkod.ast.IntConstant.constant(4)))).and(ArrayList.size_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                        Test1.points3_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                              fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                              fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                              fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                              fallback_target_isOld),
                                                                                                                                                                                                                                                                                                                                                                        "<pbnj.awt.Point>",
                                                                                                                                                                                                                                                                                                                                                                        new String[] { "pbnj.awt.Point" },
                                                                                                                                                                                                                                                                                                                                                                        fallback_target_isOld).eq(new LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                              kodkod.ast.IntConstant.constant(1)))).and(ArrayList.get_spec_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                               Test1.points3_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     fallback_target_isOld),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                               "<pbnj.awt.Point>",
                                                                                                                                                                                                                                                                                                                                                                                                                                                                               new String[] { "pbnj.awt.Point" },
                                                                                                                                                                                                                                                                                                                                                                                                                                                                               fallback_target_isOld,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                               new LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           kodkod.ast.IntConstant.constant(0)),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                               fallback_target_isOld).eq(fallback_problem.null_log()).not()));
    }
    
    public static LogExpr m0_checkFieldsInvariants_log(LogProblem fallback_problem,
                                                       LogExpr fallback_target,
                                                       String fallback_targetTypeArgsStr,
                                                       String[] fallback_targetTypeArgs,
                                                       boolean fallback_target_isOld) {
        return new LogExpr(fallback_problem,
                           kodkod.ast.Formula.TRUE).and(Test1.nums1_get_log(fallback_problem,
                                                                            fallback_target,
                                                                            fallback_targetTypeArgsStr,
                                                                            fallback_targetTypeArgs,
                                                                            fallback_target_isOld).eq(fallback_problem.null_log()).or(ArrayList.fallback_checkInvariants_log(fallback_problem,
                                                                                                                                                                             Test1.nums1_get_log(fallback_problem,
                                                                                                                                                                                                 fallback_target,
                                                                                                                                                                                                 fallback_targetTypeArgsStr,
                                                                                                                                                                                                 fallback_targetTypeArgs,
                                                                                                                                                                                                 fallback_target_isOld),
                                                                                                                                                                             "<java.lang.Integer>",
                                                                                                                                                                             new String[] { "java.lang.Integer" },
                                                                                                                                                                             fallback_target_isOld))).and(Test1.points3_get_log(fallback_problem,
                                                                                                                                                                                                                                fallback_target,
                                                                                                                                                                                                                                fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                fallback_targetTypeArgs,
                                                                                                                                                                                                                                fallback_target_isOld).eq(fallback_problem.null_log()).or(ArrayList.fallback_checkInvariants_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                 Test1.points3_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                       fallback_target,
                                                                                                                                                                                                                                                                                                                                                       fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                       fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                       fallback_target_isOld),
                                                                                                                                                                                                                                                                                                                                 "<pbnj.awt.Point>",
                                                                                                                                                                                                                                                                                                                                 new String[] { "pbnj.awt.Point" },
                                                                                                                                                                                                                                                                                                                                 fallback_target_isOld)));
    }
}
