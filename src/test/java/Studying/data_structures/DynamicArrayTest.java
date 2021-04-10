package Studying.data_structures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DynamicArrayTest {

    @Test
    public void correctBasicArrayActionsTest() {
        DynamicArray<Integer> myArr = new DynamicArray<Integer>(2);
        myArr.push(12);
        myArr.push(13);
        myArr.push(26);
        Assertions.assertEquals(myArr.get(myArr.size() - 1), 26);

        myArr.pop();
        Assertions.assertEquals(myArr.get(myArr.size() - 1), 13);
    }

    @Test
    public void incorrectSizeTest() {
        DynamicArray<Integer> myArr = new DynamicArray<Integer>(5);
        myArr.push(100);
        myArr.push(22);
        myArr.push(16);
        Assertions.assertEquals(myArr.size(), 3);
    }
}
