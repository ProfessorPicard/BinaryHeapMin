package collection;

import data.Node;
import interfaces.I_Binary;
import interfaces.I_NodeElement;

public class BinaryHeapMin<E extends I_NodeElement> implements I_Binary<E>{

    private Node<E>[] _baseArray;
    private int _currentSize;

    public BinaryHeapMin() {
        _baseArray = new Node[0];
    }

    @Override
    public boolean insert(E o, long key) {

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
            sortUp(newNode);
            return true;
        }
        return false;
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
    public E getMin() {
        return _baseArray[0].getElement();
    }

    @Override
    public void removeMin() {
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
                sortDown(_baseArray[0]);
        }
    }

    public void prettyString() {
        for (int i=0; i < _currentSize; i++) {
            System.out.println("Array Index: " + i + " | " + _baseArray[i]);
        }
    }

    private void resizeArray(int newSize) {
//        if(newSize > 0) {

            Node<E>[] newArray = new Node[newSize];
            System.arraycopy(_baseArray, 0, newArray, 0, Math.min(newSize, _currentSize));
            _baseArray = new Node[newSize];
            System.arraycopy(newArray, 0, _baseArray, 0, newArray.length);

            _currentSize = newSize;
//        } else {
//            _baseArray = new Node[0];
//            _currentSize = 0;
//        }
    }

    private void sortUp(Node<E> node) {
        int index = node.getIndex();

        if(index > 0) {

            Node<E> parent = _baseArray[node.getParentIndex()];

            if (parent.getKey() > node.getKey() ||
                    parent.getKey() == node.getKey() &&
                            parent.getElement().getTimeCreated() > node.getElement().getTimeCreated()) {

                Node<E> temp = new Node<>(parent.getElement(), parent.getKey());
                temp.setParentIndex(node.getParentIndex());
                temp.setIndex(node.getIndex());
                temp.setLeftChildIndex(node.getLeftChildIndex());
                temp.setRightChildIndex(node.getRightChildIndex());

                node.setParentIndex(parent.getParentIndex());
                node.setIndex(parent.getIndex());
                node.setLeftChildIndex(parent.getLeftChildIndex());
                node.setRightChildIndex(parent.getRightChildIndex());

                _baseArray[parent.getIndex()] = node;
                _baseArray[index] = temp;

                sortUp(_baseArray[node.getIndex()]);
            }
        }
    }

    private void sortDown(Node<E> node) {
        int minIndex;
        int index = node.getIndex();
        int leftIndex = node.getLeftChildIndex();
        int rightIndex = node.getRightChildIndex();
        if(rightIndex == -1) {
            if(leftIndex == -1)
                return;
            else
                minIndex = leftIndex;
        } else {
            Node<E> leftChild = _baseArray[leftIndex];
            Node<E> rightChild = _baseArray[rightIndex];

            if(leftChild.getKey() < rightChild.getKey() ||
                    leftChild.getKey() == rightChild.getKey() &&
                            leftChild.getElement().getTimeCreated() < rightChild.getElement().getTimeCreated())
                minIndex = leftIndex;
            else
                minIndex = rightIndex;
        }

        Node<E> selected = _baseArray[minIndex];
        if(node.getKey() > selected.getKey() ||
                node.getKey() == selected.getKey() &&
                        node.getElement().getTimeCreated() > selected.getElement().getTimeCreated()) {

            Node<E> temp = new Node<>(selected.getElement(), selected.getKey());
            temp.setParentIndex(node.getParentIndex());
            temp.setIndex(node.getIndex());
            temp.setLeftChildIndex(node.getLeftChildIndex());
            temp.setRightChildIndex(node.getRightChildIndex());
            _baseArray[index] = temp;

            node.setParentIndex(selected.getParentIndex());
            node.setIndex(selected.getIndex());
            node.setLeftChildIndex(selected.getLeftChildIndex());
            node.setRightChildIndex(selected.getRightChildIndex());
            _baseArray[minIndex] = node;

            sortDown(_baseArray[minIndex]);
        }

    }
}
