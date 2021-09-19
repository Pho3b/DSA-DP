package studying.data_structures.tree;

public class AvlNode<T extends Comparable<T>> extends Node<T> {
    public short height = 0;


    public AvlNode(T value) {
        super(value);
    }
}
