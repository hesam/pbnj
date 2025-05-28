package pbnj.awt;

import polyglot.ext.pbnj.primitives.*;

public class GridBagLayoutInfo implements java.io.Serializable, PBJObject {
    Integer width;
    
    Integer height;
    
    Integer startx;
    
    Integer starty;
    
    int[] minWidth;
    
    int[] minHeight;
    
    double[] weightX;
    
    double[] weightY;
    
    public Integer startx() { return this.startx; }
    
    public Integer starty() { return this.starty; }
    
    public void startx(Integer x) { this.startx = x; }
    
    public void starty(Integer y) { this.starty = y; }
    
    GridBagLayoutInfo(int gridCols, int gridRows) {
        super();
        minWidth = (new int[600]);
        minHeight = (new int[400]);
        weightX = (new double[600]);
        weightY = (new double[400]);
        polyglot.ext.pbnj.tologic.LogMap.addInstance(GridBagLayoutInfo.class, this); }
    
    GridBagLayoutInfo old;
    
    Object result;
    
    public void result(Object r) { this.result = r; }
    
    public GridBagLayoutInfo(polyglot.ext.pbnj.tologic.LogObjSet dontcare) { super(); }
    
    Object[] resultArray;
    
    public void resultArray(Object[] r) { this.resultArray = r; }
    
    public boolean verifyInvariants() { return true; }
    
    long startMethodTime;
    
    public GridBagLayoutInfo old() { return this.old; }
    
    boolean isOld;
    
    public boolean isOld() { return this.isOld; }
    
    int atomizerStep = 0;
    
    boolean isAtomized() { return this.atomizerStep == polyglot.ext.pbnj.tologic.LogMap.relationizerStep(); }
    
    int relationizerStep = 0;
    
    boolean isRelationized() { return this.relationizerStep == polyglot.ext.pbnj.tologic.LogMap.relationizerStep(); }
    
    int clonerStep = 0;
    
    public boolean isCloned() { return this.clonerStep == polyglot.ext.pbnj.tologic.LogMap.clonerStep(); }
    
    void initEnsuredMethod() { this.startMethodTime = System.currentTimeMillis();
                               polyglot.ext.pbnj.tologic.LogMap.incrClonerStep();
                               fallback_clone(); }
    
    public void fallback_updateField(java.lang.reflect.Method updaterMtd, Object[] args) {
        try { updaterMtd.invoke(this, args); }
        catch (Exception rte) { rte.printStackTrace(); } }
    
    public Object fallback_newInstance(java.lang.reflect.Constructor cons, Object[] args) {
        try { return cons.newInstance(args); }
        catch (Exception rte) { rte.printStackTrace();
                                return null; } }
    
    public void fallback_atomize() {
        if (!isAtomized()) { this.atomizerStep = polyglot.ext.pbnj.tologic.LogMap.relationizerStep();
                             polyglot.ext.pbnj.tologic.LogMap.addToClassInstances(this.old, GridBagLayoutInfo.class); }
    }
    
    public void fallback_relationizeOld() {
        if (!isRelationized()) {
            this.relationizerStep = polyglot.ext.pbnj.tologic.LogMap.relationizerStep();
            polyglot.ext.pbnj.tologic.LogMap.instVarRel_log0(this, "width_old").put_log(this, this.width);
            polyglot.ext.pbnj.tologic.LogMap.instVarRel_log0(this, "height_old").put_log(this, this.height);
            polyglot.ext.pbnj.tologic.LogMap.instVarRel_log0(this, "startx_old").put_log(this, this.startx);
            polyglot.ext.pbnj.tologic.LogMap.instVarRel_log0(this, "starty_old").put_log(this, this.starty); }
    }
    
    public void fallback_relationize() {
        if (!old.isRelationized()) {
            old.relationizerStep = polyglot.ext.pbnj.tologic.LogMap.relationizerStep();
            polyglot.ext.pbnj.tologic.LogMap.instVarRel_log0(this, "width").put_log(old, old.width);
            polyglot.ext.pbnj.tologic.LogMap.instVarRel_log0(this, "height").put_log(old, old.height);
            polyglot.ext.pbnj.tologic.LogMap.instVarRel_log0(this, "startx").put_log(old, old.startx);
            polyglot.ext.pbnj.tologic.LogMap.instVarRel_log0(this, "starty").put_log(old, old.starty); }
    }
    
    public GridBagLayoutInfo fallback_clone() { if (isCloned()) return this.old;
                                                GridBagLayoutInfo res = null;
                                                try { this.clonerStep = polyglot.ext.pbnj.tologic.LogMap.clonerStep();
                                                      res = (GridBagLayoutInfo) super.clone();
                                                      res.isOld = true;
                                                      this.old = res;
                                                      res.old = this;
                                                      res.width = this.width;
                                                      res.height = this.height;
                                                      res.startx = this.startx;
                                                      res.starty = this.starty; }
                                                catch (Exception rte) { rte.printStackTrace();
                                                                        System.exit(1); }
                                                return res; }
    
    public void fallback_updateField_width(Integer newVal) { this.width = newVal; }
    
