package dsa_dp.algorithms;

import dsa_dp.Utils;
import dsa_dp.algorithms.searching.JumpSearch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JumpSearchTest {
    JumpSearch jumpSearch = new JumpSearch();

    @Test
    public void foundElementTest() {
        Assertions.assertEquals(2, this.jumpSearch.search(Utils.orderedIntegerTestArray, 1));
        Assertions.assertEquals(3, this.jumpSearch.search(Utils.orderedIntegerTestArray, 3));
        Assertions.assertEquals(4, this.jumpSearch.search(Utils.orderedIntegerTestArray, 4));
        Assertions.assertEquals(5, this.jumpSearch.search(Utils.orderedIntegerTestArray, 5));
        Assertions.assertEquals(6, this.jumpSearch.search(Utils.orderedIntegerTestArray, 6));
        Assertions.assertEquals(7, this.jumpSearch.search(Utils.orderedIntegerTestArray, 10));
        Assertions.assertEquals(0, this.jumpSearch.search(Utils.orderedIntegerTestArray, -21));
        Assertions.assertEquals(
                Utils.orderedIntegerTestArray.length - 1,
                this.jumpSearch.search(Utils.orderedIntegerTestArray, 1002)
        );
        Assertions.assertEquals(
                Utils.orderedIntegerTestArray.length - 2,
                this.jumpSearch.search(Utils.orderedIntegerTestArray, 1000)
        );
        Assertions.assertEquals(
                Utils.orderedIntegerTestArray.length - 3,
                this.jumpSearch.search(Utils.orderedIntegerTestArray, 123)
        );
    }

    @Test
    public void notFoundElementTest() {
        Assertions.assertEquals(-1, this.jumpSearch.search(Utils.orderedIntegerTestArray, 100));
        Assertions.assertEquals(-1, this.jumpSearch.search(Utils.orderedIntegerTestArray, 2000));
        Assertions.assertEquals(-1, this.jumpSearch.search(Utils.orderedIntegerTestArray, -60));
        Assertions.assertEquals(-1, this.jumpSearch.search(Utils.orderedIntegerTestArray, 32));
        Assertions.assertEquals(-1, this.jumpSearch.search(Utils.orderedIntegerTestArray, 43));
    }
}
