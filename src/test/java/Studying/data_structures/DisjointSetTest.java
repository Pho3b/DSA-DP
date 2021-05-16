package Studying.data_structures;

import Studying.UtilityClass;
import studying.data_structures.disjoint_set.DisjointSet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Hashtable;

public class DisjointSetTest {
    Hashtable<Character, Integer> btChars = UtilityClass.generateRandomCharsBijectionTable();
    Hashtable<String, Integer> btPeople = UtilityClass.generateStringsBijectionTable();

    @Test
    public void correctUnionTest() {
        DisjointSet disjointSet = new DisjointSet(3);
        disjointSet.union(btChars.get('E'), btChars.get('F'));
        disjointSet.union(btChars.get('F'), btChars.get('I'));

        Assertions.assertEquals(disjointSet.find(btChars.get('F')), disjointSet.find(btChars.get('I')));
    }

    @Test
    public void incorrectUnionTest() {
        DisjointSet disjointSet = new DisjointSet(6);
        disjointSet.union(btChars.get('E'), btChars.get('F'));
        disjointSet.union(btChars.get('F'), btChars.get('I'));
        disjointSet.union(btChars.get('D'), btChars.get('A'));
        disjointSet.union(btChars.get('D'), btChars.get('F'));

        Assertions.assertNotEquals(disjointSet.find(btChars.get('F')), disjointSet.find(btChars.get('C')));
        Assertions.assertEquals(disjointSet.find(btChars.get('D')), disjointSet.find(btChars.get('E')));
    }

    @Test
    public void correctPeopleUnionAndFindTest() {
        DisjointSet disjointSet = new DisjointSet(7);
        disjointSet.union(btPeople.get("Simona"), btPeople.get("Federica"));
        disjointSet.union(btPeople.get("Alessandra"), btPeople.get("Simona"));
        disjointSet.union(btPeople.get("Marco"), btPeople.get("Matteo"));
        disjointSet.union(btPeople.get("Matteo"), btPeople.get("Andrea"));
        disjointSet.union(btPeople.get("Matteo"), btPeople.get("Giovanni"));

        Assertions.assertNotEquals(disjointSet.find(btPeople.get("Simona")), disjointSet.find(btPeople.get("Andrea")));
        Assertions.assertEquals(disjointSet.find(btPeople.get("Andrea")), disjointSet.find(btPeople.get("Marco")));
        Assertions.assertEquals(disjointSet.find(btPeople.get("Giovanni")), disjointSet.find(btPeople.get("Marco")));
        Assertions.assertEquals(disjointSet.find(btPeople.get("Matteo")), disjointSet.find(btPeople.get("Giovanni")));
        Assertions.assertNotEquals(disjointSet.find(btPeople.get("Alessandra")), disjointSet.find(btPeople.get("Marco")));
    }

    @Test
    public void areUnifiedMethodTest() {
        DisjointSet disjointSet = new DisjointSet(7);
        disjointSet.union(btPeople.get("Simona"), btPeople.get("Federica"));
        disjointSet.union(btPeople.get("Alessandra"), btPeople.get("Simona"));
        disjointSet.union(btPeople.get("Marco"), btPeople.get("Matteo"));
        disjointSet.union(btPeople.get("Matteo"), btPeople.get("Andrea"));
        disjointSet.union(btPeople.get("Matteo"), btPeople.get("Giovanni"));

        Assertions.assertFalse(disjointSet.areUnified(btPeople.get("Simona"), btPeople.get("Andrea")));
        Assertions.assertTrue(disjointSet.areUnified(btPeople.get("Andrea"), btPeople.get("Marco")));
        Assertions.assertTrue(disjointSet.areUnified(btPeople.get("Giovanni"), btPeople.get("Marco")));
        Assertions.assertTrue(disjointSet.areUnified(btPeople.get("Matteo"), btPeople.get("Giovanni")));
        Assertions.assertFalse(disjointSet.areUnified(btPeople.get("Alessandra"), btPeople.get("Marco")));
    }
}
