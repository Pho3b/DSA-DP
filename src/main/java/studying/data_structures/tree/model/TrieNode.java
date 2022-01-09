package studying.data_structures.tree.model;

import java.util.Arrays;

public class TrieNode {
    public final static int ALPHABET_SIZE = 26;
    public boolean isEndOfWord = false;
    public Character value;
    public TrieNode[] children = new TrieNode[ALPHABET_SIZE];


    /**
     * Default constructor
     */
    public TrieNode() {
        Arrays.fill(children, null);
    }

    /**
     * Constructor with given char
     *
     * @param c The char that will become the value of this TrieNode
     */
    public TrieNode(Character c) {
        this();
        this.value = Character.toLowerCase(c);
    }

    /**
     * Constructor with given char and 'isEndOfWord' flag
     *
     * @param c           The char that will become the value of this TrieNode
     * @param isEndOfWord Boolean flag that signs this node as the end of a word
     */
    public TrieNode(Character c, boolean isEndOfWord) {
        this();
        this.value = c;
        this.isEndOfWord = isEndOfWord;
    }
}
