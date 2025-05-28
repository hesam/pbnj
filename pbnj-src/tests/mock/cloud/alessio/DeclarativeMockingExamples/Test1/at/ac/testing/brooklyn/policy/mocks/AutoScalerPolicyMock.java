package at.ac.testing.brooklyn.policy.mocks;

import polyglot.ext.pbnj.tologic.*;
import polyglot.ext.pbnj.primitives.*;
import at.ac.testing.mocks.*;
import pbnj.util.ArrayList;
import java.util.Arrays;

public class AutoScalerPolicyMock implements PBJInternObject {
    ThesholdBasedPolicy thesholdBasedPolicy;
    
    int size;
    
    int minSize;
    
    int maxSize;
    
    boolean validPool() {
        return true &&
                 this.size >=
                   this.minSize &&
          this.size <=
            this.maxSize;
    }
    
    boolean validConfiguration() {
        return true &&
                 this.minSize >=
                   0 &&
          this.maxSize >=
            this.minSize;
    }
    
    boolean valid() {
        return true &&
                 validPool() &&
                 validConfiguration() &&
                 thesholdBasedPolicy !=
                   null &&
          thesholdBasedPolicy.valid();
    }
    
    boolean validRequestsCount(RequestsCount requestsCount) {
        return true &&
                 requestsCount !=
                   null &&
          requestsCount.valid();
    }
    
    public AutoScalerPolicyMock(int lowerBound,
                                int upperBound,
                                int minSize,
                                int maxSize,
                                int initialSize) {
        super();
        this.minSize =
          minSize;
        this.maxSize =
          maxSize;
        this.size =
          initialSize;
        thesholdBasedPolicy =
          new ThesholdBasedPolicy(lowerBound,
                                  upperBound);
        this.addInstance();
    }
    
    public String toString() {
        return "" +
               "Size " +
               this.size +
               "\n" +
               "MinSize " +
               this.minSize +
               "\n" +
               "MaxSize " +
               this.maxSize +
               "\n" +
               "Threshold Policy " +
               this.thesholdBasedPolicy +
        "\n";
    }
    
    public int getSize() {
        return this.size;
    }
    
    public RequestsCount resize_int_int_orig(int currentSize,
                                             int targetSize) {
        return null;
    }
    
    public double resizeDouble_int_orig(int targetSize) {
        return toDoubleMetricSensorValue(forceResize(targetSize));
    }
    
    public double toDoubleMetricSensorValue(RequestsCount requestsCount) {
        double sensor =
          this.size >
            0 ? (double)
                  requestsCount.requests /
                  this.size : (double)
                                requestsCount.requests;
        System.out.println("toMetricSensorValue " +
                           requestsCount +
                           " " +
                           this.size +
                           " --> " +
                           sensor);
        return sensor;
    }
    
    boolean boundedResizeTo(int targetSize) {
        return true &&
                 (!(this.old.size !=
                      targetSize) ||
                    this.size ==
                      targetSize) &&
                 (!(targetSize >
                      this.maxSize) ||
                    this.size ==
                      this.maxSize) &&
          (!(targetSize <
               this.minSize) ||
             this.size ==
               this.minSize);
    }
    
    public RequestsCount forceResize_int_orig(int targetSize) {
        return null;
    }
    
    boolean scalesUp(RequestsCount requestsCount,
                     int currentSize,
                     int targetSize) {
        return true &&
          thesholdBasedPolicy.scalesUp(requestsCount,
                                       currentSize,
                                       targetSize);
    }
    
    boolean scalesDown(RequestsCount requestsCount,
                       int currentSize,
                       int targetSize) {
        return true &&
          thesholdBasedPolicy.scalesDown(requestsCount,
                                         currentSize,
                                         targetSize);
    }
    
    boolean stays(RequestsCount requestsCount,
                  int currentSize,
                  int targetSize) {
        return true &&
          thesholdBasedPolicy.validRequestsCountForTargetConfiguration(requestsCount,
                                                                       currentSize,
                                                                       targetSize);
    }
    
    public static void main(String[] args) {
        LogMap.SolverOpt_IntBitWidth =
          11;
        int lowerBound =
          50;
        int upperBound =
          100;
        int minSize =
          1;
        int maxSize =
          20;
        int initialSize =
          5;
        AutoScalerPolicyMock policy =
          new AutoScalerPolicyMock(lowerBound,
                                   upperBound,
                                   minSize,
                                   maxSize,
                                   initialSize);
        double sensor10 =
          policy.resizeDouble(10);
        System.out.println("\n\n\n\n To scale from " +
                           initialSize +
                           " to 10 I must generate " +
                           sensor10);
        double sensor11 =
          policy.resizeDouble(11);
        policy.getSize();
        System.out.println("\n\n\n\n To scale from " +
                           10 +
                           " to 11 I must generate " +
                           sensor11);
    }
    
    public AutoScalerPolicyMock old;
    
    public boolean fallback_pbnj;
    
    Object fallback_field_result;
    
    public void fallback_field_result(Object r) {
        this.fallback_field_result =
          r;
    }
    
    public AutoScalerPolicyMock(LogExpr dontcare) {
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
        LogMap.addInstance(AutoScalerPolicyMock.class,
                           this);
    }
    
    public void addInstanceForProblem(AutoScalerPolicyMock toAdd,
                                      LogProblem fallback_problem,
                                      String fallback_targetTypeArgsStr) {
        fallback_problem.addToClassInstances(toAdd,
                                             AutoScalerPolicyMock.class,
                                             "at.ac.testing.brooklyn.policy.mocks.AutoScalerPolicyMock",
                                             fallback_targetTypeArgsStr);
    }
    
    long startMethodTime;
    
    boolean isOld;
    
    Object fallback_consistencyLock;
    
    int fallback_updateTime;
    
    public AutoScalerPolicyMock old() {
        return this.old;
    }
    
    String[] fallback_typeArgs;
    
    public AutoScalerPolicyMock fallback_setTypeArgs(String[] args) {
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
        return AutoScalerPolicyMock.classRelationizerStep ==
          fallback_problem.relationizerStep();
    }
    
    public static int classAtomizerStep =
      0;
    
    public static boolean isClassAtomized(LogProblem fallback_problem) {
        return AutoScalerPolicyMock.classAtomizerStep ==
          fallback_problem.relationizerStep();
    }
    
    public static int classClonerStep =
      0;
    
