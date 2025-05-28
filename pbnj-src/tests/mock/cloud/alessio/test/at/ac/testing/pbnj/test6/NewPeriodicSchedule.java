package at.ac.testing.pbnj.test6;

import polyglot.ext.pbnj.tologic.*;
import polyglot.ext.pbnj.primitives.*;
import pbnj.util.ArrayList;
import java.util.Arrays;

public class NewPeriodicSchedule implements PBJInternObject {
    public int MAX_SIZE =
      10;
    
    public int size;
    
    public int duration;
    
    public TimedAction[] actions;
    
    public TimedAction[] inputActions;
    
    int[] TEMP_VAR;
    
    Interval[] intervals;
    
    public int minDuration =
      -1;
    
    public int maxDuration =
      -1;
    
    public boolean forceConcurrentActions =
      false;
    
    public boolean avoidConcurrentActions =
      false;
    
    public boolean forceSustainedActions =
      false;
    
    public boolean avoidSustainedActions =
      false;
    
    public boolean forceBlips =
      false;
    
    public boolean avoidBlips =
      false;
    
    public boolean forceStateConsistency =
      false;
    
    public boolean forceVariability =
      false;
    
    int stabilityPeriodUp;
    
    int stabilityPeriodDown;
    
    int controlPeriod;
    
    int actuationDelay;
    
    int monitoringPeriod;
    
    boolean timeOrdering() {
        return actions[0].time >
                 0 &&
          timeOrdering_univQuantify_1();
    }
    
    public NewPeriodicSchedule(int monitoringPeriod,
                               int stabilityPeriodUp,
                               int stabilityPeriodDown,
                               int controlPeriod,
                               int actuationDelay) {
        super();
        this.monitoringPeriod =
          monitoringPeriod;
        this.stabilityPeriodUp =
          stabilityPeriodUp;
        this.stabilityPeriodDown =
          stabilityPeriodDown;
        this.controlPeriod =
          controlPeriod;
        this.actuationDelay =
          actuationDelay;
        this.addInstance();
    }
    
    private String prettyPrint(TimedAction[] theActions) {
        String output =
          "\n";
        output =
          output +
          "\tTime : Action     \t [Sta --> End]\t (HashCode)\n";
        for (int i =
               0;
             i <
               theActions.length;
             i++) {
            output =
              output +
              "\t" +
              theActions[i].toString() +
              "\n";
        }
        return output;
    }
    
    public void printTriggerActions() {
        findTheIntervals();
        while (this.intervals.length >
                 0) {
            findNextTrigger();
        }
    }
    
    public void findTheIntervals_orig() {
        
    }
    
    boolean findIntervals() {
        return findIntervals_univQuantify_3() &&
                 findIntervals_univQuantify_4() &&
          findIntervals_univQuantify_6();
    }
    
    boolean noSameStart(Interval i) {
        return noSameStart_univQuantify_7(i);
    }
    
    boolean orderedIntervals() {
        return !(this.intervals.length >
                   1) ||
          orderedIntervals_univQuantify_9();
    }
    
    void findNextTrigger_orig() {
        
    }
    
    public void updateTypes_orig() {
        
    }
    
    public String toString() {
        return "Schedule : \n" +
               "\tSize " +
               size +
               " (" +
               MAX_SIZE +
               ")\n" +
               "\tDuration " +
               duration +
               "\n" +
               "\tMonitoringPeriod " +
               monitoringPeriod +
               "\n" +
               "\tControlPeriod " +
               controlPeriod +
               "\n" +
               "\tStabilityPeriod Up/Down " +
               stabilityPeriodUp +
               "/" +
               stabilityPeriodDown +
               "\n" +
               (inputActions !=
                  null ? "\tInputs " +
                         Arrays.toString(inputActions) +
                         "\n" : "") +
               (TEMP_VAR !=
                  null ? "\tSTATE VAR " +
                         Arrays.toString(TEMP_VAR) +
                         "\n" : "") +
               "\tElements: \n" +
               (actions !=
                  null ? prettyPrint(actions) +
                         "\n" : "null\n") +
               "\t CONFIGURATION : \n" +
               "\t\t Min/Max duration " +
               this.minDuration +
               "/" +
               this.maxDuration +
               "\n" +
               "\t\t force/avoid concurrency " +
               this.forceConcurrentActions +
               "/" +
               this.avoidConcurrentActions +
               "\n" +
               "\t\t force/avoid sustained actions " +
               this.forceSustainedActions +
               "/" +
               this.avoidSustainedActions +
               "\n" +
               "\t\t force/avoid blips " +
               this.forceBlips +
               "/" +
               this.avoidBlips +
               "\n" +
               "\t\t force state consistency " +
               this.forceStateConsistency +
               "\n" +
               "Potentially Unstable Intervals: \n" +
        (this.intervals !=
           null ? Arrays.toString(this.intervals) +
                  "\n" : "none/null\n");
    }
    
    public NewPeriodicSchedule old;
    
    public boolean fallback_pbnj;
    
    Object fallback_field_result;
    
    public void fallback_field_result(Object r) {
        this.fallback_field_result =
          r;
    }
    
    public NewPeriodicSchedule(LogExpr dontcare) {
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
        LogMap.addInstance(NewPeriodicSchedule.class,
                           this);
    }
    
    public void addInstanceForProblem(NewPeriodicSchedule toAdd,
                                      LogProblem fallback_problem,
                                      String fallback_targetTypeArgsStr) {
        fallback_problem.addToClassInstances(toAdd,
                                             NewPeriodicSchedule.class,
                                             "at.ac.testing.pbnj.test6.NewPeriodicSchedule",
                                             fallback_targetTypeArgsStr);
    }
    
    long startMethodTime;
    
    boolean isOld;
    
    Object fallback_consistencyLock;
    
    int fallback_updateTime;
    
    public NewPeriodicSchedule old() {
        return this.old;
    }
    
    String[] fallback_typeArgs;
    
    public NewPeriodicSchedule fallback_setTypeArgs(String[] args) {
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
        return NewPeriodicSchedule.classRelationizerStep ==
          fallback_problem.relationizerStep();
    }
    
    public static int classAtomizerStep =
      0;
    
    public static boolean isClassAtomized(LogProblem fallback_problem) {
        return NewPeriodicSchedule.classAtomizerStep ==
          fallback_problem.relationizerStep();
    }
    
    public static int classClonerStep =
      0;
    
