package studying.data_structures.heap;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractBinaryHeap<T extends Comparable<T>> {
    protected static final int DEFAULT_SIZE = 10;
    protected List<T> heap;


    /**
     * Returns the parent Node of the node at the given index
     *
     * @param index int
     * @return T
     */
    protected T getParentNode(int index) {
        return heap.get((index - 1) / 2);
    }

    /**
     * Returns the left child of the given node
     *
     * @param index int
     * @return T
     */
    protected T getLeftChild(int index) {
        try {
            return heap.get((index * 2) + 1);
        } catch (Exception e) {
            return null;
        }

    }

    /**
     * Returns the right child of the given node
     *
     * @param index int
     * @return T
     */
    protected T getRightChild(int index) {
        try {
            return heap.get((index * 2) + 2);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Takes a node index as input and returns the index of the child with the lower value
     * Returns '-1' in case one of the children does not exist
     *
     * @param i int
     * @return int
     */
    protected int getLowerValueChildIndex(int i) {
        try {
            return getLeftChild(i).compareTo(getRightChild(i)) <= 0 ? (2 * i) + 1 : (2 * i) + 2;
        } catch (Exception e) {
            return -1;
        }
    }

    /**
     * Takes a node index as input and returns the index of the child with the higher value
     * Returns '-1' in case the node at the given index is a leaf node
     *
     * @param i int
     * @return int
     */
    protected int getHigherValueChildIndex(int i) {
        T leftChild = getLeftChild(i);
        T rightChild = getRightChild(i);

        if (leftChild != null && rightChild != null) {
            return leftChild.compareTo(rightChild) >= 0 ? (2 * i) + 1 : (2 * i) + 2;
        } else if (leftChild == null && rightChild != null) {
            return (2 * i) + 2;
        } else if (leftChild != null) {
            return (2 * i) + 1;
        }

        return -1;
    }

    /**
     * Prints the binary minHeap in a suitable format
     */
    public void print() {
        for (int i = 0; i < heap.size(); i++) {
            System.out.println("PARENT: " + heap.get(i) + " LEFT_CHILD: " + getLeftChild(i) +
                    " RIGHT_CHILD: " + getRightChild(i));
        }
    }

    /**
     * Prints the array used as binary heap in a linear format
     */
    public void linearPrint() {
        System.out.println(Arrays.toString(heap.toArray()));
    }
}
