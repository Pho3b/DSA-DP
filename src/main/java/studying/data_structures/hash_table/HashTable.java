package studying.data_structures.hash_table;

public abstract class HashTable<K, V> {
    protected int size, capacity, threshold;
    protected float loadFactor;


    /**
     * Setter for the loadFactor property.
     * Must be a value between 0.0 and 1.0, otherwise an exception is thrown
     *
     * @param loadFactor float
     */
    protected void setLoadFactor(float loadFactor) {
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
    protected int getCleanHash(K key) {
        int hash = key.hashCode() % this.capacity;
        return hash > 0 ? hash : hash * -1;
    }

    /**
     * Returns the current number of elements inside the table
     *
     * @return int
     */
    public int size() {
        return this.size;
    }

    /**
     * Returns the current internal table capacity (capacity)
     *
     * @return int
     */
    public int capacity() {
        return this.capacity;
    }

    abstract public void add(K key, V value);

    abstract public V get(K key);

    abstract public boolean put(K key, V value);

    abstract public boolean remove(K key);

    abstract public void print();
}
