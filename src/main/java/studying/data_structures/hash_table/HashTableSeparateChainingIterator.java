package studying.data_structures.hash_table;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Iterates through the given separate chaining hashTable parsing one line/bucket after the other starting
 * from the index zero
 *
 * @param <E>
 */
public class HashTableSeparateChainingIterator<E> implements Iterator<E> {
    private final ArrayList<LinkedList<E>> table;
    private int entryPointer, bucketPointer = 0;

    /**
     * Default constructor
     *
     * @param table ArrayList<LinkedList<E>>
     */
    HashTableSeparateChainingIterator(ArrayList<LinkedList<E>> table) {
        this.table = table;
    }

    /**
     * Returns the next entry object if the current iterator hasNext(),
     * otherwise it throws an indexOutOfBoundsException exception
     *
     * @return Entry object
     */
    @Override
    public E next() {
        if (this.hasNext()) {
            E entry = table.get(bucketPointer).get(entryPointer);
            entryPointer++;

            return entry;
        }

        throw new IndexOutOfBoundsException();
    }

    /**
     * Returns true if the current HashTable still have not null elements left
     *
     * @return boolean
     */
    @Override
    public boolean hasNext() {
        if (table.size() <= 0) return false;
        LinkedList<E> bucket = table.get(bucketPointer);

        while (bucket.size() <= 0 || entryPointer >= bucket.size()) {
            this.bucketPointer++;
            this.entryPointer = 0;

            if (bucketPointer <= table.size() - 1) {
                bucket = table.get(bucketPointer);
            } else {
                return false;
            }
        }

        return true;
    }

    @Override
    public void remove() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }
}
