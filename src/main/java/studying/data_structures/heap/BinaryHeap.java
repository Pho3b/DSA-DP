package studying.data_structures.heap;

import java.util.*;

/**
 * MIN Binary Heap
 *
 * @param <T>
 */
public class BinaryHeap<T extends Comparable<T>> extends AbstractBinaryHeap<T> {
    public final HashMap<T, Set<Integer>> trackingTable;


    /**
     * Default Constructor
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
        trackingTable = new HashMap<>(size);
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
     * O(log n) time complexity thanks to the tracking table
     *
     * @param value T
     * @return T
     * @throws IndexOutOfBoundsException exception
     */
    public T remove(T value) throws IndexOutOfBoundsException {
        T res = null;
        Set<Integer> tempSet = trackingTable.get(value);

        if (heap.size() > 1 && tempSet != null) {
            int index = !tempSet.isEmpty() ? tempSet.iterator().next() : -1;
            swap(index, heap.size() - 1);
            res = heap.remove(heap.size() - 1);

            // Synchronizing the index tracking table accordingly
            if (trackingTable.get(res).size() <= 1) {
                trackingTable.remove(res);
            } else {
                trackingTable.get(res).remove(heap.size() - 1);
            }

            // If the given index is not a leaf node
            // We check if we need to bubbleUp or Down after the removal
            if (getLeftChild(index) != null) {
                if (index == 0 || getParentNode(index).compareTo(heap.get(index)) < 0) {
                    bubbleDown(index);
                } else if (getParentNode(index).compareTo(heap.get(index)) > 0) {
                    bubbleUp(index);
                }
            }
        }

        return res;
    }

    /**
     * Returns whether the heap contains the given value or not
     * It performs the task with a time complexity of O(1) instead of O(n) thanks
     * to the tracking table
     *
     * @param data T
     * @return boolean
     */
    public boolean contains(T data) {
        return trackingTable.containsKey(data);
    }

    /**
     * Retrieves, but does not remove, the first element of the Heap
     *
     * @return T
     */
    public T peek() {
        return heap.size() > 0 ? heap.get(0) : null;
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
        if (lowerIndex == -1)
            return;

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
     * Utility method to swap values inside the instance 'heap'
     *
     * @param i int
     * @param j int
     */
    private void swap(int i, int j) {
        T tempValue1 = heap.get(i);
        T tempValue2 = heap.get(j);
        heap.set(i, tempValue2);
        heap.set(j, tempValue1);

        // Switching the indexes in the tracking table accordingly
        Set<Integer> tempSet = trackingTable.get(tempValue1);
        tempSet.remove(i);
        tempSet.add(j);
        tempSet = trackingTable.get(tempValue2);
        tempSet.remove(j);
        tempSet.add(i);
    }
}
