package Studying.data_structures;

import studying.data_structures.heap.BinaryHeap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinaryHeapTest {

    @Test
    public void correctPeekTest() {
        BinaryHeap<Integer> binaryHeap = new BinaryHeap<>(20);
        binaryHeap.insert(1);
        binaryHeap.insert(5);
        binaryHeap.insert(12);
        binaryHeap.insert(8);
        binaryHeap.insert(6);
        binaryHeap.insert(13);
        binaryHeap.insert(19);
        binaryHeap.insert(13);
        binaryHeap.insert(12);
        binaryHeap.insert(11);
        binaryHeap.insert(7);
        binaryHeap.insert(14);

        Assertions.assertEquals(binaryHeap.peek(), 1);
    }

    @Test
    public void correctRemoveTest() {
        BinaryHeap<Integer> binaryHeap = new BinaryHeap<>(20);
        binaryHeap.insert(1);
        binaryHeap.insert(5);
        binaryHeap.insert(12);
        binaryHeap.insert(8);
        binaryHeap.insert(6);
        binaryHeap.insert(13);
        binaryHeap.insert(19);
        binaryHeap.insert(13);
        binaryHeap.insert(12);
        binaryHeap.insert(11);
        binaryHeap.insert(7);
        binaryHeap.insert(14);

        Assertions.assertEquals(binaryHeap.remove(1), 1);
        Assertions.assertEquals(binaryHeap.peek(), 5);
    }
}
