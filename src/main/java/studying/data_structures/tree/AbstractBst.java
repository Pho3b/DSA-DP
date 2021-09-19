package studying.data_structures.tree;

public abstract class AbstractBst<T extends Comparable<T>> {
    protected Node<T> root = null;

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
}
