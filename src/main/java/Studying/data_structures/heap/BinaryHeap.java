package Studying.data_structures.heap;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

/**
 * Min Binary Heap Implementation
 *
 * @param <T>
 */
public class BinaryHeap<T extends Comparable<T>> {
    private static final int DEFAULT_SIZE = 10;
    private final List<T> heap;
    private final Hashtable<T, Set<Integer>> trackingTable;


    /**
     * Basic Constructor
     */
    public BinaryHeap() {
        this(DEFAULT_SIZE);
    }

    /**
     * Constructor with given size
     *
     * @param size int
     */
    public BinaryHeap(int size) {
        heap = new ArrayList<>(size);
        trackingTable = new Hashtable<>(size);
    }

    /**
     * Inserts a new element into the heap and adjusts the Heap
     * to satisfy the Heap Invariant rule
     *
     * @param data T
     */
    public void insert(T data) {
        heap.add(data);

        if (heap.size() > 1) {
            bubbleUp(heap.size() - 1);
        }
    }

    /**
     * Removes and returns the first element of the Heap
     *
     * @return T
     */
    public T poll() {
        T res = null;

        if (heap.size() > 1) {
            swap(0, heap.size() - 1);
            res = heap.remove(heap.size() - 1);
            bubbleDown(0);
        }

        return res;
    }

    /**
     * Removes and returns the element at the given index
     *
     * @param index int
     * @return T
     * @throws IndexOutOfBoundsException exception
     */
    public T remove(int index) throws IndexOutOfBoundsException {
        T res = null;
        return res;
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
     * 'Moves up' the element at the given index until the Heap satisfies the Heap Invariant rule
     * O(log n)
     */
    private void bubbleUp(int index) {
        while (getParentNode(index).compareTo(heap.get(index)) > 0) {
            swap(index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    /**
     * 'Moves down' the element at the given index until the Heap satisfies the Heap Invariant rule
     * O(log n)
     */
    private void bubbleDown(int index) {
        int lowerIndex = getLowerValueChildIndex(index);

        // Checking if the current index node actually has children or not
        while (heap.get(lowerIndex).compareTo(heap.get(index)) < 0) {
            swap(lowerIndex, index);
            index = lowerIndex;

            if (getLeftChild(index) != null) {
                lowerIndex = getLowerValueChildIndex(index);
            }
        }
    }

    /**
     * Returns the parent Node of the node at the given index
     *
     * @param index int
     * @return T
     */
    private T getParentNode(int index) {
        return heap.get((index - 1) / 2);
    }

    /**
     * Returns the left child of the given node
     *
     * @param index int
     * @return T
     */
    private T getLeftChild(int index) {
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
    private T getRightChild(int index) {
        try {
            return heap.get((index * 2) + 2);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Utility method to swap values inside the instance 'heap'
     *
     * @param index1 int
     * @param index2 int
     */
    private void swap(int index1, int index2) {
        T temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

    /**
     * Takes a node index as input and returns the index of the child with the lower value
     *
     * @param i int
     * @return int
     */
    private int getLowerValueChildIndex(int i) {
        return getLeftChild(i).compareTo(getRightChild(i)) <= 0 ? (2 * i) + 1 : (2 * i) + 2;
    }
}
