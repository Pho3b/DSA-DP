package studying.algorithms.tree_traversal;

import studying.data_structures.tree.model.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// Postorder (Left, Right, Root)
public class PostorderTraversal {

    /**
     * Recursively traverse a binary tree in 'post-order'
     *
     * @param root input root node
     * @return A list containing the node's values in 'pre-order'
     */
    public static List<Integer> recursiveTraversal(Node<Integer> root) {
        ArrayList<Integer> res = new ArrayList<>();
        postorder(root, res);

        return res;
    }

    /**
     * Iteratively traverse a binary tree in 'post-order'
     *
     * @param node input root node
     * @return A list containing the node's values in 'post-order'
     */
    public static List<Integer> iterativeTraversal(Node<Integer> node) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Node<Integer>> stack1 = new Stack<>();
        Stack<Node<Integer>> stack2 = new Stack<>();

        return res;
    }

    /**
     * Internal private recursive call
     *
     * @param node current input node
     * @param res  array which we want to be populated with the values in the correct 'post-order'
     */
    private static void postorder(Node<Integer> node, ArrayList<Integer> res) {
        if (node == null)
            return;

        postorder(node.leftChild, res);
        postorder(node.rightChild, res);
        res.add(node.value);
    }
}
