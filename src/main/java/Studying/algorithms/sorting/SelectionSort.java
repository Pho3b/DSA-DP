package Studying.algorithms.sorting;

import java.util.ArrayList;

public class SelectionSort {

    public ArrayList<Integer> sort(ArrayList<Integer> inputArr) {
        int lowestIndex;

        for (int j = 0; j < inputArr.size(); j++) {
            lowestIndex = j;

            for (int i = j; i < inputArr.size(); i++) {
                if (inputArr.get(i) <= inputArr.get(lowestIndex)) {
                    lowestIndex = i;
                }
            }

            int temp = inputArr.get(lowestIndex);
            inputArr.set(lowestIndex, inputArr.get(j));
            inputArr.set(j, temp);
        }

        return inputArr;
    }
}
