package Studying.algorithms;

import Studying.algorithms.searching.LinearSearch;
import org.junit.jupiter.api.Test;

public class LinearSearchTest {
    @Test
    public void linearSearchFoundElementTest() {
        int[] testArr = new int[]{-21, -1, 1, 3, 4, 5, 6, 10, 11};
        LinearSearch linearSearch = new LinearSearch();

        org.junit.Assert.assertEquals(linearSearch.search(testArr, -21), 0);
    }

    @Test
    public void linearSearchNotFoundElementTest() {
        int[] testArr = new int[]{-21, -1, 1, 3, 4, 5, 6, 10, 11};
        LinearSearch linearSearch = new LinearSearch();

        org.junit.Assert.assertEquals(linearSearch.search(testArr, 100), -1);
    }

    @Test
    public void linearSearchIncorrectTest2() {
        int[] testArr = new int[]{-21, -1, 1, 3, 4, 5, 6, 10, 11};
        LinearSearch linearSearch = new LinearSearch();

        org.junit.Assert.assertNotEquals(linearSearch.search(testArr, 3), 11);
    }
}
