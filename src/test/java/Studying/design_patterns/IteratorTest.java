package Studying.design_patterns;

import Studying.design_patterns.iterator.Client;
import Studying.design_patterns.iterator.collections.BugCollection;
import Studying.design_patterns.iterator.collections.FlyingBugsCollection;
import Studying.design_patterns.iterator.collections.GroundedBugsCollection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IteratorTest {

    @Test
    public void factoryGeneratedObjectNameTest() {
        BugCollection[] bugCollections = new BugCollection[]{new FlyingBugsCollection(), new GroundedBugsCollection()};
        Client client = new Client(bugCollections);

        client.printBugCollections();

        Assertions.assertTrue(true);
    }
}
