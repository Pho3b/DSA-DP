package dsa_dp.algorithms;

import dsa_dp.Utils;
import dsa_dp.algorithms.sorting.SelectionSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class SelectionSortTest {
    SelectionSort selectionSort = new SelectionSort();


    @Test
    public void firstSortingTest() {
        ArrayList<Integer> temp = Utils.randomUnorderedIntegerList();
        selectionSort.sort(temp);

        for (int i = 0; i < temp.size() - 1; i++) {
            Assertions.assertTrue(temp.get(i) <= temp.get(i + 1));
        }
    }

    @Test
    public void secondSortingTest() {
        ArrayList<Integer> temp = Utils.randomUnorderedIntegerList();
        selectionSort.sort(temp);

        for (int i = 0; i < temp.size() - 1; i++) {
            Assertions.assertTrue(temp.get(i) <= temp.get(i + 1));
        }
    }

    @Test
    public void thirdSortingTest() {
        ArrayList<Integer> temp = Utils.randomUnorderedIntegerList();
        selectionSort.sort(temp);

        for (int i = 0; i < temp.size() - 1; i++) {
            Assertions.assertTrue(temp.get(i) <= temp.get(i + 1));
        }
    }
}
