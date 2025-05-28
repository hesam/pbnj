package pbnj.util;

import polyglot.ext.pbnj.primitives.PBJInternSet;

public class Vector<E>  extends AbstractList<E> implements List<E>, RandomAccess, Cloneable, java.io.Serializable, polyglot.ext.pbnj.primitives.PBJInternObject {
    protected E[] elementData;
    
    protected int elementCount;
    
    protected int capacityIncrement;
    
    private static final long serialVersionUID =
      -2767605614048989439L;
    
    public Vector(int initialCapacity,
                  int capacityIncrement) {
        super();
        if (initialCapacity <
              0)
            throw new IllegalArgumentException("Illegal Capacity: " +
                                               initialCapacity);
        this.elementData =
          (E[])
            (new Object[initialCapacity]);
        this.capacityIncrement =
          capacityIncrement;
    }
    
    public Vector(int initialCapacity) {
        this(initialCapacity,
             0);
    }
    
    public Vector() {
        this(10);
    }
    
    public Vector(Collection<? extends E> c) {
        super();
        elementCount =
          c.size();
        elementData =
          (E[])
            (new Object[(int)
                          Math.min(elementCount *
                                     110L /
                                     100,
                                   Integer.MAX_VALUE)]);
        c.toArray(elementData);
    }
    
    public synchronized void copyInto(Object[] anArray) {
        System.arraycopy(elementData,
                         0,
                         anArray,
                         0,
                         elementCount);
    }
    
    public synchronized void trimToSize() {
        modCount++;
        int oldCapacity =
          elementData.length;
        if (elementCount <
              oldCapacity) {
            Object[] oldData =
              elementData;
            elementData =
              (E[])
                (new Object[elementCount]);
            System.arraycopy(oldData,
                             0,
                             elementData,
                             0,
                             elementCount);
        }
    }
    
    public synchronized void ensureCapacity(int minCapacity) {
        modCount++;
        ensureCapacityHelper(minCapacity);
    }
    
    private void ensureCapacityHelper(int minCapacity) {
        int oldCapacity =
          elementData.length;
        if (minCapacity >
              oldCapacity) {
            Object[] oldData =
              elementData;
            int newCapacity =
              capacityIncrement >
                0 ? oldCapacity +
                      capacityIncrement : oldCapacity *
                                            2;
            if (newCapacity <
                  minCapacity) {
                newCapacity =
                  minCapacity;
            }
            elementData =
              (E[])
                (new Object[newCapacity]);
            System.arraycopy(oldData,
                             0,
                             elementData,
                             0,
                             elementCount);
        }
    }
    
    public synchronized void setSize(int newSize) {
        modCount++;
        if (newSize >
              elementCount) {
            ensureCapacityHelper(newSize);
        } else {
            for (int i =
                   newSize;
                 i <
                   elementCount;
                 i++) {
                elementData[i] =
                  null;
            }
        }
        elementCount =
          newSize;
    }
    
    public synchronized int capacity() {
        return elementData.length;
    }
    
    public synchronized int size() {
        return elementCount;
    }
    
    public synchronized boolean isEmpty() {
        return elementCount ==
          0;
    }
    
    public Enumeration<E> elements() {
        return new Enumeration<E>() {
            int count =
              0;
            
            public boolean hasMoreElements() {
                return count <
                  elementCount;
            }
            
            public E nextElement() {
                if (count <
                      elementCount) {
                    return elementData[count++];
                }
                throw new NoSuchElementException("Vector Enumeration");
            }
        };
    }
    
    public boolean contains(Object elem) {
        return indexOf(elem,
                       0) >=
          0;
    }
    
    public int indexOf(Object elem) {
        return indexOf(elem,
                       0);
    }
    
    public synchronized int indexOf(Object elem,
                                    int index) {
        if (elem ==
              null) {
            for (int i =
                   index;
                 i <
                   elementCount;
                 i++)
                if (elementData[i] ==
                      null)
                    return i;
        } else {
            for (int i =
                   index;
                 i <
                   elementCount;
                 i++)
                if (elem.equals(elementData[i]))
                    return i;
        }
        return -1;
    }
    
