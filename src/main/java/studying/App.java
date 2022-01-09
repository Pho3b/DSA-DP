package studying;

import studying.data_structures.tree.Trie;

public class App {

    public static void main(String[] args) {
        System.out.println("This is your current operating system: " + System.getProperty("os.name") + "\n");
        currentWorkingOnIssueTest();
    }

    public static void currentWorkingOnIssueTest() {
        Trie trie = new Trie("boo");
        trie.insert("ball");
        trie.insert("batman");
        trie.insert("stock");

        System.out.println(trie.print());
    }
}
