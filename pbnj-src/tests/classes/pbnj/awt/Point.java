package pbnj.awt;

import java.awt.geom.Point2D;

public class Point extends Point2D implements java.io.Serializable, polyglot.ext.pbnj.primitives.PBJInternObject {
    public int x;
    
    public int x() {
        return x;
    }
    
    public int y;
    
    public int y() {
        return y;
    }
    
    private static final long serialVersionUID =
      -5276940640259749850L;
    
    public Point() {
        this(0,
             0);
    }
    
    public Point(Point p) {
        this(p.x,
             p.y);
    }
    
    public Point(int x,
                 int y) {
        super();
        this.x =
          x;
        this.y =
          y;
        this.addInstance();
    }
    
    public double getX() {
        return x;
    }
    
    public double getY() {
        return y;
    }
    
    public Point getLocation() {
        return new Point(x,
                         y);
    }
    
    public void setLocation(Point p) {
        setLocation(p.x,
                    p.y);
    }
    
    public void setLocation(int x,
                            int y) {
        move(x,
             y);
    }
    
    public void setLocation(double x,
                            double y) {
        this.x =
          (int)
            Math.floor(x +
                         0.5);
        this.y =
          (int)
            Math.floor(y +
                         0.5);
    }
    
    public void move(int x,
                     int y) {
        this.x =
          x;
        this.y =
          y;
    }
    
    public void translate(int dx,
                          int dy) {
        this.x +=
          dx;
        this.y +=
          dy;
    }
    
    public boolean equals(Object obj) {
        if (obj instanceof Point) {
            Point pt =
              (Point)
                obj;
            return x ==
                     pt.x &&
              y ==
                pt.y;
        }
        return super.equals(obj);
    }
    
    public String toString() {
        return getClass().getName() +
               "[x=" +
               x +
               ",y=" +
               y +
        "]";
    }
    
    public Point old;
    
    public boolean fallback_pbnj;
    
    Object fallback_field_result;
    
    public void fallback_field_result(Object r) {
        this.fallback_field_result =
          r;
    }
    
    public Point(polyglot.ext.pbnj.tologic.LogExpr dontcare) {
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
        polyglot.ext.pbnj.tologic.LogMap.addInstance(Point.class,
                                                     this);
    }
    
    public void addInstanceForProblem(Point toAdd,
                                      polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                      String fallback_targetTypeArgsStr) {
        fallback_problem.addToClassInstances(toAdd,
                                             Point.class,
                                             "pbnj.awt.Point",
                                             fallback_targetTypeArgsStr);
    }
    
    long startMethodTime;
    
    boolean isOld;
    
    Object fallback_consistencyLock;
    
    int fallback_updateTime;
    
    public Point old() {
        return this.old;
    }
    
    String[] fallback_typeArgs;
    
    public Point fallback_setTypeArgs(String[] args) {
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
        return Point.classRelationizerStep ==
          fallback_problem.relationizerStep();
    }
    
    public static int classAtomizerStep =
      0;
    
    public static boolean isClassAtomized(polyglot.ext.pbnj.tologic.LogProblem fallback_problem) {
        return Point.classAtomizerStep ==
          fallback_problem.relationizerStep();
    }
    
    public static int classClonerStep =
      0;
    
    public static boolean isClassCloned() {
        return Point.classClonerStep ==
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
            Point.fallback_classAtomize(fallback_problem,
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
            Point.fallback_classRelationizeOld(fallback_problem,
                                               fallback_targetTypeArgsStr,
                                               fallback_targetTypeArgs);
            Point.x_old_get_log(fallback_problem,
                                fallback_targetTypeArgsStr,
                                fallback_targetTypeArgs).put_log(fallback_problem,
                                                                 this,
                                                                 this.x);
            Point.y_old_get_log(fallback_problem,
                                fallback_targetTypeArgsStr,
                                fallback_targetTypeArgs).put_log(fallback_problem,
                                                                 this,
                                                                 this.y);
        }
    }
    
    public static void fallback_classAtomize(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                             String fallback_targetTypeArgsStr,
                                             String[] fallback_targetTypeArgs) {
        if (!isClassAtomized(fallback_problem)) {
            Point.classAtomizerStep =
              fallback_problem.relationizerStep();
        }
    }
    
    public static void fallback_classRelationizeOld(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                    String fallback_targetTypeArgsStr,
                                                    String[] fallback_targetTypeArgs) {
        if (!isClassRelationized(fallback_problem)) {
            Point.classRelationizerStep =
              fallback_problem.relationizerStep();
        }
    }
    
