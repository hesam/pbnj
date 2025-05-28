public class ArrayTest implements polyglot.ext.pbnj.primitives.PBJInternObject {
    int[] elems =
      { 4, 3 };
    
    public boolean isSorted() {
        return isSorted_univQuantify_0();
    }
    
    public boolean isPermutation(int[] orig) {
        int size =
          this.elems.length;
        return size ==
                 orig.length &&
          isPermutation_univQuantify_2(orig,
                                       size);
    }
    
    public void sort_orig() {
        
    }
    
    public int m_orig() {
        return 0;
    }
    
    public int max_int_int_orig(int a,
                                int b) {
        if (a <
              b)
            return a;
        else
            return b;
    }
    
    public boolean member(int n,
                          int[] arr) {
        return member_existQuantify_3(n,
                                      arr);
    }
    
    public boolean geq(int n,
                       int[] arr) {
        return geq_univQuantify_4(n,
                                  arr);
    }
    
    public int max_int_orig(int[] arr) {
        int res =
          0;
        for (int i =
               0;
             i <=
               arr.length;
             i++) {
            if (arr[i] >
                  res)
                res =
                  arr[i];
        }
        return res;
    }
    
    public String toString() {
        String res =
          "[";
        for (int i =
               0;
             i <
               elems.length;
             i++)
            res +=
              " " +
              elems[i];
        return res +
        " ]";
    }
    
    public static void main(String[] args) {
        ArrayTest e =
          new ArrayTest();
        System.out.println(e);
        e.sort();
        System.out.println(e);
    }
    
    public ArrayTest old;
    
    public boolean fallback_pbnj;
    
    Object fallback_field_result;
    
    public void fallback_field_result(Object r) {
        this.fallback_field_result =
          r;
    }
    
    public ArrayTest() {
        super();
        this.addInstance();
    }
    
    public ArrayTest(polyglot.ext.pbnj.tologic.LogExpr dontcare) {
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
        polyglot.ext.pbnj.tologic.LogMap.addInstance(ArrayTest.class,
                                                     this);
    }
    
    public void addInstanceForProblem(ArrayTest toAdd,
                                      polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                      String fallback_targetTypeArgsStr) {
        fallback_problem.addToClassInstances(toAdd,
                                             ArrayTest.class,
                                             "ArrayTest",
                                             fallback_targetTypeArgsStr);
    }
    
    long startMethodTime;
    
    boolean isOld;
    
    Object fallback_consistencyLock;
    
    int fallback_updateTime;
    
    public ArrayTest old() {
        return this.old;
    }
    
    String[] fallback_typeArgs;
    
    public ArrayTest fallback_setTypeArgs(String[] args) {
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
          polyglot.ext.pbnj.tologic.LogMap.clonerStep();
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
        return ArrayTest.classRelationizerStep ==
          fallback_problem.relationizerStep();
    }
    
    public static int classAtomizerStep =
      0;
    
    public static boolean isClassAtomized(polyglot.ext.pbnj.tologic.LogProblem fallback_problem) {
        return ArrayTest.classAtomizerStep ==
          fallback_problem.relationizerStep();
    }
    
    public static int classClonerStep =
      0;
    
    public static boolean isClassCloned() {
        return ArrayTest.classClonerStep ==
          polyglot.ext.pbnj.tologic.LogMap.clonerStep();
    }
    
    void initEnsuredMethod() {
        this.startMethodTime =
          System.currentTimeMillis();
        polyglot.ext.pbnj.tologic.LogMap.incrClonerStep();
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
    
    public boolean sort_checkContract() {
        return this.fallback_checkInvariants() &&
                 this.sort_checkFieldsInvariants() &&
          (isSorted() &&
             isPermutation(this.old.elems));
    }
    
    public void sort_assertContract() {
        assert sort_checkContract();
    }
    
    public void sort_commitModel(polyglot.ext.pbnj.tologic.LogProblem fallback_problem) {
        fallback_problem.commitModel(this);
    }
    
    polyglot.ext.pbnj.tologic.LogProblem sort_planb() {
        System.out.println("\n" +
                             (this +
                                (" (" +
                                   (Thread.currentThread() +
                                      (": sort" +
                                         ") initiated plan b...")))));
        polyglot.ext.pbnj.tologic.LogProblem fallback_problem =
          polyglot.ext.pbnj.tologic.LogMap.initRelationize();
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
        fallback_problem.setModifiableField("ArrayTest.elems");
        polyglot.ext.pbnj.tologic.LogExpr fallback_target =
          fallback_problem.objToSingletonRelation_log(this);
        boolean fallback_target_isOld =
          false;
        polyglot.ext.pbnj.tologic.LogExpr fallback_formula =
          ArrayTest.sort_checkContract_log(fallback_problem,
                                           fallback_target,
                                           fallback_targetTypeArgsStr,
                                           fallback_targetTypeArgs,
                                           fallback_target_isOld);
        boolean isSatisfiable =
          fallback_problem.solve("sort",
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
    
    public void sort() {
        sort_ensured();
    }
    
    public void sort_ensured() {
        initEnsuredMethod();
        try {
            sort_orig();
            sort_assertContract();
        }
        catch (Throwable rte) {
            {
                rte.printStackTrace();
                polyglot.ext.pbnj.tologic.LogProblem fallback_problem =
                  sort_planb();
                sort_commitModel(fallback_problem);
            }
        }
    }
    
    public boolean sort_checkFieldsInvariants() {
        return true;
    }
    
    public boolean m_checkContract() {
        return this.fallback_checkInvariants() &&
                 this.m_checkFieldsInvariants() &&
          (Integer)
            this.fallback_field_result >
            0;
    }
    
    public void m_assertContract() {
        assert m_checkContract();
    }
    
    public void m_commitModel(polyglot.ext.pbnj.tologic.LogProblem fallback_problem) {
        fallback_problem.commitModel(this);
    }
    
    polyglot.ext.pbnj.tologic.LogProblem m_planb() {
        System.out.println("\n" +
                             (this +
                                (" (" +
                                   (Thread.currentThread() +
                                      (": m" +
                                         ") initiated plan b...")))));
        polyglot.ext.pbnj.tologic.LogProblem fallback_problem =
          polyglot.ext.pbnj.tologic.LogMap.initRelationize();
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
          ArrayTest.m_checkContract_log(fallback_problem,
                                        fallback_target,
                                        fallback_targetTypeArgsStr,
                                        fallback_targetTypeArgs,
                                        fallback_target_isOld);
        boolean isSatisfiable =
          fallback_problem.solve("m",
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
    
    public int m() {
        return m_ensured();
    }
    
    public int m_ensured() {
        int fallback_result;
        initEnsuredMethod();
        try {
            fallback_result =
              m_orig();
            this.fallback_field_result =
              fallback_result;
            m_assertContract();
            return fallback_result;
        }
        catch (Throwable rte) {
            {
                rte.printStackTrace();
                polyglot.ext.pbnj.tologic.LogProblem fallback_problem =
                  m_planb();
                m_commitModel(fallback_problem);
                return (Integer)
                         this.fallback_field_result;
            }
        }
    }
    
    public boolean m_checkFieldsInvariants() {
        return true;
    }
    
    int fallback_field_result_m;
    
    public boolean max_int_int_checkContract(int a,
                                             int b) {
        return this.fallback_checkInvariants() &&
                 this.max_int_int_checkFieldsInvariants() &&
          (((Integer)
              this.fallback_field_result ==
              a ||
              (Integer)
                this.fallback_field_result ==
                b) &&
             (Integer)
               this.fallback_field_result >=
               a &&
             (Integer)
               this.fallback_field_result >=
               b);
    }
    
    public void max_int_int_assertContract(int a,
                                           int b) {
        assert max_int_int_checkContract(a,
                                         b);
    }
    
    public void max_int_int_commitModel(int a,
                                        int b,
                                        polyglot.ext.pbnj.tologic.LogProblem fallback_problem) {
        fallback_problem.commitModel(this);
    }
    
    polyglot.ext.pbnj.tologic.LogProblem max_int_int_planb(int a,
                                                           int b) {
        boolean a_isOld =
          false;
        boolean b_isOld =
          false;
        System.out.println("\n" +
                             (this +
                                (" (" +
                                   (Thread.currentThread() +
                                      (": max" +
                                         ") initiated plan b...")))));
        polyglot.ext.pbnj.tologic.LogProblem fallback_problem =
          polyglot.ext.pbnj.tologic.LogMap.initRelationize();
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
          ArrayTest.max_int_int_checkContract_log(fallback_problem,
                                                  fallback_target,
                                                  fallback_targetTypeArgsStr,
                                                  fallback_targetTypeArgs,
                                                  fallback_target_isOld,
                                                  fallback_problem.intToSingletonRelation_log(a),
                                                  a_isOld,
                                                  fallback_problem.intToSingletonRelation_log(b),
                                                  b_isOld);
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
    
    public int max(int a,
                   int b) {
        return max_int_int_ensured(a,
                                   b);
    }
    
    public int max_int_int_ensured(int a,
                                   int b) {
        int fallback_result;
        initEnsuredMethod();
        try {
            fallback_result =
              max_int_int_orig(a,
                               b);
            this.fallback_field_result =
              fallback_result;
            max_int_int_assertContract(a,
                                       b);
            return fallback_result;
        }
        catch (Throwable rte) {
            {
                rte.printStackTrace();
                polyglot.ext.pbnj.tologic.LogProblem fallback_problem =
                  max_int_int_planb(a,
                                    b);
                max_int_int_commitModel(a,
                                        b,
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
    
    public boolean max_int_checkContract(int[] arr) {
        return this.fallback_checkInvariants() &&
                 this.max_int_checkFieldsInvariants() &&
          (member((Integer)
                    this.fallback_field_result,
                  arr) &&
             geq((Integer)
                   this.fallback_field_result,
                 arr));
    }
    
    public void max_int_assertContract(int[] arr) {
        assert max_int_checkContract(arr);
    }
    
    public void max_int_commitModel(int[] arr,
                                    polyglot.ext.pbnj.tologic.LogProblem fallback_problem) {
        fallback_problem.commitModel(this);
    }
    
    polyglot.ext.pbnj.tologic.LogProblem max_int_planb(int[] arr) {
        boolean arr_isOld =
          false;
        System.out.println("\n" +
                             (this +
                                (" (" +
                                   (Thread.currentThread() +
                                      (": max" +
                                         ") initiated plan b...")))));
        polyglot.ext.pbnj.tologic.LogProblem fallback_problem =
          polyglot.ext.pbnj.tologic.LogMap.initRelationize();
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
          ArrayTest.max_int_checkContract_log(fallback_problem,
                                              fallback_target,
                                              fallback_targetTypeArgsStr,
                                              fallback_targetTypeArgs,
                                              fallback_target_isOld,
                                              fallback_problem.arrayToRelation_log(arr),
                                              arr_isOld);
        boolean isSatisfiable =
          fallback_problem.solve("max_int",
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
    
    public int max(int[] arr) {
        return max_int_ensured(arr);
    }
    
    public int max_int_ensured(int[] arr) {
        int fallback_result;
        initEnsuredMethod();
        try {
            fallback_result =
              max_int_orig(arr);
            this.fallback_field_result =
              fallback_result;
            max_int_assertContract(arr);
            return fallback_result;
        }
        catch (Throwable rte) {
            {
                rte.printStackTrace();
                polyglot.ext.pbnj.tologic.LogProblem fallback_problem =
                  max_int_planb(arr);
                max_int_commitModel(arr,
                                    fallback_problem);
                return (Integer)
                         this.fallback_field_result;
            }
        }
    }
    
    public boolean max_int_checkFieldsInvariants() {
        return true;
    }
    
    int fallback_field_result_max_int;
    
    public void fallback_atomize(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                 String fallback_targetTypeArgsStr,
                                 String[] fallback_targetTypeArgs) {
        if (!isAtomized(fallback_problem)) {
            this.atomizerStep =
              fallback_problem.relationizerStep();
            ArrayTest.fallback_classAtomize(fallback_problem,
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
            ArrayTest.fallback_classRelationizeOld(fallback_problem,
                                                   fallback_targetTypeArgsStr,
                                                   fallback_targetTypeArgs);
            ArrayTest.elems_old_get_log(fallback_problem,
                                        fallback_targetTypeArgsStr,
                                        fallback_targetTypeArgs).int1_array_put_log(fallback_problem,
                                                                                    this,
                                                                                    this.elems);
        }
    }
    
    public static void fallback_classAtomize(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                             String fallback_targetTypeArgsStr,
                                             String[] fallback_targetTypeArgs) {
        if (!isClassAtomized(fallback_problem)) {
            ArrayTest.classAtomizerStep =
              fallback_problem.relationizerStep();
        }
    }
    
    public static void fallback_classRelationizeOld(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                    String fallback_targetTypeArgsStr,
                                                    String[] fallback_targetTypeArgs) {
        if (!isClassRelationized(fallback_problem)) {
            ArrayTest.classRelationizerStep =
              fallback_problem.relationizerStep();
        }
    }
    
    public static void fallback_classClone() {
        if (isClassCloned())
            return;
    }
    
    public ArrayTest fallback_clone() {
        if (isCloned())
            return old;
        ArrayTest res =
          null;
        ArrayTest.fallback_classClone();
        try {
            res =
              (ArrayTest)
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
              polyglot.ext.pbnj.tologic.LogMap.clonerStep();
            if (this.elems !=
                  null) {
                res.elems =
                  (int[])
                    this.elems.clone();
            }
        }
        catch (Exception rte) {
            rte.printStackTrace();
            System.exit(1);
        }
        return res;
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr elems_get_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                  polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                  String fallback_targetTypeArgsStr,
                                                                  String[] fallback_targetTypeArgs,
                                                                  boolean isOld) {
        return polyglot.ext.pbnj.tologic.LogMap.fieldGet_log(fallback_problem,
                                                             fallback_target,
                                                             "ArrayTest",
                                                             fallback_targetTypeArgsStr,
                                                             "elems",
                                                             isOld);
    }
    
    public static polyglot.ext.pbnj.tologic.LogRelation elems_old_get_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                          String fallback_targetTypeArgsStr,
                                                                          String[] fallback_targetTypeArgs) {
        return polyglot.ext.pbnj.tologic.LogMap.oldFieldGet_log(fallback_problem,
                                                                "ArrayTest",
                                                                fallback_targetTypeArgsStr,
                                                                "elems");
    }
    
    public int fallback_updateArrayField_elems(int index,
                                               int newVal) {
        this.elems[index] =
          newVal;
        return newVal;
    }
    
    public int[] fallback_updateField_elems(java.util.ArrayList<Integer> newVal) {
        int i =
          0;
        int s =
          newVal.size();
        if (this.elems ==
              null ||
              this.elems.length !=
                s)
            this.elems =
              (new int[s]);
        while (i <
                 s) {
            this.elems[i] =
              newVal.get(i);
            i++;
        }
        return this.elems;
    }
    
    public int[] fallback_updateField_elems(int[] newVal) {
        return this.elems =
          newVal;
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr fallback_field_result_m_get_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                                    polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                                    String fallback_targetTypeArgsStr,
                                                                                    String[] fallback_targetTypeArgs,
                                                                                    boolean isOld) {
        return polyglot.ext.pbnj.tologic.LogMap.resultGet_log(fallback_problem,
                                                              fallback_target,
                                                              "ArrayTest",
                                                              fallback_targetTypeArgsStr,
                                                              "fallback_field_result_m");
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr fallback_field_result_max_int_int_get_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                                              polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                                              String fallback_targetTypeArgsStr,
                                                                                              String[] fallback_targetTypeArgs,
                                                                                              boolean isOld) {
        return polyglot.ext.pbnj.tologic.LogMap.resultGet_log(fallback_problem,
                                                              fallback_target,
                                                              "ArrayTest",
                                                              fallback_targetTypeArgsStr,
                                                              "fallback_field_result_max_int_int");
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr fallback_field_result_max_int_get_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                                          polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                                          String fallback_targetTypeArgsStr,
                                                                                          String[] fallback_targetTypeArgs,
                                                                                          boolean isOld) {
        return polyglot.ext.pbnj.tologic.LogMap.resultGet_log(fallback_problem,
                                                              fallback_target,
                                                              "ArrayTest",
                                                              fallback_targetTypeArgsStr,
                                                              "fallback_field_result_max_int");
    }
    
    public boolean isSorted_univQuantify_0() {
        for (int i : polyglot.ext.pbnj.primitives.PBJInternInteger.range(0,
                                                                         this.elems.length -
                                                                           2)) {
            if (!(elems[i] <=
                    elems[i +
                            1]))
                return false;
        }
        return true;
    }
    
    public boolean isPermutation_univQuantify_2(int[] orig,
                                                int size) {
        for (int i : polyglot.ext.pbnj.primitives.PBJInternInteger.range(0,
                                                                         size -
                                                                           1)) {
            if (!isPermutation_existQuantify_1(orig,
                                               i,
                                               size))
                return false;
        }
        return true;
    }
    
    public boolean isPermutation_existQuantify_1(int[] orig,
                                                 int i,
                                                 int size) {
        for (int j : polyglot.ext.pbnj.primitives.PBJInternInteger.range(0,
                                                                         size -
                                                                           1)) {
            if (orig[i] ==
                  elems[j])
                return true;
        }
        return false;
    }
    
    public boolean member_existQuantify_3(int n,
                                          int[] arr) {
        for (int i : polyglot.ext.pbnj.primitives.PBJInternInteger.range(0,
                                                                         arr.length -
                                                                           1)) {
            if (arr[i] ==
                  n)
                return true;
        }
        return false;
    }
    
    public boolean geq_univQuantify_4(int n,
                                      int[] arr) {
        for (int i : polyglot.ext.pbnj.primitives.PBJInternInteger.range(0,
                                                                         arr.length -
                                                                           1)) {
            if (!(arr[i] <=
                    n))
                return false;
        }
        return true;
    }
    
    public static void fallback_initClassDefs() {
        
    }
    
    static {
               polyglot.ext.pbnj.tologic.LogMap.newClassForLog(ArrayTest.class,
                                                               true);
               polyglot.ext.pbnj.tologic.LogMap.newInstVarRel("elems",
                                                              ArrayTest.class,
                                                              "ArrayTest",
                                                              Integer.class,
                                                              "int",
                                                              null,
                                                              null,
                                                              false,
                                                              false,
                                                              1,
                                                              true,
                                                              false,
                                                              false,
                                                              false,
                                                              false);
               polyglot.ext.pbnj.tologic.LogMap.newInstVarRel("fallback_field_result_m",
                                                              ArrayTest.class,
                                                              "ArrayTest",
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
               polyglot.ext.pbnj.tologic.LogMap.newInstVarRel("fallback_field_result_max_int_int",
                                                              ArrayTest.class,
                                                              "ArrayTest",
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
               polyglot.ext.pbnj.tologic.LogMap.newInstVarRel("fallback_field_result_max_int",
                                                              ArrayTest.class,
                                                              "ArrayTest",
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
    
    public static polyglot.ext.pbnj.tologic.LogExpr isSorted_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                 polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                 String fallback_targetTypeArgsStr,
                                                                 String[] fallback_targetTypeArgs,
                                                                 boolean fallback_target_isOld) {
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
        return polyglot.ext.pbnj.tologic.LogExpr.quantifyOp(polyglot.ext.pbnj.primitives.PBJInternSet.toPBJInternSet_log(fallback_problem,
                                                                                                                         polyglot.ext.pbnj.primitives.PBJInternInteger.range_log(fallback_problem,
                                                                                                                                                                                 fallback_problem.class_log(polyglot.ext.pbnj.primitives.PBJInternInteger.class),
                                                                                                                                                                                 "",
                                                                                                                                                                                 null,
                                                                                                                                                                                 fallback_target_isOld,
                                                                                                                                                                                 new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                                                                                                                                                                                       kodkod.ast.IntConstant.constant(0)),
                                                                                                                                                                                 fallback_target_isOld,
                                                                                                                                                                                 ArrayTest.elems_get_log(fallback_problem,
                                                                                                                                                                                                         fallback_target,
                                                                                                                                                                                                         fallback_targetTypeArgsStr,
                                                                                                                                                                                                         fallback_targetTypeArgs,
                                                                                                                                                                                                         fallback_target_isOld).length_get_log(fallback_problem).minus(new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                                             kodkod.ast.IntConstant.constant(2))),
                                                                                                                                                                                 fallback_target_isOld),
                                                                                                                         "<java.lang.Integer>",
                                                                                                                         new String[] { "java.lang.Integer" },
                                                                                                                         fallback_target_isOld),
                                                            false,
                                                            "all",
                                                            fallback_var_i,
                                                            ArrayTest.elems_get_log(fallback_problem,
                                                                                    fallback_target,
                                                                                    fallback_targetTypeArgsStr,
                                                                                    fallback_targetTypeArgs,
                                                                                    fallback_target_isOld).get_log(fallback_problem,
                                                                                                                   i,
                                                                                                                   false).lte(ArrayTest.elems_get_log(fallback_problem,
                                                                                                                                                      fallback_target,
                                                                                                                                                      fallback_targetTypeArgsStr,
                                                                                                                                                      fallback_targetTypeArgs,
                                                                                                                                                      fallback_target_isOld).get_log(fallback_problem,
                                                                                                                                                                                     i.plus(new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                                                                                                                                                                                                  kodkod.ast.IntConstant.constant(1))),
                                                                                                                                                                                     false)));
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr isPermutation_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                      polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                      String fallback_targetTypeArgsStr,
                                                                      String[] fallback_targetTypeArgs,
                                                                      boolean fallback_target_isOld,
                                                                      polyglot.ext.pbnj.tologic.LogExpr orig,
                                                                      boolean orig_isOld) {
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
        polyglot.ext.pbnj.tologic.LogExpr size =
          ArrayTest.elems_get_log(fallback_problem,
                                  fallback_target,
                                  fallback_targetTypeArgsStr,
                                  fallback_targetTypeArgs,
                                  fallback_target_isOld).length_get_log(fallback_problem);
        boolean size_isOld =
          false;
        return size.eq(orig.length_get_log(fallback_problem)).and(polyglot.ext.pbnj.tologic.LogExpr.quantifyOp(polyglot.ext.pbnj.primitives.PBJInternSet.toPBJInternSet_log(fallback_problem,
                                                                                                                                                                            polyglot.ext.pbnj.primitives.PBJInternInteger.range_log(fallback_problem,
                                                                                                                                                                                                                                    fallback_problem.class_log(polyglot.ext.pbnj.primitives.PBJInternInteger.class),
                                                                                                                                                                                                                                    "",
                                                                                                                                                                                                                                    null,
                                                                                                                                                                                                                                    fallback_target_isOld,
                                                                                                                                                                                                                                    new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                          kodkod.ast.IntConstant.constant(0)),
                                                                                                                                                                                                                                    fallback_target_isOld,
                                                                                                                                                                                                                                    size.minus(new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                     kodkod.ast.IntConstant.constant(1))),
                                                                                                                                                                                                                                    fallback_target_isOld),
                                                                                                                                                                            "<java.lang.Integer>",
                                                                                                                                                                            new String[] { "java.lang.Integer" },
                                                                                                                                                                            fallback_target_isOld),
                                                                                                               false,
                                                                                                               "all",
                                                                                                               fallback_var_i,
                                                                                                               polyglot.ext.pbnj.tologic.LogExpr.quantifyOp(polyglot.ext.pbnj.primitives.PBJInternSet.toPBJInternSet_log(fallback_problem,
                                                                                                                                                                                                                         polyglot.ext.pbnj.primitives.PBJInternInteger.range_log(fallback_problem,
                                                                                                                                                                                                                                                                                 fallback_problem.class_log(polyglot.ext.pbnj.primitives.PBJInternInteger.class),
                                                                                                                                                                                                                                                                                 "",
                                                                                                                                                                                                                                                                                 null,
                                                                                                                                                                                                                                                                                 fallback_target_isOld,
                                                                                                                                                                                                                                                                                 new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                                                       kodkod.ast.IntConstant.constant(0)),
                                                                                                                                                                                                                                                                                 fallback_target_isOld,
                                                                                                                                                                                                                                                                                 size.minus(new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                                                                  kodkod.ast.IntConstant.constant(1))),
                                                                                                                                                                                                                                                                                 fallback_target_isOld),
                                                                                                                                                                                                                         "<java.lang.Integer>",
                                                                                                                                                                                                                         new String[] { "java.lang.Integer" },
                                                                                                                                                                                                                         fallback_target_isOld),
                                                                                                                                                            false,
                                                                                                                                                            "some",
                                                                                                                                                            fallback_var_j,
                                                                                                                                                            orig.get_log(fallback_problem,
                                                                                                                                                                         i,
                                                                                                                                                                         false).eq(ArrayTest.elems_get_log(fallback_problem,
                                                                                                                                                                                                           fallback_target,
                                                                                                                                                                                                           fallback_targetTypeArgsStr,
                                                                                                                                                                                                           fallback_targetTypeArgs,
                                                                                                                                                                                                           fallback_target_isOld).get_log(fallback_problem,
                                                                                                                                                                                                                                          j,
                                                                                                                                                                                                                                          false)))));
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr member_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                               polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                               String fallback_targetTypeArgsStr,
                                                               String[] fallback_targetTypeArgs,
                                                               boolean fallback_target_isOld,
                                                               polyglot.ext.pbnj.tologic.LogExpr n,
                                                               boolean n_isOld,
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
        return polyglot.ext.pbnj.tologic.LogExpr.quantifyOp(polyglot.ext.pbnj.primitives.PBJInternSet.toPBJInternSet_log(fallback_problem,
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
                                                            arr.get_log(fallback_problem,
                                                                        i,
                                                                        false).eq(n));
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr geq_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                            polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                            String fallback_targetTypeArgsStr,
                                                            String[] fallback_targetTypeArgs,
                                                            boolean fallback_target_isOld,
                                                            polyglot.ext.pbnj.tologic.LogExpr n,
                                                            boolean n_isOld,
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
        return polyglot.ext.pbnj.tologic.LogExpr.quantifyOp(polyglot.ext.pbnj.primitives.PBJInternSet.toPBJInternSet_log(fallback_problem,
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
                                                            "all",
                                                            fallback_var_i,
                                                            arr.get_log(fallback_problem,
                                                                        i,
                                                                        false).lte(n));
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr fallback_checkInvariants_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                                 polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                                 String fallback_targetTypeArgsStr,
                                                                                 String[] fallback_targetTypeArgs,
                                                                                 boolean fallback_target_isOld) {
        return new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                     kodkod.ast.Formula.TRUE);
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr sort_checkContract_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                           polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                           String fallback_targetTypeArgsStr,
                                                                           String[] fallback_targetTypeArgs,
                                                                           boolean fallback_target_isOld) {
        return ArrayTest.fallback_checkInvariants_log(fallback_problem,
                                                      fallback_target,
                                                      fallback_targetTypeArgsStr,
                                                      fallback_targetTypeArgs,
                                                      fallback_target_isOld).and(ArrayTest.sort_checkFieldsInvariants_log(fallback_problem,
                                                                                                                          fallback_target,
                                                                                                                          fallback_targetTypeArgsStr,
                                                                                                                          fallback_targetTypeArgs,
                                                                                                                          fallback_target_isOld)).and(ArrayTest.isSorted_log(fallback_problem,
                                                                                                                                                                             fallback_target,
                                                                                                                                                                             fallback_targetTypeArgsStr,
                                                                                                                                                                             fallback_targetTypeArgs,
                                                                                                                                                                             fallback_target_isOld).and(ArrayTest.isPermutation_log(fallback_problem,
                                                                                                                                                                                                                                    fallback_target,
                                                                                                                                                                                                                                    fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                    fallback_targetTypeArgs,
                                                                                                                                                                                                                                    fallback_target_isOld,
                                                                                                                                                                                                                                    ArrayTest.elems_get_log(fallback_problem,
                                                                                                                                                                                                                                                            fallback_target,
                                                                                                                                                                                                                                                            fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                            fallback_targetTypeArgs,
                                                                                                                                                                                                                                                            true),
                                                                                                                                                                                                                                    true)));
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr sort_checkFieldsInvariants_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                                   polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                                   String fallback_targetTypeArgsStr,
                                                                                   String[] fallback_targetTypeArgs,
                                                                                   boolean fallback_target_isOld) {
        return new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                     kodkod.ast.Formula.TRUE);
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr m_checkContract_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                        polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                        String fallback_targetTypeArgsStr,
                                                                        String[] fallback_targetTypeArgs,
                                                                        boolean fallback_target_isOld) {
        return ArrayTest.fallback_checkInvariants_log(fallback_problem,
                                                      fallback_target,
                                                      fallback_targetTypeArgsStr,
                                                      fallback_targetTypeArgs,
                                                      fallback_target_isOld).and(ArrayTest.m_checkFieldsInvariants_log(fallback_problem,
                                                                                                                       fallback_target,
                                                                                                                       fallback_targetTypeArgsStr,
                                                                                                                       fallback_targetTypeArgs,
                                                                                                                       fallback_target_isOld)).and(ArrayTest.fallback_field_result_m_get_log(fallback_problem,
                                                                                                                                                                                             fallback_target,
                                                                                                                                                                                             fallback_targetTypeArgsStr,
                                                                                                                                                                                             fallback_targetTypeArgs,
                                                                                                                                                                                             fallback_target_isOld).gt(new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                                                                                                                                                                                                                             kodkod.ast.IntConstant.constant(0))));
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr m_checkFieldsInvariants_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
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
                                                                                  polyglot.ext.pbnj.tologic.LogExpr a,
                                                                                  boolean a_isOld,
                                                                                  polyglot.ext.pbnj.tologic.LogExpr b,
                                                                                  boolean b_isOld) {
        return ArrayTest.fallback_checkInvariants_log(fallback_problem,
                                                      fallback_target,
                                                      fallback_targetTypeArgsStr,
                                                      fallback_targetTypeArgs,
                                                      fallback_target_isOld).and(ArrayTest.max_int_int_checkFieldsInvariants_log(fallback_problem,
                                                                                                                                 fallback_target,
                                                                                                                                 fallback_targetTypeArgsStr,
                                                                                                                                 fallback_targetTypeArgs,
                                                                                                                                 fallback_target_isOld)).and(ArrayTest.fallback_field_result_max_int_int_get_log(fallback_problem,
                                                                                                                                                                                                                 fallback_target,
                                                                                                                                                                                                                 fallback_targetTypeArgsStr,
                                                                                                                                                                                                                 fallback_targetTypeArgs,
                                                                                                                                                                                                                 fallback_target_isOld).eq(a).or(ArrayTest.fallback_field_result_max_int_int_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                     fallback_target,
                                                                                                                                                                                                                                                                                                     fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                     fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                     fallback_target_isOld).eq(b)).and(ArrayTest.fallback_field_result_max_int_int_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                           fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                           fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                           fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                           fallback_target_isOld).gte(a)).and(ArrayTest.fallback_field_result_max_int_int_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  fallback_target_isOld).gte(b)));
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr max_int_int_checkFieldsInvariants_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                                          polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                                          String fallback_targetTypeArgsStr,
                                                                                          String[] fallback_targetTypeArgs,
                                                                                          boolean fallback_target_isOld) {
        return new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                     kodkod.ast.Formula.TRUE);
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr max_int_checkContract_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                              polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                              String fallback_targetTypeArgsStr,
                                                                              String[] fallback_targetTypeArgs,
                                                                              boolean fallback_target_isOld,
                                                                              polyglot.ext.pbnj.tologic.LogExpr arr,
                                                                              boolean arr_isOld) {
        return ArrayTest.fallback_checkInvariants_log(fallback_problem,
                                                      fallback_target,
                                                      fallback_targetTypeArgsStr,
                                                      fallback_targetTypeArgs,
                                                      fallback_target_isOld).and(ArrayTest.max_int_checkFieldsInvariants_log(fallback_problem,
                                                                                                                             fallback_target,
                                                                                                                             fallback_targetTypeArgsStr,
                                                                                                                             fallback_targetTypeArgs,
                                                                                                                             fallback_target_isOld)).and(ArrayTest.member_log(fallback_problem,
                                                                                                                                                                              fallback_target,
                                                                                                                                                                              fallback_targetTypeArgsStr,
                                                                                                                                                                              fallback_targetTypeArgs,
                                                                                                                                                                              fallback_target_isOld,
                                                                                                                                                                              ArrayTest.fallback_field_result_max_int_get_log(fallback_problem,
                                                                                                                                                                                                                              fallback_target,
                                                                                                                                                                                                                              fallback_targetTypeArgsStr,
                                                                                                                                                                                                                              fallback_targetTypeArgs,
                                                                                                                                                                                                                              fallback_target_isOld),
                                                                                                                                                                              fallback_target_isOld,
                                                                                                                                                                              arr,
                                                                                                                                                                              arr_isOld).and(ArrayTest.geq_log(fallback_problem,
                                                                                                                                                                                                               fallback_target,
                                                                                                                                                                                                               fallback_targetTypeArgsStr,
                                                                                                                                                                                                               fallback_targetTypeArgs,
                                                                                                                                                                                                               fallback_target_isOld,
                                                                                                                                                                                                               ArrayTest.fallback_field_result_max_int_get_log(fallback_problem,
                                                                                                                                                                                                                                                               fallback_target,
                                                                                                                                                                                                                                                               fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                               fallback_targetTypeArgs,
                                                                                                                                                                                                                                                               fallback_target_isOld),
                                                                                                                                                                                                               fallback_target_isOld,
                                                                                                                                                                                                               arr,
                                                                                                                                                                                                               arr_isOld)));
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr max_int_checkFieldsInvariants_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                                      polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                                      String fallback_targetTypeArgsStr,
                                                                                      String[] fallback_targetTypeArgs,
                                                                                      boolean fallback_target_isOld) {
        return new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                     kodkod.ast.Formula.TRUE);
    }
}
