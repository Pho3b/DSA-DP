package studying;


import studying.data_structures.queue.IndexedPriorityQueue;

public class App {

    public static void main(String[] args) {
        System.out.println("This is your current operating system: " + System.getProperty("os.name") +  "\n");
        currentWorkingOnIssueTest();
    }

    public static void currentWorkingOnIssueTest() {
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
        indexedPriorityQueue.poll();

        indexedPriorityQueue.print();
    }
}
