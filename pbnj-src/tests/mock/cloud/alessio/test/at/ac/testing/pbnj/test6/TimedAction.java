package at.ac.testing.pbnj.test6;

public class TimedAction implements polyglot.ext.pbnj.primitives.PBJInternObject {
    public int time =
      -1;
    
    public int startSize =
      -1;
    
    public int targetSize =
      -1;
    
    public ActionType type;
    
    public TimedAction() {
        super();
        this.addInstance();
    }
    
    public TimedAction(int time,
                       int startSize,
                       int targetSize,
                       ActionType type) {
        super();
        this.time =
          time;
        this.startSize =
          startSize;
        this.targetSize =
          targetSize;
        this.type =
          type;
        this.addInstance();
    }
    
    public TimedAction(int time,
                       int startSize,
                       int targetSize) {
        super();
        this.time =
          time;
        this.startSize =
          startSize;
        this.targetSize =
          targetSize;
        this.addInstance();
    }
    
    public TimedAction(int time,
                       int startSize,
                       ActionType type) {
        super();
        this.time =
          time;
        this.startSize =
          startSize;
        this.type =
          type;
        this.addInstance();
    }
    
    public TimedAction(int time,
                       ActionType type) {
        super();
        this.time =
          time;
        this.type =
          type;
        this.addInstance();
    }
    
    public TimedAction(int time,
                       ActionType type,
                       int targetSize) {
        super();
        this.time =
          time;
        this.type =
          type;
        this.targetSize =
          targetSize;
        this.addInstance();
    }
    
    public boolean equalsTo(TimedAction t) {
        return this.time ==
                 t.time &&
                 this.startSize ==
                   t.startSize &&
                 this.targetSize ==
                   t.targetSize &&
          this.type ==
            t.type;
    }
    
    public boolean validType() {
        return !(this.startSize >
                   -1 &&
                   this.targetSize >
                     -1) ||
          (this.startSize <
             this.targetSize &&
             this.type ==
               ActionType.SCALE_UP ||
             this.startSize >
               this.targetSize &&
               this.type ==
                 ActionType.SCALE_DOWN ||
             this.startSize ==
               this.targetSize &&
               this.type ==
                 ActionType.STAY);
    }
    
    public boolean valid() {
        return time >=
                 0 &&
                 startSize >=
                   0 &&
                 targetSize >=
                   0 &&
          validType();
    }
    
    public String toString() {
        return String.format("%4d : %-11s\t [%3d --> %3d]\t (%d)",
                             time,
                             type,
                             startSize,
                             targetSize,
                             hashCode());
    }
    
    public TimedAction old;
    
    public boolean fallback_pbnj;
    
    Object fallback_field_result;
    
    public void fallback_field_result(Object r) {
        this.fallback_field_result =
          r;
    }
    
    public TimedAction(polyglot.ext.pbnj.tologic.LogExpr dontcare) {
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
        polyglot.ext.pbnj.tologic.LogMap.addInstance(TimedAction.class,
                                                     this);
    }
    
    public void addInstanceForProblem(TimedAction toAdd,
                                      polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                      String fallback_targetTypeArgsStr) {
        fallback_problem.addToClassInstances(toAdd,
                                             TimedAction.class,
                                             "at.ac.testing.pbnj.test6.TimedAction",
                                             fallback_targetTypeArgsStr);
    }
    
    long startMethodTime;
    
    boolean isOld;
    
    Object fallback_consistencyLock;
    
    int fallback_updateTime;
    
    public TimedAction old() {
        return this.old;
    }
    
    String[] fallback_typeArgs;
    
    public TimedAction fallback_setTypeArgs(String[] args) {
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
        return TimedAction.classRelationizerStep ==
          fallback_problem.relationizerStep();
    }
    
    public static int classAtomizerStep =
      0;
    
    public static boolean isClassAtomized(polyglot.ext.pbnj.tologic.LogProblem fallback_problem) {
        return TimedAction.classAtomizerStep ==
          fallback_problem.relationizerStep();
    }
    
    public static int classClonerStep =
      0;
    
