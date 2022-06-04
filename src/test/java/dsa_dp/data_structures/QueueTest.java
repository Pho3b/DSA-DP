package dsa_dp.data_structures;

import dsa_dp.data_structures.queue.Queue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QueueTest {

    @Test
    public void correctEnqueueTest() {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(12);
        queue.enqueue(32);

        Assertions.assertEquals(queue.size(), 2);
    }

    @Test
    public void correctDequeueTest() {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(12);
        queue.enqueue(32);

        Assertions.assertEquals(queue.dequeue(), 12);
        Assertions.assertEquals(queue.size(), 1);
    }

    @Test
    public void correctMaxSizeReachedTest() {
        Queue<Integer> queue = new Queue<>(4);
        queue.enqueue(12);
        queue.enqueue(32);
        queue.enqueue(7);
        queue.enqueue(65);
        Assertions.assertTrue(queue.isFull());

        queue.dequeue();
        Assertions.assertFalse(queue.isFull());
    }

    @Test
    public void correctPeekTest() {
        Queue<Integer> queue = new Queue<>(4);
        queue.enqueue(12);
        queue.enqueue(123);
        Assertions.assertEquals(queue.peek(), 12);

        queue.print();
        queue.dequeue();
        queue.print();
        Assertions.assertEquals(queue.peek(), 123);
    }
}
