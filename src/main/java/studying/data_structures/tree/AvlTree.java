package studying.data_structures.tree;

import studying.data_structures.queue.Queue;
import studying.data_structures.tree.model.AvlNode;

import java.util.ArrayList;
import java.util.List;

public class AvlTree<T extends Comparable<T>> {
    private int nodesCount, balanceFactor = 0; // The difference between the right subtree and the left subtree's height.
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

        return currentNodesCount < nodesCount;
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

        System.out.println();
        return res;
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
        }

        updateHeight(node);

        return node;
    }

    /**
     * Update the height property of the given Node
     *
     * @param node AvlNode
     */
    private void updateHeight(AvlNode<T> node) {
        node.height = 1 + Math.max(height(node.leftChild), height(node.rightChild));
        System.out.println("Node value " + node.value + " Height: " +  node.height);
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
    private void rightRotation() {

    }

    /**
     * Performed in the 'right heavy' case
     */
    private void leftRotation() {

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
    private void preorderTraversal(AvlNode<T> node) {
        if (node == null) return;

        System.out.print(node.value + ":" + node.height + " ");
        inorderTraversal(node.leftChild);
        inorderTraversal(node.rightChild);
    }

    /**
     * Traverse and prints the nodes of the current BST in "IN_ORDER"
     * Depth First Search
     */
    protected void inorderTraversal(AvlNode<T> node) {
        if (node == null) return;

        inorderTraversal(node.leftChild);
        System.out.print(node.value + ":" + node.height + " ");
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
        System.out.print(node.value + ":" + node.height + " ");
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
}
