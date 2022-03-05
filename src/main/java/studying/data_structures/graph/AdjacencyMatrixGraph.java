package studying.data_structures.graph;

public class AdjacencyMatrixGraph {
    private final static int VERTICES_NUMBER = 100;
    private final int[][] matrix;


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
        if (from > matrix.length || to > matrix.length)
            return false;

        if (isUndirected)
            matrix[to][from] = 1;

        matrix[from][to] = 1;
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
    public boolean putWeightedEdge(int from, int to, int weight) {
        if (matrix[from][to] > 0) {
            matrix[from][to] = weight;
            return true;
        }

        return false;
    }

    /**
     * Prints the graph in a comprehensible format
     */
    public void print() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > 0) {
                    System.out.println(i + " ---> " + j + "   weight: " + matrix[i][j]);
                }
            }
        }
    }
}
