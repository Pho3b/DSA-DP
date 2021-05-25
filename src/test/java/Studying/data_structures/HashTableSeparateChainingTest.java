package Studying.data_structures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import studying.data_structures.hash_table.HashTableSeparateChaining;

public class HashTableSeparateChainingTest {

    @Test
    public void noDuplicateAddedTest() {
        HashTableSeparateChaining<String, Integer> htSeparateChaining = new HashTableSeparateChaining<>();
        htSeparateChaining.put("andrea", 29);
        htSeparateChaining.put("federica", 30);
        htSeparateChaining.put("luigi", 36);
        htSeparateChaining.put("riccardo", 12);
        htSeparateChaining.put("giacomo", 29);
        htSeparateChaining.put("laura", 15);
        htSeparateChaining.put("giacomo", 29);
        htSeparateChaining.put("laura", 15);

        Assertions.assertEquals(6, htSeparateChaining.size());
    }

    @Test
    public void tableResizeTest() {
        HashTableSeparateChaining<String, Integer> htSeparateChaining = new HashTableSeparateChaining<>(3);
        htSeparateChaining.put("andrea", 29);
        htSeparateChaining.put("federica", 30);
        Assertions.assertEquals(3, htSeparateChaining.capacity());

        htSeparateChaining.put("riccardo", 12);
        htSeparateChaining.put("giacomo", 29);
        Assertions.assertEquals(6, htSeparateChaining.capacity());

        htSeparateChaining.put("simona", 29);
        Assertions.assertEquals(12, htSeparateChaining.capacity());
    }
}
