package dsa_dp.data_structures.tree.model;

public class Node<T extends Comparable<T>> {
    public Node<T> left, right = null;
    public T value;


    public Node(T value) {
        this.value = value;
    }
}