    public static boolean isClassCloned() {
        return AutoScalerPolicyMock.classClonerStep ==
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
    
    public boolean resize_int_int_checkContract(int currentSize,
                                                int targetSize) {
        return this.fallback_checkInvariants() &&
                 this.resize_int_int_checkFieldsInvariants() &&
                 (this.fallback_field_result ==
                    null ||
                    ((RequestsCount)
                       this.fallback_field_result).fallback_checkInvariants()) &&
          (validRequestsCount((RequestsCount)
                                this.fallback_field_result) &&
             (!(targetSize >
                  currentSize) ||
                scalesUp((RequestsCount)
                           this.fallback_field_result,
                         currentSize,
                         targetSize)) &&
             (!(targetSize <
                  currentSize) ||
                scalesDown((RequestsCount)
                             this.fallback_field_result,
                           currentSize,
                           targetSize)) &&
             (!(targetSize ==
                  currentSize) ||
                stays((RequestsCount)
                        this.fallback_field_result,
                      currentSize,
                      targetSize)));
    }
    
    public void resize_int_int_assertContract(int currentSize,
                                              int targetSize) {
        assert resize_int_int_checkContract(currentSize,
                                            targetSize);
    }
    
    public void resize_int_int_commitModel(int currentSize,
                                           int targetSize,
                                           LogProblem fallback_problem) {
        fallback_problem.commitModel(this);
    }
    
    LogProblem resize_int_int_planb(int currentSize,
                                    int targetSize) {
        boolean currentSize_isOld =
          false;
        boolean targetSize_isOld =
          false;
        System.out.println("\n" +
                             (this +
                                (" (" +
                                   (Thread.currentThread() +
                                      (": resize" +
                                         ") initiated plan b...")))));
        RequestsCount.fallback_initClassDefs();
        RequestsCount.fallback_initClassDefs();
        LogProblem fallback_problem =
          LogMap.initRelationize();
        String fallback_targetTypeArgsStr =
          "";
        String[] fallback_targetTypeArgs =
          null;
        fallback_problem.newFreshInstances();
        fallback_problem.setFreshInstances("at.ac.testing.mocks.RequestsCount",
                                           1);
        fallback_problem.setFreshInstances("at.ac.testing.mocks.RequestsCount",
                                           1);
        old.fallback_atomize(fallback_problem,
                             "",
                             null);
        RequestsCount.fallback_classClone();
        RequestsCount.fallback_classClone();
        RequestsCount.fallback_classAtomize(fallback_problem,
                                            fallback_targetTypeArgsStr,
                                            fallback_targetTypeArgs);
        RequestsCount.fallback_classAtomize(fallback_problem,
                                            fallback_targetTypeArgsStr,
                                            fallback_targetTypeArgs);
        fallback_problem.ObjToAtomMap();
        old.fallback_relationizeOld(fallback_problem,
                                    "",
                                    null);
        RequestsCount.fallback_classRelationizeOld(fallback_problem,
                                                   fallback_targetTypeArgsStr,
                                                   fallback_targetTypeArgs);
        RequestsCount.fallback_classRelationizeOld(fallback_problem,
                                                   fallback_targetTypeArgsStr,
                                                   fallback_targetTypeArgs);
        fallback_problem.initRelations();
        fallback_problem.newModifiableFields();
        LogExpr fallback_target =
          fallback_problem.objToSingletonRelation_log(this);
        boolean fallback_target_isOld =
          false;
        LogExpr fallback_formula =
          AutoScalerPolicyMock.resize_int_int_checkContract_log(fallback_problem,
                                                                fallback_target,
                                                                fallback_targetTypeArgsStr,
                                                                fallback_targetTypeArgs,
                                                                fallback_target_isOld,
                                                                fallback_problem.intToSingletonRelation_log(currentSize),
                                                                currentSize_isOld,
                                                                fallback_problem.intToSingletonRelation_log(targetSize),
                                                                targetSize_isOld);
        boolean isSatisfiable =
          fallback_problem.solve("resize_int_int",
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
    
    public RequestsCount resize(int currentSize,
                                int targetSize) {
        return resize_int_int_ensured(currentSize,
                                      targetSize);
    }
    
    public RequestsCount resize_int_int_ensured(int currentSize,
                                                int targetSize) {
        RequestsCount fallback_result;
        initEnsuredMethod();
        try {
            fallback_result =
              resize_int_int_orig(currentSize,
                                  targetSize);
            this.fallback_field_result =
              fallback_result;
            resize_int_int_assertContract(currentSize,
                                          targetSize);
            return fallback_result;
        }
        catch (Throwable rte) {
            {
                rte.printStackTrace();
                LogProblem fallback_problem =
                  resize_int_int_planb(currentSize,
                                       targetSize);
                resize_int_int_commitModel(currentSize,
                                           targetSize,
                                           fallback_problem);
                return (RequestsCount)
                         this.fallback_field_result;
            }
        }
    }
    
    public boolean resize_int_int_checkFieldsInvariants() {
        return true &&
          (thesholdBasedPolicy ==
             null ||
             thesholdBasedPolicy.fallback_checkInvariants());
    }
    
    RequestsCount fallback_field_result_resize_int_int;
    
    public boolean resizeDouble_int_checkContract(int targetSize) {
        return this.fallback_checkInvariants() &&
                 this.resizeDouble_int_checkFieldsInvariants() &&
          boundedResizeTo(targetSize);
    }
    
    public void resizeDouble_int_assertContract(int targetSize) {
        assert resizeDouble_int_checkContract(targetSize);
    }
    
    public void resizeDouble_int_commitModel(int targetSize,
                                             LogProblem fallback_problem) {
        fallback_problem.commitModel(this);
    }
    
    LogProblem resizeDouble_int_planb(int targetSize) {
        boolean targetSize_isOld =
          false;
        System.out.println("\n" +
                             (this +
                                (" (" +
                                   (Thread.currentThread() +
                                      (": resizeDouble" +
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
        fallback_problem.setModifiableField(("at.ac.testing.brooklyn.policy.mocks.AutoScalerPolicyMock.siz" +
                                             "e"));
        LogExpr fallback_target =
          fallback_problem.objToSingletonRelation_log(this);
        boolean fallback_target_isOld =
          false;
        LogExpr fallback_formula =
          AutoScalerPolicyMock.resizeDouble_int_checkContract_log(fallback_problem,
                                                                  fallback_target,
                                                                  fallback_targetTypeArgsStr,
                                                                  fallback_targetTypeArgs,
                                                                  fallback_target_isOld,
                                                                  fallback_problem.intToSingletonRelation_log(targetSize),
                                                                  targetSize_isOld);
        boolean isSatisfiable =
          fallback_problem.solve("resizeDouble_int",
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
    
    public double resizeDouble(int targetSize) {
        return resizeDouble_int_ensured(targetSize);
    }
    
    public double resizeDouble_int_ensured(int targetSize) {
        double fallback_result;
        initEnsuredMethod();
        try {
            fallback_result =
              resizeDouble_int_orig(targetSize);
            this.fallback_field_result =
              fallback_result;
            resizeDouble_int_assertContract(targetSize);
            return fallback_result;
        }
        catch (Throwable rte) {
            {
                rte.printStackTrace();
                LogProblem fallback_problem =
                  resizeDouble_int_planb(targetSize);
                resizeDouble_int_commitModel(targetSize,
                                             fallback_problem);
                return (Double)
                         this.fallback_field_result;
            }
        }
    }
    
    public boolean resizeDouble_int_checkFieldsInvariants() {
        return true &&
          (this.old ==
             null ||
             this.old.fallback_checkInvariants());
    }
    
    double fallback_field_result_resizeDouble_int;
    
    public boolean forceResize_int_checkContract(int targetSize) {
        return this.fallback_checkInvariants() &&
                 this.forceResize_int_checkFieldsInvariants() &&
                 (this.fallback_field_result ==
                    null ||
                    ((RequestsCount)
                       this.fallback_field_result).fallback_checkInvariants()) &&
          (validRequestsCount((RequestsCount)
                                this.fallback_field_result) &&
             (!(targetSize >
                  this.size) ||
                scalesUp((RequestsCount)
                           this.fallback_field_result,
                         this.size,
                         targetSize)) &&
             (!(targetSize <
                  this.size) ||
                scalesDown((RequestsCount)
                             this.fallback_field_result,
                           this.size,
                           targetSize)) &&
             this.thesholdBasedPolicy.validRequestsCountForTargetConfiguration((RequestsCount)
                                                                                 this.fallback_field_result,
                                                                               this.size,
                                                                               targetSize));
    }
    
    public void forceResize_int_assertContract(int targetSize) {
        assert forceResize_int_checkContract(targetSize);
    }
    
    public void forceResize_int_commitModel(int targetSize,
                                            LogProblem fallback_problem) {
        fallback_problem.commitModel(this);
    }
    
    LogProblem forceResize_int_planb(int targetSize) {
        boolean targetSize_isOld =
          false;
        System.out.println("\n" +
                             (this +
                                (" (" +
                                   (Thread.currentThread() +
                                      (": forceResize" +
                                         ") initiated plan b...")))));
        RequestsCount.fallback_initClassDefs();
        RequestsCount.fallback_initClassDefs();
        LogProblem fallback_problem =
          LogMap.initRelationize();
        String fallback_targetTypeArgsStr =
          "";
        String[] fallback_targetTypeArgs =
          null;
        fallback_problem.newFreshInstances();
        fallback_problem.setFreshInstances("at.ac.testing.mocks.RequestsCount",
                                           1);
        fallback_problem.setFreshInstances("at.ac.testing.mocks.RequestsCount",
                                           1);
        old.fallback_atomize(fallback_problem,
                             "",
                             null);
        RequestsCount.fallback_classClone();
        RequestsCount.fallback_classClone();
        RequestsCount.fallback_classAtomize(fallback_problem,
                                            fallback_targetTypeArgsStr,
                                            fallback_targetTypeArgs);
        RequestsCount.fallback_classAtomize(fallback_problem,
                                            fallback_targetTypeArgsStr,
                                            fallback_targetTypeArgs);
        fallback_problem.ObjToAtomMap();
        old.fallback_relationizeOld(fallback_problem,
                                    "",
                                    null);
        RequestsCount.fallback_classRelationizeOld(fallback_problem,
                                                   fallback_targetTypeArgsStr,
                                                   fallback_targetTypeArgs);
        RequestsCount.fallback_classRelationizeOld(fallback_problem,
                                                   fallback_targetTypeArgsStr,
                                                   fallback_targetTypeArgs);
        fallback_problem.initRelations();
        fallback_problem.newModifiableFields();
        LogExpr fallback_target =
          fallback_problem.objToSingletonRelation_log(this);
        boolean fallback_target_isOld =
          false;
        LogExpr fallback_formula =
          AutoScalerPolicyMock.forceResize_int_checkContract_log(fallback_problem,
                                                                 fallback_target,
                                                                 fallback_targetTypeArgsStr,
                                                                 fallback_targetTypeArgs,
                                                                 fallback_target_isOld,
                                                                 fallback_problem.intToSingletonRelation_log(targetSize),
                                                                 targetSize_isOld);
        boolean isSatisfiable =
          fallback_problem.solve("forceResize_int",
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
    
    public RequestsCount forceResize(int targetSize) {
        return forceResize_int_ensured(targetSize);
    }
    
    public RequestsCount forceResize_int_ensured(int targetSize) {
        RequestsCount fallback_result;
        initEnsuredMethod();
        try {
            fallback_result =
              forceResize_int_orig(targetSize);
            this.fallback_field_result =
              fallback_result;
            forceResize_int_assertContract(targetSize);
            return fallback_result;
        }
        catch (Throwable rte) {
            {
                rte.printStackTrace();
                LogProblem fallback_problem =
                  forceResize_int_planb(targetSize);
                forceResize_int_commitModel(targetSize,
                                            fallback_problem);
                return (RequestsCount)
                         this.fallback_field_result;
            }
        }
    }
    
    public boolean forceResize_int_checkFieldsInvariants() {
        return true &&
          (this.thesholdBasedPolicy ==
             null ||
             this.thesholdBasedPolicy.fallback_checkInvariants());
    }
    
    RequestsCount fallback_field_result_forceResize_int;
    
    public void fallback_atomize(LogProblem fallback_problem,
                                 String fallback_targetTypeArgsStr,
                                 String[] fallback_targetTypeArgs) {
        if (!isAtomized(fallback_problem)) {
            this.atomizerStep =
              fallback_problem.relationizerStep();
            AutoScalerPolicyMock.fallback_classAtomize(fallback_problem,
                                                       fallback_targetTypeArgsStr,
                                                       fallback_targetTypeArgs);
            this.addInstanceForProblem(this.old,
                                       fallback_problem,
                                       fallback_targetTypeArgsStr);
            if (this.thesholdBasedPolicy !=
                  null)
                this.thesholdBasedPolicy.fallback_atomize(fallback_problem,
                                                          "",
                                                          null);
        }
    }
    
    public void fallback_relationizeOld(LogProblem fallback_problem,
                                        String fallback_targetTypeArgsStr,
                                        String[] fallback_targetTypeArgs) {
        if (!isRelationized(fallback_problem)) {
            this.relationizerStep =
              fallback_problem.relationizerStep();
            AutoScalerPolicyMock.fallback_classRelationizeOld(fallback_problem,
                                                              fallback_targetTypeArgsStr,
                                                              fallback_targetTypeArgs);
            if (this.thesholdBasedPolicy !=
                  null)
                this.thesholdBasedPolicy.fallback_relationizeOld(fallback_problem,
                                                                 "",
                                                                 null);
            AutoScalerPolicyMock.thesholdBasedPolicy_old_get_log(fallback_problem,
                                                                 fallback_targetTypeArgsStr,
                                                                 fallback_targetTypeArgs).put_log(fallback_problem,
                                                                                                  this,
                                                                                                  this.thesholdBasedPolicy);
            AutoScalerPolicyMock.size_old_get_log(fallback_problem,
                                                  fallback_targetTypeArgsStr,
                                                  fallback_targetTypeArgs).put_log(fallback_problem,
                                                                                   this,
                                                                                   this.size);
            AutoScalerPolicyMock.minSize_old_get_log(fallback_problem,
                                                     fallback_targetTypeArgsStr,
                                                     fallback_targetTypeArgs).put_log(fallback_problem,
                                                                                      this,
                                                                                      this.minSize);
            AutoScalerPolicyMock.maxSize_old_get_log(fallback_problem,
                                                     fallback_targetTypeArgsStr,
                                                     fallback_targetTypeArgs).put_log(fallback_problem,
                                                                                      this,
                                                                                      this.maxSize);
        }
    }
    
    public static void fallback_classAtomize(LogProblem fallback_problem,
                                             String fallback_targetTypeArgsStr,
                                             String[] fallback_targetTypeArgs) {
        if (!isClassAtomized(fallback_problem)) {
            AutoScalerPolicyMock.classAtomizerStep =
              fallback_problem.relationizerStep();
        }
    }
    
    public static void fallback_classRelationizeOld(LogProblem fallback_problem,
                                                    String fallback_targetTypeArgsStr,
                                                    String[] fallback_targetTypeArgs) {
        if (!isClassRelationized(fallback_problem)) {
            AutoScalerPolicyMock.classRelationizerStep =
              fallback_problem.relationizerStep();
        }
    }
    
    public static void fallback_classClone() {
        if (isClassCloned())
            return;
    }
    
    public AutoScalerPolicyMock fallback_clone() {
        if (isCloned())
            return old;
        AutoScalerPolicyMock res =
          null;
        AutoScalerPolicyMock.fallback_classClone();
        try {
            res =
              (AutoScalerPolicyMock)
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
            if (this.thesholdBasedPolicy !=
                  null)
                res.thesholdBasedPolicy =
                  this.thesholdBasedPolicy.fallback_clone();
            res.size =
              this.size;
            res.minSize =
              this.minSize;
            res.maxSize =
              this.maxSize;
        }
        catch (Exception rte) {
            rte.printStackTrace();
            System.exit(1);
        }
        return res;
    }
    
    public static LogExpr thesholdBasedPolicy_get_log(LogProblem fallback_problem,
                                                      LogExpr fallback_target,
                                                      String fallback_targetTypeArgsStr,
                                                      String[] fallback_targetTypeArgs,
                                                      boolean isOld) {
        return LogMap.fieldGet_log(fallback_problem,
                                   fallback_target,
                                   "at.ac.testing.brooklyn.policy.mocks.AutoScalerPolicyMock",
                                   fallback_targetTypeArgsStr,
                                   "thesholdBasedPolicy",
                                   isOld);
    }
    
    public static LogRelation thesholdBasedPolicy_old_get_log(LogProblem fallback_problem,
                                                              String fallback_targetTypeArgsStr,
                                                              String[] fallback_targetTypeArgs) {
        return LogMap.oldFieldGet_log(fallback_problem,
                                      "at.ac.testing.brooklyn.policy.mocks.AutoScalerPolicyMock",
                                      fallback_targetTypeArgsStr,
                                      "thesholdBasedPolicy");
    }
    
    public ThesholdBasedPolicy fallback_updateField_thesholdBasedPolicy(ThesholdBasedPolicy newVal) {
        return this.thesholdBasedPolicy =
          newVal;
    }
    
    public PBJInternSet<ThesholdBasedPolicy> fieldsClosure_ThesholdBasedPolicy(Object fallback_target,
                                                                               boolean isReflexive,
                                                                               java.lang.String ... fieldNs) {
        Class c =
          ThesholdBasedPolicy.class;
        PBJInternSet<ThesholdBasedPolicy> res =
          new PBJInternSet<ThesholdBasedPolicy>();
        java.util.ArrayList<ThesholdBasedPolicy> workList =
          new java.util.ArrayList<ThesholdBasedPolicy>();
        try {
            java.util.ArrayList<java.lang.reflect.Field> fields =
              new java.util.ArrayList<java.lang.reflect.Field>();
            for (String fN : fieldNs) {
                fields.add(c.getField(fN));
            }
            for (java.lang.reflect.Field f : fields) {
                ThesholdBasedPolicy childN =
                  (ThesholdBasedPolicy)
                    f.get(fallback_target);
                if (!(childN ==
                        null ||
                        res.containsPtrEqCmp(childN)))
                    workList.add(childN);
            }
            ThesholdBasedPolicy n;
            while (workList.size() >
                     0) {
                n =
                  workList.get(0);
                res.add(n);
                for (java.lang.reflect.Field f : fields) {
                    ThesholdBasedPolicy childN =
                      (ThesholdBasedPolicy)
                        f.get(n);
                    if (!(childN ==
                            null ||
                            res.containsPtrEqCmp(childN)))
                        workList.add(childN);
                }
                workList.remove(n);
            }
            if (isReflexive)
                res.add((ThesholdBasedPolicy)
                          fallback_target);
        }
        catch (Exception rte) {
            rte.printStackTrace();
        }
        return res;
    }
    
    PBJInternSet<ThesholdBasedPolicy> multiFields_ThesholdBasedPolicy(java.lang.String ... fieldNs) {
        Class c =
          ThesholdBasedPolicy.class;
        PBJInternSet<ThesholdBasedPolicy> res =
          new PBJInternSet<ThesholdBasedPolicy>();
        try {
            for (String fN : fieldNs) {
                java.lang.reflect.Field f =
                  c.getField(fN);
                ThesholdBasedPolicy n =
                  (ThesholdBasedPolicy)
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
    
    public static LogExpr size_get_log(LogProblem fallback_problem,
                                       LogExpr fallback_target,
                                       String fallback_targetTypeArgsStr,
                                       String[] fallback_targetTypeArgs,
                                       boolean isOld) {
        return LogMap.fieldGet_log(fallback_problem,
                                   fallback_target,
                                   "at.ac.testing.brooklyn.policy.mocks.AutoScalerPolicyMock",
                                   fallback_targetTypeArgsStr,
                                   "size",
                                   isOld);
    }
    
    public static LogRelation size_old_get_log(LogProblem fallback_problem,
                                               String fallback_targetTypeArgsStr,
                                               String[] fallback_targetTypeArgs) {
        return LogMap.oldFieldGet_log(fallback_problem,
                                      "at.ac.testing.brooklyn.policy.mocks.AutoScalerPolicyMock",
                                      fallback_targetTypeArgsStr,
                                      "size");
    }
    
    public int fallback_updateField_size(Integer newVal) {
        return this.size =
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
    
    public static LogExpr minSize_get_log(LogProblem fallback_problem,
                                          LogExpr fallback_target,
                                          String fallback_targetTypeArgsStr,
                                          String[] fallback_targetTypeArgs,
                                          boolean isOld) {
        return LogMap.fieldGet_log(fallback_problem,
                                   fallback_target,
                                   "at.ac.testing.brooklyn.policy.mocks.AutoScalerPolicyMock",
                                   fallback_targetTypeArgsStr,
                                   "minSize",
                                   isOld);
    }
    
    public static LogRelation minSize_old_get_log(LogProblem fallback_problem,
                                                  String fallback_targetTypeArgsStr,
                                                  String[] fallback_targetTypeArgs) {
        return LogMap.oldFieldGet_log(fallback_problem,
                                      "at.ac.testing.brooklyn.policy.mocks.AutoScalerPolicyMock",
                                      fallback_targetTypeArgsStr,
                                      "minSize");
    }
    
    public int fallback_updateField_minSize(Integer newVal) {
        return this.minSize =
          newVal;
    }
    
    public static LogExpr maxSize_get_log(LogProblem fallback_problem,
                                          LogExpr fallback_target,
                                          String fallback_targetTypeArgsStr,
                                          String[] fallback_targetTypeArgs,
                                          boolean isOld) {
        return LogMap.fieldGet_log(fallback_problem,
                                   fallback_target,
                                   "at.ac.testing.brooklyn.policy.mocks.AutoScalerPolicyMock",
                                   fallback_targetTypeArgsStr,
                                   "maxSize",
                                   isOld);
    }
    
    public static LogRelation maxSize_old_get_log(LogProblem fallback_problem,
                                                  String fallback_targetTypeArgsStr,
                                                  String[] fallback_targetTypeArgs) {
        return LogMap.oldFieldGet_log(fallback_problem,
                                      "at.ac.testing.brooklyn.policy.mocks.AutoScalerPolicyMock",
                                      fallback_targetTypeArgsStr,
                                      "maxSize");
    }
    
    public int fallback_updateField_maxSize(Integer newVal) {
        return this.maxSize =
          newVal;
    }
    
    public static LogExpr fallback_field_result_resize_int_int_get_log(LogProblem fallback_problem,
                                                                       LogExpr fallback_target,
                                                                       String fallback_targetTypeArgsStr,
                                                                       String[] fallback_targetTypeArgs,
                                                                       boolean isOld) {
        return LogMap.resultGet_log(fallback_problem,
                                    fallback_target,
                                    "at.ac.testing.brooklyn.policy.mocks.AutoScalerPolicyMock",
                                    fallback_targetTypeArgsStr,
                                    "fallback_field_result_resize_int_int");
    }
    
    public static LogExpr fallback_field_result_resizeDouble_int_get_log(LogProblem fallback_problem,
                                                                         LogExpr fallback_target,
                                                                         String fallback_targetTypeArgsStr,
                                                                         String[] fallback_targetTypeArgs,
                                                                         boolean isOld) {
        return LogMap.resultGet_log(fallback_problem,
                                    fallback_target,
                                    "at.ac.testing.brooklyn.policy.mocks.AutoScalerPolicyMock",
                                    fallback_targetTypeArgsStr,
                                    "fallback_field_result_resizeDouble_int");
    }
    
    public static LogExpr fallback_field_result_forceResize_int_get_log(LogProblem fallback_problem,
                                                                        LogExpr fallback_target,
                                                                        String fallback_targetTypeArgsStr,
                                                                        String[] fallback_targetTypeArgs,
                                                                        boolean isOld) {
        return LogMap.resultGet_log(fallback_problem,
                                    fallback_target,
                                    "at.ac.testing.brooklyn.policy.mocks.AutoScalerPolicyMock",
                                    fallback_targetTypeArgsStr,
                                    "fallback_field_result_forceResize_int");
    }
    
    public static PBJInternSet<ThesholdBasedPolicy> setMap_thesholdBasedPolicy(PBJInternSet<AutoScalerPolicyMock> objs,
                                                                               java.lang.String ... fieldNs) {
        PBJInternSet<ThesholdBasedPolicy> res =
          new PBJInternSet<ThesholdBasedPolicy>();
        java.util.Iterator<AutoScalerPolicyMock> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().thesholdBasedPolicy);
        }
        return res;
    }
    
    public static PBJInternSet<Integer> setMap_size(PBJInternSet<AutoScalerPolicyMock> objs,
                                                    java.lang.String ... fieldNs) {
        PBJInternSet<Integer> res =
          new PBJInternSet<Integer>();
        java.util.Iterator<AutoScalerPolicyMock> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().size);
        }
        return res;
    }
    
    public static PBJInternSet<Integer> setMap_minSize(PBJInternSet<AutoScalerPolicyMock> objs,
                                                       java.lang.String ... fieldNs) {
        PBJInternSet<Integer> res =
          new PBJInternSet<Integer>();
        java.util.Iterator<AutoScalerPolicyMock> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().minSize);
        }
        return res;
    }
    
    public static PBJInternSet<Integer> setMap_maxSize(PBJInternSet<AutoScalerPolicyMock> objs,
                                                       java.lang.String ... fieldNs) {
        PBJInternSet<Integer> res =
          new PBJInternSet<Integer>();
        java.util.Iterator<AutoScalerPolicyMock> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().maxSize);
        }
        return res;
    }
    
    public static void fallback_initClassDefs() {
        
    }
    
    static {
               LogMap.newClassForLog(AutoScalerPolicyMock.class,
                                     true);
               LogMap.newInstVarRel("thesholdBasedPolicy",
                                    AutoScalerPolicyMock.class,
                                    "at.ac.testing.brooklyn.policy.mocks.AutoScalerPolicyMock",
                                    ThesholdBasedPolicy.class,
                                    "at.ac.testing.brooklyn.policy.mocks.ThesholdBasedPolicy",
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
               LogMap.newInstVarRel("size",
                                    AutoScalerPolicyMock.class,
                                    "at.ac.testing.brooklyn.policy.mocks.AutoScalerPolicyMock",
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
               LogMap.newInstVarRel("minSize",
                                    AutoScalerPolicyMock.class,
                                    "at.ac.testing.brooklyn.policy.mocks.AutoScalerPolicyMock",
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
               LogMap.newInstVarRel("maxSize",
                                    AutoScalerPolicyMock.class,
                                    "at.ac.testing.brooklyn.policy.mocks.AutoScalerPolicyMock",
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
               LogMap.newInstVarRel("fallback_field_result_resize_int_int",
                                    AutoScalerPolicyMock.class,
                                    "at.ac.testing.brooklyn.policy.mocks.AutoScalerPolicyMock",
                                    RequestsCount.class,
                                    "at.ac.testing.mocks.RequestsCount",
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
               LogMap.newInstVarRel("fallback_field_result_resizeDouble_int",
                                    AutoScalerPolicyMock.class,
                                    "at.ac.testing.brooklyn.policy.mocks.AutoScalerPolicyMock",
                                    Double.class,
                                    "double",
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
               LogMap.newInstVarRel("fallback_field_result_forceResize_int",
                                    AutoScalerPolicyMock.class,
                                    "at.ac.testing.brooklyn.policy.mocks.AutoScalerPolicyMock",
                                    RequestsCount.class,
                                    "at.ac.testing.mocks.RequestsCount",
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
    
    static LogExpr validPool_log(LogProblem fallback_problem,
                                 LogExpr fallback_target,
                                 String fallback_targetTypeArgsStr,
                                 String[] fallback_targetTypeArgs,
                                 boolean fallback_target_isOld) {
        return new LogExpr(fallback_problem,
                           kodkod.ast.Formula.TRUE).and(AutoScalerPolicyMock.size_get_log(fallback_problem,
                                                                                          fallback_target,
                                                                                          fallback_targetTypeArgsStr,
                                                                                          fallback_targetTypeArgs,
                                                                                          fallback_target_isOld).gte(AutoScalerPolicyMock.minSize_get_log(fallback_problem,
                                                                                                                                                          fallback_target,
                                                                                                                                                          fallback_targetTypeArgsStr,
                                                                                                                                                          fallback_targetTypeArgs,
                                                                                                                                                          fallback_target_isOld))).and(AutoScalerPolicyMock.size_get_log(fallback_problem,
                                                                                                                                                                                                                         fallback_target,
                                                                                                                                                                                                                         fallback_targetTypeArgsStr,
                                                                                                                                                                                                                         fallback_targetTypeArgs,
                                                                                                                                                                                                                         fallback_target_isOld).lte(AutoScalerPolicyMock.maxSize_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                         fallback_target,
                                                                                                                                                                                                                                                                                         fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                         fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                         fallback_target_isOld)));
    }
    
    static LogExpr validConfiguration_log(LogProblem fallback_problem,
                                          LogExpr fallback_target,
                                          String fallback_targetTypeArgsStr,
                                          String[] fallback_targetTypeArgs,
                                          boolean fallback_target_isOld) {
        return new LogExpr(fallback_problem,
                           kodkod.ast.Formula.TRUE).and(AutoScalerPolicyMock.minSize_get_log(fallback_problem,
                                                                                             fallback_target,
                                                                                             fallback_targetTypeArgsStr,
                                                                                             fallback_targetTypeArgs,
                                                                                             fallback_target_isOld).gte(new LogExpr(fallback_problem,
                                                                                                                                    kodkod.ast.IntConstant.constant(0)))).and(AutoScalerPolicyMock.maxSize_get_log(fallback_problem,
                                                                                                                                                                                                                   fallback_target,
                                                                                                                                                                                                                   fallback_targetTypeArgsStr,
                                                                                                                                                                                                                   fallback_targetTypeArgs,
                                                                                                                                                                                                                   fallback_target_isOld).gte(AutoScalerPolicyMock.minSize_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                   fallback_target,
                                                                                                                                                                                                                                                                                   fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                   fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                   fallback_target_isOld)));
    }
    
    static LogExpr valid_log(LogProblem fallback_problem,
                             LogExpr fallback_target,
                             String fallback_targetTypeArgsStr,
                             String[] fallback_targetTypeArgs,
                             boolean fallback_target_isOld) {
        return new LogExpr(fallback_problem,
                           kodkod.ast.Formula.TRUE).and(AutoScalerPolicyMock.validPool_log(fallback_problem,
                                                                                           fallback_target,
                                                                                           fallback_targetTypeArgsStr,
                                                                                           fallback_targetTypeArgs,
                                                                                           fallback_target_isOld)).and(AutoScalerPolicyMock.validConfiguration_log(fallback_problem,
                                                                                                                                                                   fallback_target,
                                                                                                                                                                   fallback_targetTypeArgsStr,
                                                                                                                                                                   fallback_targetTypeArgs,
                                                                                                                                                                   fallback_target_isOld)).and(AutoScalerPolicyMock.thesholdBasedPolicy_get_log(fallback_problem,
                                                                                                                                                                                                                                                fallback_target,
                                                                                                                                                                                                                                                fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                fallback_targetTypeArgs,
                                                                                                                                                                                                                                                fallback_target_isOld).eq(fallback_problem.null_log()).not()).and(ThesholdBasedPolicy.valid_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                AutoScalerPolicyMock.thesholdBasedPolicy_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                 fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                 fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                 fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                 fallback_target_isOld),
                                                                                                                                                                                                                                                                                                                                                "",
                                                                                                                                                                                                                                                                                                                                                null,
                                                                                                                                                                                                                                                                                                                                                fallback_target_isOld));
    }
    
    static LogExpr validRequestsCount_log(LogProblem fallback_problem,
                                          LogExpr fallback_target,
                                          String fallback_targetTypeArgsStr,
                                          String[] fallback_targetTypeArgs,
                                          boolean fallback_target_isOld,
                                          LogExpr requestsCount,
                                          boolean requestsCount_isOld) {
        return new LogExpr(fallback_problem,
                           kodkod.ast.Formula.TRUE).and(requestsCount.eq(fallback_problem.null_log()).not()).and(RequestsCount.valid_log(fallback_problem,
                                                                                                                                         requestsCount,
                                                                                                                                         "",
                                                                                                                                         null,
                                                                                                                                         requestsCount_isOld));
    }
    
    static LogExpr boundedResizeTo_log(LogProblem fallback_problem,
                                       LogExpr fallback_target,
                                       String fallback_targetTypeArgsStr,
                                       String[] fallback_targetTypeArgs,
                                       boolean fallback_target_isOld,
                                       LogExpr targetSize,
                                       boolean targetSize_isOld) {
        return new LogExpr(fallback_problem,
                           kodkod.ast.Formula.TRUE).and(AutoScalerPolicyMock.size_get_log(fallback_problem,
                                                                                          fallback_target,
                                                                                          fallback_targetTypeArgsStr,
                                                                                          fallback_targetTypeArgs,
                                                                                          true).eq(targetSize).not().implies(AutoScalerPolicyMock.size_get_log(fallback_problem,
                                                                                                                                                               fallback_target,
                                                                                                                                                               fallback_targetTypeArgsStr,
                                                                                                                                                               fallback_targetTypeArgs,
                                                                                                                                                               fallback_target_isOld).eq(targetSize))).and(targetSize.gt(AutoScalerPolicyMock.maxSize_get_log(fallback_problem,
                                                                                                                                                                                                                                                              fallback_target,
                                                                                                                                                                                                                                                              fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                              fallback_targetTypeArgs,
                                                                                                                                                                                                                                                              fallback_target_isOld)).implies(AutoScalerPolicyMock.size_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                fallback_target,
                                                                                                                                                                                                                                                                                                                                fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                fallback_target_isOld).eq(AutoScalerPolicyMock.maxSize_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                               fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                               fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                               fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                               fallback_target_isOld)))).and(targetSize.lt(AutoScalerPolicyMock.minSize_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                fallback_target_isOld)).implies(AutoScalerPolicyMock.size_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  fallback_target_isOld).eq(AutoScalerPolicyMock.minSize_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 fallback_target_isOld))));
    }
    
    static LogExpr scalesUp_log(LogProblem fallback_problem,
                                LogExpr fallback_target,
                                String fallback_targetTypeArgsStr,
                                String[] fallback_targetTypeArgs,
                                boolean fallback_target_isOld,
                                LogExpr requestsCount,
                                boolean requestsCount_isOld,
                                LogExpr currentSize,
                                boolean currentSize_isOld,
                                LogExpr targetSize,
                                boolean targetSize_isOld) {
        return new LogExpr(fallback_problem,
                           kodkod.ast.Formula.TRUE).and(ThesholdBasedPolicy.scalesUp_log(fallback_problem,
                                                                                         AutoScalerPolicyMock.thesholdBasedPolicy_get_log(fallback_problem,
                                                                                                                                          fallback_target,
                                                                                                                                          fallback_targetTypeArgsStr,
                                                                                                                                          fallback_targetTypeArgs,
                                                                                                                                          fallback_target_isOld),
                                                                                         "",
                                                                                         null,
                                                                                         fallback_target_isOld,
                                                                                         requestsCount,
                                                                                         requestsCount_isOld,
                                                                                         currentSize,
                                                                                         currentSize_isOld,
                                                                                         targetSize,
                                                                                         targetSize_isOld));
    }
    
    static LogExpr scalesDown_log(LogProblem fallback_problem,
                                  LogExpr fallback_target,
                                  String fallback_targetTypeArgsStr,
                                  String[] fallback_targetTypeArgs,
                                  boolean fallback_target_isOld,
                                  LogExpr requestsCount,
                                  boolean requestsCount_isOld,
                                  LogExpr currentSize,
                                  boolean currentSize_isOld,
                                  LogExpr targetSize,
                                  boolean targetSize_isOld) {
        return new LogExpr(fallback_problem,
                           kodkod.ast.Formula.TRUE).and(ThesholdBasedPolicy.scalesDown_log(fallback_problem,
                                                                                           AutoScalerPolicyMock.thesholdBasedPolicy_get_log(fallback_problem,
                                                                                                                                            fallback_target,
                                                                                                                                            fallback_targetTypeArgsStr,
                                                                                                                                            fallback_targetTypeArgs,
                                                                                                                                            fallback_target_isOld),
                                                                                           "",
                                                                                           null,
                                                                                           fallback_target_isOld,
                                                                                           requestsCount,
                                                                                           requestsCount_isOld,
                                                                                           currentSize,
                                                                                           currentSize_isOld,
                                                                                           targetSize,
                                                                                           targetSize_isOld));
    }
    
    static LogExpr stays_log(LogProblem fallback_problem,
                             LogExpr fallback_target,
                             String fallback_targetTypeArgsStr,
                             String[] fallback_targetTypeArgs,
                             boolean fallback_target_isOld,
                             LogExpr requestsCount,
                             boolean requestsCount_isOld,
                             LogExpr currentSize,
                             boolean currentSize_isOld,
                             LogExpr targetSize,
                             boolean targetSize_isOld) {
        return new LogExpr(fallback_problem,
                           kodkod.ast.Formula.TRUE).and(ThesholdBasedPolicy.validRequestsCountForTargetConfiguration_log(fallback_problem,
                                                                                                                         AutoScalerPolicyMock.thesholdBasedPolicy_get_log(fallback_problem,
                                                                                                                                                                          fallback_target,
                                                                                                                                                                          fallback_targetTypeArgsStr,
                                                                                                                                                                          fallback_targetTypeArgs,
                                                                                                                                                                          fallback_target_isOld),
                                                                                                                         "",
                                                                                                                         null,
                                                                                                                         fallback_target_isOld,
                                                                                                                         requestsCount,
                                                                                                                         requestsCount_isOld,
                                                                                                                         currentSize,
                                                                                                                         currentSize_isOld,
                                                                                                                         targetSize,
                                                                                                                         targetSize_isOld));
    }
    
    public static LogExpr fallback_checkInvariants_log(LogProblem fallback_problem,
                                                       LogExpr fallback_target,
                                                       String fallback_targetTypeArgsStr,
                                                       String[] fallback_targetTypeArgs,
                                                       boolean fallback_target_isOld) {
        return AutoScalerPolicyMock.valid_log(fallback_problem,
                                              fallback_target,
                                              fallback_targetTypeArgsStr,
                                              fallback_targetTypeArgs,
                                              fallback_target_isOld);
    }
    
    public static LogExpr resize_int_int_checkContract_log(LogProblem fallback_problem,
                                                           LogExpr fallback_target,
                                                           String fallback_targetTypeArgsStr,
                                                           String[] fallback_targetTypeArgs,
                                                           boolean fallback_target_isOld,
                                                           LogExpr currentSize,
                                                           boolean currentSize_isOld,
                                                           LogExpr targetSize,
                                                           boolean targetSize_isOld) {
        return AutoScalerPolicyMock.fallback_checkInvariants_log(fallback_problem,
                                                                 fallback_target,
                                                                 fallback_targetTypeArgsStr,
                                                                 fallback_targetTypeArgs,
                                                                 fallback_target_isOld).and(AutoScalerPolicyMock.resize_int_int_checkFieldsInvariants_log(fallback_problem,
                                                                                                                                                          fallback_target,
                                                                                                                                                          fallback_targetTypeArgsStr,
                                                                                                                                                          fallback_targetTypeArgs,
                                                                                                                                                          fallback_target_isOld)).and(AutoScalerPolicyMock.fallback_field_result_resize_int_int_get_log(fallback_problem,
                                                                                                                                                                                                                                                        fallback_target,
                                                                                                                                                                                                                                                        fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                        fallback_targetTypeArgs,
                                                                                                                                                                                                                                                        fallback_target_isOld).eq(fallback_problem.null_log()).or(RequestsCount.fallback_checkInvariants_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                             AutoScalerPolicyMock.fallback_field_result_resize_int_int_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                               fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                               fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                               fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                               fallback_target_isOld),
                                                                                                                                                                                                                                                                                                                                                             "",
                                                                                                                                                                                                                                                                                                                                                             null,
                                                                                                                                                                                                                                                                                                                                                             fallback_target_isOld))).and(AutoScalerPolicyMock.validRequestsCount_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                      fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                      fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                      fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                      fallback_target_isOld,
                                                                                                                                                                                                                                                                                                                                                                                                                                      AutoScalerPolicyMock.fallback_field_result_resize_int_int_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        fallback_target_isOld),
                                                                                                                                                                                                                                                                                                                                                                                                                                      fallback_target_isOld).and(targetSize.gt(currentSize).implies(AutoScalerPolicyMock.scalesUp_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      fallback_target_isOld,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      AutoScalerPolicyMock.fallback_field_result_resize_int_int_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        fallback_target_isOld),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      fallback_target_isOld,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      currentSize,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      currentSize_isOld,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      targetSize,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      targetSize_isOld))).and(targetSize.lt(currentSize).implies(AutoScalerPolicyMock.scalesDown_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     fallback_target_isOld,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     AutoScalerPolicyMock.fallback_field_result_resize_int_int_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       fallback_target_isOld),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     fallback_target_isOld,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     currentSize,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     currentSize_isOld,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     targetSize,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     targetSize_isOld))).and(targetSize.eq(currentSize).implies(AutoScalerPolicyMock.stays_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               fallback_target_isOld,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               AutoScalerPolicyMock.fallback_field_result_resize_int_int_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 fallback_target_isOld),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               fallback_target_isOld,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               currentSize,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               currentSize_isOld,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               targetSize,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               targetSize_isOld))));
    }
    
    public static LogExpr resize_int_int_checkFieldsInvariants_log(LogProblem fallback_problem,
                                                                   LogExpr fallback_target,
                                                                   String fallback_targetTypeArgsStr,
                                                                   String[] fallback_targetTypeArgs,
                                                                   boolean fallback_target_isOld) {
        return new LogExpr(fallback_problem,
                           kodkod.ast.Formula.TRUE).and(AutoScalerPolicyMock.thesholdBasedPolicy_get_log(fallback_problem,
                                                                                                         fallback_target,
                                                                                                         fallback_targetTypeArgsStr,
                                                                                                         fallback_targetTypeArgs,
                                                                                                         fallback_target_isOld).eq(fallback_problem.null_log()).or(ThesholdBasedPolicy.fallback_checkInvariants_log(fallback_problem,
                                                                                                                                                                                                                    AutoScalerPolicyMock.thesholdBasedPolicy_get_log(fallback_problem,
                                                                                                                                                                                                                                                                     fallback_target,
                                                                                                                                                                                                                                                                     fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                     fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                     fallback_target_isOld),
                                                                                                                                                                                                                    "",
                                                                                                                                                                                                                    null,
                                                                                                                                                                                                                    fallback_target_isOld)));
    }
    
    public static LogExpr resizeDouble_int_checkContract_log(LogProblem fallback_problem,
                                                             LogExpr fallback_target,
                                                             String fallback_targetTypeArgsStr,
                                                             String[] fallback_targetTypeArgs,
                                                             boolean fallback_target_isOld,
                                                             LogExpr targetSize,
                                                             boolean targetSize_isOld) {
        return AutoScalerPolicyMock.fallback_checkInvariants_log(fallback_problem,
                                                                 fallback_target,
                                                                 fallback_targetTypeArgsStr,
                                                                 fallback_targetTypeArgs,
                                                                 fallback_target_isOld).and(AutoScalerPolicyMock.resizeDouble_int_checkFieldsInvariants_log(fallback_problem,
                                                                                                                                                            fallback_target,
                                                                                                                                                            fallback_targetTypeArgsStr,
                                                                                                                                                            fallback_targetTypeArgs,
                                                                                                                                                            fallback_target_isOld)).and(AutoScalerPolicyMock.boundedResizeTo_log(fallback_problem,
                                                                                                                                                                                                                                 fallback_target,
                                                                                                                                                                                                                                 fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                 fallback_targetTypeArgs,
                                                                                                                                                                                                                                 fallback_target_isOld,
                                                                                                                                                                                                                                 targetSize,
                                                                                                                                                                                                                                 targetSize_isOld));
    }
    
    public static LogExpr resizeDouble_int_checkFieldsInvariants_log(LogProblem fallback_problem,
                                                                     LogExpr fallback_target,
                                                                     String fallback_targetTypeArgsStr,
                                                                     String[] fallback_targetTypeArgs,
                                                                     boolean fallback_target_isOld) {
        return new LogExpr(fallback_problem,
                           kodkod.ast.Formula.TRUE).and(fallback_target.eq(fallback_problem.null_log()).or(AutoScalerPolicyMock.fallback_checkInvariants_log(fallback_problem,
                                                                                                                                                             fallback_target,
                                                                                                                                                             fallback_targetTypeArgsStr,
                                                                                                                                                             fallback_targetTypeArgs,
                                                                                                                                                             true)));
    }
    
    public static LogExpr forceResize_int_checkContract_log(LogProblem fallback_problem,
                                                            LogExpr fallback_target,
                                                            String fallback_targetTypeArgsStr,
                                                            String[] fallback_targetTypeArgs,
                                                            boolean fallback_target_isOld,
                                                            LogExpr targetSize,
                                                            boolean targetSize_isOld) {
        return AutoScalerPolicyMock.fallback_checkInvariants_log(fallback_problem,
                                                                 fallback_target,
                                                                 fallback_targetTypeArgsStr,
                                                                 fallback_targetTypeArgs,
                                                                 fallback_target_isOld).and(AutoScalerPolicyMock.forceResize_int_checkFieldsInvariants_log(fallback_problem,
                                                                                                                                                           fallback_target,
                                                                                                                                                           fallback_targetTypeArgsStr,
                                                                                                                                                           fallback_targetTypeArgs,
                                                                                                                                                           fallback_target_isOld)).and(AutoScalerPolicyMock.fallback_field_result_forceResize_int_get_log(fallback_problem,
                                                                                                                                                                                                                                                          fallback_target,
                                                                                                                                                                                                                                                          fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                          fallback_targetTypeArgs,
                                                                                                                                                                                                                                                          fallback_target_isOld).eq(fallback_problem.null_log()).or(RequestsCount.fallback_checkInvariants_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                               AutoScalerPolicyMock.fallback_field_result_forceResize_int_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                  fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                  fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                  fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                  fallback_target_isOld),
                                                                                                                                                                                                                                                                                                                                                               "",
                                                                                                                                                                                                                                                                                                                                                               null,
                                                                                                                                                                                                                                                                                                                                                               fallback_target_isOld))).and(AutoScalerPolicyMock.validRequestsCount_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                        fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                        fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                        fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                        fallback_target_isOld,
                                                                                                                                                                                                                                                                                                                                                                                                                                        AutoScalerPolicyMock.fallback_field_result_forceResize_int_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           fallback_target_isOld),
                                                                                                                                                                                                                                                                                                                                                                                                                                        fallback_target_isOld).and(targetSize.gt(AutoScalerPolicyMock.size_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   fallback_target_isOld)).implies(AutoScalerPolicyMock.scalesUp_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     fallback_target_isOld,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     AutoScalerPolicyMock.fallback_field_result_forceResize_int_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        fallback_target_isOld),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     fallback_target_isOld,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     AutoScalerPolicyMock.size_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       fallback_target_isOld),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     fallback_target_isOld,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     targetSize,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     targetSize_isOld))).and(targetSize.lt(AutoScalerPolicyMock.size_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             fallback_target_isOld)).implies(AutoScalerPolicyMock.scalesDown_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 fallback_target_isOld,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 AutoScalerPolicyMock.fallback_field_result_forceResize_int_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    fallback_target_isOld),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 fallback_target_isOld,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 AutoScalerPolicyMock.size_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   fallback_target_isOld),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 fallback_target_isOld,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 targetSize,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 targetSize_isOld))).and(ThesholdBasedPolicy.validRequestsCountForTargetConfiguration_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          AutoScalerPolicyMock.thesholdBasedPolicy_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           fallback_target_isOld),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          "",
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          null,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          fallback_target_isOld,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          AutoScalerPolicyMock.fallback_field_result_forceResize_int_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             fallback_target_isOld),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          fallback_target_isOld,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          AutoScalerPolicyMock.size_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            fallback_target_isOld),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          fallback_target_isOld,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          targetSize,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          targetSize_isOld)));
    }
    
    public static LogExpr forceResize_int_checkFieldsInvariants_log(LogProblem fallback_problem,
                                                                    LogExpr fallback_target,
                                                                    String fallback_targetTypeArgsStr,
                                                                    String[] fallback_targetTypeArgs,
                                                                    boolean fallback_target_isOld) {
        return new LogExpr(fallback_problem,
                           kodkod.ast.Formula.TRUE).and(AutoScalerPolicyMock.thesholdBasedPolicy_get_log(fallback_problem,
                                                                                                         fallback_target,
                                                                                                         fallback_targetTypeArgsStr,
                                                                                                         fallback_targetTypeArgs,
                                                                                                         fallback_target_isOld).eq(fallback_problem.null_log()).or(ThesholdBasedPolicy.fallback_checkInvariants_log(fallback_problem,
                                                                                                                                                                                                                    AutoScalerPolicyMock.thesholdBasedPolicy_get_log(fallback_problem,
                                                                                                                                                                                                                                                                     fallback_target,
                                                                                                                                                                                                                                                                     fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                     fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                     fallback_target_isOld),
                                                                                                                                                                                                                    "",
                                                                                                                                                                                                                    null,
                                                                                                                                                                                                                    fallback_target_isOld)));
    }
}
