package Studying.data_structures;

import studying.data_structures.stack.Stack;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StackTest {

    @Test
    public void correctTopAndPeekTest() {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(12);
        stack.push(32);
        stack.push(45);
        Assertions.assertEquals(stack.peek(), 45);
        stack.pop();
        Assertions.assertEquals(stack.top(), 32);
    }

    @Test
    public void correctPopTest() {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(12);
        stack.push(32);
        stack.push(45);

        Assertions.assertEquals(stack.pop(), 45);
        Assertions.assertEquals(stack.pop(), 32);
        Assertions.assertEquals(stack.pop(), 12);
        Assertions.assertEquals(stack.pop(), 10);
    }

    @Test
    public void correctSizeTest() {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(12);
        stack.push(32);
        stack.push(45);
        stack.push(45);
        stack.push(45);
        stack.push(45);

        Assertions.assertEquals(stack.size(), 7);
    }

    @Test
    public void incorrectSizeTest() {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(12);
        stack.push(32);
        stack.push(45);
        stack.push(45);
        stack.push(45);
        stack.push(45);

        Assertions.assertNotEquals(stack.size(), 4);
    }

    @Test
    public void correctIsEmptyTest() {
        Stack<Integer> stack = new Stack<>();
        Assertions.assertTrue(stack.isEmpty());
        stack.push(10);
        Assertions.assertFalse(stack.isEmpty());
    }
}
