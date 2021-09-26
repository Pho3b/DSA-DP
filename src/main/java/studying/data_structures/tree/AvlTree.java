package studying.data_structures.tree;

import studying.data_structures.queue.Queue;
import studying.data_structures.tree.model.AvlNode;
import studying.data_structures.tree.model.BalanceState;

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
     * Exposed delete method, it calls the internal recursive one to actually
     * remove the given node
     *
     * @param value T
     * @return boolean
     */
    public boolean delete(T value) {
        int currentNodesCount = nodesCount;
        this.root = this.delete(root, value);

        return (nodesCount < currentNodesCount);
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

        System.out.println(res);
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
     * Private recursive method that actually inserts a new node inside the tree,
     * it also updates the height of the current node and calls the tree balance method if needed.
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
        return updateBalance(node);
    }

    /**
     * Private recursive method that removes a node from the BST structure,
     * it starts to search for the node to delete from the given 'currentNode'
     *
     * @param currentNode AvlNode
     * @param value       T
     * @return Node
     */
    private AvlNode<T> delete(AvlNode<T> currentNode, T value) {
        if (currentNode == null) return null;

        if (value.compareTo(currentNode.value) > 0) {
            currentNode.rightChild = delete(currentNode.rightChild, value);
        } else if (value.compareTo(currentNode.value) < 0) {
            currentNode.leftChild = delete(currentNode.leftChild, value);
        } else {
            nodesCount--;

            if (currentNode.leftChild == null) {
                AvlNode<T> temp = currentNode.rightChild;
                currentNode.rightChild = null;
                return temp;
            } else if (currentNode.rightChild == null) {
                AvlNode<T> temp = currentNode.leftChild;
                currentNode.leftChild = null;
                return temp;
            } else {
                AvlNode<T> temp = findMin(currentNode.rightChild);
                currentNode.value = temp.value;
                this.delete(currentNode.rightChild, temp.value);
            }
        }

        return currentNode;
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
    private AvlNode<T> updateBalance(AvlNode<T> node) {
        int balanceFactor = (height(node.rightChild) - height(node.leftChild));

        switch (this.checkBalanceState(node, balanceFactor)) {
            case LEFT_LEFT_CASE:
                return rightRotate(node);
            case RIGHT_RIGHT_CASE:
                return leftRotate(node);
            case LEFT_RIGHT_CASE:
                node.leftChild = leftRotate(node.leftChild);
                return rightRotate(node);
            case RIGHT_LEFT_CASE:
                node.rightChild = rightRotate(node.rightChild);
                return leftRotate(node);
        }

        return node;
    }

    /**
     * Returns the current 'BalanceState' of the given node.
     * If the node is not unbalanced it returns the default 'BALANCED_CASE'
     *
     * @param node          AvlNode<T>
     * @param balanceFactor int
     * @return BalanceState
     */
    private BalanceState checkBalanceState(AvlNode<T> node, int balanceFactor) {
        switch (balanceFactor) {
            case 2:
                if (node.rightChild.leftChild == null) {
                    System.out.println("RIGHT_RIGHT_CASE");
                    return BalanceState.RIGHT_RIGHT_CASE;
                }

                System.out.println("RIGHT_LEFT_CASE");
                return BalanceState.RIGHT_LEFT_CASE;
            case -2:
                if (node.leftChild.rightChild == null) {
                    System.out.println("LEFT_LEFT_CASE");
                    return BalanceState.LEFT_LEFT_CASE;
                }

                System.out.println("LEFT_RIGHT_CASE");
                return BalanceState.LEFT_RIGHT_CASE;
            default:
                return BalanceState.BALANCED_CASE;
        }
    }

    /**
     * Utility method that retrieves the height of a given Node in the Tree
     * Height of X is calculated as the number of edges between X and the furthest Leaf Node.
     *
     * @return int
     */
    private int height(AvlNode<T> node) {
        if (node == null)
            return -1;

        return node.height;
    }

    /**
     * Performs a right rotation on the given node, returning the new
     * root node of the subtree after the rotation.
     *
     * @return AvlNode<T>
     */
    private AvlNode<T> rightRotate(AvlNode<T> node) {
        AvlNode<T> leftChild = node.leftChild;
        node.leftChild = leftChild.rightChild;
        leftChild.rightChild = node;

        updateHeight(node);
        updateHeight(leftChild);

        return leftChild;
    }


    /**
     * Performs a left rotation on the given node, returning the new
     * root node of the subtree after the rotation.
     *
     * @return AvlNode<T>
     */
    private AvlNode<T> leftRotate(AvlNode<T> node) {
        AvlNode<T> rightChild = node.rightChild;
        node.rightChild = rightChild.leftChild;
        rightChild.leftChild = node;

        updateHeight(node);
        updateHeight(rightChild);

        return rightChild;
    }

    /**
     * Given a root node it finds it's child with the minimum value and returns it
     *
     * @param currentRoot Node
     * @return AvlNode<T>
     */
    private AvlNode<T> findMin(AvlNode<T> currentRoot) {
        while (currentRoot.leftChild != null) {
            currentRoot = currentRoot.leftChild;
        }

        return currentRoot;
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
    private void inorderTraversal(AvlNode<T> node) {
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

}