    public static boolean isClassCloned() {
        return TimedAction.classClonerStep ==
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
    
    public void fallback_atomize(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                 String fallback_targetTypeArgsStr,
                                 String[] fallback_targetTypeArgs) {
        if (!isAtomized(fallback_problem)) {
            this.atomizerStep =
              fallback_problem.relationizerStep();
            TimedAction.fallback_classAtomize(fallback_problem,
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
            TimedAction.fallback_classRelationizeOld(fallback_problem,
                                                     fallback_targetTypeArgsStr,
                                                     fallback_targetTypeArgs);
            TimedAction.time_old_get_log(fallback_problem,
                                         fallback_targetTypeArgsStr,
                                         fallback_targetTypeArgs).put_log(fallback_problem,
                                                                          this,
                                                                          this.time);
            TimedAction.startSize_old_get_log(fallback_problem,
                                              fallback_targetTypeArgsStr,
                                              fallback_targetTypeArgs).put_log(fallback_problem,
                                                                               this,
                                                                               this.startSize);
            TimedAction.targetSize_old_get_log(fallback_problem,
                                               fallback_targetTypeArgsStr,
                                               fallback_targetTypeArgs).put_log(fallback_problem,
                                                                                this,
                                                                                this.targetSize);
            TimedAction.type_old_get_log(fallback_problem,
                                         fallback_targetTypeArgsStr,
                                         fallback_targetTypeArgs).put_log(fallback_problem,
                                                                          this,
                                                                          this.type);
        }
    }
    
    public static void fallback_classAtomize(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                             String fallback_targetTypeArgsStr,
                                             String[] fallback_targetTypeArgs) {
        if (!isClassAtomized(fallback_problem)) {
            TimedAction.classAtomizerStep =
              fallback_problem.relationizerStep();
        }
    }
    
    public static void fallback_classRelationizeOld(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                    String fallback_targetTypeArgsStr,
                                                    String[] fallback_targetTypeArgs) {
        if (!isClassRelationized(fallback_problem)) {
            TimedAction.classRelationizerStep =
              fallback_problem.relationizerStep();
        }
    }
    
    public static void fallback_classClone() {
        if (isClassCloned())
            return;
    }
    
    public TimedAction fallback_clone() {
        if (isCloned())
            return old;
        TimedAction res =
          null;
        TimedAction.fallback_classClone();
        try {
            res =
              (TimedAction)
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
            res.time =
              this.time;
            res.startSize =
              this.startSize;
            res.targetSize =
              this.targetSize;
            res.type =
              this.type;
        }
        catch (Exception rte) {
            rte.printStackTrace();
            System.exit(1);
        }
        return res;
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr time_get_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                 polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                 String fallback_targetTypeArgsStr,
                                                                 String[] fallback_targetTypeArgs,
                                                                 boolean isOld) {
        return polyglot.ext.pbnj.tologic.LogMap.fieldGet_log(fallback_problem,
                                                             fallback_target,
                                                             "at.ac.testing.pbnj.test6.TimedAction",
                                                             fallback_targetTypeArgsStr,
                                                             "time",
                                                             isOld);
    }
    
    public static polyglot.ext.pbnj.tologic.LogRelation time_old_get_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                         String fallback_targetTypeArgsStr,
                                                                         String[] fallback_targetTypeArgs) {
        return polyglot.ext.pbnj.tologic.LogMap.oldFieldGet_log(fallback_problem,
                                                                "at.ac.testing.pbnj.test6.TimedAction",
                                                                fallback_targetTypeArgsStr,
                                                                "time");
    }
    
    public int fallback_updateField_time(Integer newVal) {
        return this.time =
          newVal;
    }
    
    public polyglot.ext.pbnj.primitives.PBJInternSet<Integer> fieldsClosure_Integer(Object fallback_target,
                                                                                    boolean isReflexive,
                                                                                    java.lang.String ... fieldNs) {
        Class c =
          int.class;
        polyglot.ext.pbnj.primitives.PBJInternSet<Integer> res =
          new polyglot.ext.pbnj.primitives.PBJInternSet<Integer>();
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
    
    polyglot.ext.pbnj.primitives.PBJInternSet<Integer> multiFields_Integer(java.lang.String ... fieldNs) {
        Class c =
          Integer.class;
        polyglot.ext.pbnj.primitives.PBJInternSet<Integer> res =
          new polyglot.ext.pbnj.primitives.PBJInternSet<Integer>();
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
    
    public static polyglot.ext.pbnj.tologic.LogExpr startSize_get_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                      polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                      String fallback_targetTypeArgsStr,
                                                                      String[] fallback_targetTypeArgs,
                                                                      boolean isOld) {
        return polyglot.ext.pbnj.tologic.LogMap.fieldGet_log(fallback_problem,
                                                             fallback_target,
                                                             "at.ac.testing.pbnj.test6.TimedAction",
                                                             fallback_targetTypeArgsStr,
                                                             "startSize",
                                                             isOld);
    }
    
    public static polyglot.ext.pbnj.tologic.LogRelation startSize_old_get_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                              String fallback_targetTypeArgsStr,
                                                                              String[] fallback_targetTypeArgs) {
        return polyglot.ext.pbnj.tologic.LogMap.oldFieldGet_log(fallback_problem,
                                                                "at.ac.testing.pbnj.test6.TimedAction",
                                                                fallback_targetTypeArgsStr,
                                                                "startSize");
    }
    
    public int fallback_updateField_startSize(Integer newVal) {
        return this.startSize =
          newVal;
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr targetSize_get_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                       polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                       String fallback_targetTypeArgsStr,
                                                                       String[] fallback_targetTypeArgs,
                                                                       boolean isOld) {
        return polyglot.ext.pbnj.tologic.LogMap.fieldGet_log(fallback_problem,
                                                             fallback_target,
                                                             "at.ac.testing.pbnj.test6.TimedAction",
                                                             fallback_targetTypeArgsStr,
                                                             "targetSize",
                                                             isOld);
    }
    
    public static polyglot.ext.pbnj.tologic.LogRelation targetSize_old_get_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                               String fallback_targetTypeArgsStr,
                                                                               String[] fallback_targetTypeArgs) {
        return polyglot.ext.pbnj.tologic.LogMap.oldFieldGet_log(fallback_problem,
                                                                "at.ac.testing.pbnj.test6.TimedAction",
                                                                fallback_targetTypeArgsStr,
                                                                "targetSize");
    }
    
