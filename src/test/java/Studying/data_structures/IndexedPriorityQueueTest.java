package Studying.data_structures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import studying.data_structures.queue.IndexedPriorityQueue;


public class IndexedPriorityQueueTest {

    @Test
    public void pollAndSizeTest() {
        IndexedPriorityQueue<String, Integer> indexedPriorityQueue = new IndexedPriorityQueue<>();
        indexedPriorityQueue.insert("Anna", 3);
        indexedPriorityQueue.insert("Bella", 15);
        indexedPriorityQueue.insert("Carly", 11);
        indexedPriorityQueue.insert("Dylan", 17);
        indexedPriorityQueue.insert("Emily", 7);
        indexedPriorityQueue.insert("Fred", 9);
        indexedPriorityQueue.insert("George", 2);
        indexedPriorityQueue.insert("Henry", 1);
        indexedPriorityQueue.insert("Isaac", 6);
        indexedPriorityQueue.insert("James", 5);
        indexedPriorityQueue.insert("Kelly", 16);
        indexedPriorityQueue.insert("Laura", 4);
        indexedPriorityQueue.insert("Mary", 2);

        Assertions.assertEquals("Henry", indexedPriorityQueue.poll());
        Assertions.assertEquals(12 , indexedPriorityQueue.size());
        Assertions.assertEquals("George", indexedPriorityQueue.poll());
        Assertions.assertEquals("Mary", indexedPriorityQueue.poll());
        Assertions.assertEquals(10 , indexedPriorityQueue.size());
        Assertions.assertEquals("Anna", indexedPriorityQueue.poll());
        Assertions.assertEquals(9 , indexedPriorityQueue.size());
    }

    @Test
    public void removeTest() {
        IndexedPriorityQueue<String, Integer> indexedPriorityQueue = new IndexedPriorityQueue<>();
        indexedPriorityQueue.insert("Anna", 3);
        indexedPriorityQueue.insert("Bella", 15);
        indexedPriorityQueue.insert("Carly", 11);
        indexedPriorityQueue.insert("Dylan", 17);
        indexedPriorityQueue.insert("Emily", 7);
        indexedPriorityQueue.insert("Fred", 9);
        indexedPriorityQueue.insert("George", 2);
        indexedPriorityQueue.insert("Henry", 1);
        indexedPriorityQueue.insert("Isaac", 6);
        indexedPriorityQueue.insert("James", 5);
        indexedPriorityQueue.insert("Kelly", 16);
        indexedPriorityQueue.insert("Laura", 4);
        indexedPriorityQueue.insert("Mary", 2);

        Assertions.assertEquals(indexedPriorityQueue.size(), 13);
        Assertions.assertNotNull(indexedPriorityQueue.remove("George"));
        Assertions.assertNotNull(indexedPriorityQueue.remove("Mary"));
        Assertions.assertNotNull(indexedPriorityQueue.remove("Henry"));
        Assertions.assertEquals("Anna", indexedPriorityQueue.poll());
    }

    @Test
    public void updateTest() {
        IndexedPriorityQueue<String, Integer> indexedPriorityQueue = new IndexedPriorityQueue<>();
        indexedPriorityQueue.insert("Anna", 100);
        indexedPriorityQueue.insert("Bella", 15);
        indexedPriorityQueue.insert("Henry", 46);

        Assertions.assertTrue(indexedPriorityQueue.update("Anna", 10));
        Assertions.assertEquals(indexedPriorityQueue.poll(), "Anna");
        Assertions.assertTrue(indexedPriorityQueue.update("Bella", 50));
        Assertions.assertEquals(indexedPriorityQueue.poll(), "Henry");
        Assertions.assertEquals(indexedPriorityQueue.poll(), "Bella");
        Assertions.assertNull(indexedPriorityQueue.poll(), "Bella");
    }
}
