package Studying.algorithms.sorting;

import java.util.ArrayList;

public class InsertionSort {

    public ArrayList<Integer> sort(ArrayList<Integer> inputArr) {
        for (int i = 1; i < inputArr.size(); i++) {
            for (int j = i; j > 0; j--) {
                if (inputArr.get(j) < inputArr.get(j - 1)) {
                    // Swap
                    int temp = inputArr.get(j);
                    inputArr.set(j, inputArr.get(j - 1));
                    inputArr.set((j - 1), temp);
                }
            }
        }

        return inputArr;
    }
}
