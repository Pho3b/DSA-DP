package studying.data_structures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import studying.data_structures.hash_table.HashTableSeparateChaining;

public class HashTableSeparateChainingTest {

    @Test
    public void noDuplicateAddedTest() {
        HashTableSeparateChaining<String, Integer> htSeparateChaining = new HashTableSeparateChaining<>();
        htSeparateChaining.add("andrea", 29);
        htSeparateChaining.add("federica", 30);
        htSeparateChaining.add("luigi", 36);
        htSeparateChaining.add("riccardo", 12);
        htSeparateChaining.add("giacomo", 29);
        htSeparateChaining.add("laura", 15);
        htSeparateChaining.add("giacomo", 29);
        htSeparateChaining.add("laura", 15);

        Assertions.assertEquals(6, htSeparateChaining.size());
    }

    @Test
    public void tableResizeTest() {
        HashTableSeparateChaining<String, Integer> htSeparateChaining = new HashTableSeparateChaining<>(3);
        htSeparateChaining.add("andrea", 29);
        htSeparateChaining.add("federica", 30);
        Assertions.assertEquals(3, htSeparateChaining.capacity());

        htSeparateChaining.add("riccardo", 12);
        htSeparateChaining.add("giacomo", 29);
        Assertions.assertEquals(6, htSeparateChaining.capacity());

        htSeparateChaining.add("simona", 29);
        Assertions.assertEquals(12, htSeparateChaining.capacity());
    }

    @Test
    public void correctUpdateTest() {
        HashTableSeparateChaining<String, Integer> htSeparateChaining = new HashTableSeparateChaining<>();
        htSeparateChaining.add("andrea", 28);
        htSeparateChaining.add("federica", 30);
        Assertions.assertEquals(28, htSeparateChaining.get("andrea"));

        Assertions.assertTrue(htSeparateChaining.put("andrea", 29));
        Assertions.assertEquals(29, htSeparateChaining.get("andrea"));
    }

    @Test
    public void correctRemoveTest() {
        HashTableSeparateChaining<String, Integer> htSeparateChaining = new HashTableSeparateChaining<>();
        htSeparateChaining.add("andrea", 28);
        htSeparateChaining.add("federica", 30);
        Assertions.assertEquals(2, htSeparateChaining.size());

        htSeparateChaining.remove("andrea");
        Assertions.assertEquals(1, htSeparateChaining.size());
        Assertions.assertNull(htSeparateChaining.get("andrea"));
    }

    @Test
    public void retrieveValuesTest() {
        HashTableSeparateChaining<String, Integer> htSeparateChaining = new HashTableSeparateChaining<>();
        htSeparateChaining.add("andrea", 28);
        htSeparateChaining.add("federica", 30);
        Assertions.assertEquals(28, htSeparateChaining.get("andrea"));
        Assertions.assertEquals(30, htSeparateChaining.get("federica"));
    }
}
