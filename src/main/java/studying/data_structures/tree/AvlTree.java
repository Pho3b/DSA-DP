package studying.data_structures.tree;

public class AvlTree<T extends Comparable<T>> extends AbstractBst<T> {
    private BinarySearchTree<T> bst;
    short balanceFactor = 0;


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
    }

    /**
     * Public method to insert a new Node inside the tree.
     * Duplicates are not allowed, the method will return true or false whether
     * the new node has been correctly added or not.
     *
     * @return boolean
     */
    public boolean insert(T value) {
        if (value == null) {
            return false;
        } else if (this.root == null) {
            // Empty root case
            this.root = new AvlNode<>(value);
            return true;
        }

        return this.insert(new AvlNode<>(value), this.root);
    }

    /**
     * Private recursive method that actually inserts a new node inside the tree
     *
     * @param toInsert Node
     * @return boolean
     */
    private boolean insert(Node<T> toInsert, Node<T> currentNode) {
        int comparison = toInsert.value.compareTo(currentNode.value);
        Node<T> nextNode;

        if (comparison == 0) {
            return false;
        } else if (comparison > 0) {
            nextNode = currentNode.rightChild;

            if (nextNode == null) {
                currentNode.rightChild = toInsert;
                return true;
            }
        } else {
            nextNode = currentNode.leftChild;

            if (nextNode == null) {
                currentNode.leftChild = toInsert;
                return true;
            }
        }

        return this.insert(toInsert, nextNode);
    }

    public boolean contains(T value) {

        return false;
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
