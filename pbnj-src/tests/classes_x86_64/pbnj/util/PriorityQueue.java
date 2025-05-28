package pbnj.util;

import polyglot.ext.pbnj.primitives.PBJInternSet;

public class PriorityQueue<E>  extends AbstractQueue<E> implements java.io.Serializable, polyglot.ext.pbnj.primitives.PBJInternObject {
    private static final long serialVersionUID =
      -7720805057305804111L;
    
    private static final int DEFAULT_INITIAL_CAPACITY =
      11;
    
    transient Object[] queue;
    
    int size =
      0;
    
    private Comparator<? super E> comparator;
    
    private transient int modCount =
      0;
    
    public PriorityQueue() {
        this(DEFAULT_INITIAL_CAPACITY,
             null);
    }
    
    public PriorityQueue(int initialCapacity) {
        this(initialCapacity,
             null);
    }
    
    public PriorityQueue(int initialCapacity,
                         Comparator<? super E> comparator) {
        super();
        if (initialCapacity <
              1)
            throw new IllegalArgumentException();
        this.queue =
          (new Object[initialCapacity +
                        1]);
        this.comparator =
          comparator;
    }
    
    public Object[] getQueue() {
        return this.queue;
    }
    
    private void initializeArray(Collection<? extends E> c) {
        int sz =
          c.size();
        int initialCapacity =
          (int)
            Math.min(sz *
                       110L /
                       100,
                     Integer.MAX_VALUE -
                       1);
        if (initialCapacity <
              1)
            initialCapacity =
              1;
        this.queue =
          (new Object[initialCapacity +
                        1]);
    }
    
    private void fillFromSorted(Collection<? extends E> c) {
        for (Iterator<? extends E> i =
               c.iterator();
             i.hasNext();
             )
            queue[++size] =
              i.next();
    }
    
    private void fillFromUnsorted(Collection<? extends E> c) {
        for (Iterator<? extends E> i =
               c.iterator();
             i.hasNext();
             )
            queue[++size] =
              i.next();
        heapify();
    }
    
    public PriorityQueue(Collection<? extends E> c) {
        super();
        initializeArray(c);
        if (c instanceof SortedSet) {
            SortedSet<? extends E> s =
              (SortedSet<? extends E>)
                c;
            comparator =
              (Comparator<? super E>)
                s.comparator();
            fillFromSorted(s);
        } else
            if (c instanceof PriorityQueue) {
                PriorityQueue<? extends E> s =
                  (PriorityQueue<? extends E>)
                    c;
                comparator =
                  (Comparator<? super E>)
                    s.comparator();
                fillFromSorted(s);
            } else {
                comparator =
                  null;
                fillFromUnsorted(c);
            }
    }
    
    public PriorityQueue(PriorityQueue<? extends E> c) {
        super();
        initializeArray(c);
        comparator =
          (Comparator<? super E>)
            c.comparator();
        fillFromSorted(c);
    }
    
    public PriorityQueue(SortedSet<? extends E> c) {
        super();
        initializeArray(c);
        comparator =
          (Comparator<? super E>)
            c.comparator();
        fillFromSorted(c);
    }
    
    private void grow(int index) {
        int newlen =
          queue.length;
        if (index <
              newlen)
            return;
        if (index ==
              Integer.MAX_VALUE)
            throw new OutOfMemoryError();
        while (newlen <=
                 index) {
            if (newlen >=
                  Integer.MAX_VALUE /
                    2)
                newlen =
                  Integer.MAX_VALUE;
            else
                newlen <<=
                  2;
        }
        Object[] newQueue =
          new Object[newlen];
        System.arraycopy(queue,
                         0,
                         newQueue,
                         0,
                         queue.length);
        queue =
          newQueue;
    }
    
    public boolean offer(E o) {
        if (o ==
              null)
            throw new NullPointerException();
        modCount++;
        ++size;
        if (size >=
              queue.length)
            grow(size);
        queue[size] =
          o;
        fixUp(size);
        return true;
    }
    
    public E peek() {
        if (size ==
              0)
            return null;
        return (E)
                 queue[1];
    }
    
    public boolean add(E o) {
        return offer(o);
    }
    
    public boolean remove(Object o) {
        if (o ==
              null)
            return false;
        if (comparator ==
              null) {
            for (int i =
                   1;
                 i <=
                   size;
                 i++) {
                if (((Comparable<E>)
                       queue[i]).compareTo((E)
                                             o) ==
                      0) {
                    removeAt(i);
                    return true;
                }
            }
        } else {
            for (int i =
                   1;
                 i <=
                   size;
                 i++) {
                if (comparator.compare((E)
                                         queue[i],
                                       (E)
                                         o) ==
                      0) {
                    removeAt(i);
                    return true;
                }
            }
        }
        return false;
    }
    
