package uk.phsh.binaryheap.collection;

import uk.phsh.binaryheap.data.Node;
import uk.phsh.binaryheap.interfaces.I_NodeElement;

public class BinaryHeapMax<E extends I_NodeElement> extends BinaryHeapAbstract<E> {

    public BinaryHeapMax() {
        super();
    }

    @Override
    public void sortDown(int startIndex) {
        if(startIndex == -1)
            return;

        int childIndex;
        Node<E> parentNode = getNode(startIndex);

        int leftIndex = parentNode.getLeftChildIndex();
        int rightIndex = parentNode.getRightChildIndex();

        if(rightIndex == -1) {
            if(leftIndex == -1)
                return;
            else
                childIndex = leftIndex;
        } else {
            if(compare(getNode(leftIndex), getNode(rightIndex)) > 0)
                childIndex = leftIndex;
            else
                childIndex = rightIndex;
        }

        Node<E> childNode = getNode(childIndex);
        if(compare(parentNode, childNode) < 0) {
            swapNode(startIndex, childIndex);
            sortDown(childIndex);
        }
    }

    @Override
    public void sortUp(int startIndex) {
        Node<E> startNode = getNode(startIndex);
        if(startIndex > 0) {
            Node<E> parent = getNode(startNode.getParentIndex());
            if (compare(parent, startNode) < 0) {
                swapNode(parent, startNode);
                sortUp(parent.getIndex());
            }
        }
    }
}
