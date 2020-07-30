package Studying.algorithms.sorting;

import java.util.ArrayList;

public class BubbleSort {

    public ArrayList<Integer> sort(ArrayList<Integer> inputArr) {
        boolean swapped = true;

        while (swapped) {
            swapped = false;

            for (int i = 0; i < inputArr.size(); i++) {
                if ( i != inputArr.size() - 1 && inputArr.get(i) > inputArr.get(i + 1)) {
                    swap(i, inputArr);
                    swapped = true;
                }
            }
        }

        return inputArr;
    }

    private void swap(int i, ArrayList<Integer> arr) {
        int first = arr.get(i);

        arr.set(i, arr.get(i + 1));
        arr.set(i + 1, first);
    }
}
