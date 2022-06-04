package dsa_dp.data_structures.hash_table;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class HashTableSeparateChaining<K, V> extends HashTable<K, V> implements Iterable<Entry<K, V>> {
    private static final int DEFAULT_CAPACITY = 11;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
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
     * Returns the value to which the given key is mapped, or null if this table contains no mapping for the key
     *
     * @return boolean
     */
    public V get(K key) {
        int hash = getCleanHash(key);
        LinkedList<Entry<K, V>> bucket = this.table.get(hash);
        Entry<K, V> entryToRetrieve = new Entry<>(key, null);

        for (Entry<K, V> entry : bucket) {
            if (entry.isEqual(entryToRetrieve)) {
                return entry.value;
            }
        }

        return null;
    }

    /**
     * Inserts a new Entry(key value pair object) into the table, it doesn't allow duplicates
     *
     * @param key   K
     * @param value V
     */
    public void add(K key, V value) {
        int hash = getCleanHash(key);
        LinkedList<Entry<K, V>> bucket = this.table.get(hash);
        Entry<K, V> newEntry = new Entry<>(key, value);

        // Iterating through the bucket's entries
        for (Entry<K, V> entry : bucket) {
            // Duplicate entry case, let's return
            if (entry.isEqual(newEntry)) {
                return;
            }
        }

        // Successful addition of a new element
        bucket.add(new Entry<>(key, value));
        this.size++;

        // Checking if we need to resize the table or not
        if (this.size > this.threshold) {
            resizeTable();
        }
    }

    /**
     * Updates the value of the given key if it finds it inside the table,
     * it returns false if no key value is updated
     *
     * @return boolean
     */
    public boolean put(K key, V value) {
        int hash = getCleanHash(key);
        LinkedList<Entry<K, V>> bucket = this.table.get(hash);
        Entry<K, V> newEntry = new Entry<>(key, value);

        for (Entry<K, V> entry : bucket) {
            if (entry.isEqual(newEntry)) {
                entry.value = newEntry.value;

                return true;
            }
        }

        return false;
    }

    /**
     * Removes the value mapped to the given key from the table and returns true.
     * If not key is found, it returns false.
     *
     * @return boolean
     */
    public boolean remove(K key) {
        int hash = getCleanHash(key);
        LinkedList<Entry<K, V>> bucket = this.table.get(hash);
        Entry<K, V> entryToRemove = new Entry<>(key, null);

        for (Entry<K, V> entry : bucket) {
            if (entry.isEqual(entryToRemove)) {
                bucket.remove(entry);
                this.size--;

                return true;
            }
        }

        return false;
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
     * Returns a new iterator for this hashTableSeparateChaining instance
     *
     * @return Iterator<Entry < K, V>>
     */
    @Override
    public Iterator<Entry<K, V>> iterator() {
        return new HashTableSeparateChainingIterator<>(this.table);
    }

    /**
     * Returns a new table with the given capacity, pre-populated with empty LinkedLists
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
     * Doubles the size of the internal table and repopulates it with all the previous values
     * recalculating the threshold afterwards
     */
    private void resizeTable() {
        this.capacity *= 2;
        ArrayList<LinkedList<Entry<K, V>>> newTable = this.initNewTable(this.capacity);
        int hash;

        for (Entry<K, V> entry : this) {
            hash = getCleanHash(entry.key);
            newTable.get(hash).add(entry);
        }

        this.threshold = (int) (this.capacity * this.loadFactor);
        this.table = newTable;
    }
}
