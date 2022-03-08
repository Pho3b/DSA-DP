package studying.data_structures.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class AdjacencyMatrixGraph {
    private final static int VERTICES_NUMBER = 100;
    private final int[][] matrix;
    public int numberOfEdges = 0;


    /**
     * Default constructor
     */
    public AdjacencyMatrixGraph() {
        this(VERTICES_NUMBER);
    }

    /**
     * Constructor with a given number of vertices
     *
     * @param verticesNumber The starting vertices number of the Graph
     */
    public AdjacencyMatrixGraph(int verticesNumber) {
        matrix = new int[verticesNumber][verticesNumber];
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
        if (from > matrix.length || to > matrix.length || from == to)
            return false;

        if (matrix[from][to] == 0) {
            numberOfEdges++;
            matrix[from][to] = 1;
        }

        if (isUndirected && matrix[to][from] == 0) {
            numberOfEdges++;
            matrix[to][from] = 1;
        }

        return true;
    }

    /**
     * Removes and existing edge from the graph
     *
     * @param from Starting vertex's edge
     * @param to   Ending vertex's edge
     * @return false if the given edge does not exist, true otherwise
     */
    public boolean removeEdge(int from, int to) {
        if (matrix[from][to] > 0) {
            numberOfEdges--;
            matrix[from][to] = 0;

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
        if (matrix[from][to] > 0) {
            matrix[from][to] = weight;
            return true;
        }

        return false;
    }

    /**
     * Performs a depth first search on the graph starting from the given vertex
     *
     * @param v Starting vertex
     * @return List of connected vertices in order of visit
     */
    public ArrayList<Integer> iterativeDfs(int v) {
        if (v > matrix.length)
            throw new IndexOutOfBoundsException();

        ArrayList<Integer> res = new ArrayList<>(matrix.length);
        boolean[] visited = new boolean[matrix.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(v);

        while (!stack.isEmpty()) {
            v = stack.pop();

            if (!visited[v]) {
                visited[v] = true;
                res.add(v);

                for (int i = 0; i < matrix[v].length; i++) {
                    if (matrix[v][i] > 0 && !visited[i])
                        stack.add(i);
                }
            }
        }

        return res;
    }

    /**
     * Performs a depth first search using recursion starting from the given vertex
     *
     * @param v Starting vertex
     * @return List of connected vertices in order of visit
     */
    public ArrayList<Integer> recursiveDfs(int v) {
        if (v > matrix.length)
            throw new IndexOutOfBoundsException();

        ArrayList<Integer> res = new ArrayList<>(matrix.length);
        boolean[] visited = new boolean[matrix.length];

        depthFirstSearch(v, visited, res);
        return res;
    }

    /**
     * Prints the graph in a visually comprehensible format
     *
     * @return The string conversion of the graph
     */
    public String print() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > 0) {
                    System.out.println(i + " ---> " + j + "   weight: " + matrix[i][j]);
                }
            }
        }

        return Arrays.deepToString(matrix);
    }

    /**
     * Internal method that performs the DFS in a recursive fashion
     *
     * @param v       Starting vertex
     * @param visited Array of booleans needed to check whether a vertex has already been visited or not
     * @param res     Array containing the resulting visited vertices in order of visit
     */
    private void depthFirstSearch(int v, boolean[] visited, ArrayList<Integer> res) {
        if (!visited[v]) {
            visited[v] = true;
            res.add(v);

            for (int i = 0; i < matrix.length; i++) {
                if (matrix[v][i] > 0 && !visited[i])
                    depthFirstSearch(i, visited, res);
            }
        }
    }
}