    public PBJSet<Integer> fieldsClosure_Integer(Object target, boolean isReflexive, java.lang.String ... fieldNs) {
        Class c = Integer.class;
        PBJSet<Integer> res = new PBJSet<Integer>();
        java.util.ArrayList<Integer> workList = new java.util.ArrayList<Integer>();
        try {
            java.util.ArrayList<java.lang.reflect.Field> fields = new java.util.ArrayList<java.lang.reflect.Field>();
            for (String fN : fieldNs) { fields.add(c.getField(fN)); }
            for (java.lang.reflect.Field f : fields) {
                Integer childN = (Integer) f.get(target);
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
            if (isReflexive) res.add((Integer) target);
        }
        catch (Exception rte) { rte.printStackTrace(); }
        return res;
    }
    
    PBJSet<Integer> multiFields_Integer(java.lang.String ... fieldNs) {
        Class c = Integer.class;
        PBJSet<Integer> res = new PBJSet<Integer>();
        try { for (String fN : fieldNs) { java.lang.reflect.Field f = c.getField(fN);
                                          Integer n = (Integer) f.get(this);
                                          if (n != null) res.add(n); } }
        catch (Exception rte) { rte.printStackTrace(); }
        return res; }
    
    public void fallback_updateField_height(Integer newVal) { this.height = newVal; }
    
    public void fallback_updateField_startx(Integer newVal) { this.startx = newVal; }
    
    public void fallback_updateField_starty(Integer newVal) { this.starty = newVal; }
    
    public static kodkod.ast.IntExpression width_get_log(kodkod.ast.Expression target, boolean isOld) {
        return polyglot.ext.pbnj.tologic.LogMap.fieldGet_log(target, isOld ? "width_old" : "width",
                                                             GridBagLayoutInfo.class).sum();
    }
    
    public static PBJSet<Integer> setMap_width(PBJSet<GridBagLayoutInfo> objs, java.lang.String ... fieldNs) {
        PBJSet<Integer> res = new PBJSet<Integer>();
        java.util.Iterator<GridBagLayoutInfo> i = objs.iterator();
        while (i.hasNext()) { res.add(i.next().width); }
        return res; }
    
    public static kodkod.ast.IntExpression height_get_log(kodkod.ast.Expression target, boolean isOld) {
        return polyglot.ext.pbnj.tologic.LogMap.fieldGet_log(target, isOld ? "height_old" : "height",
                                                             GridBagLayoutInfo.class).sum();
    }
    
    public static PBJSet<Integer> setMap_height(PBJSet<GridBagLayoutInfo> objs, java.lang.String ... fieldNs) {
        PBJSet<Integer> res = new PBJSet<Integer>();
        java.util.Iterator<GridBagLayoutInfo> i = objs.iterator();
        while (i.hasNext()) { res.add(i.next().height); }
        return res; }
    
    public static kodkod.ast.IntExpression startx_get_log(kodkod.ast.Expression target, boolean isOld) {
        return polyglot.ext.pbnj.tologic.LogMap.fieldGet_log(target, isOld ? "startx_old" : "startx",
                                                             GridBagLayoutInfo.class).sum();
    }
    
    public static PBJSet<Integer> setMap_startx(PBJSet<GridBagLayoutInfo> objs, java.lang.String ... fieldNs) {
        PBJSet<Integer> res = new PBJSet<Integer>();
        java.util.Iterator<GridBagLayoutInfo> i = objs.iterator();
        while (i.hasNext()) { res.add(i.next().startx); }
        return res; }
    
    public static kodkod.ast.IntExpression starty_get_log(kodkod.ast.Expression target, boolean isOld) {
        return polyglot.ext.pbnj.tologic.LogMap.fieldGet_log(target, isOld ? "starty_old" : "starty",
                                                             GridBagLayoutInfo.class).sum();
    }
    
    public static PBJSet<Integer> setMap_starty(PBJSet<GridBagLayoutInfo> objs, java.lang.String ... fieldNs) {
        PBJSet<Integer> res = new PBJSet<Integer>();
        java.util.Iterator<GridBagLayoutInfo> i = objs.iterator();
        while (i.hasNext()) { res.add(i.next().starty); }
        return res; }
    
    static {
               polyglot.ext.pbnj.tologic.LogMap.newClassForLog(GridBagLayoutInfo.class);
               polyglot.ext.pbnj.tologic.LogMap.newInstVarRel(GridBagLayoutInfo.class, "width",
                                                              GridBagLayoutInfo.class, Integer.class, Integer.class,
                                                              false, false, true, false, false);
               polyglot.ext.pbnj.tologic.LogMap.newInstVarRel(GridBagLayoutInfo.class, "width",
                                                              GridBagLayoutInfo.class, Integer.class, Integer.class,
                                                              false, false, false, false, false);
               polyglot.ext.pbnj.tologic.LogMap.newInstVarRel(GridBagLayoutInfo.class, "height",
                                                              GridBagLayoutInfo.class, Integer.class, Integer.class,
                                                              false, false, true, false, false);
               polyglot.ext.pbnj.tologic.LogMap.newInstVarRel(GridBagLayoutInfo.class, "height",
                                                              GridBagLayoutInfo.class, Integer.class, Integer.class,
                                                              false, false, false, false, false);
               polyglot.ext.pbnj.tologic.LogMap.newInstVarRel(GridBagLayoutInfo.class, "startx",
                                                              GridBagLayoutInfo.class, Integer.class, Integer.class,
                                                              false, false, true, false, false);
               polyglot.ext.pbnj.tologic.LogMap.newInstVarRel(GridBagLayoutInfo.class, "startx",
                                                              GridBagLayoutInfo.class, Integer.class, Integer.class,
                                                              false, false, false, false, false);
               polyglot.ext.pbnj.tologic.LogMap.newInstVarRel(GridBagLayoutInfo.class, "starty",
                                                              GridBagLayoutInfo.class, Integer.class, Integer.class,
                                                              false, false, true, false, false);
               polyglot.ext.pbnj.tologic.LogMap.newInstVarRel(GridBagLayoutInfo.class, "starty",
                                                              GridBagLayoutInfo.class, Integer.class, Integer.class,
                                                              false, false, false, false, false);
           }
    
    public static kodkod.ast.Formula verifyInvariants_log(kodkod.ast.Expression target, boolean target_isOld) {
        return kodkod.ast.Formula.TRUE; }
}
