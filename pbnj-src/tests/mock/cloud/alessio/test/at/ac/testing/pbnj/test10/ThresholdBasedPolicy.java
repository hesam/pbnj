package at.ac.testing.pbnj.test10;

import polyglot.ext.pbnj.tologic.*;
import polyglot.ext.pbnj.primitives.*;

public class ThresholdBasedPolicy implements PBJInternObject {
    int roundup;
    
    int lowerBound;
    
    int upperBound;
    
    int multiplier;
    
    public int MAX_INT =
      256;
    
    boolean valid() {
        return true &&
                 this.lowerBound >=
                   0 &&
          this.upperBound >=
            this.lowerBound;
    }
    
    public ThresholdBasedPolicy(int lowerBound,
                                int upperBound) {
        super();
        this.lowerBound =
          lowerBound;
        this.upperBound =
          upperBound;
        this.addInstance();
    }
    
    public String toString() {
        return "Policy: \n" +
               "Lower Bound " +
               this.lowerBound +
               "\n" +
               "Upper Bound " +
               this.upperBound +
               "\n" +
               "roundup " +
               this.roundup +
               "\n" +
        "";
    }
    
    int abs(int i) {
        return i <
                 0 ? -i : i;
    }
    
    int max(int i,
            int j) {
        return i >=
                 j ? i : j;
    }
    
    PBJInternSet<Integer> getCommonDivisors(int a,
                                            int b) {
        return getCommonDivisors_setComprehension_0(a,
                                                    b);
    }
    
    public SensorReading resize(int currentSize,
                                int targetSize) {
        try {
            updateMultiplierH(currentSize,
                              targetSize);
        }
        catch (Throwable e) {
            e.printStackTrace();
            if (e.getMessage() !=
                  null &&
                  e.getMessage().contains("UNSAT")) {
                System.out.println(("Missing Precondition: There is not valid integer value to tr" +
                                    "igger the specified transition!"));
                int z =
                  1 /
                  0;
            }
        }
        System.out.println(" THE MULTIPLIER " +
                           this.multiplier);
        return resizeH(currentSize,
                       targetSize);
    }
    
    PBJInternSet<Integer> validMultipliers(int currentSize,
                                           int targetSize) {
        return validMultipliers_setComprehension_1(currentSize,
                                                   targetSize);
    }
    
    int getBiggestValidMultiplier(int currentSize,
                                  int targetSize) {
        return getBiggestValidMultiplier_setComprehension_3(currentSize,
                                                            targetSize).get();
    }
    
    void updateMultiplierH_int_int_orig(int currentSize,
                                        int targetSize) {
        
    }
    
    PBJInternSet<Integer> getAllResize(int currentSize,
                                       int targetSize) {
        return getAllResize_setComprehension_4(currentSize,
                                               targetSize);
    }
    
    int getTheResize(int currentSize,
                     int targetSize) {
        return getTheResize_setComprehension_5(currentSize,
                                               targetSize).get();
    }
    
    public boolean scalesUpTest(int value,
                                int currentSize,
                                int targetSize) {
        int scaledUpperBound =
          this.upperBound /
          this.multiplier;
        int scaledLowerBound =
          this.lowerBound /
          this.multiplier;
        return currentSize >
                 0 &&
                 value >
                   scaledUpperBound &&
                 value <=
                   scaledUpperBound *
                     targetSize /
                     currentSize &&
                 (!(scaledUpperBound *
                      targetSize <
                      (targetSize +
                         1) *
                        scaledLowerBound) ||
                    value <
                      (targetSize +
                         1) *
                        scaledLowerBound /
                        currentSize) &&
                 (!(scaledUpperBound *
                      targetSize >=
                      (targetSize +
                         1) *
                        scaledLowerBound) ||
                    value >
                      scaledUpperBound *
                        (targetSize -
                           1) /
                        currentSize) ||
          currentSize ==
            0 &&
            value >
              0 &&
            value <=
              scaledUpperBound *
                targetSize &&
            (!(scaledUpperBound *
                 targetSize <
                 (targetSize +
                    1) *
                   scaledLowerBound) ||
               value <
                 (targetSize +
                    1) *
                   scaledLowerBound) &&
            (!(scaledUpperBound *
                 targetSize >=
                 (targetSize +
                    1) *
                   scaledLowerBound) ||
               value >
                 scaledUpperBound *
                   (targetSize -
                      1));
    }
    
    public boolean scalesDownTest(int value,
                                  int currentSize,
                                  int targetSize) {
        int nextBiggerSize =
          targetSize +
          1;
        int nextSmaller =
          targetSize -
          1;
        int scaledUpperBound =
          this.upperBound /
          this.multiplier;
        int scaledLowerBound =
          this.lowerBound /
          this.multiplier;
        return value <
                 scaledLowerBound &&
                 (scaledUpperBound >=
                    scaledLowerBound *
                      targetSize /
                      nextSmaller &&
                    value >=
                      roundUp(scaledLowerBound *
                                targetSize,
                              currentSize) ||
                    scaledUpperBound <
                      scaledLowerBound *
                        targetSize /
                        nextSmaller &&
                      currentSize >=
                        scaledUpperBound *
                          nextSmaller /
                          value &&
                      currentSize >
                        scaledLowerBound *
                          nextSmaller /
                          value) &&
          ((!(this.lowerBound <=
                this.upperBound *
                  targetSize /
                  nextBiggerSize) ||
              value <
                roundUp(nextBiggerSize *
                          scaledLowerBound,
                        currentSize)) &&
             (!(this.lowerBound >
                  this.upperBound *
                    targetSize /
                    nextBiggerSize) ||
                value <=
                  scaledUpperBound /
                    currentSize *
                    targetSize));
    }
    
    public boolean staysTest(int value,
                             int currentSize,
                             int targetSize) {
        int scaledUpperBound =
          this.upperBound /
          this.multiplier;
        int scaledLowerBound =
          this.lowerBound /
          this.multiplier;
        return currentSize >
                 0 &&
                 value <=
                   scaledUpperBound *
                     currentSize /
                     currentSize &&
                 (!((currentSize -
                       1) *
                      scaledUpperBound <=
                      currentSize *
                        scaledLowerBound) ||
                    value >
                      (currentSize -
                         1) *
                        scaledUpperBound /
                        currentSize) &&
                 (!((currentSize -
                       1) *
                      scaledUpperBound >
                      currentSize *
                        scaledLowerBound) ||
                    value >=
                      scaledLowerBound *
                        currentSize /
                        currentSize) ||
          currentSize ==
            0 &&
            value ==
              0;
    }
    
    public SensorReading resizeH_int_int_orig(int currentSize,
                                              int targetSize) {
        System.out.println(currentSize +
                           " --> " +
                           targetSize +
                           " with multiplier " +
                           this.multiplier +
                           " and MAX_INT " +
                           MAX_INT);
        if (currentSize >
              targetSize) {
            System.out.println("Trigger the scale down Must be < " +
                               this.lowerBound /
                                 this.multiplier);
            if (this.upperBound /
                  this.multiplier *
                  (targetSize -
                     1) >=
                  this.lowerBound /
                    this.multiplier *
                    targetSize) {
                System.out.println(" (Overlapping - below - Rounded)  >= " +
                                   roundUp(this.lowerBound /
                                             this.multiplier *
                                             targetSize,
                                           currentSize));
            } else {
                System.out.println("(Not Overlapping - below ) Must be   >= " +
                                   this.upperBound /
                                     this.multiplier *
                                     (targetSize -
                                        1) /
                                     currentSize);
                System.out.println("(Not Overlapping - below ) Must be   > " +
                                   this.lowerBound /
                                     this.multiplier *
                                     (targetSize -
                                        1) /
                                     currentSize);
                System.out.println("(Not Overlapping - below ) Must be   >= " +
                                   (double)
                                     this.upperBound *
                                     ((double)
                                        targetSize -
                                        1) /
                                     (double)
                                       currentSize);
                System.out.println("(Not Overlapping - below ) Must be   > " +
                                   this.lowerBound *
                                     (targetSize -
                                        1) /
                                     currentSize);
            }
            if (this.lowerBound *
                  (targetSize +
                     1) <=
                  this.upperBound *
                    targetSize) {
                System.out.println(" (Overlapping - above) Must be   < " +
                                   roundUp(this.lowerBound /
                                             this.multiplier *
                                             (targetSize +
                                                1),
                                           currentSize));
                System.out.println(" (Overlapping - above) Must be   < " +
                                   (double)
                                     this.lowerBound /
                                     (double)
                                       this.multiplier *
                                     ((double)
                                        targetSize +
                                        1) /
                                     (double)
                                       currentSize);
            } else {
                System.out.println(" (Not Overlapping - above) Must be   <= " +
                                   this.upperBound /
                                     this.multiplier *
                                     targetSize /
                                     currentSize);
            }
        } else
            if (currentSize <
                  targetSize) {
                if (currentSize >
                      0) {
                    System.out.println("Trigger the scale up Must be > " +
                                       this.upperBound /
                                         this.multiplier);
                    System.out.println("(Ideally)\t\t: To stay inside the target conf Must be <= " +
                                       this.upperBound /
                                         this.multiplier *
                                         targetSize /
                                         currentSize);
                    if (this.upperBound /
                          this.multiplier *
                          targetSize <
                          this.lowerBound /
                            this.multiplier *
                            (targetSize +
                               1)) {
                        System.out.println(("(Non-Overlapping)\t: To stay inside the target conf Must be " +
                                            "< ") +
                                           this.lowerBound /
                                             this.multiplier *
                                             (targetSize +
                                                1) /
                                             currentSize);
                    } else {
                        System.out.println("(Overlapping)\t\t: To stay inside the target conf Must be > " +
                                           this.upperBound /
                                             this.multiplier *
                                             (targetSize -
                                                1) /
                                             currentSize);
                    }
                } else {
                    System.out.println("Trigger the scale up Must be > " +
                                       0);
                    System.out.println("(Ideally)\t\t: To stay inside the target conf Must be <= " +
                                       this.upperBound /
                                         this.multiplier *
                                         targetSize);
                    if (this.upperBound /
                          this.multiplier *
                          targetSize <
                          this.lowerBound /
                            this.multiplier *
                            (targetSize +
                               1)) {
                        System.out.println(("(Non-Overlapping)\t: To stay inside the target conf Must be " +
                                            "< ") +
                                           this.lowerBound /
                                             this.multiplier *
                                             (targetSize +
                                                1));
                    } else {
                        System.out.println("(Overlapping)\t\t: To stay inside the target conf Must be > " +
                                           this.upperBound /
                                             this.multiplier *
                                             (targetSize -
                                                1));
                    }
                }
            } else {
                
            }
        System.out.println(" All possible resize values\t" +
                           getAllResize(currentSize,
                                        targetSize));
        System.out.println(" One possible resize value\t\t" +
                           getTheResize(currentSize,
                                        targetSize));
        return null;
    }
    
