package dsa_dp.algorithms;

import dsa_dp.algorithms.puzzle.ClockWiseSpiral;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class ClockWiseSpiralTest {
    ClockWiseSpiral cws;


    public ClockWiseSpiralTest() {
        this.cws = new ClockWiseSpiral();
    }

    @Test
    public void correctSpiralGenerationsTest() {
        Assertions.assertArrayEquals(new int[][]{{1, 2, 3}, {8, 9, 4}, {7, 6, 5}}, cws.createSpiral(3));
        Assertions.assertArrayEquals(new int[][]{{1, 2}, {4, 3}}, cws.createSpiral(2));
        Assertions.assertArrayEquals(new int[][]{
                {1, 2, 3, 4},
                {12, 13, 14, 5},
                {11, 16, 15, 6},
                {10, 9, 8, 7}
        }, cws.createSpiral(4));
    }

    @Test
    public void incorrectSpiralGenerationsTest() {
        Assertions.assertNotEquals(new int[][]{{1, 2, 3}, {8, 9, 4}, {7, 6, 5}}, cws.createSpiral(5));
        Assertions.assertNotEquals(new int[][]{{1, 2}, {4, 3}}, cws.createSpiral(1));
        Assertions.assertNotEquals(new int[][]{
                {1, 2, 3, 4},
                {12, 13, 14, 5},
                {11, 16, 15, 6},
                {10, 9, 8, 7}
        }, cws.createSpiral(10));
    }

    @Test
    public void invalidMatrixLengthGivenTest() {
        Assertions.assertArrayEquals(new int[][]{}, cws.createSpiral(0));
        Assertions.assertArrayEquals(new int[][]{}, cws.createSpiral(-10));
    }
}
