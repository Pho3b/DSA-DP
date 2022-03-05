package studying;

import studying.data_structures.graph.AdjacencyMatrixGraph;

public class App {

    public static void main(String[] args) {
        System.out.println("This is your current operating system: " + System.getProperty("os.name") + "\n");
        currentWorkingOnIssueTest();
    }

    public static void currentWorkingOnIssueTest() {
        AdjacencyMatrixGraph graph = new AdjacencyMatrixGraph(5);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 3);
        graph.addEdge(4, 1);

        graph.print();
    }
}
