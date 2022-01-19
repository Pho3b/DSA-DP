package studying.data_structures.tree;

import studying.data_structures.tree.model.TrieNode;

import java.util.ArrayList;

// [Prefix Tree]
public class Trie {
    private int wordsNumber = 0;
    private final TrieNode root = new TrieNode(' ', true);


    /**
     * Default empty constructor
     */
    public Trie() {
    }

    /**
     * Constructor with initial word
     *
     * @param word The first word that will be inserted into the Trie
     */
    public Trie(String word) {
        this.insert(word);
    }

    /**
     * Constructor with initial array of words
     *
     * @param words All the words that will be inserted inside the Trie
     */
    public Trie(String[] words) {
        for (String word : words) {
            this.insert(word);
        }
    }

    /**
     * Inserts a new word into the Trie
     *
     * @param word The word that will be inserted
     */
    public void insert(String word) {
        TrieNode currentNode = this.root;

        for (int i = 0; i < word.length(); i++) {
            // Clamping the index from 0 to 95 because I am using only lower letters section of the ASCII table
            char currentChar = Character.toLowerCase(word.charAt(i));
            int index = currentChar - 'a';

            if (currentNode.children[index] == null)
                currentNode.children[index] = new TrieNode(currentChar);

            currentNode = currentNode.children[index];
        }

        currentNode.isEndOfWord = true;
        this.wordsNumber++;
    }

    /**
     * Searches if the given prefix string is present into the Trie
     *
     * @param prefix The prefix string to search
     * @return True if it is present, false otherwise
     */
    public boolean searchPrefix(String prefix) {
        TrieNode currentNode = this.root;

        for (int i = 0; i < prefix.length(); i++) {
            char currentChar = Character.toLowerCase(prefix.charAt(i));
            int index = currentChar - 'a';

            if (currentNode.children[index] == null)
                return false;

            currentNode = currentNode.children[index];
        }

        return true;
    }

    /**
     * @return The number of words currently present into the Trie
     */
    public int getWordsNumber() {
        return wordsNumber;
    }

    /**
     * Prints the data structure to the standard output in a suitable format
     *
     * @return The string representation of an array containing the words currently present into the Trie
     */
    public String print() {
        ArrayList<String> words = new ArrayList<>(wordsNumber);
        internalPrint(this.root, new StringBuffer(), words);

        return words.toString();
    }

    /**
     * Internal recursive method that actually prints the Trie
     *
     * @param currentNode The starting node from which to start printing
     */
    private void internalPrint(TrieNode currentNode, StringBuffer sb, ArrayList<String> words) {
        if (currentNode != null) {
            sb.append(currentNode.value);

            if (currentNode.isEndOfWord && currentNode.value != ' ') {
                System.out.println(sb);
                words.add(sb.toString().trim());
            }

            for (TrieNode node : currentNode.children) {
                if (node != null)
                    internalPrint(node, sb, words);
            }

            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
