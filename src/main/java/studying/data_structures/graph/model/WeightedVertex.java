package studying.data_structures.graph.model;

public class WeightedVertex {
    public int weight;
    public Vertex vertex;


    public WeightedVertex(Vertex vertex, int weight) {
        this.weight = weight;
        this.vertex = vertex;
    }
}
