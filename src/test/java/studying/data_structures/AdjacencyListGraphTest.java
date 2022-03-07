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
}
