package pbnj.awt;

import java.awt.Insets;
import java.awt.Component;
import java.awt.LayoutManager2;
import java.awt.Container;
import java.awt.Rectangle;
import java.awt.Dimension;
import pbnjx.swing.PBJButton;
import polyglot.ext.pbnj.primitives.*;
import polyglot.ext.pbnj.tologic.LogMap;
import pbnj.util.Hashtable;
import pbnj.util.Vector;
import pbnj.util.Arrays;
import pbnj.util.ArrayList;

public class GridBagLayout implements LayoutManager2, java.io.Serializable, PBJObject {
    protected static final int MAXGRIDSIZE =
      512;
    
    protected static final int MINSIZE =
      1;
    
    protected static final int PREFERREDSIZE =
      2;
    
    protected Hashtable<Component, GridBagConstraints> comptable;
    
    protected int SPEC_GRID;
    
    protected boolean FALLBACK;
    
    int gridCols;
    
    int gridRows;
    
    protected int parentW;
    
    protected int parentH;
    
    protected int parentGridW;
    
    protected int parentGridH;
    
    Component[] components;
    
    PBJButton[] buttons;
    
    protected GridBagConstraints defaultConstraints;
    
    protected GridBagLayoutInfo layoutInfo;
    
    public int[] columnWidths;
    
    public int[] rowHeights;
    
    public double[] columnWeights;
    
    public double[] rowWeights;
    
    public GridBagLayout(boolean fallbackOn,
                         int specGrid,
                         int gridCols,
                         int gridRows) {
        super();
        FALLBACK =
          fallbackOn;
        SPEC_GRID =
          specGrid;
        this.gridCols =
          gridCols;
        this.gridRows =
          gridRows;
        comptable =
          new Hashtable<Component, GridBagConstraints>();
        defaultConstraints =
          new GridBagConstraints();
        LogMap.addInstance(GridBagLayout.class,
                           this);
    }
    
    public void setConstraints(Component comp,
                               GridBagConstraints constraints) {
        comptable.put(comp,
                      (GridBagConstraints)
                        constraints);
    }
    
    public GridBagConstraints getConstraints(Component comp) {
        GridBagConstraints constraints =
          comptable.get(comp);
        if (constraints ==
              null) {
            setConstraints(comp,
                           defaultConstraints);
            constraints =
              comptable.get(comp);
        }
        return (GridBagConstraints)
                 constraints.clone2();
    }
    
    protected GridBagConstraints lookupConstraints(Component comp) {
        GridBagConstraints constraints =
          comptable.get(comp);
        if (constraints ==
              null) {
            setConstraints(comp,
                           defaultConstraints);
            constraints =
              comptable.get(comp);
        }
        return constraints;
    }
    
    private void removeConstraints(Component comp) {
        comptable.remove(comp);
    }
    
    public Point getLayoutOrigin() {
        Point origin =
          new Point(0,
                    0);
        if (layoutInfo !=
              null) {
            origin.x =
              layoutInfo.startx;
            origin.y =
              layoutInfo.starty;
        }
        return origin;
    }
    
    public int[][] getLayoutDimensions() {
        if (layoutInfo ==
              null)
            return new int[2][0];
        int[][] dim =
          new int[2][];
        dim[0] =
          (new int[layoutInfo.width]);
        dim[1] =
          (new int[layoutInfo.height]);
        System.arraycopy(layoutInfo.minWidth,
                         0,
                         dim[0],
                         0,
                         layoutInfo.width);
        System.arraycopy(layoutInfo.minHeight,
                         0,
                         dim[1],
                         0,
                         layoutInfo.height);
        return dim;
    }
    
    public double[][] getLayoutWeights() {
        if (layoutInfo ==
              null)
            return new double[2][0];
        double[][] weights =
          new double[2][];
        weights[0] =
          (new double[layoutInfo.width]);
        weights[1] =
          (new double[layoutInfo.height]);
        System.arraycopy(layoutInfo.weightX,
                         0,
                         weights[0],
                         0,
                         layoutInfo.width);
        System.arraycopy(layoutInfo.weightY,
                         0,
                         weights[1],
                         0,
                         layoutInfo.height);
        return weights;
    }
    
    public Point location(int x,
                          int y) {
        Point loc =
          new Point(0,
                    0);
        int i;
        int d;
        if (layoutInfo ==
              null)
            return loc;
        d =
          layoutInfo.startx;
        if (!rightToLeft) {
            for (i =
                   0;
                 i <
                   layoutInfo.width;
                 i++) {
                d +=
                  layoutInfo.minWidth[i];
                if (d >
                      x)
                    break;
            }
        } else {
            for (i =
                   layoutInfo.width -
                     1;
                 i >=
                   0;
                 i--) {
                if (d >
                      x)
                    break;
                d +=
                  layoutInfo.minWidth[i];
            }
            i++;
        }
        loc.x =
          i;
        d =
          layoutInfo.starty;
        for (i =
               0;
             i <
               layoutInfo.height;
             i++) {
            d +=
              layoutInfo.minHeight[i];
            if (d >
                  y)
                break;
        }
        loc.y =
          i;
        return loc;
    }
    
    public void addLayoutComponent(String name,
                                   Component comp) {
        
    }
    
    public void addLayoutComponent(Component comp,
                                   Object constraints) {
        if (constraints instanceof GridBagConstraints) {
            setConstraints(comp,
                           (GridBagConstraints)
                             constraints);
        } else
            if (constraints !=
                  null) {
                throw new IllegalArgumentException(("cannot add to layout: constraints must be a GridBagConstrain" +
                                                    "t"));
            }
    }
    
    public void removeLayoutComponent(Component comp) {
        removeConstraints(comp);
    }
    
    public Dimension preferredLayoutSize(Container parent) {
        GridBagLayoutInfo info =
          getLayoutInfo(parent,
                        PREFERREDSIZE);
        return getMinSize(parent,
                          info);
    }
    
    public Dimension minimumLayoutSize(Container parent) {
        GridBagLayoutInfo info =
          getLayoutInfo(parent,
                        MINSIZE);
        return getMinSize(parent,
                          info);
    }
    
    public Dimension maximumLayoutSize(Container target) {
        return new Dimension(Integer.MAX_VALUE,
                             Integer.MAX_VALUE);
    }
    
    public float getLayoutAlignmentX(Container parent) {
        return 0.5F;
    }
    
    public float getLayoutAlignmentY(Container parent) {
        return 0.5F;
    }
    
    public void invalidateLayout(Container target) {
        
    }
    
    public void layoutContainer(Container parent) {
        arrangeGrid(parent);
    }
    
    public String toString() {
        return getClass().getName();
    }
    
    protected void DumpLayoutInfo(GridBagLayoutInfo s) {
        int x;
        System.out.println("minWidth: " +
                           s.minWidth +
                           " minHeight: " +
                           s.minHeight);
        System.out.println("Col\tWidth\tWeight");
        for (x =
               0;
             x <
               s.width;
             x++) {
            System.out.println(x +
                               "\t" +
                               s.minWidth[x] +
                               "\t" +
                               s.weightX[x]);
        }
        System.out.println("Row\tHeight\tWeight");
        for (x =
               0;
             x <
               s.height;
             x++) {
            System.out.println(x +
                               "\t" +
                               s.minHeight[x] +
                               "\t" +
                               s.weightY[x]);
        }
        for (int compindex =
               0;
             compindex <
               components.length;
             compindex++) {
            PBJButton comp =
              (PBJButton)
                components[compindex];
            if (!comp.isVisible())
                continue;
            GridBagConstraints constraints =
              lookupConstraints(comp);
            System.out.print("x=" +
                             comp.getX() /
                               SPEC_GRID +
                             " y=" +
                             comp.getY() /
                               SPEC_GRID +
                             " w=" +
                             comp.getWidth() /
                               SPEC_GRID +
                             " h=" +
                             comp.getHeight() /
                               SPEC_GRID);
            System.out.print(" xp=" +
                             comp.xp() +
                             " yp=" +
                             comp.yp() +
                             " wp=" +
                             comp.wp() +
                             " hp=" +
                             comp.hp());
            System.out.print(" gw=" +
                             comp.gw() +
                             " gh=" +
                             comp.gh());
            System.out.print(" mw=" +
                             constraints.minWidth +
                             " mh=" +
                             constraints.minHeight);
            System.out.print(" ewp=" +
                             comp.ewp() +
                             " ey=" +
                             comp.ey() +
                             " ew=" +
                             comp.ew() +
                             " eh=" +
                             comp.eh());
            System.out.print(" gx=" +
                             comp.gx() +
                             " gy=" +
                             comp.gy());
            System.out.println(" iright=" +
                               comp.iright() +
                               " itop=" +
                               comp.itop());
        }
        System.out.println("parentGW: " +
                           parentGridW +
                           " parentGH: " +
                           parentGridH +
                           " parentw: " +
                           this.parentW +
                           " parenth: " +
                           this.parentH);
    }
    
