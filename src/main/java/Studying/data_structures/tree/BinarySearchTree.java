package Studying.data_structures.tree;

public class BinarySearchTree<T extends Comparable<T>> {
    private Node<T> root = null;


    public BinarySearchTree() {
    }

    public BinarySearchTree(T rootVal) {
        this.root = new Node<T>(rootVal);
    }

    /**
     * Inserts a new node in the BST, keeping the elements ordered
     *
     * @param value T
     */
    public void add(T value) {
        if (this.root == null) {
            this.root = new Node<>(value);
            return;
        }

        Node<T> currentNode = this.root;

        while (true) {
            if(currentNode.value.compareTo(value) >= 0) {
                if (currentNode.leftChild == null) {
                    currentNode.leftChild = new Node<>(value);
                    break;
                }

                currentNode = currentNode.leftChild;
            } else {
                if (currentNode.rightChild == null) {
                    currentNode.rightChild = new Node<>(value);
                    break;
                }

                currentNode = currentNode.rightChild;
            }
        }
    }

}
