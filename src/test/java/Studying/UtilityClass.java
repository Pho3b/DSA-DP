package Studying;

import java.util.ArrayList;
import java.util.Hashtable;

public class UtilityClass {

    public final static int[] orderedIntegerTestArray = new int[]{-21, -1, 1, 3, 4, 5, 6, 10, 11, 123, 1000, 1002};

    public final static int[] unorderedIntegerTestArray = new int[]{100, 13, 4, 12, 7, 6, 21, 900, 14, 76, 42, 90, 1, -10, -2};

    public static ArrayList<Integer> unorderedIntegerTestArrayList() {
        ArrayList<Integer> res = new ArrayList<>(15);
        res.add(100);
        res.add(13);
        res.add(4);
        res.add(-2);
        res.add(12);
        res.add(7);
        res.add(6);
        res.add(21);
        res.add(900);
        res.add(14);
        res.add(76);
        res.add(42);
        res.add(90);
        res.add(1);
        res.add(-10);

        return res;
    }

    public static ArrayList<Integer> binaryTreeLevelOrderList() {
        ArrayList<Integer> res = new ArrayList<>();
        int[] intArr = new int[]{11, 6, 15, 3, 8, 13, 17, 1, 5, 12, 14, 19};

        for (int i = 0; i < intArr.length; i++) {
            res.add(intArr[i]);
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

}
