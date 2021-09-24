package studying.data_structures.tree.model;

public class AvlNode<T extends Comparable<T>> {
    public AvlNode<T> leftChild, rightChild = null;
    public int balanceFactor = 0;
    public int height = 0;
    public T value;


    public AvlNode(T value) {this.value = value;}
}
