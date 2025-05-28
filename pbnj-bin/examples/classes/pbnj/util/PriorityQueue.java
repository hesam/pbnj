package pbnj.util;

import polyglot.ext.pbnj.primitives.PBJSet;

public class PriorityQueue<E>  extends AbstractQueue<E> implements java.io.Serializable, polyglot.ext.pbnj.primitives.PBJObject {
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
        polyglot.ext.pbnj.tologic.LogMap.addInstance(PriorityQueue.class,
                                                     this);
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
        polyglot.ext.pbnj.tologic.LogMap.addInstance(PriorityQueue.class,
                                                     this);
    }
    
    public PriorityQueue(PriorityQueue<? extends E> c) {
        super();
        initializeArray(c);
        comparator =
          (Comparator<? super E>)
            c.comparator();
        fillFromSorted(c);
        polyglot.ext.pbnj.tologic.LogMap.addInstance(PriorityQueue.class,
                                                     this);
    }
    
    public PriorityQueue(SortedSet<? extends E> c) {
        super();
        initializeArray(c);
        comparator =
          (Comparator<? super E>)
            c.comparator();
        fillFromSorted(c);
        polyglot.ext.pbnj.tologic.LogMap.addInstance(PriorityQueue.class,
                                                     this);
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
    
    private class Itr implements Iterator<E>, polyglot.ext.pbnj.primitives.PBJObject {
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
        
        Itr old;
        
        Object result;
        
        public void result(Object r) {
            this.result =
              r;
        }
        
        public Itr() {
            super();
            polyglot.ext.pbnj.tologic.LogMap.addInstance(Itr.class,
                                                         this);
        }
        
        public Itr(polyglot.ext.pbnj.tologic.LogObjSet dontcare) {
            super();
        }
        
        Object[] resultArray;
        
        public void resultArray(Object[] r) {
            this.resultArray =
              r;
        }
        
        long startMethodTime;
        
        public Itr old() {
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
              polyglot.ext.pbnj.tologic.LogMap.relationizerStep();
        }
        
        int relationizerStep =
          0;
        
        boolean isRelationized() {
            return this.relationizerStep ==
              polyglot.ext.pbnj.tologic.LogMap.relationizerStep();
        }
        
        int clonerStep =
          0;
        
        public boolean isCloned() {
            return this.clonerStep ==
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
                                           Object[] args) {
            try {
                return cons.newInstance(args);
            }
            catch (Exception rte) {
                rte.printStackTrace();
                return null;
            }
        }
        
        public void fallback_atomize() {
            if (!isAtomized()) {
                this.atomizerStep =
                  polyglot.ext.pbnj.tologic.LogMap.relationizerStep();
                polyglot.ext.pbnj.tologic.LogMap.addToClassInstances(this.old,
                                                                     Itr.class);
            }
        }
        
        public void fallback_relationizeOld() {
            if (!isRelationized()) {
                this.relationizerStep =
                  polyglot.ext.pbnj.tologic.LogMap.relationizerStep();
            }
        }
        
        public void fallback_relationize() {
            if (!old.isRelationized()) {
                old.relationizerStep =
                  polyglot.ext.pbnj.tologic.LogMap.relationizerStep();
            }
        }
        
        public Itr fallback_clone() {
            if (isCloned())
                return this.old;
            Itr res =
              null;
            try {
                this.clonerStep =
                  polyglot.ext.pbnj.tologic.LogMap.clonerStep();
                res =
                  (Itr)
                    super.clone();
                res.isOld =
                  true;
                this.old =
                  res;
                res.old =
                  this;
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
    
    public PBJSet<E> toPBJSet() {
        return toPBJSet_setComprehension_1();
    }
    
    PriorityQueue old;
    
    Object result;
    
    public void result(Object r) {
        this.result =
          r;
    }
    
    public PriorityQueue(polyglot.ext.pbnj.tologic.LogObjSet dontcare) {
        super();
    }
    
    Object[] resultArray;
    
    public void resultArray(Object[] r) {
        this.resultArray =
          r;
    }
    
    public boolean verifyInvariants() {
        return toPBJSet().size() ==
          this.size;
    }
    
    long startMethodTime;
    
    public PriorityQueue old() {
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
          polyglot.ext.pbnj.tologic.LogMap.relationizerStep();
    }
    
    int relationizerStep =
      0;
    
    boolean isRelationized() {
        return this.relationizerStep ==
          polyglot.ext.pbnj.tologic.LogMap.relationizerStep();
    }
    
    int clonerStep =
      0;
    
    public boolean isCloned() {
        return this.clonerStep ==
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
                                       Object[] args) {
        try {
            return cons.newInstance(args);
        }
        catch (Exception rte) {
            rte.printStackTrace();
            return null;
        }
    }
    
    public void fallback_atomize() {
        if (!isAtomized()) {
            this.atomizerStep =
              polyglot.ext.pbnj.tologic.LogMap.relationizerStep();
            polyglot.ext.pbnj.tologic.LogMap.addToClassInstances(this.old,
                                                                 PriorityQueue.class);
            if (this.queue !=
                  null)
                for (int i_queue =
                       0;
                     i_queue <
                       this.queue.length;
                     i_queue++)
                    if (this.queue[i_queue] !=
                          null)
                        ((polyglot.ext.pbnj.primitives.PBJObject)
                           this.queue[i_queue]).fallback_atomize();
        }
    }
    
    public void fallback_relationizeOld() {
        if (!isRelationized()) {
            this.relationizerStep =
              polyglot.ext.pbnj.tologic.LogMap.relationizerStep();
            if (this.queue !=
                  null)
                for (int i_queue =
                       0;
                     i_queue <
                       this.queue.length;
                     i_queue++)
                    if (this.queue[i_queue] !=
                          null)
                        ((polyglot.ext.pbnj.primitives.PBJObject)
                           this.queue[i_queue]).fallback_relationizeOld();
            for (E e : this)
                if (e !=
                      null)
                    ((polyglot.ext.pbnj.primitives.PBJObject)
                       e).fallback_relationizeOld();
            polyglot.ext.pbnj.tologic.LogMap.instVarRel_log0(this,
                                                             "queue_old").array_put_log(this,
                                                                                        this.queue);
            polyglot.ext.pbnj.tologic.LogMap.instVarRel_log0(this,
                                                             "size_old").put_log(this,
                                                                                 this.size);
        }
    }
    
    public void fallback_relationize() {
        if (!old.isRelationized()) {
            old.relationizerStep =
              polyglot.ext.pbnj.tologic.LogMap.relationizerStep();
            if (this.queue !=
                  null)
                for (int i_queue =
                       0;
                     i_queue <
                       this.queue.length;
                     i_queue++)
                    if (this.queue[i_queue] !=
                          null)
                        ((polyglot.ext.pbnj.primitives.PBJObject)
                           this.queue[i_queue]).fallback_relationize();
            for (E e : this)
                if (e !=
                      null)
                    ((polyglot.ext.pbnj.primitives.PBJObject)
                       e).fallback_relationize();
            polyglot.ext.pbnj.tologic.LogMap.instVarRel_log0(this,
                                                             "queue").array_put_log(old,
                                                                                    old.queue);
            polyglot.ext.pbnj.tologic.LogMap.instVarRel_log0(this,
                                                             "size").put_log(old,
                                                                             old.size);
        }
    }
    
    public PriorityQueue<E> fallback_clone() {
        if (isCloned())
            return this.old;
        PriorityQueue<E> res =
          null;
        try {
            this.clonerStep =
              polyglot.ext.pbnj.tologic.LogMap.clonerStep();
            res =
              (PriorityQueue<E>)
                super.clone();
            res.isOld =
              true;
            this.old =
              res;
            res.old =
              this;
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
                            ((polyglot.ext.pbnj.primitives.PBJObject)
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
    
    public void fallback_updateField_queue(java.util.ArrayList<Object> newVal) {
        int i =
          0;
        int s =
          newVal.size();
        if (this.queue ==
              null)
            this.queue =
              (new Object[s]);
        while (i <
                 s) {
            this.queue[i] =
              newVal.get(i);
            i++;
        }
    }
    
    public void fallback_updateField_size(Integer newVal) {
        this.size =
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
    
    public PBJSet<E> toPBJSet_setComprehension_1() {
        PBJSet<E> res =
          new PBJSet<E>();
        for (E e : (E[])
                     this.queue) {
            if (toPBJSet_existQuantify_0(e))
                res.add(e);
        }
        return res;
    }
    
    public boolean toPBJSet_existQuantify_0(E e) {
        for (int i : polyglot.ext.pbnj.primitives.PBJInteger.range(0,
                                                                   this.size() -
                                                                     1)) {
            if (this.queue[i] ==
                  e)
                return true;
        }
        return false;
    }
    
    static {
               polyglot.ext.pbnj.tologic.LogMap.newClassForLogInnerClasses(PriorityQueue.class);
           }
    
    public static polyglot.ext.pbnj.tologic.LogObjSet queue_get_log(kodkod.ast.Expression target,
                                                                    boolean isOld) {
        return polyglot.ext.pbnj.tologic.LogMap.fieldGet_obj_set_log(target,
                                                                     isOld ? "queue_old" : "queue",
                                                                     PriorityQueue.class);
    }
    
    public static kodkod.ast.IntExpression size_get_log(kodkod.ast.Expression target,
                                                        boolean isOld) {
        return polyglot.ext.pbnj.tologic.LogMap.fieldGet_log(target,
                                                             isOld ? "size_old" : "size",
                                                             PriorityQueue.class).sum();
    }
    
    public static PBJSet<Integer> setMap_size(PBJSet<PriorityQueue> objs,
                                              java.lang.String ... fieldNs) {
        PBJSet<Integer> res =
          new PBJSet<Integer>();
        java.util.Iterator<PriorityQueue> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().size);
        }
        return res;
    }
    
    static {
               polyglot.ext.pbnj.tologic.LogMap.newClassForLog(PriorityQueue.class);
               polyglot.ext.pbnj.tologic.LogMap.newInstVarRel(PriorityQueue.class,
                                                              "queue",
                                                              PriorityQueue.class,
                                                              Object.class,
                                                              Object.class,
                                                              false,
                                                              true,
                                                              true,
                                                              false,
                                                              false);
               polyglot.ext.pbnj.tologic.LogMap.newInstVarRel(PriorityQueue.class,
                                                              "queue",
                                                              PriorityQueue.class,
                                                              Object.class,
                                                              Object.class,
                                                              false,
                                                              true,
                                                              false,
                                                              false,
                                                              false);
               polyglot.ext.pbnj.tologic.LogMap.newInstVarRel(PriorityQueue.class,
                                                              "size",
                                                              PriorityQueue.class,
                                                              Integer.class,
                                                              Integer.class,
                                                              false,
                                                              false,
                                                              true,
                                                              false,
                                                              false);
               polyglot.ext.pbnj.tologic.LogMap.newInstVarRel(PriorityQueue.class,
                                                              "size",
                                                              PriorityQueue.class,
                                                              Integer.class,
                                                              Integer.class,
                                                              false,
                                                              false,
                                                              false,
                                                              false,
                                                              false);
           }
    
    public static polyglot.ext.pbnj.tologic.LogObjSet getQueue_log(kodkod.ast.Expression target,
                                                                   boolean target_isOld) {
        return PriorityQueue.queue_get_log(target,
                                           target_isOld);
    }
    
    public static kodkod.ast.IntExpression size_log(kodkod.ast.Expression target,
                                                    boolean target_isOld) {
        return PriorityQueue.size_get_log(target,
                                          target_isOld);
    }
    
    public static polyglot.ext.pbnj.tologic.LogObjSet toPBJSet_log(kodkod.ast.Expression target,
                                                                   boolean target_isOld) {
        boolean e_isOld =
          false;
        kodkod.ast.Expression e =
          kodkod.ast.Variable.unary("e");
        boolean i_isOld =
          false;
        kodkod.ast.Variable quantVar_i =
          kodkod.ast.Variable.unary("i");
        kodkod.ast.IntExpression i =
          quantVar_i.sum();
        kodkod.ast.Expression fallback_var_i =
          quantVar_i;
        return polyglot.ext.pbnj.tologic.LogObjSet.setComprehensionOp(PriorityQueue.queue_get_log(target,
                                                                                                  target_isOld),
                                                                      e,
                                                                      polyglot.ext.pbnj.tologic.LogObjSet.quantifyOp(polyglot.ext.pbnj.primitives.PBJInteger.range_log(kodkod.ast.IntConstant.constant(0),
                                                                                                                                                                       target_isOld,
                                                                                                                                                                       PriorityQueue.size_log(target,
                                                                                                                                                                                              target_isOld).minus(kodkod.ast.IntConstant.constant(1)),
                                                                                                                                                                       target_isOld),
                                                                                                                     false,
                                                                                                                     "some",
                                                                                                                     fallback_var_i,
                                                                                                                     PriorityQueue.queue_get_log(target,
                                                                                                                                                 target_isOld).get_log(i,
                                                                                                                                                                       false).eq(e)));
    }
    
    public static kodkod.ast.Formula verifyInvariants_log(kodkod.ast.Expression target,
                                                          boolean target_isOld) {
        return PriorityQueue.toPBJSet_log(target,
                                          target_isOld).size_log().eq(PriorityQueue.size_get_log(target,
                                                                                                 target_isOld));
    }
}