    public static boolean isClassCloned() {
        return NewPeriodicSchedule.classClonerStep ==
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
    
    public boolean findTheIntervals_checkContract() {
        return this.fallback_checkInvariants() &&
                 this.findTheIntervals_checkFieldsInvariants() &&
          (this.intervals !=
             null &&
             findIntervals() &&
             orderedIntervals());
    }
    
    public void findTheIntervals_assertContract() {
        assert findTheIntervals_checkContract();
    }
    
    public void findTheIntervals_commitModel(LogProblem fallback_problem) {
        fallback_problem.commitModel(this);
    }
    
    LogProblem findTheIntervals_planb() {
        System.out.println("\n" +
                             (this +
                                (" (" +
                                   (Thread.currentThread() +
                                      (": findTheIntervals" +
                                         ") initiated plan b...")))));
        Interval.fallback_initClassDefs();
        LogProblem fallback_problem =
          LogMap.initRelationize();
        String fallback_targetTypeArgsStr =
          "";
        String[] fallback_targetTypeArgs =
          null;
        fallback_problem.newFreshInstances();
        fallback_problem.setFreshInstances("at.ac.testing.pbnj.test6.Interval",
                                           this.actions.length);
        old.fallback_atomize(fallback_problem,
                             "",
                             null);
        Interval.fallback_classClone();
        Interval.fallback_classAtomize(fallback_problem,
                                       fallback_targetTypeArgsStr,
                                       fallback_targetTypeArgs);
        fallback_problem.ObjToAtomMap();
        old.fallback_relationizeOld(fallback_problem,
                                    "",
                                    null);
        Interval.fallback_classRelationizeOld(fallback_problem,
                                              fallback_targetTypeArgsStr,
                                              fallback_targetTypeArgs);
        fallback_problem.initRelations();
        fallback_problem.newModifiableFields();
        fallback_problem.setModifiableField("at.ac.testing.pbnj.test6.NewPeriodicSchedule.intervals");
        LogExpr fallback_target =
          fallback_problem.objToSingletonRelation_log(this);
        boolean fallback_target_isOld =
          false;
        LogExpr fallback_formula =
          NewPeriodicSchedule.findTheIntervals_checkContract_log(fallback_problem,
                                                                 fallback_target,
                                                                 fallback_targetTypeArgsStr,
                                                                 fallback_targetTypeArgs,
                                                                 fallback_target_isOld);
        boolean isSatisfiable =
          fallback_problem.solve("findTheIntervals",
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
    
    public void findTheIntervals() {
        findTheIntervals_ensured();
    }
    
    public void findTheIntervals_ensured() {
        initEnsuredMethod();
        try {
            findTheIntervals_orig();
            findTheIntervals_assertContract();
        }
        catch (Throwable rte) {
            {
                rte.printStackTrace();
                LogProblem fallback_problem =
                  findTheIntervals_planb();
                findTheIntervals_commitModel(fallback_problem);
            }
        }
    }
    
    public boolean findTheIntervals_checkFieldsInvariants() {
        return true;
    }
    
    public boolean findNextTrigger_checkContract() {
        return this.fallback_checkInvariants() &&
                 this.findNextTrigger_checkFieldsInvariants() &&
          (this.intervals.length ==
             this.old.intervals.length -
               1 &&
             (!(this.intervals.length >
                  1) ||
                findNextTrigger_checkContract_univQuantify_11()) &&
             (!(this.intervals.length >
                  0) ||
                findNextTrigger_checkContract_univQuantify_12()));
    }
    
    public void findNextTrigger_assertContract() {
        assert findNextTrigger_checkContract();
    }
    
    public void findNextTrigger_commitModel(LogProblem fallback_problem) {
        fallback_problem.commitModel(this);
    }
    
    LogProblem findNextTrigger_planb() {
        System.out.println("\n" +
                             (this +
                                (" (" +
                                   (Thread.currentThread() +
                                      (": findNextTrigger" +
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
        fallback_problem.setModifiableField("at.ac.testing.pbnj.test6.NewPeriodicSchedule.intervals");
        LogExpr fallback_target =
          fallback_problem.objToSingletonRelation_log(this);
        boolean fallback_target_isOld =
          false;
        LogExpr fallback_formula =
          NewPeriodicSchedule.findNextTrigger_checkContract_log(fallback_problem,
                                                                fallback_target,
                                                                fallback_targetTypeArgsStr,
                                                                fallback_targetTypeArgs,
                                                                fallback_target_isOld);
        boolean isSatisfiable =
          fallback_problem.solve("findNextTrigger",
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
    
    void findNextTrigger() {
        findNextTrigger_ensured();
    }
    
    void findNextTrigger_ensured() {
        initEnsuredMethod();
        try {
            findNextTrigger_orig();
            findNextTrigger_assertContract();
        }
        catch (Throwable rte) {
            {
                rte.printStackTrace();
                LogProblem fallback_problem =
                  findNextTrigger_planb();
                findNextTrigger_commitModel(fallback_problem);
            }
        }
    }
    
    public boolean findNextTrigger_checkFieldsInvariants() {
        return true &&
          (this.old ==
             null ||
             this.old.fallback_checkInvariants());
    }
    
    public boolean updateTypes_checkContract() {
        return this.fallback_checkInvariants() &&
                 this.updateTypes_checkFieldsInvariants() &&
          updateTypes_checkContract_univQuantify_13();
    }
    
    public void updateTypes_assertContract() {
        assert updateTypes_checkContract();
    }
    
    public void updateTypes_commitModel(LogProblem fallback_problem) {
        fallback_problem.commitModel(this);
    }
    
    LogProblem updateTypes_planb() {
        System.out.println("\n" +
                             (this +
                                (" (" +
                                   (Thread.currentThread() +
                                      (": updateTypes" +
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
        fallback_problem.setModifiableField("at.ac.testing.pbnj.test6.TimedAction.type");
        LogExpr fallback_target =
          fallback_problem.objToSingletonRelation_log(this);
        boolean fallback_target_isOld =
          false;
        LogExpr fallback_formula =
          NewPeriodicSchedule.updateTypes_checkContract_log(fallback_problem,
                                                            fallback_target,
                                                            fallback_targetTypeArgsStr,
                                                            fallback_targetTypeArgs,
                                                            fallback_target_isOld);
        boolean isSatisfiable =
          fallback_problem.solve("updateTypes",
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
    
    public void updateTypes() {
        updateTypes_ensured();
    }
    
    public void updateTypes_ensured() {
        initEnsuredMethod();
        try {
            updateTypes_orig();
            updateTypes_assertContract();
        }
        catch (Throwable rte) {
            {
                rte.printStackTrace();
                LogProblem fallback_problem =
                  updateTypes_planb();
                updateTypes_commitModel(fallback_problem);
            }
        }
    }
    
    public boolean updateTypes_checkFieldsInvariants() {
        return true;
    }
    
    public void fallback_atomize(LogProblem fallback_problem,
                                 String fallback_targetTypeArgsStr,
                                 String[] fallback_targetTypeArgs) {
        if (!isAtomized(fallback_problem)) {
            this.atomizerStep =
              fallback_problem.relationizerStep();
            NewPeriodicSchedule.fallback_classAtomize(fallback_problem,
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
            if (this.inputActions !=
                  null)
                for (int i0_inputActions =
                       0;
                     i0_inputActions <
                       this.inputActions.length;
                     i0_inputActions++)
                    if (this.inputActions[i0_inputActions] !=
                          null)
                        this.inputActions[i0_inputActions].fallback_atomize(fallback_problem,
                                                                            "",
                                                                            null);
            if (this.intervals !=
                  null)
                for (int i0_intervals =
                       0;
                     i0_intervals <
                       this.intervals.length;
                     i0_intervals++)
                    if (this.intervals[i0_intervals] !=
                          null)
                        this.intervals[i0_intervals].fallback_atomize(fallback_problem,
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
            NewPeriodicSchedule.fallback_classRelationizeOld(fallback_problem,
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
            if (this.inputActions !=
                  null)
                for (int i0_inputActions =
                       0;
                     i0_inputActions <
                       this.inputActions.length;
                     i0_inputActions++)
                    if (this.inputActions[i0_inputActions] !=
                          null)
                        this.inputActions[i0_inputActions].fallback_relationizeOld(fallback_problem,
                                                                                   "",
                                                                                   null);
            if (this.intervals !=
                  null)
                for (int i0_intervals =
                       0;
                     i0_intervals <
                       this.intervals.length;
                     i0_intervals++)
                    if (this.intervals[i0_intervals] !=
                          null)
                        this.intervals[i0_intervals].fallback_relationizeOld(fallback_problem,
                                                                             "",
                                                                             null);
            NewPeriodicSchedule.MAX_SIZE_old_get_log(fallback_problem,
                                                     fallback_targetTypeArgsStr,
                                                     fallback_targetTypeArgs).put_log(fallback_problem,
                                                                                      this,
                                                                                      this.MAX_SIZE);
            NewPeriodicSchedule.size_old_get_log(fallback_problem,
                                                 fallback_targetTypeArgsStr,
                                                 fallback_targetTypeArgs).put_log(fallback_problem,
                                                                                  this,
                                                                                  this.size);
            NewPeriodicSchedule.duration_old_get_log(fallback_problem,
                                                     fallback_targetTypeArgsStr,
                                                     fallback_targetTypeArgs).put_log(fallback_problem,
                                                                                      this,
                                                                                      this.duration);
            NewPeriodicSchedule.actions_old_get_log(fallback_problem,
                                                    fallback_targetTypeArgsStr,
                                                    fallback_targetTypeArgs).array_put_log(fallback_problem,
                                                                                           this,
                                                                                           this.actions);
            NewPeriodicSchedule.inputActions_old_get_log(fallback_problem,
                                                         fallback_targetTypeArgsStr,
                                                         fallback_targetTypeArgs).array_put_log(fallback_problem,
                                                                                                this,
                                                                                                this.inputActions);
            NewPeriodicSchedule.TEMP_VAR_old_get_log(fallback_problem,
                                                     fallback_targetTypeArgsStr,
                                                     fallback_targetTypeArgs).int1_array_put_log(fallback_problem,
                                                                                                 this,
                                                                                                 this.TEMP_VAR);
            NewPeriodicSchedule.intervals_old_get_log(fallback_problem,
                                                      fallback_targetTypeArgsStr,
                                                      fallback_targetTypeArgs).array_put_log(fallback_problem,
                                                                                             this,
                                                                                             this.intervals);
            NewPeriodicSchedule.minDuration_old_get_log(fallback_problem,
                                                        fallback_targetTypeArgsStr,
                                                        fallback_targetTypeArgs).put_log(fallback_problem,
                                                                                         this,
                                                                                         this.minDuration);
            NewPeriodicSchedule.maxDuration_old_get_log(fallback_problem,
                                                        fallback_targetTypeArgsStr,
                                                        fallback_targetTypeArgs).put_log(fallback_problem,
                                                                                         this,
                                                                                         this.maxDuration);
            NewPeriodicSchedule.forceConcurrentActions_old_get_log(fallback_problem,
                                                                   fallback_targetTypeArgsStr,
                                                                   fallback_targetTypeArgs).put_log(fallback_problem,
                                                                                                    this,
                                                                                                    this.forceConcurrentActions);
            NewPeriodicSchedule.avoidConcurrentActions_old_get_log(fallback_problem,
                                                                   fallback_targetTypeArgsStr,
                                                                   fallback_targetTypeArgs).put_log(fallback_problem,
                                                                                                    this,
                                                                                                    this.avoidConcurrentActions);
            NewPeriodicSchedule.forceSustainedActions_old_get_log(fallback_problem,
                                                                  fallback_targetTypeArgsStr,
                                                                  fallback_targetTypeArgs).put_log(fallback_problem,
                                                                                                   this,
                                                                                                   this.forceSustainedActions);
            NewPeriodicSchedule.avoidSustainedActions_old_get_log(fallback_problem,
                                                                  fallback_targetTypeArgsStr,
                                                                  fallback_targetTypeArgs).put_log(fallback_problem,
                                                                                                   this,
                                                                                                   this.avoidSustainedActions);
            NewPeriodicSchedule.forceBlips_old_get_log(fallback_problem,
                                                       fallback_targetTypeArgsStr,
                                                       fallback_targetTypeArgs).put_log(fallback_problem,
                                                                                        this,
                                                                                        this.forceBlips);
            NewPeriodicSchedule.avoidBlips_old_get_log(fallback_problem,
                                                       fallback_targetTypeArgsStr,
                                                       fallback_targetTypeArgs).put_log(fallback_problem,
                                                                                        this,
                                                                                        this.avoidBlips);
            NewPeriodicSchedule.forceStateConsistency_old_get_log(fallback_problem,
                                                                  fallback_targetTypeArgsStr,
                                                                  fallback_targetTypeArgs).put_log(fallback_problem,
                                                                                                   this,
                                                                                                   this.forceStateConsistency);
            NewPeriodicSchedule.forceVariability_old_get_log(fallback_problem,
                                                             fallback_targetTypeArgsStr,
                                                             fallback_targetTypeArgs).put_log(fallback_problem,
                                                                                              this,
                                                                                              this.forceVariability);
            NewPeriodicSchedule.stabilityPeriodUp_old_get_log(fallback_problem,
                                                              fallback_targetTypeArgsStr,
                                                              fallback_targetTypeArgs).put_log(fallback_problem,
                                                                                               this,
                                                                                               this.stabilityPeriodUp);
            NewPeriodicSchedule.stabilityPeriodDown_old_get_log(fallback_problem,
                                                                fallback_targetTypeArgsStr,
                                                                fallback_targetTypeArgs).put_log(fallback_problem,
                                                                                                 this,
                                                                                                 this.stabilityPeriodDown);
            NewPeriodicSchedule.controlPeriod_old_get_log(fallback_problem,
                                                          fallback_targetTypeArgsStr,
                                                          fallback_targetTypeArgs).put_log(fallback_problem,
                                                                                           this,
                                                                                           this.controlPeriod);
            NewPeriodicSchedule.actuationDelay_old_get_log(fallback_problem,
                                                           fallback_targetTypeArgsStr,
                                                           fallback_targetTypeArgs).put_log(fallback_problem,
                                                                                            this,
                                                                                            this.actuationDelay);
            NewPeriodicSchedule.monitoringPeriod_old_get_log(fallback_problem,
                                                             fallback_targetTypeArgsStr,
                                                             fallback_targetTypeArgs).put_log(fallback_problem,
                                                                                              this,
                                                                                              this.monitoringPeriod);
        }
    }
    
    public static void fallback_classAtomize(LogProblem fallback_problem,
                                             String fallback_targetTypeArgsStr,
                                             String[] fallback_targetTypeArgs) {
        if (!isClassAtomized(fallback_problem)) {
            NewPeriodicSchedule.classAtomizerStep =
              fallback_problem.relationizerStep();
        }
    }
    
    public static void fallback_classRelationizeOld(LogProblem fallback_problem,
                                                    String fallback_targetTypeArgsStr,
                                                    String[] fallback_targetTypeArgs) {
        if (!isClassRelationized(fallback_problem)) {
            NewPeriodicSchedule.classRelationizerStep =
              fallback_problem.relationizerStep();
        }
    }
    
    public static void fallback_classClone() {
        if (isClassCloned())
            return;
    }
    
    public NewPeriodicSchedule fallback_clone() {
        if (isCloned())
            return old;
        NewPeriodicSchedule res =
          null;
        NewPeriodicSchedule.fallback_classClone();
        try {
            res =
              (NewPeriodicSchedule)
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
            res.duration =
              this.duration;
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
            if (this.inputActions !=
                  null) {
                res.inputActions =
                  (TimedAction[])
                    this.inputActions.clone();
                for (int i0_inputActions =
                       0;
                     i0_inputActions <
                       this.inputActions.length;
                     i0_inputActions++)
                    if (this.inputActions[i0_inputActions] !=
                          null) {
                        res.inputActions[i0_inputActions] =
                          (TimedAction)
                            ((PBJInternObject)
                               this.inputActions[i0_inputActions]).fallback_clone();
                    }
            }
            if (this.TEMP_VAR !=
                  null) {
                res.TEMP_VAR =
                  (int[])
                    this.TEMP_VAR.clone();
            }
            if (this.intervals !=
                  null) {
                res.intervals =
                  (Interval[])
                    this.intervals.clone();
                for (int i0_intervals =
                       0;
                     i0_intervals <
                       this.intervals.length;
                     i0_intervals++)
                    if (this.intervals[i0_intervals] !=
                          null) {
                        res.intervals[i0_intervals] =
                          (Interval)
                            ((PBJInternObject)
                               this.intervals[i0_intervals]).fallback_clone();
                    }
            }
            res.minDuration =
              this.minDuration;
            res.maxDuration =
              this.maxDuration;
            res.forceConcurrentActions =
              this.forceConcurrentActions;
            res.avoidConcurrentActions =
              this.avoidConcurrentActions;
            res.forceSustainedActions =
              this.forceSustainedActions;
            res.avoidSustainedActions =
              this.avoidSustainedActions;
            res.forceBlips =
              this.forceBlips;
            res.avoidBlips =
              this.avoidBlips;
            res.forceStateConsistency =
              this.forceStateConsistency;
            res.forceVariability =
              this.forceVariability;
            res.stabilityPeriodUp =
              this.stabilityPeriodUp;
            res.stabilityPeriodDown =
              this.stabilityPeriodDown;
            res.controlPeriod =
              this.controlPeriod;
            res.actuationDelay =
              this.actuationDelay;
            res.monitoringPeriod =
              this.monitoringPeriod;
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
                                   "at.ac.testing.pbnj.test6.NewPeriodicSchedule",
                                   fallback_targetTypeArgsStr,
                                   "MAX_SIZE",
                                   isOld);
    }
    
    public static LogRelation MAX_SIZE_old_get_log(LogProblem fallback_problem,
                                                   String fallback_targetTypeArgsStr,
                                                   String[] fallback_targetTypeArgs) {
        return LogMap.oldFieldGet_log(fallback_problem,
                                      "at.ac.testing.pbnj.test6.NewPeriodicSchedule",
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
                                   "at.ac.testing.pbnj.test6.NewPeriodicSchedule",
                                   fallback_targetTypeArgsStr,
                                   "size",
                                   isOld);
    }
    
    public static LogRelation size_old_get_log(LogProblem fallback_problem,
                                               String fallback_targetTypeArgsStr,
                                               String[] fallback_targetTypeArgs) {
        return LogMap.oldFieldGet_log(fallback_problem,
                                      "at.ac.testing.pbnj.test6.NewPeriodicSchedule",
                                      fallback_targetTypeArgsStr,
                                      "size");
    }
    
    public int fallback_updateField_size(Integer newVal) {
        return this.size =
          newVal;
    }
    
    public static LogExpr duration_get_log(LogProblem fallback_problem,
                                           LogExpr fallback_target,
                                           String fallback_targetTypeArgsStr,
                                           String[] fallback_targetTypeArgs,
                                           boolean isOld) {
        return LogMap.fieldGet_log(fallback_problem,
                                   fallback_target,
                                   "at.ac.testing.pbnj.test6.NewPeriodicSchedule",
                                   fallback_targetTypeArgsStr,
                                   "duration",
                                   isOld);
    }
    
    public static LogRelation duration_old_get_log(LogProblem fallback_problem,
                                                   String fallback_targetTypeArgsStr,
                                                   String[] fallback_targetTypeArgs) {
        return LogMap.oldFieldGet_log(fallback_problem,
                                      "at.ac.testing.pbnj.test6.NewPeriodicSchedule",
                                      fallback_targetTypeArgsStr,
                                      "duration");
    }
    
    public int fallback_updateField_duration(Integer newVal) {
        return this.duration =
          newVal;
    }
    
    public static LogExpr actions_get_log(LogProblem fallback_problem,
                                          LogExpr fallback_target,
                                          String fallback_targetTypeArgsStr,
                                          String[] fallback_targetTypeArgs,
                                          boolean isOld) {
        return LogMap.fieldGet_log(fallback_problem,
                                   fallback_target,
                                   "at.ac.testing.pbnj.test6.NewPeriodicSchedule",
                                   fallback_targetTypeArgsStr,
                                   "actions",
                                   isOld);
    }
    
    public static LogRelation actions_old_get_log(LogProblem fallback_problem,
                                                  String fallback_targetTypeArgsStr,
                                                  String[] fallback_targetTypeArgs) {
        return LogMap.oldFieldGet_log(fallback_problem,
                                      "at.ac.testing.pbnj.test6.NewPeriodicSchedule",
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
    
    public static LogExpr inputActions_get_log(LogProblem fallback_problem,
                                               LogExpr fallback_target,
                                               String fallback_targetTypeArgsStr,
                                               String[] fallback_targetTypeArgs,
                                               boolean isOld) {
        return LogMap.fieldGet_log(fallback_problem,
                                   fallback_target,
                                   "at.ac.testing.pbnj.test6.NewPeriodicSchedule",
                                   fallback_targetTypeArgsStr,
                                   "inputActions",
                                   isOld);
    }
    
    public static LogRelation inputActions_old_get_log(LogProblem fallback_problem,
                                                       String fallback_targetTypeArgsStr,
                                                       String[] fallback_targetTypeArgs) {
        return LogMap.oldFieldGet_log(fallback_problem,
                                      "at.ac.testing.pbnj.test6.NewPeriodicSchedule",
                                      fallback_targetTypeArgsStr,
                                      "inputActions");
    }
    
    public TimedAction fallback_updateArrayField_inputActions(int index,
                                                              TimedAction newVal) {
        this.inputActions[index] =
          newVal;
        return newVal;
    }
    
    public TimedAction[] fallback_updateField_inputActions(java.util.ArrayList<TimedAction> newVal) {
        int i =
          0;
        int s =
          newVal.size();
        if (this.inputActions ==
              null ||
              this.inputActions.length !=
                s)
            this.inputActions =
              (new TimedAction[s]);
        while (i <
                 s) {
            this.inputActions[i] =
              newVal.get(i);
            i++;
        }
        return this.inputActions;
    }
    
    public TimedAction[] fallback_updateField_inputActions(TimedAction[] newVal) {
        return this.inputActions =
          newVal;
    }
    
    public static LogExpr TEMP_VAR_get_log(LogProblem fallback_problem,
                                           LogExpr fallback_target,
                                           String fallback_targetTypeArgsStr,
                                           String[] fallback_targetTypeArgs,
                                           boolean isOld) {
        return LogMap.fieldGet_log(fallback_problem,
                                   fallback_target,
                                   "at.ac.testing.pbnj.test6.NewPeriodicSchedule",
                                   fallback_targetTypeArgsStr,
                                   "TEMP_VAR",
                                   isOld);
    }
    
    public static LogRelation TEMP_VAR_old_get_log(LogProblem fallback_problem,
                                                   String fallback_targetTypeArgsStr,
                                                   String[] fallback_targetTypeArgs) {
        return LogMap.oldFieldGet_log(fallback_problem,
                                      "at.ac.testing.pbnj.test6.NewPeriodicSchedule",
                                      fallback_targetTypeArgsStr,
                                      "TEMP_VAR");
    }
    
    public int fallback_updateArrayField_TEMP_VAR(int index,
                                                  int newVal) {
        this.TEMP_VAR[index] =
          newVal;
        return newVal;
    }
    
    public int[] fallback_updateField_TEMP_VAR(java.util.ArrayList<Integer> newVal) {
        int i =
          0;
        int s =
          newVal.size();
        if (this.TEMP_VAR ==
              null ||
              this.TEMP_VAR.length !=
                s)
            this.TEMP_VAR =
              (new int[s]);
        while (i <
                 s) {
            this.TEMP_VAR[i] =
              newVal.get(i);
            i++;
        }
        return this.TEMP_VAR;
    }
    
    public int[] fallback_updateField_TEMP_VAR(int[] newVal) {
        return this.TEMP_VAR =
          newVal;
    }
    
    public static LogExpr intervals_get_log(LogProblem fallback_problem,
                                            LogExpr fallback_target,
                                            String fallback_targetTypeArgsStr,
                                            String[] fallback_targetTypeArgs,
                                            boolean isOld) {
        return LogMap.fieldGet_log(fallback_problem,
                                   fallback_target,
                                   "at.ac.testing.pbnj.test6.NewPeriodicSchedule",
                                   fallback_targetTypeArgsStr,
                                   "intervals",
                                   isOld);
    }
    
    public static LogRelation intervals_old_get_log(LogProblem fallback_problem,
                                                    String fallback_targetTypeArgsStr,
                                                    String[] fallback_targetTypeArgs) {
        return LogMap.oldFieldGet_log(fallback_problem,
                                      "at.ac.testing.pbnj.test6.NewPeriodicSchedule",
                                      fallback_targetTypeArgsStr,
                                      "intervals");
    }
    
    public Interval fallback_updateArrayField_intervals(int index,
                                                        Interval newVal) {
        this.intervals[index] =
          newVal;
        return newVal;
    }
    
    public Interval[] fallback_updateField_intervals(java.util.ArrayList<Interval> newVal) {
        int i =
          0;
        int s =
          newVal.size();
        if (this.intervals ==
              null ||
              this.intervals.length !=
                s)
            this.intervals =
              (new Interval[s]);
        while (i <
                 s) {
            this.intervals[i] =
              newVal.get(i);
            i++;
        }
        return this.intervals;
    }
    
    public Interval[] fallback_updateField_intervals(Interval[] newVal) {
        return this.intervals =
          newVal;
    }
    
    public static LogExpr minDuration_get_log(LogProblem fallback_problem,
                                              LogExpr fallback_target,
                                              String fallback_targetTypeArgsStr,
                                              String[] fallback_targetTypeArgs,
                                              boolean isOld) {
        return LogMap.fieldGet_log(fallback_problem,
                                   fallback_target,
                                   "at.ac.testing.pbnj.test6.NewPeriodicSchedule",
                                   fallback_targetTypeArgsStr,
                                   "minDuration",
                                   isOld);
    }
    
    public static LogRelation minDuration_old_get_log(LogProblem fallback_problem,
                                                      String fallback_targetTypeArgsStr,
                                                      String[] fallback_targetTypeArgs) {
        return LogMap.oldFieldGet_log(fallback_problem,
                                      "at.ac.testing.pbnj.test6.NewPeriodicSchedule",
                                      fallback_targetTypeArgsStr,
                                      "minDuration");
    }
    
    public int fallback_updateField_minDuration(Integer newVal) {
        return this.minDuration =
          newVal;
    }
    
    public static LogExpr maxDuration_get_log(LogProblem fallback_problem,
                                              LogExpr fallback_target,
                                              String fallback_targetTypeArgsStr,
                                              String[] fallback_targetTypeArgs,
                                              boolean isOld) {
        return LogMap.fieldGet_log(fallback_problem,
                                   fallback_target,
                                   "at.ac.testing.pbnj.test6.NewPeriodicSchedule",
                                   fallback_targetTypeArgsStr,
                                   "maxDuration",
                                   isOld);
    }
    
    public static LogRelation maxDuration_old_get_log(LogProblem fallback_problem,
                                                      String fallback_targetTypeArgsStr,
                                                      String[] fallback_targetTypeArgs) {
        return LogMap.oldFieldGet_log(fallback_problem,
                                      "at.ac.testing.pbnj.test6.NewPeriodicSchedule",
                                      fallback_targetTypeArgsStr,
                                      "maxDuration");
    }
    
    public int fallback_updateField_maxDuration(Integer newVal) {
        return this.maxDuration =
          newVal;
    }
    
    public static LogExpr forceConcurrentActions_get_log(LogProblem fallback_problem,
                                                         LogExpr fallback_target,
                                                         String fallback_targetTypeArgsStr,
                                                         String[] fallback_targetTypeArgs,
                                                         boolean isOld) {
        return LogMap.fieldGet_log(fallback_problem,
                                   fallback_target,
                                   "at.ac.testing.pbnj.test6.NewPeriodicSchedule",
                                   fallback_targetTypeArgsStr,
                                   "forceConcurrentActions",
                                   isOld).eq(fallback_problem.true_log());
    }
    
    public static LogRelation forceConcurrentActions_old_get_log(LogProblem fallback_problem,
                                                                 String fallback_targetTypeArgsStr,
                                                                 String[] fallback_targetTypeArgs) {
        return LogMap.oldFieldGet_log(fallback_problem,
                                      "at.ac.testing.pbnj.test6.NewPeriodicSchedule",
                                      fallback_targetTypeArgsStr,
                                      "forceConcurrentActions");
    }
    
    public boolean fallback_updateField_forceConcurrentActions(Boolean newVal) {
        return this.forceConcurrentActions =
          newVal;
    }
    
    public PBJInternSet<Boolean> fieldsClosure_Boolean(Object fallback_target,
                                                       boolean isReflexive,
                                                       java.lang.String ... fieldNs) {
        Class c =
          boolean.class;
        PBJInternSet<Boolean> res =
          new PBJInternSet<Boolean>();
        java.util.ArrayList<Boolean> workList =
          new java.util.ArrayList<Boolean>();
        try {
            java.util.ArrayList<java.lang.reflect.Field> fields =
              new java.util.ArrayList<java.lang.reflect.Field>();
            for (String fN : fieldNs) {
                fields.add(c.getField(fN));
            }
            for (java.lang.reflect.Field f : fields) {
                Boolean childN =
                  (Boolean)
                    f.get(fallback_target);
                if (!(childN ==
                        null ||
                        res.containsPtrEqCmp(childN)))
                    workList.add(childN);
            }
            Boolean n;
            while (workList.size() >
                     0) {
                n =
                  workList.get(0);
                res.add(n);
                for (java.lang.reflect.Field f : fields) {
                    Boolean childN =
                      (Boolean)
                        f.get(n);
                    if (!(childN ==
                            null ||
                            res.containsPtrEqCmp(childN)))
                        workList.add(childN);
                }
                workList.remove(n);
            }
            if (isReflexive)
                res.add((Boolean)
                          fallback_target);
        }
        catch (Exception rte) {
            rte.printStackTrace();
        }
        return res;
    }
    
    PBJInternSet<Boolean> multiFields_Boolean(java.lang.String ... fieldNs) {
        Class c =
          Boolean.class;
        PBJInternSet<Boolean> res =
          new PBJInternSet<Boolean>();
        try {
            for (String fN : fieldNs) {
                java.lang.reflect.Field f =
                  c.getField(fN);
                Boolean n =
                  (Boolean)
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
    
    public static LogExpr avoidConcurrentActions_get_log(LogProblem fallback_problem,
                                                         LogExpr fallback_target,
                                                         String fallback_targetTypeArgsStr,
                                                         String[] fallback_targetTypeArgs,
                                                         boolean isOld) {
        return LogMap.fieldGet_log(fallback_problem,
                                   fallback_target,
                                   "at.ac.testing.pbnj.test6.NewPeriodicSchedule",
                                   fallback_targetTypeArgsStr,
                                   "avoidConcurrentActions",
                                   isOld).eq(fallback_problem.true_log());
    }
    
    public static LogRelation avoidConcurrentActions_old_get_log(LogProblem fallback_problem,
                                                                 String fallback_targetTypeArgsStr,
                                                                 String[] fallback_targetTypeArgs) {
        return LogMap.oldFieldGet_log(fallback_problem,
                                      "at.ac.testing.pbnj.test6.NewPeriodicSchedule",
                                      fallback_targetTypeArgsStr,
                                      "avoidConcurrentActions");
    }
    
    public boolean fallback_updateField_avoidConcurrentActions(Boolean newVal) {
        return this.avoidConcurrentActions =
          newVal;
    }
    
    public static LogExpr forceSustainedActions_get_log(LogProblem fallback_problem,
                                                        LogExpr fallback_target,
                                                        String fallback_targetTypeArgsStr,
                                                        String[] fallback_targetTypeArgs,
                                                        boolean isOld) {
        return LogMap.fieldGet_log(fallback_problem,
                                   fallback_target,
                                   "at.ac.testing.pbnj.test6.NewPeriodicSchedule",
                                   fallback_targetTypeArgsStr,
                                   "forceSustainedActions",
                                   isOld).eq(fallback_problem.true_log());
    }
    
    public static LogRelation forceSustainedActions_old_get_log(LogProblem fallback_problem,
                                                                String fallback_targetTypeArgsStr,
                                                                String[] fallback_targetTypeArgs) {
        return LogMap.oldFieldGet_log(fallback_problem,
                                      "at.ac.testing.pbnj.test6.NewPeriodicSchedule",
                                      fallback_targetTypeArgsStr,
                                      "forceSustainedActions");
    }
    
    public boolean fallback_updateField_forceSustainedActions(Boolean newVal) {
        return this.forceSustainedActions =
          newVal;
    }
    
    public static LogExpr avoidSustainedActions_get_log(LogProblem fallback_problem,
                                                        LogExpr fallback_target,
                                                        String fallback_targetTypeArgsStr,
                                                        String[] fallback_targetTypeArgs,
                                                        boolean isOld) {
        return LogMap.fieldGet_log(fallback_problem,
                                   fallback_target,
                                   "at.ac.testing.pbnj.test6.NewPeriodicSchedule",
                                   fallback_targetTypeArgsStr,
                                   "avoidSustainedActions",
                                   isOld).eq(fallback_problem.true_log());
    }
    
    public static LogRelation avoidSustainedActions_old_get_log(LogProblem fallback_problem,
                                                                String fallback_targetTypeArgsStr,
                                                                String[] fallback_targetTypeArgs) {
        return LogMap.oldFieldGet_log(fallback_problem,
                                      "at.ac.testing.pbnj.test6.NewPeriodicSchedule",
                                      fallback_targetTypeArgsStr,
                                      "avoidSustainedActions");
    }
    
    public boolean fallback_updateField_avoidSustainedActions(Boolean newVal) {
        return this.avoidSustainedActions =
          newVal;
    }
    
    public static LogExpr forceBlips_get_log(LogProblem fallback_problem,
                                             LogExpr fallback_target,
                                             String fallback_targetTypeArgsStr,
                                             String[] fallback_targetTypeArgs,
                                             boolean isOld) {
        return LogMap.fieldGet_log(fallback_problem,
                                   fallback_target,
                                   "at.ac.testing.pbnj.test6.NewPeriodicSchedule",
                                   fallback_targetTypeArgsStr,
                                   "forceBlips",
                                   isOld).eq(fallback_problem.true_log());
    }
    
    public static LogRelation forceBlips_old_get_log(LogProblem fallback_problem,
                                                     String fallback_targetTypeArgsStr,
                                                     String[] fallback_targetTypeArgs) {
        return LogMap.oldFieldGet_log(fallback_problem,
                                      "at.ac.testing.pbnj.test6.NewPeriodicSchedule",
                                      fallback_targetTypeArgsStr,
                                      "forceBlips");
    }
    
    public boolean fallback_updateField_forceBlips(Boolean newVal) {
        return this.forceBlips =
          newVal;
    }
    
    public static LogExpr avoidBlips_get_log(LogProblem fallback_problem,
                                             LogExpr fallback_target,
                                             String fallback_targetTypeArgsStr,
                                             String[] fallback_targetTypeArgs,
                                             boolean isOld) {
        return LogMap.fieldGet_log(fallback_problem,
                                   fallback_target,
                                   "at.ac.testing.pbnj.test6.NewPeriodicSchedule",
                                   fallback_targetTypeArgsStr,
                                   "avoidBlips",
                                   isOld).eq(fallback_problem.true_log());
    }
    
    public static LogRelation avoidBlips_old_get_log(LogProblem fallback_problem,
                                                     String fallback_targetTypeArgsStr,
                                                     String[] fallback_targetTypeArgs) {
        return LogMap.oldFieldGet_log(fallback_problem,
                                      "at.ac.testing.pbnj.test6.NewPeriodicSchedule",
                                      fallback_targetTypeArgsStr,
                                      "avoidBlips");
    }
    
    public boolean fallback_updateField_avoidBlips(Boolean newVal) {
        return this.avoidBlips =
          newVal;
    }
    
    public static LogExpr forceStateConsistency_get_log(LogProblem fallback_problem,
                                                        LogExpr fallback_target,
                                                        String fallback_targetTypeArgsStr,
                                                        String[] fallback_targetTypeArgs,
                                                        boolean isOld) {
        return LogMap.fieldGet_log(fallback_problem,
                                   fallback_target,
                                   "at.ac.testing.pbnj.test6.NewPeriodicSchedule",
                                   fallback_targetTypeArgsStr,
                                   "forceStateConsistency",
                                   isOld).eq(fallback_problem.true_log());
    }
    
    public static LogRelation forceStateConsistency_old_get_log(LogProblem fallback_problem,
                                                                String fallback_targetTypeArgsStr,
                                                                String[] fallback_targetTypeArgs) {
        return LogMap.oldFieldGet_log(fallback_problem,
                                      "at.ac.testing.pbnj.test6.NewPeriodicSchedule",
                                      fallback_targetTypeArgsStr,
                                      "forceStateConsistency");
    }
    
    public boolean fallback_updateField_forceStateConsistency(Boolean newVal) {
        return this.forceStateConsistency =
          newVal;
    }
    
    public static LogExpr forceVariability_get_log(LogProblem fallback_problem,
                                                   LogExpr fallback_target,
                                                   String fallback_targetTypeArgsStr,
                                                   String[] fallback_targetTypeArgs,
                                                   boolean isOld) {
        return LogMap.fieldGet_log(fallback_problem,
                                   fallback_target,
                                   "at.ac.testing.pbnj.test6.NewPeriodicSchedule",
                                   fallback_targetTypeArgsStr,
                                   "forceVariability",
                                   isOld).eq(fallback_problem.true_log());
    }
    
    public static LogRelation forceVariability_old_get_log(LogProblem fallback_problem,
                                                           String fallback_targetTypeArgsStr,
                                                           String[] fallback_targetTypeArgs) {
        return LogMap.oldFieldGet_log(fallback_problem,
                                      "at.ac.testing.pbnj.test6.NewPeriodicSchedule",
                                      fallback_targetTypeArgsStr,
                                      "forceVariability");
    }
    
    public boolean fallback_updateField_forceVariability(Boolean newVal) {
        return this.forceVariability =
          newVal;
    }
    
    public static LogExpr stabilityPeriodUp_get_log(LogProblem fallback_problem,
                                                    LogExpr fallback_target,
                                                    String fallback_targetTypeArgsStr,
                                                    String[] fallback_targetTypeArgs,
                                                    boolean isOld) {
        return LogMap.fieldGet_log(fallback_problem,
                                   fallback_target,
                                   "at.ac.testing.pbnj.test6.NewPeriodicSchedule",
                                   fallback_targetTypeArgsStr,
                                   "stabilityPeriodUp",
                                   isOld);
    }
    
    public static LogRelation stabilityPeriodUp_old_get_log(LogProblem fallback_problem,
                                                            String fallback_targetTypeArgsStr,
                                                            String[] fallback_targetTypeArgs) {
        return LogMap.oldFieldGet_log(fallback_problem,
                                      "at.ac.testing.pbnj.test6.NewPeriodicSchedule",
                                      fallback_targetTypeArgsStr,
                                      "stabilityPeriodUp");
    }
    
    public int fallback_updateField_stabilityPeriodUp(Integer newVal) {
        return this.stabilityPeriodUp =
          newVal;
    }
    
    public static LogExpr stabilityPeriodDown_get_log(LogProblem fallback_problem,
                                                      LogExpr fallback_target,
                                                      String fallback_targetTypeArgsStr,
                                                      String[] fallback_targetTypeArgs,
                                                      boolean isOld) {
        return LogMap.fieldGet_log(fallback_problem,
                                   fallback_target,
                                   "at.ac.testing.pbnj.test6.NewPeriodicSchedule",
                                   fallback_targetTypeArgsStr,
                                   "stabilityPeriodDown",
                                   isOld);
    }
    
    public static LogRelation stabilityPeriodDown_old_get_log(LogProblem fallback_problem,
                                                              String fallback_targetTypeArgsStr,
                                                              String[] fallback_targetTypeArgs) {
        return LogMap.oldFieldGet_log(fallback_problem,
                                      "at.ac.testing.pbnj.test6.NewPeriodicSchedule",
                                      fallback_targetTypeArgsStr,
                                      "stabilityPeriodDown");
    }
    
    public int fallback_updateField_stabilityPeriodDown(Integer newVal) {
        return this.stabilityPeriodDown =
          newVal;
    }
    
    public static LogExpr controlPeriod_get_log(LogProblem fallback_problem,
                                                LogExpr fallback_target,
                                                String fallback_targetTypeArgsStr,
                                                String[] fallback_targetTypeArgs,
                                                boolean isOld) {
        return LogMap.fieldGet_log(fallback_problem,
                                   fallback_target,
                                   "at.ac.testing.pbnj.test6.NewPeriodicSchedule",
                                   fallback_targetTypeArgsStr,
                                   "controlPeriod",
                                   isOld);
    }
    
    public static LogRelation controlPeriod_old_get_log(LogProblem fallback_problem,
                                                        String fallback_targetTypeArgsStr,
                                                        String[] fallback_targetTypeArgs) {
        return LogMap.oldFieldGet_log(fallback_problem,
                                      "at.ac.testing.pbnj.test6.NewPeriodicSchedule",
                                      fallback_targetTypeArgsStr,
                                      "controlPeriod");
    }
    
    public int fallback_updateField_controlPeriod(Integer newVal) {
        return this.controlPeriod =
          newVal;
    }
    
    public static LogExpr actuationDelay_get_log(LogProblem fallback_problem,
                                                 LogExpr fallback_target,
                                                 String fallback_targetTypeArgsStr,
                                                 String[] fallback_targetTypeArgs,
                                                 boolean isOld) {
        return LogMap.fieldGet_log(fallback_problem,
                                   fallback_target,
                                   "at.ac.testing.pbnj.test6.NewPeriodicSchedule",
                                   fallback_targetTypeArgsStr,
                                   "actuationDelay",
                                   isOld);
    }
    
    public static LogRelation actuationDelay_old_get_log(LogProblem fallback_problem,
                                                         String fallback_targetTypeArgsStr,
                                                         String[] fallback_targetTypeArgs) {
        return LogMap.oldFieldGet_log(fallback_problem,
                                      "at.ac.testing.pbnj.test6.NewPeriodicSchedule",
                                      fallback_targetTypeArgsStr,
                                      "actuationDelay");
    }
    
    public int fallback_updateField_actuationDelay(Integer newVal) {
        return this.actuationDelay =
          newVal;
    }
    
    public static LogExpr monitoringPeriod_get_log(LogProblem fallback_problem,
                                                   LogExpr fallback_target,
                                                   String fallback_targetTypeArgsStr,
                                                   String[] fallback_targetTypeArgs,
                                                   boolean isOld) {
        return LogMap.fieldGet_log(fallback_problem,
                                   fallback_target,
                                   "at.ac.testing.pbnj.test6.NewPeriodicSchedule",
                                   fallback_targetTypeArgsStr,
                                   "monitoringPeriod",
                                   isOld);
    }
    
    public static LogRelation monitoringPeriod_old_get_log(LogProblem fallback_problem,
                                                           String fallback_targetTypeArgsStr,
                                                           String[] fallback_targetTypeArgs) {
        return LogMap.oldFieldGet_log(fallback_problem,
                                      "at.ac.testing.pbnj.test6.NewPeriodicSchedule",
                                      fallback_targetTypeArgsStr,
                                      "monitoringPeriod");
    }
    
    public int fallback_updateField_monitoringPeriod(Integer newVal) {
        return this.monitoringPeriod =
          newVal;
    }
    
    boolean timeOrdering_univQuantify_1() {
        for (int i : PBJInternInteger.range(0,
                                            size -
                                              2)) {
            if (!timeOrdering_univQuantify_0(i))
                return false;
        }
        return true;
    }
    
    boolean timeOrdering_univQuantify_0(int i) {
        for (int j : PBJInternInteger.range(0,
                                            size -
                                              1)) {
            if (!(!(i <
                      j) ||
                    actions[i].time <=
                      actions[j].time))
                return false;
        }
        return true;
    }
    
    boolean findIntervals_univQuantify_3() {
        for (TimedAction a : this.actions) {
            if (!(!(a.type !=
                      ActionType.STAY) ||
                    findIntervals_existQuantify_2(a)))
                return false;
        }
        return true;
    }
    
    boolean findIntervals_existQuantify_2(TimedAction a) {
        int quantCount =
          0;
        for (Interval i : this.intervals) {
            if (a ==
                  i.start &&
                  (a.type ==
                     ActionType.SCALE_UP &&
                     i.intervalDuration ==
                       stabilityPeriodUp ||
                     a.type ==
                       ActionType.SCALE_DOWN &&
                       i.intervalDuration ==
                         stabilityPeriodDown) &&
                  noSameStart(i))
                quantCount++;
            if (quantCount >
                  1)
                return false;
        }
        return quantCount ==
          1;
    }
    
    boolean findIntervals_univQuantify_4() {
        for (Interval ii : this.intervals) {
            if (!(ii !=
                    null))
                return false;
        }
        return true;
    }
    
    boolean findIntervals_univQuantify_6() {
        for (int iii : PBJInternInteger.range(0,
                                              this.intervals.length -
                                                1)) {
            if (!findIntervals_univQuantify_5(iii))
                return false;
        }
        return true;
    }
    
    boolean findIntervals_univQuantify_5(int iii) {
        for (int j : PBJInternInteger.range(0,
                                            this.intervals.length -
                                              1)) {
            if (!(!(iii !=
                      j) ||
                    this.intervals[iii] !=
                      this.intervals[j]))
                return false;
        }
        return true;
    }
    
    boolean noSameStart_univQuantify_7(Interval i) {
        for (Interval ii : this.intervals) {
            if (!(!(i !=
                      ii &&
                      i.start ==
                        ii.start)))
                return false;
        }
        return true;
    }
    
    boolean orderedIntervals_univQuantify_9() {
        for (int i : PBJInternInteger.range(0,
                                            this.intervals.length -
                                              1)) {
            if (!orderedIntervals_univQuantify_8(i))
                return false;
        }
        return true;
    }
    
    boolean orderedIntervals_univQuantify_8(int i) {
        for (int j : PBJInternInteger.range(0,
                                            this.intervals.length -
                                              1)) {
            if (!(!(i <
                      j) ||
                    this.intervals[i].start.time <=
                      this.intervals[j].start.time))
                return false;
        }
        return true;
    }
    
    public boolean findNextTrigger_checkContract_univQuantify_11() {
        for (int i : PBJInternInteger.range(0,
                                            this.intervals.length -
                                              1)) {
            if (!findNextTrigger_checkContract_univQuantify_10(i))
                return false;
        }
        return true;
    }
    
    public boolean findNextTrigger_checkContract_univQuantify_10(int i) {
        for (int j : PBJInternInteger.range(0,
                                            this.intervals.length -
                                              1)) {
            if (!(!(i !=
                      j) ||
                    this.intervals[i] !=
                      this.intervals[j]))
                return false;
        }
        return true;
    }
    
    public boolean findNextTrigger_checkContract_univQuantify_12() {
        for (Interval interval : this.intervals) {
            if (!(interval !=
                    null))
                return false;
        }
        return true;
    }
    
    public boolean updateTypes_checkContract_univQuantify_13() {
        for (TimedAction t : this.inputActions) {
            if (!t.validType())
                return false;
        }
        return true;
    }
    
    public static PBJInternSet<Integer> setMap_MAX_SIZE(PBJInternSet<NewPeriodicSchedule> objs,
                                                        java.lang.String ... fieldNs) {
        PBJInternSet<Integer> res =
          new PBJInternSet<Integer>();
        java.util.Iterator<NewPeriodicSchedule> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().MAX_SIZE);
        }
        return res;
    }
    
    public static PBJInternSet<Integer> setMap_size(PBJInternSet<NewPeriodicSchedule> objs,
                                                    java.lang.String ... fieldNs) {
        PBJInternSet<Integer> res =
          new PBJInternSet<Integer>();
        java.util.Iterator<NewPeriodicSchedule> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().size);
        }
        return res;
    }
    
    public static PBJInternSet<Integer> setMap_duration(PBJInternSet<NewPeriodicSchedule> objs,
                                                        java.lang.String ... fieldNs) {
        PBJInternSet<Integer> res =
          new PBJInternSet<Integer>();
        java.util.Iterator<NewPeriodicSchedule> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().duration);
        }
        return res;
    }
    
    public static PBJInternSet<Integer> setMap_minDuration(PBJInternSet<NewPeriodicSchedule> objs,
                                                           java.lang.String ... fieldNs) {
        PBJInternSet<Integer> res =
          new PBJInternSet<Integer>();
        java.util.Iterator<NewPeriodicSchedule> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().minDuration);
        }
        return res;
    }
    
    public static PBJInternSet<Integer> setMap_maxDuration(PBJInternSet<NewPeriodicSchedule> objs,
                                                           java.lang.String ... fieldNs) {
        PBJInternSet<Integer> res =
          new PBJInternSet<Integer>();
        java.util.Iterator<NewPeriodicSchedule> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().maxDuration);
        }
        return res;
    }
    
    public static PBJInternSet<Boolean> setMap_forceConcurrentActions(PBJInternSet<NewPeriodicSchedule> objs,
                                                                      java.lang.String ... fieldNs) {
        PBJInternSet<Boolean> res =
          new PBJInternSet<Boolean>();
        java.util.Iterator<NewPeriodicSchedule> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().forceConcurrentActions);
        }
        return res;
    }
    
    public static PBJInternSet<Boolean> setMap_avoidConcurrentActions(PBJInternSet<NewPeriodicSchedule> objs,
                                                                      java.lang.String ... fieldNs) {
        PBJInternSet<Boolean> res =
          new PBJInternSet<Boolean>();
        java.util.Iterator<NewPeriodicSchedule> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().avoidConcurrentActions);
        }
        return res;
    }
    
    public static PBJInternSet<Boolean> setMap_forceSustainedActions(PBJInternSet<NewPeriodicSchedule> objs,
                                                                     java.lang.String ... fieldNs) {
        PBJInternSet<Boolean> res =
          new PBJInternSet<Boolean>();
        java.util.Iterator<NewPeriodicSchedule> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().forceSustainedActions);
        }
        return res;
    }
    
    public static PBJInternSet<Boolean> setMap_avoidSustainedActions(PBJInternSet<NewPeriodicSchedule> objs,
                                                                     java.lang.String ... fieldNs) {
        PBJInternSet<Boolean> res =
          new PBJInternSet<Boolean>();
        java.util.Iterator<NewPeriodicSchedule> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().avoidSustainedActions);
        }
        return res;
    }
    
    public static PBJInternSet<Boolean> setMap_forceBlips(PBJInternSet<NewPeriodicSchedule> objs,
                                                          java.lang.String ... fieldNs) {
        PBJInternSet<Boolean> res =
          new PBJInternSet<Boolean>();
        java.util.Iterator<NewPeriodicSchedule> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().forceBlips);
        }
        return res;
    }
    
    public static PBJInternSet<Boolean> setMap_avoidBlips(PBJInternSet<NewPeriodicSchedule> objs,
                                                          java.lang.String ... fieldNs) {
        PBJInternSet<Boolean> res =
          new PBJInternSet<Boolean>();
        java.util.Iterator<NewPeriodicSchedule> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().avoidBlips);
        }
        return res;
    }
    
    public static PBJInternSet<Boolean> setMap_forceStateConsistency(PBJInternSet<NewPeriodicSchedule> objs,
                                                                     java.lang.String ... fieldNs) {
        PBJInternSet<Boolean> res =
          new PBJInternSet<Boolean>();
        java.util.Iterator<NewPeriodicSchedule> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().forceStateConsistency);
        }
        return res;
    }
    
    public static PBJInternSet<Boolean> setMap_forceVariability(PBJInternSet<NewPeriodicSchedule> objs,
                                                                java.lang.String ... fieldNs) {
        PBJInternSet<Boolean> res =
          new PBJInternSet<Boolean>();
        java.util.Iterator<NewPeriodicSchedule> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().forceVariability);
        }
        return res;
    }
    
    public static PBJInternSet<Integer> setMap_stabilityPeriodUp(PBJInternSet<NewPeriodicSchedule> objs,
                                                                 java.lang.String ... fieldNs) {
        PBJInternSet<Integer> res =
          new PBJInternSet<Integer>();
        java.util.Iterator<NewPeriodicSchedule> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().stabilityPeriodUp);
        }
        return res;
    }
    
    public static PBJInternSet<Integer> setMap_stabilityPeriodDown(PBJInternSet<NewPeriodicSchedule> objs,
                                                                   java.lang.String ... fieldNs) {
        PBJInternSet<Integer> res =
          new PBJInternSet<Integer>();
        java.util.Iterator<NewPeriodicSchedule> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().stabilityPeriodDown);
        }
        return res;
    }
    
    public static PBJInternSet<Integer> setMap_controlPeriod(PBJInternSet<NewPeriodicSchedule> objs,
                                                             java.lang.String ... fieldNs) {
        PBJInternSet<Integer> res =
          new PBJInternSet<Integer>();
        java.util.Iterator<NewPeriodicSchedule> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().controlPeriod);
        }
        return res;
    }
    
    public static PBJInternSet<Integer> setMap_actuationDelay(PBJInternSet<NewPeriodicSchedule> objs,
                                                              java.lang.String ... fieldNs) {
        PBJInternSet<Integer> res =
          new PBJInternSet<Integer>();
        java.util.Iterator<NewPeriodicSchedule> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().actuationDelay);
        }
        return res;
    }
    
    public static PBJInternSet<Integer> setMap_monitoringPeriod(PBJInternSet<NewPeriodicSchedule> objs,
                                                                java.lang.String ... fieldNs) {
        PBJInternSet<Integer> res =
          new PBJInternSet<Integer>();
        java.util.Iterator<NewPeriodicSchedule> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().monitoringPeriod);
        }
        return res;
    }
    
    public static void fallback_initClassDefs() {
        
    }
    
    static {
               LogMap.newClassForLog(NewPeriodicSchedule.class,
                                     true);
               LogMap.newInstVarRel("MAX_SIZE",
                                    NewPeriodicSchedule.class,
                                    "at.ac.testing.pbnj.test6.NewPeriodicSchedule",
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
                                    NewPeriodicSchedule.class,
                                    "at.ac.testing.pbnj.test6.NewPeriodicSchedule",
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
               LogMap.newInstVarRel("duration",
                                    NewPeriodicSchedule.class,
                                    "at.ac.testing.pbnj.test6.NewPeriodicSchedule",
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
                                    NewPeriodicSchedule.class,
                                    "at.ac.testing.pbnj.test6.NewPeriodicSchedule",
                                    TimedAction.class,
                                    "at.ac.testing.pbnj.test6.TimedAction",
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
               LogMap.newInstVarRel("inputActions",
                                    NewPeriodicSchedule.class,
                                    "at.ac.testing.pbnj.test6.NewPeriodicSchedule",
                                    TimedAction.class,
                                    "at.ac.testing.pbnj.test6.TimedAction",
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
               LogMap.newInstVarRel("TEMP_VAR",
                                    NewPeriodicSchedule.class,
                                    "at.ac.testing.pbnj.test6.NewPeriodicSchedule",
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
               LogMap.newInstVarRel("intervals",
                                    NewPeriodicSchedule.class,
                                    "at.ac.testing.pbnj.test6.NewPeriodicSchedule",
                                    Interval.class,
                                    "at.ac.testing.pbnj.test6.Interval",
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
               LogMap.newInstVarRel("minDuration",
                                    NewPeriodicSchedule.class,
                                    "at.ac.testing.pbnj.test6.NewPeriodicSchedule",
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
               LogMap.newInstVarRel("maxDuration",
                                    NewPeriodicSchedule.class,
                                    "at.ac.testing.pbnj.test6.NewPeriodicSchedule",
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
               LogMap.newInstVarRel("forceConcurrentActions",
                                    NewPeriodicSchedule.class,
                                    "at.ac.testing.pbnj.test6.NewPeriodicSchedule",
                                    Boolean.class,
                                    "boolean",
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
               LogMap.newInstVarRel("avoidConcurrentActions",
                                    NewPeriodicSchedule.class,
                                    "at.ac.testing.pbnj.test6.NewPeriodicSchedule",
                                    Boolean.class,
                                    "boolean",
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
               LogMap.newInstVarRel("forceSustainedActions",
                                    NewPeriodicSchedule.class,
                                    "at.ac.testing.pbnj.test6.NewPeriodicSchedule",
                                    Boolean.class,
                                    "boolean",
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
               LogMap.newInstVarRel("avoidSustainedActions",
                                    NewPeriodicSchedule.class,
                                    "at.ac.testing.pbnj.test6.NewPeriodicSchedule",
                                    Boolean.class,
                                    "boolean",
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
               LogMap.newInstVarRel("forceBlips",
                                    NewPeriodicSchedule.class,
                                    "at.ac.testing.pbnj.test6.NewPeriodicSchedule",
                                    Boolean.class,
                                    "boolean",
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
               LogMap.newInstVarRel("avoidBlips",
                                    NewPeriodicSchedule.class,
                                    "at.ac.testing.pbnj.test6.NewPeriodicSchedule",
                                    Boolean.class,
                                    "boolean",
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
               LogMap.newInstVarRel("forceStateConsistency",
                                    NewPeriodicSchedule.class,
                                    "at.ac.testing.pbnj.test6.NewPeriodicSchedule",
                                    Boolean.class,
                                    "boolean",
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
               LogMap.newInstVarRel("forceVariability",
                                    NewPeriodicSchedule.class,
                                    "at.ac.testing.pbnj.test6.NewPeriodicSchedule",
                                    Boolean.class,
                                    "boolean",
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
               LogMap.newInstVarRel("stabilityPeriodUp",
                                    NewPeriodicSchedule.class,
                                    "at.ac.testing.pbnj.test6.NewPeriodicSchedule",
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
               LogMap.newInstVarRel("stabilityPeriodDown",
                                    NewPeriodicSchedule.class,
                                    "at.ac.testing.pbnj.test6.NewPeriodicSchedule",
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
               LogMap.newInstVarRel("controlPeriod",
                                    NewPeriodicSchedule.class,
                                    "at.ac.testing.pbnj.test6.NewPeriodicSchedule",
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
               LogMap.newInstVarRel("actuationDelay",
                                    NewPeriodicSchedule.class,
                                    "at.ac.testing.pbnj.test6.NewPeriodicSchedule",
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
               LogMap.newInstVarRel("monitoringPeriod",
                                    NewPeriodicSchedule.class,
                                    "at.ac.testing.pbnj.test6.NewPeriodicSchedule",
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
    
    static LogExpr timeOrdering_log(LogProblem fallback_problem,
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
        return TimedAction.time_get_log(fallback_problem,
                                        NewPeriodicSchedule.actions_get_log(fallback_problem,
                                                                            fallback_target,
                                                                            fallback_targetTypeArgsStr,
                                                                            fallback_targetTypeArgs,
                                                                            fallback_target_isOld).get_log(fallback_problem,
                                                                                                           new LogExpr(fallback_problem,
                                                                                                                       kodkod.ast.IntConstant.constant(0)),
                                                                                                           false),
                                        "",
                                        null,
                                        fallback_target_isOld).gt(new LogExpr(fallback_problem,
                                                                              kodkod.ast.IntConstant.constant(0))).and(LogExpr.quantifyOp(PBJInternSet.toPBJInternSet_log(fallback_problem,
                                                                                                                                                                          PBJInternInteger.range_log(fallback_problem,
                                                                                                                                                                                                     fallback_problem.class_log(PBJInternInteger.class),
                                                                                                                                                                                                     "",
                                                                                                                                                                                                     null,
                                                                                                                                                                                                     fallback_target_isOld,
                                                                                                                                                                                                     new LogExpr(fallback_problem,
                                                                                                                                                                                                                 kodkod.ast.IntConstant.constant(0)),
                                                                                                                                                                                                     fallback_target_isOld,
                                                                                                                                                                                                     NewPeriodicSchedule.size_get_log(fallback_problem,
                                                                                                                                                                                                                                      fallback_target,
                                                                                                                                                                                                                                      fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                      fallback_targetTypeArgs,
                                                                                                                                                                                                                                      fallback_target_isOld).minus(new LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                               kodkod.ast.IntConstant.constant(2))),
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
                                                                                                                                                                                                                        NewPeriodicSchedule.size_get_log(fallback_problem,
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
                                                                                                                                                             i.lt(j).implies(TimedAction.time_get_log(fallback_problem,
                                                                                                                                                                                                      NewPeriodicSchedule.actions_get_log(fallback_problem,
                                                                                                                                                                                                                                          fallback_target,
                                                                                                                                                                                                                                          fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                          fallback_targetTypeArgs,
                                                                                                                                                                                                                                          fallback_target_isOld).get_log(fallback_problem,
                                                                                                                                                                                                                                                                         i,
                                                                                                                                                                                                                                                                         false),
                                                                                                                                                                                                      "",
                                                                                                                                                                                                      null,
                                                                                                                                                                                                      fallback_target_isOld).lte(TimedAction.time_get_log(fallback_problem,
                                                                                                                                                                                                                                                          NewPeriodicSchedule.actions_get_log(fallback_problem,
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
    
    static LogExpr findIntervals_log(LogProblem fallback_problem,
                                     LogExpr fallback_target,
                                     String fallback_targetTypeArgsStr,
                                     String[] fallback_targetTypeArgs,
                                     boolean fallback_target_isOld) {
        boolean a_isOld =
          false;
        LogExpr a =
          new LogExpr(fallback_problem,
                      kodkod.ast.Variable.unary("a"));
        boolean i_isOld =
          false;
        LogExpr i =
          new LogExpr(fallback_problem,
                      kodkod.ast.Variable.unary("i"));
        boolean ii_isOld =
          false;
        LogExpr ii =
          new LogExpr(fallback_problem,
                      kodkod.ast.Variable.unary("ii"));
        boolean iii_isOld =
          false;
        LogExpr quantVar_iii =
          new LogExpr(fallback_problem,
                      kodkod.ast.Variable.unary("iii"));
        LogExpr iii =
          new LogExpr(fallback_problem,
                      quantVar_iii.expr());
        LogExpr fallback_var_iii =
          quantVar_iii;
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
        return LogExpr.quantifyOp(NewPeriodicSchedule.actions_get_log(fallback_problem,
                                                                      fallback_target,
                                                                      fallback_targetTypeArgsStr,
                                                                      fallback_targetTypeArgs,
                                                                      fallback_target_isOld),
                                  false,
                                  "all",
                                  a,
                                  TimedAction.type_get_log(fallback_problem,
                                                           a,
                                                           "",
                                                           null,
                                                           a_isOld).eq(ActionType.STAY_get_log(fallback_problem,
                                                                                               fallback_problem.class_log(ActionType.class),
                                                                                               "",
                                                                                               null,
                                                                                               fallback_target_isOld)).not().implies(LogExpr.quantifyOp(NewPeriodicSchedule.intervals_get_log(fallback_problem,
                                                                                                                                                                                              fallback_target,
                                                                                                                                                                                              fallback_targetTypeArgsStr,
                                                                                                                                                                                              fallback_targetTypeArgs,
                                                                                                                                                                                              fallback_target_isOld),
                                                                                                                                                        true,
                                                                                                                                                        "one",
                                                                                                                                                        i,
                                                                                                                                                        a.eq(Interval.start_get_log(fallback_problem,
                                                                                                                                                                                    i,
                                                                                                                                                                                    "",
                                                                                                                                                                                    null,
                                                                                                                                                                                    i_isOld)).and(TimedAction.type_get_log(fallback_problem,
                                                                                                                                                                                                                           a,
                                                                                                                                                                                                                           "",
                                                                                                                                                                                                                           null,
                                                                                                                                                                                                                           a_isOld).eq(ActionType.SCALE_UP_get_log(fallback_problem,
                                                                                                                                                                                                                                                                   fallback_problem.class_log(ActionType.class),
                                                                                                                                                                                                                                                                   "",
                                                                                                                                                                                                                                                                   null,
                                                                                                                                                                                                                                                                   fallback_target_isOld)).and(Interval.intervalDuration_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                 i,
                                                                                                                                                                                                                                                                                                                                 "",
                                                                                                                                                                                                                                                                                                                                 null,
                                                                                                                                                                                                                                                                                                                                 i_isOld).eq(NewPeriodicSchedule.stabilityPeriodUp_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                           fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                           fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                           fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                           fallback_target_isOld))).or(TimedAction.type_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                a,
                                                                                                                                                                                                                                                                                                                                                                                                                                                "",
                                                                                                                                                                                                                                                                                                                                                                                                                                                null,
                                                                                                                                                                                                                                                                                                                                                                                                                                                a_isOld).eq(ActionType.SCALE_DOWN_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          fallback_problem.class_log(ActionType.class),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          "",
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          null,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          fallback_target_isOld)).and(Interval.intervalDuration_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        i,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        "",
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        null,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        i_isOld).eq(NewPeriodicSchedule.stabilityPeriodDown_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    fallback_target_isOld))))).and(NewPeriodicSchedule.noSameStart_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       fallback_target_isOld,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       i,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       i_isOld))))).and(LogExpr.quantifyOp(NewPeriodicSchedule.intervals_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 fallback_target_isOld),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           false,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           "all",
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           ii,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           ii.eq(fallback_problem.null_log()).not())).and(LogExpr.quantifyOp(PBJInternSet.toPBJInternSet_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             PBJInternInteger.range_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        fallback_problem.class_log(PBJInternInteger.class),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        "",
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        null,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        fallback_target_isOld,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        new LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    kodkod.ast.IntConstant.constant(0)),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        fallback_target_isOld,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        NewPeriodicSchedule.intervals_get_log(fallback_problem,
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
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             fallback_var_iii,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             LogExpr.quantifyOp(PBJInternSet.toPBJInternSet_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                PBJInternInteger.range_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           fallback_problem.class_log(PBJInternInteger.class),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           "",
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           null,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           fallback_target_isOld,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           new LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       kodkod.ast.IntConstant.constant(0)),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           fallback_target_isOld,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           NewPeriodicSchedule.intervals_get_log(fallback_problem,
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
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                fallback_var_j,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                iii.eq(j).not().implies(NewPeriodicSchedule.intervals_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              fallback_target_isOld).get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             iii,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             false).eq(NewPeriodicSchedule.intervals_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             fallback_target_isOld).get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            j,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            false)).not()))));
    }
    
    static LogExpr noSameStart_log(LogProblem fallback_problem,
                                   LogExpr fallback_target,
                                   String fallback_targetTypeArgsStr,
                                   String[] fallback_targetTypeArgs,
                                   boolean fallback_target_isOld,
                                   LogExpr i,
                                   boolean i_isOld) {
        boolean ii_isOld =
          false;
        LogExpr ii =
          new LogExpr(fallback_problem,
                      kodkod.ast.Variable.unary("ii"));
        return LogExpr.quantifyOp(NewPeriodicSchedule.intervals_get_log(fallback_problem,
                                                                        fallback_target,
                                                                        fallback_targetTypeArgsStr,
                                                                        fallback_targetTypeArgs,
                                                                        fallback_target_isOld),
                                  false,
                                  "all",
                                  ii,
                                  i.eq(ii).not().and(Interval.start_get_log(fallback_problem,
                                                                            i,
                                                                            "",
                                                                            null,
                                                                            i_isOld).eq(Interval.start_get_log(fallback_problem,
                                                                                                               ii,
                                                                                                               "",
                                                                                                               null,
                                                                                                               ii_isOld))).not());
    }
    
    static LogExpr orderedIntervals_log(LogProblem fallback_problem,
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
        return NewPeriodicSchedule.intervals_get_log(fallback_problem,
                                                     fallback_target,
                                                     fallback_targetTypeArgsStr,
                                                     fallback_targetTypeArgs,
                                                     fallback_target_isOld).length_get_log(fallback_problem).gt(new LogExpr(fallback_problem,
                                                                                                                            kodkod.ast.IntConstant.constant(1))).implies(LogExpr.quantifyOp(PBJInternSet.toPBJInternSet_log(fallback_problem,
                                                                                                                                                                                                                            PBJInternInteger.range_log(fallback_problem,
                                                                                                                                                                                                                                                       fallback_problem.class_log(PBJInternInteger.class),
                                                                                                                                                                                                                                                       "",
                                                                                                                                                                                                                                                       null,
                                                                                                                                                                                                                                                       fallback_target_isOld,
                                                                                                                                                                                                                                                       new LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                   kodkod.ast.IntConstant.constant(0)),
                                                                                                                                                                                                                                                       fallback_target_isOld,
                                                                                                                                                                                                                                                       NewPeriodicSchedule.intervals_get_log(fallback_problem,
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
                                                                                                                                                                                            LogExpr.quantifyOp(PBJInternSet.toPBJInternSet_log(fallback_problem,
                                                                                                                                                                                                                                               PBJInternInteger.range_log(fallback_problem,
                                                                                                                                                                                                                                                                          fallback_problem.class_log(PBJInternInteger.class),
                                                                                                                                                                                                                                                                          "",
                                                                                                                                                                                                                                                                          null,
                                                                                                                                                                                                                                                                          fallback_target_isOld,
                                                                                                                                                                                                                                                                          new LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                      kodkod.ast.IntConstant.constant(0)),
                                                                                                                                                                                                                                                                          fallback_target_isOld,
                                                                                                                                                                                                                                                                          NewPeriodicSchedule.intervals_get_log(fallback_problem,
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
                                                                                                                                                                                                               fallback_var_j,
                                                                                                                                                                                                               i.lt(j).implies(TimedAction.time_get_log(fallback_problem,
                                                                                                                                                                                                                                                        Interval.start_get_log(fallback_problem,
                                                                                                                                                                                                                                                                               NewPeriodicSchedule.intervals_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                     fallback_target,
                                                                                                                                                                                                                                                                                                                     fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                     fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                     fallback_target_isOld).get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                    i,
                                                                                                                                                                                                                                                                                                                                                    false),
                                                                                                                                                                                                                                                                               "",
                                                                                                                                                                                                                                                                               null,
                                                                                                                                                                                                                                                                               fallback_target_isOld),
                                                                                                                                                                                                                                                        "",
                                                                                                                                                                                                                                                        null,
                                                                                                                                                                                                                                                        fallback_target_isOld).lte(TimedAction.time_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                            Interval.start_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                   NewPeriodicSchedule.intervals_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                         fallback_target,
                                                                                                                                                                                                                                                                                                                                                                         fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                         fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                         fallback_target_isOld).get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                        j,
                                                                                                                                                                                                                                                                                                                                                                                                        false),
                                                                                                                                                                                                                                                                                                                                   "",
                                                                                                                                                                                                                                                                                                                                   null,
                                                                                                                                                                                                                                                                                                                                   fallback_target_isOld),
                                                                                                                                                                                                                                                                                                            "",
                                                                                                                                                                                                                                                                                                            null,
                                                                                                                                                                                                                                                                                                            fallback_target_isOld))))));
    }
    
    public static LogExpr fallback_checkInvariants_log(LogProblem fallback_problem,
                                                       LogExpr fallback_target,
                                                       String fallback_targetTypeArgsStr,
                                                       String[] fallback_targetTypeArgs,
                                                       boolean fallback_target_isOld) {
        return new LogExpr(fallback_problem,
                           kodkod.ast.Formula.TRUE);
    }
    
    public static LogExpr findTheIntervals_checkContract_log(LogProblem fallback_problem,
                                                             LogExpr fallback_target,
                                                             String fallback_targetTypeArgsStr,
                                                             String[] fallback_targetTypeArgs,
                                                             boolean fallback_target_isOld) {
        return NewPeriodicSchedule.fallback_checkInvariants_log(fallback_problem,
                                                                fallback_target,
                                                                fallback_targetTypeArgsStr,
                                                                fallback_targetTypeArgs,
                                                                fallback_target_isOld).and(NewPeriodicSchedule.findTheIntervals_checkFieldsInvariants_log(fallback_problem,
                                                                                                                                                          fallback_target,
                                                                                                                                                          fallback_targetTypeArgsStr,
                                                                                                                                                          fallback_targetTypeArgs,
                                                                                                                                                          fallback_target_isOld)).and(NewPeriodicSchedule.intervals_get_log(fallback_problem,
                                                                                                                                                                                                                            fallback_target,
                                                                                                                                                                                                                            fallback_targetTypeArgsStr,
                                                                                                                                                                                                                            fallback_targetTypeArgs,
                                                                                                                                                                                                                            fallback_target_isOld).no().not().and(NewPeriodicSchedule.findIntervals_log(fallback_problem,
                                                                                                                                                                                                                                                                                                        fallback_target,
                                                                                                                                                                                                                                                                                                        fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                        fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                        fallback_target_isOld)).and(NewPeriodicSchedule.orderedIntervals_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                             fallback_target,
                                                                                                                                                                                                                                                                                                                                                                             fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                             fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                             fallback_target_isOld)));
    }
    
    public static LogExpr findTheIntervals_checkFieldsInvariants_log(LogProblem fallback_problem,
                                                                     LogExpr fallback_target,
                                                                     String fallback_targetTypeArgsStr,
                                                                     String[] fallback_targetTypeArgs,
                                                                     boolean fallback_target_isOld) {
        return new LogExpr(fallback_problem,
                           kodkod.ast.Formula.TRUE);
    }
    
    public static LogExpr findNextTrigger_checkContract_log(LogProblem fallback_problem,
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
        boolean interval_isOld =
          false;
        LogExpr interval =
          new LogExpr(fallback_problem,
                      kodkod.ast.Variable.unary("interval"));
        return NewPeriodicSchedule.fallback_checkInvariants_log(fallback_problem,
                                                                fallback_target,
                                                                fallback_targetTypeArgsStr,
                                                                fallback_targetTypeArgs,
                                                                fallback_target_isOld).and(NewPeriodicSchedule.findNextTrigger_checkFieldsInvariants_log(fallback_problem,
                                                                                                                                                         fallback_target,
                                                                                                                                                         fallback_targetTypeArgsStr,
                                                                                                                                                         fallback_targetTypeArgs,
                                                                                                                                                         fallback_target_isOld)).and(NewPeriodicSchedule.intervals_get_log(fallback_problem,
                                                                                                                                                                                                                           fallback_target,
                                                                                                                                                                                                                           fallback_targetTypeArgsStr,
                                                                                                                                                                                                                           fallback_targetTypeArgs,
                                                                                                                                                                                                                           fallback_target_isOld).length_get_log(fallback_problem).eq(NewPeriodicSchedule.intervals_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                            fallback_target,
                                                                                                                                                                                                                                                                                                                            fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                            fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                            true).length_get_log(fallback_problem).minus(new LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                     kodkod.ast.IntConstant.constant(1)))).and(NewPeriodicSchedule.intervals_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                     fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                     fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                     fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                     fallback_target_isOld).length_get_log(fallback_problem).gt(new LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            kodkod.ast.IntConstant.constant(1))).implies(LogExpr.quantifyOp(PBJInternSet.toPBJInternSet_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            PBJInternInteger.range_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       fallback_problem.class_log(PBJInternInteger.class),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       "",
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       null,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       fallback_target_isOld,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       new LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   kodkod.ast.IntConstant.constant(0)),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       fallback_target_isOld,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       NewPeriodicSchedule.intervals_get_log(fallback_problem,
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
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            LogExpr.quantifyOp(PBJInternSet.toPBJInternSet_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               PBJInternInteger.range_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          fallback_problem.class_log(PBJInternInteger.class),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          "",
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          null,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          fallback_target_isOld,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          new LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      kodkod.ast.IntConstant.constant(0)),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          fallback_target_isOld,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          NewPeriodicSchedule.intervals_get_log(fallback_problem,
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
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               fallback_var_j,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               i.eq(j).not().implies(NewPeriodicSchedule.intervals_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           fallback_target_isOld).get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          i,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          false).eq(NewPeriodicSchedule.intervals_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          fallback_target_isOld).get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         j,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         false)).not()))))).and(NewPeriodicSchedule.intervals_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      fallback_target_isOld).length_get_log(fallback_problem).gt(new LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             kodkod.ast.IntConstant.constant(0))).implies(LogExpr.quantifyOp(NewPeriodicSchedule.intervals_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   fallback_target_isOld),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             false,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             "all",
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             interval,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             interval.eq(fallback_problem.null_log()).not()))));
    }
    
    public static LogExpr findNextTrigger_checkFieldsInvariants_log(LogProblem fallback_problem,
                                                                    LogExpr fallback_target,
                                                                    String fallback_targetTypeArgsStr,
                                                                    String[] fallback_targetTypeArgs,
                                                                    boolean fallback_target_isOld) {
        return new LogExpr(fallback_problem,
                           kodkod.ast.Formula.TRUE).and(fallback_target.eq(fallback_problem.null_log()).or(NewPeriodicSchedule.fallback_checkInvariants_log(fallback_problem,
                                                                                                                                                            fallback_target,
                                                                                                                                                            fallback_targetTypeArgsStr,
                                                                                                                                                            fallback_targetTypeArgs,
                                                                                                                                                            true)));
    }
    
    public static LogExpr updateTypes_checkContract_log(LogProblem fallback_problem,
                                                        LogExpr fallback_target,
                                                        String fallback_targetTypeArgsStr,
                                                        String[] fallback_targetTypeArgs,
                                                        boolean fallback_target_isOld) {
        boolean t_isOld =
          false;
        LogExpr t =
          new LogExpr(fallback_problem,
                      kodkod.ast.Variable.unary("t"));
        return NewPeriodicSchedule.fallback_checkInvariants_log(fallback_problem,
                                                                fallback_target,
                                                                fallback_targetTypeArgsStr,
                                                                fallback_targetTypeArgs,
                                                                fallback_target_isOld).and(NewPeriodicSchedule.updateTypes_checkFieldsInvariants_log(fallback_problem,
                                                                                                                                                     fallback_target,
                                                                                                                                                     fallback_targetTypeArgsStr,
                                                                                                                                                     fallback_targetTypeArgs,
                                                                                                                                                     fallback_target_isOld)).and(LogExpr.quantifyOp(NewPeriodicSchedule.inputActions_get_log(fallback_problem,
                                                                                                                                                                                                                                             fallback_target,
                                                                                                                                                                                                                                             fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                             fallback_targetTypeArgs,
                                                                                                                                                                                                                                             fallback_target_isOld),
                                                                                                                                                                                                    false,
                                                                                                                                                                                                    "all",
                                                                                                                                                                                                    t,
                                                                                                                                                                                                    TimedAction.validType_log(fallback_problem,
                                                                                                                                                                                                                              t,
                                                                                                                                                                                                                              "",
                                                                                                                                                                                                                              null,
                                                                                                                                                                                                                              t_isOld)));
    }
    
    public static LogExpr updateTypes_checkFieldsInvariants_log(LogProblem fallback_problem,
                                                                LogExpr fallback_target,
                                                                String fallback_targetTypeArgsStr,
                                                                String[] fallback_targetTypeArgs,
                                                                boolean fallback_target_isOld) {
        return new LogExpr(fallback_problem,
                           kodkod.ast.Formula.TRUE);
    }
}
