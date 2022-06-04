package dsa_dp.data_structures.tree.iterator;

import dsa_dp.data_structures.tree.BinarySearchTree;

import java.util.Iterator;

public class InOrderIterator<T extends Comparable<T>> implements Iterator<T> {

    public InOrderIterator(BinarySearchTree<T> binarySearchTree) {

    }


    @Override
    public T next() {
        return null;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public void remove() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }
}
