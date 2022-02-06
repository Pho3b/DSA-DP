package studying.algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import studying.Utils;
import studying.algorithms.tree.traversal.PostorderTraversal;
import studying.data_structures.tree.BinarySearchTree;

import java.util.ArrayList;

public class PostorderTraversalTest {

    @Test
    public void recursivePostorderCorrectTest() {
        ArrayList<Integer> correctRes = new ArrayList<>();
        int[] intArr = new int[]{9, 8, 12, 10, 28, 25, 20};

        for (int j : intArr)
            correctRes.add(j);

        BinarySearchTree<Integer> tree = Utils.testBinaryTree1();
        Assertions.assertEquals(correctRes, PostorderTraversal.recursiveTraversal(tree.root));
    }

    @Test
    public void recursivePostorderCorrectTest2() {
        ArrayList<Integer> correctRes = new ArrayList<>();
        int[] res = new int[]{6, 4, 2, 12, 80, 100, 50};

        for (int j : res)
            correctRes.add(j);

        BinarySearchTree<Integer> tree = Utils.testBinaryTree2();
        Assertions.assertEquals(correctRes, PostorderTraversal.recursiveTraversal(tree.root));
    }

    @Test
    public void recursivePostorderWrongTest() {
        ArrayList<Integer> correctRes = new ArrayList<>();
        int[] intArr = new int[]{20, 11, 8, 9, 12, 25, 12};

        for (int j : intArr)
            correctRes.add(j);

        BinarySearchTree<Integer> tree = Utils.testBinaryTree1();
        Assertions.assertNotEquals(correctRes, PostorderTraversal.recursiveTraversal(tree.root));
    }

    @Test
    public void iterativePostorderCorrectTest() {
        ArrayList<Integer> correctRes = new ArrayList<>();
        int[] res = new int[]{9, 8, 12, 10, 28, 25, 20};

        for (int j : res)
            correctRes.add(j);

        BinarySearchTree<Integer> tree = Utils.testBinaryTree1();
        Assertions.assertEquals(correctRes, PostorderTraversal.iterativeTraversal(tree.root));
    }

    @Test
    public void iterativePostorderCorrectTest2() {
        ArrayList<Integer> correctRes = new ArrayList<>();
        int[] res = new int[]{6, 4, 2, 12, 80, 100, 50};

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