    protected void DumpConstraints(GridBagConstraints constraints) {
        System.out.println("wt " +
                           constraints.weightx +
                           " " +
                           constraints.weighty +
                           ", " +
                           "box " +
                           constraints.gridx +
                           " " +
                           constraints.gridy +
                           " " +
                           constraints.gridwidth +
                           " " +
                           constraints.gridheight +
                           ", " +
                           "min " +
                           constraints.minWidth +
                           " " +
                           constraints.minHeight +
                           ", " +
                           "pad " +
                           constraints.insets.bottom +
                           " " +
                           constraints.insets.left +
                           " " +
                           constraints.insets.right +
                           " " +
                           constraints.insets.top +
                           " " +
                           constraints.ipadx +
                           " " +
                           constraints.ipady);
    }
    
    protected GridBagLayoutInfo getLayoutInfo(Container parent,
                                              int sizeflag) {
        return GetLayoutInfo(parent,
                             sizeflag);
    }
    
    protected GridBagLayoutInfo GetLayoutInfo(Container parent,
                                              int sizeflag) {
        GridBagLayoutInfo r =
          new GridBagLayoutInfo(gridCols,
                                gridRows);
        if (false &&
              FALLBACK) {
            this.components =
              parent.getComponents();
            r.width =
              this.gridCols;
            r.height =
              this.gridRows;
            this.parentW =
              parent.getWidth() /
                SPEC_GRID;
            this.parentH =
              parent.getHeight() /
                SPEC_GRID;
            this.parentGridW =
              this.parentW /
                r.width;
            this.parentGridH =
              this.parentH /
                r.height;
            System.out.println("hi: " +
                               this.parentGridW);
            Component comp;
            GridBagConstraints constraints;
            Dimension d;
            for (int compindex =
                   0;
                 compindex <
                   components.length;
                 compindex++) {
                comp =
                  components[compindex];
                if (!comp.isVisible())
                    continue;
                d =
                  comp.getMinimumSize();
                constraints =
                  lookupConstraints(comp);
                constraints.minWidth =
                  d.width;
                constraints.minHeight =
                  d.height;
                System.out.println("---> " +
                                   constraints.minWidth +
                                   " " +
                                   constraints.minHeight);
                PBJButton b =
                  (PBJButton)
                    comp;
                int cw =
                  constraints.minWidth /
                  constraints.gridwidth;
                int ch =
                  constraints.minHeight /
                    constraints.gridheight +
                    constraints.insets.top +
                  constraints.ipady;
                if (r.minWidth[constraints.gridx] <
                      cw)
                    r.minWidth[constraints.gridx] =
                      cw;
                if (r.minHeight[constraints.gridy] <
                      ch)
                    r.minHeight[constraints.gridy] =
                      ch;
                b.xpSet(b.getX() /
                          SPEC_GRID);
                b.ypSet(b.getY() /
                          SPEC_GRID);
                b.wpSet(b.getWidth() /
                          SPEC_GRID);
                b.hpSet(b.getHeight() /
                          SPEC_GRID);
                b.gw(constraints.gridwidth);
                b.gh(constraints.gridheight);
                b.ew(constraints.gridwidth *
                       constraints.minWidth /
                       SPEC_GRID);
                b.eh(constraints.gridheight *
                       constraints.minHeight /
                       SPEC_GRID);
                int totalMinHs =
                  0;
                for (int idx =
                       0;
                     idx <
                       constraints.gridy;
                     idx++)
                    totalMinHs +=
                      r.minHeight[idx];
                b.ey(constraints.gridheight *
                       totalMinHs /
                       SPEC_GRID);
                b.ewp(parent.getWidth() /
                        SPEC_GRID /
                        r.width *
                        constraints.gridwidth);
                b.gx(constraints.gridx);
                b.gy(constraints.gridy);
                b.iright(constraints.insets.right /
                           SPEC_GRID);
                b.itop(constraints.insets.top /
                         SPEC_GRID);
                b.centerAnchor(constraints.anchor ==
                                 GridBagConstraints.PAGE_END ? 1 : 0);
            }
        } else {
            Component comp;
            GridBagConstraints constraints;
            Dimension d;
            this.components =
              parent.getComponents();
            int compindex;
            int i;
            int j;
            int k;
            int px;
            int py;
            int pixels_diff;
            int nextSize;
            int curX;
            int curY;
            int curWidth;
            int curHeight;
            int curRow;
            int curCol;
            double weight_diff;
            double weight;
            double start;
            double size;
            int[] xMax;
            int[] yMax;
            r.width =
              (r.height =
                 0);
            curRow =
              (curCol =
                 -1);
            xMax =
              (new int[MAXGRIDSIZE]);
            yMax =
              (new int[MAXGRIDSIZE]);
            for (compindex =
                   0;
                 compindex <
                   components.length;
                 compindex++) {
                comp =
                  components[compindex];
                if (!comp.isVisible())
                    continue;
                constraints =
                  lookupConstraints(comp);
                System.out.println("holo1 " +
                                   comp +
                                   " " +
                                   comp.getMinimumSize());
                DumpConstraints(constraints);
                curX =
                  constraints.gridx;
                curY =
                  constraints.gridy;
                curWidth =
                  constraints.gridwidth;
                if (curWidth <=
                      0)
                    curWidth =
                      1;
                curHeight =
                  constraints.gridheight;
                if (curHeight <=
                      0)
                    curHeight =
                      1;
                if (curX <
                      0 &&
                      curY <
                        0) {
                    if (curRow >=
                          0)
                        curY =
                          curRow;
                    else
                        if (curCol >=
                              0)
                            curX =
                              curCol;
                        else
                            curY =
                              0;
                }
                if (curX <
                      0) {
                    px =
                      0;
                    for (i =
                           curY;
                         i <
                           curY +
                             curHeight;
                         i++) {
                        px =
                          Math.max(px,
                                   xMax[i]);
                    }
                    curX =
                      px -
                        curX -
                        1;
                    if (curX <
                          0)
                        curX =
                          0;
                } else
                    if (curY <
                          0) {
                        py =
                          0;
                        for (i =
                               curX;
                             i <
                               curX +
                                 curWidth;
                             i++) {
                            py =
                              Math.max(py,
                                       yMax[i]);
                        }
                        curY =
                          py -
                            curY -
                            1;
                        if (curY <
                              0)
                            curY =
                              0;
                    }
                for (px =
                       curX +
                         curWidth;
                     r.width <
                       px;
                     r.width++)
                    ;
                for (py =
                       curY +
                         curHeight;
                     r.height <
                       py;
                     r.height++)
                    ;
                for (i =
                       curX;
                     i <
                       curX +
                         curWidth;
                     i++) {
                    yMax[i] =
                      py;
                }
                for (i =
                       curY;
                     i <
                       curY +
                         curHeight;
                     i++) {
                    xMax[i] =
                      px;
                }
                if (sizeflag ==
                      PREFERREDSIZE)
                    d =
                      comp.getPreferredSize();
                else
                    d =
                      comp.getMinimumSize();
                constraints.minWidth =
                  d.width;
                constraints.minHeight =
                  d.height;
                if (constraints.gridheight ==
                      0 &&
                      constraints.gridwidth ==
                        0)
                    curRow =
                      (curCol =
                         -1);
                if (constraints.gridheight ==
                      0 &&
                      curRow <
                        0)
                    curCol =
                      curX +
                        curWidth;
                else
                    if (constraints.gridwidth ==
                          0 &&
                          curCol <
                            0)
                        curRow =
                          curY +
                            curHeight;
            }
            if (columnWidths !=
                  null &&
                  r.width <
                    columnWidths.length)
                r.width =
                  columnWidths.length;
            if (rowHeights !=
                  null &&
                  r.height <
                    rowHeights.length)
                r.height =
                  rowHeights.length;
            curRow =
              (curCol =
                 -1);
            xMax =
              (new int[MAXGRIDSIZE]);
            yMax =
              (new int[MAXGRIDSIZE]);
            for (compindex =
                   0;
                 compindex <
                   components.length;
                 compindex++) {
                comp =
                  components[compindex];
                if (!comp.isVisible())
                    continue;
                constraints =
                  lookupConstraints(comp);
                System.out.println("holo2");
                DumpConstraints(constraints);
                curX =
                  constraints.gridx;
                curY =
                  constraints.gridy;
                curWidth =
                  constraints.gridwidth;
                curHeight =
                  constraints.gridheight;
                if (curX <
                      0 &&
                      curY <
                        0) {
                    if (curRow >=
                          0)
                        curY =
                          curRow;
                    else
                        if (curCol >=
                              0)
                            curX =
                              curCol;
                        else
                            curY =
                              0;
                }
                if (curX <
                      0) {
                    if (curHeight <=
                          0) {
                        curHeight +=
                          r.height -
                            curY;
                        if (curHeight <
                              1)
                            curHeight =
                              1;
                    }
                    px =
                      0;
                    for (i =
                           curY;
                         i <
                           curY +
                             curHeight;
                         i++)
                        px =
                          Math.max(px,
                                   xMax[i]);
                    curX =
                      px -
                        curX -
                        1;
                    if (curX <
                          0)
                        curX =
                          0;
                } else
                    if (curY <
                          0) {
                        if (curWidth <=
                              0) {
                            curWidth +=
                              r.width -
                                curX;
                            if (curWidth <
                                  1)
                                curWidth =
                                  1;
                        }
                        py =
                          0;
                        for (i =
                               curX;
                             i <
                               curX +
                                 curWidth;
                             i++)
                            py =
                              Math.max(py,
                                       yMax[i]);
                        curY =
                          py -
                            curY -
                            1;
                        if (curY <
                              0)
                            curY =
                              0;
                    }
                if (curWidth <=
                      0) {
                    curWidth +=
                      r.width -
                        curX;
                    if (curWidth <
                          1)
                        curWidth =
                          1;
                }
                if (curHeight <=
                      0) {
                    curHeight +=
                      r.height -
                        curY;
                    if (curHeight <
                          1)
                        curHeight =
                          1;
                }
                px =
                  curX +
                    curWidth;
                py =
                  curY +
                    curHeight;
                for (i =
                       curX;
                     i <
                       curX +
                         curWidth;
                     i++) {
                    yMax[i] =
                      py;
                }
                for (i =
                       curY;
                     i <
                       curY +
                         curHeight;
                     i++) {
                    xMax[i] =
                      px;
                }
                if (constraints.gridheight ==
                      0 &&
                      constraints.gridwidth ==
                        0)
                    curRow =
                      (curCol =
                         -1);
                if (constraints.gridheight ==
                      0 &&
                      curRow <
                        0)
                    curCol =
                      curX +
                        curWidth;
                else
                    if (constraints.gridwidth ==
                          0 &&
                          curCol <
                            0)
                        curRow =
                          curY +
                            curHeight;
                constraints.tempX =
                  curX;
                constraints.tempY =
                  curY;
                constraints.tempWidth =
                  curWidth;
                constraints.tempHeight =
                  curHeight;
            }
            if (columnWidths !=
                  null)
                System.arraycopy(columnWidths,
                                 0,
                                 r.minWidth,
                                 0,
                                 columnWidths.length);
            if (rowHeights !=
                  null)
                System.arraycopy(rowHeights,
                                 0,
                                 r.minHeight,
                                 0,
                                 rowHeights.length);
            if (columnWeights !=
                  null)
                System.arraycopy(columnWeights,
                                 0,
                                 r.weightX,
                                 0,
                                 Math.min(r.weightX.length,
                                          columnWeights.length));
            if (rowWeights !=
                  null)
                System.arraycopy(rowWeights,
                                 0,
                                 r.weightY,
                                 0,
                                 Math.min(r.weightY.length,
                                          rowWeights.length));
            nextSize =
              Integer.MAX_VALUE;
            for (i =
                   1;
                 i !=
                   Integer.MAX_VALUE;
                 i =
                   nextSize,
                   nextSize =
                     Integer.MAX_VALUE) {
                for (compindex =
                       0;
                     compindex <
                       components.length;
                     compindex++) {
                    comp =
                      components[compindex];
                    if (!comp.isVisible())
                        continue;
                    constraints =
                      lookupConstraints(comp);
                    System.out.println("holo3");
                    DumpConstraints(constraints);
                    if (constraints.tempWidth ==
                          i) {
                        px =
                          constraints.tempX +
                            constraints.tempWidth;
                        weight_diff =
                          constraints.weightx;
                        for (k =
                               constraints.tempX;
                             k <
                               px;
                             k++)
                            weight_diff -=
                              r.weightX[k];
                        if (weight_diff >
                              0.0) {
                            weight =
                              0.0;
                            for (k =
                                   constraints.tempX;
                                 k <
                                   px;
                                 k++)
                                weight +=
                                  r.weightX[k];
                            for (k =
                                   constraints.tempX;
                                 weight >
                                   0.0 &&
                                   k <
                                     px;
                                 k++) {
                                double wt =
                                  r.weightX[k];
                                double dx =
                                  wt *
                                    weight_diff /
                                  weight;
                                r.weightX[k] +=
                                  dx;
                                weight_diff -=
                                  dx;
                                weight -=
                                  wt;
                            }
                            r.weightX[px -
                                        1] +=
                              weight_diff;
                        }
                        pixels_diff =
                          constraints.minWidth +
                            constraints.ipadx +
                            constraints.insets.left +
                            constraints.insets.right;
                        for (k =
                               constraints.tempX;
                             k <
                               px;
                             k++)
                            pixels_diff -=
                              r.minWidth[k];
                        if (pixels_diff >
                              0) {
                            weight =
                              0.0;
                            for (k =
                                   constraints.tempX;
                                 k <
                                   px;
                                 k++)
                                weight +=
                                  r.weightX[k];
                            for (k =
                                   constraints.tempX;
                                 weight >
                                   0.0 &&
                                   k <
                                     px;
                                 k++) {
                                double wt =
                                  r.weightX[k];
                                int dx =
                                  (int)
                                    (wt *
                                       (double)
                                         pixels_diff /
                                       weight);
                                r.minWidth[k] +=
                                  dx;
                                pixels_diff -=
                                  dx;
                                weight -=
                                  wt;
                            }
                            r.minWidth[px -
                                         1] +=
                              pixels_diff;
                        }
                    } else
                        if (constraints.tempWidth >
                              i &&
                              constraints.tempWidth <
                                nextSize)
                            nextSize =
                              constraints.tempWidth;
                    if (constraints.tempHeight ==
                          i) {
                        py =
                          constraints.tempY +
                            constraints.tempHeight;
                        weight_diff =
                          constraints.weighty;
                        for (k =
                               constraints.tempY;
                             k <
                               py;
                             k++)
                            weight_diff -=
                              r.weightY[k];
                        if (weight_diff >
                              0.0) {
                            weight =
                              0.0;
                            for (k =
                                   constraints.tempY;
                                 k <
                                   py;
                                 k++)
                                weight +=
                                  r.weightY[k];
                            for (k =
                                   constraints.tempY;
                                 weight >
                                   0.0 &&
                                   k <
                                     py;
                                 k++) {
                                double wt =
                                  r.weightY[k];
                                double dy =
                                  wt *
                                    weight_diff /
                                  weight;
                                r.weightY[k] +=
                                  dy;
                                weight_diff -=
                                  dy;
                                weight -=
                                  wt;
                            }
                            r.weightY[py -
                                        1] +=
                              weight_diff;
                        }
                        pixels_diff =
                          constraints.minHeight +
                            constraints.ipady +
                            constraints.insets.top +
                            constraints.insets.bottom;
                        for (k =
                               constraints.tempY;
                             k <
                               py;
                             k++)
                            pixels_diff -=
                              r.minHeight[k];
                        if (pixels_diff >
                              0) {
                            weight =
                              0.0;
                            for (k =
                                   constraints.tempY;
                                 k <
                                   py;
                                 k++)
                                weight +=
                                  r.weightY[k];
                            for (k =
                                   constraints.tempY;
                                 weight >
                                   0.0 &&
                                   k <
                                     py;
                                 k++) {
                                double wt =
                                  r.weightY[k];
                                int dy =
                                  (int)
                                    (wt *
                                       (double)
                                         pixels_diff /
                                       weight);
                                r.minHeight[k] +=
                                  dy;
                                pixels_diff -=
                                  dy;
                                weight -=
                                  wt;
                            }
                            r.minHeight[py -
                                          1] +=
                              pixels_diff;
                        }
                    } else
                        if (constraints.tempHeight >
                              i &&
                              constraints.tempHeight <
                                nextSize)
                            nextSize =
                              constraints.tempHeight;
                    PBJButton b =
                      (PBJButton)
                        comp;
                    b.xpSet(b.getX() /
                              SPEC_GRID);
                    b.ypSet(b.getY() /
                              SPEC_GRID);
                    b.wpSet(b.getWidth() /
                              SPEC_GRID);
                    b.hpSet(b.getHeight() /
                              SPEC_GRID);
                    b.gw(constraints.gridwidth);
                    b.gh(constraints.gridheight);
                    b.ew(constraints.gridwidth *
                           r.minWidth[constraints.gridx] /
                           SPEC_GRID);
                    b.eh(constraints.gridheight *
                           r.minHeight[constraints.gridy] /
                           SPEC_GRID);
                    int totalMinHs =
                      0;
                    for (int idx =
                           0;
                         idx <
                           constraints.gridy;
                         idx++)
                        totalMinHs +=
                          r.minHeight[idx];
                    b.ey(constraints.gridheight *
                           totalMinHs /
                           SPEC_GRID);
                    b.ewp(parent.getWidth() /
                            SPEC_GRID /
                            r.width *
                            constraints.gridwidth);
                    b.gx(constraints.gridx);
                    b.gy(constraints.gridy);
                    b.iright(constraints.insets.right /
                               SPEC_GRID);
                    b.itop(constraints.insets.top /
                             SPEC_GRID);
                    b.centerAnchor(constraints.anchor ==
                                     GridBagConstraints.PAGE_END ? 1 : 0);
                }
            }
            this.parentW =
              parent.getWidth() /
                SPEC_GRID;
            this.parentH =
              parent.getHeight() /
                SPEC_GRID;
            this.parentGridW =
              this.parentW /
                r.width;
            this.parentGridH =
              this.parentH /
                r.height;
        }
        return r;
    }
    
