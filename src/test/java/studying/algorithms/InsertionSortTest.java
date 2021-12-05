package studying.algorithms;

import studying.Utils;
import studying.algorithms.sorting.InsertionSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class InsertionSortTest {
    InsertionSort insertionSort = new InsertionSort();

    @Test
    public void firstSortingTest() {
        ArrayList<Integer> temp = Utils.randomUnorderedIntegerList();
        insertionSort.sort(temp);

        for (int i = 0; i < temp.size() - 1; i++) {
            Assertions.assertTrue(temp.get(i) <= temp.get(i + 1));
        }
    }

    @Test
    public void secondSortingTest() {
        ArrayList<Integer> temp = Utils.randomUnorderedIntegerList();
        insertionSort.sort(temp);

        for (int i = 0; i < temp.size() - 1; i++) {
            Assertions.assertTrue(temp.get(i) <= temp.get(i + 1));
        }
    }

    @Test
    public void thirdSortingTest() {
        ArrayList<Integer> temp = Utils.randomUnorderedIntegerList();
        insertionSort.sort(temp);

        for (int i = 0; i < temp.size() - 1; i++) {
            Assertions.assertTrue(temp.get(i) <= temp.get(i + 1));
        }
    }
}
