package studying.data_structures;

import studying.Utils;
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

    @Test
    public void correctDeleteTest() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>(100);
        bst.insert(1);
        bst.insert(12);
        bst.insert(3);
        bst.insert(18);
        bst.insert(897);

        Assertions.assertEquals(6, bst.size());
        Assertions.assertTrue(bst.delete(3));
        Assertions.assertEquals(5, bst.size());
        Assertions.assertFalse(bst.contains(3));

        bst.delete(897);
        Assertions.assertFalse(bst.contains(897));
    }

    @Test
    public void deleteOneNodeTreeTest() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>(100);

        Assertions.assertEquals(1, bst.size());
        bst.delete(100);
        Assertions.assertEquals(0, bst.size());
    }

    @Test
    public void correctRecursiveDepthTest() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>(20);
        bst.insert(10);
        bst.insert(31);
        bst.insert(5);
        bst.insert(15);
        bst.insert(25);
        bst.insert(42);
        bst.insert(2);
        bst.insert(12);
        bst.insert(19);
        bst.insert(35);
        bst.insert(47);
        bst.insert(11);
        bst.insert(14);
        bst.insert(33);
        bst.insert(37);
        bst.insert(36);
        bst.insert(38);

        Assertions.assertEquals(6, bst.depth());
    }

    @Test
    public void correctLevelOrderTraversal() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>(11);
        bst.insert(6);
        bst.insert(15);
        bst.insert(3);
        bst.insert(8);
        bst.insert(13);
        bst.insert(17);
        bst.insert(1);
        bst.insert(5);
        bst.insert(12);
        bst.insert(14);
        bst.insert(19);

        Assertions.assertEquals(bst.levelOrderTraversal(), Utils.binaryTreeLevelOrderList());
    }

    @Test
    public void correctIterativeHeightTest() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>(50);
        bst.insert(45);
        bst.insert(67);
        bst.insert(40);
        bst.insert(65);
        bst.insert(79);
        bst.insert(36);
        bst.insert(41);
        bst.insert(61);
        bst.insert(66);
        bst.insert(68);
        bst.insert(69);

        Assertions.assertEquals(5, bst.height());
    }

    @Test
    public void zeroIterativeHeightTest() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        Assertions.assertEquals(0, bst.height());
    }

    @Test
    public void oneLevelIterativeHeightTest() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>(12);

        Assertions.assertEquals(1, bst.height());
    }

    @Test
    public void eightLevelHeightTest() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>(50);
        bst.insert(45);
        bst.insert(67);
        bst.insert(40);
        bst.insert(65);
        bst.insert(79);
        bst.insert(36);
        bst.insert(41);
        bst.insert(61);
        bst.insert(66);
        bst.insert(68);
        bst.insert(69);
        bst.insert(70);
        bst.insert(71);
        bst.insert(72);

        Assertions.assertEquals(8, bst.height());
    }
}
