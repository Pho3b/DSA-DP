package dsa_dp.data_structures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import dsa_dp.data_structures.sparse_table.SparseTable;
import dsa_dp.data_structures.sparse_table.SparseTableType;

import java.util.Arrays;

public class SparseTableTest {
    int[] primitiveArr = new int[]{4, 2, 3, 7, 1, 5, 3, 3, 9, 6, 7, -1, 4};
    Integer[] boxedArray = Arrays.stream(primitiveArr).boxed().toArray(Integer[]::new);

    @Test
    public void minSparseTableConstructionTest() {
        SparseTable<Integer> sparseTable = new SparseTable<>(boxedArray);

        Assertions.assertEquals("[[4, 2, 2, 1], [2, 2, 1, 1], [3, 3, 1, 1], [7, 1, 1, 1], [1, 1, 1, -1], [5, 3, 3, -1]," +
                " [3, 3, 3, null], [3, 3, 3, null], [9, 6, -1, null], [6, 6, -1, null], [7, -1, null, null]," +
                " [-1, -1, null, null], [4, null, null, null]]", sparseTable.toString());
    }

    @Test
    public void maxSparseTableConstructionTest() {
        SparseTable<Integer> sparseTable = new SparseTable<>(boxedArray, SparseTableType.MAX);

        Assertions.assertEquals("[[4, 4, 7, 7], [2, 3, 7, 9], [3, 7, 7, 9], [7, 7, 7, 9], [1, 5, 5, 9]," +
                " [5, 5, 9, 9], [3, 3, 9, null], [3, 9, 9, null], [9, 9, 9, null], [6, 7, 7, null]," +
                " [7, 7, null, null], [-1, 4, null, null], [4, null, null, null]]", sparseTable.toString());
    }

    @Test
    public void minRangeQueryTest() {
        SparseTable<Integer> sparseTable = new SparseTable<>(boxedArray, SparseTableType.MIN);

        Assertions.assertEquals(-1, sparseTable.rangeQuery(0, boxedArray.length - 1));
        Assertions.assertEquals(1, sparseTable.rangeQuery(0, 4));
        Assertions.assertEquals(6, sparseTable.rangeQuery(8, 10));
        Assertions.assertEquals(3, sparseTable.rangeQuery(5, 8));
        Assertions.assertEquals(-1, sparseTable.rangeQuery(10, 12));
    }

    @Test
    public void maxRangeQueryTest() {
        SparseTable<Integer> sparseTable = new SparseTable<>(boxedArray, SparseTableType.MAX);

        Assertions.assertEquals(9, sparseTable.rangeQuery(0, boxedArray.length - 1));
        Assertions.assertEquals(7, sparseTable.rangeQuery(0, 4));
        Assertions.assertEquals(9, sparseTable.rangeQuery(8, 10));
        Assertions.assertEquals(9, sparseTable.rangeQuery(5, 8));
        Assertions.assertEquals(7, sparseTable.rangeQuery(10, 12));
    }

    @Test
    public void rangeQueryIndexOutOfBoundsTest() {
        SparseTable<Integer> sparseTable = new SparseTable<>(boxedArray, SparseTableType.MIN);

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> sparseTable.rangeQuery(-11, 2));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> sparseTable.rangeQuery(2, 50));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> sparseTable.rangeQuery(390, 23));
    }

}
