package studying.data_structures.hash_table;

public class HashTableOpenAddressing<K, V> extends HashTable<K, V> {
    private static final int DEFAULT_CAPACITY = 22;
    private static final float DEFAULT_LOAD_FACTOR = 0.6f;


    /**
     * Default constructor
     */
    HashTableOpenAddressing() {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    /**
     * Constructor with given capacity
     *
     * @param capacity int
     */
    HashTableOpenAddressing(int capacity) {
        this(capacity, DEFAULT_LOAD_FACTOR);
    }

    /**
     * Constructor with given capacity and load factor
     *
     * @param capacity   int
     * @param loadFactor float
     */
    HashTableOpenAddressing(int capacity, float loadFactor) {
        this.capacity = capacity;
    }

    @Override
    public void add(K key, V value) {

    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public boolean put(K key, V value) {
        return false;
    }

    @Override
    public boolean remove(K key) {
        return false;
    }

    @Override
    public void print() {

    }
}