    public synchronized int lastIndexOf(Object elem) {
        return lastIndexOf(elem,
                           elementCount -
                             1);
    }
    
    public synchronized int lastIndexOf(Object elem,
                                        int index) {
        if (index >=
              elementCount)
            throw new IndexOutOfBoundsException(index +
                                                " >= " +
                                                elementCount);
        if (elem ==
              null) {
            for (int i =
                   index;
                 i >=
                   0;
                 i--)
                if (elementData[i] ==
                      null)
                    return i;
        } else {
            for (int i =
                   index;
                 i >=
                   0;
                 i--)
                if (elem.equals(elementData[i]))
                    return i;
        }
        return -1;
    }
    
    public synchronized E elementAt(int index) {
        if (index >=
              elementCount) {
            throw new ArrayIndexOutOfBoundsException(index +
                                                     " >= " +
                                                     elementCount);
        }
        return (E)
                 elementData[index];
    }
    
    public synchronized E firstElement() {
        if (elementCount ==
              0) {
            throw new NoSuchElementException();
        }
        return (E)
                 elementData[0];
    }
    
    public synchronized E lastElement() {
        if (elementCount ==
              0) {
            throw new NoSuchElementException();
        }
        return (E)
                 elementData[elementCount -
                               1];
    }
    
    public synchronized void setElementAt(E obj,
                                          int index) {
        if (index >=
              elementCount) {
            throw new ArrayIndexOutOfBoundsException(index +
                                                     " >= " +
                                                     elementCount);
        }
        elementData[index] =
          obj;
    }
    
    public synchronized void removeElementAt(int index) {
        modCount++;
        if (index >=
              elementCount) {
            throw new ArrayIndexOutOfBoundsException(index +
                                                     " >= " +
                                                     elementCount);
        } else
            if (index <
                  0) {
                throw new ArrayIndexOutOfBoundsException(index);
            }
        int j =
          elementCount -
            index -
          1;
        if (j >
              0) {
            System.arraycopy(elementData,
                             index +
                               1,
                             elementData,
                             index,
                             j);
        }
        elementCount--;
        elementData[elementCount] =
          null;
    }
    
    public synchronized void insertElementAt(E obj,
                                             int index) {
        modCount++;
        if (index >
              elementCount) {
            throw new ArrayIndexOutOfBoundsException(index +
                                                     " > " +
                                                     elementCount);
        }
        ensureCapacityHelper(elementCount +
                               1);
        System.arraycopy(elementData,
                         index,
                         elementData,
                         index +
                           1,
                         elementCount -
                           index);
        elementData[index] =
          obj;
        elementCount++;
    }
    
    public synchronized void addElement(E obj) {
        modCount++;
        ensureCapacityHelper(elementCount +
                               1);
        elementData[elementCount++] =
          obj;
    }
    
    public synchronized boolean removeElement(Object obj) {
        modCount++;
        int i =
          indexOf(obj);
        if (i >=
              0) {
            removeElementAt(i);
            return true;
        }
        return false;
    }
    
    public synchronized void removeAllElements() {
        modCount++;
        for (int i =
               0;
             i <
               elementCount;
             i++)
            elementData[i] =
              null;
        elementCount =
          0;
    }
    
    public synchronized Object clone() {
        try {
            Vector<E> v =
              (Vector<E>)
                super.clone();
            v.elementData =
              (E[])
                (new Object[elementCount]);
            System.arraycopy(elementData,
                             0,
                             v.elementData,
                             0,
                             elementCount);
            v.modCount =
              0;
            return v;
        }
        catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }
    
    public synchronized Object[] toArray() {
        Object[] result =
          new Object[elementCount];
        System.arraycopy(elementData,
                         0,
                         result,
                         0,
                         elementCount);
        return result;
    }
    
