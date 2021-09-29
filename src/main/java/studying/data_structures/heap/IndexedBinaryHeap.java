package studying.data_structures.heap;

import java.util.ArrayList;
import java.util.List;

/**
 * MAX Indexed Binary Heap
 *
 * @param <T>
 */
public class IndexedBinaryHeap<T extends Comparable<T>> {
    private static final int DEFAULT_SIZE = 10;
    private final List<T> heap;


    /**
     * Default constructor
     */
    public IndexedBinaryHeap() {
        this(DEFAULT_SIZE);
    }

    /**
     * Constructor with given size
     *
     * @param size int
     */
    public IndexedBinaryHeap(int size) {
        this.heap = new ArrayList<>(size);
    }

    /**
     * Inserts a new element into the heap and adjusts the Heap
     * to satisfy the Heap Invariant
     *
     * @param data T
     */
    public void insert(T data) {
        heap.add(data);


        if (heap.size() > 1) {
            swim(heap.size() - 1);
        }
    }

    /**
     * Moves 'up' the given node until it satisfy the MAX Heap invariant
     * If the given value is greater than the parent let's swap
     *
     * @param index int
     */
    private void swim(int index) {
        while (heap.get(index).compareTo(heap.get((index - 1) / 2)) > 0) {
            swap(index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    /**
     * Moves 'down' the given node until it satisfy the MAX Heap invariant
     * If the given value is less than one of its children let's swap with the child having the lowest value
     *
     * @param index int
     */
    private void sink(int index) {
        while (heap.get(index).compareTo(heap.get((index - 1) / 2)) > 0) {
            swap(index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    /**
     * Utility method to swap the given values inside the heap array
     *
     * @param index1 int
     * @param index2 int
     */
    private void swap(int index1, int index2) {
        T tempValue1 = heap.get(index1);
        T tempValue2 = heap.get(index2);
        heap.set(index1, tempValue2);
        heap.set(index2, tempValue1);
    }
}