    protected void adjustForGravity(GridBagConstraints constraints,
                                    Rectangle r) {
        AdjustForGravity(constraints,
                         r);
    }
    
    protected void AdjustForGravity(GridBagConstraints constraints,
                                    Rectangle r) {
        int diffx;
        int diffy;
        if (!rightToLeft) {
            r.x +=
              constraints.insets.left;
        } else {
            r.x -=
              r.width -
                constraints.insets.right;
        }
        r.width -=
          constraints.insets.left +
            constraints.insets.right;
        r.y +=
          constraints.insets.top;
        r.height -=
          constraints.insets.top +
            constraints.insets.bottom;
        diffx =
          0;
        if (constraints.fill !=
              GridBagConstraints.HORIZONTAL &&
              constraints.fill !=
                GridBagConstraints.BOTH &&
              r.width >
                constraints.minWidth +
                  constraints.ipadx) {
            diffx =
              r.width -
                (constraints.minWidth +
                   constraints.ipadx);
            r.width =
              constraints.minWidth +
                constraints.ipadx;
        }
        diffy =
          0;
        if (constraints.fill !=
              GridBagConstraints.VERTICAL &&
              constraints.fill !=
                GridBagConstraints.BOTH &&
              r.height >
                constraints.minHeight +
                  constraints.ipady) {
            diffy =
              r.height -
                (constraints.minHeight +
                   constraints.ipady);
            r.height =
              constraints.minHeight +
                constraints.ipady;
        }
        switch (constraints.anchor) {
            case GridBagConstraints.CENTER:
                r.x +=
                  diffx /
                    2;
                r.y +=
                  diffy /
                    2;
                break;
            case GridBagConstraints.PAGE_START:
            case GridBagConstraints.NORTH:
                r.x +=
                  diffx /
                    2;
                break;
            case GridBagConstraints.NORTHEAST:
                r.x +=
                  diffx;
                break;
            case GridBagConstraints.EAST:
                r.x +=
                  diffx;
                r.y +=
                  diffy /
                    2;
                break;
            case GridBagConstraints.SOUTHEAST:
                r.x +=
                  diffx;
                r.y +=
                  diffy;
                break;
            case GridBagConstraints.PAGE_END:
            case GridBagConstraints.SOUTH:
                r.x +=
                  diffx /
                    2;
                r.y +=
                  diffy;
                break;
            case GridBagConstraints.SOUTHWEST:
                r.y +=
                  diffy;
                break;
            case GridBagConstraints.WEST:
                r.y +=
                  diffy /
                    2;
                break;
            case GridBagConstraints.NORTHWEST:
                break;
            case GridBagConstraints.LINE_START:
                if (rightToLeft) {
                    r.x +=
                      diffx;
                }
                r.y +=
                  diffy /
                    2;
                break;
            case GridBagConstraints.LINE_END:
                if (!rightToLeft) {
                    r.x +=
                      diffx;
                }
                r.y +=
                  diffy /
                    2;
                break;
            case GridBagConstraints.FIRST_LINE_START:
                if (rightToLeft) {
                    r.x +=
                      diffx;
                }
                break;
            case GridBagConstraints.FIRST_LINE_END:
                if (!rightToLeft) {
                    r.x +=
                      diffx;
                }
                break;
            case GridBagConstraints.LAST_LINE_START:
                if (rightToLeft) {
                    r.x +=
                      diffx;
                }
                r.y +=
                  diffy;
                break;
            case GridBagConstraints.LAST_LINE_END:
                if (!rightToLeft) {
                    r.x +=
                      diffx;
                }
                r.y +=
                  diffy;
                break;
            default:
                throw new IllegalArgumentException("illegal anchor value");
        }
    }
    
