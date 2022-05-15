package studying.data_structures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import studying.data_structures.graph.AdjacencyListGraph;

public class AdjacencyListGraphTest {

    @Test
    public void numberOfEdgesTest() {
        AdjacencyListGraph graph = new AdjacencyListGraph(5);
        Assertions.assertEquals(0, graph.numberOfEdges);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4, true);
        graph.addEdge(4, 1);
        Assertions.assertEquals(6, graph.numberOfEdges);

        graph.removeEdge(4, 1);
        graph.removeEdge(4, 1);
        Assertions.assertEquals(5, graph.numberOfEdges);

        graph.removeEdge(4, 2);
        Assertions.assertEquals(5, graph.numberOfEdges);

        graph.addEdge(4, 2);
        graph.addEdge(4, 4);
        Assertions.assertEquals(6, graph.numberOfEdges);
    }

    @Test
    public void iterativeDepthFirstSearchTest() {
        AdjacencyListGraph graph = new AdjacencyListGraph(5);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4, true);
        graph.addEdge(4, 1);
        Assertions.assertEquals("[0, 1, 2, 3, 4]", graph.iterativeDfs(0).toString());

        graph = new AdjacencyListGraph(6);
        graph.addEdge(0, 1, true);
        graph.addEdge(0, 4);
        graph.addEdge(0, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 5);
        Assertions.assertEquals("[0, 2, 3, 5, 4, 1]", graph.iterativeDfs(0).toString());
        Assertions.assertEquals("[4]", graph.iterativeDfs(4).toString());
        Assertions.assertEquals("[2, 3, 5]", graph.iterativeDfs(2).toString());
    }

    @Test
    public void iterativeBreadthFirstSearchTest() {
        AdjacencyListGraph graph = new AdjacencyListGraph(13);
        graph.addEdge(0, 9);
        graph.addEdge(0, 11);
        graph.addEdge(0, 7);
        graph.addEdge(9, 8);
        graph.addEdge(9, 10);
        graph.addEdge(7, 3);
        graph.addEdge(7, 6);
        graph.addEdge(7, 11);
        graph.addEdge(10, 1);
        graph.addEdge(8, 1);
        graph.addEdge(8, 12);
        graph.addEdge(6, 5);
        graph.addEdge(3, 2);
        graph.addEdge(3, 4);
        graph.addEdge(12, 2);

        Assertions.assertEquals("[0, 9, 11, 7, 8, 10, 3, 6, 1, 12, 2, 4, 5]", graph.iterativeBfs(0).toString());
    }

    @Test
    public void shortestPathTest() {
        AdjacencyListGraph graph = new AdjacencyListGraph(8);
        graph.addEdge(0, 4);
        graph.addEdge(0, 3);
        graph.addEdge(0, 7);
        graph.addEdge(7, 3);
        graph.addEdge(7, 2);
        graph.addEdge(7, 1);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);
        graph.addEdge(6, 1);
        graph.addEdge(1, 7);
        graph.addEdge(1, 6);
        Assertions.assertEquals("[0, 4, 5, 6]", graph.shortestPath(0, 6).toString());
        Assertions.assertEquals("[0, 7]", graph.shortestPath(0, 7).toString());
        Assertions.assertEquals("[0, 7, 2]", graph.shortestPath(0, 2).toString());
        Assertions.assertEquals("[0, 7, 1]", graph.shortestPath(0, 1).toString());
        Assertions.assertEquals("[0, 3]", graph.shortestPath(0, 3).toString());
        Assertions.assertEquals("[]", graph.shortestPath(3, 1).toString());
        Assertions.assertEquals("[]", graph.shortestPath(2, 7).toString());
        Assertions.assertEquals("[]", graph.shortestPath(2, 2).toString());

        graph.addEdge(7, 6);
        Assertions.assertEquals("[0, 4, 5]", graph.shortestPath(0, 5).toString());
        Assertions.assertEquals("[0, 7, 6]", graph.shortestPath(0, 6).toString());
    }

    @Test
    public void djikstraTest() {
        AdjacencyListGraph graph = new AdjacencyListGraph(5);
        graph.addWeightedEdge(0, 1, 4);
        graph.addWeightedEdge(0, 2, 1);
        graph.addWeightedEdge(2, 1, 2);
        graph.addWeightedEdge(1, 3, 1);
        graph.addWeightedEdge(3, 4, 3);
        graph.addWeightedEdge(2, 3, 5);
        Assertions.assertArrayEquals(new int[]{0, 3, 1, 4, 7}, graph.djikstra(0));

//        AdjacencyListGraph graph1 = new AdjacencyListGraph(6);
//        graph1.addWeightedEdge(0, 2, 1);
//        graph1.addWeightedEdge(2, 1, 2);
//        graph1.addWeightedEdge(1, 3, 1);
//        graph1.addWeightedEdge(3, 4, 3);
//        graph1.addWeightedEdge(2, 3, 5);
//        graph1.addWeightedEdge(4, 5, 2);
//        graph1.addWeightedEdge(1, 5, 10);
//        Assertions.assertArrayEquals(new int[]{0, 3, 1, 4, 7, 9}, graph1.djikstra(0));
    }
}
