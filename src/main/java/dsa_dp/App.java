package dsa_dp;

import dsa_dp.data_structures.graph.AdjacencyListGraph;

public class App {

    public static void main(String[] args) {
        System.out.println("This is your current operating system: " + System.getProperty("os.name") + "\n");
        currentWorkingOnIssueTest();
    }

    public static void currentWorkingOnIssueTest() {
        AdjacencyListGraph graph = new AdjacencyListGraph(5);
        graph.addWeightedEdge(0, 1, 4);
        graph.addWeightedEdge(0, 2, 1);
        graph.addWeightedEdge(2, 1, 2);
        graph.addWeightedEdge(1, 3, 1);
        graph.addWeightedEdge(3, 4, 3);
        graph.addWeightedEdge(2, 3, 5);

        System.out.println(graph.djikstraShortestPath(0, 3));
        System.out.println(graph.djikstraShortestPath(1, 0));
        System.out.println(graph.djikstraShortestPath(2, 4));
        System.out.println(graph.djikstraShortestPath(4, 3));
    }
}
