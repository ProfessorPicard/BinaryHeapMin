package uk.phsh.binaryheap.collection;

import uk.phsh.binaryheap.data.Node;
import uk.phsh.binaryheap.interfaces.I_Binary;
import uk.phsh.binaryheap.interfaces.I_NodeElement;

public abstract class BinaryHeapAbstract<E extends I_NodeElement> implements I_Binary<E> {
    private Node<E>[] _baseArray;
    private int _currentSize;

    public BinaryHeapAbstract() {
        _baseArray = new Node[0];
    }

    @Override
    public void insert(E o, long key) {
        if(o != null) {
            resizeArray(_currentSize + 1);
            int index = _currentSize - 1;
            Node<E> newNode = new Node<>(o, key);
            _baseArray[index] = newNode;
            newNode.setIndex(index);

            if(_currentSize > 1) {
                newNode.setParentIndex((int)Math.floor((index - 1) / 2.0));
                if(index % 2 == 0)
                    _baseArray[newNode.getParentIndex()].setRightChildIndex(index);
                else
                    _baseArray[newNode.getParentIndex()].setLeftChildIndex(index);
            }
            sortUp(newNode.getIndex());
        }
    }

    @Override
    public boolean contains(long identifier) {
        for(int i = 0; i < _currentSize; i++) {
            if(_baseArray[i].getElement().getUniqueIdentifier() == identifier) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return _currentSize;
    }

    @Override
    public void removeRoot() {
        if(_currentSize > 0) {
            Node<E> temp = _baseArray[0];
            int lastIndex = _currentSize - 1;
            int parentIndex = _baseArray[lastIndex].getParentIndex();
            _baseArray[0] = _baseArray[lastIndex];
            _baseArray[0].setIndex(temp.getIndex());
            _baseArray[0].setParentIndex(temp.getParentIndex());
            _baseArray[0].setRightChildIndex(temp.getRightChildIndex());
            _baseArray[0].setLeftChildIndex(temp.getLeftChildIndex());


            if(_baseArray[parentIndex].getLeftChildIndex() == lastIndex)
                _baseArray[parentIndex].setLeftChildIndex(-1);
            else
                _baseArray[parentIndex].setRightChildIndex(-1);

            _baseArray[lastIndex] = null;

            resizeArray(_currentSize - 1);

            if(_currentSize > 0)
                sortDown(0);
        }
    }

    @Override
    public void clear() {
        resizeArray(0);
    }

    private void resizeArray(int newSize) {
        Node<E>[] newArray = new Node[newSize];
        System.arraycopy(_baseArray, 0, newArray, 0, Math.min(newSize, _currentSize));
        _baseArray = new Node[newSize];
        System.arraycopy(newArray, 0, _baseArray, 0, newArray.length);

        _currentSize = newSize;
    }

    @Override
    public E getRoot() {
        return _baseArray[0].getElement();
    }

    @Override
    public void swapNode(int parentIndex, int childIndex) {
        Node<E> parentNode = _baseArray[parentIndex];
        Node<E> childNode = _baseArray[childIndex];

        swapNode(parentNode, childNode);
    }

    @Override
    public void swapNode(Node<E> parentNode, Node<E> childNode) {
        int childIndex = childNode.getIndex();
        int parentIndex = parentNode.getIndex();
        Node<E> temp = new Node<>(parentNode.getElement(), parentNode.getKey());
        temp.setParentIndex(childNode.getParentIndex());
        temp.setIndex(childNode.getIndex());
        temp.setLeftChildIndex(childNode.getLeftChildIndex());
        temp.setRightChildIndex(childNode.getRightChildIndex());

        childNode.setParentIndex(parentNode.getParentIndex());
        childNode.setIndex(parentNode.getIndex());
        childNode.setLeftChildIndex(parentNode.getLeftChildIndex());
        childNode.setRightChildIndex(parentNode.getRightChildIndex());

        _baseArray[parentIndex] = childNode;
        _baseArray[childIndex] = temp;
    }

    @Override
    public Node<E> getNode(int index) {
        return _baseArray[index];
    }

    @Override
    public int compare(Node<E> parentNode, Node<E> childNode) {
        if(parentNode.getKey() == childNode.getKey()) {
            return Long.compare(parentNode.getElement().getTimeCreated(), childNode.getElement().getTimeCreated());
        }
        return Long.compare(parentNode.getKey(), childNode.getKey());
    }

    public void prettyString() {
        for (int i=0; i < _currentSize; i++) {
            System.out.println("Array Index: " + i + " | " + _baseArray[i]);
        }
    }

    public abstract void sortDown(int startNode);
    public abstract void sortUp(int startNode);
}
