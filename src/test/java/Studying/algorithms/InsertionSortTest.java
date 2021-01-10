package Studying.algorithms;

import Studying.UtilityClass;
import Studying.algorithms.sorting.InsertionSort;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class InsertionSortTest {
    InsertionSort insertionSort = new InsertionSort();

    @Test
    public void correctSortingTest() {
        ArrayList<Integer> temp = UtilityClass.unorderedIntegerTestArrayList();
        int size = temp.size();
        insertionSort.sort(temp);

        for (int i = 0; i < size - 1; i++) {
            org.junit.Assert.assertTrue(temp.get(i) < temp.get(i + 1));
        }
    }
}