    public Iterator<E> iterator() {
        return new Itr();
    }
    
    private class Itr implements Iterator<E>, polyglot.ext.pbnj.primitives.PBJInternObject {
        private int cursor =
          1;
        
        private int lastRet =
          0;
        
        private int expectedModCount =
          modCount;
        
        private ArrayList<E> forgetMeNot =
          null;
        
        private Object lastRetElt =
          null;
        
        public boolean hasNext() {
            return cursor <=
                     size ||
              forgetMeNot !=
                null;
        }
        
        public E next() {
            checkForComodification();
            E result;
            if (cursor <=
                  size) {
                result =
                  (E)
                    queue[cursor];
                lastRet =
                  cursor++;
            } else
                if (forgetMeNot ==
                      null)
                    throw new NoSuchElementException();
                else {
                    int remaining =
                      forgetMeNot.size();
                    result =
                      forgetMeNot.remove(remaining -
                                           1);
                    if (remaining ==
                          1)
                        forgetMeNot =
                          null;
                    lastRet =
                      0;
                    lastRetElt =
                      result;
                }
            return result;
        }
        
        public void remove() {
            checkForComodification();
            if (lastRet !=
                  0) {
                E moved =
                  outerRemoveAt(lastRet);
                lastRet =
                  0;
                if (moved ==
                      null) {
                    cursor--;
                } else {
                    if (forgetMeNot ==
                          null)
                        forgetMeNot =
                          new ArrayList<E>();
                    forgetMeNot.add(moved);
                }
            } else
                if (lastRetElt !=
                      null) {
                    outerRemove(lastRetElt);
                    lastRetElt =
                      null;
                } else {
                    throw new IllegalStateException();
                }
            expectedModCount =
              modCount;
        }
        
        private E outerRemoveAt(int i) {
            assert i >
                     0 &&
              i <=
                size;
            modCount++;
            E moved =
              (E)
                queue[size];
            queue[i] =
              moved;
            queue[size--] =
              null;
            if (i <=
                  size) {
                fixDown(i);
                if (queue[i] ==
                      moved) {
                    fixUp(i);
                    if (queue[i] !=
                          moved)
                        return moved;
                }
            }
            return null;
        }
        
        public boolean outerRemove(Object o) {
            if (o ==
                  null)
                return false;
            if (comparator ==
                  null) {
                for (int i =
                       1;
                     i <=
                       size;
                     i++) {
                    if (((Comparable<E>)
                           queue[i]).compareTo((E)
                                                 o) ==
                          0) {
                        removeAt(i);
                        return true;
                    }
                }
            } else {
                for (int i =
                       1;
                     i <=
                       size;
                     i++) {
                    if (comparator.compare((E)
                                             queue[i],
                                           (E)
                                             o) ==
                          0) {
                        removeAt(i);
                        return true;
                    }
                }
            }
            return false;
        }
        
        final void checkForComodification() {
            if (modCount !=
                  expectedModCount)
                throw new ConcurrentModificationException();
        }
        
        public Itr old;
        
        Object result;
        
        public void result(Object r) {
            this.result =
              r;
        }
        
        public Itr() {
            super();
            this.addInstance();
        }
        
        public Itr(polyglot.ext.pbnj.tologic.LogExpr dontcare) {
            super();
        }
        
        Object[] resultArray;
        
        public void resultArray(Object[] r) {
            this.resultArray =
              r;
        }
        
        public void addInstance() {
            polyglot.ext.pbnj.tologic.LogMap.addInstance(Itr.class,
                                                         this);
        }
        
        public void addInstanceForProblem(Itr toAdd,
                                          polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                          String fallback_targetType) {
            fallback_problem.addToClassInstances(toAdd,
                                                 Itr.class,
                                                 fallback_targetType);
        }
        
        long startMethodTime;
        
        boolean isOld;
        
        Object fallback_consistencyLock;
        
        int fallback_updateTime;
        
        public Itr old() {
            return this.old;
        }
        
        String[] fallback_typeArgs;
        
