package studying.data_structures.tree;

import studying.data_structures.queue.Queue;
import studying.data_structures.tree.iterators.InOrderIterator;
import studying.data_structures.tree.iterators.IterationType;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BinarySearchTree<T extends Comparable<T>> {
    private Node<T> root = null;
    private int nodesNumber = 0;


    /**
     * Default constructor that generates an empty BST
     */
    public BinarySearchTree() {
    }

    /**
     * Constructor with given root node value
     *
     * @param rootVal T
     */
    public BinarySearchTree(T rootVal) {
        this.root = new Node<>(rootVal);
        this.nodesNumber++;
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
            this.nodesNumber++;
            return true;
        }

        Node<T> currentNode = this.root;

        while (true) {
            int comparison = currentNode.value.compareTo(value);

            if (comparison > 0) {
                if (currentNode.leftChild == null) {
                    currentNode.leftChild = new Node<>(value);
                    this.nodesNumber++;
                    return true;
                }

                currentNode = currentNode.leftChild;
            } else if (comparison < 0) {
                if (currentNode.rightChild == null) {
                    currentNode.rightChild = new Node<>(value);
                    this.nodesNumber++;
                    return true;
                }

                currentNode = currentNode.rightChild;
            } else {
                return false;
            }
        }
    }

    public boolean delete(T value) {
        if (this.contains(value)) {
            root = this.delete(root, value);
            this.nodesNumber--;
            return true;
        }

        return false;
    }

    /**
     * Returns whether the binary search tree contains the given value or not
     * returns true, if it contains it.
     *
     * @param value T
     * @return boolean
     */
    public boolean contains(T value) {
        Node<T> currentNode = this.root;

        while (currentNode != null) {
            int comparison = value.compareTo(currentNode.value);

            if (comparison > 0) {
                currentNode = currentNode.rightChild;
            } else if (comparison < 0) {
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
        this.inorderTraversal(this.root);
        System.out.println();
    }

    /**
     * Breadth First Search
     * (We avoid keeping track of the already checked nodes here because BST cannot contain loops)
     *
     * @return List
     */
    public List<T> levelOrderTraversal() {
        ArrayList<T> res = new ArrayList<>(this.nodesNumber);
        Queue<Node<T>> queue = new Queue<>(this.nodesNumber);
        queue.enqueue(this.root);

        while (!queue.isEmpty()) {
            Node<T> currentNode = queue.dequeue();
            res.add(currentNode.value);
            System.out.print(currentNode.value + " ");

            if (currentNode.leftChild != null)
                queue.enqueue(currentNode.leftChild);

            if (currentNode.rightChild != null)
                queue.enqueue(currentNode.rightChild);
        }

        System.out.println();
        return res;
    }

    /**
     * Traverse and prints the nodes of the current BST in "PRE_ORDER"
     * Depth First Search
     */
    private void preorderTraversal(Node<T> node) {
        if (node == null) return;

        System.out.print(node.value + " - ");
        inorderTraversal(node.leftChild);
        inorderTraversal(node.rightChild);
    }

    /**
     * Traverse and prints the nodes of the current BST in "IN_ORDER"
     * Depth First Search
     */
    private void inorderTraversal(Node<T> node) {
        if (node == null) return;

        inorderTraversal(node.leftChild);
        System.out.print(node.value + " ");
        inorderTraversal(node.rightChild);
    }

    /**
     * Traverse and prints the nodes of the current BST in "POST_ORDER"
     * Depth First Search
     */
    private void postOrderTraversal(Node<T> node) {
        if (node == null) return;

        inorderTraversal(node.leftChild);
        inorderTraversal(node.rightChild);
        System.out.print(node.value + " - ");
    }

    /**
     * Private recursive method that removes a node from the BST structure,
     * it starts to search for the node to delete from the given 'currentNode'
     *
     * @param currentNode Node
     * @param value       T
     * @return Node
     */
    private Node<T> delete(Node<T> currentNode, T value) {
        if (currentNode == null) return null;

        int comparison = value.compareTo(currentNode.value);

        if (comparison > 0) {
            // If the value to remove is greater than the current one, we search in the right subtree
            currentNode.rightChild = delete(currentNode.rightChild, value);
        } else if (comparison < 0) {
            // If the value to remove is less than the current one, we search in the left subtree
            currentNode.leftChild = delete(currentNode.leftChild, value);
        } else {
            // If the value to remove is equal to the current one, we have to manage 3 possible scenarios:
            // 1. Single child scenario
            // 2. No children scenario (Leaf node)
            if (currentNode.leftChild == null) {
                Node<T> temp = currentNode.rightChild;
                currentNode.rightChild = null;

                return temp;
            } else if (currentNode.rightChild == null) {
                Node<T> temp = currentNode.leftChild;
                currentNode.leftChild = null;

                return temp;
            } else {
                // 3. Two children scenario
                // Here we can decide to search for the minimum value of the right subtree OR the maximum value
                // of the left subtree and substitute the current node with the result
                Node<T> temp = findMin(currentNode.rightChild);
                currentNode.value = temp.value; // swapping data
                this.delete(currentNode.rightChild, temp.value);
            }
        }

        return currentNode;
    }

    /**
     * Returns the current height(Level of nodes) of the BST, with an iterative calculation.
     * We calculate it using a levelOrderTraversal style and keeping track of how many nodes we still
     * need to parse in the current Tree level.
     *
     * @return int
     */
    public int height() {
        if (this.root == null) return 0;

        Queue<Node<T>> queue = new Queue<>(this.nodesNumber);
        queue.enqueue(this.root);
        int height = 0;
        int levelSize;

        while (!queue.isEmpty()) {
            levelSize = queue.size();

            while (levelSize > 0) {
                Node<T> currentNode = queue.dequeue();

                if (currentNode.leftChild != null) {
                    queue.enqueue(currentNode.leftChild);
                }

                if (currentNode.rightChild != null) {
                    queue.enqueue(currentNode.rightChild);
                }

                levelSize--;
            }

            height++;
        }

        return height;
    }

    /**
     * Public method to let the client call the recursive method to calculate the depth of the current BST
     *
     * @return int
     */
    public int depth() {
        return depth(this.root);
    }

    /**
     * Calculates and returns the depth/height of the Binary Tree in a recursive way
     *
     * @param root Node
     * @return int
     */
    private int depth(Node<T> root) {
        if (root == null) return 0;

        int left = depth(root.leftChild);
        int right = depth(root.rightChild);

        return Math.max(left, right) + 1;
    }

    /**
     * Returns the current number of nodes in the BST
     *
     * @return int
     */
    public int size() {
        return this.nodesNumber;
    }

    /**
     * Given a root node it finds it's child with the minimum value and returns it
     *
     * @param currentRoot Node
     * @return Node
     */
    private Node<T> findMin(Node<T> currentRoot) {
        while (currentRoot.leftChild != null) {
            currentRoot = currentRoot.leftChild;
        }

        return currentRoot;
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
