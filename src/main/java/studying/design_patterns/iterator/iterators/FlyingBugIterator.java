package studying.design_patterns.iterator.iterators;

import studying.design_patterns.iterator.collections.BugItem;

import java.util.Arrays;

public class FlyingBugIterator implements Iterator {
    private int currentPosition = -1;
    public BugItem[] bugsCollection;


    public FlyingBugIterator(BugItem[] bugsCollection) {
        this.bugsCollection = bugsCollection;
        System.out.println(Arrays.toString(this.bugsCollection));
    }

    @Override
    public BugItem next() {
        if (this.hasNext()) {
            this.currentPosition++;
            return this.bugsCollection[currentPosition];
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public boolean hasNext() {
        return this.currentPosition < (this.bugsCollection.length - 1);
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
