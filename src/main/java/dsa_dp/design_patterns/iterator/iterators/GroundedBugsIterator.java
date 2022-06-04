package dsa_dp.design_patterns.iterator.iterators;

import dsa_dp.design_patterns.iterator.collections.BugItem;

import java.util.ArrayList;

public class GroundedBugsIterator implements Iterator {
    public final ArrayList<BugItem> collection;
    private int currentPosition = -1;


    public GroundedBugsIterator(ArrayList<BugItem> collection) {
        this.collection = collection;
    }

    @Override
    public BugItem next() {
        if (this.hasNext()) {
            this.currentPosition++;
            return this.collection.get(currentPosition);
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public boolean hasNext() {
        return this.currentPosition < (this.collection.size() - 1);
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
