package Studying.algorithms;

import Studying.UtilityClass;
import studying.algorithms.searching.JumpSearch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JumpSearchTest {
    JumpSearch jumpSearch = new JumpSearch();

    @Test
    public void foundElementTest() {
        Assertions.assertEquals(this.jumpSearch.search(UtilityClass.orderedIntegerTestArray, -21), 0);
    }

    @Test
    public void notFoundElementTest() {
        Assertions.assertEquals(this.jumpSearch.search(UtilityClass.orderedIntegerTestArray, 100), -1);
    }

    @Test
    public void foundLastElementTest() {
        Assertions.assertEquals(this.jumpSearch.search(UtilityClass.orderedIntegerTestArray,
                1002),
                (UtilityClass.orderedIntegerTestArray.length - 1));
    }

    @Test
    public void foundFirstElementTest() {
        Assertions.assertEquals(this.jumpSearch.search(UtilityClass.orderedIntegerTestArray,
                -21),
                0);
    }

    @Test
    public void jumpSearchIncorrectTest() {
        Assertions.assertNotEquals(this.jumpSearch.search(UtilityClass.orderedIntegerTestArray, 3), 11);
    }
}
