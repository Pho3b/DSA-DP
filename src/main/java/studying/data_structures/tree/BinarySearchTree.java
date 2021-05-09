package studying.data_structures.tree;

import studying.data_structures.tree.iterators.InOrderIterator;
import studying.data_structures.tree.iterators.IterationType;

import java.util.Iterator;

public class BinarySearchTree<T extends Comparable<T>> {
    private Node<T> root = null;


    public BinarySearchTree() {
    }

    public BinarySearchTree(T rootVal) {
        this.root = new Node<T>(rootVal);
    }

    /**
     * Inserts a new node in the BST keeping the elements ordered, this method is iterative.
     * Duplicates are not allowed allowed, if the tree already contains a value
     * the method will return false and the value won't be inserted
     *
     * @param value T
     * @return boolean
     */
    public boolean insert(T value) {
        if (this.root == null) {
            this.root = new Node<>(value);
            return true;
        }

        Node<T> currentNode = this.root;

        while (true) {
            if (currentNode.value.compareTo(value) > 0) {
                if (currentNode.leftChild == null) {
                    currentNode.leftChild = new Node<>(value);
                    return true;
                }

                currentNode = currentNode.leftChild;
            } else if (currentNode.value.compareTo(value) < 0) {
                if (currentNode.rightChild == null) {
                    currentNode.rightChild = new Node<>(value);
                    return true;
                }

                currentNode = currentNode.rightChild;
            } else {
                return false;
            }
        }
    }

    public T delete(T value) {
        return null;
    }

    /**
     * Returns true whether the binary search tree contains the given value or not
     *
     * @param value T
     * @return boolean
     */
    public boolean contains(T value) {
        Node<T> currentNode = this.root;

        while (currentNode != null) {
            if (value.compareTo(currentNode.value) > 0) {
                currentNode = currentNode.rightChild;
            } else if (value.compareTo(currentNode.value) < 0) {
                currentNode = currentNode.leftChild;
            } else {
                return true;
            }
        }

        return false;
    }

    /**
     * Public print method that can be called by the user
     */
    public void print() {
        this.print(this.root);
    }

    /**
     * Private recursive print method
     * Prints the current BST in "IN_ORDER" fashion
     */
    private void print(Node<T> node) {
        if (node == null) return;

        print(node.leftChild);
        System.out.print(node.value + " - ");
        print(node.rightChild);
    }


    //TODO: Implement the four types of traversal iteratively
    public Iterator<T> createIterator(IterationType type) {
        switch (type) {
            case IN_ORDER:
                return new InOrderIterator<>(this);
            case PRE_ORDER:
            case POST_ORDER:
            case LEVEL_ORDER:
                break;
        }

        return new InOrderIterator<>(this);
    }
}
