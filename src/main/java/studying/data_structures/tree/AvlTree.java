package studying.data_structures.tree;

public class AvlTree<T extends Comparable<T>> extends AbstractBst<T> {
    private BinarySearchTree<T> bst;
    /**
     * balanceFactor = The difference between the right subtree's height and the left subtree's height.
     * Height of X is calculated as the number of edges between X and the furthest Leaf Node.
     */
    int balanceFactor = 0;


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
     * Private recursive method that actually inserts a new node inside the tree
     *
     * @param node Node
     * @return boolean
     */
    private Node<T> insert(Node<T> node, T newValue) {
        if (node == null) {
            nodesCount++;
            return new AvlNode<>(newValue);
        }

        if (newValue.compareTo(node.value) > 0) {
            node.rightChild = insert(node.rightChild, newValue);
        } else if (newValue.compareTo(node.value) < 0) {
            node.leftChild = insert(node.leftChild, newValue);
        }

        return node;
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
}