        public Itr fallback_setTypeArgs(String[] args) {
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
                                     String fallback_targetType,
                                     String[] fallback_targetTypeArgs) {
            if (!isAtomized(fallback_problem)) {
                this.atomizerStep =
                  fallback_problem.relationizerStep();
                this.addInstanceForProblem(this.old,
                                           fallback_problem,
                                           fallback_targetType);
            }
        }
        
        public void fallback_relationizeOld(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                            String fallback_targetType,
                                            String[] fallback_targetTypeArgs) {
            if (!isRelationized(fallback_problem)) {
                this.relationizerStep =
                  fallback_problem.relationizerStep();
            }
        }
        
        public Itr fallback_clone() {
            if (isCloned())
                return old;
            this.clonerStep =
              polyglot.ext.pbnj.tologic.LogMap.clonerStep();
            Itr res =
              null;
            try {
                res =
                  (Itr)
                    super.clone();
                res.isOld =
                  true;
                this.old =
                  res;
                res.old =
                  this;
                this.fallback_consistencyLock =
                  new Object();
            }
            catch (Exception rte) {
                rte.printStackTrace();
                System.exit(1);
            }
            return res;
        }
    }
    
    
    public int size() {
        return size;
    }
    
    public void clear() {
        modCount++;
        for (int i =
               1;
             i <=
               size;
             i++)
            queue[i] =
              null;
        size =
          0;
    }
    
    public E poll() {
        if (size ==
              0)
            return null;
        modCount++;
        E result =
          (E)
            queue[1];
        queue[1] =
          queue[size];
        queue[size--] =
          null;
        if (size >
              1)
            fixDown(1);
        return result;
    }
    
    private E removeAt(int i) {
        assert i >
                 0 &&
          i <=
            size;
        modCount++;
        E moved =
          (E)
            queue[size];
        queue[i] =
          moved;
        queue[size--] =
          null;
        if (i <=
              size) {
            fixDown(i);
            if (queue[i] ==
                  moved) {
                fixUp(i);
                if (queue[i] !=
                      moved)
                    return moved;
            }
        }
        return null;
    }
    
    private void fixUp(int k) {
        if (comparator ==
              null) {
            while (k >
                     1) {
                int j =
                  k >>
                  1;
                if (((Comparable<E>)
                       queue[j]).compareTo((E)
                                             queue[k]) <=
                      0)
                    break;
                Object tmp =
                  queue[j];
                queue[j] =
                  queue[k];
                queue[k] =
                  tmp;
                k =
                  j;
            }
        } else {
            while (k >
                     1) {
                int j =
                  k >>>
                  1;
                if (comparator.compare((E)
                                         queue[j],
                                       (E)
                                         queue[k]) <=
                      0)
                    break;
                Object tmp =
                  queue[j];
                queue[j] =
                  queue[k];
                queue[k] =
                  tmp;
                k =
                  j;
            }
        }
    }
    
    private void fixDown(int k) {
        int j;
        if (comparator ==
              null) {
            while ((j =
                      k <<
                        1) <=
                     size &&
                     j >
                       0) {
                if (j <
                      size &&
                      ((Comparable<E>)
                         queue[j]).compareTo((E)
                                               queue[j +
                                                       1]) >
                        0)
                    j++;
                if (((Comparable<E>)
                       queue[k]).compareTo((E)
                                             queue[j]) <=
                      0)
                    break;
                Object tmp =
                  queue[j];
                queue[j] =
                  queue[k];
                queue[k] =
                  tmp;
                k =
                  j;
            }
        } else {
            while ((j =
                      k <<
                        1) <=
                     size &&
                     j >
                       0) {
                if (j <
                      size &&
                      comparator.compare((E)
                                           queue[j],
                                         (E)
                                           queue[j +
                                                   1]) >
                        0)
                    j++;
                if (comparator.compare((E)
                                         queue[k],
                                       (E)
                                         queue[j]) <=
                      0)
                    break;
                Object tmp =
                  queue[j];
                queue[j] =
                  queue[k];
                queue[k] =
                  tmp;
                k =
                  j;
            }
        }
    }
    
    private void heapify() {
        for (int i =
               size /
               2;
             i >=
               1;
             i--)
            fixDown(i);
    }
    
    public Comparator<? super E> comparator() {
        return comparator;
    }
    
    private void writeObject(java.io.ObjectOutputStream s)
          throws java.io.IOException {
        s.defaultWriteObject();
        s.writeInt(queue.length);
        for (int i =
               1;
             i <=
               size;
             i++)
            s.writeObject(queue[i]);
    }
    
