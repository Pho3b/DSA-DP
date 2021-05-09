package Studying.algorithms;

import Studying.UtilityClass;
import studying.algorithms.searching.BinarySearch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinarySearchTest {
    BinarySearch binarySearch = new BinarySearch();

    @Test
    public void foundElementTest() {
        Assertions.assertEquals(this.binarySearch.search(UtilityClass.orderedIntegerTestArray, 1), 2);
    }

    @Test
    public void notFoundElementTest() {
        Assertions.assertEquals(this.binarySearch.search(UtilityClass.orderedIntegerTestArray, 100), -1);
    }

    @Test
    public void foundLastElementTest() {
        Assertions.assertEquals(this.binarySearch.search(UtilityClass.orderedIntegerTestArray, 1002),
                (UtilityClass.orderedIntegerTestArray.length - 1));
    }

    @Test
    public void foundFirstElementTest() {
        Assertions.assertEquals(this.binarySearch.search(UtilityClass.orderedIntegerTestArray, -21),0);
    }

    @Test
    public void jumpSearchIncorrectTest() {
        Assertions.assertNotEquals(this.binarySearch.search(UtilityClass.orderedIntegerTestArray, 3), 11);
    }
}
