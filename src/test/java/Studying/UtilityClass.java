package Studying;

import java.util.ArrayList;

public class UtilityClass {

    public final static int[] orderedIntegerTestArray = new int[]{-21, -1, 1, 3, 4, 5, 6, 10, 11, 123, 1000, 1002};
    public final static int[] unorderedIntegerTestArray = new int[]{100, 13 , 4, 12, 7, 6, 21, 900, 14, 76, 42, 90, 1, -10, -2};
    public final static ArrayList<Integer> unorderedIntegerTestArrayList() {
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

}
