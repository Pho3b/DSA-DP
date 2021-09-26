package studying;

import studying.data_structures.tree.AvlTree;

public class App {

    public static void main(String[] args) {
        System.out.println("This is your current operating system: " + System.getProperty("os.name") +  "\n");
        currentWorkingOnIssueTest();
    }

    public static void currentWorkingOnIssueTest() {
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

        avlTree.levelTraversal();
        avlTree.print();
    }
}
