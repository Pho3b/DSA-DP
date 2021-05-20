package studying.data_structures.hash_table;


import java.util.LinkedList;

public class HashTableSeparateChaining<K, V> {
    private static final int DEFAULT_CAPACITY = 11;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private int size, capacity, threshold = 0;
    private float loadFactor;
    private LinkedList<Entry<K, V>>[] table;


    /**
     * Default empty constructor
     */
    public HashTableSeparateChaining() {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    /**
     * Constructor with given capacity
     *
     * @param capacity int
     */
    public HashTableSeparateChaining(int capacity) {
        this(capacity, DEFAULT_LOAD_FACTOR);
    }

    /**
     * Constructor with given capacity and loadFactor
     *
     * @param capacity   int
     * @param loadFactor float
     */
    public HashTableSeparateChaining(int capacity, float loadFactor) {
        this.capacity = Math.max(capacity, 3); // I want to avoid to work with table that are too small (ex. < 3)
        this.setLoadFactor(loadFactor);
        // Threshold holds the max number of entries that can be inside the table before to resize it
        this.threshold = (int) (this.capacity * this.loadFactor);
        this.table = new LinkedList[this.capacity];
    }

    /**
     * Inserts a new Entry(key value pair object) into the table
     *
     * @param key K
     * @param value V
     */
    public void put(K key, V value) {
        int tempHash = key.hashCode();
        LinkedList<Entry<K, V>> bucket = this.table[tempHash];

        if (bucket != null) {
            for (Entry<K, V> entry: bucket) {
                if(value == entry.value) {

                }
            }
        }
    }



    /**
     * Setter for the loadFactor property.
     * Must be a value between 0.0 and 1.0, otherwise an exception is thrown
     *
     * @param loadFactor float
     */
    private void setLoadFactor(float loadFactor) {
        if (loadFactor < 0 && loadFactor > 1)
            throw new IndexOutOfBoundsException("loadFactor value must lie between 0.0 and 1.0");

        this.loadFactor = loadFactor;
    }
}
