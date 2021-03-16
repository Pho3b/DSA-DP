package Studying.algorithms;

import Studying.UtilityClass;
import Studying.algorithms.sorting.SelectionSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class SelectionSortTest {
    SelectionSort selectionSort = new SelectionSort();

    @Test
    public void correctSortingTest() {
        ArrayList<Integer> temp = UtilityClass.unorderedIntegerTestArrayList();
        selectionSort.sort(temp);

        for (int i = 0; i < temp.size() - 1; i++) {
            Assertions.assertTrue(temp.get(i) < temp.get(i + 1));
        }
    }
}
