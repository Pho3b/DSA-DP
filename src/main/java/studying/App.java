package studying;

import studying.data_structures.tree.AvlTree;

public class App {

    public static void main(String[] args) {
        String osName = System.getProperty("os.name").toLowerCase();
        System.out.println("This is your current operating system: " + osName +  "\n");

        currentWorkingOnIssueTest();
    }

    public static void currentWorkingOnIssueTest() {
        AvlTree<Integer> avlTree = new AvlTree<>();
        avlTree.insert(4);
        avlTree.insert(12);
        avlTree.insert(32);
        avlTree.insert(32);
        avlTree.insert(36);
        avlTree.insert(8);
        avlTree.insert(2);
        avlTree.insert(1);

        avlTree.levelTraversal();
        avlTree.print();
    }
}
