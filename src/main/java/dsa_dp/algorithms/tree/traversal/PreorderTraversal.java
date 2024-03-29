package dsa_dp.algorithms.tree.traversal;

import dsa_dp.data_structures.tree.model.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// Preorder (Root, Left, Right)
public class PreorderTraversal {

    /**
     * Recursively traverse a binary tree in 'pre-order'
     *
     * @param root input root node
     * @return A list containing the node's values in 'pre-order'
     */
    public static List<Integer> recursiveTraversal(Node<Integer> root) {
        ArrayList<Integer> res = new ArrayList<>();
        preorder(root, res);

        return res;
    }

    /**
     * Iteratively traverse a binary tree in 'pre-order'
     *
     * @param root input root node
     * @return A list containing the node's values in 'pre-order'
     */
    public static List<Integer> iterativeTraversal(Node<Integer> root) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Node<Integer>> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node<Integer> node = stack.pop();
            res.add(node.value);

            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }

        return res;
    }

    /**
     * Internal private recursive call
     *
     * @param node current input node
     * @param res  array which we want to be populated with the values in the correct 'pre-order'
     */
    private static void preorder(Node<Integer> node, ArrayList<Integer> res) {
        if (node == null)
            return;

        res.add(node.value);
        preorder(node.left, res);
        preorder(node.right, res);
    }

}