    private void readObject(java.io.ObjectInputStream s)
          throws java.io.IOException,
        ClassNotFoundException {
        s.defaultReadObject();
        int arrayLength =
          s.readInt();
        queue =
          (new Object[arrayLength]);
        for (int i =
               1;
             i <=
               size;
             i++)
            queue[i] =
              (E)
                s.readObject();
    }
    
    public PriorityQueue<E> old;
    
    Object result;
    
    public void result(Object r) {
        this.result =
          r;
    }
    
    public PriorityQueue(polyglot.ext.pbnj.tologic.LogExpr dontcare) {
        super();
    }
    
    Object[] resultArray;
    
    public void resultArray(Object[] r) {
        this.resultArray =
          r;
    }
    
    public boolean checkInvariants() {
        return true;
    }
    
    public void addInstance() {
        polyglot.ext.pbnj.tologic.LogMap.addInstance(PriorityQueue.class,
                                                     this);
    }
    
    public void addInstanceForProblem(PriorityQueue toAdd,
                                      polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                      String fallback_targetType) {
        fallback_problem.addToClassInstances(toAdd,
                                             PriorityQueue.class,
                                             fallback_targetType);
    }
    
    long startMethodTime;
    
    boolean isOld;
    
    Object fallback_consistencyLock;
    
    int fallback_updateTime;
    
    public PriorityQueue<E> old() {
        return this.old;
    }
    
    String[] fallback_typeArgs;
    
    public PriorityQueue<E> fallback_setTypeArgs(String[] args) {
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
                                 String fallback_targetType,
                                 String[] fallback_targetTypeArgs) {
        if (!isAtomized(fallback_problem)) {
            this.atomizerStep =
              fallback_problem.relationizerStep();
            this.addInstanceForProblem(this.old,
                                       fallback_problem,
                                       fallback_targetType);
            if (this.queue !=
                  null)
                for (int i_queue =
                       0;
                     i_queue <
                       this.queue.length;
                     i_queue++)
                    if (this.queue[i_queue] !=
                          null)
                        ((polyglot.ext.pbnj.primitives.PBJInternObject)
                           this.queue[i_queue]).fallback_atomize(fallback_problem,
                                                                 "java.lang.Object",
                                                                 null);
        }
    }
    
    public void fallback_relationizeOld(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                        String fallback_targetType,
                                        String[] fallback_targetTypeArgs) {
        if (!isRelationized(fallback_problem)) {
            this.relationizerStep =
              fallback_problem.relationizerStep();
            if (this.queue !=
                  null)
                for (int i_queue =
                       0;
                     i_queue <
                       this.queue.length;
                     i_queue++)
                    if (this.queue[i_queue] !=
                          null)
                        ((polyglot.ext.pbnj.primitives.PBJInternObject)
                           this.queue[i_queue]).fallback_relationizeOld(fallback_problem,
                                                                        "java.lang.Object",
                                                                        null);
            for (E e : this)
                if (e !=
                      null &&
                      e instanceof polyglot.ext.pbnj.primitives.PBJInternObject)
                    ((polyglot.ext.pbnj.primitives.PBJInternObject)
                       e).fallback_relationizeOld(fallback_problem,
                                                  fallback_targetTypeArgs[polyglot.ext.pbnj.tologic.LogMap.getTypeVariableIndex(PriorityQueue.class,
                                                                                                                                "E")],
                                                  null);
            polyglot.ext.pbnj.tologic.LogMap.instVarRelOld_log0(fallback_targetType,
                                                                "queue").array_put_log(fallback_problem,
                                                                                       this,
                                                                                       this.queue);
            polyglot.ext.pbnj.tologic.LogMap.instVarRelOld_log0(fallback_targetType,
                                                                "size").put_log(fallback_problem,
                                                                                this,
                                                                                this.size);
        }
    }
    
    public PriorityQueue<E> fallback_clone() {
        if (isCloned())
            return old;
        this.clonerStep =
          polyglot.ext.pbnj.tologic.LogMap.clonerStep();
        PriorityQueue<E> res =
          null;
        try {
            res =
              (PriorityQueue<E>)
                super.clone();
            res.isOld =
              true;
            this.old =
              res;
            res.old =
              this;
            this.fallback_consistencyLock =
              new Object();
            if (this.queue !=
                  null) {
                res.queue =
                  (Object[])
                    this.queue.clone();
                for (int i_queue =
                       0;
                     i_queue <
                       this.queue.length;
                     i_queue++)
                    if (this.queue[i_queue] !=
                          null)
                        res.queue[i_queue] =
                          (Object)
                            ((polyglot.ext.pbnj.primitives.PBJInternObject)
                               this.queue[i_queue]).fallback_clone();
            }
            res.size =
              this.size;
        }
        catch (Exception rte) {
            rte.printStackTrace();
            System.exit(1);
        }
        return res;
    }
    
