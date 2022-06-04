package dsa_dp.algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import dsa_dp.Utils;
import dsa_dp.algorithms.sorting.MergeSort;

import java.util.ArrayList;

public class MergeSortTest {
    MergeSort<Integer> ms = new MergeSort<>();

    @Test
    public void firstSortingTest() {
        ArrayList<Integer> temp = Utils.randomUnorderedIntegerList();
        ms.sort(temp);

        for (int i = 0; i < temp.size() - 1; i++) {
            Assertions.assertTrue(temp.get(i) <= temp.get(i + 1));
        }
    }

    @Test
    public void secondSortingTest() {
        ArrayList<Integer> temp = Utils.randomUnorderedIntegerList();
        ms.sort(temp);

        for (int i = 0; i < temp.size() - 1; i++) {
            Assertions.assertTrue(temp.get(i) <= temp.get(i + 1));
        }
    }

    @Test
    public void thirdSortingTest() {
        ArrayList<Integer> temp = Utils.randomUnorderedIntegerList();
        ms.sort(temp);

        for (int i = 0; i < temp.size() - 1; i++) {
            Assertions.assertTrue(temp.get(i) <= temp.get(i + 1));
        }
    }
}
