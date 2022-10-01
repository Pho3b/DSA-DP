package dsa_dp.algorithms;

import dsa_dp.Utils;
import dsa_dp.algorithms.searching.BinarySearch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinarySearchTest {
    BinarySearch binarySearch = new BinarySearch();

    @Test
    public void foundElementTest() {
        Assertions.assertEquals(2, this.binarySearch.search(Utils.orderedIntegerTestArray, 1));
        Assertions.assertEquals(3, this.binarySearch.search(Utils.orderedIntegerTestArray, 3));
        Assertions.assertEquals(4, this.binarySearch.search(Utils.orderedIntegerTestArray, 4));
        Assertions.assertEquals(5, this.binarySearch.search(Utils.orderedIntegerTestArray, 5));
        Assertions.assertEquals(0, this.binarySearch.search(Utils.orderedIntegerTestArray, -21));
        Assertions.assertEquals(
                Utils.orderedIntegerTestArray.length - 1,
                this.binarySearch.search(Utils.orderedIntegerTestArray, 1002)
        );
        Assertions.assertEquals(
                Utils.orderedIntegerTestArray.length - 2,
                this.binarySearch.search(Utils.orderedIntegerTestArray, 1000)
        );
        Assertions.assertEquals(
                Utils.orderedIntegerTestArray.length - 3,
                this.binarySearch.search(Utils.orderedIntegerTestArray, 123)
        );
    }

    @Test
    public void notFoundElementTest() {
        Assertions.assertEquals(-1, this.binarySearch.search(Utils.orderedIntegerTestArray, 100));
        Assertions.assertEquals(-1, this.binarySearch.search(Utils.orderedIntegerTestArray, 2000));
        Assertions.assertEquals(-1, this.binarySearch.search(Utils.orderedIntegerTestArray, -60));
        Assertions.assertEquals(-1, this.binarySearch.search(Utils.orderedIntegerTestArray, 32));
        Assertions.assertEquals(-1, this.binarySearch.search(Utils.orderedIntegerTestArray, 43));
    }
}
