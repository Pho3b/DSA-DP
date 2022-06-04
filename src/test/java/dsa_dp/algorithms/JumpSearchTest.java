package dsa_dp.algorithms;

import dsa_dp.Utils;
import dsa_dp.algorithms.searching.JumpSearch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JumpSearchTest {
    JumpSearch jumpSearch = new JumpSearch();

    @Test
    public void foundElementTest() {
        Assertions.assertEquals(this.jumpSearch.search(Utils.orderedIntegerTestArray, -21), 0);
    }

    @Test
    public void notFoundElementTest() {
        Assertions.assertEquals(this.jumpSearch.search(Utils.orderedIntegerTestArray, 100), -1);
    }

    @Test
    public void foundLastElementTest() {
        Assertions.assertEquals(this.jumpSearch.search(Utils.orderedIntegerTestArray,
                1002),
                (Utils.orderedIntegerTestArray.length - 1));
    }

    @Test
    public void foundFirstElementTest() {
        Assertions.assertEquals(this.jumpSearch.search(Utils.orderedIntegerTestArray,
                -21),
                0);
    }

    @Test
    public void jumpSearchIncorrectTest() {
        Assertions.assertNotEquals(this.jumpSearch.search(Utils.orderedIntegerTestArray, 3), 11);
    }
}