    public synchronized <T> T[] toArray(T[] a) {
        if (a.length <
              elementCount)
            a =
              (T[])
                java.lang.reflect.Array.newInstance(a.getClass().getComponentType(),
                                                    elementCount);
        System.arraycopy(elementData,
                         0,
                         a,
                         0,
                         elementCount);
        if (a.length >
              elementCount)
            a[elementCount] =
              null;
        return a;
    }
    
    public synchronized E get(int index) {
        if (index >=
              elementCount)
            throw new ArrayIndexOutOfBoundsException(index);
        return (E)
                 elementData[index];
    }
    
    public synchronized E get_spec(int index) {
        return elementData[index];
    }
    
    public synchronized E set(int index,
                              E element) {
        if (index >=
              elementCount)
            throw new ArrayIndexOutOfBoundsException(index);
        Object oldValue =
          elementData[index];
        elementData[index] =
          element;
        return (E)
                 oldValue;
    }
    
    public synchronized boolean add(E o) {
        modCount++;
        ensureCapacityHelper(elementCount +
                               1);
        elementData[elementCount++] =
          o;
        return true;
    }
    
    public boolean remove(Object o) {
        return removeElement(o);
    }
    
    public void add(int index,
                    E element) {
        insertElementAt(element,
                        index);
    }
    
    public synchronized E remove(int index) {
        modCount++;
        if (index >=
              elementCount)
            throw new ArrayIndexOutOfBoundsException(index);
        Object oldValue =
          elementData[index];
        int numMoved =
          elementCount -
            index -
          1;
        if (numMoved >
              0)
            System.arraycopy(elementData,
                             index +
                               1,
                             elementData,
                             index,
                             numMoved);
        elementData[--elementCount] =
          null;
        return (E)
                 oldValue;
    }
    
    public void clear() {
        removeAllElements();
    }
    
    public synchronized boolean containsAll(Collection<?> c) {
        return super.containsAll(c);
    }
    
    public synchronized boolean addAll(Collection<? extends E> c) {
        modCount++;
        Object[] a =
          c.toArray();
        int numNew =
          a.length;
        ensureCapacityHelper(elementCount +
                               numNew);
        System.arraycopy(a,
                         0,
                         elementData,
                         elementCount,
                         numNew);
        elementCount +=
          numNew;
        return numNew !=
          0;
    }
    
    public synchronized boolean removeAll(Collection<?> c) {
        return super.removeAll(c);
    }
    
    public synchronized boolean retainAll(Collection<?> c) {
        return super.retainAll(c);
    }
    
    public synchronized boolean addAll(int index,
                                       Collection<? extends E> c) {
        modCount++;
        if (index <
              0 ||
              index >
                elementCount)
            throw new ArrayIndexOutOfBoundsException(index);
        Object[] a =
          c.toArray();
        int numNew =
          a.length;
        ensureCapacityHelper(elementCount +
                               numNew);
        int numMoved =
          elementCount -
          index;
        if (numMoved >
              0)
            System.arraycopy(elementData,
                             index,
                             elementData,
                             index +
                               numNew,
                             numMoved);
        System.arraycopy(a,
                         0,
                         elementData,
                         index,
                         numNew);
        elementCount +=
          numNew;
        return numNew !=
          0;
    }
    
    public synchronized boolean equals(Object o) {
        return super.equals(o);
    }
    
    public synchronized int hashCode() {
        return super.hashCode();
    }
    
    public synchronized String toString() {
        return super.toString();
    }
    
    public synchronized List<E> subList(int fromIndex,
                                        int toIndex) {
        return Collections.synchronizedList(super.subList(fromIndex,
                                                          toIndex),
                                            this);
    }
    
    protected synchronized void removeRange(int fromIndex,
                                            int toIndex) {
        modCount++;
        int numMoved =
          elementCount -
          toIndex;
        System.arraycopy(elementData,
                         toIndex,
                         elementData,
                         fromIndex,
                         numMoved);
        int newElementCount =
          elementCount -
          (toIndex -
             fromIndex);
        while (elementCount !=
                 newElementCount)
            elementData[--elementCount] =
              null;
    }
    
