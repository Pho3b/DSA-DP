package Studying.data_structures.heap;

import java.util.*;

/**
 * Min Binary Heap Implementation
 *
 * @param <T>
 */
public class BinaryHeap<T extends Comparable<T>> {
    private static final int DEFAULT_SIZE = 10;
    private final List<T> heap;
    public final Hashtable<T, Set<Integer>> trackingTable;


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

        // Also inserting in the index tracking table accordingly
        if (!trackingTable.containsKey(data)) {
            HashSet<Integer> tempIndexes = new HashSet<>(10);
            tempIndexes.add(heap.size() - 1);
            trackingTable.put(data, tempIndexes);
        } else {
            trackingTable.get(data).add(heap.size() - 1);
        }

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
        return remove(heap.get(0));
    }

    /**
     * Removes and returns the element at the given index
     *
     * @param value T
     * @return T
     * @throws IndexOutOfBoundsException exception
     */
    public T remove(T value) throws IndexOutOfBoundsException {
        T res = null;
        Set<Integer> tempSet = trackingTable.get(value);
        int index = !tempSet.isEmpty() ? tempSet.iterator().next() : -1;

        if (heap.size() > 1) {
            swap(index, heap.size() - 1);
            res = heap.remove(heap.size() - 1);

            // Synchronizing the index tracking table accordingly
            if (trackingTable.get(res).size() <= 1) {
                trackingTable.remove(res);
            } else {
                trackingTable.get(res).remove(heap.size() - 1);
            }

            // Checking if we need to bubbleUp or Down after the removal
            if (index == 0 || getParentNode(index).compareTo(heap.get(index)) < 0) {
                bubbleDown(index);
            } else if (getParentNode(index).compareTo(heap.get(index)) > 0) {
                bubbleUp(index);
            }
        }

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
        if (lowerIndex == -1) return;

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
        T tempValue1 = heap.get(index1);
        T tempValue2 = heap.get(index2);
        heap.set(index1, tempValue2);
        heap.set(index2, tempValue1);

        // Switching the indexes in the tracking table accordingly
        Set<Integer> tempSet = trackingTable.get(tempValue1);
        tempSet.remove(index1);
        tempSet.add(index2);
        tempSet = trackingTable.get(tempValue2);
        tempSet.remove(index2);
        tempSet.add(index1);
    }

    /**
     * Takes a node index as input and returns the index of the child with the lower value
     * Returns '-1' in case one of the children does not exist
     *
     * @param i int
     * @return int
     */
    private int getLowerValueChildIndex(int i) {
        try {
            return getLeftChild(i).compareTo(getRightChild(i)) <= 0 ? (2 * i) + 1 : (2 * i) + 2;
        } catch (Exception e) {
            return -1;
        }
    }
}
