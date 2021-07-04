package Studying.data_structures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import studying.data_structures.hash_table.HashTableOpenAddressing;

public class HashTableOpenAddressingTest {

    @Test
    public void correctAddNoResizeTest() {
        HashTableOpenAddressing<String, Integer> htOpenAddressing = new HashTableOpenAddressing<>();
        htOpenAddressing.add("andrea", 29);
        htOpenAddressing.add("federica", 30);
        htOpenAddressing.add("luigi", 36);
        htOpenAddressing.add("riccardo", 12);
        htOpenAddressing.add("giacomo", 29);
        htOpenAddressing.add("laura", 15);
        htOpenAddressing.add("giacomo", 29);
        htOpenAddressing.add("laura", 15);

        Assertions.assertEquals(8, htOpenAddressing.size());
    }

    @Test
    public void wrongLoadFactorTest() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            HashTableOpenAddressing<String, Integer> htOpenAddressing = new HashTableOpenAddressing<>(3);
        });
    }

    @Test
    public void tableResizeTest() {
        HashTableOpenAddressing<String, Integer> htOpenAddressing = new HashTableOpenAddressing<>(0.4f);
        htOpenAddressing.add("andreanb", 29);
        htOpenAddressing.add("gdgfdg", 29);
        htOpenAddressing.add("jhjh", 29);
        htOpenAddressing.add("ahjfgdf", 29);
        htOpenAddressing.add("federica", 30);
        htOpenAddressing.add("luigi", 36);
        htOpenAddressing.add("luigi", 36);
        htOpenAddressing.add("luigi", 36);
        htOpenAddressing.add("andrear", 29);

        Assertions.assertEquals(24, htOpenAddressing.capacity());

        htOpenAddressing.add("riccardo", 12);
        htOpenAddressing.add("giacomo", 29);

        Assertions.assertEquals(48, htOpenAddressing.capacity());
        Assertions.assertEquals(11, htOpenAddressing.size());
    }

    @Test
    public void correctGetTest() {
        HashTableOpenAddressing<Character, Integer> htOpenAddressing = new HashTableOpenAddressing<>(0.4f);
        htOpenAddressing.add('A', 0);
        htOpenAddressing.add('b', 2);
        htOpenAddressing.add('C', 12);
        htOpenAddressing.add('d', 65);
        htOpenAddressing.add('e', 34);
        htOpenAddressing.add('F', 12);
        htOpenAddressing.add('f', 90);

        Assertions.assertNull(htOpenAddressing.get('Z'));
        Assertions.assertEquals(90, htOpenAddressing.get('f'));
        Assertions.assertEquals(0, htOpenAddressing.get('A'));
        Assertions.assertNotEquals(12, htOpenAddressing.get('b'));
        Assertions.assertEquals(2, htOpenAddressing.get('b'));
        Assertions.assertNull(htOpenAddressing.get('B'));
    }

    @Test
    public void correctPutTest() {
        HashTableOpenAddressing<Character, Integer> htOpenAddressing = new HashTableOpenAddressing<>(0.4f);
        htOpenAddressing.add('a', 22);
        htOpenAddressing.add('>', 8656);

        Assertions.assertEquals(22, htOpenAddressing.get('a'));
        Assertions.assertEquals(8656, htOpenAddressing.get('>'));

        htOpenAddressing.put('a', 23);
        htOpenAddressing.put('>', 12);
        Assertions.assertNotEquals(8656, htOpenAddressing.get('>'));
        Assertions.assertEquals(23, htOpenAddressing.get('a'));
        Assertions.assertEquals(12, htOpenAddressing.get('>'));
    }
}
