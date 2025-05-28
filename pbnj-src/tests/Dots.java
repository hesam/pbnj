import polyglot.ext.pbnj.primitives.*;
import polyglot.ext.pbnj.tologic.LogMap;
import pbnj.util.ArrayList;
import java.util.HashSet;
import java.awt.*;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class Dot implements PBJInternObject {
    public Integer x;
    
    public Integer y;
    
    public Integer xOrig;
    
    public Integer yOrig;
    
    public Dot(Integer x,
               Integer y) {
        super();
        this.x =
          (this.xOrig =
             x);
        this.y =
          (this.yOrig =
             y);
        this.addInstance();
    }
    
    public void x(Integer x) {
        this.x =
          x;
    }
    
    public void y(Integer y) {
        this.y =
          y;
    }
    
    public String toString() {
        return "(" +
               x +
               ", " +
               y +
        ")";
    }
    
    public Dot old;
    
    public boolean fallback_pbnj;
    
    Object fallback_field_result;
    
    public void fallback_field_result(Object r) {
        this.fallback_field_result =
          r;
    }
    
    public Dot(polyglot.ext.pbnj.tologic.LogExpr dontcare) {
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
        LogMap.addInstance(Dot.class,
                           this);
    }
    
    public void addInstanceForProblem(Dot toAdd,
                                      polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                      String fallback_targetTypeArgsStr) {
        fallback_problem.addToClassInstances(toAdd,
                                             Dot.class,
                                             "Dot",
                                             fallback_targetTypeArgsStr);
    }
    
    long startMethodTime;
    
    boolean isOld;
    
    Object fallback_consistencyLock;
    
    int fallback_updateTime;
    
    public Dot old() {
        return this.old;
    }
    
    String[] fallback_typeArgs;
    
    public Dot fallback_setTypeArgs(String[] args) {
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
        return Dot.classRelationizerStep ==
          fallback_problem.relationizerStep();
    }
    
    public static int classAtomizerStep =
      0;
    
    public static boolean isClassAtomized(polyglot.ext.pbnj.tologic.LogProblem fallback_problem) {
        return Dot.classAtomizerStep ==
          fallback_problem.relationizerStep();
    }
    
    public static int classClonerStep =
      0;
    
    public static boolean isClassCloned() {
        return Dot.classClonerStep ==
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
    
    public void fallback_atomize(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                 String fallback_targetTypeArgsStr,
                                 String[] fallback_targetTypeArgs) {
        if (!isAtomized(fallback_problem)) {
            this.atomizerStep =
              fallback_problem.relationizerStep();
            Dot.fallback_classAtomize(fallback_problem,
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
            Dot.fallback_classRelationizeOld(fallback_problem,
                                             fallback_targetTypeArgsStr,
                                             fallback_targetTypeArgs);
            Dot.x_old_get_log(fallback_problem,
                              fallback_targetTypeArgsStr,
                              fallback_targetTypeArgs).put_log(fallback_problem,
                                                               this,
                                                               this.x);
            Dot.y_old_get_log(fallback_problem,
                              fallback_targetTypeArgsStr,
                              fallback_targetTypeArgs).put_log(fallback_problem,
                                                               this,
                                                               this.y);
            Dot.xOrig_old_get_log(fallback_problem,
                                  fallback_targetTypeArgsStr,
                                  fallback_targetTypeArgs).put_log(fallback_problem,
                                                                   this,
                                                                   this.xOrig);
            Dot.yOrig_old_get_log(fallback_problem,
                                  fallback_targetTypeArgsStr,
                                  fallback_targetTypeArgs).put_log(fallback_problem,
                                                                   this,
                                                                   this.yOrig);
        }
    }
    
    public static void fallback_classAtomize(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                             String fallback_targetTypeArgsStr,
                                             String[] fallback_targetTypeArgs) {
        if (!isClassAtomized(fallback_problem)) {
            Dot.classAtomizerStep =
              fallback_problem.relationizerStep();
        }
    }
    
    public static void fallback_classRelationizeOld(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                    String fallback_targetTypeArgsStr,
                                                    String[] fallback_targetTypeArgs) {
        if (!isClassRelationized(fallback_problem)) {
            Dot.classRelationizerStep =
              fallback_problem.relationizerStep();
        }
    }
    
    public static void fallback_classClone() {
        if (isClassCloned())
            return;
    }
    
    public Dot fallback_clone() {
        if (isCloned())
            return old;
        Dot res =
          null;
        Dot.fallback_classClone();
        try {
            res =
              (Dot)
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
            res.x =
              this.x;
            res.y =
              this.y;
            res.xOrig =
              this.xOrig;
            res.yOrig =
              this.yOrig;
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
        return LogMap.fieldGet_log(fallback_problem,
                                   fallback_target,
                                   "Dot",
                                   fallback_targetTypeArgsStr,
                                   "x",
                                   isOld);
    }
    
    public static polyglot.ext.pbnj.tologic.LogRelation x_old_get_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                      String fallback_targetTypeArgsStr,
                                                                      String[] fallback_targetTypeArgs) {
        return LogMap.oldFieldGet_log(fallback_problem,
                                      "Dot",
                                      fallback_targetTypeArgsStr,
                                      "x");
    }
    
    public Integer fallback_updateField_x(Integer newVal) {
        return this.x =
          newVal;
    }
    
    public PBJInternSet<Integer> fieldsClosure_Integer(Object fallback_target,
                                                       boolean isReflexive,
                                                       java.lang.String ... fieldNs) {
        Class c =
          Integer.class;
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
    
    public static polyglot.ext.pbnj.tologic.LogExpr y_get_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                              polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                              String fallback_targetTypeArgsStr,
                                                              String[] fallback_targetTypeArgs,
                                                              boolean isOld) {
        return LogMap.fieldGet_log(fallback_problem,
                                   fallback_target,
                                   "Dot",
                                   fallback_targetTypeArgsStr,
                                   "y",
                                   isOld);
    }
    
    public static polyglot.ext.pbnj.tologic.LogRelation y_old_get_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                      String fallback_targetTypeArgsStr,
                                                                      String[] fallback_targetTypeArgs) {
        return LogMap.oldFieldGet_log(fallback_problem,
                                      "Dot",
                                      fallback_targetTypeArgsStr,
                                      "y");
    }
    
    public Integer fallback_updateField_y(Integer newVal) {
        return this.y =
          newVal;
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr xOrig_get_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                  polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                  String fallback_targetTypeArgsStr,
                                                                  String[] fallback_targetTypeArgs,
                                                                  boolean isOld) {
        return LogMap.fieldGet_log(fallback_problem,
                                   fallback_target,
                                   "Dot",
                                   fallback_targetTypeArgsStr,
                                   "xOrig",
                                   isOld);
    }
    
    public static polyglot.ext.pbnj.tologic.LogRelation xOrig_old_get_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                          String fallback_targetTypeArgsStr,
                                                                          String[] fallback_targetTypeArgs) {
        return LogMap.oldFieldGet_log(fallback_problem,
                                      "Dot",
                                      fallback_targetTypeArgsStr,
                                      "xOrig");
    }
    
    public Integer fallback_updateField_xOrig(Integer newVal) {
        return this.xOrig =
          newVal;
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr yOrig_get_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                  polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                  String fallback_targetTypeArgsStr,
                                                                  String[] fallback_targetTypeArgs,
                                                                  boolean isOld) {
        return LogMap.fieldGet_log(fallback_problem,
                                   fallback_target,
                                   "Dot",
                                   fallback_targetTypeArgsStr,
                                   "yOrig",
                                   isOld);
    }
    
    public static polyglot.ext.pbnj.tologic.LogRelation yOrig_old_get_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                          String fallback_targetTypeArgsStr,
                                                                          String[] fallback_targetTypeArgs) {
        return LogMap.oldFieldGet_log(fallback_problem,
                                      "Dot",
                                      fallback_targetTypeArgsStr,
                                      "yOrig");
    }
    
    public Integer fallback_updateField_yOrig(Integer newVal) {
        return this.yOrig =
          newVal;
    }
    
    public static PBJInternSet<Integer> setMap_x(PBJInternSet<Dot> objs,
                                                 java.lang.String ... fieldNs) {
        PBJInternSet<Integer> res =
          new PBJInternSet<Integer>();
        java.util.Iterator<Dot> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().x);
        }
        return res;
    }
    
    public static PBJInternSet<Integer> setMap_y(PBJInternSet<Dot> objs,
                                                 java.lang.String ... fieldNs) {
        PBJInternSet<Integer> res =
          new PBJInternSet<Integer>();
        java.util.Iterator<Dot> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().y);
        }
        return res;
    }
    
    public static PBJInternSet<Integer> setMap_xOrig(PBJInternSet<Dot> objs,
                                                     java.lang.String ... fieldNs) {
        PBJInternSet<Integer> res =
          new PBJInternSet<Integer>();
        java.util.Iterator<Dot> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().xOrig);
        }
        return res;
    }
    
    public static PBJInternSet<Integer> setMap_yOrig(PBJInternSet<Dot> objs,
                                                     java.lang.String ... fieldNs) {
        PBJInternSet<Integer> res =
          new PBJInternSet<Integer>();
        java.util.Iterator<Dot> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().yOrig);
        }
        return res;
    }
    
    public static void fallback_initClassDefs() {
        
    }
    
    static {
               LogMap.newClassForLog(Dot.class,
                                     true);
               LogMap.newInstVarRel("x",
                                    Dot.class,
                                    "Dot",
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
               LogMap.newInstVarRel("y",
                                    Dot.class,
                                    "Dot",
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
               LogMap.newInstVarRel("xOrig",
                                    Dot.class,
                                    "Dot",
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
               LogMap.newInstVarRel("yOrig",
                                    Dot.class,
                                    "Dot",
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

public class Dots extends Canvas implements MouseListener, MouseMotionListener, PBJInternObject {
    public Dots() {
        super();
        this.dots =
          new ArrayList<Dot>().fallback_setTypeArgs(new String[] { "Dot" });
        this.addInstance();
    }
    
    static int grid =
      10;
    
    static int canvasSize =
      600;
    
    static int dotSize =
      20;
    
    static Color[] colors =
      { Color.black, Color.blue, Color.darkGray, Color.gray, Color.red, Color.magenta, Color.orange, Color.pink, Color.yellow };
    
    Graphics g;
    
    static int minDistance =
      50 /
      grid;
    
    static int maxWiggleRoom =
      40 /
      grid;
    
    ArrayList<Dot> dots;
    
    public int abs(int i) {
        return i <
                 0 ? -i : i;
    }
    
    public boolean distributed() {
        return distributed_univQuantify_1();
    }
    
    public boolean unperturbed() {
        return unperturbed_univQuantify_2();
    }
    
    public boolean validPos() {
        return validPos_univQuantify_3();
    }
    
    public PBJInternSet<Dot> surrounds(Dot d) {
        return surrounds_setComprehension_4(d);
    }
    
    public void mousePressed(MouseEvent e) {
        ;
    }
    
    public void mouseDragged(MouseEvent e) {
        ;
    }
    
    public void mouseClicked(MouseEvent e) {
        ;
    }
    
    public void mouseEntered(MouseEvent e) {
        ;
    }
    
    public void mouseExited(MouseEvent e) {
        ;
    }
    
    public void mouseMoved(MouseEvent e) {
        ;
    }
    
    public void mouseReleased(MouseEvent e) {
        int x =
          (int)
            Math.floor(e.getX() /
                         grid);
        int y =
          (int)
            Math.floor(e.getY() /
                         grid);
        Dot d =
          new Dot(x,
                  y);
        dots.add(d);
        moveDotsIfNeeded(d);
        draw();
    }
    
    public void moveDotsIfNeeded_Dot_orig(Dot d) {
        
    }
    
    public void draw() {
        int i =
          0;
        int m =
          maxWiggleRoom *
            2 *
          grid;
        paint(g);
        for (Dot d : this.dots) {
            g.setColor(colors[i++]);
            g.fillOval(d.x *
                         grid,
                       d.y *
                         grid,
                       dotSize,
                       dotSize);
            g.drawRect((d.xOrig -
                          maxWiggleRoom) *
                         grid,
                       (d.yOrig -
                          maxWiggleRoom) *
                         grid,
                       m,
                       m);
            if (i ==
                  colors.length)
                i =
                  0;
        }
    }
    
    public void init() {
        this.g =
          getGraphics();
        paint(g);
    }
    
    public HashSet<Object> surroundsTransitiveClosure(Dot d) {
        int x =
          d.x;
        int y =
          d.y;
        HashSet<Object> res =
          new HashSet<Object>();
        HashSet<Object> unExpanded =
          new HashSet<Object>();
        unExpanded.add(d);
        Object n;
        while (unExpanded.size() >
                 0) {
            n =
              unExpanded.iterator().next();
            res.add(n);
            unExpanded.addAll(surrounds((Dot)
                                          n));
            for (Object d1 : res)
                unExpanded.remove(d1);
        }
        return res;
    }
    
    public static void main(String[] args) {
        boolean useAltSolver =
          args.length >
          0;
        if (useAltSolver)
            LogMap.SolverOpt_SolverNum(Integer.parseInt(args[0]));
        LogMap.SolverOpt_IntBitWidth =
          7;
        Frame myFrame =
          new Frame("Distributed Dots");
        Dots myCanvas =
          new Dots();
        myCanvas.addMouseListener(myCanvas);
        myCanvas.addMouseMotionListener(myCanvas);
        myFrame.add(myCanvas);
        myFrame.setSize(canvasSize,
                        canvasSize);
        myFrame.setVisible(true);
        myCanvas.init();
        myFrame.addWindowListener(new WindowAdapter() {
                                      public void windowClosing(WindowEvent we) {
                                          System.exit(0);
                                      }
                                  });
    }
    
    public Dots old;
    
    public boolean fallback_pbnj;
    
    Object fallback_field_result;
    
    public void fallback_field_result(Object r) {
        this.fallback_field_result =
          r;
    }
    
    public Dots(polyglot.ext.pbnj.tologic.LogExpr dontcare) {
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
        LogMap.addInstance(Dots.class,
                           this);
    }
    
    public void addInstanceForProblem(Dots toAdd,
                                      polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                      String fallback_targetTypeArgsStr) {
        fallback_problem.addToClassInstances(toAdd,
                                             Dots.class,
                                             "Dots",
                                             fallback_targetTypeArgsStr);
    }
    
    long startMethodTime;
    
    boolean isOld;
    
    Object fallback_consistencyLock;
    
    int fallback_updateTime;
    
    public Dots old() {
        return this.old;
    }
    
    String[] fallback_typeArgs;
    
    public Dots fallback_setTypeArgs(String[] args) {
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
        return Dots.classRelationizerStep ==
          fallback_problem.relationizerStep();
    }
    
    public static int classAtomizerStep =
      0;
    
    public static boolean isClassAtomized(polyglot.ext.pbnj.tologic.LogProblem fallback_problem) {
        return Dots.classAtomizerStep ==
          fallback_problem.relationizerStep();
    }
    
    public static int classClonerStep =
      0;
    
    public static boolean isClassCloned() {
        return Dots.classClonerStep ==
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
    
    public boolean moveDotsIfNeeded_Dot_checkContract(Dot d) {
        return this.fallback_checkInvariants() &&
                 (this.moveDotsIfNeeded_Dot_checkFieldsInvariants() &&
                    d.fallback_checkInvariants()) &&
          (validPos() &&
             distributed() &&
             unperturbed());
    }
    
    public void moveDotsIfNeeded_Dot_assertContract(Dot d) {
        assert moveDotsIfNeeded_Dot_checkContract(d);
    }
    
    public void moveDotsIfNeeded_Dot_commitModel(Dot d,
                                                 polyglot.ext.pbnj.tologic.LogProblem fallback_problem) {
        fallback_problem.commitModel(this);
    }
    
    polyglot.ext.pbnj.tologic.LogProblem moveDotsIfNeeded_Dot_planb(Dot d,
                                                                    java.util.Collection modifiableObjects) {
        boolean d_isOld =
          false;
        boolean modifiableObjects_isOld =
          false;
        System.out.println("\n" +
                             (this +
                                (" (" +
                                   (Thread.currentThread() +
                                      (": moveDotsIfNeeded" +
                                         ") initiated plan b...")))));
        polyglot.ext.pbnj.tologic.LogProblem fallback_problem =
          LogMap.initRelationize();
        String fallback_targetTypeArgsStr =
          "";
        String[] fallback_targetTypeArgs =
          null;
        old.fallback_atomize(fallback_problem,
                             "",
                             null);
        if (d !=
              null)
            d.old().fallback_atomize(fallback_problem,
                                     "",
                                     null);
        fallback_problem.ObjToAtomMap();
        old.fallback_relationizeOld(fallback_problem,
                                    "",
                                    null);
        if (d !=
              null)
            d.old().fallback_relationizeOld(fallback_problem,
                                            "",
                                            null);
        fallback_problem.initRelations();
        fallback_problem.newModifiableFields();
        fallback_problem.setModifiableField("Dot.x");
        fallback_problem.setModifiableField("Dot.y");
        polyglot.ext.pbnj.tologic.LogExpr fallback_target =
          fallback_problem.objToSingletonRelation_log(this);
        boolean fallback_target_isOld =
          false;
        polyglot.ext.pbnj.tologic.LogExpr fallback_formula =
          Dots.moveDotsIfNeeded_Dot_checkContract_log(fallback_problem,
                                                      fallback_target,
                                                      fallback_targetTypeArgsStr,
                                                      fallback_targetTypeArgs,
                                                      fallback_target_isOld,
                                                      fallback_problem.objToSingletonRelation_log(d),
                                                      d_isOld);
        boolean isSatisfiable =
          fallback_problem.solve("moveDotsIfNeeded_Dot",
                                 this,
                                 fallback_formula.formula(),
                                 modifiableObjects,
                                 false,
                                 false,
                                 this.startMethodTime,
                                 false);
        assert isSatisfiable: "Formula UNSAT! Recovery failed...";
        return fallback_problem;
    }
    
    public void moveDotsIfNeeded(Dot d) {
        moveDotsIfNeeded_Dot_ensured(d);
    }
    
    public void moveDotsIfNeeded_Dot_ensured(Dot d) {
        initEnsuredMethod();
        if (d !=
              null)
            d.fallback_clone();
        try {
            moveDotsIfNeeded_Dot_orig(d);
            moveDotsIfNeeded_Dot_assertContract(d);
        }
        catch (Throwable rte) {
            {
                rte.printStackTrace();
                polyglot.ext.pbnj.tologic.LogProblem fallback_problem =
                  moveDotsIfNeeded_Dot_planb(d,
                                             this.old.surroundsTransitiveClosure(d));
                moveDotsIfNeeded_Dot_commitModel(d,
                                                 fallback_problem);
            }
        }
    }
    
    public boolean moveDotsIfNeeded_Dot_checkFieldsInvariants() {
        return true &&
          (this.dots ==
             null ||
             this.dots.fallback_checkInvariants());
    }
    
    public void fallback_atomize(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                 String fallback_targetTypeArgsStr,
                                 String[] fallback_targetTypeArgs) {
        if (!isAtomized(fallback_problem)) {
            this.atomizerStep =
              fallback_problem.relationizerStep();
            Dots.fallback_classAtomize(fallback_problem,
                                       fallback_targetTypeArgsStr,
                                       fallback_targetTypeArgs);
            this.addInstanceForProblem(this.old,
                                       fallback_problem,
                                       fallback_targetTypeArgsStr);
            if (this.dots !=
                  null)
                this.dots.fallback_atomize(fallback_problem,
                                           "<Dot>",
                                           new String[] { "Dot" });
        }
    }
    
    public void fallback_relationizeOld(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                        String fallback_targetTypeArgsStr,
                                        String[] fallback_targetTypeArgs) {
        if (!isRelationized(fallback_problem)) {
            this.relationizerStep =
              fallback_problem.relationizerStep();
            Dots.fallback_classRelationizeOld(fallback_problem,
                                              fallback_targetTypeArgsStr,
                                              fallback_targetTypeArgs);
            if (this.dots !=
                  null)
                this.dots.fallback_relationizeOld(fallback_problem,
                                                  "<Dot>",
                                                  new String[] { "Dot" });
            Dots.dots_old_get_log(fallback_problem,
                                  fallback_targetTypeArgsStr,
                                  fallback_targetTypeArgs).put_log(fallback_problem,
                                                                   this,
                                                                   this.dots);
        }
    }
    
    public static void fallback_classAtomize(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                             String fallback_targetTypeArgsStr,
                                             String[] fallback_targetTypeArgs) {
        if (!isClassAtomized(fallback_problem)) {
            Dots.classAtomizerStep =
              fallback_problem.relationizerStep();
        }
    }
    
    public static void fallback_classRelationizeOld(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                    String fallback_targetTypeArgsStr,
                                                    String[] fallback_targetTypeArgs) {
        if (!isClassRelationized(fallback_problem)) {
            Dots.classRelationizerStep =
              fallback_problem.relationizerStep();
            Dots.minDistance_old_get_log(fallback_problem,
                                         fallback_targetTypeArgsStr,
                                         fallback_targetTypeArgs).put_log(fallback_problem,
                                                                          "Dots",
                                                                          Dots.minDistance);
            Dots.maxWiggleRoom_old_get_log(fallback_problem,
                                           fallback_targetTypeArgsStr,
                                           fallback_targetTypeArgs).put_log(fallback_problem,
                                                                            "Dots",
                                                                            Dots.maxWiggleRoom);
        }
    }
    
    public static void fallback_classClone() {
        if (isClassCloned())
            return;
    }
    
    public Dots fallback_clone() {
        if (isCloned())
            return old;
        Dots res =
          null;
        Dots.fallback_classClone();
        try {
            res =
              (Dots)
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
            if (this.dots !=
                  null)
                res.dots =
                  this.dots.fallback_clone();
        }
        catch (Exception rte) {
            rte.printStackTrace();
            System.exit(1);
        }
        return res;
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr minDistance_get_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                        polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                        String fallback_targetTypeArgsStr,
                                                                        String[] fallback_targetTypeArgs,
                                                                        boolean isOld) {
        return LogMap.fieldGet_log(fallback_problem,
                                   fallback_target,
                                   "Dots",
                                   fallback_targetTypeArgsStr,
                                   "minDistance",
                                   false);
    }
    
    public static polyglot.ext.pbnj.tologic.LogRelation minDistance_old_get_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                                String fallback_targetTypeArgsStr,
                                                                                String[] fallback_targetTypeArgs) {
        return LogMap.oldFieldGet_log(fallback_problem,
                                      "Dots",
                                      fallback_targetTypeArgsStr,
                                      "minDistance");
    }
    
    public int fallback_updateField_minDistance(Integer newVal) {
        return Dots.minDistance =
          newVal;
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr maxWiggleRoom_get_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                          polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                          String fallback_targetTypeArgsStr,
                                                                          String[] fallback_targetTypeArgs,
                                                                          boolean isOld) {
        return LogMap.fieldGet_log(fallback_problem,
                                   fallback_target,
                                   "Dots",
                                   fallback_targetTypeArgsStr,
                                   "maxWiggleRoom",
                                   false);
    }
    
    public static polyglot.ext.pbnj.tologic.LogRelation maxWiggleRoom_old_get_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                                  String fallback_targetTypeArgsStr,
                                                                                  String[] fallback_targetTypeArgs) {
        return LogMap.oldFieldGet_log(fallback_problem,
                                      "Dots",
                                      fallback_targetTypeArgsStr,
                                      "maxWiggleRoom");
    }
    
    public int fallback_updateField_maxWiggleRoom(Integer newVal) {
        return Dots.maxWiggleRoom =
          newVal;
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr dots_get_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                 polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                 String fallback_targetTypeArgsStr,
                                                                 String[] fallback_targetTypeArgs,
                                                                 boolean isOld) {
        return LogMap.fieldGet_log(fallback_problem,
                                   fallback_target,
                                   "Dots",
                                   fallback_targetTypeArgsStr,
                                   "dots",
                                   isOld);
    }
    
    public static polyglot.ext.pbnj.tologic.LogRelation dots_old_get_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                         String fallback_targetTypeArgsStr,
                                                                         String[] fallback_targetTypeArgs) {
        return LogMap.oldFieldGet_log(fallback_problem,
                                      "Dots",
                                      fallback_targetTypeArgsStr,
                                      "dots");
    }
    
    public ArrayList<Dot> fallback_updateField_dots(ArrayList<Dot> newVal) {
        return this.dots =
          newVal;
    }
    
    public boolean distributed_univQuantify_1() {
        for (Dot d1 : this.dots) {
            if (!distributed_univQuantify_0(d1))
                return false;
        }
        return true;
    }
    
    public boolean distributed_univQuantify_0(Dot d1) {
        for (Dot d2 : this.dots) {
            if (!(d1 ==
                    d2 ||
                    abs(d1.x -
                          d2.x) >
                      minDistance ||
                    abs(d1.y -
                          d2.y) >
                      minDistance))
                return false;
        }
        return true;
    }
    
    public boolean unperturbed_univQuantify_2() {
        for (Dot d : this.dots) {
            if (!(abs(d.xOrig -
                        d.x) <
                    maxWiggleRoom &&
                    abs(d.yOrig -
                          d.y) <
                      maxWiggleRoom))
                return false;
        }
        return true;
    }
    
    public boolean validPos_univQuantify_3() {
        for (Dot d : this.dots) {
            if (!(d.x >
                    0 &&
                    d.y >
                      0))
                return false;
        }
        return true;
    }
    
    public PBJInternSet<Dot> surrounds_setComprehension_4(Dot d) {
        PBJInternSet<Dot> res =
          new PBJInternSet<Dot>();
        for (Dot d1 : (java.util.ArrayList<Dot>)
                        LogMap.allInstances("Dot")) {
            if (abs(d1.x -
                      d.x) <=
                  minDistance &&
                  abs(d1.y -
                        d.y) <=
                    minDistance)
                res.add(d1);
        }
        return res;
    }
    
    public static void fallback_initClassDefs() {
        
    }
    
    static {
               LogMap.newClassForLog(Dots.class,
                                     true);
               LogMap.newInstVarRel("minDistance",
                                    Dots.class,
                                    "Dots",
                                    Integer.class,
                                    "int",
                                    null,
                                    null,
                                    false,
                                    true,
                                    0,
                                    true,
                                    false,
                                    false,
                                    false,
                                    false);
               LogMap.newInstVarRel("maxWiggleRoom",
                                    Dots.class,
                                    "Dots",
                                    Integer.class,
                                    "int",
                                    null,
                                    null,
                                    false,
                                    true,
                                    0,
                                    true,
                                    false,
                                    false,
                                    false,
                                    false);
               LogMap.newInstVarRel("dots",
                                    Dots.class,
                                    "Dots",
                                    ArrayList.class,
                                    "pbnj.util.ArrayList<Dot>",
                                    new Class[] { Dot.class },
                                    new String[] { "Dot" },
                                    false,
                                    false,
                                    0,
                                    true,
                                    false,
                                    false,
                                    false,
                                    false);
               LogMap.newParameterizedGenericClass(ArrayList.class,
                                                   "pbnj.util.ArrayList<Dot>",
                                                   new Class[] { Dot.class },
                                                   new String[] { "Dot" });
           }
    
    public static polyglot.ext.pbnj.tologic.LogExpr abs_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                            polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                            String fallback_targetTypeArgsStr,
                                                            String[] fallback_targetTypeArgs,
                                                            boolean fallback_target_isOld,
                                                            polyglot.ext.pbnj.tologic.LogExpr i,
                                                            boolean i_isOld) {
        return i.lt(new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                          kodkod.ast.IntConstant.constant(0))).thenElse(i.negate(),
                                                                                                        i);
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr distributed_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                    polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                    String fallback_targetTypeArgsStr,
                                                                    String[] fallback_targetTypeArgs,
                                                                    boolean fallback_target_isOld) {
        boolean d1_isOld =
          false;
        polyglot.ext.pbnj.tologic.LogExpr d1 =
          new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                kodkod.ast.Variable.unary("d1"));
        boolean d2_isOld =
          false;
        polyglot.ext.pbnj.tologic.LogExpr d2 =
          new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                kodkod.ast.Variable.unary("d2"));
        return polyglot.ext.pbnj.tologic.LogExpr.quantifyOp(ArrayList.toPBJInternSet_log(fallback_problem,
                                                                                         Dots.dots_get_log(fallback_problem,
                                                                                                           fallback_target,
                                                                                                           fallback_targetTypeArgsStr,
                                                                                                           fallback_targetTypeArgs,
                                                                                                           fallback_target_isOld),
                                                                                         "<Dot>",
                                                                                         new String[] { "Dot" },
                                                                                         fallback_target_isOld),
                                                            false,
                                                            "all",
                                                            d1,
                                                            polyglot.ext.pbnj.tologic.LogExpr.quantifyOp(ArrayList.toPBJInternSet_log(fallback_problem,
                                                                                                                                      Dots.dots_get_log(fallback_problem,
                                                                                                                                                        fallback_target,
                                                                                                                                                        fallback_targetTypeArgsStr,
                                                                                                                                                        fallback_targetTypeArgs,
                                                                                                                                                        fallback_target_isOld),
                                                                                                                                      "<Dot>",
                                                                                                                                      new String[] { "Dot" },
                                                                                                                                      fallback_target_isOld),
                                                                                                         false,
                                                                                                         "all",
                                                                                                         d2,
                                                                                                         d1.eq(d2).or(Dots.abs_log(fallback_problem,
                                                                                                                                   fallback_target,
                                                                                                                                   fallback_targetTypeArgsStr,
                                                                                                                                   fallback_targetTypeArgs,
                                                                                                                                   fallback_target_isOld,
                                                                                                                                   Dot.x_get_log(fallback_problem,
                                                                                                                                                 d1,
                                                                                                                                                 "",
                                                                                                                                                 null,
                                                                                                                                                 d1_isOld).minus(Dot.x_get_log(fallback_problem,
                                                                                                                                                                               d2,
                                                                                                                                                                               "",
                                                                                                                                                                               null,
                                                                                                                                                                               d2_isOld)),
                                                                                                                                   fallback_target_isOld).gt(Dots.minDistance_get_log(fallback_problem,
                                                                                                                                                                                      fallback_problem.class_log(Dots.class),
                                                                                                                                                                                      fallback_targetTypeArgsStr,
                                                                                                                                                                                      fallback_targetTypeArgs,
                                                                                                                                                                                      fallback_target_isOld))).or(Dots.abs_log(fallback_problem,
                                                                                                                                                                                                                               fallback_target,
                                                                                                                                                                                                                               fallback_targetTypeArgsStr,
                                                                                                                                                                                                                               fallback_targetTypeArgs,
                                                                                                                                                                                                                               fallback_target_isOld,
                                                                                                                                                                                                                               Dot.y_get_log(fallback_problem,
                                                                                                                                                                                                                                             d1,
                                                                                                                                                                                                                                             "",
                                                                                                                                                                                                                                             null,
                                                                                                                                                                                                                                             d1_isOld).minus(Dot.y_get_log(fallback_problem,
                                                                                                                                                                                                                                                                           d2,
                                                                                                                                                                                                                                                                           "",
                                                                                                                                                                                                                                                                           null,
                                                                                                                                                                                                                                                                           d2_isOld)),
                                                                                                                                                                                                                               fallback_target_isOld).gt(Dots.minDistance_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                  fallback_problem.class_log(Dots.class),
                                                                                                                                                                                                                                                                                  fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                  fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                  fallback_target_isOld)))));
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr unperturbed_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                    polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                    String fallback_targetTypeArgsStr,
                                                                    String[] fallback_targetTypeArgs,
                                                                    boolean fallback_target_isOld) {
        boolean d_isOld =
          false;
        polyglot.ext.pbnj.tologic.LogExpr d =
          new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                kodkod.ast.Variable.unary("d"));
        return polyglot.ext.pbnj.tologic.LogExpr.quantifyOp(ArrayList.toPBJInternSet_log(fallback_problem,
                                                                                         Dots.dots_get_log(fallback_problem,
                                                                                                           fallback_target,
                                                                                                           fallback_targetTypeArgsStr,
                                                                                                           fallback_targetTypeArgs,
                                                                                                           fallback_target_isOld),
                                                                                         "<Dot>",
                                                                                         new String[] { "Dot" },
                                                                                         fallback_target_isOld),
                                                            false,
                                                            "all",
                                                            d,
                                                            Dots.abs_log(fallback_problem,
                                                                         fallback_target,
                                                                         fallback_targetTypeArgsStr,
                                                                         fallback_targetTypeArgs,
                                                                         fallback_target_isOld,
                                                                         Dot.xOrig_get_log(fallback_problem,
                                                                                           d,
                                                                                           "",
                                                                                           null,
                                                                                           d_isOld).minus(Dot.x_get_log(fallback_problem,
                                                                                                                        d,
                                                                                                                        "",
                                                                                                                        null,
                                                                                                                        d_isOld)),
                                                                         fallback_target_isOld).lt(Dots.maxWiggleRoom_get_log(fallback_problem,
                                                                                                                              fallback_problem.class_log(Dots.class),
                                                                                                                              fallback_targetTypeArgsStr,
                                                                                                                              fallback_targetTypeArgs,
                                                                                                                              fallback_target_isOld)).and(Dots.abs_log(fallback_problem,
                                                                                                                                                                       fallback_target,
                                                                                                                                                                       fallback_targetTypeArgsStr,
                                                                                                                                                                       fallback_targetTypeArgs,
                                                                                                                                                                       fallback_target_isOld,
                                                                                                                                                                       Dot.yOrig_get_log(fallback_problem,
                                                                                                                                                                                         d,
                                                                                                                                                                                         "",
                                                                                                                                                                                         null,
                                                                                                                                                                                         d_isOld).minus(Dot.y_get_log(fallback_problem,
                                                                                                                                                                                                                      d,
                                                                                                                                                                                                                      "",
                                                                                                                                                                                                                      null,
                                                                                                                                                                                                                      d_isOld)),
                                                                                                                                                                       fallback_target_isOld).lt(Dots.maxWiggleRoom_get_log(fallback_problem,
                                                                                                                                                                                                                            fallback_problem.class_log(Dots.class),
                                                                                                                                                                                                                            fallback_targetTypeArgsStr,
                                                                                                                                                                                                                            fallback_targetTypeArgs,
                                                                                                                                                                                                                            fallback_target_isOld))));
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr validPos_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                 polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                 String fallback_targetTypeArgsStr,
                                                                 String[] fallback_targetTypeArgs,
                                                                 boolean fallback_target_isOld) {
        boolean d_isOld =
          false;
        polyglot.ext.pbnj.tologic.LogExpr d =
          new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                kodkod.ast.Variable.unary("d"));
        return polyglot.ext.pbnj.tologic.LogExpr.quantifyOp(ArrayList.toPBJInternSet_log(fallback_problem,
                                                                                         Dots.dots_get_log(fallback_problem,
                                                                                                           fallback_target,
                                                                                                           fallback_targetTypeArgsStr,
                                                                                                           fallback_targetTypeArgs,
                                                                                                           fallback_target_isOld),
                                                                                         "<Dot>",
                                                                                         new String[] { "Dot" },
                                                                                         fallback_target_isOld),
                                                            false,
                                                            "all",
                                                            d,
                                                            Dot.x_get_log(fallback_problem,
                                                                          d,
                                                                          "",
                                                                          null,
                                                                          d_isOld).gt(new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                                                                                            kodkod.ast.IntConstant.constant(0))).and(Dot.y_get_log(fallback_problem,
                                                                                                                                                                                   d,
                                                                                                                                                                                   "",
                                                                                                                                                                                   null,
                                                                                                                                                                                   d_isOld).gt(new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                                                                                                                                                                                                     kodkod.ast.IntConstant.constant(0)))));
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr surrounds_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                  polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                  String fallback_targetTypeArgsStr,
                                                                  String[] fallback_targetTypeArgs,
                                                                  boolean fallback_target_isOld,
                                                                  polyglot.ext.pbnj.tologic.LogExpr d,
                                                                  boolean d_isOld) {
        boolean d1_isOld =
          false;
        polyglot.ext.pbnj.tologic.LogExpr d1 =
          new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                kodkod.ast.Variable.unary("d1"));
        return polyglot.ext.pbnj.tologic.LogExpr.setComprehensionOp(fallback_problem.allInstances_log("Dot",
                                                                                                      false),
                                                                    d1,
                                                                    Dots.abs_log(fallback_problem,
                                                                                 fallback_target,
                                                                                 fallback_targetTypeArgsStr,
                                                                                 fallback_targetTypeArgs,
                                                                                 fallback_target_isOld,
                                                                                 Dot.x_get_log(fallback_problem,
                                                                                               d1,
                                                                                               "",
                                                                                               null,
                                                                                               d1_isOld).minus(Dot.x_get_log(fallback_problem,
                                                                                                                             d,
                                                                                                                             "",
                                                                                                                             null,
                                                                                                                             d_isOld)),
                                                                                 fallback_target_isOld).lte(Dots.minDistance_get_log(fallback_problem,
                                                                                                                                     fallback_problem.class_log(Dots.class),
                                                                                                                                     fallback_targetTypeArgsStr,
                                                                                                                                     fallback_targetTypeArgs,
                                                                                                                                     fallback_target_isOld)).and(Dots.abs_log(fallback_problem,
                                                                                                                                                                              fallback_target,
                                                                                                                                                                              fallback_targetTypeArgsStr,
                                                                                                                                                                              fallback_targetTypeArgs,
                                                                                                                                                                              fallback_target_isOld,
                                                                                                                                                                              Dot.y_get_log(fallback_problem,
                                                                                                                                                                                            d1,
                                                                                                                                                                                            "",
                                                                                                                                                                                            null,
                                                                                                                                                                                            d1_isOld).minus(Dot.y_get_log(fallback_problem,
                                                                                                                                                                                                                          d,
                                                                                                                                                                                                                          "",
                                                                                                                                                                                                                          null,
                                                                                                                                                                                                                          d_isOld)),
                                                                                                                                                                              fallback_target_isOld).lte(Dots.minDistance_get_log(fallback_problem,
                                                                                                                                                                                                                                  fallback_problem.class_log(Dots.class),
                                                                                                                                                                                                                                  fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                  fallback_targetTypeArgs,
                                                                                                                                                                                                                                  fallback_target_isOld))));
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr fallback_checkInvariants_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                                 polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                                 String fallback_targetTypeArgsStr,
                                                                                 String[] fallback_targetTypeArgs,
                                                                                 boolean fallback_target_isOld) {
        return new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                     kodkod.ast.Formula.TRUE);
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr moveDotsIfNeeded_Dot_checkContract_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                                           polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                                           String fallback_targetTypeArgsStr,
                                                                                           String[] fallback_targetTypeArgs,
                                                                                           boolean fallback_target_isOld,
                                                                                           polyglot.ext.pbnj.tologic.LogExpr d,
                                                                                           boolean d_isOld) {
        return Dots.fallback_checkInvariants_log(fallback_problem,
                                                 fallback_target,
                                                 fallback_targetTypeArgsStr,
                                                 fallback_targetTypeArgs,
                                                 fallback_target_isOld).and(Dots.moveDotsIfNeeded_Dot_checkFieldsInvariants_log(fallback_problem,
                                                                                                                                fallback_target,
                                                                                                                                fallback_targetTypeArgsStr,
                                                                                                                                fallback_targetTypeArgs,
                                                                                                                                fallback_target_isOld).and(Dot.fallback_checkInvariants_log(fallback_problem,
                                                                                                                                                                                            d,
                                                                                                                                                                                            "",
                                                                                                                                                                                            null,
                                                                                                                                                                                            d_isOld))).and(Dots.validPos_log(fallback_problem,
                                                                                                                                                                                                                             fallback_target,
                                                                                                                                                                                                                             fallback_targetTypeArgsStr,
                                                                                                                                                                                                                             fallback_targetTypeArgs,
                                                                                                                                                                                                                             fallback_target_isOld).and(Dots.distributed_log(fallback_problem,
                                                                                                                                                                                                                                                                             fallback_target,
                                                                                                                                                                                                                                                                             fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                             fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                             fallback_target_isOld)).and(Dots.unperturbed_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                              fallback_target,
                                                                                                                                                                                                                                                                                                                              fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                              fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                              fallback_target_isOld)));
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr moveDotsIfNeeded_Dot_checkFieldsInvariants_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                                                   polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                                                   String fallback_targetTypeArgsStr,
                                                                                                   String[] fallback_targetTypeArgs,
                                                                                                   boolean fallback_target_isOld) {
        return new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                     kodkod.ast.Formula.TRUE).and(Dots.dots_get_log(fallback_problem,
                                                                                                    fallback_target,
                                                                                                    fallback_targetTypeArgsStr,
                                                                                                    fallback_targetTypeArgs,
                                                                                                    fallback_target_isOld).eq(fallback_problem.null_log()).or(ArrayList.fallback_checkInvariants_log(fallback_problem,
                                                                                                                                                                                                     Dots.dots_get_log(fallback_problem,
                                                                                                                                                                                                                       fallback_target,
                                                                                                                                                                                                                       fallback_targetTypeArgsStr,
                                                                                                                                                                                                                       fallback_targetTypeArgs,
                                                                                                                                                                                                                       fallback_target_isOld),
                                                                                                                                                                                                     "<Dot>",
                                                                                                                                                                                                     new String[] { "Dot" },
                                                                                                                                                                                                     fallback_target_isOld)));
    }
}
