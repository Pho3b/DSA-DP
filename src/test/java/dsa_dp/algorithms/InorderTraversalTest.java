package dsa_dp.algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import dsa_dp.Utils;
import dsa_dp.algorithms.tree.traversal.InorderTraversal;
import dsa_dp.data_structures.tree.BinarySearchTree;

import java.util.ArrayList;

public class InorderTraversalTest {

    @Test
    public void recursiveInorderCorrectTest() {
        ArrayList<Integer> correctRes = new ArrayList<>();
        int[] intArr = new int[]{8, 9, 10, 12, 20, 25, 28};

        for (int j : intArr)
            correctRes.add(j);

        BinarySearchTree<Integer> tree = Utils.testBinaryTree1();
        Assertions.assertEquals(correctRes, InorderTraversal.recursiveTraversal(tree.root));
    }

    @Test
    public void recursiveInorderCorrectTest2() {
        ArrayList<Integer> correctRes = new ArrayList<>();
        int[] res = new int[]{2, 4, 6, 12, 50, 80, 100};

        for (int j : res)
            correctRes.add(j);

        BinarySearchTree<Integer> tree = Utils.testBinaryTree2();
        Assertions.assertEquals(correctRes, InorderTraversal.recursiveTraversal(tree.root));
    }

    @Test
    public void recursiveInorderWrongTest() {
        ArrayList<Integer> correctRes = new ArrayList<>();
        int[] intArr = new int[]{20, 11, 8, 9, 12, 25, 28};

        for (int j : intArr)
            correctRes.add(j);

        BinarySearchTree<Integer> tree = Utils.testBinaryTree1();
        Assertions.assertNotEquals(correctRes, InorderTraversal.recursiveTraversal(tree.root));
    }


    @Test
    public void iterativeInorderCorrectTest() {
        ArrayList<Integer> correctRes = new ArrayList<>();
        int[] res = new int[]{8, 9, 10, 12, 20, 25, 28};

        for (int j : res)
            correctRes.add(j);

        BinarySearchTree<Integer> tree = Utils.testBinaryTree1();
        Assertions.assertEquals(correctRes, InorderTraversal.iterativeTraversal(tree.root));
    }

    @Test
    public void iterativeInorderCorrectTest2() {
        ArrayList<Integer> correctRes = new ArrayList<>();
        int[] res = new int[]{2, 4, 6, 12, 50, 80, 100};

        for (int j : res)
            correctRes.add(j);

        BinarySearchTree<Integer> tree = Utils.testBinaryTree2();
        Assertions.assertEquals(correctRes, InorderTraversal.iterativeTraversal(tree.root));
    }

    @Test
    public void iterativeInorderWrongTest() {
        ArrayList<Integer> correctRes = new ArrayList<>();
        int[] res = new int[]{20, 11, 8, 9, 12, 25, 28};

        for (int j : res)
            correctRes.add(j);

        BinarySearchTree<Integer> tree = Utils.testBinaryTree1();
        Assertions.assertNotEquals(correctRes, InorderTraversal.iterativeTraversal(tree.root));
    }
}
