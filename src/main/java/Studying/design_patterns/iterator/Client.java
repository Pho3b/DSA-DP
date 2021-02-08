package Studying.design_patterns.iterator;

import Studying.design_patterns.iterator.collections.BugCollection;
import Studying.design_patterns.iterator.collections.BugItem;
import Studying.design_patterns.iterator.iterators.FlyingBugIterator;
import Studying.design_patterns.iterator.iterators.GroundedBugsIterator;
import Studying.design_patterns.iterator.iterators.Iterator;

public class Client {
    Iterator[] bugIterators;


    public Client(BugCollection[] bugCollections) {
        FlyingBugIterator flyingBugIterator = (FlyingBugIterator) bugCollections[0].createIterator();
        GroundedBugsIterator groundedBugsIterator = (GroundedBugsIterator) bugCollections[1].createIterator();
        this.bugIterators = new Iterator[]{
                flyingBugIterator,
                groundedBugsIterator
        };
    }

    /**
     *  Cycles over various iterators without the need to know the actual
     *  logic of how to iterate over each of them.
     */
    public void printBugCollections() {
        for (Iterator iterator : this.bugIterators) {
            printBugCollection(iterator);
        }
    }

    private void printBugCollection(Iterator iterator) {
        while (iterator.hasNext()) {
            BugItem item = (BugItem) iterator.next();

            System.out.println("Bug Name: " + item.getName());
            System.out.println("Can Fly: " + item.canFly() + "\n");
        }
    }
}
