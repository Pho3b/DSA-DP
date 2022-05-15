package studying.data_structures.graph.model;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Vertex implements Comparable<Vertex> {
    public final int i;
    public int weight;

    /**
     * Constructor with given index
     *
     * @param index The unique identifier of this vertex
     */
    public Vertex(int index) {
        this(index, 0);
    }

    /**
     * Constructor with given index and weight
     *
     * @param index  The unique identifier of this vertex
     * @param weight The weight to reach this node when used as the 'ending' vertex of an edge
     */
    public Vertex(int index, int weight) {
        this.i = index;
        this.weight = weight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(i, weight);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Vertex)
            return this.i == ((Vertex) obj).i;

        return false;
    }

    @Override
    public int compareTo(@NotNull Vertex otherVertex) {
        return Integer.compare(weight, otherVertex.weight);
    }
}
