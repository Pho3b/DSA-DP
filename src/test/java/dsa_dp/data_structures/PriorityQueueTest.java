package dsa_dp.data_structures;

import dsa_dp.data_structures.queue.PriorityQueue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PriorityQueueTest {

    @Test
    public void correctEnqueueTest() {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.enqueue(12);
        priorityQueue.enqueue(32);
        priorityQueue.enqueue(2);
        priorityQueue.enqueue(3);

        Assertions.assertEquals(priorityQueue.peek(), 2);
    }

    @Test
    public void correctDequeueTest() {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.enqueue(12);
        priorityQueue.enqueue(32);
        priorityQueue.enqueue(2);
        priorityQueue.enqueue(3);
        priorityQueue.dequeue();

        Assertions.assertEquals(priorityQueue.dequeue(), 3);
    }

    @Test
    public void correctRemoveTest() {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.enqueue(12);
        priorityQueue.enqueue(32);
        priorityQueue.enqueue(2);
        priorityQueue.enqueue(3);

        Assertions.assertEquals(priorityQueue.remove(32), 32);
        Assertions.assertNull(priorityQueue.remove(32));
    }

    @Test
    public void correctContainsTest() {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.enqueue(12);
        priorityQueue.enqueue(32);
        priorityQueue.enqueue(2);
        priorityQueue.enqueue(3);
        priorityQueue.enqueue(5);
        priorityQueue.enqueue(2003);

        priorityQueue.print();
        Assertions.assertTrue(priorityQueue.contains(5));
        Assertions.assertTrue(priorityQueue.contains(2003));
        Assertions.assertFalse(priorityQueue.contains(50000));
    }
}