    public int fallback_updateField_targetSize(Integer newVal) {
        return this.targetSize =
          newVal;
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr type_get_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                 polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                 String fallback_targetTypeArgsStr,
                                                                 String[] fallback_targetTypeArgs,
                                                                 boolean isOld) {
        return polyglot.ext.pbnj.tologic.LogMap.fieldGet_log(fallback_problem,
                                                             fallback_target,
                                                             "at.ac.testing.pbnj.test6.TimedAction",
                                                             fallback_targetTypeArgsStr,
                                                             "type",
                                                             isOld);
    }
    
    public static polyglot.ext.pbnj.tologic.LogRelation type_old_get_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                         String fallback_targetTypeArgsStr,
                                                                         String[] fallback_targetTypeArgs) {
        return polyglot.ext.pbnj.tologic.LogMap.oldFieldGet_log(fallback_problem,
                                                                "at.ac.testing.pbnj.test6.TimedAction",
                                                                fallback_targetTypeArgsStr,
                                                                "type");
    }
    
    public ActionType fallback_updateField_type(ActionType newVal) {
        return this.type =
          newVal;
    }
    
    public polyglot.ext.pbnj.primitives.PBJInternSet<ActionType> fieldsClosure_ActionType(Object fallback_target,
                                                                                          boolean isReflexive,
                                                                                          java.lang.String ... fieldNs) {
        Class c =
          ActionType.class;
        polyglot.ext.pbnj.primitives.PBJInternSet<ActionType> res =
          new polyglot.ext.pbnj.primitives.PBJInternSet<ActionType>();
        java.util.ArrayList<ActionType> workList =
          new java.util.ArrayList<ActionType>();
        try {
            java.util.ArrayList<java.lang.reflect.Field> fields =
              new java.util.ArrayList<java.lang.reflect.Field>();
            for (String fN : fieldNs) {
                fields.add(c.getField(fN));
            }
            for (java.lang.reflect.Field f : fields) {
                ActionType childN =
                  (ActionType)
                    f.get(fallback_target);
                if (!(childN ==
                        null ||
                        res.containsPtrEqCmp(childN)))
                    workList.add(childN);
            }
            ActionType n;
            while (workList.size() >
                     0) {
                n =
                  workList.get(0);
                res.add(n);
                for (java.lang.reflect.Field f : fields) {
                    ActionType childN =
                      (ActionType)
                        f.get(n);
                    if (!(childN ==
                            null ||
                            res.containsPtrEqCmp(childN)))
                        workList.add(childN);
                }
                workList.remove(n);
            }
            if (isReflexive)
                res.add((ActionType)
                          fallback_target);
        }
        catch (Exception rte) {
            rte.printStackTrace();
        }
        return res;
    }
    
    polyglot.ext.pbnj.primitives.PBJInternSet<ActionType> multiFields_ActionType(java.lang.String ... fieldNs) {
        Class c =
          ActionType.class;
        polyglot.ext.pbnj.primitives.PBJInternSet<ActionType> res =
          new polyglot.ext.pbnj.primitives.PBJInternSet<ActionType>();
        try {
            for (String fN : fieldNs) {
                java.lang.reflect.Field f =
                  c.getField(fN);
                ActionType n =
                  (ActionType)
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
    
    public static polyglot.ext.pbnj.primitives.PBJInternSet<Integer> setMap_time(polyglot.ext.pbnj.primitives.PBJInternSet<TimedAction> objs,
                                                                                 java.lang.String ... fieldNs) {
        polyglot.ext.pbnj.primitives.PBJInternSet<Integer> res =
          new polyglot.ext.pbnj.primitives.PBJInternSet<Integer>();
        java.util.Iterator<TimedAction> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().time);
        }
        return res;
    }
    
    public static polyglot.ext.pbnj.primitives.PBJInternSet<Integer> setMap_startSize(polyglot.ext.pbnj.primitives.PBJInternSet<TimedAction> objs,
                                                                                      java.lang.String ... fieldNs) {
        polyglot.ext.pbnj.primitives.PBJInternSet<Integer> res =
          new polyglot.ext.pbnj.primitives.PBJInternSet<Integer>();
        java.util.Iterator<TimedAction> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().startSize);
        }
        return res;
    }
    
    public static polyglot.ext.pbnj.primitives.PBJInternSet<Integer> setMap_targetSize(polyglot.ext.pbnj.primitives.PBJInternSet<TimedAction> objs,
                                                                                       java.lang.String ... fieldNs) {
        polyglot.ext.pbnj.primitives.PBJInternSet<Integer> res =
          new polyglot.ext.pbnj.primitives.PBJInternSet<Integer>();
        java.util.Iterator<TimedAction> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().targetSize);
        }
        return res;
    }
    
    public static polyglot.ext.pbnj.primitives.PBJInternSet<ActionType> setMap_type(polyglot.ext.pbnj.primitives.PBJInternSet<TimedAction> objs,
                                                                                    java.lang.String ... fieldNs) {
        polyglot.ext.pbnj.primitives.PBJInternSet<ActionType> res =
          new polyglot.ext.pbnj.primitives.PBJInternSet<ActionType>();
        java.util.Iterator<TimedAction> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().type);
        }
        return res;
    }
    
    public static void fallback_initClassDefs() {
        
    }
    
    static {
               polyglot.ext.pbnj.tologic.LogMap.newClassForLog(TimedAction.class,
                                                               true);
               polyglot.ext.pbnj.tologic.LogMap.newInstVarRel("time",
                                                              TimedAction.class,
                                                              "at.ac.testing.pbnj.test6.TimedAction",
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
               polyglot.ext.pbnj.tologic.LogMap.newInstVarRel("startSize",
                                                              TimedAction.class,
                                                              "at.ac.testing.pbnj.test6.TimedAction",
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
               polyglot.ext.pbnj.tologic.LogMap.newInstVarRel("targetSize",
                                                              TimedAction.class,
                                                              "at.ac.testing.pbnj.test6.TimedAction",
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
               polyglot.ext.pbnj.tologic.LogMap.newInstVarRel("type",
                                                              TimedAction.class,
                                                              "at.ac.testing.pbnj.test6.TimedAction",
                                                              ActionType.class,
                                                              "at.ac.testing.pbnj.test6.ActionType",
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
    
    public static polyglot.ext.pbnj.tologic.LogExpr equalsTo_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                 polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                 String fallback_targetTypeArgsStr,
                                                                 String[] fallback_targetTypeArgs,
                                                                 boolean fallback_target_isOld,
                                                                 polyglot.ext.pbnj.tologic.LogExpr t,
                                                                 boolean t_isOld) {
        return TimedAction.time_get_log(fallback_problem,
                                        fallback_target,
                                        fallback_targetTypeArgsStr,
                                        fallback_targetTypeArgs,
                                        fallback_target_isOld).eq(TimedAction.time_get_log(fallback_problem,
                                                                                           t,
                                                                                           fallback_targetTypeArgsStr,
                                                                                           fallback_targetTypeArgs,
                                                                                           t_isOld)).and(TimedAction.startSize_get_log(fallback_problem,
                                                                                                                                       fallback_target,
                                                                                                                                       fallback_targetTypeArgsStr,
                                                                                                                                       fallback_targetTypeArgs,
                                                                                                                                       fallback_target_isOld).eq(TimedAction.startSize_get_log(fallback_problem,
                                                                                                                                                                                               t,
                                                                                                                                                                                               fallback_targetTypeArgsStr,
                                                                                                                                                                                               fallback_targetTypeArgs,
                                                                                                                                                                                               t_isOld))).and(TimedAction.targetSize_get_log(fallback_problem,
                                                                                                                                                                                                                                             fallback_target,
                                                                                                                                                                                                                                             fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                             fallback_targetTypeArgs,
                                                                                                                                                                                                                                             fallback_target_isOld).eq(TimedAction.targetSize_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                      t,
                                                                                                                                                                                                                                                                                                      fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                      fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                      t_isOld))).and(TimedAction.type_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                              fallback_target,
                                                                                                                                                                                                                                                                                                                                              fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                              fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                              fallback_target_isOld).eq(TimedAction.type_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                 t,
                                                                                                                                                                                                                                                                                                                                                                                                 fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                 fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                 t_isOld)));
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr validType_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                  polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                  String fallback_targetTypeArgsStr,
                                                                  String[] fallback_targetTypeArgs,
                                                                  boolean fallback_target_isOld) {
        return TimedAction.startSize_get_log(fallback_problem,
                                             fallback_target,
                                             fallback_targetTypeArgsStr,
                                             fallback_targetTypeArgs,
                                             fallback_target_isOld).gt(new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                                                                             kodkod.ast.IntConstant.constant(1)).negate()).and(TimedAction.targetSize_get_log(fallback_problem,
                                                                                                                                                                                              fallback_target,
                                                                                                                                                                                              fallback_targetTypeArgsStr,
                                                                                                                                                                                              fallback_targetTypeArgs,
                                                                                                                                                                                              fallback_target_isOld).gt(new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                                                                                                                                                                                                                              kodkod.ast.IntConstant.constant(1)).negate())).implies(TimedAction.startSize_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                   fallback_target,
                                                                                                                                                                                                                                                                                                                                                   fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                   fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                   fallback_target_isOld).lt(TimedAction.targetSize_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                            fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                            fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                            fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                            fallback_target_isOld)).and(TimedAction.type_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                 fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                 fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                 fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                 fallback_target_isOld).eq(ActionType.SCALE_UP_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       fallback_problem.class_log(ActionType.class),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       "",
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       null,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       fallback_target_isOld))).or(TimedAction.startSize_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 fallback_target_isOld).gt(TimedAction.targetSize_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          fallback_target_isOld)).and(TimedAction.type_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               fallback_target_isOld).eq(ActionType.SCALE_DOWN_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       fallback_problem.class_log(ActionType.class),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       "",
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       null,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       fallback_target_isOld)))).or(TimedAction.startSize_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  fallback_target_isOld).eq(TimedAction.targetSize_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           fallback_target_isOld)).and(TimedAction.type_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                fallback_target_isOld).eq(ActionType.STAY_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  fallback_problem.class_log(ActionType.class),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  "",
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  null,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  fallback_target_isOld)))));
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr valid_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                              polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                              String fallback_targetTypeArgsStr,
                                                              String[] fallback_targetTypeArgs,
                                                              boolean fallback_target_isOld) {
        return TimedAction.time_get_log(fallback_problem,
                                        fallback_target,
                                        fallback_targetTypeArgsStr,
                                        fallback_targetTypeArgs,
                                        fallback_target_isOld).gte(new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                                                                         kodkod.ast.IntConstant.constant(0))).and(TimedAction.startSize_get_log(fallback_problem,
                                                                                                                                                                                fallback_target,
                                                                                                                                                                                fallback_targetTypeArgsStr,
                                                                                                                                                                                fallback_targetTypeArgs,
                                                                                                                                                                                fallback_target_isOld).gte(new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                                                                                                                                                                                                                 kodkod.ast.IntConstant.constant(0)))).and(TimedAction.targetSize_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                          fallback_target,
                                                                                                                                                                                                                                                                                                                          fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                          fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                          fallback_target_isOld).gte(new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                           kodkod.ast.IntConstant.constant(0)))).and(TimedAction.validType_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                               fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                                               fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                                               fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                                               fallback_target_isOld));
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr fallback_checkInvariants_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                                 polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                                 String fallback_targetTypeArgsStr,
                                                                                 String[] fallback_targetTypeArgs,
                                                                                 boolean fallback_target_isOld) {
        return new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                     kodkod.ast.Formula.TRUE);
    }
}
