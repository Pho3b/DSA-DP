package studying.data_structures.tree;

import studying.data_structures.queue.Queue;
import studying.data_structures.tree.model.AvlNode;

import java.util.ArrayList;
import java.util.List;

public class AvlTree<T extends Comparable<T>> {
    private int nodesCount = 0;
    private AvlNode<T> root;


    /**
     * Default constructor
     */
    public AvlTree() {
    }

    /**
     * Constructor with given root node value
     *
     * @param rootValue T
     */
    public AvlTree(T rootValue) {
        this.root = new AvlNode<>(rootValue);
        this.nodesCount++;
    }

    /**
     * Public method to insert a new Node inside the tree.
     * Duplicates are not allowed, the method will return true or false whether
     * the new node has been correctly added or not.
     *
     * @return boolean
     */
    public boolean insert(T value) {
        int currentNodesCount = nodesCount;
        this.root = this.insert(this.root, value);

        return (currentNodesCount < nodesCount);
    }

    /**
     * Breadth First Search
     *
     * @return List
     */
    public List<T> levelTraversal() {
        ArrayList<T> res = new ArrayList<>(this.nodesCount);
        Queue<AvlNode<T>> queue = new Queue<>(this.nodesCount);
        queue.enqueue(this.root);

        while (!queue.isEmpty()) {
            AvlNode<T> currentNode = queue.dequeue();
            res.add(currentNode.value);

            if (currentNode.leftChild != null)
                queue.enqueue(currentNode.leftChild);

            if (currentNode.rightChild != null)
                queue.enqueue(currentNode.rightChild);
        }

        return res;
    }

    /**
     * Returns whether the binary search tree contains the given value or not
     *
     * @param value T
     * @return boolean
     */
    public boolean contains(T value) {
        AvlNode<T> currentNode = this.root;

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
     * Returns the current number of nodes in the BST
     *
     * @return int
     */
    public int size() {
        return this.nodesCount;
    }

    /**
     * Public print method that can be called by the user
     */
    public void print() {
        this.inorderTraversal(this.root);
        System.out.println();
    }

    /**
     * Private recursive method that actually inserts a new node inside the tree
     *
     * @param node Node
     * @return boolean
     */
    private AvlNode<T> insert(AvlNode<T> node, T newValue) {
        if (node == null) {
            nodesCount++;
            return new AvlNode<>(newValue);
        }

        if (newValue.compareTo(node.value) > 0) {
            node.rightChild = insert(node.rightChild, newValue);
        } else if (newValue.compareTo(node.value) < 0) {
            node.leftChild = insert(node.leftChild, newValue);
        } else if (newValue.compareTo(node.value) == 0) {
            // Checking the equal case because we don't want to recalculate
            // the height or the balance in this occurrence
            return node;
        }

        updateHeight(node);
        updateBalance(node);

        return node;
    }

    /**
     * Update the height property of the given Node
     *
     * @param node AvlNode
     */
    private void updateHeight(AvlNode<T> node) {
        node.height = 1 + Math.max(height(node.leftChild), height(node.rightChild));
    }

    /**
     * Update the balance factor property of the given Node and calls the correct rotation methods if needed.
     * The balance factor is given by the difference between the right subtree and the left subtree's height
     *
     * @param node AvlNode
     */
    private void updateBalance(AvlNode<T> node) {
        node.balanceFactor = height(node.rightChild) - height(node.leftChild);

        // Controllo se il balance factor è 2 o -2, in uno di questi due casi controllo quale dei quattro casi
        // possibili di sbilanciamento è presente nell'albero al momento
    }

    /**
     * Utility method that retrieves the height of a given Node in the Tree
     * Height of X is calculated as the number of edges between X and the furthest Leaf Node.
     *
     * @return int
     */
    private int height(AvlNode<T> node) {
        if (node == null)
            return 0;

        return node.height;
    }

    /**
     * Performed in the 'left heavy' case
     */
    private void rightRotation(AvlNode<T> node) {

    }

    /**
     * Performed in the 'right heavy' case
     */
    private void leftRotation() {

    }

    /**
     * Traverse and prints the nodes of the current BST in "PRE_ORDER"
     * Depth First Search
     */
    private void preorderTraversal(AvlNode<T> node) {
        if (node == null) return;

        System.out.print(node.value + ":" + node.height + ":" + node.balanceFactor + " ");
        inorderTraversal(node.leftChild);
        inorderTraversal(node.rightChild);
    }

    /**
     * Traverse and prints the nodes of the current BST in "IN_ORDER"
     * Depth First Search
     */
    private void inorderTraversal(AvlNode<T> node) {
        if (node == null) return;

        inorderTraversal(node.leftChild);
        System.out.print(node.value + ":" + node.height + ":" + node.balanceFactor + " ");
        inorderTraversal(node.rightChild);
    }

    /**
     * Traverse and prints the nodes of the current BST in "POST_ORDER"
     * Depth First Search
     */
    private void postOrderTraversal(AvlNode<T> node) {
        if (node == null) return;

        inorderTraversal(node.leftChild);
        inorderTraversal(node.rightChild);
        System.out.print(node.value + ":" + node.height + ":" + node.balanceFactor + " ");
    }

}
