package data;

import interfaces.I_Node;

public class Node<E> implements I_Node<E> {

    private E _element;
    private int _parent = -1;
    private int _left = -1;
    private int _right = -1;
    long _key;
    int _index = -1;

    public Node(E element, long key) {
        this._element = element;
        this._key = key;
    }

    @Override
    public E getElement() {
        return _element;
    }

    @Override
    public int getParentIndex() {
        return _parent;
    }

    @Override
    public int getLeftChildIndex() {
        return _left;
    }

    @Override
    public int getRightChildIndex() {
        return _right;
    }

    @Override
    public long getKey() {
        return _key;
    }

    @Override
    public int getIndex() {
        return _index;
    }

    @Override
    public void setElement(E element) {
        _element = element;
    }

    @Override
    public void setParentIndex(int parent) {
        _parent = parent;
    }

    @Override
    public void setLeftChildIndex(int left) {
        _left = left;
    }

    @Override
    public void setRightChildIndex(int right) {
        _right = right;
    }

    @Override
    public void setKey(long key) {
        _key = key;
    }

    @Override
    public void setIndex(int index) {
        _index = index;
    }

    @Override
    public String toString() {
        return "Node [index=" + getIndex() + ", parentIndex=" + getParentIndex() + ", leftChildIndex=" + getLeftChildIndex() + ", rightChildIndex=" + getRightChildIndex() + ", key=" + getKey() + "]" + " | " + _element.toString();
    }
}