    int roundUp(int nom,
                int den) {
        return nom /
                 den *
                 den <
                 nom ? nom /
                         den +
                         1 : nom /
                               den;
    }
    
    public boolean fullyContained(SensorReading sensorReading,
                                  int currentSize,
                                  int targetSize) {
        int scaledUpperBound =
          this.upperBound /
          this.multiplier;
        int scaledLowerBound =
          this.lowerBound /
          this.multiplier;
        return true &&
                 sensorReading.value *
                   currentSize >=
                   scaledLowerBound *
                     targetSize &&
          sensorReading.value *
            currentSize <=
            scaledUpperBound *
              targetSize;
    }
    
    public boolean scalesUp(SensorReading sensorReading,
                            int currentSize,
                            int targetSize) {
        int scaledUpperBound =
          this.upperBound /
          this.multiplier;
        int scaledLowerBound =
          this.lowerBound /
          this.multiplier;
        return currentSize >
                 0 &&
                 sensorReading.value >
                   scaledUpperBound &&
                 sensorReading.value <=
                   scaledUpperBound *
                     targetSize /
                     currentSize &&
                 (!(scaledUpperBound *
                      targetSize <
                      (targetSize +
                         1) *
                        scaledLowerBound) ||
                    sensorReading.value <
                      (targetSize +
                         1) *
                        scaledLowerBound /
                        currentSize) &&
                 (!(scaledUpperBound *
                      targetSize >=
                      (targetSize +
                         1) *
                        scaledLowerBound) ||
                    sensorReading.value >
                      scaledUpperBound *
                        (targetSize -
                           1) /
                        currentSize) ||
          currentSize ==
            0 &&
            sensorReading.value >
              0 &&
            sensorReading.value <=
              scaledUpperBound *
                targetSize &&
            (!(scaledUpperBound *
                 targetSize <
                 (targetSize +
                    1) *
                   scaledLowerBound) ||
               sensorReading.value <
                 (targetSize +
                    1) *
                   scaledLowerBound) &&
            (!(scaledUpperBound *
                 targetSize >=
                 (targetSize +
                    1) *
                   scaledLowerBound) ||
               sensorReading.value >
                 scaledUpperBound *
                   (targetSize -
                      1));
    }
    
    public boolean stays(SensorReading sensorReading,
                         int currentSize,
                         int targetSize) {
        int scaledUpperBound =
          this.upperBound /
          this.multiplier;
        int scaledLowerBound =
          this.lowerBound /
          this.multiplier;
        return currentSize >
                 0 &&
                 sensorReading.value <=
                   scaledUpperBound *
                     currentSize /
                     currentSize &&
                 (!((currentSize -
                       1) *
                      scaledUpperBound <=
                      currentSize *
                        scaledLowerBound) ||
                    sensorReading.value >
                      (currentSize -
                         1) *
                        scaledUpperBound /
                        currentSize) &&
                 (!((currentSize -
                       1) *
                      scaledUpperBound >
                      currentSize *
                        scaledLowerBound) ||
                    sensorReading.value >=
                      scaledLowerBound *
                        currentSize /
                        currentSize) ||
          currentSize ==
            0 &&
            sensorReading.value ==
              0;
    }
    
    public ThresholdBasedPolicy old;
    
    public boolean fallback_pbnj;
    
    Object fallback_field_result;
    
    public void fallback_field_result(Object r) {
        this.fallback_field_result =
          r;
    }
    
    public ThresholdBasedPolicy(LogExpr dontcare) {
        super();
        this.addInstance();
    }
    
    Object[] fallback_field_resultArray;
    
    public void fallback_field_resultArray(Object[] r) {
        this.fallback_field_resultArray =
          r;
    }
    
    public boolean fallback_checkInvariants() {
        return valid();
    }
    
    public void addInstance() {
        LogMap.addInstance(ThresholdBasedPolicy.class,
                           this);
    }
    
    public void addInstanceForProblem(ThresholdBasedPolicy toAdd,
                                      LogProblem fallback_problem,
                                      String fallback_targetTypeArgsStr) {
        fallback_problem.addToClassInstances(toAdd,
                                             ThresholdBasedPolicy.class,
                                             "at.ac.testing.pbnj.test10.ThresholdBasedPolicy",
                                             fallback_targetTypeArgsStr);
    }
    
    long startMethodTime;
    
    boolean isOld;
    
    Object fallback_consistencyLock;
    
    int fallback_updateTime;
    
    public ThresholdBasedPolicy old() {
        return this.old;
    }
    
    String[] fallback_typeArgs;
    
    public ThresholdBasedPolicy fallback_setTypeArgs(String[] args) {
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
        return ThresholdBasedPolicy.classRelationizerStep ==
          fallback_problem.relationizerStep();
    }
    
    public static int classAtomizerStep =
      0;
    
    public static boolean isClassAtomized(LogProblem fallback_problem) {
        return ThresholdBasedPolicy.classAtomizerStep ==
          fallback_problem.relationizerStep();
    }
    
    public static int classClonerStep =
      0;
    