    public Object fallback_updateArrayField_queue(int index,
                                                  Object newVal) {
        this.queue[index] =
          newVal;
        return newVal;
    }
    
    public Object[] fallback_updateField_queue(java.util.ArrayList<Object> newVal) {
        int i =
          0;
        int s =
          newVal.size();
        if (this.queue ==
              null ||
              this.queue.length <
                s)
            this.queue =
              (new Object[s]);
        while (i <
                 s) {
            this.queue[i] =
              newVal.get(i);
            i++;
        }
        return this.queue;
    }
    
    public Object[] fallback_updateField_queue(Object[] newVal) {
        return this.queue =
          newVal;
    }
    
    public int fallback_updateField_size(Integer newVal) {
        return this.size =
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
    
    public static polyglot.ext.pbnj.tologic.LogExpr queue_get_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                  polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                  String fallback_targetType,
                                                                  String[] fallback_targetTypeArgs,
                                                                  boolean isOld) {
        return polyglot.ext.pbnj.tologic.LogMap.fieldGet_log(fallback_problem,
                                                             fallback_target,
                                                             "queue",
                                                             fallback_targetType,
                                                             fallback_targetTypeArgs,
                                                             isOld);
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr size_get_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                 polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                 String fallback_targetType,
                                                                 String[] fallback_targetTypeArgs,
                                                                 boolean isOld) {
        return polyglot.ext.pbnj.tologic.LogMap.fieldGet_log(fallback_problem,
                                                             fallback_target,
                                                             "size",
                                                             fallback_targetType,
                                                             fallback_targetTypeArgs,
                                                             isOld);
    }
    
    public static PBJInternSet<Integer> setMap_size(PBJInternSet<PriorityQueue> objs,
                                                    java.lang.String ... fieldNs) {
        PBJInternSet<Integer> res =
          new PBJInternSet<Integer>();
        java.util.Iterator<PriorityQueue> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().size);
        }
        return res;
    }
    
    public static void fallback_initClassDefs() {
        
    }
    
    static {
               polyglot.ext.pbnj.tologic.LogMap.newClassForLog(PriorityQueue.class,
                                                               true,
                                                               "E");
               polyglot.ext.pbnj.tologic.LogMap.newGenericInstVarRel("queue",
                                                                     PriorityQueue.class,
                                                                     "pbnj.util.PriorityQueue<[E]>",
                                                                     Object.class,
                                                                     "java.lang.Object",
                                                                     null,
                                                                     false,
                                                                     false,
                                                                     true,
                                                                     true,
                                                                     false,
                                                                     false,
                                                                     false);
               polyglot.ext.pbnj.tologic.LogMap.newGenericInstVarRel("size",
                                                                     PriorityQueue.class,
                                                                     "pbnj.util.PriorityQueue<[E]>",
                                                                     Integer.class,
                                                                     "int",
                                                                     null,
                                                                     false,
                                                                     false,
                                                                     false,
                                                                     true,
                                                                     false,
                                                                     false,
                                                                     false);
               polyglot.ext.pbnj.tologic.LogMap.newClassForLogInnerClasses(PriorityQueue.class);
           }
    
    public static polyglot.ext.pbnj.tologic.LogExpr getQueue_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                 polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                 String fallback_targetType,
                                                                 String[] fallback_targetTypeArgs,
                                                                 boolean fallback_target_isOld) {
        return PriorityQueue.queue_get_log(fallback_problem,
                                           fallback_target,
                                           "pbnj.util.PriorityQueue<[E]>",
                                           null,
                                           fallback_target_isOld);
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr size_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                             polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                             String fallback_targetType,
                                                             String[] fallback_targetTypeArgs,
                                                             boolean fallback_target_isOld) {
        return PriorityQueue.size_get_log(fallback_problem,
                                          fallback_target,
                                          "pbnj.util.PriorityQueue<[E]>",
                                          null,
                                          fallback_target_isOld);
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr checkInvariants_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                        polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                        String fallback_targetType,
                                                                        String[] fallback_targetTypeArgs,
                                                                        boolean fallback_target_isOld) {
        return new polyglot.ext.pbnj.tologic.LogExpr(kodkod.ast.Formula.TRUE);
    }
}
