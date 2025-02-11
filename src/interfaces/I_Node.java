package interfaces;

public interface I_Node<E> {
    E getElement();
    int getParentIndex();
    int getLeftChildIndex();
    int getRightChildIndex();
    long getKey();
    int getIndex();
    void setElement(E element);
    void setParentIndex(int parentIndex);
    void setLeftChildIndex(int leftIndex);
    void setRightChildIndex(int rightIndex);
    void setKey(long key);
    void setIndex(int index);
}