    public static boolean isClassCloned() {
        return ThresholdBasedPolicy.classClonerStep ==
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
    
    public boolean updateMultiplierH_int_int_checkContract(int currentSize,
                                                           int targetSize) {
        return this.fallback_checkInvariants() &&
                 this.updateMultiplierH_int_int_checkFieldsInvariants() &&
          getBiggestValidMultiplier(currentSize,
                                    targetSize) ==
            this.multiplier;
    }
    
    public void updateMultiplierH_int_int_assertContract(int currentSize,
                                                         int targetSize) {
        assert updateMultiplierH_int_int_checkContract(currentSize,
                                                       targetSize);
    }
    
    public void updateMultiplierH_int_int_commitModel(int currentSize,
                                                      int targetSize,
                                                      LogProblem fallback_problem) {
        fallback_problem.commitModel(this);
    }
    
    LogProblem updateMultiplierH_int_int_planb(int currentSize,
                                               int targetSize) {
        boolean currentSize_isOld =
          false;
        boolean targetSize_isOld =
          false;
        System.out.println("\n" +
                             (this +
                                (" (" +
                                   (Thread.currentThread() +
                                      (": updateMultiplierH" +
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
        fallback_problem.setModifiableField("at.ac.testing.pbnj.test10.ThresholdBasedPolicy.multiplier");
        LogExpr fallback_target =
          fallback_problem.objToSingletonRelation_log(this);
        boolean fallback_target_isOld =
          false;
        LogExpr fallback_formula =
          ThresholdBasedPolicy.updateMultiplierH_int_int_checkContract_log(fallback_problem,
                                                                           fallback_target,
                                                                           fallback_targetTypeArgsStr,
                                                                           fallback_targetTypeArgs,
                                                                           fallback_target_isOld,
                                                                           fallback_problem.intToSingletonRelation_log(currentSize),
                                                                           currentSize_isOld,
                                                                           fallback_problem.intToSingletonRelation_log(targetSize),
                                                                           targetSize_isOld);
        boolean isSatisfiable =
          fallback_problem.solve("updateMultiplierH_int_int",
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
    
    void updateMultiplierH(int currentSize,
                           int targetSize) {
        updateMultiplierH_int_int_ensured(currentSize,
                                          targetSize);
    }
    
    void updateMultiplierH_int_int_ensured(int currentSize,
                                           int targetSize) {
        initEnsuredMethod();
        try {
            updateMultiplierH_int_int_orig(currentSize,
                                           targetSize);
            updateMultiplierH_int_int_assertContract(currentSize,
                                                     targetSize);
        }
        catch (Throwable rte) {
            {
                rte.printStackTrace();
                LogProblem fallback_problem =
                  updateMultiplierH_int_int_planb(currentSize,
                                                  targetSize);
                updateMultiplierH_int_int_commitModel(currentSize,
                                                      targetSize,
                                                      fallback_problem);
            }
        }
    }
    
    public boolean updateMultiplierH_int_int_checkFieldsInvariants() {
        return true;
    }
    
    public boolean resizeH_int_int_checkContract(int currentSize,
                                                 int targetSize) {
        return this.fallback_checkInvariants() &&
                 this.resizeH_int_int_checkFieldsInvariants() &&
                 (this.fallback_field_result ==
                    null ||
                    ((SensorReading)
                       this.fallback_field_result).fallback_checkInvariants()) &&
          ((SensorReading)
             this.fallback_field_result !=
             null &&
             ((SensorReading)
                this.fallback_field_result).multiplier ==
               this.multiplier &&
             this.roundup ==
               roundUp(this.lowerBound /
                         this.multiplier *
                         targetSize,
                       currentSize) &&
             targetSize <
               currentSize &&
             scalesDownTest(((SensorReading)
                               this.fallback_field_result).value,
                            currentSize,
                            targetSize));
    }
    
    public void resizeH_int_int_assertContract(int currentSize,
                                               int targetSize) {
        assert resizeH_int_int_checkContract(currentSize,
                                             targetSize);
    }
    
    public void resizeH_int_int_commitModel(int currentSize,
                                            int targetSize,
                                            LogProblem fallback_problem) {
        fallback_problem.commitModel(this);
    }
    
    LogProblem resizeH_int_int_planb(int currentSize,
                                     int targetSize) {
        boolean currentSize_isOld =
          false;
        boolean targetSize_isOld =
          false;
        System.out.println("\n" +
                             (this +
                                (" (" +
                                   (Thread.currentThread() +
                                      (": resizeH" +
                                         ") initiated plan b...")))));
        SensorReading.fallback_initClassDefs();
        SensorReading.fallback_initClassDefs();
        LogProblem fallback_problem =
          LogMap.initRelationize();
        String fallback_targetTypeArgsStr =
          "";
        String[] fallback_targetTypeArgs =
          null;
        fallback_problem.newFreshInstances();
        fallback_problem.setFreshInstances("at.ac.testing.pbnj.test10.SensorReading",
                                           1);
        fallback_problem.setFreshInstances("at.ac.testing.pbnj.test10.SensorReading",
                                           1);
        old.fallback_atomize(fallback_problem,
                             "",
                             null);
        SensorReading.fallback_classClone();
        SensorReading.fallback_classClone();
        SensorReading.fallback_classAtomize(fallback_problem,
                                            fallback_targetTypeArgsStr,
                                            fallback_targetTypeArgs);
        SensorReading.fallback_classAtomize(fallback_problem,
                                            fallback_targetTypeArgsStr,
                                            fallback_targetTypeArgs);
        fallback_problem.ObjToAtomMap();
        old.fallback_relationizeOld(fallback_problem,
                                    "",
                                    null);
        SensorReading.fallback_classRelationizeOld(fallback_problem,
                                                   fallback_targetTypeArgsStr,
                                                   fallback_targetTypeArgs);
        SensorReading.fallback_classRelationizeOld(fallback_problem,
                                                   fallback_targetTypeArgsStr,
                                                   fallback_targetTypeArgs);
        fallback_problem.initRelations();
        fallback_problem.newModifiableFields();
        fallback_problem.setModifiableField("at.ac.testing.pbnj.test10.ThresholdBasedPolicy.roundup");
        LogExpr fallback_target =
          fallback_problem.objToSingletonRelation_log(this);
        boolean fallback_target_isOld =
          false;
        LogExpr fallback_formula =
          ThresholdBasedPolicy.resizeH_int_int_checkContract_log(fallback_problem,
                                                                 fallback_target,
                                                                 fallback_targetTypeArgsStr,
                                                                 fallback_targetTypeArgs,
                                                                 fallback_target_isOld,
                                                                 fallback_problem.intToSingletonRelation_log(currentSize),
                                                                 currentSize_isOld,
                                                                 fallback_problem.intToSingletonRelation_log(targetSize),
                                                                 targetSize_isOld);
        boolean isSatisfiable =
          fallback_problem.solve("resizeH_int_int",
                                 this,
                                 fallback_formula.formula(),
                                 null,
                                 true,
                                 false,
                                 this.startMethodTime,
                                 false);
        assert isSatisfiable: "Formula UNSAT! Recovery failed...";
        return fallback_problem;
    }
    
    public SensorReading resizeH(int currentSize,
                                 int targetSize) {
        return resizeH_int_int_ensured(currentSize,
                                       targetSize);
    }
    
    public SensorReading resizeH_int_int_ensured(int currentSize,
                                                 int targetSize) {
        SensorReading fallback_result;
        initEnsuredMethod();
        try {
            fallback_result =
              resizeH_int_int_orig(currentSize,
                                   targetSize);
            this.fallback_field_result =
              fallback_result;
            resizeH_int_int_assertContract(currentSize,
                                           targetSize);
            return fallback_result;
        }
        catch (Throwable rte) {
            {
                rte.printStackTrace();
                LogProblem fallback_problem =
                  resizeH_int_int_planb(currentSize,
                                        targetSize);
                resizeH_int_int_commitModel(currentSize,
                                            targetSize,
                                            fallback_problem);
                return (SensorReading)
                         this.fallback_field_result;
            }
        }
    }
    
    public boolean resizeH_int_int_checkFieldsInvariants() {
        return true;
    }
    
    SensorReading fallback_field_result_resizeH_int_int;
    
    public void fallback_atomize(LogProblem fallback_problem,
                                 String fallback_targetTypeArgsStr,
                                 String[] fallback_targetTypeArgs) {
        if (!isAtomized(fallback_problem)) {
            this.atomizerStep =
              fallback_problem.relationizerStep();
            ThresholdBasedPolicy.fallback_classAtomize(fallback_problem,
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
            ThresholdBasedPolicy.fallback_classRelationizeOld(fallback_problem,
                                                              fallback_targetTypeArgsStr,
                                                              fallback_targetTypeArgs);
            ThresholdBasedPolicy.roundup_old_get_log(fallback_problem,
                                                     fallback_targetTypeArgsStr,
                                                     fallback_targetTypeArgs).put_log(fallback_problem,
                                                                                      this,
                                                                                      this.roundup);
            ThresholdBasedPolicy.lowerBound_old_get_log(fallback_problem,
                                                        fallback_targetTypeArgsStr,
                                                        fallback_targetTypeArgs).put_log(fallback_problem,
                                                                                         this,
                                                                                         this.lowerBound);
            ThresholdBasedPolicy.upperBound_old_get_log(fallback_problem,
                                                        fallback_targetTypeArgsStr,
                                                        fallback_targetTypeArgs).put_log(fallback_problem,
                                                                                         this,
                                                                                         this.upperBound);
            ThresholdBasedPolicy.multiplier_old_get_log(fallback_problem,
                                                        fallback_targetTypeArgsStr,
                                                        fallback_targetTypeArgs).put_log(fallback_problem,
                                                                                         this,
                                                                                         this.multiplier);
            ThresholdBasedPolicy.MAX_INT_old_get_log(fallback_problem,
                                                     fallback_targetTypeArgsStr,
                                                     fallback_targetTypeArgs).put_log(fallback_problem,
                                                                                      this,
                                                                                      this.MAX_INT);
        }
    }
    
    public static void fallback_classAtomize(LogProblem fallback_problem,
                                             String fallback_targetTypeArgsStr,
                                             String[] fallback_targetTypeArgs) {
        if (!isClassAtomized(fallback_problem)) {
            ThresholdBasedPolicy.classAtomizerStep =
              fallback_problem.relationizerStep();
        }
    }
    
    public static void fallback_classRelationizeOld(LogProblem fallback_problem,
                                                    String fallback_targetTypeArgsStr,
                                                    String[] fallback_targetTypeArgs) {
        if (!isClassRelationized(fallback_problem)) {
            ThresholdBasedPolicy.classRelationizerStep =
              fallback_problem.relationizerStep();
        }
    }
    
    public static void fallback_classClone() {
        if (isClassCloned())
            return;
    }
    
    public ThresholdBasedPolicy fallback_clone() {
        if (isCloned())
            return old;
        ThresholdBasedPolicy res =
          null;
        ThresholdBasedPolicy.fallback_classClone();
        try {
            res =
              (ThresholdBasedPolicy)
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
            res.roundup =
              this.roundup;
            res.lowerBound =
              this.lowerBound;
            res.upperBound =
              this.upperBound;
            res.multiplier =
              this.multiplier;
            res.MAX_INT =
              this.MAX_INT;
        }
        catch (Exception rte) {
            rte.printStackTrace();
            System.exit(1);
        }
        return res;
    }
    
    public static LogExpr roundup_get_log(LogProblem fallback_problem,
                                          LogExpr fallback_target,
                                          String fallback_targetTypeArgsStr,
                                          String[] fallback_targetTypeArgs,
                                          boolean isOld) {
        return LogMap.fieldGet_log(fallback_problem,
                                   fallback_target,
                                   "at.ac.testing.pbnj.test10.ThresholdBasedPolicy",
                                   fallback_targetTypeArgsStr,
                                   "roundup",
                                   isOld);
    }
    
    public static LogRelation roundup_old_get_log(LogProblem fallback_problem,
                                                  String fallback_targetTypeArgsStr,
                                                  String[] fallback_targetTypeArgs) {
        return LogMap.oldFieldGet_log(fallback_problem,
                                      "at.ac.testing.pbnj.test10.ThresholdBasedPolicy",
                                      fallback_targetTypeArgsStr,
                                      "roundup");
    }
    
    public int fallback_updateField_roundup(Integer newVal) {
        return this.roundup =
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
    
    public static LogExpr lowerBound_get_log(LogProblem fallback_problem,
                                             LogExpr fallback_target,
                                             String fallback_targetTypeArgsStr,
                                             String[] fallback_targetTypeArgs,
                                             boolean isOld) {
        return LogMap.fieldGet_log(fallback_problem,
                                   fallback_target,
                                   "at.ac.testing.pbnj.test10.ThresholdBasedPolicy",
                                   fallback_targetTypeArgsStr,
                                   "lowerBound",
                                   isOld);
    }
    
    public static LogRelation lowerBound_old_get_log(LogProblem fallback_problem,
                                                     String fallback_targetTypeArgsStr,
                                                     String[] fallback_targetTypeArgs) {
        return LogMap.oldFieldGet_log(fallback_problem,
                                      "at.ac.testing.pbnj.test10.ThresholdBasedPolicy",
                                      fallback_targetTypeArgsStr,
                                      "lowerBound");
    }
    
    public int fallback_updateField_lowerBound(Integer newVal) {
        return this.lowerBound =
          newVal;
    }
    
    public static LogExpr upperBound_get_log(LogProblem fallback_problem,
                                             LogExpr fallback_target,
                                             String fallback_targetTypeArgsStr,
                                             String[] fallback_targetTypeArgs,
                                             boolean isOld) {
        return LogMap.fieldGet_log(fallback_problem,
                                   fallback_target,
                                   "at.ac.testing.pbnj.test10.ThresholdBasedPolicy",
                                   fallback_targetTypeArgsStr,
                                   "upperBound",
                                   isOld);
    }
    
    public static LogRelation upperBound_old_get_log(LogProblem fallback_problem,
                                                     String fallback_targetTypeArgsStr,
                                                     String[] fallback_targetTypeArgs) {
        return LogMap.oldFieldGet_log(fallback_problem,
                                      "at.ac.testing.pbnj.test10.ThresholdBasedPolicy",
                                      fallback_targetTypeArgsStr,
                                      "upperBound");
    }
    
    public int fallback_updateField_upperBound(Integer newVal) {
        return this.upperBound =
          newVal;
    }
    
    public static LogExpr multiplier_get_log(LogProblem fallback_problem,
                                             LogExpr fallback_target,
                                             String fallback_targetTypeArgsStr,
                                             String[] fallback_targetTypeArgs,
                                             boolean isOld) {
        return LogMap.fieldGet_log(fallback_problem,
                                   fallback_target,
                                   "at.ac.testing.pbnj.test10.ThresholdBasedPolicy",
                                   fallback_targetTypeArgsStr,
                                   "multiplier",
                                   isOld);
    }
    
    public static LogRelation multiplier_old_get_log(LogProblem fallback_problem,
                                                     String fallback_targetTypeArgsStr,
                                                     String[] fallback_targetTypeArgs) {
        return LogMap.oldFieldGet_log(fallback_problem,
                                      "at.ac.testing.pbnj.test10.ThresholdBasedPolicy",
                                      fallback_targetTypeArgsStr,
                                      "multiplier");
    }
    
    public int fallback_updateField_multiplier(Integer newVal) {
        return this.multiplier =
          newVal;
    }
    
    public static LogExpr MAX_INT_get_log(LogProblem fallback_problem,
                                          LogExpr fallback_target,
                                          String fallback_targetTypeArgsStr,
                                          String[] fallback_targetTypeArgs,
                                          boolean isOld) {
        return LogMap.fieldGet_log(fallback_problem,
                                   fallback_target,
                                   "at.ac.testing.pbnj.test10.ThresholdBasedPolicy",
                                   fallback_targetTypeArgsStr,
                                   "MAX_INT",
                                   isOld);
    }
    
    public static LogRelation MAX_INT_old_get_log(LogProblem fallback_problem,
                                                  String fallback_targetTypeArgsStr,
                                                  String[] fallback_targetTypeArgs) {
        return LogMap.oldFieldGet_log(fallback_problem,
                                      "at.ac.testing.pbnj.test10.ThresholdBasedPolicy",
                                      fallback_targetTypeArgsStr,
                                      "MAX_INT");
    }
    
    public int fallback_updateField_MAX_INT(Integer newVal) {
        return this.MAX_INT =
          newVal;
    }
    
    public static LogExpr fallback_field_result_resizeH_int_int_get_log(LogProblem fallback_problem,
                                                                        LogExpr fallback_target,
                                                                        String fallback_targetTypeArgsStr,
                                                                        String[] fallback_targetTypeArgs,
                                                                        boolean isOld) {
        return LogMap.resultGet_log(fallback_problem,
                                    fallback_target,
                                    "at.ac.testing.pbnj.test10.ThresholdBasedPolicy",
                                    fallback_targetTypeArgsStr,
                                    "fallback_field_result_resizeH_int_int");
    }
    
    PBJInternSet<Integer> getCommonDivisors_setComprehension_0(int a,
                                                               int b) {
        PBJInternSet<Integer> res =
          new PBJInternSet<Integer>();
        for (int gcd : PBJInternInteger.range(1,
                                              max(a,
                                                  b))) {
            if (a /
                  gcd *
                  gcd ==
                  a &&
                  b /
                    gcd *
                    gcd ==
                    b)
                res.add(gcd);
        }
        return res;
    }
    
    PBJInternSet<Integer> validMultipliers_setComprehension_1(int currentSize,
                                                              int targetSize) {
        PBJInternSet<Integer> res =
          new PBJInternSet<Integer>();
        for (int cd : getCommonDivisors(lowerBound,
                                        upperBound)) {
            if (currentSize >
                  targetSize &&
                  roundUp(this.lowerBound /
                            cd *
                            (targetSize +
                               1),
                          currentSize) !=
                    roundUp(this.lowerBound /
                              cd *
                              targetSize,
                            currentSize) ||
                  currentSize <
                    targetSize &&
                    (currentSize >
                       0 &&
                       this.lowerBound /
                         cd *
                         (targetSize +
                            1) /
                         currentSize <
                         this.MAX_INT ||
                       currentSize ==
                         0 &&
                         this.lowerBound /
                           cd *
                           (targetSize +
                              1) <
                           this.MAX_INT) ||
                  currentSize ==
                    targetSize)
                res.add(cd);
        }
        return res;
    }
    
    PBJInternSet<Integer> getBiggestValidMultiplier_setComprehension_3(int currentSize,
                                                                       int targetSize) {
        PBJInternSet<Integer> res =
          new PBJInternSet<Integer>();
        for (int m : validMultipliers(currentSize,
                                      targetSize)) {
            if (getBiggestValidMultiplier_univQuantify_2(currentSize,
                                                         targetSize,
                                                         m))
                res.add(m);
        }
        return res;
    }
    
    boolean getBiggestValidMultiplier_univQuantify_2(int currentSize,
                                                     int targetSize,
                                                     int m) {
        for (int mm : validMultipliers(currentSize,
                                       targetSize)) {
            if (!(!(m !=
                      mm &&
                      mm >
                        m)))
                return false;
        }
        return true;
    }
    
    PBJInternSet<Integer> getAllResize_setComprehension_4(int currentSize,
                                                          int targetSize) {
        PBJInternSet<Integer> res =
          new PBJInternSet<Integer>();
        for (int value : PBJInternInteger.range(0,
                                                MAX_INT)) {
            if (targetSize >
                  currentSize &&
                  scalesUpTest(value,
                               currentSize,
                               targetSize) ||
                  targetSize <
                    currentSize &&
                    scalesDownTest(value,
                                   currentSize,
                                   targetSize) ||
                  targetSize ==
                    currentSize &&
                    staysTest(value,
                              currentSize,
                              targetSize))
                res.add(value);
        }
        return res;
    }
    
    PBJInternSet<Integer> getTheResize_setComprehension_5(int currentSize,
                                                          int targetSize) {
        PBJInternSet<Integer> res =
          new PBJInternSet<Integer>();
        for (int value : PBJInternInteger.range(0,
                                                MAX_INT)) {
            if (targetSize >
                  currentSize &&
                  scalesUpTest(value,
                               currentSize,
                               targetSize) ||
                  targetSize <
                    currentSize &&
                    scalesDownTest(value,
                                   currentSize,
                                   targetSize) ||
                  targetSize ==
                    currentSize &&
                    staysTest(value,
                              currentSize,
                              targetSize))
                res.add(value);
        }
        return res;
    }
    
    public static PBJInternSet<Integer> setMap_roundup(PBJInternSet<ThresholdBasedPolicy> objs,
                                                       java.lang.String ... fieldNs) {
        PBJInternSet<Integer> res =
          new PBJInternSet<Integer>();
        java.util.Iterator<ThresholdBasedPolicy> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().roundup);
        }
        return res;
    }
    
    public static PBJInternSet<Integer> setMap_lowerBound(PBJInternSet<ThresholdBasedPolicy> objs,
                                                          java.lang.String ... fieldNs) {
        PBJInternSet<Integer> res =
          new PBJInternSet<Integer>();
        java.util.Iterator<ThresholdBasedPolicy> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().lowerBound);
        }
        return res;
    }
    
    public static PBJInternSet<Integer> setMap_upperBound(PBJInternSet<ThresholdBasedPolicy> objs,
                                                          java.lang.String ... fieldNs) {
        PBJInternSet<Integer> res =
          new PBJInternSet<Integer>();
        java.util.Iterator<ThresholdBasedPolicy> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().upperBound);
        }
        return res;
    }
    
    public static PBJInternSet<Integer> setMap_multiplier(PBJInternSet<ThresholdBasedPolicy> objs,
                                                          java.lang.String ... fieldNs) {
        PBJInternSet<Integer> res =
          new PBJInternSet<Integer>();
        java.util.Iterator<ThresholdBasedPolicy> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().multiplier);
        }
        return res;
    }
    
    public static PBJInternSet<Integer> setMap_MAX_INT(PBJInternSet<ThresholdBasedPolicy> objs,
                                                       java.lang.String ... fieldNs) {
        PBJInternSet<Integer> res =
          new PBJInternSet<Integer>();
        java.util.Iterator<ThresholdBasedPolicy> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().MAX_INT);
        }
        return res;
    }
    
