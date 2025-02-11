package uk.phsh.binaryheap.interfaces;

public interface I_Binary<E> {
    boolean insert(E e, long key);
    boolean contains(long identifier);
    int size();
    E getMin();
    void removeMin();
    void clear();
}
