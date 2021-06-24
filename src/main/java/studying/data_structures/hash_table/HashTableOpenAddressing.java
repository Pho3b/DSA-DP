package studying.data_structures.hash_table;

import java.util.ArrayList;

public class HashTableOpenAddressing<K, V> extends HashTable<K, V> {
    private static final int DEFAULT_CAPACITY = 24;
    private static final float DEFAULT_LOAD_FACTOR = 0.6f;
    private ArrayList<Entry<K, V>> table;


    /**
     * Default constructor
     */
    public HashTableOpenAddressing() {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    /**
     * Constructor with given capacity
     *
     * @param loadFactor float
     */
    HashTableOpenAddressing(float loadFactor) {
        this(DEFAULT_CAPACITY, loadFactor);
    }

    /**
     * Constructor with given capacity and load factor
     *
     * @param capacity   int
     * @param loadFactor float
     */
    HashTableOpenAddressing(int capacity, float loadFactor) {
        this.capacity = Math.max(capacity, 3);
        this.setLoadFactor(loadFactor);
        this.threshold = (int) (this.capacity * this.loadFactor);
        this.table = this.initEmptyTable(capacity);
    }

    /**
     * @param key   K
     * @param value V
     */
    @Override
    public void add(K key, V value) {
        Entry<K, V> entry = new Entry<>(key, value);
        int hash = getCleanHash(key);
        int index = probeForASlot(hash);

        this.table.set(index, entry);
        this.size++;

        // Checking if we need to resize the table or not
        if (this.size > this.threshold) {
            this.resizeTable();
        }
    }

    /**
     * Probes for a given slot until it finds it
     * Note: The NOT FOUND case cannot occur because the size of the table and the probe X number
     * are kept always relatively prime to each other
     *
     * @param hash int
     * @return int
     */
    private int probeForASlot(int hash) {
        return this.probeForASlot(hash, null);
    }

    /**
     *
     * @param hash
     * @param valueToSearch
     * @return
     */
    private int probeForASlot(int hash, K valueToSearch) {
        int index = hash;
        int x = 0;

        // We keep probing until we find an empty slot in the table
        while (this.table.get(index) != valueToSearch) {
            index = (hash + Probe.linearProbing(x)) % this.capacity;
            x++;
        }

        return index;
    }

    // TODO: fix this method
    @Override
    public V get(K key) {
        int hash = getCleanHash(key);
        int index = this.probeForASlot(hash, key);

        return this.table.get(this.probeForASlot(hash, key)).value;
    }

    @Override
    public boolean put(K key, V value) {
        return false;
    }

    @Override
    public boolean remove(K key) {
        return false;
    }

    /**
     * Prints the HashTable in a suitable format
     */
    @Override
    public void print() {
        System.out.println("HASH TABLE START:");

        for (int i = 0; i < this.capacity; i++) {
            System.out.println(i + " : " + this.table.get(i));
        }
    }

    /**
     * Initializes a new empty table with the instance given capacity filled with null values
     *
     * @param capacity int
     */
    private ArrayList<Entry<K, V>> initEmptyTable(int capacity) {
        ArrayList<Entry<K, V>> res = new ArrayList<>(capacity);

        for (int i = 0; i < capacity; i++) {
            res.add(i, null);
        }

        return res;
    }

    /**
     * Doubles the size of the current table and re hashes all of the previous elements inside it
     */
    private void resizeTable() {
        this.capacity *= 2;
        ArrayList<Entry<K, V>> newTable = initEmptyTable(this.capacity);

        for (Entry<K, V> entry : this.table) {
            if (entry != null) {
                int index = this.probeForASlot(entry.hash);
                newTable.set(index, entry);
            }
        }

        this.table = newTable;
        this.threshold = (int) (this.capacity * this.loadFactor);
    }
}
