package studying.design_patterns.iterator.collections;

import studying.design_patterns.iterator.iterators.GroundedBugsIterator;
import studying.design_patterns.iterator.iterators.Iterator;

import java.util.ArrayList;

public class GroundedBugsCollection implements BugCollection {
    String[] flyingBugNames = new String[]{"Ant", "Centipede", "Beetle", "Spider", "Snail", "Worm"};
    public ArrayList<BugItem> bugCollection;


    public GroundedBugsCollection() {
        this.initCollection();
    }

    @Override
    public Iterator createIterator() {
        return new GroundedBugsIterator(this.bugCollection);
    }

    private void initCollection() {
        this.bugCollection = new ArrayList<>(flyingBugNames.length);

        for (int i = 0; i < flyingBugNames.length; i++) {
            this.bugCollection.add(i, new BugItem(this.flyingBugNames[i], 3, false));
        }
    }
}