    private synchronized void writeObject(java.io.ObjectOutputStream s)
          throws java.io.IOException {
        s.defaultWriteObject();
    }
    
    public PBJInternSet<E> toPBJInternSet() {
        return toPBJInternSet_setComprehension_1();
    }
    
    public Vector<E> old;
    
    public boolean fallback_pbnj;
    
    Object fallback_field_result;
    
    public void fallback_field_result(Object r) {
        this.fallback_field_result =
          r;
    }
    
    public Vector(polyglot.ext.pbnj.tologic.LogExpr dontcare) {
        super();
        this.addInstance();
    }
    
    Object[] fallback_field_resultArray;
    
    public void fallback_field_resultArray(Object[] r) {
        this.fallback_field_resultArray =
          r;
    }
    
    public boolean fallback_checkInvariants() {
        return toPBJInternSet().size() ==
          size();
    }
    
    public void addInstance() {
        polyglot.ext.pbnj.tologic.LogMap.addInstance(Vector.class,
                                                     this);
    }
    
    public void addInstanceForProblem(Vector toAdd,
                                      polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                      String fallback_targetTypeArgsStr) {
        fallback_problem.addToClassInstances(toAdd,
                                             Vector.class,
                                             "pbnj.util.Vector",
                                             fallback_targetTypeArgsStr);
    }
    
    long startMethodTime;
    
    boolean isOld;
    
    Object fallback_consistencyLock;
    
    int fallback_updateTime;
    
    public Vector<E> old() {
        return this.old;
    }
    
    String[] fallback_typeArgs;
    
    public Vector<E> fallback_setTypeArgs(String[] args) {
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
        return Vector.classRelationizerStep ==
          fallback_problem.relationizerStep();
    }
    
    public static int classAtomizerStep =
      0;
    
    public static boolean isClassAtomized(polyglot.ext.pbnj.tologic.LogProblem fallback_problem) {
        return Vector.classAtomizerStep ==
          fallback_problem.relationizerStep();
    }
    
    public static int classClonerStep =
      0;
    
