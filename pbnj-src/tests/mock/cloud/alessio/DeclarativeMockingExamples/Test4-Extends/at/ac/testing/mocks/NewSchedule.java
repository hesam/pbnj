package at.ac.testing.mocks;

import polyglot.ext.pbnj.tologic.*;
import polyglot.ext.pbnj.primitives.*;
import pbnj.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NewSchedule implements PBJInternObject {
    int MAX_SIZE =
      10;
    
    int size;
    
    public TimedAction[] actions;
    
    public NewSchedule() {
        super();
        this.addInstance();
    }
    
    public boolean classInvariant() {
        return true &&
          classInvariant_univQuantify_0();
    }
    
    public void init() {
        positiveSizeH();
        initH();
    }
    
    void positiveSizeH_orig() {
        
    }
    
    void initH_orig() {
        
    }
    
    boolean initSpec() {
        return validSchedule();
    }
    
    public void init(TimedAction[] targetActions) {
        size =
          targetActions.length;
        initH(targetActions);
    }
    
    void initH_TimedAction_orig(TimedAction[] targetActions) {
        
    }
    
    boolean pureObjects(TimedAction[] targetActions) {
        return pureObjects_univQuantify_2(targetActions);
    }
    
    boolean pureObjects() {
        return pureObjects_univQuantify_4();
    }
    
    boolean preserveStateTransitions(TimedAction[] targetActions) {
        return preserveStateTransitions_univQuantify_6(targetActions);
    }
    
    public void withDuration_int_orig(int duration) {
        
    }
    
    public void withMaxDuration_int_orig(int maxDuration) {
        
    }
    
    public void withMinDuration_int_orig(int minDuration) {
        
    }
    
    public void withDurationInBetween_int_int_orig(int minDuration,
                                                   int maxDuration) {
        
    }
    
    boolean validSchedule() {
        return actions !=
                 null &&
                 actions.length ==
                   size &&
          validSchedule_univQuantify_8();
    }
    
    boolean atMost(int maxDuration) {
        return actions[size -
                         1].time <=
          maxDuration;
    }
    
    boolean atLeast(int minDuration) {
        return actions[size -
                         1].time >=
          minDuration;
    }
    
    boolean exactly(int duration) {
        return actions[size -
                         1].time ==
          duration;
    }
    
    public void doForceStateConsistency_orig() {
        int z =
          1 /
          0;
    }
    
    boolean stateConsistency() {
        return stateConsistency_univQuantify_10();
    }
    
    public String toString() {
        return "Schedule : " +
               Arrays.toString(actions) +
        "\n";
    }
    
    public NewSchedule old;
    
    public boolean fallback_pbnj;
    
    Object fallback_field_result;
    
    public void fallback_field_result(Object r) {
        this.fallback_field_result =
          r;
    }
    
    public NewSchedule(LogExpr dontcare) {
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
        LogMap.addInstance(NewSchedule.class,
                           this);
    }
    
    public void addInstanceForProblem(NewSchedule toAdd,
                                      LogProblem fallback_problem,
                                      String fallback_targetTypeArgsStr) {
        fallback_problem.addToClassInstances(toAdd,
                                             NewSchedule.class,
                                             "at.ac.testing.mocks.NewSchedule",
                                             fallback_targetTypeArgsStr);
    }
    
    long startMethodTime;
    
    boolean isOld;
    
    Object fallback_consistencyLock;
    
    int fallback_updateTime;
    
    public NewSchedule old() {
        return this.old;
    }
    
    String[] fallback_typeArgs;
    
    public NewSchedule fallback_setTypeArgs(String[] args) {
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
        return NewSchedule.classRelationizerStep ==
          fallback_problem.relationizerStep();
    }
    
    public static int classAtomizerStep =
      0;
    
    public static boolean isClassAtomized(LogProblem fallback_problem) {
        return NewSchedule.classAtomizerStep ==
          fallback_problem.relationizerStep();
    }
    
    public static int classClonerStep =
      0;
    
    public static boolean isClassCloned() {
        return NewSchedule.classClonerStep ==
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
    
    public boolean positiveSizeH_checkContract() {
        return this.fallback_checkInvariants() &&
                 this.positiveSizeH_checkFieldsInvariants() &&
          (this.size >
             0 &&
             this.size <=
               this.MAX_SIZE);
    }
    
    public void positiveSizeH_assertContract() {
        assert positiveSizeH_checkContract();
    }
    
    public void positiveSizeH_commitModel(LogProblem fallback_problem) {
        fallback_problem.commitModel(this);
    }
    
    LogProblem positiveSizeH_planb() {
        System.out.println("\n" +
                             (this +
                                (" (" +
                                   (Thread.currentThread() +
                                      (": positiveSizeH" +
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
        fallback_problem.setModifiableField("at.ac.testing.mocks.NewSchedule.size");
        LogExpr fallback_target =
          fallback_problem.objToSingletonRelation_log(this);
        boolean fallback_target_isOld =
          false;
        LogExpr fallback_formula =
          NewSchedule.positiveSizeH_checkContract_log(fallback_problem,
                                                      fallback_target,
                                                      fallback_targetTypeArgsStr,
                                                      fallback_targetTypeArgs,
                                                      fallback_target_isOld);
        boolean isSatisfiable =
          fallback_problem.solve("positiveSizeH",
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
    
    void positiveSizeH() {
        positiveSizeH_ensured();
    }
    
    void positiveSizeH_ensured() {
        initEnsuredMethod();
        try {
            positiveSizeH_orig();
            positiveSizeH_assertContract();
        }
        catch (Throwable rte) {
            {
                rte.printStackTrace();
                LogProblem fallback_problem =
                  positiveSizeH_planb();
                positiveSizeH_commitModel(fallback_problem);
            }
        }
    }
    
    public boolean positiveSizeH_checkFieldsInvariants() {
        return true;
    }
    
    public boolean initH_checkContract() {
        return this.fallback_checkInvariants() &&
                 this.initH_checkFieldsInvariants() &&
          (initSpec() &&
             pureObjects());
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
        TimedAction.fallback_initClassDefs();
        LogProblem fallback_problem =
          LogMap.initRelationize();
        String fallback_targetTypeArgsStr =
          "";
        String[] fallback_targetTypeArgs =
          null;
        fallback_problem.newFreshInstances();
        fallback_problem.setFreshInstances("at.ac.testing.mocks.TimedAction",
                                           this.size);
        old.fallback_atomize(fallback_problem,
                             "",
                             null);
        TimedAction.fallback_classClone();
        TimedAction.fallback_classAtomize(fallback_problem,
                                          fallback_targetTypeArgsStr,
                                          fallback_targetTypeArgs);
        fallback_problem.ObjToAtomMap();
        old.fallback_relationizeOld(fallback_problem,
                                    "",
                                    null);
        TimedAction.fallback_classRelationizeOld(fallback_problem,
                                                 fallback_targetTypeArgsStr,
                                                 fallback_targetTypeArgs);
        fallback_problem.initRelations();
        fallback_problem.newModifiableFields();
        fallback_problem.setModifiableField("at.ac.testing.mocks.NewSchedule.actions");
        LogExpr fallback_target =
          fallback_problem.objToSingletonRelation_log(this);
        boolean fallback_target_isOld =
          false;
        LogExpr fallback_formula =
          NewSchedule.initH_checkContract_log(fallback_problem,
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
    
    public boolean initH_TimedAction_checkContract(TimedAction[] targetActions) {
        return this.fallback_checkInvariants() &&
                 this.initH_TimedAction_checkFieldsInvariants() &&
          (pureObjects(targetActions) &&
             preserveStateTransitions(targetActions) &&
             initSpec());
    }
    
    public void initH_TimedAction_assertContract(TimedAction[] targetActions) {
        assert initH_TimedAction_checkContract(targetActions);
    }
    
    public void initH_TimedAction_commitModel(TimedAction[] targetActions,
                                              LogProblem fallback_problem) {
        fallback_problem.commitModel(this);
    }
    
    LogProblem initH_TimedAction_planb(TimedAction[] targetActions) {
        boolean targetActions_isOld =
          false;
        System.out.println("\n" +
                             (this +
                                (" (" +
                                   (Thread.currentThread() +
                                      (": initH" +
                                         ") initiated plan b...")))));
        TimedAction.fallback_initClassDefs();
        LogProblem fallback_problem =
          LogMap.initRelationize();
        String fallback_targetTypeArgsStr =
          "";
        String[] fallback_targetTypeArgs =
          null;
        fallback_problem.newFreshInstances();
        fallback_problem.setFreshInstances("at.ac.testing.mocks.TimedAction",
                                           this.size);
        old.fallback_atomize(fallback_problem,
                             "",
                             null);
        TimedAction.fallback_classClone();
        TimedAction.fallback_classAtomize(fallback_problem,
                                          fallback_targetTypeArgsStr,
                                          fallback_targetTypeArgs);
        if (targetActions !=
              null)
            for (int i_fallback =
                   0;
                 i_fallback <
                   targetActions.length;
                 i_fallback++)
                targetActions[i_fallback].old().fallback_atomize(fallback_problem,
                                                                 "",
                                                                 null);
        fallback_problem.ObjToAtomMap();
        old.fallback_relationizeOld(fallback_problem,
                                    "",
                                    null);
        if (targetActions !=
              null)
            for (int i_fallback =
                   0;
                 i_fallback <
                   targetActions.length;
                 i_fallback++)
                targetActions[i_fallback].old().fallback_relationizeOld(fallback_problem,
                                                                        "",
                                                                        null);
        TimedAction.fallback_classRelationizeOld(fallback_problem,
                                                 fallback_targetTypeArgsStr,
                                                 fallback_targetTypeArgs);
        fallback_problem.initRelations();
        fallback_problem.newModifiableFields();
        fallback_problem.setModifiableField("at.ac.testing.mocks.NewSchedule.actions");
        LogExpr fallback_target =
          fallback_problem.objToSingletonRelation_log(this);
        boolean fallback_target_isOld =
          false;
        LogExpr fallback_formula =
          NewSchedule.initH_TimedAction_checkContract_log(fallback_problem,
                                                          fallback_target,
                                                          fallback_targetTypeArgsStr,
                                                          fallback_targetTypeArgs,
                                                          fallback_target_isOld,
                                                          fallback_problem.arrayToRelation_log(targetActions),
                                                          targetActions_isOld);
        boolean isSatisfiable =
          fallback_problem.solve("initH_TimedAction",
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
    
    void initH(TimedAction[] targetActions) {
        initH_TimedAction_ensured(targetActions);
    }
    
    void initH_TimedAction_ensured(TimedAction[] targetActions) {
        initEnsuredMethod();
        if (targetActions !=
              null)
            for (int i_fallback =
                   0;
                 i_fallback <
                   targetActions.length;
                 i_fallback++)
                ((PBJInternObject)
                   targetActions[i_fallback]).fallback_clone();
        try {
            initH_TimedAction_orig(targetActions);
            initH_TimedAction_assertContract(targetActions);
        }
        catch (Throwable rte) {
            {
                rte.printStackTrace();
                LogProblem fallback_problem =
                  initH_TimedAction_planb(targetActions);
                initH_TimedAction_commitModel(targetActions,
                                              fallback_problem);
            }
        }
    }
    
    public boolean initH_TimedAction_checkFieldsInvariants() {
        return true;
    }
    
    public boolean withDuration_int_checkContract(int duration) {
        return this.fallback_checkInvariants() &&
                 this.withDuration_int_checkFieldsInvariants() &&
          (exactly(duration) &&
             validSchedule());
    }
    
    public void withDuration_int_assertContract(int duration) {
        assert withDuration_int_checkContract(duration);
    }
    
    public void withDuration_int_commitModel(int duration,
                                             LogProblem fallback_problem) {
        fallback_problem.commitModel(this);
    }
    
    LogProblem withDuration_int_planb(int duration) {
        boolean duration_isOld =
          false;
        System.out.println("\n" +
                             (this +
                                (" (" +
                                   (Thread.currentThread() +
                                      (": withDuration" +
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
        fallback_problem.setModifiableField("at.ac.testing.mocks.TimedAction.time");
        LogExpr fallback_target =
          fallback_problem.objToSingletonRelation_log(this);
        boolean fallback_target_isOld =
          false;
        LogExpr fallback_formula =
          NewSchedule.withDuration_int_checkContract_log(fallback_problem,
                                                         fallback_target,
                                                         fallback_targetTypeArgsStr,
                                                         fallback_targetTypeArgs,
                                                         fallback_target_isOld,
                                                         fallback_problem.intToSingletonRelation_log(duration),
                                                         duration_isOld);
        boolean isSatisfiable =
          fallback_problem.solve("withDuration_int",
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
    
    public void withDuration(int duration) {
        withDuration_int_ensured(duration);
    }
    
    public void withDuration_int_ensured(int duration) {
        initEnsuredMethod();
        try {
            withDuration_int_orig(duration);
            withDuration_int_assertContract(duration);
        }
        catch (Throwable rte) {
            {
                rte.printStackTrace();
                LogProblem fallback_problem =
                  withDuration_int_planb(duration);
                withDuration_int_commitModel(duration,
                                             fallback_problem);
            }
        }
    }
    
    public boolean withDuration_int_checkFieldsInvariants() {
        return true;
    }
    
    public boolean withMaxDuration_int_checkContract(int maxDuration) {
        return this.fallback_checkInvariants() &&
                 this.withMaxDuration_int_checkFieldsInvariants() &&
          (atMost(maxDuration) &&
             validSchedule());
    }
    
    public void withMaxDuration_int_assertContract(int maxDuration) {
        assert withMaxDuration_int_checkContract(maxDuration);
    }
    
    public void withMaxDuration_int_commitModel(int maxDuration,
                                                LogProblem fallback_problem) {
        fallback_problem.commitModel(this);
    }
    
    LogProblem withMaxDuration_int_planb(int maxDuration) {
        boolean maxDuration_isOld =
          false;
        System.out.println("\n" +
                             (this +
                                (" (" +
                                   (Thread.currentThread() +
                                      (": withMaxDuration" +
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
        fallback_problem.setModifiableField("at.ac.testing.mocks.TimedAction.time");
        LogExpr fallback_target =
          fallback_problem.objToSingletonRelation_log(this);
        boolean fallback_target_isOld =
          false;
        LogExpr fallback_formula =
          NewSchedule.withMaxDuration_int_checkContract_log(fallback_problem,
                                                            fallback_target,
                                                            fallback_targetTypeArgsStr,
                                                            fallback_targetTypeArgs,
                                                            fallback_target_isOld,
                                                            fallback_problem.intToSingletonRelation_log(maxDuration),
                                                            maxDuration_isOld);
        boolean isSatisfiable =
          fallback_problem.solve("withMaxDuration_int",
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
    
    public void withMaxDuration(int maxDuration) {
        withMaxDuration_int_ensured(maxDuration);
    }
    
    public void withMaxDuration_int_ensured(int maxDuration) {
        initEnsuredMethod();
        try {
            withMaxDuration_int_orig(maxDuration);
            withMaxDuration_int_assertContract(maxDuration);
        }
        catch (Throwable rte) {
            {
                rte.printStackTrace();
                LogProblem fallback_problem =
                  withMaxDuration_int_planb(maxDuration);
                withMaxDuration_int_commitModel(maxDuration,
                                                fallback_problem);
            }
        }
    }
    
    public boolean withMaxDuration_int_checkFieldsInvariants() {
        return true;
    }
    
    public boolean withMinDuration_int_checkContract(int minDuration) {
        return this.fallback_checkInvariants() &&
                 this.withMinDuration_int_checkFieldsInvariants() &&
          (atLeast(minDuration) &&
             validSchedule());
    }
    
    public void withMinDuration_int_assertContract(int minDuration) {
        assert withMinDuration_int_checkContract(minDuration);
    }
    
    public void withMinDuration_int_commitModel(int minDuration,
                                                LogProblem fallback_problem) {
        fallback_problem.commitModel(this);
    }
    
    LogProblem withMinDuration_int_planb(int minDuration) {
        boolean minDuration_isOld =
          false;
        System.out.println("\n" +
                             (this +
                                (" (" +
                                   (Thread.currentThread() +
                                      (": withMinDuration" +
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
        fallback_problem.setModifiableField("at.ac.testing.mocks.TimedAction.time");
        LogExpr fallback_target =
          fallback_problem.objToSingletonRelation_log(this);
        boolean fallback_target_isOld =
          false;
        LogExpr fallback_formula =
          NewSchedule.withMinDuration_int_checkContract_log(fallback_problem,
                                                            fallback_target,
                                                            fallback_targetTypeArgsStr,
                                                            fallback_targetTypeArgs,
                                                            fallback_target_isOld,
                                                            fallback_problem.intToSingletonRelation_log(minDuration),
                                                            minDuration_isOld);
        boolean isSatisfiable =
          fallback_problem.solve("withMinDuration_int",
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
    
    public void withMinDuration(int minDuration) {
        withMinDuration_int_ensured(minDuration);
    }
    
    public void withMinDuration_int_ensured(int minDuration) {
        initEnsuredMethod();
        try {
            withMinDuration_int_orig(minDuration);
            withMinDuration_int_assertContract(minDuration);
        }
        catch (Throwable rte) {
            {
                rte.printStackTrace();
                LogProblem fallback_problem =
                  withMinDuration_int_planb(minDuration);
                withMinDuration_int_commitModel(minDuration,
                                                fallback_problem);
            }
        }
    }
    
    public boolean withMinDuration_int_checkFieldsInvariants() {
        return true;
    }
    
    public boolean withDurationInBetween_int_int_checkContract(int minDuration,
                                                               int maxDuration) {
        return this.fallback_checkInvariants() &&
                 this.withDurationInBetween_int_int_checkFieldsInvariants() &&
          (minDuration <
             maxDuration &&
             atLeast(minDuration) &&
             atMost(maxDuration) ||
             minDuration >
               maxDuration &&
               atLeast(maxDuration) &&
               atMost(minDuration) ||
             minDuration <
               maxDuration &&
               exactly(minDuration));
    }
    
    public void withDurationInBetween_int_int_assertContract(int minDuration,
                                                             int maxDuration) {
        assert withDurationInBetween_int_int_checkContract(minDuration,
                                                           maxDuration);
    }
    
    public void withDurationInBetween_int_int_commitModel(int minDuration,
                                                          int maxDuration,
                                                          LogProblem fallback_problem) {
        fallback_problem.commitModel(this);
    }
    
    LogProblem withDurationInBetween_int_int_planb(int minDuration,
                                                   int maxDuration) {
        boolean minDuration_isOld =
          false;
        boolean maxDuration_isOld =
          false;
        System.out.println("\n" +
                             (this +
                                (" (" +
                                   (Thread.currentThread() +
                                      (": withDurationInBetween" +
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
        fallback_problem.setModifiableField("at.ac.testing.mocks.TimedAction.time");
        LogExpr fallback_target =
          fallback_problem.objToSingletonRelation_log(this);
        boolean fallback_target_isOld =
          false;
        LogExpr fallback_formula =
          NewSchedule.withDurationInBetween_int_int_checkContract_log(fallback_problem,
                                                                      fallback_target,
                                                                      fallback_targetTypeArgsStr,
                                                                      fallback_targetTypeArgs,
                                                                      fallback_target_isOld,
                                                                      fallback_problem.intToSingletonRelation_log(minDuration),
                                                                      minDuration_isOld,
                                                                      fallback_problem.intToSingletonRelation_log(maxDuration),
                                                                      maxDuration_isOld);
        boolean isSatisfiable =
          fallback_problem.solve("withDurationInBetween_int_int",
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
    
    public void withDurationInBetween(int minDuration,
                                      int maxDuration) {
        withDurationInBetween_int_int_ensured(minDuration,
                                              maxDuration);
    }
    
    public void withDurationInBetween_int_int_ensured(int minDuration,
                                                      int maxDuration) {
        initEnsuredMethod();
        try {
            withDurationInBetween_int_int_orig(minDuration,
                                               maxDuration);
            withDurationInBetween_int_int_assertContract(minDuration,
                                                         maxDuration);
        }
        catch (Throwable rte) {
            {
                rte.printStackTrace();
                LogProblem fallback_problem =
                  withDurationInBetween_int_int_planb(minDuration,
                                                      maxDuration);
                withDurationInBetween_int_int_commitModel(minDuration,
                                                          maxDuration,
                                                          fallback_problem);
            }
        }
    }
    
    public boolean withDurationInBetween_int_int_checkFieldsInvariants() {
        return true;
    }
    
    public boolean doForceStateConsistency_checkContract() {
        return this.fallback_checkInvariants() &&
                 this.doForceStateConsistency_checkFieldsInvariants() &&
          ((!(this.actions.length >
                1) ||
              stateConsistency()) &&
             doForceStateConsistency_checkContract_univQuantify_9());
    }
    
    public void doForceStateConsistency_assertContract() {
        assert doForceStateConsistency_checkContract();
    }
    
    public void doForceStateConsistency_commitModel(LogProblem fallback_problem) {
        fallback_problem.commitModel(this);
    }
    
    LogProblem doForceStateConsistency_planb() {
        System.out.println("\n" +
                             (this +
                                (" (" +
                                   (Thread.currentThread() +
                                      (": doForceStateConsistency" +
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
        fallback_problem.setModifiableField("at.ac.testing.mocks.TimedAction.startSize");
        fallback_problem.setModifiableField("at.ac.testing.mocks.TimedAction.endSize");
        LogExpr fallback_target =
          fallback_problem.objToSingletonRelation_log(this);
        boolean fallback_target_isOld =
          false;
        LogExpr fallback_formula =
          NewSchedule.doForceStateConsistency_checkContract_log(fallback_problem,
                                                                fallback_target,
                                                                fallback_targetTypeArgsStr,
                                                                fallback_targetTypeArgs,
                                                                fallback_target_isOld);
        boolean isSatisfiable =
          fallback_problem.solve("doForceStateConsistency",
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
    
    public void doForceStateConsistency() {
        doForceStateConsistency_ensured();
    }
    
    public void doForceStateConsistency_ensured() {
        initEnsuredMethod();
        try {
            doForceStateConsistency_orig();
            doForceStateConsistency_assertContract();
        }
        catch (Throwable rte) {
            {
                rte.printStackTrace();
                LogProblem fallback_problem =
                  doForceStateConsistency_planb();
                doForceStateConsistency_commitModel(fallback_problem);
            }
        }
    }
    
    public boolean doForceStateConsistency_checkFieldsInvariants() {
        return true;
    }
    
    public void fallback_atomize(LogProblem fallback_problem,
                                 String fallback_targetTypeArgsStr,
                                 String[] fallback_targetTypeArgs) {
        if (!isAtomized(fallback_problem)) {
            this.atomizerStep =
              fallback_problem.relationizerStep();
            NewSchedule.fallback_classAtomize(fallback_problem,
                                              fallback_targetTypeArgsStr,
                                              fallback_targetTypeArgs);
            this.addInstanceForProblem(this.old,
                                       fallback_problem,
                                       fallback_targetTypeArgsStr);
            if (this.actions !=
                  null)
                for (int i0_actions =
                       0;
                     i0_actions <
                       this.actions.length;
                     i0_actions++)
                    if (this.actions[i0_actions] !=
                          null)
                        this.actions[i0_actions].fallback_atomize(fallback_problem,
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
            NewSchedule.fallback_classRelationizeOld(fallback_problem,
                                                     fallback_targetTypeArgsStr,
                                                     fallback_targetTypeArgs);
            if (this.actions !=
                  null)
                for (int i0_actions =
                       0;
                     i0_actions <
                       this.actions.length;
                     i0_actions++)
                    if (this.actions[i0_actions] !=
                          null)
                        this.actions[i0_actions].fallback_relationizeOld(fallback_problem,
                                                                         "",
                                                                         null);
            NewSchedule.MAX_SIZE_old_get_log(fallback_problem,
                                             fallback_targetTypeArgsStr,
                                             fallback_targetTypeArgs).put_log(fallback_problem,
                                                                              this,
                                                                              this.MAX_SIZE);
            NewSchedule.size_old_get_log(fallback_problem,
                                         fallback_targetTypeArgsStr,
                                         fallback_targetTypeArgs).put_log(fallback_problem,
                                                                          this,
                                                                          this.size);
            NewSchedule.actions_old_get_log(fallback_problem,
                                            fallback_targetTypeArgsStr,
                                            fallback_targetTypeArgs).array_put_log(fallback_problem,
                                                                                   this,
                                                                                   this.actions);
        }
    }
    
    public static void fallback_classAtomize(LogProblem fallback_problem,
                                             String fallback_targetTypeArgsStr,
                                             String[] fallback_targetTypeArgs) {
        if (!isClassAtomized(fallback_problem)) {
            NewSchedule.classAtomizerStep =
              fallback_problem.relationizerStep();
        }
    }
    
    public static void fallback_classRelationizeOld(LogProblem fallback_problem,
                                                    String fallback_targetTypeArgsStr,
                                                    String[] fallback_targetTypeArgs) {
        if (!isClassRelationized(fallback_problem)) {
            NewSchedule.classRelationizerStep =
              fallback_problem.relationizerStep();
        }
    }
    
    public static void fallback_classClone() {
        if (isClassCloned())
            return;
    }
    
    public NewSchedule fallback_clone() {
        if (isCloned())
            return old;
        NewSchedule res =
          null;
        NewSchedule.fallback_classClone();
        try {
            res =
              (NewSchedule)
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
            res.MAX_SIZE =
              this.MAX_SIZE;
            res.size =
              this.size;
            if (this.actions !=
                  null) {
                res.actions =
                  (TimedAction[])
                    this.actions.clone();
                for (int i0_actions =
                       0;
                     i0_actions <
                       this.actions.length;
                     i0_actions++)
                    if (this.actions[i0_actions] !=
                          null) {
                        res.actions[i0_actions] =
                          (TimedAction)
                            ((PBJInternObject)
                               this.actions[i0_actions]).fallback_clone();
                    }
            }
        }
        catch (Exception rte) {
            rte.printStackTrace();
            System.exit(1);
        }
        return res;
    }
    
    public static LogExpr MAX_SIZE_get_log(LogProblem fallback_problem,
                                           LogExpr fallback_target,
                                           String fallback_targetTypeArgsStr,
                                           String[] fallback_targetTypeArgs,
                                           boolean isOld) {
        return LogMap.fieldGet_log(fallback_problem,
                                   fallback_target,
                                   "at.ac.testing.mocks.NewSchedule",
                                   fallback_targetTypeArgsStr,
                                   "MAX_SIZE",
                                   isOld);
    }
    
    public static LogRelation MAX_SIZE_old_get_log(LogProblem fallback_problem,
                                                   String fallback_targetTypeArgsStr,
                                                   String[] fallback_targetTypeArgs) {
        return LogMap.oldFieldGet_log(fallback_problem,
                                      "at.ac.testing.mocks.NewSchedule",
                                      fallback_targetTypeArgsStr,
                                      "MAX_SIZE");
    }
    
    public int fallback_updateField_MAX_SIZE(Integer newVal) {
        return this.MAX_SIZE =
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
    
    public static LogExpr size_get_log(LogProblem fallback_problem,
                                       LogExpr fallback_target,
                                       String fallback_targetTypeArgsStr,
                                       String[] fallback_targetTypeArgs,
                                       boolean isOld) {
        return LogMap.fieldGet_log(fallback_problem,
                                   fallback_target,
                                   "at.ac.testing.mocks.NewSchedule",
                                   fallback_targetTypeArgsStr,
                                   "size",
                                   isOld);
    }
    
    public static LogRelation size_old_get_log(LogProblem fallback_problem,
                                               String fallback_targetTypeArgsStr,
                                               String[] fallback_targetTypeArgs) {
        return LogMap.oldFieldGet_log(fallback_problem,
                                      "at.ac.testing.mocks.NewSchedule",
                                      fallback_targetTypeArgsStr,
                                      "size");
    }
    
    public int fallback_updateField_size(Integer newVal) {
        return this.size =
          newVal;
    }
    
    public static LogExpr actions_get_log(LogProblem fallback_problem,
                                          LogExpr fallback_target,
                                          String fallback_targetTypeArgsStr,
                                          String[] fallback_targetTypeArgs,
                                          boolean isOld) {
        return LogMap.fieldGet_log(fallback_problem,
                                   fallback_target,
                                   "at.ac.testing.mocks.NewSchedule",
                                   fallback_targetTypeArgsStr,
                                   "actions",
                                   isOld);
    }
    
    public static LogRelation actions_old_get_log(LogProblem fallback_problem,
                                                  String fallback_targetTypeArgsStr,
                                                  String[] fallback_targetTypeArgs) {
        return LogMap.oldFieldGet_log(fallback_problem,
                                      "at.ac.testing.mocks.NewSchedule",
                                      fallback_targetTypeArgsStr,
                                      "actions");
    }
    
    public TimedAction fallback_updateArrayField_actions(int index,
                                                         TimedAction newVal) {
        this.actions[index] =
          newVal;
        return newVal;
    }
    
    public TimedAction[] fallback_updateField_actions(java.util.ArrayList<TimedAction> newVal) {
        int i =
          0;
        int s =
          newVal.size();
        if (this.actions ==
              null ||
              this.actions.length !=
                s)
            this.actions =
              (new TimedAction[s]);
        while (i <
                 s) {
            this.actions[i] =
              newVal.get(i);
            i++;
        }
        return this.actions;
    }
    
    public TimedAction[] fallback_updateField_actions(TimedAction[] newVal) {
        return this.actions =
          newVal;
    }
    
    public boolean classInvariant_univQuantify_0() {
        for (TimedAction action : actions) {
            if (!(action !=
                    null &&
                    action.valid()))
                return false;
        }
        return true;
    }
    
    boolean pureObjects_univQuantify_2(TimedAction[] targetActions) {
        for (TimedAction t1 : targetActions) {
            if (!pureObjects_univQuantify_1(targetActions,
                                            t1))
                return false;
        }
        return true;
    }
    
    boolean pureObjects_univQuantify_1(TimedAction[] targetActions,
                                       TimedAction t1) {
        for (TimedAction t2 : actions) {
            if (!(t1 !=
                    t2))
                return false;
        }
        return true;
    }
    
    boolean pureObjects_univQuantify_4() {
        for (int a : PBJInternInteger.range(0,
                                            size -
                                              1)) {
            if (!pureObjects_univQuantify_3(a))
                return false;
        }
        return true;
    }
    
    boolean pureObjects_univQuantify_3(int a) {
        for (int b : PBJInternInteger.range(0,
                                            size -
                                              1)) {
            if (!(a !=
                    b ==
                    (actions[a] !=
                       actions[b])))
                return false;
        }
        return true;
    }
    
    boolean preserveStateTransitions_univQuantify_6(TimedAction[] targetActions) {
        for (TimedAction targetTA : targetActions) {
            if (!preserveStateTransitions_existQuantify_5(targetActions,
                                                          targetTA))
                return false;
        }
        return true;
    }
    
    boolean preserveStateTransitions_existQuantify_5(TimedAction[] targetActions,
                                                     TimedAction targetTA) {
        for (TimedAction localTA : actions) {
            if (localTA.startSize ==
                  targetTA.startSize &&
                  localTA.targetSize ==
                    targetTA.targetSize &&
                  (!(targetTA.time >=
                       0) ||
                     localTA.time ==
                       targetTA.time))
                return true;
        }
        return false;
    }
    
    boolean validSchedule_univQuantify_8() {
        for (int i : PBJInternInteger.range(0,
                                            size -
                                              1)) {
            if (!validSchedule_univQuantify_7(i))
                return false;
        }
        return true;
    }
    
    boolean validSchedule_univQuantify_7(int i) {
        for (int j : PBJInternInteger.range(0,
                                            size -
                                              1)) {
            if (!(!(i <=
                      j) ||
                    actions[i].time <=
                      actions[j].time))
                return false;
        }
        return true;
    }
    
    boolean stateConsistency_univQuantify_10() {
        for (int i : PBJInternInteger.range(0,
                                            this.actions.length -
                                              1)) {
            if (!((!(i ==
                       0) ||
                     this.actions[i].targetSize ==
                       this.actions[i +
                                      1].startSize) &&
                    (!(i >
                         0 &&
                         i <
                           this.actions.length -
                             1) ||
                       this.actions[i].startSize ==
                         this.actions[i -
                                        1].targetSize &&
                         this.actions[i].targetSize ==
                           this.actions[i +
                                          1].startSize) &&
                    (!(i ==
                         this.actions.length -
                           1) ||
                       this.actions[i].startSize ==
                         this.actions[i -
                                        1].targetSize)))
                return false;
        }
        return true;
    }
    
    public boolean doForceStateConsistency_checkContract_univQuantify_9() {
        for (TimedAction t : this.actions) {
            if (!t.valid())
                return false;
        }
        return true;
    }
    
    public static PBJInternSet<Integer> setMap_MAX_SIZE(PBJInternSet<NewSchedule> objs,
                                                        java.lang.String ... fieldNs) {
        PBJInternSet<Integer> res =
          new PBJInternSet<Integer>();
        java.util.Iterator<NewSchedule> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().MAX_SIZE);
        }
        return res;
    }
    
    public static PBJInternSet<Integer> setMap_size(PBJInternSet<NewSchedule> objs,
                                                    java.lang.String ... fieldNs) {
        PBJInternSet<Integer> res =
          new PBJInternSet<Integer>();
        java.util.Iterator<NewSchedule> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().size);
        }
        return res;
    }
    
    public static void fallback_initClassDefs() {
        
    }
    
    static {
               LogMap.newClassForLog(NewSchedule.class,
                                     true);
               LogMap.newInstVarRel("MAX_SIZE",
                                    NewSchedule.class,
                                    "at.ac.testing.mocks.NewSchedule",
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
               LogMap.newInstVarRel("size",
                                    NewSchedule.class,
                                    "at.ac.testing.mocks.NewSchedule",
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
               LogMap.newInstVarRel("actions",
                                    NewSchedule.class,
                                    "at.ac.testing.mocks.NewSchedule",
                                    TimedAction.class,
                                    "at.ac.testing.mocks.TimedAction",
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
    
    public static LogExpr classInvariant_log(LogProblem fallback_problem,
                                             LogExpr fallback_target,
                                             String fallback_targetTypeArgsStr,
                                             String[] fallback_targetTypeArgs,
                                             boolean fallback_target_isOld) {
        boolean action_isOld =
          false;
        LogExpr action =
          new LogExpr(fallback_problem,
                      kodkod.ast.Variable.unary("action"));
        return new LogExpr(fallback_problem,
                           kodkod.ast.Formula.TRUE).and(LogExpr.quantifyOp(NewSchedule.actions_get_log(fallback_problem,
                                                                                                       fallback_target,
                                                                                                       fallback_targetTypeArgsStr,
                                                                                                       fallback_targetTypeArgs,
                                                                                                       fallback_target_isOld),
                                                                           false,
                                                                           "all",
                                                                           action,
                                                                           action.eq(fallback_problem.null_log()).not().and(TimedAction.valid_log(fallback_problem,
                                                                                                                                                  action,
                                                                                                                                                  "",
                                                                                                                                                  null,
                                                                                                                                                  action_isOld))));
    }
    
    static LogExpr initSpec_log(LogProblem fallback_problem,
                                LogExpr fallback_target,
                                String fallback_targetTypeArgsStr,
                                String[] fallback_targetTypeArgs,
                                boolean fallback_target_isOld) {
        return NewSchedule.validSchedule_log(fallback_problem,
                                             fallback_target,
                                             fallback_targetTypeArgsStr,
                                             fallback_targetTypeArgs,
                                             fallback_target_isOld);
    }
    
    static LogExpr pureObjects_log(LogProblem fallback_problem,
                                   LogExpr fallback_target,
                                   String fallback_targetTypeArgsStr,
                                   String[] fallback_targetTypeArgs,
                                   boolean fallback_target_isOld,
                                   LogExpr targetActions,
                                   boolean targetActions_isOld) {
        boolean t1_isOld =
          false;
        LogExpr t1 =
          new LogExpr(fallback_problem,
                      kodkod.ast.Variable.unary("t1"));
        boolean t2_isOld =
          false;
        LogExpr t2 =
          new LogExpr(fallback_problem,
                      kodkod.ast.Variable.unary("t2"));
        return LogExpr.quantifyOp(targetActions,
                                  false,
                                  "all",
                                  t1,
                                  LogExpr.quantifyOp(NewSchedule.actions_get_log(fallback_problem,
                                                                                 fallback_target,
                                                                                 fallback_targetTypeArgsStr,
                                                                                 fallback_targetTypeArgs,
                                                                                 fallback_target_isOld),
                                                     false,
                                                     "all",
                                                     t2,
                                                     t1.eq(t2).not()));
    }
    
    static LogExpr pureObjects_log(LogProblem fallback_problem,
                                   LogExpr fallback_target,
                                   String fallback_targetTypeArgsStr,
                                   String[] fallback_targetTypeArgs,
                                   boolean fallback_target_isOld) {
        boolean a_isOld =
          false;
        LogExpr quantVar_a =
          new LogExpr(fallback_problem,
                      kodkod.ast.Variable.unary("a"));
        LogExpr a =
          new LogExpr(fallback_problem,
                      quantVar_a.expr());
        LogExpr fallback_var_a =
          quantVar_a;
        boolean b_isOld =
          false;
        LogExpr quantVar_b =
          new LogExpr(fallback_problem,
                      kodkod.ast.Variable.unary("b"));
        LogExpr b =
          new LogExpr(fallback_problem,
                      quantVar_b.expr());
        LogExpr fallback_var_b =
          quantVar_b;
        return LogExpr.quantifyOp(PBJInternSet.toPBJInternSet_log(fallback_problem,
                                                                  PBJInternInteger.range_log(fallback_problem,
                                                                                             fallback_problem.class_log(PBJInternInteger.class),
                                                                                             "",
                                                                                             null,
                                                                                             fallback_target_isOld,
                                                                                             new LogExpr(fallback_problem,
                                                                                                         kodkod.ast.IntConstant.constant(0)),
                                                                                             fallback_target_isOld,
                                                                                             NewSchedule.size_get_log(fallback_problem,
                                                                                                                      fallback_target,
                                                                                                                      fallback_targetTypeArgsStr,
                                                                                                                      fallback_targetTypeArgs,
                                                                                                                      fallback_target_isOld).minus(new LogExpr(fallback_problem,
                                                                                                                                                               kodkod.ast.IntConstant.constant(1))),
                                                                                             fallback_target_isOld),
                                                                  "<java.lang.Integer>",
                                                                  new String[] { "java.lang.Integer" },
                                                                  fallback_target_isOld),
                                  false,
                                  "all",
                                  fallback_var_a,
                                  LogExpr.quantifyOp(PBJInternSet.toPBJInternSet_log(fallback_problem,
                                                                                     PBJInternInteger.range_log(fallback_problem,
                                                                                                                fallback_problem.class_log(PBJInternInteger.class),
                                                                                                                "",
                                                                                                                null,
                                                                                                                fallback_target_isOld,
                                                                                                                new LogExpr(fallback_problem,
                                                                                                                            kodkod.ast.IntConstant.constant(0)),
                                                                                                                fallback_target_isOld,
                                                                                                                NewSchedule.size_get_log(fallback_problem,
                                                                                                                                         fallback_target,
                                                                                                                                         fallback_targetTypeArgsStr,
                                                                                                                                         fallback_targetTypeArgs,
                                                                                                                                         fallback_target_isOld).minus(new LogExpr(fallback_problem,
                                                                                                                                                                                  kodkod.ast.IntConstant.constant(1))),
                                                                                                                fallback_target_isOld),
                                                                                     "<java.lang.Integer>",
                                                                                     new String[] { "java.lang.Integer" },
                                                                                     fallback_target_isOld),
                                                     false,
                                                     "all",
                                                     fallback_var_b,
                                                     a.eq(b).not().iff(NewSchedule.actions_get_log(fallback_problem,
                                                                                                   fallback_target,
                                                                                                   fallback_targetTypeArgsStr,
                                                                                                   fallback_targetTypeArgs,
                                                                                                   fallback_target_isOld).get_log(fallback_problem,
                                                                                                                                  a,
                                                                                                                                  false).eq(NewSchedule.actions_get_log(fallback_problem,
                                                                                                                                                                        fallback_target,
                                                                                                                                                                        fallback_targetTypeArgsStr,
                                                                                                                                                                        fallback_targetTypeArgs,
                                                                                                                                                                        fallback_target_isOld).get_log(fallback_problem,
                                                                                                                                                                                                       b,
                                                                                                                                                                                                       false)).not())));
    }
    
    static LogExpr preserveStateTransitions_log(LogProblem fallback_problem,
                                                LogExpr fallback_target,
                                                String fallback_targetTypeArgsStr,
                                                String[] fallback_targetTypeArgs,
                                                boolean fallback_target_isOld,
                                                LogExpr targetActions,
                                                boolean targetActions_isOld) {
        boolean targetTA_isOld =
          false;
        LogExpr targetTA =
          new LogExpr(fallback_problem,
                      kodkod.ast.Variable.unary("targetTA"));
        boolean localTA_isOld =
          false;
        LogExpr localTA =
          new LogExpr(fallback_problem,
                      kodkod.ast.Variable.unary("localTA"));
        return LogExpr.quantifyOp(targetActions,
                                  false,
                                  "all",
                                  targetTA,
                                  LogExpr.quantifyOp(NewSchedule.actions_get_log(fallback_problem,
                                                                                 fallback_target,
                                                                                 fallback_targetTypeArgsStr,
                                                                                 fallback_targetTypeArgs,
                                                                                 fallback_target_isOld),
                                                     false,
                                                     "some",
                                                     localTA,
                                                     TimedAction.startSize_get_log(fallback_problem,
                                                                                   localTA,
                                                                                   "",
                                                                                   null,
                                                                                   localTA_isOld).eq(TimedAction.startSize_get_log(fallback_problem,
                                                                                                                                   targetTA,
                                                                                                                                   "",
                                                                                                                                   null,
                                                                                                                                   targetTA_isOld)).and(TimedAction.targetSize_get_log(fallback_problem,
                                                                                                                                                                                       localTA,
                                                                                                                                                                                       "",
                                                                                                                                                                                       null,
                                                                                                                                                                                       localTA_isOld).eq(TimedAction.targetSize_get_log(fallback_problem,
                                                                                                                                                                                                                                        targetTA,
                                                                                                                                                                                                                                        "",
                                                                                                                                                                                                                                        null,
                                                                                                                                                                                                                                        targetTA_isOld))).and(TimedAction.time_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                       targetTA,
                                                                                                                                                                                                                                                                                       "",
                                                                                                                                                                                                                                                                                       null,
                                                                                                                                                                                                                                                                                       targetTA_isOld).gte(new LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                                                       kodkod.ast.IntConstant.constant(0))).implies(TimedAction.time_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                             localTA,
                                                                                                                                                                                                                                                                                                                                                                                             "",
                                                                                                                                                                                                                                                                                                                                                                                             null,
                                                                                                                                                                                                                                                                                                                                                                                             localTA_isOld).eq(TimedAction.time_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                        targetTA,
                                                                                                                                                                                                                                                                                                                                                                                                                                        "",
                                                                                                                                                                                                                                                                                                                                                                                                                                        null,
                                                                                                                                                                                                                                                                                                                                                                                                                                        targetTA_isOld))))));
    }
    
    static LogExpr validSchedule_log(LogProblem fallback_problem,
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
        boolean j_isOld =
          false;
        LogExpr quantVar_j =
          new LogExpr(fallback_problem,
                      kodkod.ast.Variable.unary("j"));
        LogExpr j =
          new LogExpr(fallback_problem,
                      quantVar_j.expr());
        LogExpr fallback_var_j =
          quantVar_j;
        return NewSchedule.actions_get_log(fallback_problem,
                                           fallback_target,
                                           fallback_targetTypeArgsStr,
                                           fallback_targetTypeArgs,
                                           fallback_target_isOld).no().not().and(NewSchedule.actions_get_log(fallback_problem,
                                                                                                             fallback_target,
                                                                                                             fallback_targetTypeArgsStr,
                                                                                                             fallback_targetTypeArgs,
                                                                                                             fallback_target_isOld).length_get_log(fallback_problem).eq(NewSchedule.size_get_log(fallback_problem,
                                                                                                                                                                                                 fallback_target,
                                                                                                                                                                                                 fallback_targetTypeArgsStr,
                                                                                                                                                                                                 fallback_targetTypeArgs,
                                                                                                                                                                                                 fallback_target_isOld))).and(LogExpr.quantifyOp(PBJInternSet.toPBJInternSet_log(fallback_problem,
                                                                                                                                                                                                                                                                                 PBJInternInteger.range_log(fallback_problem,
                                                                                                                                                                                                                                                                                                            fallback_problem.class_log(PBJInternInteger.class),
                                                                                                                                                                                                                                                                                                            "",
                                                                                                                                                                                                                                                                                                            null,
                                                                                                                                                                                                                                                                                                            fallback_target_isOld,
                                                                                                                                                                                                                                                                                                            new LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                                                        kodkod.ast.IntConstant.constant(0)),
                                                                                                                                                                                                                                                                                                            fallback_target_isOld,
                                                                                                                                                                                                                                                                                                            NewSchedule.size_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                     fallback_target,
                                                                                                                                                                                                                                                                                                                                     fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                     fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                     fallback_target_isOld).minus(new LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                              kodkod.ast.IntConstant.constant(1))),
                                                                                                                                                                                                                                                                                                            fallback_target_isOld),
                                                                                                                                                                                                                                                                                 "<java.lang.Integer>",
                                                                                                                                                                                                                                                                                 new String[] { "java.lang.Integer" },
                                                                                                                                                                                                                                                                                 fallback_target_isOld),
                                                                                                                                                                                                                                                 false,
                                                                                                                                                                                                                                                 "all",
                                                                                                                                                                                                                                                 fallback_var_i,
                                                                                                                                                                                                                                                 LogExpr.quantifyOp(PBJInternSet.toPBJInternSet_log(fallback_problem,
                                                                                                                                                                                                                                                                                                    PBJInternInteger.range_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                               fallback_problem.class_log(PBJInternInteger.class),
                                                                                                                                                                                                                                                                                                                               "",
                                                                                                                                                                                                                                                                                                                               null,
                                                                                                                                                                                                                                                                                                                               fallback_target_isOld,
                                                                                                                                                                                                                                                                                                                               new LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                                                                           kodkod.ast.IntConstant.constant(0)),
                                                                                                                                                                                                                                                                                                                               fallback_target_isOld,
                                                                                                                                                                                                                                                                                                                               NewSchedule.size_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                        fallback_target,
                                                                                                                                                                                                                                                                                                                                                        fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                        fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                        fallback_target_isOld).minus(new LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                 kodkod.ast.IntConstant.constant(1))),
                                                                                                                                                                                                                                                                                                                               fallback_target_isOld),
                                                                                                                                                                                                                                                                                                    "<java.lang.Integer>",
                                                                                                                                                                                                                                                                                                    new String[] { "java.lang.Integer" },
                                                                                                                                                                                                                                                                                                    fallback_target_isOld),
                                                                                                                                                                                                                                                                    false,
                                                                                                                                                                                                                                                                    "all",
                                                                                                                                                                                                                                                                    fallback_var_j,
                                                                                                                                                                                                                                                                    i.lte(j).implies(TimedAction.time_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                              NewSchedule.actions_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                          fallback_target,
                                                                                                                                                                                                                                                                                                                                          fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                          fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                          fallback_target_isOld).get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                         i,
                                                                                                                                                                                                                                                                                                                                                                         false),
                                                                                                                                                                                                                                                                                                              "",
                                                                                                                                                                                                                                                                                                              null,
                                                                                                                                                                                                                                                                                                              fallback_target_isOld).lte(TimedAction.time_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                  NewSchedule.actions_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                              fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                              fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                              fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                              fallback_target_isOld).get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                             j,
                                                                                                                                                                                                                                                                                                                                                                                                                             false),
                                                                                                                                                                                                                                                                                                                                                                  "",
                                                                                                                                                                                                                                                                                                                                                                  null,
                                                                                                                                                                                                                                                                                                                                                                  fallback_target_isOld))))));
    }
    
    static LogExpr atMost_log(LogProblem fallback_problem,
                              LogExpr fallback_target,
                              String fallback_targetTypeArgsStr,
                              String[] fallback_targetTypeArgs,
                              boolean fallback_target_isOld,
                              LogExpr maxDuration,
                              boolean maxDuration_isOld) {
        return TimedAction.time_get_log(fallback_problem,
                                        NewSchedule.actions_get_log(fallback_problem,
                                                                    fallback_target,
                                                                    fallback_targetTypeArgsStr,
                                                                    fallback_targetTypeArgs,
                                                                    fallback_target_isOld).get_log(fallback_problem,
                                                                                                   NewSchedule.size_get_log(fallback_problem,
                                                                                                                            fallback_target,
                                                                                                                            fallback_targetTypeArgsStr,
                                                                                                                            fallback_targetTypeArgs,
                                                                                                                            fallback_target_isOld).minus(new LogExpr(fallback_problem,
                                                                                                                                                                     kodkod.ast.IntConstant.constant(1))),
                                                                                                   false),
                                        "",
                                        null,
                                        fallback_target_isOld).lte(maxDuration);
    }
    
    static LogExpr atLeast_log(LogProblem fallback_problem,
                               LogExpr fallback_target,
                               String fallback_targetTypeArgsStr,
                               String[] fallback_targetTypeArgs,
                               boolean fallback_target_isOld,
                               LogExpr minDuration,
                               boolean minDuration_isOld) {
        return TimedAction.time_get_log(fallback_problem,
                                        NewSchedule.actions_get_log(fallback_problem,
                                                                    fallback_target,
                                                                    fallback_targetTypeArgsStr,
                                                                    fallback_targetTypeArgs,
                                                                    fallback_target_isOld).get_log(fallback_problem,
                                                                                                   NewSchedule.size_get_log(fallback_problem,
                                                                                                                            fallback_target,
                                                                                                                            fallback_targetTypeArgsStr,
                                                                                                                            fallback_targetTypeArgs,
                                                                                                                            fallback_target_isOld).minus(new LogExpr(fallback_problem,
                                                                                                                                                                     kodkod.ast.IntConstant.constant(1))),
                                                                                                   false),
                                        "",
                                        null,
                                        fallback_target_isOld).gte(minDuration);
    }
    
    static LogExpr exactly_log(LogProblem fallback_problem,
                               LogExpr fallback_target,
                               String fallback_targetTypeArgsStr,
                               String[] fallback_targetTypeArgs,
                               boolean fallback_target_isOld,
                               LogExpr duration,
                               boolean duration_isOld) {
        return TimedAction.time_get_log(fallback_problem,
                                        NewSchedule.actions_get_log(fallback_problem,
                                                                    fallback_target,
                                                                    fallback_targetTypeArgsStr,
                                                                    fallback_targetTypeArgs,
                                                                    fallback_target_isOld).get_log(fallback_problem,
                                                                                                   NewSchedule.size_get_log(fallback_problem,
                                                                                                                            fallback_target,
                                                                                                                            fallback_targetTypeArgsStr,
                                                                                                                            fallback_targetTypeArgs,
                                                                                                                            fallback_target_isOld).minus(new LogExpr(fallback_problem,
                                                                                                                                                                     kodkod.ast.IntConstant.constant(1))),
                                                                                                   false),
                                        "",
                                        null,
                                        fallback_target_isOld).eq(duration);
    }
    
    static LogExpr stateConsistency_log(LogProblem fallback_problem,
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
        return LogExpr.quantifyOp(PBJInternSet.toPBJInternSet_log(fallback_problem,
                                                                  PBJInternInteger.range_log(fallback_problem,
                                                                                             fallback_problem.class_log(PBJInternInteger.class),
                                                                                             "",
                                                                                             null,
                                                                                             fallback_target_isOld,
                                                                                             new LogExpr(fallback_problem,
                                                                                                         kodkod.ast.IntConstant.constant(0)),
                                                                                             fallback_target_isOld,
                                                                                             NewSchedule.actions_get_log(fallback_problem,
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
                                  i.eq(new LogExpr(fallback_problem,
                                                   kodkod.ast.IntConstant.constant(0))).implies(TimedAction.targetSize_get_log(fallback_problem,
                                                                                                                               NewSchedule.actions_get_log(fallback_problem,
                                                                                                                                                           fallback_target,
                                                                                                                                                           fallback_targetTypeArgsStr,
                                                                                                                                                           fallback_targetTypeArgs,
                                                                                                                                                           fallback_target_isOld).get_log(fallback_problem,
                                                                                                                                                                                          i,
                                                                                                                                                                                          false),
                                                                                                                               "",
                                                                                                                               null,
                                                                                                                               fallback_target_isOld).eq(TimedAction.startSize_get_log(fallback_problem,
                                                                                                                                                                                       NewSchedule.actions_get_log(fallback_problem,
                                                                                                                                                                                                                   fallback_target,
                                                                                                                                                                                                                   fallback_targetTypeArgsStr,
                                                                                                                                                                                                                   fallback_targetTypeArgs,
                                                                                                                                                                                                                   fallback_target_isOld).get_log(fallback_problem,
                                                                                                                                                                                                                                                  i.plus(new LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                     kodkod.ast.IntConstant.constant(1))),
                                                                                                                                                                                                                                                  false),
                                                                                                                                                                                       "",
                                                                                                                                                                                       null,
                                                                                                                                                                                       fallback_target_isOld))).and(i.gt(new LogExpr(fallback_problem,
                                                                                                                                                                                                                                     kodkod.ast.IntConstant.constant(0))).and(i.lt(NewSchedule.actions_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                               fallback_target,
                                                                                                                                                                                                                                                                                                               fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                               fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                               fallback_target_isOld).length_get_log(fallback_problem).minus(new LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                         kodkod.ast.IntConstant.constant(1))))).implies(TimedAction.startSize_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                      NewSchedule.actions_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  fallback_target_isOld).get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 i,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 false),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                      "",
                                                                                                                                                                                                                                                                                                                                                                                                                                                                      null,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                      fallback_target_isOld).eq(TimedAction.targetSize_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               NewSchedule.actions_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           fallback_target_isOld).get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          i.minus(new LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              kodkod.ast.IntConstant.constant(1))),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          false),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               "",
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               null,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               fallback_target_isOld)).and(TimedAction.targetSize_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          NewSchedule.actions_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      fallback_target_isOld).get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     i,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     false),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          "",
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          null,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          fallback_target_isOld).eq(TimedAction.startSize_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  NewSchedule.actions_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              fallback_target_isOld).get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             i.plus(new LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                kodkod.ast.IntConstant.constant(1))),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             false),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  "",
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  null,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  fallback_target_isOld))))).and(i.eq(NewSchedule.actions_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  fallback_target_isOld).length_get_log(fallback_problem).minus(new LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            kodkod.ast.IntConstant.constant(1)))).implies(TimedAction.startSize_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        NewSchedule.actions_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    fallback_target_isOld).get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   i,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   false),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        "",
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        null,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        fallback_target_isOld).eq(TimedAction.targetSize_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 NewSchedule.actions_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             fallback_target_isOld).get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            i.minus(new LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                kodkod.ast.IntConstant.constant(1))),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            false),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 "",
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 null,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 fallback_target_isOld)))));
    }
    
    public static LogExpr fallback_checkInvariants_log(LogProblem fallback_problem,
                                                       LogExpr fallback_target,
                                                       String fallback_targetTypeArgsStr,
                                                       String[] fallback_targetTypeArgs,
                                                       boolean fallback_target_isOld) {
        return NewSchedule.classInvariant_log(fallback_problem,
                                              fallback_target,
                                              fallback_targetTypeArgsStr,
                                              fallback_targetTypeArgs,
                                              fallback_target_isOld);
    }
    
    public static LogExpr positiveSizeH_checkContract_log(LogProblem fallback_problem,
                                                          LogExpr fallback_target,
                                                          String fallback_targetTypeArgsStr,
                                                          String[] fallback_targetTypeArgs,
                                                          boolean fallback_target_isOld) {
        return NewSchedule.fallback_checkInvariants_log(fallback_problem,
                                                        fallback_target,
                                                        fallback_targetTypeArgsStr,
                                                        fallback_targetTypeArgs,
                                                        fallback_target_isOld).and(NewSchedule.positiveSizeH_checkFieldsInvariants_log(fallback_problem,
                                                                                                                                       fallback_target,
                                                                                                                                       fallback_targetTypeArgsStr,
                                                                                                                                       fallback_targetTypeArgs,
                                                                                                                                       fallback_target_isOld)).and(NewSchedule.size_get_log(fallback_problem,
                                                                                                                                                                                            fallback_target,
                                                                                                                                                                                            fallback_targetTypeArgsStr,
                                                                                                                                                                                            fallback_targetTypeArgs,
                                                                                                                                                                                            fallback_target_isOld).gt(new LogExpr(fallback_problem,
                                                                                                                                                                                                                                  kodkod.ast.IntConstant.constant(0))).and(NewSchedule.size_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                    fallback_target,
                                                                                                                                                                                                                                                                                                    fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                    fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                    fallback_target_isOld).lte(NewSchedule.MAX_SIZE_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                            fallback_target,
                                                                                                                                                                                                                                                                                                                                                            fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                            fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                            fallback_target_isOld))));
    }
    
    public static LogExpr positiveSizeH_checkFieldsInvariants_log(LogProblem fallback_problem,
                                                                  LogExpr fallback_target,
                                                                  String fallback_targetTypeArgsStr,
                                                                  String[] fallback_targetTypeArgs,
                                                                  boolean fallback_target_isOld) {
        return new LogExpr(fallback_problem,
                           kodkod.ast.Formula.TRUE);
    }
    
    public static LogExpr initH_checkContract_log(LogProblem fallback_problem,
                                                  LogExpr fallback_target,
                                                  String fallback_targetTypeArgsStr,
                                                  String[] fallback_targetTypeArgs,
                                                  boolean fallback_target_isOld) {
        return NewSchedule.fallback_checkInvariants_log(fallback_problem,
                                                        fallback_target,
                                                        fallback_targetTypeArgsStr,
                                                        fallback_targetTypeArgs,
                                                        fallback_target_isOld).and(NewSchedule.initH_checkFieldsInvariants_log(fallback_problem,
                                                                                                                               fallback_target,
                                                                                                                               fallback_targetTypeArgsStr,
                                                                                                                               fallback_targetTypeArgs,
                                                                                                                               fallback_target_isOld)).and(NewSchedule.initSpec_log(fallback_problem,
                                                                                                                                                                                    fallback_target,
                                                                                                                                                                                    fallback_targetTypeArgsStr,
                                                                                                                                                                                    fallback_targetTypeArgs,
                                                                                                                                                                                    fallback_target_isOld).and(NewSchedule.pureObjects_log(fallback_problem,
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
    
    public static LogExpr initH_TimedAction_checkContract_log(LogProblem fallback_problem,
                                                              LogExpr fallback_target,
                                                              String fallback_targetTypeArgsStr,
                                                              String[] fallback_targetTypeArgs,
                                                              boolean fallback_target_isOld,
                                                              LogExpr targetActions,
                                                              boolean targetActions_isOld) {
        return NewSchedule.fallback_checkInvariants_log(fallback_problem,
                                                        fallback_target,
                                                        fallback_targetTypeArgsStr,
                                                        fallback_targetTypeArgs,
                                                        fallback_target_isOld).and(NewSchedule.initH_TimedAction_checkFieldsInvariants_log(fallback_problem,
                                                                                                                                           fallback_target,
                                                                                                                                           fallback_targetTypeArgsStr,
                                                                                                                                           fallback_targetTypeArgs,
                                                                                                                                           fallback_target_isOld)).and(NewSchedule.pureObjects_log(fallback_problem,
                                                                                                                                                                                                   fallback_target,
                                                                                                                                                                                                   fallback_targetTypeArgsStr,
                                                                                                                                                                                                   fallback_targetTypeArgs,
                                                                                                                                                                                                   fallback_target_isOld,
                                                                                                                                                                                                   targetActions,
                                                                                                                                                                                                   targetActions_isOld).and(NewSchedule.preserveStateTransitions_log(fallback_problem,
                                                                                                                                                                                                                                                                     fallback_target,
                                                                                                                                                                                                                                                                     fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                     fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                     fallback_target_isOld,
                                                                                                                                                                                                                                                                     targetActions,
                                                                                                                                                                                                                                                                     targetActions_isOld)).and(NewSchedule.initSpec_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                        fallback_target,
                                                                                                                                                                                                                                                                                                                        fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                        fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                        fallback_target_isOld)));
    }
    
    public static LogExpr initH_TimedAction_checkFieldsInvariants_log(LogProblem fallback_problem,
                                                                      LogExpr fallback_target,
                                                                      String fallback_targetTypeArgsStr,
                                                                      String[] fallback_targetTypeArgs,
                                                                      boolean fallback_target_isOld) {
        return new LogExpr(fallback_problem,
                           kodkod.ast.Formula.TRUE);
    }
    
    public static LogExpr withDuration_int_checkContract_log(LogProblem fallback_problem,
                                                             LogExpr fallback_target,
                                                             String fallback_targetTypeArgsStr,
                                                             String[] fallback_targetTypeArgs,
                                                             boolean fallback_target_isOld,
                                                             LogExpr duration,
                                                             boolean duration_isOld) {
        return NewSchedule.fallback_checkInvariants_log(fallback_problem,
                                                        fallback_target,
                                                        fallback_targetTypeArgsStr,
                                                        fallback_targetTypeArgs,
                                                        fallback_target_isOld).and(NewSchedule.withDuration_int_checkFieldsInvariants_log(fallback_problem,
                                                                                                                                          fallback_target,
                                                                                                                                          fallback_targetTypeArgsStr,
                                                                                                                                          fallback_targetTypeArgs,
                                                                                                                                          fallback_target_isOld)).and(NewSchedule.exactly_log(fallback_problem,
                                                                                                                                                                                              fallback_target,
                                                                                                                                                                                              fallback_targetTypeArgsStr,
                                                                                                                                                                                              fallback_targetTypeArgs,
                                                                                                                                                                                              fallback_target_isOld,
                                                                                                                                                                                              duration,
                                                                                                                                                                                              duration_isOld).and(NewSchedule.validSchedule_log(fallback_problem,
                                                                                                                                                                                                                                                fallback_target,
                                                                                                                                                                                                                                                fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                fallback_targetTypeArgs,
                                                                                                                                                                                                                                                fallback_target_isOld)));
    }
    
    public static LogExpr withDuration_int_checkFieldsInvariants_log(LogProblem fallback_problem,
                                                                     LogExpr fallback_target,
                                                                     String fallback_targetTypeArgsStr,
                                                                     String[] fallback_targetTypeArgs,
                                                                     boolean fallback_target_isOld) {
        return new LogExpr(fallback_problem,
                           kodkod.ast.Formula.TRUE);
    }
    
    public static LogExpr withMaxDuration_int_checkContract_log(LogProblem fallback_problem,
                                                                LogExpr fallback_target,
                                                                String fallback_targetTypeArgsStr,
                                                                String[] fallback_targetTypeArgs,
                                                                boolean fallback_target_isOld,
                                                                LogExpr maxDuration,
                                                                boolean maxDuration_isOld) {
        return NewSchedule.fallback_checkInvariants_log(fallback_problem,
                                                        fallback_target,
                                                        fallback_targetTypeArgsStr,
                                                        fallback_targetTypeArgs,
                                                        fallback_target_isOld).and(NewSchedule.withMaxDuration_int_checkFieldsInvariants_log(fallback_problem,
                                                                                                                                             fallback_target,
                                                                                                                                             fallback_targetTypeArgsStr,
                                                                                                                                             fallback_targetTypeArgs,
                                                                                                                                             fallback_target_isOld)).and(NewSchedule.atMost_log(fallback_problem,
                                                                                                                                                                                                fallback_target,
                                                                                                                                                                                                fallback_targetTypeArgsStr,
                                                                                                                                                                                                fallback_targetTypeArgs,
                                                                                                                                                                                                fallback_target_isOld,
                                                                                                                                                                                                maxDuration,
                                                                                                                                                                                                maxDuration_isOld).and(NewSchedule.validSchedule_log(fallback_problem,
                                                                                                                                                                                                                                                     fallback_target,
                                                                                                                                                                                                                                                     fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                     fallback_targetTypeArgs,
                                                                                                                                                                                                                                                     fallback_target_isOld)));
    }
    
    public static LogExpr withMaxDuration_int_checkFieldsInvariants_log(LogProblem fallback_problem,
                                                                        LogExpr fallback_target,
                                                                        String fallback_targetTypeArgsStr,
                                                                        String[] fallback_targetTypeArgs,
                                                                        boolean fallback_target_isOld) {
        return new LogExpr(fallback_problem,
                           kodkod.ast.Formula.TRUE);
    }
    
    public static LogExpr withMinDuration_int_checkContract_log(LogProblem fallback_problem,
                                                                LogExpr fallback_target,
                                                                String fallback_targetTypeArgsStr,
                                                                String[] fallback_targetTypeArgs,
                                                                boolean fallback_target_isOld,
                                                                LogExpr minDuration,
                                                                boolean minDuration_isOld) {
        return NewSchedule.fallback_checkInvariants_log(fallback_problem,
                                                        fallback_target,
                                                        fallback_targetTypeArgsStr,
                                                        fallback_targetTypeArgs,
                                                        fallback_target_isOld).and(NewSchedule.withMinDuration_int_checkFieldsInvariants_log(fallback_problem,
                                                                                                                                             fallback_target,
                                                                                                                                             fallback_targetTypeArgsStr,
                                                                                                                                             fallback_targetTypeArgs,
                                                                                                                                             fallback_target_isOld)).and(NewSchedule.atLeast_log(fallback_problem,
                                                                                                                                                                                                 fallback_target,
                                                                                                                                                                                                 fallback_targetTypeArgsStr,
                                                                                                                                                                                                 fallback_targetTypeArgs,
                                                                                                                                                                                                 fallback_target_isOld,
                                                                                                                                                                                                 minDuration,
                                                                                                                                                                                                 minDuration_isOld).and(NewSchedule.validSchedule_log(fallback_problem,
                                                                                                                                                                                                                                                      fallback_target,
                                                                                                                                                                                                                                                      fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                      fallback_targetTypeArgs,
                                                                                                                                                                                                                                                      fallback_target_isOld)));
    }
    
    public static LogExpr withMinDuration_int_checkFieldsInvariants_log(LogProblem fallback_problem,
                                                                        LogExpr fallback_target,
                                                                        String fallback_targetTypeArgsStr,
                                                                        String[] fallback_targetTypeArgs,
                                                                        boolean fallback_target_isOld) {
        return new LogExpr(fallback_problem,
                           kodkod.ast.Formula.TRUE);
    }
    
    public static LogExpr withDurationInBetween_int_int_checkContract_log(LogProblem fallback_problem,
                                                                          LogExpr fallback_target,
                                                                          String fallback_targetTypeArgsStr,
                                                                          String[] fallback_targetTypeArgs,
                                                                          boolean fallback_target_isOld,
                                                                          LogExpr minDuration,
                                                                          boolean minDuration_isOld,
                                                                          LogExpr maxDuration,
                                                                          boolean maxDuration_isOld) {
        return NewSchedule.fallback_checkInvariants_log(fallback_problem,
                                                        fallback_target,
                                                        fallback_targetTypeArgsStr,
                                                        fallback_targetTypeArgs,
                                                        fallback_target_isOld).and(NewSchedule.withDurationInBetween_int_int_checkFieldsInvariants_log(fallback_problem,
                                                                                                                                                       fallback_target,
                                                                                                                                                       fallback_targetTypeArgsStr,
                                                                                                                                                       fallback_targetTypeArgs,
                                                                                                                                                       fallback_target_isOld)).and(minDuration.lt(maxDuration).and(NewSchedule.atLeast_log(fallback_problem,
                                                                                                                                                                                                                                           fallback_target,
                                                                                                                                                                                                                                           fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                           fallback_targetTypeArgs,
                                                                                                                                                                                                                                           fallback_target_isOld,
                                                                                                                                                                                                                                           minDuration,
                                                                                                                                                                                                                                           minDuration_isOld)).and(NewSchedule.atMost_log(fallback_problem,
                                                                                                                                                                                                                                                                                          fallback_target,
                                                                                                                                                                                                                                                                                          fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                          fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                          fallback_target_isOld,
                                                                                                                                                                                                                                                                                          maxDuration,
                                                                                                                                                                                                                                                                                          maxDuration_isOld)).or(minDuration.gt(maxDuration).and(NewSchedule.atLeast_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                         fallback_target,
                                                                                                                                                                                                                                                                                                                                                                         fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                         fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                         fallback_target_isOld,
                                                                                                                                                                                                                                                                                                                                                                         maxDuration,
                                                                                                                                                                                                                                                                                                                                                                         maxDuration_isOld)).and(NewSchedule.atMost_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                        fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                        fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                        fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                        fallback_target_isOld,
                                                                                                                                                                                                                                                                                                                                                                                                                        minDuration,
                                                                                                                                                                                                                                                                                                                                                                                                                        minDuration_isOld))).or(minDuration.lt(maxDuration).and(NewSchedule.exactly_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        fallback_target_isOld,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        minDuration,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        minDuration_isOld))));
    }
    
    public static LogExpr withDurationInBetween_int_int_checkFieldsInvariants_log(LogProblem fallback_problem,
                                                                                  LogExpr fallback_target,
                                                                                  String fallback_targetTypeArgsStr,
                                                                                  String[] fallback_targetTypeArgs,
                                                                                  boolean fallback_target_isOld) {
        return new LogExpr(fallback_problem,
                           kodkod.ast.Formula.TRUE);
    }
    
    public static LogExpr doForceStateConsistency_checkContract_log(LogProblem fallback_problem,
                                                                    LogExpr fallback_target,
                                                                    String fallback_targetTypeArgsStr,
                                                                    String[] fallback_targetTypeArgs,
                                                                    boolean fallback_target_isOld) {
        boolean t_isOld =
          false;
        LogExpr t =
          new LogExpr(fallback_problem,
                      kodkod.ast.Variable.unary("t"));
        return NewSchedule.fallback_checkInvariants_log(fallback_problem,
                                                        fallback_target,
                                                        fallback_targetTypeArgsStr,
                                                        fallback_targetTypeArgs,
                                                        fallback_target_isOld).and(NewSchedule.doForceStateConsistency_checkFieldsInvariants_log(fallback_problem,
                                                                                                                                                 fallback_target,
                                                                                                                                                 fallback_targetTypeArgsStr,
                                                                                                                                                 fallback_targetTypeArgs,
                                                                                                                                                 fallback_target_isOld)).and(NewSchedule.actions_get_log(fallback_problem,
                                                                                                                                                                                                         fallback_target,
                                                                                                                                                                                                         fallback_targetTypeArgsStr,
                                                                                                                                                                                                         fallback_targetTypeArgs,
                                                                                                                                                                                                         fallback_target_isOld).length_get_log(fallback_problem).gt(new LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                kodkod.ast.IntConstant.constant(1))).implies(NewSchedule.stateConsistency_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                              fallback_target,
                                                                                                                                                                                                                                                                                                                                                              fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                              fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                              fallback_target_isOld)).and(LogExpr.quantifyOp(NewSchedule.actions_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                         fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                         fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                         fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                         fallback_target_isOld),
                                                                                                                                                                                                                                                                                                                                                                                                             false,
                                                                                                                                                                                                                                                                                                                                                                                                             "all",
                                                                                                                                                                                                                                                                                                                                                                                                             t,
                                                                                                                                                                                                                                                                                                                                                                                                             TimedAction.valid_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                   t,
                                                                                                                                                                                                                                                                                                                                                                                                                                   "",
                                                                                                                                                                                                                                                                                                                                                                                                                                   null,
                                                                                                                                                                                                                                                                                                                                                                                                                                   t_isOld))));
    }
    
    public static LogExpr doForceStateConsistency_checkFieldsInvariants_log(LogProblem fallback_problem,
                                                                            LogExpr fallback_target,
                                                                            String fallback_targetTypeArgsStr,
                                                                            String[] fallback_targetTypeArgs,
                                                                            boolean fallback_target_isOld) {
        return new LogExpr(fallback_problem,
                           kodkod.ast.Formula.TRUE);
    }
}