    protected Dimension getMinSize(Container parent,
                                   GridBagLayoutInfo info) {
        return GetMinSize(parent,
                          info);
    }
    
    protected Dimension GetMinSize(Container parent,
                                   GridBagLayoutInfo info) {
        Dimension d =
          new Dimension();
        int i;
        int t;
        Insets insets =
          parent.getInsets();
        t =
          0;
        for (i =
               0;
             i <
               info.width;
             i++)
            t +=
              info.minWidth[i];
        d.width =
          t +
            insets.left +
            insets.right;
        t =
          0;
        for (i =
               0;
             i <
               info.height;
             i++)
            t +=
              info.minHeight[i];
        d.height =
          t +
            insets.top +
            insets.bottom;
        return d;
    }
    
    protected Point GetMinSize2(Container parent,
                                GridBagLayoutInfo info) {
        Point d =
          new Point();
        return GetMinSize2H(parent,
                            info,
                            d);
    }
    
    PBJSet<Point> unarySet(Point p) {
        PBJSet<Point> r =
          new PBJSet<Point>();
        r.add(p);
        return r;
    }
    
    protected Point GetMinSize2H(Container parent,
                                 GridBagLayoutInfo info,
                                 Point d) {
        int i;
        int t;
        Insets insets =
          parent.getInsets();
        t =
          0;
        for (i =
               0;
             i <
               info.width;
             i++)
            t +=
              info.minWidth[i];
        d.x =
          t +
            insets.left +
            insets.right;
        t =
          0;
        for (i =
               0;
             i <
               info.height;
             i++)
            t +=
              info.minHeight[i];
        d.y =
          t +
            insets.top +
            insets.bottom;
        return d;
    }
    
    transient boolean rightToLeft =
      false;
    
    protected boolean boundsValid(PBJButton c1) {
        return c1.xp() >=
                 0 &&
                 c1.yp() >=
                   0 &&
                 c1.wp() >
                   0 &&
                 c1.hp() >
                   0 &&
                 c1.xp() +
                   c1.wp() <=
                   this.parentW &&
                 c1.yp() +
                   c1.hp() <=
                   this.parentH &&
                 c1.xp() ==
                   c1.gx() *
                     this.parentGridW &&
                 c1.wp() ==
                   c1.ewp() -
                     c1.iright() &&
          c1.hp() ==
            c1.eh() -
              c1.itop();
    }
    
    protected boolean positionValid(PBJButton c1) {
        return c1.centerAnchor() ==
                 1 &&
                 c1.yp() +
                   c1.hp() ==
                   this.parentH ||
          c1.centerAnchor() ==
            0 &&
            c1.yp() ==
              c1.ey();
    }
    
    protected boolean noOverlaps(PBJButton c1,
                                 PBJButton c2) {
        return c2.xp() >=
                 c1.xp() &&
                 c2.xp() >=
                   c1.xp() +
                     c1.wp() ||
                 c2.xp() <=
                   c1.xp() &&
                   c2.xp() +
                     c2.wp() <=
                     c1.xp() ||
                 c2.yp() >=
                   c1.yp() &&
                   c2.yp() >=
                     c1.yp() +
                       c1.hp() ||
          c2.yp() <=
            c1.yp() &&
            c2.yp() +
              c2.hp() <=
              c1.yp();
    }
    