    public static boolean isClassCloned() {
        return Vector.classClonerStep ==
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
            Vector.fallback_classAtomize(fallback_problem,
                                         fallback_targetTypeArgsStr,
                                         fallback_targetTypeArgs);
            this.addInstanceForProblem(this.old,
                                       fallback_problem,
                                       fallback_targetTypeArgsStr);
            if (this.elementData !=
                  null)
                for (int i0_elementData =
                       0;
                     i0_elementData <
                       this.elementData.length;
                     i0_elementData++)
                    if (this.elementData[i0_elementData] !=
                          null &&
                          this.elementData[i0_elementData] instanceof polyglot.ext.pbnj.primitives.PBJInternObject)
                        ((polyglot.ext.pbnj.primitives.PBJInternObject)
                           this.elementData[i0_elementData]).fallback_atomize(fallback_problem,
                                                                              "",
                                                                              null);
        }
    }
    
    public void fallback_relationizeOld(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                        String fallback_targetTypeArgsStr,
                                        String[] fallback_targetTypeArgs) {
        if (!isRelationized(fallback_problem)) {
            this.relationizerStep =
              fallback_problem.relationizerStep();
            Vector.fallback_classRelationizeOld(fallback_problem,
                                                fallback_targetTypeArgsStr,
                                                fallback_targetTypeArgs);
            if (this.elementData !=
                  null)
                for (int i0_elementData =
                       0;
                     i0_elementData <
                       this.elementData.length;
                     i0_elementData++)
                    if (this.elementData[i0_elementData] !=
                          null &&
                          this.elementData[i0_elementData] instanceof polyglot.ext.pbnj.primitives.PBJInternObject)
                        ((polyglot.ext.pbnj.primitives.PBJInternObject)
                           this.elementData[i0_elementData]).fallback_relationizeOld(fallback_problem,
                                                                                     "",
                                                                                     null);
            for (E e : this)
                if (e !=
                      null &&
                      e instanceof polyglot.ext.pbnj.primitives.PBJInternObject)
                    ((polyglot.ext.pbnj.primitives.PBJInternObject)
                       e).fallback_relationizeOld(fallback_problem,
                                                  fallback_targetTypeArgs[polyglot.ext.pbnj.tologic.LogMap.getTypeVariableIndex(Vector.class,
                                                                                                                                "E")],
                                                  null);
            Vector.elementData_old_get_log(fallback_problem,
                                           fallback_targetTypeArgsStr,
                                           fallback_targetTypeArgs).array_put_log(fallback_problem,
                                                                                  this,
                                                                                  this.elementData);
            Vector.elementCount_old_get_log(fallback_problem,
                                            fallback_targetTypeArgsStr,
                                            fallback_targetTypeArgs).put_log(fallback_problem,
                                                                             this,
                                                                             this.elementCount);
        }
    }
    
    public static void fallback_classAtomize(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                             String fallback_targetTypeArgsStr,
                                             String[] fallback_targetTypeArgs) {
        if (!isClassAtomized(fallback_problem)) {
            Vector.classAtomizerStep =
              fallback_problem.relationizerStep();
        }
    }
    
    public static void fallback_classRelationizeOld(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                    String fallback_targetTypeArgsStr,
                                                    String[] fallback_targetTypeArgs) {
        if (!isClassRelationized(fallback_problem)) {
            Vector.classRelationizerStep =
              fallback_problem.relationizerStep();
        }
    }
    
    public static void fallback_classClone() {
        if (isClassCloned())
            return;
    }
    
    public Vector<E> fallback_clone() {
        if (isCloned())
            return old;
        Vector<E> res =
          null;
        Vector.fallback_classClone();
        try {
            res =
              (Vector<E>)
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
            if (this.elementData !=
                  null) {
                res.elementData =
                  (E[])
                    this.elementData.clone();
                for (int i0_elementData =
                       0;
                     i0_elementData <
                       this.elementData.length;
                     i0_elementData++)
                    if (this.elementData[i0_elementData] !=
                          null &&
                          this.elementData[i0_elementData] instanceof polyglot.ext.pbnj.primitives.PBJInternObject) {
                        res.elementData[i0_elementData] =
                          (E)
                            ((polyglot.ext.pbnj.primitives.PBJInternObject)
                               this.elementData[i0_elementData]).fallback_clone();
                    }
            }
            res.elementCount =
              this.elementCount;
        }
        catch (Exception rte) {
            rte.printStackTrace();
            System.exit(1);
        }
        return res;
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr elementData_get_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                        polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                        String fallback_targetTypeArgsStr,
                                                                        String[] fallback_targetTypeArgs,
                                                                        boolean isOld) {
        return polyglot.ext.pbnj.tologic.LogMap.fieldGet_log(fallback_problem,
                                                             fallback_target,
                                                             "pbnj.util.Vector",
                                                             fallback_targetTypeArgsStr,
                                                             "elementData",
                                                             isOld);
    }
    
    public static polyglot.ext.pbnj.tologic.LogRelation elementData_old_get_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                                String fallback_targetTypeArgsStr,
                                                                                String[] fallback_targetTypeArgs) {
        return polyglot.ext.pbnj.tologic.LogMap.oldFieldGet_log(fallback_problem,
                                                                "pbnj.util.Vector",
                                                                fallback_targetTypeArgsStr,
                                                                "elementData");
    }
    
    public E fallback_updateArrayField_elementData(int index,
                                                   E newVal) {
        this.elementData[index] =
          newVal;
        return newVal;
    }
    
    public E[] fallback_updateField_elementData(java.util.ArrayList<E> newVal) {
        int i =
          0;
        int s =
          newVal.size();
        if (this.elementData ==
              null ||
              this.elementData.length !=
                s)
            this.elementData =
              (E[])
                (new Object[s]);
        while (i <
                 s) {
            this.elementData[i] =
              newVal.get(i);
            i++;
        }
        return this.elementData;
    }
    
    public E[] fallback_updateField_elementData(E[] newVal) {
        return this.elementData =
          newVal;
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr elementCount_get_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                         polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                         String fallback_targetTypeArgsStr,
                                                                         String[] fallback_targetTypeArgs,
                                                                         boolean isOld) {
        return polyglot.ext.pbnj.tologic.LogMap.fieldGet_log(fallback_problem,
                                                             fallback_target,
                                                             "pbnj.util.Vector",
                                                             fallback_targetTypeArgsStr,
                                                             "elementCount",
                                                             isOld);
    }
    
    public static polyglot.ext.pbnj.tologic.LogRelation elementCount_old_get_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                                 String fallback_targetTypeArgsStr,
                                                                                 String[] fallback_targetTypeArgs) {
        return polyglot.ext.pbnj.tologic.LogMap.oldFieldGet_log(fallback_problem,
                                                                "pbnj.util.Vector",
                                                                fallback_targetTypeArgsStr,
                                                                "elementCount");
    }
    
    public int fallback_updateField_elementCount(Integer newVal) {
        return this.elementCount =
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
    
    public PBJInternSet<E> toPBJInternSet_setComprehension_1() {
        PBJInternSet<E> res =
          new PBJInternSet<E>();
        for (E e : this.elementData) {
            if (toPBJInternSet_existQuantify_0(e))
                res.add(e);
        }
        return res;
    }
    
    public boolean toPBJInternSet_existQuantify_0(E e) {
        for (int i : polyglot.ext.pbnj.primitives.PBJInternInteger.range(0,
                                                                         this.size() -
                                                                           1)) {
            if (this.elementData[i] ==
                  e)
                return true;
        }
        return false;
    }
    
    public static PBJInternSet<Integer> setMap_elementCount(PBJInternSet<Vector> objs,
                                                            java.lang.String ... fieldNs) {
        PBJInternSet<Integer> res =
          new PBJInternSet<Integer>();
        java.util.Iterator<Vector> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().elementCount);
        }
        return res;
    }
    
    public static void fallback_initClassDefs() {
        
    }
    
    static {
               polyglot.ext.pbnj.tologic.LogMap.newClassForLog(Vector.class,
                                                               true,
                                                               "E");
               polyglot.ext.pbnj.tologic.LogMap.newGenericInstVarRel("elementData",
                                                                     Vector.class,
                                                                     "pbnj.util.Vector",
                                                                     Object.class,
                                                                     "E",
                                                                     null,
                                                                     null,
                                                                     true,
                                                                     false,
                                                                     1,
                                                                     true,
                                                                     false,
                                                                     false,
                                                                     false,
                                                                     false);
               polyglot.ext.pbnj.tologic.LogMap.newGenericInstVarRel("elementCount",
                                                                     Vector.class,
                                                                     "pbnj.util.Vector",
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
    
    public static synchronized polyglot.ext.pbnj.tologic.LogExpr size_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                          polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                          String fallback_targetTypeArgsStr,
                                                                          String[] fallback_targetTypeArgs,
                                                                          boolean fallback_target_isOld) {
        return Vector.elementCount_get_log(fallback_problem,
                                           fallback_target,
                                           fallback_targetTypeArgsStr,
                                           fallback_targetTypeArgs,
                                           fallback_target_isOld);
    }
    
    public static synchronized polyglot.ext.pbnj.tologic.LogExpr get_spec_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                              polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                              String fallback_targetTypeArgsStr,
                                                                              String[] fallback_targetTypeArgs,
                                                                              boolean fallback_target_isOld,
                                                                              polyglot.ext.pbnj.tologic.LogExpr index,
                                                                              boolean index_isOld) {
        return Vector.elementData_get_log(fallback_problem,
                                          fallback_target,
                                          fallback_targetTypeArgsStr,
                                          fallback_targetTypeArgs,
                                          fallback_target_isOld).get_log(fallback_problem,
                                                                         index,
                                                                         false);
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr toPBJInternSet_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                       polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                       String fallback_targetTypeArgsStr,
                                                                       String[] fallback_targetTypeArgs,
                                                                       boolean fallback_target_isOld) {
        boolean e_isOld =
          false;
        polyglot.ext.pbnj.tologic.LogExpr e =
          new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                kodkod.ast.Variable.unary("e"));
        boolean i_isOld =
          false;
        polyglot.ext.pbnj.tologic.LogExpr quantVar_i =
          new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                kodkod.ast.Variable.unary("i"));
        polyglot.ext.pbnj.tologic.LogExpr i =
          new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                quantVar_i.expr());
        polyglot.ext.pbnj.tologic.LogExpr fallback_var_i =
          quantVar_i;
        return polyglot.ext.pbnj.tologic.LogExpr.setComprehensionOp(Vector.elementData_get_log(fallback_problem,
                                                                                               fallback_target,
                                                                                               fallback_targetTypeArgsStr,
                                                                                               fallback_targetTypeArgs,
                                                                                               fallback_target_isOld),
                                                                    e,
                                                                    polyglot.ext.pbnj.tologic.LogExpr.quantifyOp(PBJInternSet.toPBJInternSet_log(fallback_problem,
                                                                                                                                                 polyglot.ext.pbnj.primitives.PBJInternInteger.range_log(fallback_problem,
                                                                                                                                                                                                         fallback_problem.class_log(polyglot.ext.pbnj.primitives.PBJInternInteger.class),
                                                                                                                                                                                                         "",
                                                                                                                                                                                                         null,
                                                                                                                                                                                                         fallback_target_isOld,
                                                                                                                                                                                                         new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                                                                                                                                                                                                               kodkod.ast.IntConstant.constant(0)),
                                                                                                                                                                                                         fallback_target_isOld,
                                                                                                                                                                                                         Vector.size_log(fallback_problem,
                                                                                                                                                                                                                         fallback_target,
                                                                                                                                                                                                                         fallback_targetTypeArgsStr,
                                                                                                                                                                                                                         fallback_targetTypeArgs,
                                                                                                                                                                                                                         fallback_target_isOld).minus(new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                            kodkod.ast.IntConstant.constant(1))),
                                                                                                                                                                                                         fallback_target_isOld),
                                                                                                                                                 "<java.lang.Integer>",
                                                                                                                                                 new String[] { "java.lang.Integer" },
                                                                                                                                                 fallback_target_isOld),
                                                                                                                 false,
                                                                                                                 "some",
                                                                                                                 fallback_var_i,
                                                                                                                 Vector.elementData_get_log(fallback_problem,
                                                                                                                                            fallback_target,
                                                                                                                                            fallback_targetTypeArgsStr,
                                                                                                                                            fallback_targetTypeArgs,
                                                                                                                                            fallback_target_isOld).get_log(fallback_problem,
                                                                                                                                                                           i,
                                                                                                                                                                           false).eq(e)));
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr fallback_checkInvariants_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                                 polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                                 String fallback_targetTypeArgsStr,
                                                                                 String[] fallback_targetTypeArgs,
                                                                                 boolean fallback_target_isOld) {
        return Vector.toPBJInternSet_log(fallback_problem,
                                         fallback_target,
                                         fallback_targetTypeArgsStr,
                                         fallback_targetTypeArgs,
                                         fallback_target_isOld).size_log(fallback_problem).eq(Vector.size_log(fallback_problem,
                                                                                                              fallback_target,
                                                                                                              fallback_targetTypeArgsStr,
                                                                                                              fallback_targetTypeArgs,
                                                                                                              fallback_target_isOld));
    }
}
