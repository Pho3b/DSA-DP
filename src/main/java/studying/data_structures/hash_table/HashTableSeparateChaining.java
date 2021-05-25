package studying.data_structures.hash_table;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class HashTableSeparateChaining<K, V> implements Iterable<Entry<K, V>> {
    private static final int DEFAULT_CAPACITY = 11;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private int size, capacity, threshold = 0;
    private float loadFactor;
    private ArrayList<LinkedList<Entry<K, V>>> table;


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
        // The threshold tells us the max number of entries that can be inside the table before we need to resize it
        this.threshold = (int) (this.capacity * this.loadFactor);
        this.table = this.initNewTable(this.capacity);
    }

    /**
     * Inserts a new Entry(key value pair object) into the table
     *
     * @param key   K
     * @param value V
     */
    public void put(K key, V value) {
        int hash = getCleanHash(key);
        LinkedList<Entry<K, V>> bucket = this.table.get(hash);

        // Iterating through the bucket's entries
        for (Entry<K, V> entry : bucket) {
            // Duplicate entry case, we return
            if (entry.equals(key)) {
                return;
            }
        }

        // Successful addition of a new element
        bucket.add(new Entry<>(key, value));
        this.size++;

        // Checking if we need to resize the table or not
        if (this.size > this.threshold) {
            // Duplicate table size, re hash values inside it and recalculate the threshold
            // this.threshold = (int) (this.capacity * this.loadFactor);
        }

    }

    /**
     * Prints the HashTable in a suitable format
     */
    public void print() {
        System.out.println("HASH TABLE START:");

        for (int i = 0; i < this.capacity; i++) {
            System.out.println(i + " : " + this.table.get(i));
        }
    }

    /**
     * Returns a new table with the given capacity, pre populated with empty LinkedLists
     *
     * @param capacity int
     * @return ArrayList<LinkedList < Entry < K, V>>>
     */
    private ArrayList<LinkedList<Entry<K, V>>> initNewTable(int capacity) {
        ArrayList<LinkedList<Entry<K, V>>> res = new ArrayList<>(capacity);

        for (int i = 0; i < capacity; i++) {
            res.add(i, new LinkedList<>());
        }

        return res;
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

    /**
     * Returns a positive hash value clamped between zero and the current table capacity
     * (0 <= hash <= this.capacity)
     *
     * @param key K
     */
    private int getCleanHash(K key) {
        int hash = key.hashCode() % this.capacity;
        return hash > 0 ? hash : hash * -1;
    }

    private void resizeTable() {
        ArrayList<LinkedList<Entry<K, V>>> newTable = this.initNewTable(this.capacity * 2);
        int hash;

        for (Entry<K, V> entry : this) {
            hash = getCleanHash(entry.key);
            newTable.get(hash).add(entry);
        }

        // Let's change the threshold
        this.table = newTable;
    }

    /**
     * Returns a new iterator for this hashTableSeparateChaining instance
     *
     * @return Iterator<Entry < K, V>>
     */
    @Override
    public Iterator<Entry<K, V>> iterator() {
        return new HashTableSeparateChainingIterator<>(this.table);
    }

}
