package studying.data_structures.tree;

public class AvlNode<T extends Comparable<T>> extends Node<T> {
    public AvlNode<T> leftChild, rightChild = null;
    public int height, balanceFactor = 0;


    public AvlNode(T value) {
        super(value);
    }
}
