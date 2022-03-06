package studying;

import studying.data_structures.graph.AdjacencyMatrixGraph;

public class App {

    public static void main(String[] args) {
        System.out.println("This is your current operating system: " + System.getProperty("os.name") + "\n");
        currentWorkingOnIssueTest();
    }

    public static void currentWorkingOnIssueTest() {
        AdjacencyMatrixGraph graph = new AdjacencyMatrixGraph(6);
        graph.addEdge(0, 1, true);
        graph.addEdge(0, 4);
        graph.addEdge(0, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 5);

        System.out.println(graph.iterativeDfs(0));
    }
}
