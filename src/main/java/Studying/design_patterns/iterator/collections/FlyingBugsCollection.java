package Studying.design_patterns.iterator.collections;

import Studying.design_patterns.iterator.iterators.FlyingBugIterator;
import Studying.design_patterns.iterator.iterators.Iterator;

public class FlyingBugsCollection implements BugCollection {
    String[] flyingBugNames = new String[]{"Ant Queen", "Bee", "Fly", "Mosquito", "DragonFly"};
    BugItem[] bugsCollection;


    public FlyingBugsCollection() {
        this.initCollection();
    }

    @Override
    public Iterator createIterator() {
        return new FlyingBugIterator(this.bugsCollection);
    }

    private void initCollection() {
        int counter = 0;
        this.bugsCollection = new BugItem[5];

        for (String bugName : flyingBugNames) {
            this.bugsCollection[counter] = new BugItem(bugName, (counter + 5), true);
            counter++;
        }
    }
}
