package studying.algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import studying.Utils;
import studying.algorithms.tree_traversal.PostorderTraversal;
import studying.data_structures.tree.BinarySearchTree;

import java.util.ArrayList;

public class PostorderTraversalTest {

    @Test
    public void recursivePostorderCorrectTest() {
        ArrayList<Integer> correctRes = new ArrayList<>();
        int[] intArr = new int[]{8, 9, 10, 12, 20, 25, 28};

        for (int j : intArr)
            correctRes.add(j);

        BinarySearchTree<Integer> tree = Utils.testBinaryTree1();
        Assertions.assertEquals(correctRes, PostorderTraversal.recursiveTraversal(tree.root));
    }

    @Test
    public void recursivePostorderCorrectTest2() {
        ArrayList<Integer> correctRes = new ArrayList<>();
        int[] res = new int[]{2, 4, 6, 12, 50, 80, 100};

        for (int j : res)
            correctRes.add(j);

        BinarySearchTree<Integer> tree = Utils.testBinaryTree2();
        Assertions.assertEquals(correctRes, PostorderTraversal.recursiveTraversal(tree.root));
    }

    @Test
    public void recursivePostorderWrongTest() {
        ArrayList<Integer> correctRes = new ArrayList<>();
        int[] intArr = new int[]{20, 11, 8, 9, 12, 25, 28};

        for (int j : intArr)
            correctRes.add(j);

        BinarySearchTree<Integer> tree = Utils.testBinaryTree1();
        Assertions.assertNotEquals(correctRes, PostorderTraversal.recursiveTraversal(tree.root));
    }


    @Test
    public void iterativePostorderCorrectTest() {
        ArrayList<Integer> correctRes = new ArrayList<>();
        int[] res = new int[]{8, 9, 10, 12, 20, 25, 28};

        for (int j : res)
            correctRes.add(j);

        BinarySearchTree<Integer> tree = Utils.testBinaryTree1();
        Assertions.assertEquals(correctRes, PostorderTraversal.iterativeTraversal(tree.root));
    }

    @Test
    public void iterativePostorderCorrectTest2() {
        ArrayList<Integer> correctRes = new ArrayList<>();
        int[] res = new int[]{2, 4, 6, 12, 50, 80, 100};

        for (int j : res)
            correctRes.add(j);

        BinarySearchTree<Integer> tree = Utils.testBinaryTree2();
        Assertions.assertEquals(correctRes, PostorderTraversal.iterativeTraversal(tree.root));
    }

    @Test
    public void iterativePostorderWrongTest() {
        ArrayList<Integer> correctRes = new ArrayList<>();
        int[] res = new int[]{20, 11, 8, 9, 12, 25, 28};

        for (int j : res)
            correctRes.add(j);

        BinarySearchTree<Integer> tree = Utils.testBinaryTree1();
        Assertions.assertNotEquals(correctRes, PostorderTraversal.iterativeTraversal(tree.root));
    }
}
