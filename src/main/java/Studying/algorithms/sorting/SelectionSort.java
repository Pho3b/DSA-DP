package Studying.algorithms.sorting;

import java.util.ArrayList;

/**
 * TIME COMPLEXITY
 * Best: O(n^2)
 * Average: O(n^2)
 * Worst: O(n^2)
 *
 * SPACE COMPLEXITY:
 * Worst: O(1)
 */
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
