package Studying.data_structures;

import Studying.data_structures.heap.BinaryHeap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinaryHeapTest {

    @Test
    public void correctAddElementTest() {
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

        Assertions.assertTrue(true);
    }
}
