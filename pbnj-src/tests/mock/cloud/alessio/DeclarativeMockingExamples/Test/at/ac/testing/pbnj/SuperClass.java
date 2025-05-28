package at.ac.testing.pbnj;

import polyglot.ext.pbnj.tologic.*;
import polyglot.ext.pbnj.primitives.*;
import pbnj.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SuperClass implements PBJInternObject {
    int intSize;
    
    Integer integerSize;
    
    int[] anArray;
    
    Integer[] anIntegerArray;
    
    boolean classInvariant() {
        return intSize !=
                 0 &&
                 integerSize !=
                   null &&
                 anArray !=
                   null &&
                 anIntegerArray !=
                   null &&
          classInvariant_univQuantify_0();
    }
    
    public void init() {
        initH();
    }
    
    void initH_orig() {
        
    }
    
    boolean positiveArray() {
        return this.anArray.length >
                 1 &&
          positiveArray_univQuantify_1();
    }
    
    boolean positiveIntegerArray() {
        return this.anIntegerArray.length ==
                 4 &&
          positiveIntegerArray_univQuantify_2();
    }
    
    boolean positiveSize() {
        return this.intSize >
                 0 &&
          this.integerSize >
            0;
    }
    
    public void resize_int_orig(int newSize) {
        
    }
    
    public void updateAnArray_int_orig(int newSize) {
        
    }
    
    public void updateAnIntegerArray_int_orig(int newSize) {
        
    }
    
    boolean matchingElements(int elem) {
        return matchingElements_univQuantify_3(elem);
    }
    
    boolean matchingIntegerElements(int elem) {
        return matchingIntegerElements_univQuantify_4(elem);
    }
    
    boolean resizeArray(int newSize) {
        return this.anArray.length ==
                 newSize &&
          resizeArray_univQuantify_5(newSize);
    }
    
    boolean sameSize(int newSize) {
        return this.intSize ==
                 newSize &&
          this.integerSize ==
            newSize;
    }
    
    public int getSize() {
        return this.intSize;
    }
    
    public Integer getIntegerSize() {
        return this.integerSize;
    }
    
    public String toString() {
        return "intSize " +
               intSize +
               "\n" +
               "integerSize " +
               integerSize +
               "\n" +
               "anArray " +
               Arrays.toString(anArray) +
               "\n" +
               "anIntegerArray " +
               Arrays.toString(anIntegerArray) +
        "\n";
    }
    
    public SuperClass old;
    
    public boolean fallback_pbnj;
    
    Object fallback_field_result;
    
    public void fallback_field_result(Object r) {
        this.fallback_field_result =
          r;
    }
    
    public SuperClass() {
        super();
        this.addInstance();
    }
    
    public SuperClass(LogExpr dontcare) {
        super();
        this.addInstance();
    }
    
    Object[] fallback_field_resultArray;
    
    public void fallback_field_resultArray(Object[] r) {
        this.fallback_field_resultArray =
          r;
    }
    
    public boolean fallback_checkInvariants() {
        return classInvariant();
    }
    
    public void addInstance() {
        LogMap.addInstance(SuperClass.class,
                           this);
    }
    
    public void addInstanceForProblem(SuperClass toAdd,
                                      LogProblem fallback_problem,
                                      String fallback_targetTypeArgsStr) {
        fallback_problem.addToClassInstances(toAdd,
                                             SuperClass.class,
                                             "at.ac.testing.pbnj.SuperClass",
                                             fallback_targetTypeArgsStr);
    }
    
    long startMethodTime;
    
    boolean isOld;
    
    Object fallback_consistencyLock;
    
    int fallback_updateTime;
    
    public SuperClass old() {
        return this.old;
    }
    
    String[] fallback_typeArgs;
    
    public SuperClass fallback_setTypeArgs(String[] args) {
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
        return SuperClass.classRelationizerStep ==
          fallback_problem.relationizerStep();
    }
    
    public static int classAtomizerStep =
      0;
    
    public static boolean isClassAtomized(LogProblem fallback_problem) {
        return SuperClass.classAtomizerStep ==
          fallback_problem.relationizerStep();
    }
    
    public static int classClonerStep =
      0;
    
    public static boolean isClassCloned() {
        return SuperClass.classClonerStep ==
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
    
    public boolean initH_checkContract() {
        return this.fallback_checkInvariants() &&
                 this.initH_checkFieldsInvariants() &&
          (positiveSize() &&
             positiveArray() &&
             positiveIntegerArray());
    }
    
    public void initH_assertContract() {
        assert initH_checkContract();
    }
    
    public void initH_commitModel(LogProblem fallback_problem) {
        fallback_problem.commitModel(this);
    }
    
    LogProblem initH_planb() {
        System.out.println("\n" +
                             (this +
                                (" (" +
                                   (Thread.currentThread() +
                                      (": initH" +
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
        fallback_problem.newModifiableFields();
        fallback_problem.setModifiableField("at.ac.testing.pbnj.SuperClass.intSize");
        fallback_problem.setModifiableField("at.ac.testing.pbnj.SuperClass.integerSize");
        fallback_problem.setModifiableField("at.ac.testing.pbnj.SuperClass.anArray");
        fallback_problem.setModifiableField("at.ac.testing.pbnj.SuperClass.anIntegerArray");
        LogExpr fallback_target =
          fallback_problem.objToSingletonRelation_log(this);
        boolean fallback_target_isOld =
          false;
        LogExpr fallback_formula =
          SuperClass.initH_checkContract_log(fallback_problem,
                                             fallback_target,
                                             fallback_targetTypeArgsStr,
                                             fallback_targetTypeArgs,
                                             fallback_target_isOld);
        boolean isSatisfiable =
          fallback_problem.solve("initH",
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
    
    void initH() {
        initH_ensured();
    }
    
    void initH_ensured() {
        initEnsuredMethod();
        try {
            initH_orig();
            initH_assertContract();
        }
        catch (Throwable rte) {
            {
                rte.printStackTrace();
                LogProblem fallback_problem =
                  initH_planb();
                initH_commitModel(fallback_problem);
            }
        }
    }
    
    public boolean initH_checkFieldsInvariants() {
        return true;
    }
    
    public boolean resize_int_checkContract(int newSize) {
        return this.fallback_checkInvariants() &&
                 this.resize_int_checkFieldsInvariants() &&
          (positiveSize() &&
             sameSize(newSize) &&
             resizeArray(newSize));
    }
    
    public void resize_int_assertContract(int newSize) {
        assert resize_int_checkContract(newSize);
    }
    
    public void resize_int_commitModel(int newSize,
                                       LogProblem fallback_problem) {
        fallback_problem.commitModel(this);
    }
    
    LogProblem resize_int_planb(int newSize) {
        boolean newSize_isOld =
          false;
        System.out.println("\n" +
                             (this +
                                (" (" +
                                   (Thread.currentThread() +
                                      (": resize" +
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
        fallback_problem.newModifiableFields();
        fallback_problem.setModifiableField("at.ac.testing.pbnj.SuperClass.intSize");
        fallback_problem.setModifiableField("at.ac.testing.pbnj.SuperClass.integerSize");
        fallback_problem.setModifiableField("at.ac.testing.pbnj.SuperClass.anArray");
        LogExpr fallback_target =
          fallback_problem.objToSingletonRelation_log(this);
        boolean fallback_target_isOld =
          false;
        LogExpr fallback_formula =
          SuperClass.resize_int_checkContract_log(fallback_problem,
                                                  fallback_target,
                                                  fallback_targetTypeArgsStr,
                                                  fallback_targetTypeArgs,
                                                  fallback_target_isOld,
                                                  fallback_problem.intToSingletonRelation_log(newSize),
                                                  newSize_isOld);
        boolean isSatisfiable =
          fallback_problem.solve("resize_int",
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
    
    public void resize(int newSize) {
        resize_int_ensured(newSize);
    }
    
    public void resize_int_ensured(int newSize) {
        initEnsuredMethod();
        try {
            resize_int_orig(newSize);
            resize_int_assertContract(newSize);
        }
        catch (Throwable rte) {
            {
                rte.printStackTrace();
                LogProblem fallback_problem =
                  resize_int_planb(newSize);
                resize_int_commitModel(newSize,
                                       fallback_problem);
            }
        }
    }
    
    public boolean resize_int_checkFieldsInvariants() {
        return true;
    }
    
    public boolean updateAnArray_int_checkContract(int newSize) {
        return this.fallback_checkInvariants() &&
                 this.updateAnArray_int_checkFieldsInvariants() &&
          matchingElements(newSize);
    }
    
    public void updateAnArray_int_assertContract(int newSize) {
        assert updateAnArray_int_checkContract(newSize);
    }
    
    public void updateAnArray_int_commitModel(int newSize,
                                              LogProblem fallback_problem) {
        fallback_problem.commitModel(this);
    }
    
    LogProblem updateAnArray_int_planb(int newSize) {
        boolean newSize_isOld =
          false;
        System.out.println("\n" +
                             (this +
                                (" (" +
                                   (Thread.currentThread() +
                                      (": updateAnArray" +
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
        fallback_problem.newModifiableFields();
        fallback_problem.setModifiableField("at.ac.testing.pbnj.SuperClass.anArray");
        LogExpr fallback_target =
          fallback_problem.objToSingletonRelation_log(this);
        boolean fallback_target_isOld =
          false;
        LogExpr fallback_formula =
          SuperClass.updateAnArray_int_checkContract_log(fallback_problem,
                                                         fallback_target,
                                                         fallback_targetTypeArgsStr,
                                                         fallback_targetTypeArgs,
                                                         fallback_target_isOld,
                                                         fallback_problem.intToSingletonRelation_log(newSize),
                                                         newSize_isOld);
        boolean isSatisfiable =
          fallback_problem.solve("updateAnArray_int",
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
    
    public void updateAnArray(int newSize) {
        updateAnArray_int_ensured(newSize);
    }
    
    public void updateAnArray_int_ensured(int newSize) {
        initEnsuredMethod();
        try {
            updateAnArray_int_orig(newSize);
            updateAnArray_int_assertContract(newSize);
        }
        catch (Throwable rte) {
            {
                rte.printStackTrace();
                LogProblem fallback_problem =
                  updateAnArray_int_planb(newSize);
                updateAnArray_int_commitModel(newSize,
                                              fallback_problem);
            }
        }
    }
    
    public boolean updateAnArray_int_checkFieldsInvariants() {
        return true;
    }
    
    public boolean updateAnIntegerArray_int_checkContract(int newSize) {
        return this.fallback_checkInvariants() &&
                 this.updateAnIntegerArray_int_checkFieldsInvariants() &&
          matchingIntegerElements(newSize);
    }
    
    public void updateAnIntegerArray_int_assertContract(int newSize) {
        assert updateAnIntegerArray_int_checkContract(newSize);
    }
    
    public void updateAnIntegerArray_int_commitModel(int newSize,
                                                     LogProblem fallback_problem) {
        fallback_problem.commitModel(this);
    }
    
    LogProblem updateAnIntegerArray_int_planb(int newSize) {
        boolean newSize_isOld =
          false;
        System.out.println("\n" +
                             (this +
                                (" (" +
                                   (Thread.currentThread() +
                                      (": updateAnIntegerArray" +
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
        fallback_problem.newModifiableFields();
        fallback_problem.setModifiableField("at.ac.testing.pbnj.SuperClass.anIntegerArray");
        LogExpr fallback_target =
          fallback_problem.objToSingletonRelation_log(this);
        boolean fallback_target_isOld =
          false;
        LogExpr fallback_formula =
          SuperClass.updateAnIntegerArray_int_checkContract_log(fallback_problem,
                                                                fallback_target,
                                                                fallback_targetTypeArgsStr,
                                                                fallback_targetTypeArgs,
                                                                fallback_target_isOld,
                                                                fallback_problem.intToSingletonRelation_log(newSize),
                                                                newSize_isOld);
        boolean isSatisfiable =
          fallback_problem.solve("updateAnIntegerArray_int",
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
    
    public void updateAnIntegerArray(int newSize) {
        updateAnIntegerArray_int_ensured(newSize);
    }
    
    public void updateAnIntegerArray_int_ensured(int newSize) {
        initEnsuredMethod();
        try {
            updateAnIntegerArray_int_orig(newSize);
            updateAnIntegerArray_int_assertContract(newSize);
        }
        catch (Throwable rte) {
            {
                rte.printStackTrace();
                LogProblem fallback_problem =
                  updateAnIntegerArray_int_planb(newSize);
                updateAnIntegerArray_int_commitModel(newSize,
                                                     fallback_problem);
            }
        }
    }
    
    public boolean updateAnIntegerArray_int_checkFieldsInvariants() {
        return true;
    }
    
    public void fallback_atomize(LogProblem fallback_problem,
                                 String fallback_targetTypeArgsStr,
                                 String[] fallback_targetTypeArgs) {
        if (!isAtomized(fallback_problem)) {
            this.atomizerStep =
              fallback_problem.relationizerStep();
            SuperClass.fallback_classAtomize(fallback_problem,
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
            SuperClass.fallback_classRelationizeOld(fallback_problem,
                                                    fallback_targetTypeArgsStr,
                                                    fallback_targetTypeArgs);
            SuperClass.intSize_old_get_log(fallback_problem,
                                           fallback_targetTypeArgsStr,
                                           fallback_targetTypeArgs).put_log(fallback_problem,
                                                                            this,
                                                                            this.intSize);
            SuperClass.integerSize_old_get_log(fallback_problem,
                                               fallback_targetTypeArgsStr,
                                               fallback_targetTypeArgs).put_log(fallback_problem,
                                                                                this,
                                                                                this.integerSize);
            SuperClass.anArray_old_get_log(fallback_problem,
                                           fallback_targetTypeArgsStr,
                                           fallback_targetTypeArgs).int1_array_put_log(fallback_problem,
                                                                                       this,
                                                                                       this.anArray);
            SuperClass.anIntegerArray_old_get_log(fallback_problem,
                                                  fallback_targetTypeArgsStr,
                                                  fallback_targetTypeArgs).Integer1_array_put_log(fallback_problem,
                                                                                                  this,
                                                                                                  this.anIntegerArray);
        }
    }
    
    public static void fallback_classAtomize(LogProblem fallback_problem,
                                             String fallback_targetTypeArgsStr,
                                             String[] fallback_targetTypeArgs) {
        if (!isClassAtomized(fallback_problem)) {
            SuperClass.classAtomizerStep =
              fallback_problem.relationizerStep();
        }
    }
    
    public static void fallback_classRelationizeOld(LogProblem fallback_problem,
                                                    String fallback_targetTypeArgsStr,
                                                    String[] fallback_targetTypeArgs) {
        if (!isClassRelationized(fallback_problem)) {
            SuperClass.classRelationizerStep =
              fallback_problem.relationizerStep();
        }
    }
    
    public static void fallback_classClone() {
        if (isClassCloned())
            return;
    }
    
    public SuperClass fallback_clone() {
        if (isCloned())
            return old;
        SuperClass res =
          null;
        SuperClass.fallback_classClone();
        try {
            res =
              (SuperClass)
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
            res.intSize =
              this.intSize;
            res.integerSize =
              this.integerSize;
            if (this.anArray !=
                  null) {
                res.anArray =
                  (int[])
                    this.anArray.clone();
            }
            if (this.anIntegerArray !=
                  null) {
                res.anIntegerArray =
                  (Integer[])
                    this.anIntegerArray.clone();
            }
        }
        catch (Exception rte) {
            rte.printStackTrace();
            System.exit(1);
        }
        return res;
    }
    
    public static LogExpr intSize_get_log(LogProblem fallback_problem,
                                          LogExpr fallback_target,
                                          String fallback_targetTypeArgsStr,
                                          String[] fallback_targetTypeArgs,
                                          boolean isOld) {
        return LogMap.fieldGet_log(fallback_problem,
                                   fallback_target,
                                   "at.ac.testing.pbnj.SuperClass",
                                   fallback_targetTypeArgsStr,
                                   "intSize",
                                   isOld);
    }
    
    public static LogRelation intSize_old_get_log(LogProblem fallback_problem,
                                                  String fallback_targetTypeArgsStr,
                                                  String[] fallback_targetTypeArgs) {
        return LogMap.oldFieldGet_log(fallback_problem,
                                      "at.ac.testing.pbnj.SuperClass",
                                      fallback_targetTypeArgsStr,
                                      "intSize");
    }
    
    public int fallback_updateField_intSize(Integer newVal) {
        return this.intSize =
          newVal;
    }
    
    public PBJInternSet<Integer> fieldsClosure_Integer(Object fallback_target,
                                                       boolean isReflexive,
                                                       java.lang.String ... fieldNs) {
        Class c =
          int.class;
        PBJInternSet<Integer> res =
          new PBJInternSet<Integer>();
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
    
    PBJInternSet<Integer> multiFields_Integer(java.lang.String ... fieldNs) {
        Class c =
          Integer.class;
        PBJInternSet<Integer> res =
          new PBJInternSet<Integer>();
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
    
    public static LogExpr integerSize_get_log(LogProblem fallback_problem,
                                              LogExpr fallback_target,
                                              String fallback_targetTypeArgsStr,
                                              String[] fallback_targetTypeArgs,
                                              boolean isOld) {
        return LogMap.fieldGet_log(fallback_problem,
                                   fallback_target,
                                   "at.ac.testing.pbnj.SuperClass",
                                   fallback_targetTypeArgsStr,
                                   "integerSize",
                                   isOld);
    }
    
    public static LogRelation integerSize_old_get_log(LogProblem fallback_problem,
                                                      String fallback_targetTypeArgsStr,
                                                      String[] fallback_targetTypeArgs) {
        return LogMap.oldFieldGet_log(fallback_problem,
                                      "at.ac.testing.pbnj.SuperClass",
                                      fallback_targetTypeArgsStr,
                                      "integerSize");
    }
    
    public Integer fallback_updateField_integerSize(Integer newVal) {
        return this.integerSize =
          newVal;
    }
    
    public static LogExpr anArray_get_log(LogProblem fallback_problem,
                                          LogExpr fallback_target,
                                          String fallback_targetTypeArgsStr,
                                          String[] fallback_targetTypeArgs,
                                          boolean isOld) {
        return LogMap.fieldGet_log(fallback_problem,
                                   fallback_target,
                                   "at.ac.testing.pbnj.SuperClass",
                                   fallback_targetTypeArgsStr,
                                   "anArray",
                                   isOld);
    }
    
    public static LogRelation anArray_old_get_log(LogProblem fallback_problem,
                                                  String fallback_targetTypeArgsStr,
                                                  String[] fallback_targetTypeArgs) {
        return LogMap.oldFieldGet_log(fallback_problem,
                                      "at.ac.testing.pbnj.SuperClass",
                                      fallback_targetTypeArgsStr,
                                      "anArray");
    }
    
    public int fallback_updateArrayField_anArray(int index,
                                                 int newVal) {
        this.anArray[index] =
          newVal;
        return newVal;
    }
    
    public int[] fallback_updateField_anArray(java.util.ArrayList<Integer> newVal) {
        int i =
          0;
        int s =
          newVal.size();
        if (this.anArray ==
              null ||
              this.anArray.length !=
                s)
            this.anArray =
              (new int[s]);
        while (i <
                 s) {
            this.anArray[i] =
              newVal.get(i);
            i++;
        }
        return this.anArray;
    }
    
    public int[] fallback_updateField_anArray(int[] newVal) {
        return this.anArray =
          newVal;
    }
    
    public static LogExpr anIntegerArray_get_log(LogProblem fallback_problem,
                                                 LogExpr fallback_target,
                                                 String fallback_targetTypeArgsStr,
                                                 String[] fallback_targetTypeArgs,
                                                 boolean isOld) {
        return LogMap.fieldGet_log(fallback_problem,
                                   fallback_target,
                                   "at.ac.testing.pbnj.SuperClass",
                                   fallback_targetTypeArgsStr,
                                   "anIntegerArray",
                                   isOld);
    }
    
    public static LogRelation anIntegerArray_old_get_log(LogProblem fallback_problem,
                                                         String fallback_targetTypeArgsStr,
                                                         String[] fallback_targetTypeArgs) {
        return LogMap.oldFieldGet_log(fallback_problem,
                                      "at.ac.testing.pbnj.SuperClass",
                                      fallback_targetTypeArgsStr,
                                      "anIntegerArray");
    }
    
    public Integer fallback_updateArrayField_anIntegerArray(int index,
                                                            Integer newVal) {
        this.anIntegerArray[index] =
          newVal;
        return newVal;
    }
    
    public Integer[] fallback_updateField_anIntegerArray(java.util.ArrayList<Integer> newVal) {
        int i =
          0;
        int s =
          newVal.size();
        if (this.anIntegerArray ==
              null ||
              this.anIntegerArray.length !=
                s)
            this.anIntegerArray =
              (new Integer[s]);
        while (i <
                 s) {
            this.anIntegerArray[i] =
              newVal.get(i);
            i++;
        }
        return this.anIntegerArray;
    }
    
    public Integer[] fallback_updateField_anIntegerArray(Integer[] newVal) {
        return this.anIntegerArray =
          newVal;
    }
    
    boolean classInvariant_univQuantify_0() {
        for (Integer i : anIntegerArray) {
            if (!(i !=
                    null))
                return false;
        }
        return true;
    }
    
    boolean positiveArray_univQuantify_1() {
        for (int i : this.anArray) {
            if (!(i >
                    0))
                return false;
        }
        return true;
    }
    
    boolean positiveIntegerArray_univQuantify_2() {
        for (Integer i : this.anIntegerArray) {
            if (!(i >
                    0))
                return false;
        }
        return true;
    }
    
    boolean matchingElements_univQuantify_3(int elem) {
        for (int i : PBJInternInteger.range(0,
                                            this.anArray.length -
                                              1)) {
            if (!(anArray[i] ==
                    elem))
                return false;
        }
        return true;
    }
    
    boolean matchingIntegerElements_univQuantify_4(int elem) {
        for (Integer i : this.anArray) {
            if (!(i ==
                    elem))
                return false;
        }
        return true;
    }
    
    boolean resizeArray_univQuantify_5(int newSize) {
        for (Integer i : this.anArray) {
            if (!(i >
                    0))
                return false;
        }
        return true;
    }
    
    public static PBJInternSet<Integer> setMap_intSize(PBJInternSet<SuperClass> objs,
                                                       java.lang.String ... fieldNs) {
        PBJInternSet<Integer> res =
          new PBJInternSet<Integer>();
        java.util.Iterator<SuperClass> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().intSize);
        }
        return res;
    }
    
    public static PBJInternSet<Integer> setMap_integerSize(PBJInternSet<SuperClass> objs,
                                                           java.lang.String ... fieldNs) {
        PBJInternSet<Integer> res =
          new PBJInternSet<Integer>();
        java.util.Iterator<SuperClass> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().integerSize);
        }
        return res;
    }
    
    public static void fallback_initClassDefs() {
        
    }
    
    static {
               LogMap.newClassForLog(SuperClass.class,
                                     true);
               LogMap.newInstVarRel("intSize",
                                    SuperClass.class,
                                    "at.ac.testing.pbnj.SuperClass",
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
               LogMap.newInstVarRel("integerSize",
                                    SuperClass.class,
                                    "at.ac.testing.pbnj.SuperClass",
                                    Integer.class,
                                    "java.lang.Integer",
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
               LogMap.newInstVarRel("anArray",
                                    SuperClass.class,
                                    "at.ac.testing.pbnj.SuperClass",
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
               LogMap.newInstVarRel("anIntegerArray",
                                    SuperClass.class,
                                    "at.ac.testing.pbnj.SuperClass",
                                    Integer.class,
                                    "java.lang.Integer",
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
           }
    
    static LogExpr classInvariant_log(LogProblem fallback_problem,
                                      LogExpr fallback_target,
                                      String fallback_targetTypeArgsStr,
                                      String[] fallback_targetTypeArgs,
                                      boolean fallback_target_isOld) {
        boolean i_isOld =
          false;
        LogExpr quantVar_i =
          new LogExpr(fallback_problem,
                      kodkod.ast.Variable.unary("i"));
        LogExpr i =
          new LogExpr(fallback_problem,
                      quantVar_i.expr());
        LogExpr fallback_var_i =
          quantVar_i;
        return SuperClass.intSize_get_log(fallback_problem,
                                          fallback_target,
                                          fallback_targetTypeArgsStr,
                                          fallback_targetTypeArgs,
                                          fallback_target_isOld).eq(new LogExpr(fallback_problem,
                                                                                kodkod.ast.IntConstant.constant(0))).not().and(SuperClass.integerSize_get_log(fallback_problem,
                                                                                                                                                              fallback_target,
                                                                                                                                                              fallback_targetTypeArgsStr,
                                                                                                                                                              fallback_targetTypeArgs,
                                                                                                                                                              fallback_target_isOld).eq(fallback_problem.null_log()).not()).and(SuperClass.anArray_get_log(fallback_problem,
                                                                                                                                                                                                                                                           fallback_target,
                                                                                                                                                                                                                                                           fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                           fallback_targetTypeArgs,
                                                                                                                                                                                                                                                           fallback_target_isOld).no().not()).and(SuperClass.anIntegerArray_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                    fallback_target,
                                                                                                                                                                                                                                                                                                                                    fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                    fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                    fallback_target_isOld).no().not()).and(LogExpr.quantifyOp(SuperClass.anIntegerArray_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                fallback_target_isOld),
                                                                                                                                                                                                                                                                                                                                                                                              false,
                                                                                                                                                                                                                                                                                                                                                                                              "all",
                                                                                                                                                                                                                                                                                                                                                                                              fallback_var_i,
                                                                                                                                                                                                                                                                                                                                                                                              i.eq(fallback_problem.null_log()).not()));
    }
    
    static LogExpr positiveArray_log(LogProblem fallback_problem,
                                     LogExpr fallback_target,
                                     String fallback_targetTypeArgsStr,
                                     String[] fallback_targetTypeArgs,
                                     boolean fallback_target_isOld) {
        boolean i_isOld =
          false;
        LogExpr quantVar_i =
          new LogExpr(fallback_problem,
                      kodkod.ast.Variable.unary("i"));
        LogExpr i =
          new LogExpr(fallback_problem,
                      quantVar_i.expr());
        LogExpr fallback_var_i =
          quantVar_i;
        return SuperClass.anArray_get_log(fallback_problem,
                                          fallback_target,
                                          fallback_targetTypeArgsStr,
                                          fallback_targetTypeArgs,
                                          fallback_target_isOld).length_get_log(fallback_problem).gt(new LogExpr(fallback_problem,
                                                                                                                 kodkod.ast.IntConstant.constant(1))).and(LogExpr.quantifyOp(SuperClass.anArray_get_log(fallback_problem,
                                                                                                                                                                                                        fallback_target,
                                                                                                                                                                                                        fallback_targetTypeArgsStr,
                                                                                                                                                                                                        fallback_targetTypeArgs,
                                                                                                                                                                                                        fallback_target_isOld),
                                                                                                                                                                             false,
                                                                                                                                                                             "all",
                                                                                                                                                                             fallback_var_i,
                                                                                                                                                                             i.gt(new LogExpr(fallback_problem,
                                                                                                                                                                                              kodkod.ast.IntConstant.constant(0)))));
    }
    
    static LogExpr positiveIntegerArray_log(LogProblem fallback_problem,
                                            LogExpr fallback_target,
                                            String fallback_targetTypeArgsStr,
                                            String[] fallback_targetTypeArgs,
                                            boolean fallback_target_isOld) {
        boolean i_isOld =
          false;
        LogExpr quantVar_i =
          new LogExpr(fallback_problem,
                      kodkod.ast.Variable.unary("i"));
        LogExpr i =
          new LogExpr(fallback_problem,
                      quantVar_i.expr());
        LogExpr fallback_var_i =
          quantVar_i;
        return SuperClass.anIntegerArray_get_log(fallback_problem,
                                                 fallback_target,
                                                 fallback_targetTypeArgsStr,
                                                 fallback_targetTypeArgs,
                                                 fallback_target_isOld).length_get_log(fallback_problem).eq(new LogExpr(fallback_problem,
                                                                                                                        kodkod.ast.IntConstant.constant(4))).and(LogExpr.quantifyOp(SuperClass.anIntegerArray_get_log(fallback_problem,
                                                                                                                                                                                                                      fallback_target,
                                                                                                                                                                                                                      fallback_targetTypeArgsStr,
                                                                                                                                                                                                                      fallback_targetTypeArgs,
                                                                                                                                                                                                                      fallback_target_isOld),
                                                                                                                                                                                    false,
                                                                                                                                                                                    "all",
                                                                                                                                                                                    fallback_var_i,
                                                                                                                                                                                    i.gt(new LogExpr(fallback_problem,
                                                                                                                                                                                                     kodkod.ast.IntConstant.constant(0)))));
    }
    
    static LogExpr positiveSize_log(LogProblem fallback_problem,
                                    LogExpr fallback_target,
                                    String fallback_targetTypeArgsStr,
                                    String[] fallback_targetTypeArgs,
                                    boolean fallback_target_isOld) {
        return SuperClass.intSize_get_log(fallback_problem,
                                          fallback_target,
                                          fallback_targetTypeArgsStr,
                                          fallback_targetTypeArgs,
                                          fallback_target_isOld).gt(new LogExpr(fallback_problem,
                                                                                kodkod.ast.IntConstant.constant(0))).and(SuperClass.integerSize_get_log(fallback_problem,
                                                                                                                                                        fallback_target,
                                                                                                                                                        fallback_targetTypeArgsStr,
                                                                                                                                                        fallback_targetTypeArgs,
                                                                                                                                                        fallback_target_isOld).gt(new LogExpr(fallback_problem,
                                                                                                                                                                                              kodkod.ast.IntConstant.constant(0))));
    }
    
    static LogExpr matchingElements_log(LogProblem fallback_problem,
                                        LogExpr fallback_target,
                                        String fallback_targetTypeArgsStr,
                                        String[] fallback_targetTypeArgs,
                                        boolean fallback_target_isOld,
                                        LogExpr elem,
                                        boolean elem_isOld) {
        boolean i_isOld =
          false;
        LogExpr quantVar_i =
          new LogExpr(fallback_problem,
                      kodkod.ast.Variable.unary("i"));
        LogExpr i =
          new LogExpr(fallback_problem,
                      quantVar_i.expr());
        LogExpr fallback_var_i =
          quantVar_i;
        return LogExpr.quantifyOp(PBJInternSet.toPBJInternSet_log(fallback_problem,
                                                                  PBJInternInteger.range_log(fallback_problem,
                                                                                             fallback_problem.class_log(PBJInternInteger.class),
                                                                                             "",
                                                                                             null,
                                                                                             fallback_target_isOld,
                                                                                             new LogExpr(fallback_problem,
                                                                                                         kodkod.ast.IntConstant.constant(0)),
                                                                                             fallback_target_isOld,
                                                                                             SuperClass.anArray_get_log(fallback_problem,
                                                                                                                        fallback_target,
                                                                                                                        fallback_targetTypeArgsStr,
                                                                                                                        fallback_targetTypeArgs,
                                                                                                                        fallback_target_isOld).length_get_log(fallback_problem).minus(new LogExpr(fallback_problem,
                                                                                                                                                                                                  kodkod.ast.IntConstant.constant(1))),
                                                                                             fallback_target_isOld),
                                                                  "<java.lang.Integer>",
                                                                  new String[] { "java.lang.Integer" },
                                                                  fallback_target_isOld),
                                  false,
                                  "all",
                                  fallback_var_i,
                                  SuperClass.anArray_get_log(fallback_problem,
                                                             fallback_target,
                                                             fallback_targetTypeArgsStr,
                                                             fallback_targetTypeArgs,
                                                             fallback_target_isOld).get_log(fallback_problem,
                                                                                            i,
                                                                                            false).eq(elem));
    }
    
    static LogExpr matchingIntegerElements_log(LogProblem fallback_problem,
                                               LogExpr fallback_target,
                                               String fallback_targetTypeArgsStr,
                                               String[] fallback_targetTypeArgs,
                                               boolean fallback_target_isOld,
                                               LogExpr elem,
                                               boolean elem_isOld) {
        boolean i_isOld =
          false;
        LogExpr quantVar_i =
          new LogExpr(fallback_problem,
                      kodkod.ast.Variable.unary("i"));
        LogExpr i =
          new LogExpr(fallback_problem,
                      quantVar_i.expr());
        LogExpr fallback_var_i =
          quantVar_i;
        return LogExpr.quantifyOp(SuperClass.anArray_get_log(fallback_problem,
                                                             fallback_target,
                                                             fallback_targetTypeArgsStr,
                                                             fallback_targetTypeArgs,
                                                             fallback_target_isOld),
                                  false,
                                  "all",
                                  fallback_var_i,
                                  i.eq(elem));
    }
    
    static LogExpr resizeArray_log(LogProblem fallback_problem,
                                   LogExpr fallback_target,
                                   String fallback_targetTypeArgsStr,
                                   String[] fallback_targetTypeArgs,
                                   boolean fallback_target_isOld,
                                   LogExpr newSize,
                                   boolean newSize_isOld) {
        boolean i_isOld =
          false;
        LogExpr quantVar_i =
          new LogExpr(fallback_problem,
                      kodkod.ast.Variable.unary("i"));
        LogExpr i =
          new LogExpr(fallback_problem,
                      quantVar_i.expr());
        LogExpr fallback_var_i =
          quantVar_i;
        return SuperClass.anArray_get_log(fallback_problem,
                                          fallback_target,
                                          fallback_targetTypeArgsStr,
                                          fallback_targetTypeArgs,
                                          fallback_target_isOld).length_get_log(fallback_problem).eq(newSize).and(LogExpr.quantifyOp(SuperClass.anArray_get_log(fallback_problem,
                                                                                                                                                                fallback_target,
                                                                                                                                                                fallback_targetTypeArgsStr,
                                                                                                                                                                fallback_targetTypeArgs,
                                                                                                                                                                fallback_target_isOld),
                                                                                                                                     false,
                                                                                                                                     "all",
                                                                                                                                     fallback_var_i,
                                                                                                                                     i.gt(new LogExpr(fallback_problem,
                                                                                                                                                      kodkod.ast.IntConstant.constant(0)))));
    }
    
    static LogExpr sameSize_log(LogProblem fallback_problem,
                                LogExpr fallback_target,
                                String fallback_targetTypeArgsStr,
                                String[] fallback_targetTypeArgs,
                                boolean fallback_target_isOld,
                                LogExpr newSize,
                                boolean newSize_isOld) {
        return SuperClass.intSize_get_log(fallback_problem,
                                          fallback_target,
                                          fallback_targetTypeArgsStr,
                                          fallback_targetTypeArgs,
                                          fallback_target_isOld).eq(newSize).and(SuperClass.integerSize_get_log(fallback_problem,
                                                                                                                fallback_target,
                                                                                                                fallback_targetTypeArgsStr,
                                                                                                                fallback_targetTypeArgs,
                                                                                                                fallback_target_isOld).eq(newSize));
    }
    
    public static LogExpr fallback_checkInvariants_log(LogProblem fallback_problem,
                                                       LogExpr fallback_target,
                                                       String fallback_targetTypeArgsStr,
                                                       String[] fallback_targetTypeArgs,
                                                       boolean fallback_target_isOld) {
        return SuperClass.classInvariant_log(fallback_problem,
                                             fallback_target,
                                             fallback_targetTypeArgsStr,
                                             fallback_targetTypeArgs,
                                             fallback_target_isOld);
    }
    
    public static LogExpr initH_checkContract_log(LogProblem fallback_problem,
                                                  LogExpr fallback_target,
                                                  String fallback_targetTypeArgsStr,
                                                  String[] fallback_targetTypeArgs,
                                                  boolean fallback_target_isOld) {
        return SuperClass.fallback_checkInvariants_log(fallback_problem,
                                                       fallback_target,
                                                       fallback_targetTypeArgsStr,
                                                       fallback_targetTypeArgs,
                                                       fallback_target_isOld).and(SuperClass.initH_checkFieldsInvariants_log(fallback_problem,
                                                                                                                             fallback_target,
                                                                                                                             fallback_targetTypeArgsStr,
                                                                                                                             fallback_targetTypeArgs,
                                                                                                                             fallback_target_isOld)).and(SuperClass.positiveSize_log(fallback_problem,
                                                                                                                                                                                     fallback_target,
                                                                                                                                                                                     fallback_targetTypeArgsStr,
                                                                                                                                                                                     fallback_targetTypeArgs,
                                                                                                                                                                                     fallback_target_isOld).and(SuperClass.positiveArray_log(fallback_problem,
                                                                                                                                                                                                                                             fallback_target,
                                                                                                                                                                                                                                             fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                             fallback_targetTypeArgs,
                                                                                                                                                                                                                                             fallback_target_isOld)).and(SuperClass.positiveIntegerArray_log(fallback_problem,
                                                                                                                                                                                                                                                                                                             fallback_target,
                                                                                                                                                                                                                                                                                                             fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                             fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                             fallback_target_isOld)));
    }
    
    public static LogExpr initH_checkFieldsInvariants_log(LogProblem fallback_problem,
                                                          LogExpr fallback_target,
                                                          String fallback_targetTypeArgsStr,
                                                          String[] fallback_targetTypeArgs,
                                                          boolean fallback_target_isOld) {
        return new LogExpr(fallback_problem,
                           kodkod.ast.Formula.TRUE);
    }
    
    public static LogExpr resize_int_checkContract_log(LogProblem fallback_problem,
                                                       LogExpr fallback_target,
                                                       String fallback_targetTypeArgsStr,
                                                       String[] fallback_targetTypeArgs,
                                                       boolean fallback_target_isOld,
                                                       LogExpr newSize,
                                                       boolean newSize_isOld) {
        return SuperClass.fallback_checkInvariants_log(fallback_problem,
                                                       fallback_target,
                                                       fallback_targetTypeArgsStr,
                                                       fallback_targetTypeArgs,
                                                       fallback_target_isOld).and(SuperClass.resize_int_checkFieldsInvariants_log(fallback_problem,
                                                                                                                                  fallback_target,
                                                                                                                                  fallback_targetTypeArgsStr,
                                                                                                                                  fallback_targetTypeArgs,
                                                                                                                                  fallback_target_isOld)).and(SuperClass.positiveSize_log(fallback_problem,
                                                                                                                                                                                          fallback_target,
                                                                                                                                                                                          fallback_targetTypeArgsStr,
                                                                                                                                                                                          fallback_targetTypeArgs,
                                                                                                                                                                                          fallback_target_isOld).and(SuperClass.sameSize_log(fallback_problem,
                                                                                                                                                                                                                                             fallback_target,
                                                                                                                                                                                                                                             fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                             fallback_targetTypeArgs,
                                                                                                                                                                                                                                             fallback_target_isOld,
                                                                                                                                                                                                                                             newSize,
                                                                                                                                                                                                                                             newSize_isOld)).and(SuperClass.resizeArray_log(fallback_problem,
                                                                                                                                                                                                                                                                                            fallback_target,
                                                                                                                                                                                                                                                                                            fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                            fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                            fallback_target_isOld,
                                                                                                                                                                                                                                                                                            newSize,
                                                                                                                                                                                                                                                                                            newSize_isOld)));
    }
    
    public static LogExpr resize_int_checkFieldsInvariants_log(LogProblem fallback_problem,
                                                               LogExpr fallback_target,
                                                               String fallback_targetTypeArgsStr,
                                                               String[] fallback_targetTypeArgs,
                                                               boolean fallback_target_isOld) {
        return new LogExpr(fallback_problem,
                           kodkod.ast.Formula.TRUE);
    }
    
    public static LogExpr updateAnArray_int_checkContract_log(LogProblem fallback_problem,
                                                              LogExpr fallback_target,
                                                              String fallback_targetTypeArgsStr,
                                                              String[] fallback_targetTypeArgs,
                                                              boolean fallback_target_isOld,
                                                              LogExpr newSize,
                                                              boolean newSize_isOld) {
        return SuperClass.fallback_checkInvariants_log(fallback_problem,
                                                       fallback_target,
                                                       fallback_targetTypeArgsStr,
                                                       fallback_targetTypeArgs,
                                                       fallback_target_isOld).and(SuperClass.updateAnArray_int_checkFieldsInvariants_log(fallback_problem,
                                                                                                                                         fallback_target,
                                                                                                                                         fallback_targetTypeArgsStr,
                                                                                                                                         fallback_targetTypeArgs,
                                                                                                                                         fallback_target_isOld)).and(SuperClass.matchingElements_log(fallback_problem,
                                                                                                                                                                                                     fallback_target,
                                                                                                                                                                                                     fallback_targetTypeArgsStr,
                                                                                                                                                                                                     fallback_targetTypeArgs,
                                                                                                                                                                                                     fallback_target_isOld,
                                                                                                                                                                                                     newSize,
                                                                                                                                                                                                     newSize_isOld));
    }
    
    public static LogExpr updateAnArray_int_checkFieldsInvariants_log(LogProblem fallback_problem,
                                                                      LogExpr fallback_target,
                                                                      String fallback_targetTypeArgsStr,
                                                                      String[] fallback_targetTypeArgs,
                                                                      boolean fallback_target_isOld) {
        return new LogExpr(fallback_problem,
                           kodkod.ast.Formula.TRUE);
    }
    
    public static LogExpr updateAnIntegerArray_int_checkContract_log(LogProblem fallback_problem,
                                                                     LogExpr fallback_target,
                                                                     String fallback_targetTypeArgsStr,
                                                                     String[] fallback_targetTypeArgs,
                                                                     boolean fallback_target_isOld,
                                                                     LogExpr newSize,
                                                                     boolean newSize_isOld) {
        return SuperClass.fallback_checkInvariants_log(fallback_problem,
                                                       fallback_target,
                                                       fallback_targetTypeArgsStr,
                                                       fallback_targetTypeArgs,
                                                       fallback_target_isOld).and(SuperClass.updateAnIntegerArray_int_checkFieldsInvariants_log(fallback_problem,
                                                                                                                                                fallback_target,
                                                                                                                                                fallback_targetTypeArgsStr,
                                                                                                                                                fallback_targetTypeArgs,
                                                                                                                                                fallback_target_isOld)).and(SuperClass.matchingIntegerElements_log(fallback_problem,
                                                                                                                                                                                                                   fallback_target,
                                                                                                                                                                                                                   fallback_targetTypeArgsStr,
                                                                                                                                                                                                                   fallback_targetTypeArgs,
                                                                                                                                                                                                                   fallback_target_isOld,
                                                                                                                                                                                                                   newSize,
                                                                                                                                                                                                                   newSize_isOld));
    }
    
    public static LogExpr updateAnIntegerArray_int_checkFieldsInvariants_log(LogProblem fallback_problem,
                                                                             LogExpr fallback_target,
                                                                             String fallback_targetTypeArgsStr,
                                                                             String[] fallback_targetTypeArgs,
                                                                             boolean fallback_target_isOld) {
        return new LogExpr(fallback_problem,
                           kodkod.ast.Formula.TRUE);
    }
}
