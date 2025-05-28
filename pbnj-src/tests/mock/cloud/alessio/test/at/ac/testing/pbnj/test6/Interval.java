package at.ac.testing.pbnj.test6;

import polyglot.ext.pbnj.tologic.*;
import polyglot.ext.pbnj.primitives.*;
import pbnj.util.ArrayList;
import java.util.Arrays;

public class Interval implements PBJInternObject {
    public TimedAction start;
    
    public int intervalDuration;
    
    public int stable;
    
    public String toString() {
        return "Interval: stability " + stable + " duration " + intervalDuration + " action " + start + "\n"; }
    
    public Interval old;
    
    public boolean fallback_pbnj;
    
    Object fallback_field_result;
    
    public void fallback_field_result(Object r) { this.fallback_field_result = r; }
    
    public Interval() { super();
                        this.addInstance(); }
    
    public Interval(LogExpr dontcare) { super();
                                        this.addInstance(); }
    
    Object[] fallback_field_resultArray;
    
    public void fallback_field_resultArray(Object[] r) { this.fallback_field_resultArray = r; }
    
    public boolean fallback_checkInvariants() { return true; }
    
    public void addInstance() { LogMap.addInstance(Interval.class, this); }
    
    public void addInstanceForProblem(Interval toAdd, LogProblem fallback_problem, String fallback_targetTypeArgsStr) {
        fallback_problem.addToClassInstances(toAdd, Interval.class, "at.ac.testing.pbnj.test6.Interval",
                                             fallback_targetTypeArgsStr);
    }
    
    long startMethodTime;
    
    boolean isOld;
    
    Object fallback_consistencyLock;
    
    int fallback_updateTime;
    
    public Interval old() { return this.old; }
    
    String[] fallback_typeArgs;
    
    public Interval fallback_setTypeArgs(String[] args) { this.fallback_typeArgs = args;
                                                          return this; }
    
    int clonerStep = 0;
    
    int atomizerStep = 0;
    
    boolean isCloned() { return this.clonerStep == LogMap.clonerStep(); }
    
    boolean isAtomized(LogProblem fallback_problem) { return this.atomizerStep == fallback_problem.relationizerStep(); }
    
    int relationizerStep = 0;
    
    boolean isRelationized(LogProblem fallback_problem) {
        return this.relationizerStep == fallback_problem.relationizerStep(); }
    
    public static int classRelationizerStep = 0;
    
    public static boolean isClassRelationized(LogProblem fallback_problem) {
        return Interval.classRelationizerStep == fallback_problem.relationizerStep(); }
    
    public static int classAtomizerStep = 0;
    
    public static boolean isClassAtomized(LogProblem fallback_problem) {
        return Interval.classAtomizerStep == fallback_problem.relationizerStep(); }
    
    public static int classClonerStep = 0;
    
    public static boolean isClassCloned() { return Interval.classClonerStep == LogMap.clonerStep(); }
    
    void initEnsuredMethod() { this.startMethodTime = System.currentTimeMillis();
                               LogMap.incrClonerStep();
                               fallback_clone(); }
    
    public void fallback_updateField(java.lang.reflect.Method updaterMtd, Object[] args) {
        try { updaterMtd.invoke(this, args); }
        catch (Exception rte) { rte.printStackTrace(); } }
    
    public Object fallback_newInstance(java.lang.reflect.Constructor cons, Object[] args, String[] typeParamNames) {
        try { return ((PBJInternObject) cons.newInstance(args)).fallback_setTypeArgs(typeParamNames); }
        catch (Exception rte) { rte.printStackTrace();
                                return null; } }
    
    public void fallback_atomize(LogProblem fallback_problem, String fallback_targetTypeArgsStr,
                                 String[] fallback_targetTypeArgs) {
        if (!isAtomized(fallback_problem)) {
            this.atomizerStep = fallback_problem.relationizerStep();
            Interval.fallback_classAtomize(fallback_problem, fallback_targetTypeArgsStr, fallback_targetTypeArgs);
            this.addInstanceForProblem(this.old, fallback_problem, fallback_targetTypeArgsStr);
            if (this.start != null) this.start.fallback_atomize(fallback_problem, "", null); }
    }
    
    public void fallback_relationizeOld(LogProblem fallback_problem, String fallback_targetTypeArgsStr,
                                        String[] fallback_targetTypeArgs) {
        if (!isRelationized(fallback_problem)) {
            this.relationizerStep = fallback_problem.relationizerStep();
            Interval.fallback_classRelationizeOld(fallback_problem, fallback_targetTypeArgsStr,
                                                  fallback_targetTypeArgs);
            if (this.start != null) this.start.fallback_relationizeOld(fallback_problem, "", null);
            Interval.start_old_get_log(fallback_problem, fallback_targetTypeArgsStr,
                                       fallback_targetTypeArgs).put_log(fallback_problem, this, this.start);
            Interval.intervalDuration_old_get_log(fallback_problem, fallback_targetTypeArgsStr,
                                                  fallback_targetTypeArgs).put_log(fallback_problem, this,
                                                                                   this.intervalDuration);
            Interval.stable_old_get_log(fallback_problem, fallback_targetTypeArgsStr,
                                        fallback_targetTypeArgs).put_log(fallback_problem, this, this.stable);
        }
    }
    
