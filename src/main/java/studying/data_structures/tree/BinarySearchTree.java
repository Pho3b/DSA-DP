package studying.data_structures.tree;

import studying.data_structures.queue.Queue;
import studying.data_structures.tree.iterator.InOrderIterator;
import studying.data_structures.tree.enumerator.IterationType;
import studying.data_structures.tree.model.Node;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BinarySearchTree<T extends Comparable<T>> {
    public Node<T> root;
    private int nodesCount = 0;


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
        this.nodesCount++;
    }

    /**
     * Inserts a new node in the BST keeping the elements ordered, this method is iterative.
     * Duplicates are not allowed, if the tree already contains a value
     * the method will return false and the value won't be inserted
     *
     * @param value T
     * @return boolean
     */
    public boolean insert(T value) {
        if (this.root == null) {
            this.root = new Node<>(value);
            this.nodesCount++;

            return true;
        }

        Node<T> currentNode = this.root;

        while (true) {
            int comparison = currentNode.value.compareTo(value);

            if (comparison > 0) {
                if (currentNode.left == null) {
                    currentNode.left = new Node<>(value);
                    this.nodesCount++;

                    return true;
                }

                currentNode = currentNode.left;
            } else if (comparison < 0) {
                if (currentNode.right == null) {
                    currentNode.right = new Node<>(value);
                    this.nodesCount++;

                    return true;
                }

                currentNode = currentNode.right;
            } else {
                return false;
            }
        }
    }

    /**
     * Exposed delete method, it calls the internal recursive one to actually
     * remove the given node
     *
     * @param value T
     * @return boolean
     */
    public boolean delete(T value) {
        if (this.contains(value)) {
            root = this.delete(root, value);
            this.nodesCount--;

            return true;
        }

        return false;
    }

    /**
     * Breadth First Search
     * (We avoid keeping track of the already checked nodes here because BSTs don't contain loops)
     *
     * @return List
     */
    public List<T> levelOrderTraversal() {
        if (root == null)
            return new ArrayList<>();

        ArrayList<T> res = new ArrayList<>(this.nodesCount);
        Queue<Node<T>> queue = new Queue<>(this.nodesCount);
        queue.enqueue(this.root);

        while (!queue.isEmpty()) {
            Node<T> currentNode = queue.dequeue();
            res.add(currentNode.value);

            if (currentNode.left != null) queue.enqueue(currentNode.left);
            if (currentNode.right != null) queue.enqueue(currentNode.right);
        }

        return res;
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
        if (currentNode == null)
            return null;

        int comparison = value.compareTo(currentNode.value);

        if (comparison > 0) {
            // If the value to remove is greater than the current one, we search in the right subtree
            currentNode.right = delete(currentNode.right, value);
        } else if (comparison < 0) {
            // If the value to remove is less than the current one, we search in the left subtree
            currentNode.left = delete(currentNode.left, value);
        } else {
            // If the value to remove is equal to the current one, we have to manage 3 possible scenarios:
            // 1. Single child scenario
            // 2. No children scenario (Leaf node)
            if (currentNode.left == null) {
                Node<T> temp = currentNode.right;
                currentNode.right = null;

                return temp;
            } else if (currentNode.right == null) {
                Node<T> temp = currentNode.left;
                currentNode.left = null;

                return temp;
            } else {
                // 3. Two children scenario
                // Here we can decide to search for the minimum value of the right subtree OR the maximum value
                // of the left subtree and substitute the current node with the result
                Node<T> temp = findMin(currentNode.right);
                currentNode.value = temp.value; // swapping data
                this.delete(currentNode.right, temp.value);
            }
        }

        return currentNode;
    }

    /**
     * Returns the current height(Level of nodes) of the BST calculating it iteratively.
     * It calculates it using a levelOrderTraversal and keeping track of how many nodes we still
     * need to parse in the current Tree level.
     *
     * @return int
     */
    public int height() {
        if (this.root == null)
            return 0;

        int height = 0;
        Queue<Node<T>> queue = new Queue<>();
        queue.enqueue(this.root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            while (levelSize > 0) {
                Node<T> currentNode = queue.dequeue();

                if (currentNode.left != null) queue.enqueue(currentNode.left);
                if (currentNode.right != null) queue.enqueue(currentNode.right);
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
        if (root == null)
            return 0;

        return Math.max(depth(root.left), depth(root.right)) + 1;
    }

    /**
     * Given a root node it finds it's child with the minimum value and returns it
     *
     * @param currentRoot Node
     * @return Node
     */
    private Node<T> findMin(Node<T> currentRoot) {
        while (currentRoot.left != null) {
            currentRoot = currentRoot.left;
        }

        return currentRoot;
    }

    /**
     * Public print method that can be called by the user
     */
    public void print() {
        this.inorderTraversal(this.root);
        System.out.println();
    }

    /**
     * Traverse and prints the nodes of the current BST in "PRE_ORDER"
     * Depth First Search
     */
    private void preorderTraversal(Node<T> node) {
        if (node == null) return;

        System.out.print(node.value + " - ");
        inorderTraversal(node.left);
        inorderTraversal(node.right);
    }

    /**
     * Traverse and prints the nodes of the current BST in "IN_ORDER"
     * Depth First Search
     */
    private void inorderTraversal(Node<T> node) {
        if (node == null) return;

        inorderTraversal(node.left);
        System.out.print(node.value + " ");
        inorderTraversal(node.right);
    }

    /**
     * Traverse and prints the nodes of the current BST in "POST_ORDER"
     * Depth First Search
     */
    private void postOrderTraversal(Node<T> node) {
        if (node == null) return;

        inorderTraversal(node.left);
        inorderTraversal(node.right);
        System.out.print(node.value + " - ");
    }

    /**
     * Returns whether the binary search tree contains the given value or not
     *
     * @param value T
     * @return boolean
     */
    public boolean contains(T value) {
        Node<T> node = this.root;

        while (node != null) {
            int comparison = value.compareTo(node.value);

            if (comparison > 0) {
                node = node.right;
            } else if (comparison < 0) {
                node = node.left;
            } else {
                return true;
            }
        }

        return false;
    }

    /**
     * Returns the current number of nodes in the BST
     *
     * @return int
     */
    public int size() {
        return this.nodesCount;
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
