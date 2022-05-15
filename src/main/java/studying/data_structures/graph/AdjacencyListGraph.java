package studying.data_structures.graph;

import org.checkerframework.checker.units.qual.A;
import studying.data_structures.graph.model.Vertex;
import studying.data_structures.queue.IndexedPriorityQueue;
import studying.data_structures.queue.Queue;

import java.util.*;

public class AdjacencyListGraph {
    private final static int VERTICES_NUMBER = 100;
    private final Map<Vertex, LinkedHashSet<Vertex>> adjacentMap;
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
        adjacentMap = new HashMap<>();

        for (int i = 0; i < verticesNumber; i++)
            adjacentMap.put(new Vertex(i), new LinkedHashSet<>());
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
        if (from > adjacentMap.size() || to > adjacentMap.size() || from == to)
            return false;

        Vertex vFrom = new Vertex(from);
        Vertex vTo = new Vertex(to);

        if (!adjacentMap.get(vFrom).contains(vTo)) {
            numberOfEdges++;
            adjacentMap.get(vFrom).add(vTo);
        }

        if (isUndirected && !adjacentMap.get(vTo).contains(vFrom)) {
            numberOfEdges++;
            adjacentMap.get(vTo).add(vFrom);
        }

        return true;
    }

    /**
     * Adds a new edge from the given 'from' vertex to the 'to' vertex
     * also assigns the given weight to it
     *
     * @param from   Starting vertex's edge
     * @param to     Ending vertex's edge
     * @param weight Edge weight
     * @return false if the given vertices outbounds the matrix size, true otherwise
     */
    public boolean addWeightedEdge(int from, int to, int weight) {
        if (from > adjacentMap.size() || to > adjacentMap.size() || from == to)
            return false;

        Vertex vFrom = new Vertex(from);
        Vertex vTo = new Vertex(to, weight);

        if (!adjacentMap.get(vFrom).contains(vTo)) {
            numberOfEdges++;
            adjacentMap.get(vFrom).add(vTo);
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

        if (adjacentMap.get(vFrom).contains(vTo)) {
            numberOfEdges--;
            adjacentMap.get(vFrom).remove(vTo);

            return true;
        }

        return false;
    }

    /**
     * Performs a Depth First Search on the graph starting from the given vertex
     *
     * @param v Starting vertex
     * @return List of connected vertices in order of visit
     */
    public ArrayList<Integer> iterativeDfs(int v) {
        if (v > adjacentMap.size()) throw new IndexOutOfBoundsException();

        ArrayList<Integer> res = new ArrayList<>(adjacentMap.size());
        boolean[] visited = new boolean[adjacentMap.size()];
        Stack<Integer> stack = new Stack<>();
        stack.push(v);

        while (!stack.isEmpty()) {
            v = stack.pop();

            if (!visited[v]) {
                visited[v] = true;
                res.add(v);

                for (Vertex adj : adjacentMap.get(new Vertex(v))) {
                    if (!visited[adj.i]) stack.push(adj.i);
                }
            }
        }

        return res;
    }

    /**
     * Performs a Breadth First Search on the graph starting from the given vertex
     *
     * @param v Starting vertex
     * @return List of connected vertices in order of visit
     */
    public ArrayList<Integer> iterativeBfs(int v) {
        if (v > adjacentMap.size()) throw new IndexOutOfBoundsException();

        ArrayList<Integer> res = new ArrayList<>(adjacentMap.size());
        boolean[] visited = new boolean[adjacentMap.size()];
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(v);
        visited[v] = true;

        while (!queue.isEmpty()) {
            v = queue.dequeue();
            LinkedHashSet<Vertex> neighbours = adjacentMap.get(new Vertex(v));
            res.add(v);

            for (Vertex adj : neighbours) {
                if (!visited[adj.i]) {
                    queue.enqueue(adj.i);
                    visited[adj.i] = true;
                }
            }
        }

        return res;
    }

    /**
     * Computes and returns the shortest path between the two given Vertices
     *
     * @param s Index of the Starting Vertex
     * @param e Index of the Ending vertex
     * @return An array containing the vertices that compose the shortest path from 's' to 'e' if the path is found,
     * an empty array otherwise
     */
    public ArrayList<Integer> shortestPath(int s, int e) {
        ArrayList<Integer> parent = new ArrayList<>(Collections.nCopies(adjacentMap.size(), null));
        boolean[] visited = new boolean[adjacentMap.size()];
        boolean found = false;
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(s);

        // Performing a BFS with early return in case the 'ending' vertex is found
        while (!queue.isEmpty()) {
            if (found) break;

            int v = queue.dequeue();
            LinkedHashSet<Vertex> neighbours = adjacentMap.get(new Vertex(v));

            for (Vertex neighbour : neighbours) {
                if (!visited[neighbour.i]) {
                    queue.enqueue(neighbour.i);
                    visited[neighbour.i] = true;
                    parent.set(neighbour.i, v);

                    if (neighbour.i == e) {
                        found = true;
                        break;
                    }
                }
            }
        }

        if (found) {
            return this.reconstructPath(e, parent);
        }

        return new ArrayList<>();
    }

    /**
     * Computes (if it exists) the shortest path from vertex 'from' to vertex 'to'
     *
     * @param from starting vertex
     * @param to   ending vertex
     * @return An array containing the vertices that compose the shortest path from 's' to 'e' if the path is found,
     * an empty array otherwise
     */
    public ArrayList<Integer> djikstraShortestPath(int from, int to) {
        boolean[] visited = new boolean[adjacentMap.size()];
        IndexedPriorityQueue<Integer, Integer> iPriorityQueue = new IndexedPriorityQueue<>();
        ArrayList<Integer> parent = new ArrayList<>(Collections.nCopies(adjacentMap.size(), null));
        int[] dist = new int[adjacentMap.size()];
        boolean found = false;

        Arrays.fill(dist, Integer.MAX_VALUE);
        iPriorityQueue.insert(from, 0);
        dist[from] = 0;

        while (iPriorityQueue.size() > 0) {
            Vertex currentV = new Vertex(iPriorityQueue.poll());
            visited[currentV.i] = true;

            for (Vertex v : adjacentMap.get(currentV)) {
                if (visited[v.i]) continue;
                int newDist = dist[currentV.i] + v.weight;

                if (newDist < dist[v.i]) {
                    dist[v.i] = newDist;

                    if (!iPriorityQueue.contains(v.i))
                        iPriorityQueue.insert(v.i, newDist);
                    else
                        iPriorityQueue.update(v.i, newDist);

                    parent.set(v.i, currentV.i);

                    if (v.i == to)
                        found = true;
                }
            }
        }

        return found
                ? this.reconstructPath(to, parent)
                : new ArrayList<>();
    }

    /**
     * Eager implementation of the Dijkstra's algorithm
     *
     * @param from index of the starting vertex
     * @return An array of distances from the given vertex to all the other graph vertices,
     * res[vertexI] = (distance from starting vertex)
     */
    public int[] djikstra(int from) {
        boolean[] visited = new boolean[adjacentMap.size()];
        IndexedPriorityQueue<Integer, Integer> iPriorityQueue = new IndexedPriorityQueue<>();
        int[] dist = new int[adjacentMap.size()];
        Arrays.fill(dist, Integer.MAX_VALUE);
        iPriorityQueue.insert(from, 0);
        dist[from] = 0;

        while (iPriorityQueue.size() > 0) {
            Vertex currentV = new Vertex(iPriorityQueue.poll());
            visited[currentV.i] = true;

            for (Vertex v : adjacentMap.get(currentV)) {
                if (visited[v.i]) continue;
                int newDist = dist[currentV.i] + v.weight;

                if (newDist < dist[v.i]) {
                    dist[v.i] = newDist;

                    if (!iPriorityQueue.contains(v.i))
                        iPriorityQueue.insert(v.i, newDist);
                    else
                        iPriorityQueue.update(v.i, newDist);
                }
            }
        }

        return dist;
    }

    /**
     * Populates the given path array with the vertices that compose the path,
     * it also calls a reverse method to make it more readable
     *
     * @param at   The vertex from which it starts to iterate the path in reverse
     * @param prev The list containing the parent vertices
     * @return path The list containing all the path vertices
     */
    private ArrayList<Integer> reconstructPath(int at, ArrayList<Integer> prev) {
        ArrayList<Integer> path = new ArrayList<>();
        path.add(at);

        while (prev.get(at) != null) {
            at = prev.get(at);
            path.add(at);
        }

        return this.reverse(path);
    }

    /**
     * Utility function to reverse an ArrayList in place
     *
     * @param list The list to reverse
     * @return the reversed list
     */
    private ArrayList<Integer> reverse(ArrayList<Integer> list) {
        int left = 0;
        int right = list.size() - 1;

        while (left < right) {
            int temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);

            left++;
            right--;
        }

        return list;
    }

}
