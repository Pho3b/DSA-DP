package studying.data_structures.queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class IndexedPriorityQueue<K, V extends Comparable<V>> {
    private static final int DEFAULT_MAX_SIZE = 20;
    HashMap<K, Integer> map;
    ArrayList<V> values; // Array containing the node values mapped to the Key index of the 'map'
    int[] pm; // Array containing the nodes index position for every Key Index in the 'map'
    int[] im; // Array containing the Key Index for every node
    int maxSize, size = 0;


    /**
     * Default constructor
     */
    public IndexedPriorityQueue() {
        this(DEFAULT_MAX_SIZE);
    }

    /**
     * Constructor with given size
     *
     * @param maxSize int
     */
    public IndexedPriorityQueue(int maxSize) {
        this.maxSize = maxSize;

        prePopulateValuesArray();
        map = new HashMap<>(maxSize);
        pm = new int[maxSize];
        im = new int[maxSize];
    }

    public boolean insert(K key, V value) {
        if (size > maxSize)
            return false;

        // Populating the internal arrays
        map.put(key, size);
        values.set(size, value);
        pm[size] = size;
        im[size] = size;

        swim(size);
        size++;

        return true;
    }

    /**
     * Moves 'up' the given node until it satisfy the MAX Heap invariant
     * If the given value is greater than the parent let's swap
     *
     * @param i int
     */
    private void swim(int i) {
        if (size < 0)
            return;

        int p = (i - 1) / 2;

        while (values.get(im[i]).compareTo(values.get(im[p])) < 0) {
            swap(i, p);
            i = p;
            p = (i - 1) / 2;
        }
    }

    /**
     * Swaps indexes accordingly in the position map and inverse map
     *
     * @param i int
     * @param p int
     */
    private void swap(int i, int p) {
        pm[im[p]] = i;
        pm[im[i]] = p;

        int iPos = im[i];
        im[i] = im[p];
        im[p] = iPos;
    }

    /**
     * Prints the data structure in a friendly format
     */
    public void print() {
//        System.out.println("VAL: " + values);
        System.out.println("PM: " + Arrays.toString(pm));
        System.out.println("IM: " + Arrays.toString(im));

        for (int i = 0; i < size; i++) {
            System.out.print(values.get(im[i]) + ",");
        }

        System.out.println();
    }

    /**
     * Populates the instance 'values' array property with null values
     */
    private void prePopulateValuesArray() {
        values = new ArrayList<>(maxSize);

        for (int i = 0; i < maxSize; i++) {
            values.add(i, null);
        }
    }

}
