package dsa_dp.algorithms.sorting;

import java.util.ArrayList;

/**
 * TIME COMPLEXITY
 * Best: O(n)
 * Average: O(n^2)
 * Worst: O(n^2)
 * <p>
 * SPACE COMPLEXITY:
 * Worst: O(1)
 */
public class InsertionSort<T extends Comparable<T>> {

    public ArrayList<T> sort(ArrayList<T> inputArr) {
        for (int i = 1; i < inputArr.size(); i++) {
            for (int j = i; j > 0; j--) {
                if (inputArr.get(j).compareTo(inputArr.get(j - 1)) < 0) {
                    // Swap
                    T temp = inputArr.get(j);
                    inputArr.set(j, inputArr.get(j - 1));
                    inputArr.set((j - 1), temp);
                } else {
                    break;
                }
            }
        }

        return inputArr;
    }
}
