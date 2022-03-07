package studying.data_structures.graph;

import studying.data_structures.graph.model.Vertex;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class AdjacencyListGraph {
    private final static int VERTICES_NUMBER = 100;
    private final Map<Vertex, LinkedHashSet<Vertex>> map;
    public int numberOfEdges = 0;


    /**
     * Default constructor
     */
    public AdjacencyListGraph() {
        this(VERTICES_NUMBER);
    }

    /**
     * Constructor with a given number of vertices
     *
     * @param verticesNumber The starting vertices number of the Graph
     */
    public AdjacencyListGraph(int verticesNumber) {
        map = new HashMap<>();

        for (int i = 0; i < verticesNumber; i++)
            map.put(new Vertex(i), new LinkedHashSet<>());
    }

    /**
     * Adds a new vertex to the graph, the index of the new graph must be unique
     *
     * @param vertexIndex The index that will be applied to the new vertex (Must be unique)
     * @return True if the given index is not already contained in the graph, false otherwise
     */
    public boolean addVertex(int vertexIndex) {
        if (map.containsKey(new Vertex(vertexIndex)))
            return false;

        map.put(new Vertex(vertexIndex), new LinkedHashSet<>());
        return true;
    }

    /**
     * Adds a new edge from the given 'from' vertex to the 'to' vertex
     *
     * @param from Starting vertex's edge
     * @param to   Ending vertex's edge
     * @return false if the given vertices outbounds the matrix size, true otherwise
     */
    public boolean addEdge(int from, int to) {
        return this.addEdge(from, to, false);
    }

    /**
     * Adds a new edge from the given 'from' vertex to the 'to' vertex, it also
     * adds the reverse edge if the 'isUndirected' param is given true
     *
     * @param from         Starting vertex's edge
     * @param to           Ending vertex's edge
     * @param isUndirected Decides whether to add the reverse edge or not
     * @return false if the given vertices outbounds the matrix size, true otherwise
     */
    public boolean addEdge(int from, int to, boolean isUndirected) {
        if (from > map.size() || to > map.size() || from == to)
            return false;

        Vertex vFrom = new Vertex(from);
        Vertex vTo = new Vertex(to);

        if (map.get(vFrom).contains(vTo)) {
            numberOfEdges++;
            map.get(vFrom).add(vTo);
        }

        if (isUndirected && map.get(vTo).contains(vFrom)) {
            numberOfEdges++;
            map.get(vTo).add(vFrom);
        }

        return true;
    }

    /**
     * Removes and existing edge from the graph
     *
     * @param from Starting vertex's edge
     * @param to   Ending vertex's edge
     * @return False if the given edge does not exist, true otherwise
     */
    public boolean removeEdge(int from, int to) {
        Vertex vFrom = new Vertex(from);
        Vertex vTo = new Vertex(to);

        if (map.get(vFrom).contains(vTo)) {
            numberOfEdges--;
            map.get(vFrom).remove(vTo);

            return true;
        }

        return false;
    }

    /**
     * Updates the weight of an existing edge
     *
     * @param from   Starting vertex's edge
     * @param to     Ending vertex's edge
     * @param weight Edge's weight
     * @return false if the given edge does not exist, true otherwise
     */
    public boolean putEdgeWeight(int from, int to, int weight) {
        Vertex vFrom = new Vertex(from);
        Vertex vTo = new Vertex(to);

        if (map.get(vFrom).contains(vTo)) {
            for (Vertex v : map.get(vFrom)) {
                if (v.equals(vTo)) {
                    v.weight = weight;
                    return true;
                }
            }
        }

        return false;
    }
}