    protected boolean relPositionsValid(PBJButton c1,
                                        PBJButton c2) {
        return (c1.gy() !=
                  c2.gy() ||
                  c1.yp() ==
                    c2.yp() &&
                    (c2.gx() >
                       c1.gx() &&
                       c2.xp() >=
                         c1.xp() +
                           c1.wp() ||
                       c2.gx() <
                         c1.gx() &&
                         c2.xp() +
                           c2.wp() <=
                           c1.xp())) &&
          (c1.gy() ==
             c2.gy() ||
             c2.gy() >
               c1.gy() &&
               c2.yp() >=
                 c1.yp() +
                   c1.hp() ||
             c2.gy() <
               c1.gy() &&
               c2.yp() +
                 c2.hp() <=
                 c1.yp());
    }
    
    protected boolean gridLayoutValid() {
        return gridLayoutValid_univQuantify_1();
    }
    
    protected void arrangeGrid(Container parent) {
        PBJInteger.setBounds(0,
                             Math.max(50,
                                      Math.max(this.parentW,
                                               this.parentH)));
        if (FALLBACK) {
            Dimension d;
            layoutInfo =
              getLayoutInfo(parent,
                            PREFERREDSIZE);
            d =
              getMinSize(parent,
                         layoutInfo);
            if (parent.getWidth() <
                  d.width ||
                  parent.getHeight() <
                    d.height) {
                layoutInfo =
                  getLayoutInfo(parent,
                                MINSIZE);
                d =
                  getMinSize(parent,
                             layoutInfo);
            }
            Component[] tmpComps =
              parent.getComponents();
            this.buttons =
              (new PBJButton[tmpComps.length]);
            for (int i =
                   0;
                 i <
                   tmpComps.length;
                 i++) {
                this.buttons[i] =
                  (PBJButton)
                    tmpComps[i];
            }
            System.out.println("Before:");
            DumpLayoutInfo(layoutInfo);
            ArrangeGridEnsured();
            System.out.println("after:");
            DumpLayoutInfo(layoutInfo);
            System.out.println(d);
        } else
            ArrangeGrid(parent);
    }
    
    protected void ArrangeGridEnsured() {
        try {
            initEnsuredMethod();
            int z =
              FALLBACK ? 1 /
                           0 : 0;
            assert this.verifyInvariants() &&
                     this.verifyFieldInvariants_ArrangeGridEnsured() &&
              gridLayoutValid();
        }
        catch (Throwable rte) {
            rte.printStackTrace();
            LogMap.initRelationize();
            old.fallback_atomize();
            LogMap.ObjToAtomMap(null);
            old.fallback_relationizeOld();
            if (LogMap.SolverOpt_Prove())
                old.fallback_relationize();
            LogMap.initRelations();
            ArrangeGridEnsured_fallback();
        }
    }
    
    protected void ArrangeGrid(Container parent) {
        Component comp;
        int compindex;
        GridBagConstraints constraints;
        Insets insets =
          parent.getInsets();
        this.components =
          parent.getComponents();
        Dimension d;
        Rectangle r =
          new Rectangle();
        int i;
        int diffw;
        int diffh;
        double weight;
        GridBagLayoutInfo info;
        rightToLeft =
          !parent.getComponentOrientation().isLeftToRight();
        if (components.length ==
              0 &&
              (columnWidths ==
                 null ||
                 columnWidths.length ==
                   0) &&
              (rowHeights ==
                 null ||
                 rowHeights.length ==
                   0)) {
            return;
        }
        info =
          getLayoutInfo(parent,
                        PREFERREDSIZE);
        d =
          getMinSize(parent,
                     info);
        if (parent.getWidth() <
              d.width ||
              parent.getHeight() <
                d.height) {
            info =
              getLayoutInfo(parent,
                            MINSIZE);
            d =
              getMinSize(parent,
                         info);
        }
        layoutInfo =
          info;
        r.width =
          d.width;
        r.height =
          d.height;
        System.out.println("Orig:");
        DumpLayoutInfo(info);
        for (compindex =
               0;
             compindex <
               components.length;
             compindex++) {
            comp =
              components[compindex];
            if (!comp.isVisible())
                continue;
            constraints =
              lookupConstraints(comp);
            DumpConstraints(constraints);
        }
        System.out.println("minSize " +
                           r.width +
                           " " +
                           r.height);
        diffw =
          parent.getWidth() -
            r.width;
        if (diffw !=
              0) {
            weight =
              0.0;
            for (i =
                   0;
                 i <
                   info.width;
                 i++)
                weight +=
                  info.weightX[i];
            if (weight >
                  0.0) {
                for (i =
                       0;
                     i <
                       info.width;
                     i++) {
                    int dx =
                      (int)
                        ((double)
                           diffw *
                           info.weightX[i] /
                           weight);
                    info.minWidth[i] +=
                      dx;
                    r.width +=
                      dx;
                    if (info.minWidth[i] <
                          0) {
                        r.width -=
                          info.minWidth[i];
                        info.minWidth[i] =
                          0;
                    }
                }
            }
            diffw =
              parent.getWidth() -
                r.width;
        } else {
            diffw =
              0;
        }
        diffh =
          parent.getHeight() -
            r.height;
        if (diffh !=
              0) {
            weight =
              0.0;
            for (i =
                   0;
                 i <
                   info.height;
                 i++)
                weight +=
                  info.weightY[i];
            if (weight >
                  0.0) {
                for (i =
                       0;
                     i <
                       info.height;
                     i++) {
                    int dy =
                      (int)
                        ((double)
                           diffh *
                           info.weightY[i] /
                           weight);
                    info.minHeight[i] +=
                      dy;
                    r.height +=
                      dy;
                    if (info.minHeight[i] <
                          0) {
                        r.height -=
                          info.minHeight[i];
                        info.minHeight[i] =
                          0;
                    }
                }
            }
            diffh =
              parent.getHeight() -
                r.height;
        } else {
            diffh =
              0;
        }
        System.out.println("Re-adjusted:");
        DumpLayoutInfo(info);
        info.startx =
          diffw /
            2 +
            insets.left;
        info.starty =
          diffh /
            2 +
            insets.top;
        for (compindex =
               0;
             compindex <
               components.length;
             compindex++) {
            comp =
              components[compindex];
            if (!comp.isVisible())
                continue;
            constraints =
              lookupConstraints(comp);
            if (!rightToLeft) {
                r.x =
                  info.startx;
                for (i =
                       0;
                     i <
                       constraints.tempX;
                     i++)
                    r.x +=
                      info.minWidth[i];
            } else {
                r.x =
                  parent.getWidth() -
                    (diffw /
                       2 +
                       insets.right);
                for (i =
                       0;
                     i <
                       constraints.tempX;
                     i++)
                    r.x -=
                      info.minWidth[i];
            }
            r.y =
              info.starty;
            for (i =
                   0;
                 i <
                   constraints.tempY;
                 i++)
                r.y +=
                  info.minHeight[i];
            r.width =
              0;
            for (i =
                   constraints.tempX;
                 i <
                   constraints.tempX +
                     constraints.tempWidth;
                 i++) {
                r.width +=
                  info.minWidth[i];
            }
            r.height =
              0;
            for (i =
                   constraints.tempY;
                 i <
                   constraints.tempY +
                     constraints.tempHeight;
                 i++) {
                r.height +=
                  info.minHeight[i];
            }
            adjustForGravity(constraints,
                             r);
            if (r.x <
                  0) {
                r.width +=
                  r.x;
                r.x =
                  0;
            }
            if (r.y <
                  0) {
                r.height +=
                  r.y;
                r.y =
                  0;
            }
            if (r.width <=
                  0 ||
                  r.height <=
                    0) {
                comp.setBounds(0,
                               0,
                               0,
                               0);
            } else {
                if (comp.getX() !=
                      r.x ||
                      comp.getY() !=
                        r.y ||
                      comp.getWidth() !=
                        r.width ||
                      comp.getHeight() !=
                        r.height) {
                    comp.setBounds(r.x,
                                   r.y,
                                   r.width,
                                   r.height);
                }
            }
        }
        System.out.println("Final:");
        DumpLayoutInfo(info);
    }
    
    static final long serialVersionUID =
      8838754796412211005L;
    
    GridBagLayout old;
    
    Object result;
    
    public void result(Object r) {
        this.result =
          r;
    }
    
    public GridBagLayout(polyglot.ext.pbnj.tologic.LogObjSet dontcare) {
        super();
    }
    
    Object[] resultArray;
    
    public void resultArray(Object[] r) {
        this.resultArray =
          r;
    }
    
    public boolean verifyInvariants() {
        return true;
    }
    
    long startMethodTime;
    
    public GridBagLayout old() {
        return this.old;
    }
    
    boolean isOld;
    
    public boolean isOld() {
        return this.isOld;
    }
    
