package Studying.algorithms;

import Studying.UtilityClass;
import Studying.algorithms.searching.BinarySearch;
import org.junit.jupiter.api.Test;

public class BinarySearchTest {
    BinarySearch binarySearch = new BinarySearch();

    @Test
    public void foundElementTest() {
        org.junit.Assert.assertEquals(this.binarySearch.search(UtilityClass.orderedIntegerTestArray, 1), 2);
    }

    @Test
    public void notFoundElementTest() {
        org.junit.Assert.assertEquals(this.binarySearch.search(UtilityClass.orderedIntegerTestArray, 100), -1);
    }

    @Test
    public void foundLastElementTest() {
        org.junit.Assert.assertEquals(this.binarySearch.search(UtilityClass.orderedIntegerTestArray, 1002),
                (UtilityClass.orderedIntegerTestArray.length - 1));
    }

    @Test
    public void foundFirstElementTest() {
        org.junit.Assert.assertEquals(this.binarySearch.search(UtilityClass.orderedIntegerTestArray,
                -21),
                0);
    }

    @Test
    public void jumpSearchIncorrectTest() {
        org.junit.Assert.assertNotEquals(this.binarySearch.search(UtilityClass.orderedIntegerTestArray, 3), 11);
    }
}
