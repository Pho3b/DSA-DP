package Studying.algorithms;

import Studying.UtilityClass;
import Studying.algorithms.sorting.InsertionSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class InsertionSortTest {
    InsertionSort insertionSort = new InsertionSort();

    @Test
    public void correctSortingTest() {
        ArrayList<Integer> temp = UtilityClass.unorderedIntegerTestArrayList();
        insertionSort.sort(temp);

        for (int i = 0; i < temp.size() - 1; i++) {
            Assertions.assertTrue(temp.get(i) < temp.get(i + 1));
        }
    }
}