    int atomizerStep =
      0;
    
    boolean isAtomized() {
        return this.atomizerStep ==
          LogMap.relationizerStep();
    }
    
    int relationizerStep =
      0;
    
    boolean isRelationized() {
        return this.relationizerStep ==
          LogMap.relationizerStep();
    }
    
    int clonerStep =
      0;
    
    public boolean isCloned() {
        return this.clonerStep ==
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
                                       Object[] args) {
        try {
            return cons.newInstance(args);
        }
        catch (Exception rte) {
            rte.printStackTrace();
            return null;
        }
    }
    
    boolean ArrangeGridEnsured_fallback() {
        System.out.println("fallback initiated...");
        java.util.HashMap<String, String> modifiableFields =
          new java.util.HashMap<String, String>();
        modifiableFields.put("PBJButton.xp",
                             null);
        modifiableFields.put("PBJButton.yp",
                             null);
        modifiableFields.put("PBJButton.wp",
                             null);
        modifiableFields.put("PBJButton.hp",
                             null);
        kodkod.ast.Expression target =
          LogMap.objToSingletonRelation_log(this);
        boolean target_isOld =
          false;
        kodkod.ast.Formula fallback_problem =
          GridBagLayout.verifyInvariants_log(target,
                                             target_isOld).and(GridBagLayout.verifyFieldInvariants_ArrangeGridEnsured_log(target,
                                                                                                                          target_isOld)).and(GridBagLayout.gridLayoutValid_log(target,
                                                                                                                                                                               target_isOld));
        boolean isSatisfiable =
          LogMap.solve(this,
                       fallback_problem,
                       null,
                       modifiableFields,
                       null,
                       false,
                       this.startMethodTime,
                       false);
        assert isSatisfiable: "Formula UNSAT! Recovery failed...";
        return isSatisfiable;
    }
    
    public boolean verifyFieldInvariants_ArrangeGridEnsured() {
        return true;
    }
    
    public void fallback_atomize() {
        if (!isAtomized()) {
            this.atomizerStep =
              LogMap.relationizerStep();
            LogMap.addToClassInstances(this.old,
                                       GridBagLayout.class);
            if (this.buttons !=
                  null)
                for (int i_buttons =
                       0;
                     i_buttons <
                       this.buttons.length;
                     i_buttons++)
                    if (this.buttons[i_buttons] !=
                          null)
                        ((PBJObject)
                           this.buttons[i_buttons]).fallback_atomize();
        }
    }
    
    public void fallback_relationizeOld() {
        if (!isRelationized()) {
            this.relationizerStep =
              LogMap.relationizerStep();
            if (this.buttons !=
                  null)
                for (int i_buttons =
                       0;
                     i_buttons <
                       this.buttons.length;
                     i_buttons++)
                    if (this.buttons[i_buttons] !=
                          null)
                        ((PBJObject)
                           this.buttons[i_buttons]).fallback_relationizeOld();
            LogMap.instVarRel_log0(this,
                                   "gridCols_old").put_log(this,
                                                           this.gridCols);
            LogMap.instVarRel_log0(this,
                                   "gridRows_old").put_log(this,
                                                           this.gridRows);
            LogMap.instVarRel_log0(this,
                                   "parentW_old").put_log(this,
                                                          this.parentW);
            LogMap.instVarRel_log0(this,
                                   "parentH_old").put_log(this,
                                                          this.parentH);
            LogMap.instVarRel_log0(this,
                                   "parentGridW_old").put_log(this,
                                                              this.parentGridW);
            LogMap.instVarRel_log0(this,
                                   "parentGridH_old").put_log(this,
                                                              this.parentGridH);
            LogMap.instVarRel_log0(this,
                                   "buttons_old").array_put_log(this,
                                                                this.buttons);
        }
    }
    
    public void fallback_relationize() {
        if (!old.isRelationized()) {
            old.relationizerStep =
              LogMap.relationizerStep();
            if (this.buttons !=
                  null)
                for (int i_buttons =
                       0;
                     i_buttons <
                       this.buttons.length;
                     i_buttons++)
                    if (this.buttons[i_buttons] !=
                          null)
                        ((PBJObject)
                           this.buttons[i_buttons]).fallback_relationize();
            LogMap.instVarRel_log0(this,
                                   "gridCols").put_log(old,
                                                       old.gridCols);
            LogMap.instVarRel_log0(this,
                                   "gridRows").put_log(old,
                                                       old.gridRows);
            LogMap.instVarRel_log0(this,
                                   "parentW").put_log(old,
                                                      old.parentW);
            LogMap.instVarRel_log0(this,
                                   "parentH").put_log(old,
                                                      old.parentH);
            LogMap.instVarRel_log0(this,
                                   "parentGridW").put_log(old,
                                                          old.parentGridW);
            LogMap.instVarRel_log0(this,
                                   "parentGridH").put_log(old,
                                                          old.parentGridH);
            LogMap.instVarRel_log0(this,
                                   "buttons").array_put_log(old,
                                                            old.buttons);
        }
    }
    
    public GridBagLayout fallback_clone() {
        if (isCloned())
            return this.old;
        GridBagLayout res =
          null;
        try {
            this.clonerStep =
              LogMap.clonerStep();
            res =
              (GridBagLayout)
                super.clone();
            res.isOld =
              true;
            this.old =
              res;
            res.old =
              this;
            res.gridCols =
              this.gridCols;
            res.gridRows =
              this.gridRows;
            res.parentW =
              this.parentW;
            res.parentH =
              this.parentH;
            res.parentGridW =
              this.parentGridW;
            res.parentGridH =
              this.parentGridH;
            if (this.buttons !=
                  null) {
                res.buttons =
                  (PBJButton[])
                    this.buttons.clone();
                for (int i_buttons =
                       0;
                     i_buttons <
                       this.buttons.length;
                     i_buttons++)
                    if (this.buttons[i_buttons] !=
                          null)
                        res.buttons[i_buttons] =
                          (PBJButton)
                            ((PBJObject)
                               this.buttons[i_buttons]).fallback_clone();
            }
        }
        catch (Exception rte) {
            rte.printStackTrace();
            System.exit(1);
        }
        return res;
    }
    
    public void fallback_updateField_gridCols(Integer newVal) {
        this.gridCols =
          newVal;
    }
    
