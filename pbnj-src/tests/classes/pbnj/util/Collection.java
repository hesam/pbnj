package pbnj.util;

public interface Collection<E>  extends Iterable<E> {
    public abstract int size();
    
    public abstract boolean isEmpty();
    
    public abstract boolean contains(Object o);
    
    public abstract Iterator<E> iterator();
    
    public abstract Object[] toArray();
    
    public abstract <T> T[] toArray(T[] a);
    
    public abstract boolean add(E o);
    
    public abstract boolean remove(Object o);
    
    public abstract boolean containsAll(Collection<?> c);
    
    public abstract boolean addAll(Collection<? extends E> c);
    
    public abstract boolean removeAll(Collection<?> c);
    
    public abstract boolean retainAll(Collection<?> c);
    
    public abstract void clear();
    
    public abstract boolean equals(Object o);
    
    public abstract int hashCode();
}
