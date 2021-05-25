package studying.data_structures.hash_table;

public class Entry<K, V> {
    public K key;
    public V value;
    public int hash;


    /**
     * Default constructor
     *
     * @param key   K
     * @param value V
     */
    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
        this.hash = key.hashCode();
    }

    /**
     * Returns whether an entry is equal to another or not
     * It first compares the two entry hashes and then they're keys
     *
     * @param entry Entry
     * @return boolean
     */
    public boolean isEqual(Entry<K, V> entry) {
        if (this.hash != entry.hash)
            return false;

        return this.key.equals(entry.key);
    }

    @Override
    public String toString() {
        return "{" +
                "key=" + key +
                ", value=" + value +
                ", hash=" + hash +
                '}';
    }
}
