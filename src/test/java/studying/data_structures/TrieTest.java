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
        Assertions.assertEquals(trie.print(), "[ball, batman]");

        trie.insert("batman");
        Assertions.assertEquals(trie.print(), "[ball, batman]");

        trie.insert("chess");
        Assertions.assertEquals(trie.print(), "[ball, batman, chess]");
    }

    @Test
    public void insertionUsingWordConstructorTest() {
        Trie trie = new Trie("stairs");
        Assertions.assertEquals(trie.print(), "[stairs]");
    }

    @Test
    public void insertionUsingWordsConstructorTest() {
        Trie trie = new Trie(new String[]{"ball", "batman", "chess", "stock"});
        Assertions.assertEquals(trie.print(), "[ball, batman, chess, stock]");
    }

    @Test
    public void insertionWithCapitalLettersTest() {
        Trie trie = new Trie(new String[]{"Ball", "batMAN", "ChEsS", "PlAGUe"});
        Assertions.assertEquals(trie.print(), "[ball, batman, chess, plague]");
    }

    @Test
    public void prefixSearchTest() {
        Trie trie = new Trie(new String[]{"Ball", "batMAN", "ChEsS", "PlAGUe"});

        Assertions.assertTrue(trie.searchPrefix("ba"));
        Assertions.assertFalse(trie.searchPrefix("cia"));
        Assertions.assertTrue(trie.searchPrefix("ches"));
        Assertions.assertFalse(trie.searchPrefix("chesss"));
        Assertions.assertFalse(trie.searchPrefix("chesss"));
        Assertions.assertFalse(trie.searchPrefix("sdfas"));
        Assertions.assertFalse(trie.searchPrefix("gjjhgd"));
        Assertions.assertTrue(trie.searchPrefix("plague"));
        Assertions.assertTrue(trie.searchPrefix("p"));
        Assertions.assertTrue(trie.searchPrefix("pl"));
        Assertions.assertTrue(trie.searchPrefix("plag"));
    }
}
