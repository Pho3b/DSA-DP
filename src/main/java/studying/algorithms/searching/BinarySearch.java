package studying.algorithms.searching;

import java.util.Arrays;

/**
 * TIME COMPLEXITY
 * Best: O(1)
 * Average: O(log n)
 * Worst: O(log n)
 *
 * SPACE COMPLEXITY:
 * Worst: O(1)
 */
public class BinarySearch {

    public int search(int[] inputArr, int toSearch) {
        Arrays.sort(inputArr);
        int top = inputArr.length - 1;
        int min = 0;
        int mid = top / 2;

        while (min <= top) {
            if (toSearch == inputArr[mid]) {
                return mid;
            } else if (toSearch < inputArr[mid]) {
                top = mid - 1;
            } else {
                min = mid + 1;
            }

            mid = (min + top) / 2;
        }

        return -1;
    }
}
