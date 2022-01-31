package studying.algorithms.tree_traversal;

import studying.data_structures.tree.model.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// Inorder (Left, Root, Right)
public class InorderTraversal {

    /**
     * Recursively traverse a binary tree in 'inorder'
     *
     * @param root input root node
     * @return A list containing the node's values in 'pre-order'
     */
    public static List<Integer> recursiveTraversal(Node<Integer> root) {
        ArrayList<Integer> res = new ArrayList<>();
        inorder(root, res);

        return res;
    }

    /**
     * Iteratively traverse a binary tree in 'inorder'
     *
     * @param node input root node
     * @return A list containing the node's values in 'inorder'
     */
    public static List<Integer> iterativeTraversal(Node<Integer> node) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Node<Integer>> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            while (node.leftChild != null) {
                stack.push(node.leftChild);
                node = node.leftChild;
            }

            node = stack.pop();
            res.add(node.value);

            if (node.rightChild != null) stack.push(node.rightChild);
        }

        return res;
    }

    /**
     * Internal private recursive call
     *
     * @param node current input node
     * @param res  array which we want to be populated with the values in the correct 'inorder'
     */
    private static void inorder(Node<Integer> node, ArrayList<Integer> res) {
        if (node == null)
            return;

        inorder(node.leftChild, res);
        res.add(node.value);
        inorder(node.rightChild, res);
    }
}
