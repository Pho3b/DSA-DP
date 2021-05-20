package studying.data_structures.hash_table;

public class Entry<K, V> {
    public K key;
    public V value;
    public int hash;


    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
        this.hash = key.hashCode();
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