    public static void fallback_classAtomize(LogProblem fallback_problem, String fallback_targetTypeArgsStr,
                                             String[] fallback_targetTypeArgs) {
        if (!isClassAtomized(fallback_problem)) { Interval.classAtomizerStep = fallback_problem.relationizerStep(); }
    }
    
    public static void fallback_classRelationizeOld(LogProblem fallback_problem, String fallback_targetTypeArgsStr,
                                                    String[] fallback_targetTypeArgs) {
        if (!isClassRelationized(fallback_problem)) {
            Interval.classRelationizerStep = fallback_problem.relationizerStep(); }
    }
    
    public static void fallback_classClone() { if (isClassCloned()) return; }
    
    public Interval fallback_clone() { if (isCloned()) return old;
                                       Interval res = null;
                                       Interval.fallback_classClone();
                                       try { res = (Interval) super.clone();
                                             res.isOld = true;
                                             this.old = res;
                                             res.old = this;
                                             this.fallback_consistencyLock = new Object();
                                             this.clonerStep = LogMap.clonerStep();
                                             if (this.start != null) res.start = this.start.fallback_clone();
                                             res.intervalDuration = this.intervalDuration;
                                             res.stable = this.stable; }
                                       catch (Exception rte) { rte.printStackTrace();
                                                               System.exit(1); }
                                       return res; }
    
    public static LogExpr start_get_log(LogProblem fallback_problem, LogExpr fallback_target,
                                        String fallback_targetTypeArgsStr, String[] fallback_targetTypeArgs,
                                        boolean isOld) {
        return LogMap.fieldGet_log(fallback_problem, fallback_target, "at.ac.testing.pbnj.test6.Interval",
                                   fallback_targetTypeArgsStr, "start", isOld);
    }
    
    public static LogRelation start_old_get_log(LogProblem fallback_problem, String fallback_targetTypeArgsStr,
                                                String[] fallback_targetTypeArgs) {
        return LogMap.oldFieldGet_log(fallback_problem, "at.ac.testing.pbnj.test6.Interval", fallback_targetTypeArgsStr,
                                      "start");
    }
    
    public TimedAction fallback_updateField_start(TimedAction newVal) { return this.start = newVal; }
    
    public PBJInternSet<TimedAction> fieldsClosure_TimedAction(Object fallback_target, boolean isReflexive,
                                                               java.lang.String ... fieldNs) {
        Class c = TimedAction.class;
        PBJInternSet<TimedAction> res = new PBJInternSet<TimedAction>();
        java.util.ArrayList<TimedAction> workList = new java.util.ArrayList<TimedAction>();
        try {
            java.util.ArrayList<java.lang.reflect.Field> fields = new java.util.ArrayList<java.lang.reflect.Field>();
            for (String fN : fieldNs) { fields.add(c.getField(fN)); }
            for (java.lang.reflect.Field f : fields) {
                TimedAction childN = (TimedAction) f.get(fallback_target);
                if (!(childN == null || res.containsPtrEqCmp(childN))) workList.add(childN); }
            TimedAction n;
            while (workList.size() > 0) {
                n = workList.get(0);
                res.add(n);
                for (java.lang.reflect.Field f : fields) {
                    TimedAction childN = (TimedAction) f.get(n);
                    if (!(childN == null || res.containsPtrEqCmp(childN))) workList.add(childN); }
                workList.remove(n);
            }
            if (isReflexive) res.add((TimedAction) fallback_target);
        }
        catch (Exception rte) { rte.printStackTrace(); }
        return res;
    }
    
    PBJInternSet<TimedAction> multiFields_TimedAction(java.lang.String ... fieldNs) {
        Class c = TimedAction.class;
        PBJInternSet<TimedAction> res = new PBJInternSet<TimedAction>();
        try { for (String fN : fieldNs) { java.lang.reflect.Field f = c.getField(fN);
                                          TimedAction n = (TimedAction) f.get(this);
                                          if (n != null) res.add(n); } }
        catch (Exception rte) { rte.printStackTrace(); }
        return res; }
    
    public static LogExpr intervalDuration_get_log(LogProblem fallback_problem, LogExpr fallback_target,
                                                   String fallback_targetTypeArgsStr, String[] fallback_targetTypeArgs,
                                                   boolean isOld) {
        return LogMap.fieldGet_log(fallback_problem, fallback_target, "at.ac.testing.pbnj.test6.Interval",
                                   fallback_targetTypeArgsStr, "intervalDuration", isOld);
    }
    
    public static LogRelation intervalDuration_old_get_log(LogProblem fallback_problem,
                                                           String fallback_targetTypeArgsStr,
                                                           String[] fallback_targetTypeArgs) {
        return LogMap.oldFieldGet_log(fallback_problem, "at.ac.testing.pbnj.test6.Interval", fallback_targetTypeArgsStr,
                                      "intervalDuration");
    }
    
