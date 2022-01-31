package studying.algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import studying.Utils;
import studying.algorithms.tree_traversal.PreOrderTraversal;
import studying.data_structures.tree.BinarySearchTree;

import java.util.ArrayList;

public class PreOrderTraversalTest {

    @Test
    public void recursivePreOrderCorrectTest() {
        ArrayList<Integer> correctRes = new ArrayList<>();
        int[] intArr = new int[]{20, 10, 8, 9, 12, 25, 28};

        for (int j : intArr)
            correctRes.add(j);

        BinarySearchTree<Integer> tree = Utils.testBinaryTree1();
        Assertions.assertEquals(correctRes, PreOrderTraversal.recursiveTraversal(tree.root));
    }

    @Test
    public void recursivePreOrderCorrectTest2() {
        ArrayList<Integer> correctRes = new ArrayList<>();
        int[] intArr = new int[]{50, 12, 2, 4, 6, 100, 80};

        for (int j : intArr)
            correctRes.add(j);

        BinarySearchTree<Integer> tree = Utils.testBinaryTree2();
        Assertions.assertEquals(correctRes, PreOrderTraversal.recursiveTraversal(tree.root));
    }

    @Test
    public void recursivePreOrderWrongTest() {
        ArrayList<Integer> correctRes = new ArrayList<>();
        int[] intArr = new int[]{20, 11, 8, 9, 12, 25, 28};

        for (int j : intArr)
            correctRes.add(j);

        BinarySearchTree<Integer> tree = Utils.testBinaryTree1();
        Assertions.assertNotEquals(correctRes, PreOrderTraversal.recursiveTraversal(tree.root));
    }

    @Test
    public void iterativePreOrderCorrectTest() {
        ArrayList<Integer> correctRes = new ArrayList<>();
        int[] intArr = new int[]{20, 10, 8, 9, 12, 25, 28};

        for (int j : intArr)
            correctRes.add(j);

        BinarySearchTree<Integer> tree = Utils.testBinaryTree1();
        Assertions.assertEquals(correctRes, PreOrderTraversal.iterativeTraversal(tree.root));
    }

    @Test
    public void iterativePreOrderCorrectTest2() {
        ArrayList<Integer> correctRes = new ArrayList<>();
        int[] intArr = new int[]{50, 12, 2, 4, 6, 100, 80};

        for (int j : intArr)
            correctRes.add(j);

        BinarySearchTree<Integer> tree = Utils.testBinaryTree2();
        Assertions.assertEquals(correctRes, PreOrderTraversal.iterativeTraversal(tree.root));
    }

    @Test
    public void iterativePreOrderWrongTest() {
        ArrayList<Integer> correctRes = new ArrayList<>();
        int[] intArr = new int[]{20, 11, 8, 9, 12, 25, 28};

        for (int j : intArr)
            correctRes.add(j);

        BinarySearchTree<Integer> tree = Utils.testBinaryTree1();
        Assertions.assertNotEquals(correctRes, PreOrderTraversal.iterativeTraversal(tree.root));
    }
}
