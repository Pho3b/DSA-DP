package studying.data_structures.heap;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * MAX Indexed Binary Heap implementation
 *
 * @param <V>
 */
public class IndexedBinaryHeap<K, V extends Comparable<V>> extends AbstractBinaryHeap<V> {
    private static final int DEFAULT_SIZE = 20;
    HashMap<K, Integer> map;
    ArrayList<V> values; // Array containing the node values mapped to the Key index of the 'map'
    ArrayList<Integer> positionMap; // Array containing the nodes index position for every Key Index in the 'map'
    ArrayList<Integer> inverseMap; // Array containing the Key Index for every node



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
        values = new ArrayList<>(size);
        positionMap = new ArrayList<>(size);
        inverseMap = new ArrayList<>(size);
        map = new HashMap<>(size);
    }

    /**
     * Inserts a new element into the heap and adjusts the Heap
     * to satisfy the Heap Invariant
     *
     * @param value V
     */
    public void insert(K key, V value) {
        values.add(value);

        int lastIndex = values.size() - 1;
        map.put(key, lastIndex);
        positionMap.add(lastIndex);
        inverseMap.add(lastIndex);

        if (values.size() > 1) {
            swim(lastIndex);
        }
    }

    /**
     * Deletes the given element from the heap if it exists and then heapify the rest of the container.
     * Returns true or false whether the deletion has correctly occurred or not.
     *
     * @param value V
     */
    public boolean delete(V value) {
        for (int i = 0; i < heap.size(); i++) {
            if (value == heap.get(i)) {
                swap(i, (heap.size() - 1));
                heap.remove(heap.size() - 1);

                if (heap.get(i).compareTo(heap.get((i - 1) / 2)) > 0) {
                    swim(i);
                } else {
                    sink(i);
                }

                return true;
            }
        }

        return false;
    }

    /**
     * Moves 'up' the given node until it satisfy the MAX Heap invariant
     * If the given value is greater than the parent let's swap
     *
     * @param i int
     */
    private void swim(int i) {
        while (heap.get(i).compareTo(heap.get((i - 1) / 2)) > 0) {
            swap(i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    /**
     * Moves 'down' the given node until it satisfy the MAX Heap invariant
     * If the given value is less than one of its children let's swap with the child having the highest value
     *
     * @param i int
     */
    private void sink(int i) {
        int higherValueIndex = getHigherValueChildIndex(i);
        if (higherValueIndex == -1) return; // No children scenario

        while (heap.get(i).compareTo(heap.get(higherValueIndex)) < 0) {
            swap(i, higherValueIndex);
            i = higherValueIndex;
            higherValueIndex = getHigherValueChildIndex(i);

            if (higherValueIndex == -1) break;
        }
    }

    /**
     * Utility method to swap the given values inside the heap array
     *
     * @param i int
     * @param j int
     */
    private void swap(int i, int j) {
        V val1 = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, val1);
    }
}