    public int fallback_updateField_intervalDuration(Integer newVal) { return this.intervalDuration = newVal; }
    
    public PBJInternSet<Integer> fieldsClosure_Integer(Object fallback_target, boolean isReflexive,
                                                       java.lang.String ... fieldNs) {
        Class c = int.class;
        PBJInternSet<Integer> res = new PBJInternSet<Integer>();
        java.util.ArrayList<Integer> workList = new java.util.ArrayList<Integer>();
        try {
            java.util.ArrayList<java.lang.reflect.Field> fields = new java.util.ArrayList<java.lang.reflect.Field>();
            for (String fN : fieldNs) { fields.add(c.getField(fN)); }
            for (java.lang.reflect.Field f : fields) {
                Integer childN = (Integer) f.get(fallback_target);
                if (!(childN == null || res.containsPtrEqCmp(childN))) workList.add(childN); }
            Integer n;
            while (workList.size() > 0) {
                n = workList.get(0);
                res.add(n);
                for (java.lang.reflect.Field f : fields) {
                    Integer childN = (Integer) f.get(n);
                    if (!(childN == null || res.containsPtrEqCmp(childN))) workList.add(childN); }
                workList.remove(n);
            }
            if (isReflexive) res.add((Integer) fallback_target);
        }
        catch (Exception rte) { rte.printStackTrace(); }
        return res;
    }
    
    PBJInternSet<Integer> multiFields_Integer(java.lang.String ... fieldNs) {
        Class c = Integer.class;
        PBJInternSet<Integer> res = new PBJInternSet<Integer>();
        try { for (String fN : fieldNs) { java.lang.reflect.Field f = c.getField(fN);
                                          Integer n = (Integer) f.get(this);
                                          if (n != null) res.add(n); } }
        catch (Exception rte) { rte.printStackTrace(); }
        return res; }
    
    public static LogExpr stable_get_log(LogProblem fallback_problem, LogExpr fallback_target,
                                         String fallback_targetTypeArgsStr, String[] fallback_targetTypeArgs,
                                         boolean isOld) {
        return LogMap.fieldGet_log(fallback_problem, fallback_target, "at.ac.testing.pbnj.test6.Interval",
                                   fallback_targetTypeArgsStr, "stable", isOld);
    }
    
    public static LogRelation stable_old_get_log(LogProblem fallback_problem, String fallback_targetTypeArgsStr,
                                                 String[] fallback_targetTypeArgs) {
        return LogMap.oldFieldGet_log(fallback_problem, "at.ac.testing.pbnj.test6.Interval", fallback_targetTypeArgsStr,
                                      "stable");
    }
    
    public int fallback_updateField_stable(Integer newVal) { return this.stable = newVal; }
    
    public static PBJInternSet<TimedAction> setMap_start(PBJInternSet<Interval> objs, java.lang.String ... fieldNs) {
        PBJInternSet<TimedAction> res = new PBJInternSet<TimedAction>();
        java.util.Iterator<Interval> i = objs.iterator();
        while (i.hasNext()) { res.add(i.next().start); }
        return res; }
    
    public static PBJInternSet<Integer> setMap_intervalDuration(PBJInternSet<Interval> objs,
                                                                java.lang.String ... fieldNs) {
        PBJInternSet<Integer> res = new PBJInternSet<Integer>();
        java.util.Iterator<Interval> i = objs.iterator();
        while (i.hasNext()) { res.add(i.next().intervalDuration); }
        return res;
    }
    
    public static PBJInternSet<Integer> setMap_stable(PBJInternSet<Interval> objs, java.lang.String ... fieldNs) {
        PBJInternSet<Integer> res = new PBJInternSet<Integer>();
        java.util.Iterator<Interval> i = objs.iterator();
        while (i.hasNext()) { res.add(i.next().stable); }
        return res; }
    
    public static void fallback_initClassDefs() {  }
    
    static {
               LogMap.newClassForLog(Interval.class, true);
               LogMap.newInstVarRel("start", Interval.class, "at.ac.testing.pbnj.test6.Interval", TimedAction.class,
                                    "at.ac.testing.pbnj.test6.TimedAction", null, null, false, false, 0, true, false,
                                    false, false, false);
               LogMap.newInstVarRel("intervalDuration", Interval.class, "at.ac.testing.pbnj.test6.Interval",
                                    Integer.class, "int", null, null, false, false, 0, true, false, false, false,
                                    false);
               LogMap.newInstVarRel("stable", Interval.class, "at.ac.testing.pbnj.test6.Interval", Integer.class,
                                    "int", null, null, false, false, 0, true, false, false, false, false);
           }
    
    public static LogExpr fallback_checkInvariants_log(LogProblem fallback_problem, LogExpr fallback_target,
                                                       String fallback_targetTypeArgsStr,
                                                       String[] fallback_targetTypeArgs,
                                                       boolean fallback_target_isOld) {
        return new LogExpr(fallback_problem, kodkod.ast.Formula.TRUE);
    }
}
