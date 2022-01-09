package studying.data_structures.tree;

import studying.data_structures.tree.model.TrieNode;

import java.util.ArrayList;

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
            // Clamping the index from 0 to 95 because I am using only the ASCII table lower letters section
            char currentChar = Character.toLowerCase(word.charAt(i));
            int index = currentChar - 'a';

            if (currentNode.children[index] == null)
                currentNode.children[index] = new TrieNode(currentChar);

            currentNode = currentNode.children[index];
        }

        currentNode.isEndOfWord = true;
        this.wordsNumber++;
    }

    public boolean search() {
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
     */
    public ArrayList<String> print() {
        ArrayList<String> words = new ArrayList<>(wordsNumber);
        internalPrint(this.root, new StringBuffer(), words);

        return words;
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