    public PBJSet<Integer> fieldsClosure_Integer(Object target,
                                                 boolean isReflexive,
                                                 java.lang.String ... fieldNs) {
        Class c =
          int.class;
        PBJSet<Integer> res =
          new PBJSet<Integer>();
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
                    f.get(target);
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
                          target);
        }
        catch (Exception rte) {
            rte.printStackTrace();
        }
        return res;
    }
    
    PBJSet<Integer> multiFields_Integer(java.lang.String ... fieldNs) {
        Class c =
          Integer.class;
        PBJSet<Integer> res =
          new PBJSet<Integer>();
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
    
    public void fallback_updateField_gridRows(Integer newVal) {
        this.gridRows =
          newVal;
    }
    
    public void fallback_updateField_parentW(Integer newVal) {
        this.parentW =
          newVal;
    }
    
    public void fallback_updateField_parentH(Integer newVal) {
        this.parentH =
          newVal;
    }
    
    public void fallback_updateField_parentGridW(Integer newVal) {
        this.parentGridW =
          newVal;
    }
    
    public void fallback_updateField_parentGridH(Integer newVal) {
        this.parentGridH =
          newVal;
    }
    
    public void fallback_updateField_buttons(java.util.ArrayList<PBJButton> newVal) {
        int i =
          0;
        int s =
          newVal.size();
        if (this.buttons ==
              null)
            this.buttons =
              (new PBJButton[s]);
        while (i <
                 s) {
            this.buttons[i] =
              newVal.get(i);
            i++;
        }
    }
    
    protected boolean gridLayoutValid_univQuantify_1() {
        for (PBJButton c1 : buttons) {
            if (!(boundsValid(c1) &&
                    positionValid(c1) &&
                    gridLayoutValid_univQuantify_0(c1)))
                return false;
        }
        return true;
    }
    
    protected boolean gridLayoutValid_univQuantify_0(PBJButton c1) {
        for (PBJButton c2 : buttons) {
            if (!(c1 ==
                    c2 ||
                    noOverlaps(c1,
                               c2) &&
                      relPositionsValid(c1,
                                        c2)))
                return false;
        }
        return true;
    }
    
    public static kodkod.ast.IntExpression gridCols_get_log(kodkod.ast.Expression target,
                                                            boolean isOld) {
        return LogMap.fieldGet_log(target,
                                   isOld ? "gridCols_old" : "gridCols",
                                   GridBagLayout.class).sum();
    }
    
    public static PBJSet<Integer> setMap_gridCols(PBJSet<GridBagLayout> objs,
                                                  java.lang.String ... fieldNs) {
        PBJSet<Integer> res =
          new PBJSet<Integer>();
        java.util.Iterator<GridBagLayout> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().gridCols);
        }
        return res;
    }
    
    public static kodkod.ast.IntExpression gridRows_get_log(kodkod.ast.Expression target,
                                                            boolean isOld) {
        return LogMap.fieldGet_log(target,
                                   isOld ? "gridRows_old" : "gridRows",
                                   GridBagLayout.class).sum();
    }
    
    public static PBJSet<Integer> setMap_gridRows(PBJSet<GridBagLayout> objs,
                                                  java.lang.String ... fieldNs) {
        PBJSet<Integer> res =
          new PBJSet<Integer>();
        java.util.Iterator<GridBagLayout> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().gridRows);
        }
        return res;
    }
    
    public static kodkod.ast.IntExpression parentW_get_log(kodkod.ast.Expression target,
                                                           boolean isOld) {
        return LogMap.fieldGet_log(target,
                                   isOld ? "parentW_old" : "parentW",
                                   GridBagLayout.class).sum();
    }
    
    public static PBJSet<Integer> setMap_parentW(PBJSet<GridBagLayout> objs,
                                                 java.lang.String ... fieldNs) {
        PBJSet<Integer> res =
          new PBJSet<Integer>();
        java.util.Iterator<GridBagLayout> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().parentW);
        }
        return res;
    }
    
    public static kodkod.ast.IntExpression parentH_get_log(kodkod.ast.Expression target,
                                                           boolean isOld) {
        return LogMap.fieldGet_log(target,
                                   isOld ? "parentH_old" : "parentH",
                                   GridBagLayout.class).sum();
    }
    
    public static PBJSet<Integer> setMap_parentH(PBJSet<GridBagLayout> objs,
                                                 java.lang.String ... fieldNs) {
        PBJSet<Integer> res =
          new PBJSet<Integer>();
        java.util.Iterator<GridBagLayout> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().parentH);
        }
        return res;
    }
    
    public static kodkod.ast.IntExpression parentGridW_get_log(kodkod.ast.Expression target,
                                                               boolean isOld) {
        return LogMap.fieldGet_log(target,
                                   isOld ? "parentGridW_old" : "parentGridW",
                                   GridBagLayout.class).sum();
    }
    
    public static PBJSet<Integer> setMap_parentGridW(PBJSet<GridBagLayout> objs,
                                                     java.lang.String ... fieldNs) {
        PBJSet<Integer> res =
          new PBJSet<Integer>();
        java.util.Iterator<GridBagLayout> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().parentGridW);
        }
        return res;
    }
    
    public static kodkod.ast.IntExpression parentGridH_get_log(kodkod.ast.Expression target,
                                                               boolean isOld) {
        return LogMap.fieldGet_log(target,
                                   isOld ? "parentGridH_old" : "parentGridH",
                                   GridBagLayout.class).sum();
    }
    
    public static PBJSet<Integer> setMap_parentGridH(PBJSet<GridBagLayout> objs,
                                                     java.lang.String ... fieldNs) {
        PBJSet<Integer> res =
          new PBJSet<Integer>();
        java.util.Iterator<GridBagLayout> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().parentGridH);
        }
        return res;
    }
    
    public static polyglot.ext.pbnj.tologic.LogObjSet buttons_get_log(kodkod.ast.Expression target,
                                                                      boolean isOld) {
        return LogMap.fieldGet_obj_set_log(target,
                                           isOld ? "buttons_old" : "buttons",
                                           GridBagLayout.class);
    }
    
    static {
               LogMap.newClassForLog(GridBagLayout.class);
               LogMap.newInstVarRel(GridBagLayout.class,
                                    "gridCols",
                                    GridBagLayout.class,
                                    Integer.class,
                                    Integer.class,
                                    false,
                                    false,
                                    true,
                                    false,
                                    false);
               LogMap.newInstVarRel(GridBagLayout.class,
                                    "gridCols",
                                    GridBagLayout.class,
                                    Integer.class,
                                    Integer.class,
                                    false,
                                    false,
                                    false,
                                    false,
                                    false);
               LogMap.newInstVarRel(GridBagLayout.class,
                                    "gridRows",
                                    GridBagLayout.class,
                                    Integer.class,
                                    Integer.class,
                                    false,
                                    false,
                                    true,
                                    false,
                                    false);
               LogMap.newInstVarRel(GridBagLayout.class,
                                    "gridRows",
                                    GridBagLayout.class,
                                    Integer.class,
                                    Integer.class,
                                    false,
                                    false,
                                    false,
                                    false,
                                    false);
               LogMap.newInstVarRel(GridBagLayout.class,
                                    "parentW",
                                    GridBagLayout.class,
                                    Integer.class,
                                    Integer.class,
                                    false,
                                    false,
                                    true,
                                    false,
                                    false);
               LogMap.newInstVarRel(GridBagLayout.class,
                                    "parentW",
                                    GridBagLayout.class,
                                    Integer.class,
                                    Integer.class,
                                    false,
                                    false,
                                    false,
                                    false,
                                    false);
               LogMap.newInstVarRel(GridBagLayout.class,
                                    "parentH",
                                    GridBagLayout.class,
                                    Integer.class,
                                    Integer.class,
                                    false,
                                    false,
                                    true,
                                    false,
                                    false);
               LogMap.newInstVarRel(GridBagLayout.class,
                                    "parentH",
                                    GridBagLayout.class,
                                    Integer.class,
                                    Integer.class,
                                    false,
                                    false,
                                    false,
                                    false,
                                    false);
               LogMap.newInstVarRel(GridBagLayout.class,
                                    "parentGridW",
                                    GridBagLayout.class,
                                    Integer.class,
                                    Integer.class,
                                    false,
                                    false,
                                    true,
                                    false,
                                    false);
               LogMap.newInstVarRel(GridBagLayout.class,
                                    "parentGridW",
                                    GridBagLayout.class,
                                    Integer.class,
                                    Integer.class,
                                    false,
                                    false,
                                    false,
                                    false,
                                    false);
               LogMap.newInstVarRel(GridBagLayout.class,
                                    "parentGridH",
                                    GridBagLayout.class,
                                    Integer.class,
                                    Integer.class,
                                    false,
                                    false,
                                    true,
                                    false,
                                    false);
               LogMap.newInstVarRel(GridBagLayout.class,
                                    "parentGridH",
                                    GridBagLayout.class,
                                    Integer.class,
                                    Integer.class,
                                    false,
                                    false,
                                    false,
                                    false,
                                    false);
               LogMap.newInstVarRel(GridBagLayout.class,
                                    "buttons",
                                    GridBagLayout.class,
                                    PBJButton.class,
                                    PBJButton.class,
                                    false,
                                    true,
                                    true,
                                    false,
                                    false);
               LogMap.newInstVarRel(GridBagLayout.class,
                                    "buttons",
                                    GridBagLayout.class,
                                    PBJButton.class,
                                    PBJButton.class,
                                    false,
                                    true,
                                    false,
                                    false,
                                    false);
           }
    
    protected static kodkod.ast.Formula boundsValid_log(kodkod.ast.Expression target,
                                                        boolean target_isOld,
                                                        kodkod.ast.Expression c1,
                                                        boolean c1_isOld) {
        return PBJButton.xp_log(c1,
                                c1_isOld).gte(kodkod.ast.IntConstant.constant(0)).and(PBJButton.yp_log(c1,
                                                                                                       c1_isOld).gte(kodkod.ast.IntConstant.constant(0))).and(PBJButton.wp_log(c1,
                                                                                                                                                                               c1_isOld).gt(kodkod.ast.IntConstant.constant(0))).and(PBJButton.hp_log(c1,
                                                                                                                                                                                                                                                      c1_isOld).gt(kodkod.ast.IntConstant.constant(0))).and(PBJButton.xp_log(c1,
                                                                                                                                                                                                                                                                                                                             c1_isOld).plus(PBJButton.wp_log(c1,
                                                                                                                                                                                                                                                                                                                                                             c1_isOld)).lte(GridBagLayout.parentW_get_log(target,
                                                                                                                                                                                                                                                                                                                                                                                                          target_isOld))).and(PBJButton.yp_log(c1,
                                                                                                                                                                                                                                                                                                                                                                                                                                               c1_isOld).plus(PBJButton.hp_log(c1,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                               c1_isOld)).lte(GridBagLayout.parentH_get_log(target,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            target_isOld))).and(PBJButton.xp_log(c1,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 c1_isOld).eq(PBJButton.gx_log(c1,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               c1_isOld).multiply(GridBagLayout.parentGridW_get_log(target,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    target_isOld)))).and(PBJButton.wp_log(c1,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          c1_isOld).eq(PBJButton.ewp_log(c1,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         c1_isOld).minus(PBJButton.iright_log(c1,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              c1_isOld)))).and(PBJButton.hp_log(c1,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                c1_isOld).eq(PBJButton.eh_log(c1,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              c1_isOld).minus(PBJButton.itop_log(c1,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 c1_isOld))));
    }
    
    protected static kodkod.ast.Formula positionValid_log(kodkod.ast.Expression target,
                                                          boolean target_isOld,
                                                          kodkod.ast.Expression c1,
                                                          boolean c1_isOld) {
        return PBJButton.centerAnchor_log(c1,
                                          c1_isOld).eq(kodkod.ast.IntConstant.constant(1)).and(PBJButton.yp_log(c1,
                                                                                                                c1_isOld).plus(PBJButton.hp_log(c1,
                                                                                                                                                c1_isOld)).eq(GridBagLayout.parentH_get_log(target,
                                                                                                                                                                                            target_isOld))).or(PBJButton.centerAnchor_log(c1,
                                                                                                                                                                                                                                          c1_isOld).eq(kodkod.ast.IntConstant.constant(0)).and(PBJButton.yp_log(c1,
                                                                                                                                                                                                                                                                                                                c1_isOld).eq(PBJButton.ey_log(c1,
                                                                                                                                                                                                                                                                                                                                              c1_isOld))));
    }
    
    protected static kodkod.ast.Formula noOverlaps_log(kodkod.ast.Expression target,
                                                       boolean target_isOld,
                                                       kodkod.ast.Expression c1,
                                                       boolean c1_isOld,
                                                       kodkod.ast.Expression c2,
                                                       boolean c2_isOld) {
        return PBJButton.xp_log(c2,
                                c2_isOld).gte(PBJButton.xp_log(c1,
                                                               c1_isOld)).and(PBJButton.xp_log(c2,
                                                                                               c2_isOld).gte(PBJButton.xp_log(c1,
                                                                                                                              c1_isOld).plus(PBJButton.wp_log(c1,
                                                                                                                                                              c1_isOld)))).or(PBJButton.xp_log(c2,
                                                                                                                                                                                               c2_isOld).lte(PBJButton.xp_log(c1,
                                                                                                                                                                                                                              c1_isOld)).and(PBJButton.xp_log(c2,
                                                                                                                                                                                                                                                              c2_isOld).plus(PBJButton.wp_log(c2,
                                                                                                                                                                                                                                                                                              c2_isOld)).lte(PBJButton.xp_log(c1,
                                                                                                                                                                                                                                                                                                                              c1_isOld)))).or(PBJButton.yp_log(c2,
                                                                                                                                                                                                                                                                                                                                                               c2_isOld).gte(PBJButton.yp_log(c1,
                                                                                                                                                                                                                                                                                                                                                                                              c1_isOld)).and(PBJButton.yp_log(c2,
                                                                                                                                                                                                                                                                                                                                                                                                                              c2_isOld).gte(PBJButton.yp_log(c1,
                                                                                                                                                                                                                                                                                                                                                                                                                                                             c1_isOld).plus(PBJButton.hp_log(c1,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             c1_isOld))))).or(PBJButton.yp_log(c2,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               c2_isOld).lte(PBJButton.yp_log(c1,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              c1_isOld)).and(PBJButton.yp_log(c2,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              c2_isOld).plus(PBJButton.hp_log(c2,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              c2_isOld)).lte(PBJButton.yp_log(c1,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              c1_isOld))));
    }
    
    protected static kodkod.ast.Formula relPositionsValid_log(kodkod.ast.Expression target,
                                                              boolean target_isOld,
                                                              kodkod.ast.Expression c1,
                                                              boolean c1_isOld,
                                                              kodkod.ast.Expression c2,
                                                              boolean c2_isOld) {
        return PBJButton.gy_log(c1,
                                c1_isOld).eq(PBJButton.gy_log(c2,
                                                              c2_isOld)).not().or(PBJButton.yp_log(c1,
                                                                                                   c1_isOld).eq(PBJButton.yp_log(c2,
                                                                                                                                 c2_isOld)).and(PBJButton.gx_log(c2,
                                                                                                                                                                 c2_isOld).gt(PBJButton.gx_log(c1,
                                                                                                                                                                                               c1_isOld)).and(PBJButton.xp_log(c2,
                                                                                                                                                                                                                               c2_isOld).gte(PBJButton.xp_log(c1,
                                                                                                                                                                                                                                                              c1_isOld).plus(PBJButton.wp_log(c1,
                                                                                                                                                                                                                                                                                              c1_isOld)))).or(PBJButton.gx_log(c2,
                                                                                                                                                                                                                                                                                                                               c2_isOld).lt(PBJButton.gx_log(c1,
                                                                                                                                                                                                                                                                                                                                                             c1_isOld)).and(PBJButton.xp_log(c2,
                                                                                                                                                                                                                                                                                                                                                                                             c2_isOld).plus(PBJButton.wp_log(c2,
                                                                                                                                                                                                                                                                                                                                                                                                                             c2_isOld)).lte(PBJButton.xp_log(c1,
                                                                                                                                                                                                                                                                                                                                                                                                                                                             c1_isOld)))))).and(PBJButton.gy_log(c1,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 c1_isOld).eq(PBJButton.gy_log(c2,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               c2_isOld)).or(PBJButton.gy_log(c2,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              c2_isOld).gt(PBJButton.gy_log(c1,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            c1_isOld)).and(PBJButton.yp_log(c2,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            c2_isOld).gte(PBJButton.yp_log(c1,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           c1_isOld).plus(PBJButton.hp_log(c1,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           c1_isOld))))).or(PBJButton.gy_log(c2,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             c2_isOld).lt(PBJButton.gy_log(c1,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           c1_isOld)).and(PBJButton.yp_log(c2,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           c2_isOld).plus(PBJButton.hp_log(c2,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           c2_isOld)).lte(PBJButton.yp_log(c1,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           c1_isOld)))));
    }
    
    protected static kodkod.ast.Formula gridLayoutValid_log(kodkod.ast.Expression target,
                                                            boolean target_isOld) {
        boolean c1_isOld =
          false;
        kodkod.ast.Expression c1 =
          kodkod.ast.Variable.unary("c1");
        boolean c2_isOld =
          false;
        kodkod.ast.Expression c2 =
          kodkod.ast.Variable.unary("c2");
        return polyglot.ext.pbnj.tologic.LogObjSet.quantifyOp(GridBagLayout.buttons_get_log(target,
                                                                                            target_isOld),
                                                              false,
                                                              "all",
                                                              c1,
                                                              GridBagLayout.boundsValid_log(target,
                                                                                            target_isOld,
                                                                                            c1,
                                                                                            c1_isOld).and(GridBagLayout.positionValid_log(target,
                                                                                                                                          target_isOld,
                                                                                                                                          c1,
                                                                                                                                          c1_isOld)).and(polyglot.ext.pbnj.tologic.LogObjSet.quantifyOp(GridBagLayout.buttons_get_log(target,
                                                                                                                                                                                                                                      target_isOld),
                                                                                                                                                                                                        false,
                                                                                                                                                                                                        "all",
                                                                                                                                                                                                        c2,
                                                                                                                                                                                                        c1.eq(c2).or(GridBagLayout.noOverlaps_log(target,
                                                                                                                                                                                                                                                  target_isOld,
                                                                                                                                                                                                                                                  c1,
                                                                                                                                                                                                                                                  c1_isOld,
                                                                                                                                                                                                                                                  c2,
                                                                                                                                                                                                                                                  c2_isOld).and(GridBagLayout.relPositionsValid_log(target,
                                                                                                                                                                                                                                                                                                    target_isOld,
                                                                                                                                                                                                                                                                                                    c1,
                                                                                                                                                                                                                                                                                                    c1_isOld,
                                                                                                                                                                                                                                                                                                    c2,
                                                                                                                                                                                                                                                                                                    c2_isOld))))));
    }
    
    public static kodkod.ast.Formula verifyInvariants_log(kodkod.ast.Expression target,
                                                          boolean target_isOld) {
        return kodkod.ast.Formula.TRUE;
    }
    
    public static kodkod.ast.Formula verifyFieldInvariants_ArrangeGridEnsured_log(kodkod.ast.Expression target,
                                                                                  boolean target_isOld) {
        return kodkod.ast.Formula.TRUE;
    }
}
