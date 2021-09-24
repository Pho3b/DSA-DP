package studying;

import studying.data_structures.tree.AvlTree;

public class App {

    public static void main(String[] args) {
        String osName = System.getProperty("os.name").toLowerCase();
        System.out.println("This is your current operating system: " + osName);

        currentWorkingOnIssueTest();
    }

    public static void currentWorkingOnIssueTest() {
        AvlTree<Integer> avlTree = new AvlTree<>();
        System.out.println(avlTree.insert(4));
        System.out.println(avlTree.insert(12));
        System.out.println(avlTree.insert(32));
        System.out.println(avlTree.insert(32));
        System.out.println(avlTree.insert(2));
        System.out.println(avlTree.insert(1));
        System.out.println(avlTree.traverse());
        avlTree.print();
    }
}
