package Studying.data_structures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import studying.data_structures.tree.BinarySearchTree;

public class BinaryTreeTest {

    @Test
    public void correctInsertionTest() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>(11);
        bst.insert(23);
        bst.insert(2);
        bst.insert(3);

        Assertions.assertTrue(bst.contains(3));
        Assertions.assertTrue(bst.contains(2));
        Assertions.assertTrue(bst.contains(23));
        Assertions.assertTrue(bst.contains(11));
    }

    @Test
    public void correctContainsTest() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>(1000);
        bst.insert(2000);
        bst.insert(2);
        bst.insert(3);
        bst.insert(18);

        Assertions.assertTrue(bst.contains(3));
        Assertions.assertTrue(bst.contains(2));
        Assertions.assertFalse(bst.contains(23));
        Assertions.assertFalse(bst.contains(11));
        Assertions.assertTrue(bst.contains(2000));
    }
}
