package studying.data_structures.queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class IndexedPriorityQueue<K, V extends Comparable<V>> {
    private static final int DEFAULT_MAX_SIZE = 20;
    int maxSize, size = 0;
    HashMap<K, Integer> map;
    ArrayList<V> values; // Array containing the node values mapped to the Key index of the 'map'
    int[] pm; // Array containing the nodes index position for every Key Index in the 'map'
    int[] im; // Array containing the Key Index for every node


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
        System.out.println("guarda max size " +  maxSize);
    }

    public boolean insert(K key, V value) {
        System.out.println(value);
        if (size > maxSize)
            return false;

        map.put(key, size);
        values.set(size, value);
        pm[size] = size;
        im[size] = size;
        size++;

        swim(size);

        return true;
    }

    /**
     * Moves 'up' the given node until it satisfy the MAX Heap invariant
     * If the given value is greater than the parent let's swap
     *
     * @param i int
     */
    private void swim(int i) {
        int parent = (i - 1) / 2;

        //TODO: Solve null pointer exception here --
        while (values.get(i).compareTo(values.get(im[parent])) > 0) {
            int pos = pm[im[parent]];
            pm[im[parent]] = pm[i];
            pm[i] = pos;

            int iPos = im[parent];
            im[parent] = im[i];
            im[i] = iPos;

            i = parent;
            parent = (i - 1) / 2;
        }
    }

    /**
     * Prints the data structure in a friendly format
     */
    public void print() {
        System.out.println("values: ");
        System.out.println(values);
        System.out.println("position map: ");
        System.out.println(Arrays.toString(pm));
        System.out.println("inverse map: ");
        System.out.println(Arrays.toString(im));
    }

    /**
     * Populates the instance 'values' array property with null values
     */
    private void prePopulateValuesArray() {
        values = new ArrayList<>(maxSize);

        for (int i = 0; i < maxSize; i++) {
            System.out.println("aggiunto");
            values.add(i, null);
        }
    }

}
