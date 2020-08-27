package Studying.algorithms;

import Studying.UtilityClass;
import Studying.algorithms.searching.JumpSearch;
import org.junit.jupiter.api.Test;

public class JumpSearchTest {
    JumpSearch jumpSearch = new JumpSearch();

    @Test
    public void foundElementTest() {
        org.junit.Assert.assertEquals(this.jumpSearch.search(UtilityClass.defaultIntegerOrderedTestArr, -21), 0);
    }

    @Test
    public void notFoundElementTest() {
        org.junit.Assert.assertEquals(this.jumpSearch.search(UtilityClass.defaultIntegerOrderedTestArr, 100), -1);
    }

    @Test
    public void foundLastElementTest() {
        org.junit.Assert.assertEquals(this.jumpSearch.search(UtilityClass.defaultIntegerOrderedTestArr,
                1002),
                (UtilityClass.defaultIntegerOrderedTestArr.length - 1));
    }

    @Test
    public void foundFirstElementTest() {
        org.junit.Assert.assertEquals(this.jumpSearch.search(UtilityClass.defaultIntegerOrderedTestArr,
                -21),
                0);
    }

    @Test
    public void jumpSearchIncorrectTest() {
        org.junit.Assert.assertNotEquals(this.jumpSearch.search(UtilityClass.defaultIntegerOrderedTestArr, 3), 11);
    }
}