    public static void fallback_classClone() {
        if (isClassCloned())
            return;
    }
    
    public Point fallback_clone() {
        if (isCloned())
            return old;
        Point res =
          null;
        Point.fallback_classClone();
        try {
            res =
              (Point)
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
            res.x =
              this.x;
            res.y =
              this.y;
        }
        catch (Exception rte) {
            rte.printStackTrace();
            System.exit(1);
        }
        return res;
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr x_get_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                              polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                              String fallback_targetTypeArgsStr,
                                                              String[] fallback_targetTypeArgs,
                                                              boolean isOld) {
        return polyglot.ext.pbnj.tologic.LogMap.fieldGet_log(fallback_problem,
                                                             fallback_target,
                                                             "pbnj.awt.Point",
                                                             fallback_targetTypeArgsStr,
                                                             "x",
                                                             isOld);
    }
    
    public static polyglot.ext.pbnj.tologic.LogRelation x_old_get_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                      String fallback_targetTypeArgsStr,
                                                                      String[] fallback_targetTypeArgs) {
        return polyglot.ext.pbnj.tologic.LogMap.oldFieldGet_log(fallback_problem,
                                                                "pbnj.awt.Point",
                                                                fallback_targetTypeArgsStr,
                                                                "x");
    }
    
    public int fallback_updateField_x(Integer newVal) {
        return this.x =
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
    
    public static polyglot.ext.pbnj.tologic.LogExpr y_get_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                              polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                              String fallback_targetTypeArgsStr,
                                                              String[] fallback_targetTypeArgs,
                                                              boolean isOld) {
        return polyglot.ext.pbnj.tologic.LogMap.fieldGet_log(fallback_problem,
                                                             fallback_target,
                                                             "pbnj.awt.Point",
                                                             fallback_targetTypeArgsStr,
                                                             "y",
                                                             isOld);
    }
    
    public static polyglot.ext.pbnj.tologic.LogRelation y_old_get_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                      String fallback_targetTypeArgsStr,
                                                                      String[] fallback_targetTypeArgs) {
        return polyglot.ext.pbnj.tologic.LogMap.oldFieldGet_log(fallback_problem,
                                                                "pbnj.awt.Point",
                                                                fallback_targetTypeArgsStr,
                                                                "y");
    }
    
    public int fallback_updateField_y(Integer newVal) {
        return this.y =
          newVal;
    }
    
    public static polyglot.ext.pbnj.primitives.PBJInternSet<Integer> setMap_x(polyglot.ext.pbnj.primitives.PBJInternSet<Point> objs,
                                                                              java.lang.String ... fieldNs) {
        polyglot.ext.pbnj.primitives.PBJInternSet<Integer> res =
          new polyglot.ext.pbnj.primitives.PBJInternSet<Integer>();
        java.util.Iterator<Point> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().x);
        }
        return res;
    }
    
    public static polyglot.ext.pbnj.primitives.PBJInternSet<Integer> setMap_y(polyglot.ext.pbnj.primitives.PBJInternSet<Point> objs,
                                                                              java.lang.String ... fieldNs) {
        polyglot.ext.pbnj.primitives.PBJInternSet<Integer> res =
          new polyglot.ext.pbnj.primitives.PBJInternSet<Integer>();
        java.util.Iterator<Point> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().y);
        }
        return res;
    }
    
    public static void fallback_initClassDefs() {
        
    }
    
    static {
               polyglot.ext.pbnj.tologic.LogMap.newClassForLog(Point.class,
                                                               true);
               polyglot.ext.pbnj.tologic.LogMap.newInstVarRel("x",
                                                              Point.class,
                                                              "pbnj.awt.Point",
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
               polyglot.ext.pbnj.tologic.LogMap.newInstVarRel("y",
                                                              Point.class,
                                                              "pbnj.awt.Point",
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
    
    public static polyglot.ext.pbnj.tologic.LogExpr x_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                          polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                          String fallback_targetTypeArgsStr,
                                                          String[] fallback_targetTypeArgs,
                                                          boolean fallback_target_isOld) {
        return Point.x_get_log(fallback_problem,
                               fallback_target,
                               fallback_targetTypeArgsStr,
                               fallback_targetTypeArgs,
                               fallback_target_isOld);
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr y_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                          polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                          String fallback_targetTypeArgsStr,
                                                          String[] fallback_targetTypeArgs,
                                                          boolean fallback_target_isOld) {
        return Point.y_get_log(fallback_problem,
                               fallback_target,
                               fallback_targetTypeArgsStr,
                               fallback_targetTypeArgs,
                               fallback_target_isOld);
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
