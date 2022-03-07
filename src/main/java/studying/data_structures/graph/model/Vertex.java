package studying.data_structures.graph.model;

public class Vertex {
    public int weight;
    private final int i;


    public Vertex(int index) {
        this(index, 0);
    }

    public Vertex(int index, int weight) {
        this.i = index;
        this.weight = weight;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Vertex)
            return this.i == ((Vertex) obj).i;

        return false;
    }
}
