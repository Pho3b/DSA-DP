package studying.data_structures.tree.model;

public class Node<T extends Comparable<T>> {
    public Node<T> leftChild, rightChild = null;
    public T value;


    public Node(T value) {
        this.value = value;
    }
}
