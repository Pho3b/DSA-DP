package Studying;

import Studying.algorithms.searching.LinearSearch;
import org.junit.jupiter.api.Test;


public class AppTest {
    @Test
    public void linearSearchCorrectTests() {
        int[] testArr = new int[]{-21, -1, 1, 3, 4, 5, 6, 10, 11};
        LinearSearch linearSearch = new LinearSearch();

        for (int i = 0; i < testArr.length; i++) {
            org.junit.Assert.assertEquals(linearSearch.search(testArr, testArr[i]), i);
        }
    }
}
