package studying;

import studying.data_structures.tree.BinarySearchTree;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;

public class Utils {

    public final static int[] orderedIntegerTestArray = new int[]{-21, -1, 1, 3, 4, 5, 6, 10, 11, 123, 1000, 1002};

    public final static int[] unorderedIntegerTestArray = new int[]{100, 13, 4, 12, 7, 6, 21, 900, 14, 76, 42, 90, 1, -10, -2};

    /**
     * Generates an array list containing random integer numbers
     *
     * @return A randomly generated Integer arrayList
     */
    public static ArrayList<Integer> randomUnorderedIntegerList() {
        final int capacity = 100;
        Random rand = new Random();
        ArrayList<Integer> res = new ArrayList<>(capacity);

        for (int i = 0; i < capacity; i++) {
            res.add(rand.nextInt(101));
        }

        return res;
    }

    public static ArrayList<Integer> binaryTreeLevelOrderList() {
        ArrayList<Integer> res = new ArrayList<>();
        int[] intArr = new int[]{11, 6, 15, 3, 8, 13, 17, 1, 5, 12, 14, 19};

        for (int j : intArr) {
            res.add(j);
        }

        return res;
    }

    public static Hashtable<Character, Integer> generateRandomCharsBijectionTable() {
        Hashtable<Character, Integer> bijectionTable = new Hashtable<>();
        char[] charsArr = new char[]{'E', 'F', 'I', 'D', 'C', 'A', 'J', 'L', 'G', 'K', 'B', 'H'};

        for (int i = 0; i < charsArr.length; i++) {
            bijectionTable.put(charsArr[i], i);
        }

        return bijectionTable;
    }

    public static Hashtable<String, Integer> generateStringsBijectionTable() {
        Hashtable<String, Integer> bijectionTable = new Hashtable<>();
        String[] peopleArr = new String[]{"Simona", "Federica", "Marco", "Giovanni", "Andrea", "Matteo", "Alessandra"};

        for (int i = 0; i < peopleArr.length; i++) {
            bijectionTable.put(peopleArr[i], i);
        }

        return bijectionTable;
    }

    public static BinarySearchTree<Integer> testBinaryTree1() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>(20);
        tree.insert(10);
        tree.insert(25);
        tree.insert(8);
        tree.insert(12);
        tree.insert(9);
        tree.insert(28);

        return tree;
    }

    public static BinarySearchTree<Integer> testBinaryTree2() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>(50);
        tree.insert(100);
        tree.insert(12);
        tree.insert(2);
        tree.insert(80);
        tree.insert(4);
        tree.insert(6);

        return tree;
    }
}
