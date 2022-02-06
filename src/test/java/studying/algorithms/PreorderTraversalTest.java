package studying.algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import studying.Utils;
import studying.algorithms.tree.traversal.PreorderTraversal;
import studying.data_structures.tree.BinarySearchTree;

import java.util.ArrayList;

public class PreorderTraversalTest {

    @Test
    public void recursivePreorderCorrectTest() {
        ArrayList<Integer> correctRes = new ArrayList<>();
        int[] res = new int[]{20, 10, 8, 9, 12, 25, 28};

        for (int j : res)
            correctRes.add(j);

        BinarySearchTree<Integer> tree = Utils.testBinaryTree1();
        Assertions.assertEquals(correctRes, PreorderTraversal.recursiveTraversal(tree.root));
    }

    @Test
    public void recursivePreorderCorrectTest2() {
        ArrayList<Integer> correctRes = new ArrayList<>();
        int[] res = new int[]{50, 12, 2, 4, 6, 100, 80};

        for (int j : res)
            correctRes.add(j);

        BinarySearchTree<Integer> tree = Utils.testBinaryTree2();
        Assertions.assertEquals(correctRes, PreorderTraversal.recursiveTraversal(tree.root));
    }

    @Test
    public void recursivePreorderWrongTest() {
        ArrayList<Integer> correctRes = new ArrayList<>();
        int[] res = new int[]{20, 11, 8, 9, 12, 25, 28};

        for (int j : res)
            correctRes.add(j);

        BinarySearchTree<Integer> tree = Utils.testBinaryTree1();
        Assertions.assertNotEquals(correctRes, PreorderTraversal.recursiveTraversal(tree.root));
    }

    @Test
    public void iterativePreorderCorrectTest() {
        ArrayList<Integer> correctRes = new ArrayList<>();
        int[] res = new int[]{20, 10, 8, 9, 12, 25, 28};

        for (int j : res)
            correctRes.add(j);

        BinarySearchTree<Integer> tree = Utils.testBinaryTree1();
        Assertions.assertEquals(correctRes, PreorderTraversal.iterativeTraversal(tree.root));
    }

    @Test
    public void iterativePreorderCorrectTest2() {
        ArrayList<Integer> correctRes = new ArrayList<>();
        int[] res = new int[]{50, 12, 2, 4, 6, 100, 80};

        for (int j : res)
            correctRes.add(j);

        BinarySearchTree<Integer> tree = Utils.testBinaryTree2();
        Assertions.assertEquals(correctRes, PreorderTraversal.iterativeTraversal(tree.root));
    }

    @Test
    public void iterativePreorderWrongTest() {
        ArrayList<Integer> correctRes = new ArrayList<>();
        int[] res = new int[]{20, 11, 8, 9, 12, 25, 28};

        for (int j : res)
            correctRes.add(j);

        BinarySearchTree<Integer> tree = Utils.testBinaryTree1();
        Assertions.assertNotEquals(correctRes, PreorderTraversal.iterativeTraversal(tree.root));
    }
}
