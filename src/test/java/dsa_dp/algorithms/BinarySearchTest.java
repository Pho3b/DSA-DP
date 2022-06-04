package dsa_dp.algorithms;

import dsa_dp.Utils;
import dsa_dp.algorithms.searching.BinarySearch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinarySearchTest {
    BinarySearch binarySearch = new BinarySearch();

    @Test
    public void foundElementTest() {
        Assertions.assertEquals(this.binarySearch.search(Utils.orderedIntegerTestArray, 1), 2);
    }

    @Test
    public void notFoundElementTest() {
        Assertions.assertEquals(this.binarySearch.search(Utils.orderedIntegerTestArray, 100), -1);
    }

    @Test
    public void foundLastElementTest() {
        Assertions.assertEquals(this.binarySearch.search(Utils.orderedIntegerTestArray, 1002),
                (Utils.orderedIntegerTestArray.length - 1));
    }

    @Test
    public void foundFirstElementTest() {
        Assertions.assertEquals(this.binarySearch.search(Utils.orderedIntegerTestArray, -21),0);
    }

    @Test
    public void jumpSearchIncorrectTest() {
        Assertions.assertNotEquals(this.binarySearch.search(Utils.orderedIntegerTestArray, 3), 11);
    }
}