package studying.algorithms.sorting;

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
public class BubbleSort {

    public ArrayList<Integer> sort(ArrayList<Integer> arr) {
        boolean swapped = true;

        while (swapped) {
            swapped = false;

            for (int i = 0; i < arr.size(); i++) {
                if (i != arr.size() - 1 && arr.get(i) > arr.get(i + 1)) {
                    // Swapping values
                    int temp = arr.get(i);
                    arr.set(i, arr.get(i + 1));
                    arr.set(i + 1, temp);
                    swapped = true;
                }
            }
        }

        return arr;
    }
}
