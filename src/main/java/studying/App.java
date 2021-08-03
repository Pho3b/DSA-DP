package studying;

import studying.data_structures.tree.FenwickTree;

public class App {

    public static void main(String[] args) {
        String osName = System.getProperty("os.name").toLowerCase();
        System.out.println("This is your current operating system: " + osName);

        currentWorkingOnIssueTest();
    }

    public static void currentWorkingOnIssueTest() {
        int res = FenwickTree.lsb(108);
        System.out.println("result: " + res);
        System.out.println("binary result: " + Integer.toBinaryString(res));
    }
}
