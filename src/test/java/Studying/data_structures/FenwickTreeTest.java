package Studying.data_structures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import studying.data_structures.tree.FenwickTree;

import java.util.stream.IntStream;

public class FenwickTreeTest {
    int[] testArr = {0, 3, 4, -2, 7, 3, 11, 5, -8, -9, 2, 4, -8};

    @Test
    public void correctRangeQueryTest() {
        FenwickTree fenwickTree = new FenwickTree(testArr);

        Assertions.assertEquals(19, fenwickTree.rangeQuery(5, 7));
        Assertions.assertEquals(5, fenwickTree.rangeQuery(1, 3));
        Assertions.assertEquals(-4, fenwickTree.rangeQuery(11, 12));
        Assertions.assertEquals(26, fenwickTree.rangeQuery(4, 7));
    }

    @Test
    public void correctPrefixSumTest() {
        FenwickTree fenwickTree = new FenwickTree(testArr);

        Assertions.assertEquals(15, fenwickTree.prefixSum(5));
        Assertions.assertEquals(3, fenwickTree.prefixSum(1));
        Assertions.assertEquals(IntStream.of(testArr).sum(), fenwickTree.prefixSum(testArr.length - 1));
    }

    //TODO: Implements test for the add method
}
