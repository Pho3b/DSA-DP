package studying.data_structures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import studying.data_structures.tree.Trie;

public class TrieTest {

    @Test
    public void wordsNumberTest() {
        Trie trie = new Trie();
        trie.insert("hi");
        Assertions.assertEquals(trie.getWordsNumber(), 1);

        trie.insert("yo");
        trie.insert("back");
        trie.insert("luck");
        Assertions.assertEquals(trie.getWordsNumber(), 4);

        trie.insert("follow");
        Assertions.assertEquals(trie.getWordsNumber(), 5);
    }

    @Test
    public void insertionTest() {
        Trie trie = new Trie();
        trie.insert("ball");
        trie.insert("batman");

        Assertions.assertEquals(trie.print().toString(), "[ball, batman]");

        trie.insert("batman");
        Assertions.assertEquals(trie.print().toString(), "[ball, batman]");

        trie.insert("chess");
        Assertions.assertEquals(trie.print().toString(), "[ball, batman, chess]");
    }

    @Test
    public void insertionUsingWordConstructorTest() {
        Trie trie = new Trie("stairs");
        Assertions.assertEquals(trie.print().toString(), "[stairs]");
    }

    @Test
    public void insertionUsingWordsConstructorTest() {
        Trie trie = new Trie(new String[]{"ball", "batman", "chess", "stock"});
        Assertions.assertEquals(trie.print().toString(), "[ball, batman, chess, stock]");
    }

    @Test
    public void insertionWithCapitalLettersTest() {
        Trie trie = new Trie(new String[]{"Ball", "batMAN", "ChEsS", "PlAGUe"});
        Assertions.assertEquals(trie.print().toString(), "[ball, batman, chess, plague]");
    }
}
