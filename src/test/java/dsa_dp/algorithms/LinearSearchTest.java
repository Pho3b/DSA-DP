package dsa_dp.algorithms;

import dsa_dp.algorithms.searching.LinearSearch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LinearSearchTest {
    int[] testArr = new int[]{-21, -1, 1, 3, 4, 5, 6, 10, 11};
    LinearSearch linearSearch = new LinearSearch();

    @Test
    public void linearSearchFoundElementTest() {
        Assertions.assertEquals(this.linearSearch.search(testArr, -21), 0);
    }

    @Test
    public void linearSearchNotFoundElementTest() {
        Assertions.assertEquals(this.linearSearch.search(testArr, 100), -1);
    }

    @Test
    public void linearSearchIncorrectTest() {
        Assertions.assertNotEquals(this.linearSearch.search(testArr, 3), 11);
    }
}
