package studying.data_structures;

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

    @Test
    public void simplePositiveAddTest() {
        FenwickTree fenwickTree = new FenwickTree(testArr);

        Assertions.assertEquals(12, fenwickTree.rangeQuery(1, 4));
        fenwickTree.add(1, 3);
        Assertions.assertEquals(15, fenwickTree.rangeQuery(1, 4));
    }

    @Test
    public void simpleNegativeNumberUpdateTest() {
        FenwickTree fenwickTree = new FenwickTree(testArr);

        Assertions.assertEquals(12, fenwickTree.rangeQuery(1, 4));
        fenwickTree.add(1, -5);
        Assertions.assertEquals(7, fenwickTree.rangeQuery(1, 4));
        Assertions.assertEquals(-11, fenwickTree.rangeQuery(8, 11));
        fenwickTree.update(8, 8);
        fenwickTree.update(9, 9);
        Assertions.assertEquals(6, fenwickTree.rangeQuery(8, 11));
        fenwickTree.update(1, 7);
        fenwickTree.update(3, 2);
        fenwickTree.update(12, 8);
        Assertions.assertEquals(41, fenwickTree.rangeQuery(1, 12));
    }
}
