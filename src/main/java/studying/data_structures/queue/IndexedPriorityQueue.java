package studying.data_structures.queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IndexedPriorityQueue<K, V extends Comparable<V>> {
    private static final int DEFAULT_MAX_SIZE = 20;
    private HashMap<K, Integer> map;
    private ArrayList<V> values;
    private int[] pm, im;
    private int maxSize, size = 0;


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

        values = new ArrayList<>(maxSize);
        map = new HashMap<>(maxSize);
        pm = new int[maxSize];
        im = new int[maxSize];
        prePopulateArrays();
    }

    public boolean insert(K key, V value) {
        if (map.containsKey(key) || size > maxSize)
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
     * Removes and returns the first element's key of the Priority Queue
     *
     * @return T
     */
    public K poll() {
        return remove(getMapKey(im[0]));
    }

    /**
     * @param key K
     * @return K
     */
    public K remove(K key) {
        if (map.containsKey(key)) {
            int keyPos = pm[map.get(key)];
            swap(keyPos, size - 1);

            values.set(im[size - 1], null);
            pm[im[size - 1]] = -1;
            im[size - 1] = -1;

            // Heapifying
            sink(keyPos);
            //swim(keyPos);
            size--;

            return key;
        }

        return null;
    }

    /**
     * Prints the data structure in a debugging friendly format
     */
    public void print() {
        System.out.println("VAL: " + values);
        System.out.println("PM: " + Arrays.toString(pm));
        System.out.println("IM: " + Arrays.toString(im));

        for (int i = 0; i < size; i++) {
            System.out.print(values.get(im[i]) + ",");
        }

        System.out.println();
    }

    /**
     * Moves 'up' the given node until it satisfy the MIN Heap invariant
     * If the given value is lower than the parent let's swap
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
     * Moves 'down' the given node until it satisfy the MIN Heap invariant
     * If the given value is greater than one of its children let's swap with the child having the lower value
     *
     * @param i int
     */
    private void sink(int i) {
        int lowerI = getLowerValueChildIndex(i);
        if (lowerI == -1) return; // No children scenario

        System.out.println("L Children " + lowerI);

        while (values.get(im[i]).compareTo(values.get(im[lowerI])) < 0) {
            swap(i, lowerI);
            i = lowerI;
            lowerI = getLowerValueChildIndex(i);

            if (lowerI == -1) break;
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

        int temp = im[i];
        im[i] = im[p];
        im[p] = temp;
    }

    /**
     * Populates the instance arrays with placeholder values
     */
    private void prePopulateArrays() {
        for (int i = 0; i < maxSize; i++) {
            values.add(i, null);
            im[i] = -1;
            pm[i] = -1;
        }
    }

    /**
     * Given an index value it returns a map Key
     * TODO: Change the O(n) time complexity for this operation, it is extremely bad.
     *
     * @param ki int
     * @return K
     */
    private K getMapKey(int ki) {
        for (Map.Entry<K, Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(ki)) {
                return entry.getKey();
            }
        }

        return null;
    }

    /**
     * Takes a node index as input and returns the index of the child with the lower value
     * Returns '-1' in case one of the children does not exist
     *
     * @param i int
     * @return int
     */
    private int getLowerValueChildIndex(int i) {
        int leftI = (2 * i) + 1;
        int rightI = (2 * i) + 2;
        V leftChild = getLeftChild(i);
        V rightChild = getRightChild(i);
        System.out.println("Chidlernds val " + leftChild + "   " + rightChild);

        if (leftChild != null && rightChild != null) {
            return leftChild.compareTo(rightChild) <= 0 ? leftI : rightI;
        } else if (leftChild == null && rightChild != null) {
            return rightI;
        } else if (leftChild != null) {
            return leftI;
        }

        return -1;
    }

    /**
     * Returns the left child's value of the given node
     *
     * @param index int
     * @return T
     */
    private V getLeftChild(int index) {
        try {
            return values.get(im[(index * 2) + 1]);
        } catch (Exception e) {
            return null;
        }

    }

    /**
     * Returns the right child's value of the given node
     *
     * @param index int
     * @return T
     */
    private V getRightChild(int index) {
        try {
            return values.get(im[(index * 2) + 2]);
        } catch (Exception e) {
            return null;
        }
    }

}
