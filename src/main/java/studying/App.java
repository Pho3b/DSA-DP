package studying;


import studying.data_structures.queue.IndexedPriorityQueue;

public class App {

    public static void main(String[] args) {
        System.out.println("This is your current operating system: " + System.getProperty("os.name") +  "\n");
        currentWorkingOnIssueTest();
    }

    public static void currentWorkingOnIssueTest() {
        IndexedPriorityQueue<String, Integer> indexedPriorityQueue = new IndexedPriorityQueue<>();
        indexedPriorityQueue.insert("Porta", 98);
        indexedPriorityQueue.insert("Comodino", 58);
        indexedPriorityQueue.insert("Sedia", 20);
        indexedPriorityQueue.insert("Portone", 47);
        indexedPriorityQueue.insert("Carrello", 64);
        indexedPriorityQueue.insert("Vaso", 76);
        indexedPriorityQueue.insert("Tappeto", 61);
        indexedPriorityQueue.insert("Tavolo", 13);
        // indexedBinaryHeap.delete(64); // La chiave deve essere la stringa in questo caso

        indexedPriorityQueue.print();
    }
}
