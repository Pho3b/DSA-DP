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
    public HashTableOpenAddressing(float loadFactor) {
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
        int index = probeForEmptySlot(key, null);

        this.table.set(index, entry);
        this.size++;

        // Checking if we need to resize the table or not
        if (this.size > this.threshold) {
            this.resizeTable();
        }
    }

    /**
     * Returns the value to which the given key is mapped
     * returns null if this table does not contain a mapping for the given key
     *
     * @param key K
     * @return V | null
     */
    @Override
    public V get(K key) {
        try {
            return this.table.get(this.probeForASlot(key)).value;
        } catch (Exception e) {
            return null;
        }

    }

    /**
     * Probes for a given key's slot until it finds it
     * Note: The NOT FOUND case cannot occur because the size of the table and the probe X number
     * are kept always relatively prime to each other
     *
     * @param key K
     * @return int
     */
    private int probeForASlot(K key) {
        Entry<K, V> entryToRetrieve = new Entry<>(key, null);
        int hash = getCleanHash(key);
        int index = hash;
        int x = 0;

        // We keep probing until we find an empty slot in the table
        while (table.get(index) != null && !table.get(index).isEqual(entryToRetrieve)) {
            index = (hash + Probe.linearProbing(x)) % this.capacity;
            x++;
        }

        return index;
    }

    /**
     * Probes for an empty slot 'Null slot' until it finds it.
     * If the table parameter will be given as Null, the current instance table will be used instead
     *
     * @param key   K
     * @param table ArrayList<Entry<K, V>>
     * @return int
     */
    private int probeForEmptySlot(K key, ArrayList<Entry<K, V>> table) {
        table = table == null ? this.table : table;
        int hash = getCleanHash(key);
        int index = hash;
        int x = 0;

        while (table.get(index) != null) {
            index = (hash + Probe.linearProbing(x)) % this.capacity;
            x++;
        }

        return index;
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
                int index = this.probeForEmptySlot(entry.key, newTable);
                newTable.set(index, entry);
            }
        }

        this.table = newTable;
        this.threshold = (int) (this.capacity * this.loadFactor);
    }
}
