package studying.data_structures.tree.model;

public class TrieNode {
    boolean isEndOfWord = false;
    Character value = null;


    /**
     * Default constructor
     */
    public TrieNode() {
    }

    /**
     * Constructor with given char
     *
     * @param c The char that will become the value of this TrieNode
     */
    public TrieNode(Character c) {
        this.value = c;
    }
}
