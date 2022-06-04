package dsa_dp.data_structures;

import dsa_dp.data_structures.linked_list.SinglyLinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SinglyLinkedListTest {

    @Test
    public void correctAddElementTest() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.add(123);
        singlyLinkedList.add(43);
        singlyLinkedList.add(12);
        singlyLinkedList.add(76);

        Assertions.assertEquals(singlyLinkedList.get(1), 43);
        Assertions.assertEquals(singlyLinkedList.get(3), 76);
    }

    @Test
    public void correctInsertTest() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.addFirst(22);
        singlyLinkedList.add(43);
        singlyLinkedList.add(12);
        singlyLinkedList.add(76);
        singlyLinkedList.insert(3, 200);

        Assertions.assertEquals(singlyLinkedList.get(3), 200);
        Assertions.assertEquals(singlyLinkedList.get(4), 76);
    }

    @Test
    public void correctSizeTest() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.addFirst(22);
        singlyLinkedList.add(43);
        singlyLinkedList.add(12);
        singlyLinkedList.add(76);
        singlyLinkedList.insert(3, 200);

        Assertions.assertEquals(singlyLinkedList.size(), 5);
    }

    @Test
    public void correctRemoveTest() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.add(1);
        singlyLinkedList.add(2);
        singlyLinkedList.add(3);
        singlyLinkedList.add(4);
        singlyLinkedList.add(5);
        singlyLinkedList.add(6);
        singlyLinkedList.remove(4);

        Assertions.assertEquals(singlyLinkedList.get(4), 6);
    }

    @Test
    public void correctRemoveHeadTest() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.add(1);
        singlyLinkedList.add(2);
        singlyLinkedList.add(3);
        singlyLinkedList.add(4);
        singlyLinkedList.add(5);
        singlyLinkedList.add(6);
        singlyLinkedList.remove(0);

        Assertions.assertEquals(singlyLinkedList.get(4), 6);
    }
}
