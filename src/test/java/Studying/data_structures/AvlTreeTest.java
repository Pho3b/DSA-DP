package Studying.data_structures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import studying.data_structures.tree.AvlTree;

public class AvlTreeTest {

    @Test
    public void insertionTest() {
        AvlTree<Integer> avlTree = new AvlTree<>(10);
        avlTree.insert(23);
        avlTree.insert(2);
        avlTree.insert(3);

        Assertions.assertTrue(avlTree.contains(3));
        Assertions.assertTrue(avlTree.contains(2));
        Assertions.assertTrue(avlTree.contains(23));
        Assertions.assertFalse(avlTree.contains(11));
    }

    @Test
    public void containsTest() {
        AvlTree<Integer> avlTree = new AvlTree<>(1000);
        avlTree.insert(2000);
        avlTree.insert(2);
        avlTree.insert(3);
        avlTree.insert(18);

        Assertions.assertTrue(avlTree.contains(3));
        Assertions.assertTrue(avlTree.contains(2));
        Assertions.assertFalse(avlTree.contains(23));
        Assertions.assertFalse(avlTree.contains(11));
        Assertions.assertTrue(avlTree.contains(2000));
    }

    @Test
    public void nodesCountTest() {
        AvlTree<Integer> avlTree = new AvlTree<>(1000);
        avlTree.insert(2000);
        avlTree.insert(2);
        avlTree.insert(3);
        avlTree.insert(18);

        Assertions.assertEquals(5, avlTree.size());

        avlTree.insert(3);
        Assertions.assertEquals(5, avlTree.size());
        avlTree.insert(144);
        Assertions.assertEquals(6, avlTree.size());
    }
}
