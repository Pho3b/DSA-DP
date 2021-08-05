package studying;

import studying.data_structures.tree.FenwickTree;

public class App {

    public static void main(String[] args) {
        String osName = System.getProperty("os.name").toLowerCase();
        System.out.println("This is your current operating system: " + osName);

        currentWorkingOnIssueTest();
    }

    public static void currentWorkingOnIssueTest() {
        int[] testArr = {0, 3, 4, -2, 7, 3, 11, 5, -8, -9, 2, 4, -8};
        FenwickTree fenwickTree = new FenwickTree(testArr);
        fenwickTree.print();
        System.out.println(fenwickTree.rangeQuery(5,7)); // 26
    }
}
