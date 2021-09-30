package studying;


import studying.data_structures.heap.IndexedBinaryHeap;

public class App {

    public static void main(String[] args) {
        System.out.println("This is your current operating system: " + System.getProperty("os.name") +  "\n");
        currentWorkingOnIssueTest();
    }

    public static void currentWorkingOnIssueTest() {
        IndexedBinaryHeap<Integer> indexedBinaryHeap = new IndexedBinaryHeap<>();
        indexedBinaryHeap.insert(20);
        indexedBinaryHeap.insert(61);
        indexedBinaryHeap.insert(58);
        indexedBinaryHeap.insert(47);
        indexedBinaryHeap.insert(76);
        indexedBinaryHeap.insert(98);

        indexedBinaryHeap.print();
    }
}
