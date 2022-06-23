package dsa_dp.algorithms.puzzle;

public class MaxSubArraySum {

    /**
     * Computes the maximum sum of a contiguous subsequence in the given array of integers.
     *
     * @param arr input array of integers
     * @return the maximum possible sum or 0 if the input array is empty
     */
    public int sequence(int[] arr) {
        if (arr.length < 1)
            return 0;

        int sum = 0;
        int maxSum = 0;

        for (int i : arr) {
            if (i > (sum + i)) {
                sum = i;
            } else {
                sum += i;
            }

            if (sum > maxSum)
                maxSum = sum;
        }

        return maxSum;
    }
}
