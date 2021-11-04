package studying.data_structures;

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

    @Test
    public void simpleRightAndLeftTreeRotationsTest() {
        AvlTree<Integer> avlTree = new AvlTree<>();
        avlTree.insert(4);
        avlTree.insert(12);
        avlTree.insert(32);
        Assertions.assertEquals("[12, 4, 32]", avlTree.levelTraversal().toString());

        avlTree.insert(2);
        avlTree.insert(1);
        Assertions.assertEquals("[12, 2, 32, 1, 4]", avlTree.levelTraversal().toString());

        avlTree.insert(36);
        avlTree.insert(8);
        avlTree.insert(18);
        avlTree.insert(38);
        Assertions.assertEquals("[12, 2, 32, 1, 4, 18, 36, 8, 38]", avlTree.levelTraversal().toString());
    }

    @Test
    public void rightLeftRotationTest() {
        AvlTree<Integer> avlTree = new AvlTree<>();
        avlTree.insert(4);
        avlTree.insert(12);
        avlTree.insert(32);
        avlTree.insert(2);
        avlTree.insert(1);
        avlTree.insert(36);
        avlTree.insert(8);
        avlTree.insert(18);
        avlTree.insert(38);
        avlTree.insert(37);
        Assertions.assertEquals("[12, 2, 32, 1, 4, 18, 37, 8, 36, 38]", avlTree.levelTraversal().toString());
    }

    @Test
    public void leftRightRotationTest() {
        AvlTree<Integer> avlTree = new AvlTree<>();
        avlTree.insert(4);
        avlTree.insert(12);
        avlTree.insert(32);
        avlTree.insert(2);
        avlTree.insert(1);
        avlTree.insert(36);
        avlTree.insert(8);
        avlTree.insert(18);
        avlTree.insert(38);
        avlTree.insert(20);
        avlTree.insert(19);
        Assertions.assertEquals("[12, 2, 32, 1, 4, 19, 36, 8, 18, 20, 38]",
                avlTree.levelTraversal().toString());
    }

    @Test
    public void removeAndSizeTest() {
        AvlTree<Integer> avlTree = new AvlTree<>(12);
        avlTree.insert(4);
        avlTree.insert(12);
        avlTree.insert(32);
        Assertions.assertEquals(3, avlTree.size());

        // avlTree.levelTraversal();
        avlTree.delete(12);
        avlTree.levelTraversal();
        Assertions.assertEquals(2, avlTree.size());
    }

    @Test
    public void removeAndRotations() {
        AvlTree<Integer> avlTree = new AvlTree<>();
        avlTree.insert(4);
        avlTree.insert(12);
        avlTree.insert(32);
        avlTree.insert(76);
        avlTree.insert(15);
        avlTree.delete(4);
        Assertions.assertEquals("[32, 12, 76, 15]", avlTree.levelTraversal().toString());

        avlTree.delete(76);
        Assertions.assertEquals("[15, 12, 32]", avlTree.levelTraversal().toString());
    }
}
