package studying.data_structures.tree;

import studying.data_structures.tree.iterators.InOrderIterator;
import studying.data_structures.tree.iterators.IterationType;

import java.util.Iterator;

public class BinarySearchTree<T extends Comparable<T>> implements Iterable<T> {
    private Node<T> root = null;


    public BinarySearchTree() {
    }

    public BinarySearchTree(T rootVal) {
        this.root = new Node<T>(rootVal);
    }

    /**
     * Inserts a new node in the BST, keeping the elements ordered
     * Duplicates are allowed
     *
     * @param value T
     */
    public void insert(T value) {
        if (this.root == null) {
            this.root = new Node<>(value);
            return;
        }

        Node<T> currentNode = this.root;

        while (true) {
            if (currentNode.value.compareTo(value) >= 0) {
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


    /**
     * The default returned iterator
     *
     * @return Iterator
     */
    @Override
    public Iterator<T> iterator() {
        return createIterator(IterationType.IN_ORDER);
    }

    /**
     * The client can choose which type of iteration to perform on
     * @param type IterationType
     * @return
     */
    public Iterator<T> createIterator(IterationType type) {
        switch (type) {
            case PRE_ORDER:
                break;
            case IN_ORDER:
                return new InOrderIterator<>(this);
            case POST_ORDER:
                break;
            case LEVEL_ORDER:
                break;

        }

        return new InOrderIterator<>(this);
    }
}
