package dsa_dp.algorithms;

import dsa_dp.algorithms.puzzle.MaxSubArraySum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MaxSubArraySumTest {
    MaxSubArraySum maxSubArraySum;


    public MaxSubArraySumTest() {
        this.maxSubArraySum = new MaxSubArraySum();
    }

    @Test
    public void correctMaxSubArraySequenceTest() {
        Assertions.assertEquals(6, maxSubArraySum.sequence(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        Assertions.assertEquals(33, maxSubArraySum.sequence(new int[]{-2, 30, -3, 4, -1, 2, 1, -5, 4}));
        Assertions.assertEquals(13, maxSubArraySum.sequence(new int[]{-2, 12, -3, 4, -1, -42, 1, -5, 4}));
    }

    @Test
    public void invalidInputArrayTest() {
        Assertions.assertEquals(0, maxSubArraySum.sequence(new int[]{}));
        Assertions.assertEquals(0, maxSubArraySum.sequence(new int[]{-1, -2, -10}));
    }
}
