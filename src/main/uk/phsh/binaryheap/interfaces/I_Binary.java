package uk.phsh.binaryheap.interfaces;

import uk.phsh.binaryheap.data.Node;

public interface I_Binary<E> {
    void insert(E e, long key);
    boolean contains(long identifier);
    int size();
    E getRoot();
    void removeRoot();
    void clear();
    void sortUp(int startIndex);
    void sortDown(int startIndex);
    void swapNode(int index1, int index2);
    void swapNode(Node<E> node1, Node<E> node2);
    Node<E> getNode(int index);
    int compare(Node<E> node1, Node<E> node2);
}
