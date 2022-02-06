package studying.algorithms.tree.traversal;

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

        if (node == null) return res;

        Stack<Node<Integer>> stack1 = new Stack<>();
        Stack<Node<Integer>> stack2 = new Stack<>();
        stack1.push(node);

        while (!stack1.isEmpty()) {
            node = stack1.pop();
            stack2.push(node);

            if (node.leftChild != null) stack1.push(node.leftChild);
            if (node.rightChild != null) stack1.push(node.rightChild);
        }

        // Cycling through the result of a reversed preorder filled stack
        // will give us the values ordered in postorder style
        while (!stack2.isEmpty()) {
            res.add(stack2.pop().value);
        }

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
