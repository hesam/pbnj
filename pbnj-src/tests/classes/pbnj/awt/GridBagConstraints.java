package pbnj.awt;

import java.awt.Insets;

public class GridBagConstraints implements Cloneable, java.io.Serializable, polyglot.ext.pbnj.primitives.PBJObject {
    public static final int RELATIVE = -1;
    
    public static final int REMAINDER = 0;
    
    public static final int NONE = 0;
    
    public static final int BOTH = 1;
    
    public static final int HORIZONTAL = 2;
    
    public static final int VERTICAL = 3;
    
    public static final int CENTER = 10;
    
    public static final int NORTH = 11;
    
    public static final int NORTHEAST = 12;
    
    public static final int EAST = 13;
    
    public static final int SOUTHEAST = 14;
    
    public static final int SOUTH = 15;
    
    public static final int SOUTHWEST = 16;
    
    public static final int WEST = 17;
    
    public static final int NORTHWEST = 18;
    
    public static final int PAGE_START = 19;
    
    public static final int PAGE_END = 20;
    
    public static final int LINE_START = 21;
    
    public static final int LINE_END = 22;
    
    public static final int FIRST_LINE_START = 23;
    
    public static final int FIRST_LINE_END = 24;
    
    public static final int LAST_LINE_START = 25;
    
    public static final int LAST_LINE_END = 26;
    
    public int gridx;
    
    public int gridy;
    
    public int gridwidth;
    
    public int gridheight;
    
    public double weightx;
    
    public double weighty;
    
    public int anchor;
    
    public int fill;
    
    public Insets insets;
    
    public int ipadx;
    
    public int ipady;
    
    int tempX;
    
    int tempY;
    
    int tempWidth;
    
    int tempHeight;
    
    int minWidth;
    
    int minHeight;
    
    private static final long serialVersionUID = -1000070633030801713L;
    
    public GridBagConstraints() { super();
                                  gridx = RELATIVE;
                                  gridy = RELATIVE;
                                  gridwidth = 1;
                                  gridheight = 1;
                                  weightx = 0;
                                  weighty = 0;
                                  anchor = CENTER;
                                  fill = NONE;
                                  insets = new Insets(0, 0, 0, 0);
                                  ipadx = 0;
                                  ipady = 0;
                                  polyglot.ext.pbnj.tologic.LogMap.addInstance(GridBagConstraints.class, this); }
    
    public GridBagConstraints(int gridx, int gridy, int gridwidth, int gridheight, double weightx, double weighty,
                              int anchor, int fill, Insets insets, int ipadx, int ipady) {
        super();
        this.gridx = gridx;
        this.gridy = gridy;
        this.gridwidth = gridwidth;
        this.gridheight = gridheight;
        this.fill = fill;
        this.ipadx = ipadx;
        this.ipady = ipady;
        this.insets = insets;
        this.anchor = anchor;
        this.weightx = weightx;
        this.weighty = weighty;
        polyglot.ext.pbnj.tologic.LogMap.addInstance(GridBagConstraints.class, this);
    }
    
    public Object clone2() { try { GridBagConstraints c = (GridBagConstraints) super.clone();
                                   c.insets = (Insets) insets.clone();
                                   return c; }
                             catch (CloneNotSupportedException e) { throw new InternalError(); } }
    
    GridBagConstraints old;
    
    Object result;
    
    public void result(Object r) { this.result = r; }
    
    public GridBagConstraints(polyglot.ext.pbnj.tologic.LogObjSet dontcare) { super(); }
    
    Object[] resultArray;
    
    public void resultArray(Object[] r) { this.resultArray = r; }
    
    public boolean verifyInvariants() { return true; }
    
    long startMethodTime;
    
    public GridBagConstraints old() { return this.old; }
    
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
                             polyglot.ext.pbnj.tologic.LogMap.addToClassInstances(this.old, GridBagConstraints.class); }
    }
    
    public void fallback_relationizeOld() {
        if (!isRelationized()) { this.relationizerStep = polyglot.ext.pbnj.tologic.LogMap.relationizerStep(); } }
    
    public void fallback_relationize() {
        if (!old.isRelationized()) { old.relationizerStep = polyglot.ext.pbnj.tologic.LogMap.relationizerStep(); } }
    
    public GridBagConstraints fallback_clone() {
        if (isCloned()) return this.old;
        GridBagConstraints res = null;
        try { this.clonerStep = polyglot.ext.pbnj.tologic.LogMap.clonerStep();
              res = (GridBagConstraints) super.clone();
              res.isOld = true;
              this.old = res;
              res.old = this; }
        catch (Exception rte) { rte.printStackTrace();
                                System.exit(1); }
        return res; }
    
    static { polyglot.ext.pbnj.tologic.LogMap.newClassForLog(GridBagConstraints.class); }
    
    public static kodkod.ast.Formula verifyInvariants_log(kodkod.ast.Expression target, boolean target_isOld) {
        return kodkod.ast.Formula.TRUE; }
}