    public static void fallback_initClassDefs() {
        
    }
    
    static {
               LogMap.newClassForLog(ThresholdBasedPolicy.class,
                                     true);
               LogMap.newInstVarRel("roundup",
                                    ThresholdBasedPolicy.class,
                                    "at.ac.testing.pbnj.test10.ThresholdBasedPolicy",
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
               LogMap.newInstVarRel("lowerBound",
                                    ThresholdBasedPolicy.class,
                                    "at.ac.testing.pbnj.test10.ThresholdBasedPolicy",
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
               LogMap.newInstVarRel("upperBound",
                                    ThresholdBasedPolicy.class,
                                    "at.ac.testing.pbnj.test10.ThresholdBasedPolicy",
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
               LogMap.newInstVarRel("multiplier",
                                    ThresholdBasedPolicy.class,
                                    "at.ac.testing.pbnj.test10.ThresholdBasedPolicy",
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
               LogMap.newInstVarRel("MAX_INT",
                                    ThresholdBasedPolicy.class,
                                    "at.ac.testing.pbnj.test10.ThresholdBasedPolicy",
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
               LogMap.newInstVarRel("fallback_field_result_resizeH_int_int",
                                    ThresholdBasedPolicy.class,
                                    "at.ac.testing.pbnj.test10.ThresholdBasedPolicy",
                                    SensorReading.class,
                                    "at.ac.testing.pbnj.test10.SensorReading",
                                    null,
                                    null,
                                    false,
                                    false,
                                    0,
                                    true,
                                    true,
                                    true,
                                    false,
                                    false);
           }
    
    static LogExpr valid_log(LogProblem fallback_problem,
                             LogExpr fallback_target,
                             String fallback_targetTypeArgsStr,
                             String[] fallback_targetTypeArgs,
                             boolean fallback_target_isOld) {
        return new LogExpr(fallback_problem,
                           kodkod.ast.Formula.TRUE).and(ThresholdBasedPolicy.lowerBound_get_log(fallback_problem,
                                                                                                fallback_target,
                                                                                                fallback_targetTypeArgsStr,
                                                                                                fallback_targetTypeArgs,
                                                                                                fallback_target_isOld).gte(new LogExpr(fallback_problem,
                                                                                                                                       kodkod.ast.IntConstant.constant(0)))).and(ThresholdBasedPolicy.upperBound_get_log(fallback_problem,
                                                                                                                                                                                                                         fallback_target,
                                                                                                                                                                                                                         fallback_targetTypeArgsStr,
                                                                                                                                                                                                                         fallback_targetTypeArgs,
                                                                                                                                                                                                                         fallback_target_isOld).gte(ThresholdBasedPolicy.lowerBound_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                            fallback_target,
                                                                                                                                                                                                                                                                                            fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                            fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                            fallback_target_isOld)));
    }
    
    static LogExpr abs_log(LogProblem fallback_problem,
                           LogExpr fallback_target,
                           String fallback_targetTypeArgsStr,
                           String[] fallback_targetTypeArgs,
                           boolean fallback_target_isOld,
                           LogExpr i,
                           boolean i_isOld) {
        return i.lt(new LogExpr(fallback_problem,
                                kodkod.ast.IntConstant.constant(0))).thenElse(i.negate(),
                                                                              i);
    }
    
    static LogExpr max_log(LogProblem fallback_problem,
                           LogExpr fallback_target,
                           String fallback_targetTypeArgsStr,
                           String[] fallback_targetTypeArgs,
                           boolean fallback_target_isOld,
                           LogExpr i,
                           boolean i_isOld,
                           LogExpr j,
                           boolean j_isOld) {
        return i.gte(j).thenElse(i,
                                 j);
    }
    
    static LogExpr getCommonDivisors_log(LogProblem fallback_problem,
                                         LogExpr fallback_target,
                                         String fallback_targetTypeArgsStr,
                                         String[] fallback_targetTypeArgs,
                                         boolean fallback_target_isOld,
                                         LogExpr a,
                                         boolean a_isOld,
                                         LogExpr b,
                                         boolean b_isOld) {
        boolean gcd_isOld =
          false;
        LogExpr quantVar_gcd =
          new LogExpr(fallback_problem,
                      kodkod.ast.Variable.unary("gcd"));
        LogExpr gcd =
          new LogExpr(fallback_problem,
                      quantVar_gcd.expr());
        LogExpr fallback_var_gcd =
          quantVar_gcd;
        return LogExpr.setComprehensionOp(PBJInternSet.toPBJInternSet_log(fallback_problem,
                                                                          PBJInternInteger.range_log(fallback_problem,
                                                                                                     fallback_problem.class_log(PBJInternInteger.class),
                                                                                                     "",
                                                                                                     null,
                                                                                                     fallback_target_isOld,
                                                                                                     new LogExpr(fallback_problem,
                                                                                                                 kodkod.ast.IntConstant.constant(1)),
                                                                                                     fallback_target_isOld,
                                                                                                     ThresholdBasedPolicy.max_log(fallback_problem,
                                                                                                                                  fallback_target,
                                                                                                                                  fallback_targetTypeArgsStr,
                                                                                                                                  fallback_targetTypeArgs,
                                                                                                                                  fallback_target_isOld,
                                                                                                                                  a,
                                                                                                                                  a_isOld,
                                                                                                                                  b,
                                                                                                                                  b_isOld),
                                                                                                     fallback_target_isOld),
                                                                          "<java.lang.Integer>",
                                                                          new String[] { "java.lang.Integer" },
                                                                          fallback_target_isOld),
                                          fallback_var_gcd,
                                          a.divide(gcd).multiply(gcd).eq(a).and(b.divide(gcd).multiply(gcd).eq(b)));
    }
    
    static LogExpr validMultipliers_log(LogProblem fallback_problem,
                                        LogExpr fallback_target,
                                        String fallback_targetTypeArgsStr,
                                        String[] fallback_targetTypeArgs,
                                        boolean fallback_target_isOld,
                                        LogExpr currentSize,
                                        boolean currentSize_isOld,
                                        LogExpr targetSize,
                                        boolean targetSize_isOld) {
        boolean cd_isOld =
          false;
        LogExpr quantVar_cd =
          new LogExpr(fallback_problem,
                      kodkod.ast.Variable.unary("cd"));
        LogExpr cd =
          new LogExpr(fallback_problem,
                      quantVar_cd.expr());
        LogExpr fallback_var_cd =
          quantVar_cd;
        return LogExpr.setComprehensionOp(PBJInternSet.toPBJInternSet_log(fallback_problem,
                                                                          ThresholdBasedPolicy.getCommonDivisors_log(fallback_problem,
                                                                                                                     fallback_target,
                                                                                                                     fallback_targetTypeArgsStr,
                                                                                                                     fallback_targetTypeArgs,
                                                                                                                     fallback_target_isOld,
                                                                                                                     ThresholdBasedPolicy.lowerBound_get_log(fallback_problem,
                                                                                                                                                             fallback_target,
                                                                                                                                                             fallback_targetTypeArgsStr,
                                                                                                                                                             fallback_targetTypeArgs,
                                                                                                                                                             fallback_target_isOld),
                                                                                                                     fallback_target_isOld,
                                                                                                                     ThresholdBasedPolicy.upperBound_get_log(fallback_problem,
                                                                                                                                                             fallback_target,
                                                                                                                                                             fallback_targetTypeArgsStr,
                                                                                                                                                             fallback_targetTypeArgs,
                                                                                                                                                             fallback_target_isOld),
                                                                                                                     fallback_target_isOld),
                                                                          "<java.lang.Integer>",
                                                                          new String[] { "java.lang.Integer" },
                                                                          fallback_target_isOld),
                                          fallback_var_cd,
                                          currentSize.gt(targetSize).and(ThresholdBasedPolicy.roundUp_log(fallback_problem,
                                                                                                          fallback_target,
                                                                                                          fallback_targetTypeArgsStr,
                                                                                                          fallback_targetTypeArgs,
                                                                                                          fallback_target_isOld,
                                                                                                          ThresholdBasedPolicy.lowerBound_get_log(fallback_problem,
                                                                                                                                                  fallback_target,
                                                                                                                                                  fallback_targetTypeArgsStr,
                                                                                                                                                  fallback_targetTypeArgs,
                                                                                                                                                  fallback_target_isOld).divide(cd).multiply(targetSize.plus(new LogExpr(fallback_problem,
                                                                                                                                                                                                                         kodkod.ast.IntConstant.constant(1)))),
                                                                                                          fallback_target_isOld,
                                                                                                          currentSize,
                                                                                                          currentSize_isOld).eq(ThresholdBasedPolicy.roundUp_log(fallback_problem,
                                                                                                                                                                 fallback_target,
                                                                                                                                                                 fallback_targetTypeArgsStr,
                                                                                                                                                                 fallback_targetTypeArgs,
                                                                                                                                                                 fallback_target_isOld,
                                                                                                                                                                 ThresholdBasedPolicy.lowerBound_get_log(fallback_problem,
                                                                                                                                                                                                         fallback_target,
                                                                                                                                                                                                         fallback_targetTypeArgsStr,
                                                                                                                                                                                                         fallback_targetTypeArgs,
                                                                                                                                                                                                         fallback_target_isOld).divide(cd).multiply(targetSize),
                                                                                                                                                                 fallback_target_isOld,
                                                                                                                                                                 currentSize,
                                                                                                                                                                 currentSize_isOld)).not()).or(currentSize.lt(targetSize).and(currentSize.gt(new LogExpr(fallback_problem,
                                                                                                                                                                                                                                                         kodkod.ast.IntConstant.constant(0))).and(ThresholdBasedPolicy.lowerBound_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                          fallback_target,
                                                                                                                                                                                                                                                                                                                                          fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                          fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                          fallback_target_isOld).divide(cd).multiply(targetSize.plus(new LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                 kodkod.ast.IntConstant.constant(1)))).divide(currentSize).lt(ThresholdBasedPolicy.MAX_INT_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   fallback_target_isOld))).or(currentSize.eq(new LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          kodkod.ast.IntConstant.constant(0))).and(ThresholdBasedPolicy.lowerBound_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           fallback_target_isOld).divide(cd).multiply(targetSize.plus(new LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  kodkod.ast.IntConstant.constant(1)))).lt(ThresholdBasedPolicy.MAX_INT_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                fallback_target_isOld)))))).or(currentSize.eq(targetSize)));
    }
    
    static LogExpr getBiggestValidMultiplier_log(LogProblem fallback_problem,
                                                 LogExpr fallback_target,
                                                 String fallback_targetTypeArgsStr,
                                                 String[] fallback_targetTypeArgs,
                                                 boolean fallback_target_isOld,
                                                 LogExpr currentSize,
                                                 boolean currentSize_isOld,
                                                 LogExpr targetSize,
                                                 boolean targetSize_isOld) {
        boolean m_isOld =
          false;
        LogExpr quantVar_m =
          new LogExpr(fallback_problem,
                      kodkod.ast.Variable.unary("m"));
        LogExpr m =
          new LogExpr(fallback_problem,
                      quantVar_m.expr());
        LogExpr fallback_var_m =
          quantVar_m;
        boolean mm_isOld =
          false;
        LogExpr quantVar_mm =
          new LogExpr(fallback_problem,
                      kodkod.ast.Variable.unary("mm"));
        LogExpr mm =
          new LogExpr(fallback_problem,
                      quantVar_mm.expr());
        LogExpr fallback_var_mm =
          quantVar_mm;
        return LogExpr.setComprehensionOp(PBJInternSet.toPBJInternSet_log(fallback_problem,
                                                                          ThresholdBasedPolicy.validMultipliers_log(fallback_problem,
                                                                                                                    fallback_target,
                                                                                                                    fallback_targetTypeArgsStr,
                                                                                                                    fallback_targetTypeArgs,
                                                                                                                    fallback_target_isOld,
                                                                                                                    currentSize,
                                                                                                                    currentSize_isOld,
                                                                                                                    targetSize,
                                                                                                                    targetSize_isOld),
                                                                          "<java.lang.Integer>",
                                                                          new String[] { "java.lang.Integer" },
                                                                          fallback_target_isOld),
                                          fallback_var_m,
                                          LogExpr.quantifyOp(PBJInternSet.toPBJInternSet_log(fallback_problem,
                                                                                             ThresholdBasedPolicy.validMultipliers_log(fallback_problem,
                                                                                                                                       fallback_target,
                                                                                                                                       fallback_targetTypeArgsStr,
                                                                                                                                       fallback_targetTypeArgs,
                                                                                                                                       fallback_target_isOld,
                                                                                                                                       currentSize,
                                                                                                                                       currentSize_isOld,
                                                                                                                                       targetSize,
                                                                                                                                       targetSize_isOld),
                                                                                             "<java.lang.Integer>",
                                                                                             new String[] { "java.lang.Integer" },
                                                                                             fallback_target_isOld),
                                                             false,
                                                             "all",
                                                             fallback_var_mm,
                                                             m.eq(mm).not().and(mm.gt(m)).not())).get_log(fallback_problem);
    }
    
    static LogExpr getAllResize_log(LogProblem fallback_problem,
                                    LogExpr fallback_target,
                                    String fallback_targetTypeArgsStr,
                                    String[] fallback_targetTypeArgs,
                                    boolean fallback_target_isOld,
                                    LogExpr currentSize,
                                    boolean currentSize_isOld,
                                    LogExpr targetSize,
                                    boolean targetSize_isOld) {
        boolean value_isOld =
          false;
        LogExpr quantVar_value =
          new LogExpr(fallback_problem,
                      kodkod.ast.Variable.unary("value"));
        LogExpr value =
          new LogExpr(fallback_problem,
                      quantVar_value.expr());
        LogExpr fallback_var_value =
          quantVar_value;
        return LogExpr.setComprehensionOp(PBJInternSet.toPBJInternSet_log(fallback_problem,
                                                                          PBJInternInteger.range_log(fallback_problem,
                                                                                                     fallback_problem.class_log(PBJInternInteger.class),
                                                                                                     "",
                                                                                                     null,
                                                                                                     fallback_target_isOld,
                                                                                                     new LogExpr(fallback_problem,
                                                                                                                 kodkod.ast.IntConstant.constant(0)),
                                                                                                     fallback_target_isOld,
                                                                                                     ThresholdBasedPolicy.MAX_INT_get_log(fallback_problem,
                                                                                                                                          fallback_target,
                                                                                                                                          fallback_targetTypeArgsStr,
                                                                                                                                          fallback_targetTypeArgs,
                                                                                                                                          fallback_target_isOld),
                                                                                                     fallback_target_isOld),
                                                                          "<java.lang.Integer>",
                                                                          new String[] { "java.lang.Integer" },
                                                                          fallback_target_isOld),
                                          fallback_var_value,
                                          targetSize.gt(currentSize).and(ThresholdBasedPolicy.scalesUpTest_log(fallback_problem,
                                                                                                               fallback_target,
                                                                                                               fallback_targetTypeArgsStr,
                                                                                                               fallback_targetTypeArgs,
                                                                                                               fallback_target_isOld,
                                                                                                               value,
                                                                                                               value_isOld,
                                                                                                               currentSize,
                                                                                                               currentSize_isOld,
                                                                                                               targetSize,
                                                                                                               targetSize_isOld)).or(targetSize.lt(currentSize).and(ThresholdBasedPolicy.scalesDownTest_log(fallback_problem,
                                                                                                                                                                                                            fallback_target,
                                                                                                                                                                                                            fallback_targetTypeArgsStr,
                                                                                                                                                                                                            fallback_targetTypeArgs,
                                                                                                                                                                                                            fallback_target_isOld,
                                                                                                                                                                                                            value,
                                                                                                                                                                                                            value_isOld,
                                                                                                                                                                                                            currentSize,
                                                                                                                                                                                                            currentSize_isOld,
                                                                                                                                                                                                            targetSize,
                                                                                                                                                                                                            targetSize_isOld))).or(targetSize.eq(currentSize).and(ThresholdBasedPolicy.staysTest_log(fallback_problem,
                                                                                                                                                                                                                                                                                                     fallback_target,
                                                                                                                                                                                                                                                                                                     fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                     fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                     fallback_target_isOld,
                                                                                                                                                                                                                                                                                                     value,
                                                                                                                                                                                                                                                                                                     value_isOld,
                                                                                                                                                                                                                                                                                                     currentSize,
                                                                                                                                                                                                                                                                                                     currentSize_isOld,
                                                                                                                                                                                                                                                                                                     targetSize,
                                                                                                                                                                                                                                                                                                     targetSize_isOld))));
    }
    
    static LogExpr getTheResize_log(LogProblem fallback_problem,
                                    LogExpr fallback_target,
                                    String fallback_targetTypeArgsStr,
                                    String[] fallback_targetTypeArgs,
                                    boolean fallback_target_isOld,
                                    LogExpr currentSize,
                                    boolean currentSize_isOld,
                                    LogExpr targetSize,
                                    boolean targetSize_isOld) {
        boolean value_isOld =
          false;
        LogExpr quantVar_value =
          new LogExpr(fallback_problem,
                      kodkod.ast.Variable.unary("value"));
        LogExpr value =
          new LogExpr(fallback_problem,
                      quantVar_value.expr());
        LogExpr fallback_var_value =
          quantVar_value;
        return LogExpr.setComprehensionOp(PBJInternSet.toPBJInternSet_log(fallback_problem,
                                                                          PBJInternInteger.range_log(fallback_problem,
                                                                                                     fallback_problem.class_log(PBJInternInteger.class),
                                                                                                     "",
                                                                                                     null,
                                                                                                     fallback_target_isOld,
                                                                                                     new LogExpr(fallback_problem,
                                                                                                                 kodkod.ast.IntConstant.constant(0)),
                                                                                                     fallback_target_isOld,
                                                                                                     ThresholdBasedPolicy.MAX_INT_get_log(fallback_problem,
                                                                                                                                          fallback_target,
                                                                                                                                          fallback_targetTypeArgsStr,
                                                                                                                                          fallback_targetTypeArgs,
                                                                                                                                          fallback_target_isOld),
                                                                                                     fallback_target_isOld),
                                                                          "<java.lang.Integer>",
                                                                          new String[] { "java.lang.Integer" },
                                                                          fallback_target_isOld),
                                          fallback_var_value,
                                          targetSize.gt(currentSize).and(ThresholdBasedPolicy.scalesUpTest_log(fallback_problem,
                                                                                                               fallback_target,
                                                                                                               fallback_targetTypeArgsStr,
                                                                                                               fallback_targetTypeArgs,
                                                                                                               fallback_target_isOld,
                                                                                                               value,
                                                                                                               value_isOld,
                                                                                                               currentSize,
                                                                                                               currentSize_isOld,
                                                                                                               targetSize,
                                                                                                               targetSize_isOld)).or(targetSize.lt(currentSize).and(ThresholdBasedPolicy.scalesDownTest_log(fallback_problem,
                                                                                                                                                                                                            fallback_target,
                                                                                                                                                                                                            fallback_targetTypeArgsStr,
                                                                                                                                                                                                            fallback_targetTypeArgs,
                                                                                                                                                                                                            fallback_target_isOld,
                                                                                                                                                                                                            value,
                                                                                                                                                                                                            value_isOld,
                                                                                                                                                                                                            currentSize,
                                                                                                                                                                                                            currentSize_isOld,
                                                                                                                                                                                                            targetSize,
                                                                                                                                                                                                            targetSize_isOld))).or(targetSize.eq(currentSize).and(ThresholdBasedPolicy.staysTest_log(fallback_problem,
                                                                                                                                                                                                                                                                                                     fallback_target,
                                                                                                                                                                                                                                                                                                     fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                     fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                     fallback_target_isOld,
                                                                                                                                                                                                                                                                                                     value,
                                                                                                                                                                                                                                                                                                     value_isOld,
                                                                                                                                                                                                                                                                                                     currentSize,
                                                                                                                                                                                                                                                                                                     currentSize_isOld,
                                                                                                                                                                                                                                                                                                     targetSize,
                                                                                                                                                                                                                                                                                                     targetSize_isOld)))).get_log(fallback_problem);
    }
    
    public static LogExpr scalesUpTest_log(LogProblem fallback_problem,
                                           LogExpr fallback_target,
                                           String fallback_targetTypeArgsStr,
                                           String[] fallback_targetTypeArgs,
                                           boolean fallback_target_isOld,
                                           LogExpr value,
                                           boolean value_isOld,
                                           LogExpr currentSize,
                                           boolean currentSize_isOld,
                                           LogExpr targetSize,
                                           boolean targetSize_isOld) {
        LogExpr scaledUpperBound =
          ThresholdBasedPolicy.upperBound_get_log(fallback_problem,
                                                  fallback_target,
                                                  fallback_targetTypeArgsStr,
                                                  fallback_targetTypeArgs,
                                                  fallback_target_isOld).divide(ThresholdBasedPolicy.multiplier_get_log(fallback_problem,
                                                                                                                        fallback_target,
                                                                                                                        fallback_targetTypeArgsStr,
                                                                                                                        fallback_targetTypeArgs,
                                                                                                                        fallback_target_isOld));
        boolean scaledUpperBound_isOld =
          false;
        LogExpr scaledLowerBound =
          ThresholdBasedPolicy.lowerBound_get_log(fallback_problem,
                                                  fallback_target,
                                                  fallback_targetTypeArgsStr,
                                                  fallback_targetTypeArgs,
                                                  fallback_target_isOld).divide(ThresholdBasedPolicy.multiplier_get_log(fallback_problem,
                                                                                                                        fallback_target,
                                                                                                                        fallback_targetTypeArgsStr,
                                                                                                                        fallback_targetTypeArgs,
                                                                                                                        fallback_target_isOld));
        boolean scaledLowerBound_isOld =
          false;
        return currentSize.gt(new LogExpr(fallback_problem,
                                          kodkod.ast.IntConstant.constant(0))).and(value.gt(scaledUpperBound)).and(value.lte(scaledUpperBound.multiply(targetSize).divide(currentSize))).and(scaledUpperBound.multiply(targetSize).lt(targetSize.plus(new LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                  kodkod.ast.IntConstant.constant(1))).multiply(scaledLowerBound)).implies(value.lt(targetSize.plus(new LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                kodkod.ast.IntConstant.constant(1))).multiply(scaledLowerBound).divide(currentSize)))).and(scaledUpperBound.multiply(targetSize).gte(targetSize.plus(new LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 kodkod.ast.IntConstant.constant(1))).multiply(scaledLowerBound)).implies(value.gt(scaledUpperBound.multiply(targetSize.minus(new LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          kodkod.ast.IntConstant.constant(1)))).divide(currentSize)))).or(currentSize.eq(new LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     kodkod.ast.IntConstant.constant(0))).and(value.gt(new LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   kodkod.ast.IntConstant.constant(0)))).and(value.lte(scaledUpperBound.multiply(targetSize))).and(scaledUpperBound.multiply(targetSize).lt(targetSize.plus(new LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        kodkod.ast.IntConstant.constant(1))).multiply(scaledLowerBound)).implies(value.lt(targetSize.plus(new LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      kodkod.ast.IntConstant.constant(1))).multiply(scaledLowerBound)))).and(scaledUpperBound.multiply(targetSize).gte(targetSize.plus(new LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   kodkod.ast.IntConstant.constant(1))).multiply(scaledLowerBound)).implies(value.gt(scaledUpperBound.multiply(targetSize.minus(new LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            kodkod.ast.IntConstant.constant(1))))))));
    }
    
    public static LogExpr scalesDownTest_log(LogProblem fallback_problem,
                                             LogExpr fallback_target,
                                             String fallback_targetTypeArgsStr,
                                             String[] fallback_targetTypeArgs,
                                             boolean fallback_target_isOld,
                                             LogExpr value,
                                             boolean value_isOld,
                                             LogExpr currentSize,
                                             boolean currentSize_isOld,
                                             LogExpr targetSize,
                                             boolean targetSize_isOld) {
        LogExpr nextBiggerSize =
          targetSize.plus(new LogExpr(fallback_problem,
                                      kodkod.ast.IntConstant.constant(1)));
        boolean nextBiggerSize_isOld =
          false;
        LogExpr nextSmaller =
          targetSize.minus(new LogExpr(fallback_problem,
                                       kodkod.ast.IntConstant.constant(1)));
        boolean nextSmaller_isOld =
          false;
        LogExpr scaledUpperBound =
          ThresholdBasedPolicy.upperBound_get_log(fallback_problem,
                                                  fallback_target,
                                                  fallback_targetTypeArgsStr,
                                                  fallback_targetTypeArgs,
                                                  fallback_target_isOld).divide(ThresholdBasedPolicy.multiplier_get_log(fallback_problem,
                                                                                                                        fallback_target,
                                                                                                                        fallback_targetTypeArgsStr,
                                                                                                                        fallback_targetTypeArgs,
                                                                                                                        fallback_target_isOld));
        boolean scaledUpperBound_isOld =
          false;
        LogExpr scaledLowerBound =
          ThresholdBasedPolicy.lowerBound_get_log(fallback_problem,
                                                  fallback_target,
                                                  fallback_targetTypeArgsStr,
                                                  fallback_targetTypeArgs,
                                                  fallback_target_isOld).divide(ThresholdBasedPolicy.multiplier_get_log(fallback_problem,
                                                                                                                        fallback_target,
                                                                                                                        fallback_targetTypeArgsStr,
                                                                                                                        fallback_targetTypeArgs,
                                                                                                                        fallback_target_isOld));
        boolean scaledLowerBound_isOld =
          false;
        return value.lt(scaledLowerBound).and(scaledUpperBound.gte(scaledLowerBound.multiply(targetSize).divide(nextSmaller)).and(value.gte(ThresholdBasedPolicy.roundUp_log(fallback_problem,
                                                                                                                                                                             fallback_target,
                                                                                                                                                                             fallback_targetTypeArgsStr,
                                                                                                                                                                             fallback_targetTypeArgs,
                                                                                                                                                                             fallback_target_isOld,
                                                                                                                                                                             scaledLowerBound.multiply(targetSize),
                                                                                                                                                                             fallback_target_isOld,
                                                                                                                                                                             currentSize,
                                                                                                                                                                             currentSize_isOld))).or(scaledUpperBound.lt(scaledLowerBound.multiply(targetSize).divide(nextSmaller)).and(currentSize.gte(scaledUpperBound.multiply(nextSmaller).divide(value))).and(currentSize.gt(scaledLowerBound.multiply(nextSmaller).divide(value))))).and(ThresholdBasedPolicy.lowerBound_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       fallback_target_isOld).lte(ThresholdBasedPolicy.upperBound_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          fallback_target_isOld).multiply(targetSize).divide(nextBiggerSize)).implies(value.lt(ThresholdBasedPolicy.roundUp_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                fallback_target_isOld,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                nextBiggerSize.multiply(scaledLowerBound),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                fallback_target_isOld,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                currentSize,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                currentSize_isOld))).and(ThresholdBasedPolicy.lowerBound_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 fallback_target_isOld).gt(ThresholdBasedPolicy.upperBound_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   fallback_target_isOld).multiply(targetSize).divide(nextBiggerSize)).implies(value.lte(scaledUpperBound.divide(currentSize).multiply(targetSize)))));
    }
    
    public static LogExpr staysTest_log(LogProblem fallback_problem,
                                        LogExpr fallback_target,
                                        String fallback_targetTypeArgsStr,
                                        String[] fallback_targetTypeArgs,
                                        boolean fallback_target_isOld,
                                        LogExpr value,
                                        boolean value_isOld,
                                        LogExpr currentSize,
                                        boolean currentSize_isOld,
                                        LogExpr targetSize,
                                        boolean targetSize_isOld) {
        LogExpr scaledUpperBound =
          ThresholdBasedPolicy.upperBound_get_log(fallback_problem,
                                                  fallback_target,
                                                  fallback_targetTypeArgsStr,
                                                  fallback_targetTypeArgs,
                                                  fallback_target_isOld).divide(ThresholdBasedPolicy.multiplier_get_log(fallback_problem,
                                                                                                                        fallback_target,
                                                                                                                        fallback_targetTypeArgsStr,
                                                                                                                        fallback_targetTypeArgs,
                                                                                                                        fallback_target_isOld));
        boolean scaledUpperBound_isOld =
          false;
        LogExpr scaledLowerBound =
          ThresholdBasedPolicy.lowerBound_get_log(fallback_problem,
                                                  fallback_target,
                                                  fallback_targetTypeArgsStr,
                                                  fallback_targetTypeArgs,
                                                  fallback_target_isOld).divide(ThresholdBasedPolicy.multiplier_get_log(fallback_problem,
                                                                                                                        fallback_target,
                                                                                                                        fallback_targetTypeArgsStr,
                                                                                                                        fallback_targetTypeArgs,
                                                                                                                        fallback_target_isOld));
        boolean scaledLowerBound_isOld =
          false;
        return currentSize.gt(new LogExpr(fallback_problem,
                                          kodkod.ast.IntConstant.constant(0))).and(value.lte(scaledUpperBound.multiply(currentSize).divide(currentSize))).and(currentSize.minus(new LogExpr(fallback_problem,
                                                                                                                                                                                            kodkod.ast.IntConstant.constant(1))).multiply(scaledUpperBound).lte(currentSize.multiply(scaledLowerBound)).implies(value.gt(currentSize.minus(new LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                       kodkod.ast.IntConstant.constant(1))).multiply(scaledUpperBound).divide(currentSize)))).and(currentSize.minus(new LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                kodkod.ast.IntConstant.constant(1))).multiply(scaledUpperBound).gt(currentSize.multiply(scaledLowerBound)).implies(value.gte(scaledLowerBound.multiply(currentSize).divide(currentSize)))).or(currentSize.eq(new LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         kodkod.ast.IntConstant.constant(0))).and(value.eq(new LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       kodkod.ast.IntConstant.constant(0)))));
    }
    
    static LogExpr roundUp_log(LogProblem fallback_problem,
                               LogExpr fallback_target,
                               String fallback_targetTypeArgsStr,
                               String[] fallback_targetTypeArgs,
                               boolean fallback_target_isOld,
                               LogExpr nom,
                               boolean nom_isOld,
                               LogExpr den,
                               boolean den_isOld) {
        return nom.divide(den).multiply(den).lt(nom).thenElse(nom.divide(den).plus(new LogExpr(fallback_problem,
                                                                                               kodkod.ast.IntConstant.constant(1))),
                                                              nom.divide(den));
    }
    
    public static LogExpr fullyContained_log(LogProblem fallback_problem,
                                             LogExpr fallback_target,
                                             String fallback_targetTypeArgsStr,
                                             String[] fallback_targetTypeArgs,
                                             boolean fallback_target_isOld,
                                             LogExpr sensorReading,
                                             boolean sensorReading_isOld,
                                             LogExpr currentSize,
                                             boolean currentSize_isOld,
                                             LogExpr targetSize,
                                             boolean targetSize_isOld) {
        LogExpr scaledUpperBound =
          ThresholdBasedPolicy.upperBound_get_log(fallback_problem,
                                                  fallback_target,
                                                  fallback_targetTypeArgsStr,
                                                  fallback_targetTypeArgs,
                                                  fallback_target_isOld).divide(ThresholdBasedPolicy.multiplier_get_log(fallback_problem,
                                                                                                                        fallback_target,
                                                                                                                        fallback_targetTypeArgsStr,
                                                                                                                        fallback_targetTypeArgs,
                                                                                                                        fallback_target_isOld));
        boolean scaledUpperBound_isOld =
          false;
        LogExpr scaledLowerBound =
          ThresholdBasedPolicy.lowerBound_get_log(fallback_problem,
                                                  fallback_target,
                                                  fallback_targetTypeArgsStr,
                                                  fallback_targetTypeArgs,
                                                  fallback_target_isOld).divide(ThresholdBasedPolicy.multiplier_get_log(fallback_problem,
                                                                                                                        fallback_target,
                                                                                                                        fallback_targetTypeArgsStr,
                                                                                                                        fallback_targetTypeArgs,
                                                                                                                        fallback_target_isOld));
        boolean scaledLowerBound_isOld =
          false;
        return new LogExpr(fallback_problem,
                           kodkod.ast.Formula.TRUE).and(SensorReading.value_get_log(fallback_problem,
                                                                                    sensorReading,
                                                                                    "",
                                                                                    null,
                                                                                    sensorReading_isOld).multiply(currentSize).gte(scaledLowerBound.multiply(targetSize))).and(SensorReading.value_get_log(fallback_problem,
                                                                                                                                                                                                           sensorReading,
                                                                                                                                                                                                           "",
                                                                                                                                                                                                           null,
                                                                                                                                                                                                           sensorReading_isOld).multiply(currentSize).lte(scaledUpperBound.multiply(targetSize)));
    }
    
    public static LogExpr scalesUp_log(LogProblem fallback_problem,
                                       LogExpr fallback_target,
                                       String fallback_targetTypeArgsStr,
                                       String[] fallback_targetTypeArgs,
                                       boolean fallback_target_isOld,
                                       LogExpr sensorReading,
                                       boolean sensorReading_isOld,
                                       LogExpr currentSize,
                                       boolean currentSize_isOld,
                                       LogExpr targetSize,
                                       boolean targetSize_isOld) {
        LogExpr scaledUpperBound =
          ThresholdBasedPolicy.upperBound_get_log(fallback_problem,
                                                  fallback_target,
                                                  fallback_targetTypeArgsStr,
                                                  fallback_targetTypeArgs,
                                                  fallback_target_isOld).divide(ThresholdBasedPolicy.multiplier_get_log(fallback_problem,
                                                                                                                        fallback_target,
                                                                                                                        fallback_targetTypeArgsStr,
                                                                                                                        fallback_targetTypeArgs,
                                                                                                                        fallback_target_isOld));
        boolean scaledUpperBound_isOld =
          false;
        LogExpr scaledLowerBound =
          ThresholdBasedPolicy.lowerBound_get_log(fallback_problem,
                                                  fallback_target,
                                                  fallback_targetTypeArgsStr,
                                                  fallback_targetTypeArgs,
                                                  fallback_target_isOld).divide(ThresholdBasedPolicy.multiplier_get_log(fallback_problem,
                                                                                                                        fallback_target,
                                                                                                                        fallback_targetTypeArgsStr,
                                                                                                                        fallback_targetTypeArgs,
                                                                                                                        fallback_target_isOld));
        boolean scaledLowerBound_isOld =
          false;
        return currentSize.gt(new LogExpr(fallback_problem,
                                          kodkod.ast.IntConstant.constant(0))).and(SensorReading.value_get_log(fallback_problem,
                                                                                                               sensorReading,
                                                                                                               "",
                                                                                                               null,
                                                                                                               sensorReading_isOld).gt(scaledUpperBound)).and(SensorReading.value_get_log(fallback_problem,
                                                                                                                                                                                          sensorReading,
                                                                                                                                                                                          "",
                                                                                                                                                                                          null,
                                                                                                                                                                                          sensorReading_isOld).lte(scaledUpperBound.multiply(targetSize).divide(currentSize))).and(scaledUpperBound.multiply(targetSize).lt(targetSize.plus(new LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                        kodkod.ast.IntConstant.constant(1))).multiply(scaledLowerBound)).implies(SensorReading.value_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                             sensorReading,
                                                                                                                                                                                                                                                                                                                                                                                                                                                             "",
                                                                                                                                                                                                                                                                                                                                                                                                                                                             null,
                                                                                                                                                                                                                                                                                                                                                                                                                                                             sensorReading_isOld).lt(targetSize.plus(new LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 kodkod.ast.IntConstant.constant(1))).multiply(scaledLowerBound).divide(currentSize)))).and(scaledUpperBound.multiply(targetSize).gte(targetSize.plus(new LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  kodkod.ast.IntConstant.constant(1))).multiply(scaledLowerBound)).implies(SensorReading.value_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       sensorReading,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       "",
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       null,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       sensorReading_isOld).gt(scaledUpperBound.multiply(targetSize.minus(new LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      kodkod.ast.IntConstant.constant(1)))).divide(currentSize)))).or(currentSize.eq(new LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 kodkod.ast.IntConstant.constant(0))).and(SensorReading.value_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      sensorReading,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      "",
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      null,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      sensorReading_isOld).gt(new LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          kodkod.ast.IntConstant.constant(0)))).and(SensorReading.value_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                sensorReading,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                "",
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                null,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                sensorReading_isOld).lte(scaledUpperBound.multiply(targetSize))).and(scaledUpperBound.multiply(targetSize).lt(targetSize.plus(new LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          kodkod.ast.IntConstant.constant(1))).multiply(scaledLowerBound)).implies(SensorReading.value_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               sensorReading,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               "",
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               null,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               sensorReading_isOld).lt(targetSize.plus(new LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   kodkod.ast.IntConstant.constant(1))).multiply(scaledLowerBound)))).and(scaledUpperBound.multiply(targetSize).gte(targetSize.plus(new LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                kodkod.ast.IntConstant.constant(1))).multiply(scaledLowerBound)).implies(SensorReading.value_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     sensorReading,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     "",
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     null,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     sensorReading_isOld).gt(scaledUpperBound.multiply(targetSize.minus(new LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    kodkod.ast.IntConstant.constant(1))))))));
    }
    
    public static LogExpr stays_log(LogProblem fallback_problem,
                                    LogExpr fallback_target,
                                    String fallback_targetTypeArgsStr,
                                    String[] fallback_targetTypeArgs,
                                    boolean fallback_target_isOld,
                                    LogExpr sensorReading,
                                    boolean sensorReading_isOld,
                                    LogExpr currentSize,
                                    boolean currentSize_isOld,
                                    LogExpr targetSize,
                                    boolean targetSize_isOld) {
        LogExpr scaledUpperBound =
          ThresholdBasedPolicy.upperBound_get_log(fallback_problem,
                                                  fallback_target,
                                                  fallback_targetTypeArgsStr,
                                                  fallback_targetTypeArgs,
                                                  fallback_target_isOld).divide(ThresholdBasedPolicy.multiplier_get_log(fallback_problem,
                                                                                                                        fallback_target,
                                                                                                                        fallback_targetTypeArgsStr,
                                                                                                                        fallback_targetTypeArgs,
                                                                                                                        fallback_target_isOld));
        boolean scaledUpperBound_isOld =
          false;
        LogExpr scaledLowerBound =
          ThresholdBasedPolicy.lowerBound_get_log(fallback_problem,
                                                  fallback_target,
                                                  fallback_targetTypeArgsStr,
                                                  fallback_targetTypeArgs,
                                                  fallback_target_isOld).divide(ThresholdBasedPolicy.multiplier_get_log(fallback_problem,
                                                                                                                        fallback_target,
                                                                                                                        fallback_targetTypeArgsStr,
                                                                                                                        fallback_targetTypeArgs,
                                                                                                                        fallback_target_isOld));
        boolean scaledLowerBound_isOld =
          false;
        return currentSize.gt(new LogExpr(fallback_problem,
                                          kodkod.ast.IntConstant.constant(0))).and(SensorReading.value_get_log(fallback_problem,
                                                                                                               sensorReading,
                                                                                                               "",
                                                                                                               null,
                                                                                                               sensorReading_isOld).lte(scaledUpperBound.multiply(currentSize).divide(currentSize))).and(currentSize.minus(new LogExpr(fallback_problem,
                                                                                                                                                                                                                                       kodkod.ast.IntConstant.constant(1))).multiply(scaledUpperBound).lte(currentSize.multiply(scaledLowerBound)).implies(SensorReading.value_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                       sensorReading,
                                                                                                                                                                                                                                                                                                                                                                                       "",
                                                                                                                                                                                                                                                                                                                                                                                       null,
                                                                                                                                                                                                                                                                                                                                                                                       sensorReading_isOld).gt(currentSize.minus(new LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                             kodkod.ast.IntConstant.constant(1))).multiply(scaledUpperBound).divide(currentSize)))).and(currentSize.minus(new LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      kodkod.ast.IntConstant.constant(1))).multiply(scaledUpperBound).gt(currentSize.multiply(scaledLowerBound)).implies(SensorReading.value_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     sensorReading,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     "",
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     null,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     sensorReading_isOld).gte(scaledLowerBound.multiply(currentSize).divide(currentSize)))).or(currentSize.eq(new LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          kodkod.ast.IntConstant.constant(0))).and(SensorReading.value_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               sensorReading,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               "",
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               null,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               sensorReading_isOld).eq(new LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   kodkod.ast.IntConstant.constant(0)))));
    }
    
    public static LogExpr fallback_checkInvariants_log(LogProblem fallback_problem,
                                                       LogExpr fallback_target,
                                                       String fallback_targetTypeArgsStr,
                                                       String[] fallback_targetTypeArgs,
                                                       boolean fallback_target_isOld) {
        return ThresholdBasedPolicy.valid_log(fallback_problem,
                                              fallback_target,
                                              fallback_targetTypeArgsStr,
                                              fallback_targetTypeArgs,
                                              fallback_target_isOld);
    }
    
    public static LogExpr updateMultiplierH_int_int_checkContract_log(LogProblem fallback_problem,
                                                                      LogExpr fallback_target,
                                                                      String fallback_targetTypeArgsStr,
                                                                      String[] fallback_targetTypeArgs,
                                                                      boolean fallback_target_isOld,
                                                                      LogExpr currentSize,
                                                                      boolean currentSize_isOld,
                                                                      LogExpr targetSize,
                                                                      boolean targetSize_isOld) {
        return ThresholdBasedPolicy.fallback_checkInvariants_log(fallback_problem,
                                                                 fallback_target,
                                                                 fallback_targetTypeArgsStr,
                                                                 fallback_targetTypeArgs,
                                                                 fallback_target_isOld).and(ThresholdBasedPolicy.updateMultiplierH_int_int_checkFieldsInvariants_log(fallback_problem,
                                                                                                                                                                     fallback_target,
                                                                                                                                                                     fallback_targetTypeArgsStr,
                                                                                                                                                                     fallback_targetTypeArgs,
                                                                                                                                                                     fallback_target_isOld)).and(ThresholdBasedPolicy.getBiggestValidMultiplier_log(fallback_problem,
                                                                                                                                                                                                                                                    fallback_target,
                                                                                                                                                                                                                                                    fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                    fallback_targetTypeArgs,
                                                                                                                                                                                                                                                    fallback_target_isOld,
                                                                                                                                                                                                                                                    currentSize,
                                                                                                                                                                                                                                                    currentSize_isOld,
                                                                                                                                                                                                                                                    targetSize,
                                                                                                                                                                                                                                                    targetSize_isOld).eq(ThresholdBasedPolicy.multiplier_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                 fallback_target,
                                                                                                                                                                                                                                                                                                                 fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                 fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                 fallback_target_isOld)));
    }
    
    public static LogExpr updateMultiplierH_int_int_checkFieldsInvariants_log(LogProblem fallback_problem,
                                                                              LogExpr fallback_target,
                                                                              String fallback_targetTypeArgsStr,
                                                                              String[] fallback_targetTypeArgs,
                                                                              boolean fallback_target_isOld) {
        return new LogExpr(fallback_problem,
                           kodkod.ast.Formula.TRUE);
    }
    
    public static LogExpr resizeH_int_int_checkContract_log(LogProblem fallback_problem,
                                                            LogExpr fallback_target,
                                                            String fallback_targetTypeArgsStr,
                                                            String[] fallback_targetTypeArgs,
                                                            boolean fallback_target_isOld,
                                                            LogExpr currentSize,
                                                            boolean currentSize_isOld,
                                                            LogExpr targetSize,
                                                            boolean targetSize_isOld) {
        return ThresholdBasedPolicy.fallback_checkInvariants_log(fallback_problem,
                                                                 fallback_target,
                                                                 fallback_targetTypeArgsStr,
                                                                 fallback_targetTypeArgs,
                                                                 fallback_target_isOld).and(ThresholdBasedPolicy.resizeH_int_int_checkFieldsInvariants_log(fallback_problem,
                                                                                                                                                           fallback_target,
                                                                                                                                                           fallback_targetTypeArgsStr,
                                                                                                                                                           fallback_targetTypeArgs,
                                                                                                                                                           fallback_target_isOld)).and(ThresholdBasedPolicy.fallback_field_result_resizeH_int_int_get_log(fallback_problem,
                                                                                                                                                                                                                                                          fallback_target,
                                                                                                                                                                                                                                                          fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                          fallback_targetTypeArgs,
                                                                                                                                                                                                                                                          fallback_target_isOld).eq(fallback_problem.null_log()).or(SensorReading.fallback_checkInvariants_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                               ThresholdBasedPolicy.fallback_field_result_resizeH_int_int_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                  fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                  fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                  fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                  fallback_target_isOld),
                                                                                                                                                                                                                                                                                                                                                               "",
                                                                                                                                                                                                                                                                                                                                                               null,
                                                                                                                                                                                                                                                                                                                                                               fallback_target_isOld))).and(ThresholdBasedPolicy.fallback_field_result_resizeH_int_int_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                               fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                                               fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                                               fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                                               fallback_target_isOld).eq(fallback_problem.null_log()).not().and(SensorReading.multiplier_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 ThresholdBasedPolicy.fallback_field_result_resizeH_int_int_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    fallback_target_isOld),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 "",
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 null,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 fallback_target_isOld).eq(ThresholdBasedPolicy.multiplier_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   fallback_target_isOld))).and(ThresholdBasedPolicy.roundup_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     fallback_target_isOld).eq(ThresholdBasedPolicy.roundUp_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                fallback_target_isOld,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                ThresholdBasedPolicy.lowerBound_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        fallback_target_isOld).divide(ThresholdBasedPolicy.multiplier_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              fallback_target_isOld)).multiply(targetSize),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                fallback_target_isOld,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                currentSize,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                currentSize_isOld))).and(targetSize.lt(currentSize)).and(ThresholdBasedPolicy.scalesDownTest_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 fallback_target_isOld,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 SensorReading.value_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             ThresholdBasedPolicy.fallback_field_result_resizeH_int_int_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                fallback_target_isOld),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             "",
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             null,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             fallback_target_isOld),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 fallback_target_isOld,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 currentSize,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 currentSize_isOld,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 targetSize,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 targetSize_isOld)));
    }
    
    public static LogExpr resizeH_int_int_checkFieldsInvariants_log(LogProblem fallback_problem,
                                                                    LogExpr fallback_target,
                                                                    String fallback_targetTypeArgsStr,
                                                                    String[] fallback_targetTypeArgs,
                                                                    boolean fallback_target_isOld) {
        return new LogExpr(fallback_problem,
                           kodkod.ast.Formula.TRUE);
    }
}
