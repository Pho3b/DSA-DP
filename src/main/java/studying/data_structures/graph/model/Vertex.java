package studying.data_structures.graph.model;

import java.util.Objects;

public class Vertex {
    public final int i;


    /**
     * Constructor with given index
     *
     * @param index The unique identifier of this vertex
     */
    public Vertex(int index) {
        this.i = index;
    }

    @Override
    public int hashCode() {
        return Objects.hash(i);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Vertex)
            return this.i == ((Vertex) obj).i;

        return false;
    }
}
