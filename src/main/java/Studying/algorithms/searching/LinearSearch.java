package Studying.algorithms.searching;

/**
 * TIME COMPLEXITY
 * Best: O(1)
 * Average: O(n)
 * Worst: O(n)
 *
 * SPACE COMPLEXITY:
 * Worst: O(1)
 */
public class LinearSearch {

    public int search(int[] inputArr, int toSearch) {
        for (int i = 0; i < inputArr.length; i++) {
            if (inputArr[i] == toSearch) {
                return i;
            }
        }

        return -1;
    }
}
