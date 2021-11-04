package studying.data_structures;

import studying.data_structures.linked_list.DoublyLInkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DoublyLinkedListTest {

    @Test
    public void correctAddElementTest() {
        DoublyLInkedList<Integer> doublyLinkedList = new DoublyLInkedList<>();
        doublyLinkedList.add(123);
        doublyLinkedList.add(43);
        doublyLinkedList.add(12);
        doublyLinkedList.add(76);

        Assertions.assertEquals(doublyLinkedList.get(1), 43);
        Assertions.assertEquals(doublyLinkedList.get(3), 76);
    }

    @Test
    public void correctInsertTest() {
        DoublyLInkedList<Integer> doublyLinkedList = new DoublyLInkedList<>();
        doublyLinkedList.addFirst(22);
        doublyLinkedList.add(43);
        doublyLinkedList.add(12);
        doublyLinkedList.add(76);
        doublyLinkedList.insert(3, 200);

        Assertions.assertEquals(doublyLinkedList.get(3), 200);
        Assertions.assertEquals(doublyLinkedList.get(4), 76);
    }

    @Test
    public void correctSizeTest() {
        DoublyLInkedList<Integer> doublyLinkedList = new DoublyLInkedList<>();
        doublyLinkedList.addFirst(22);
        doublyLinkedList.add(43);
        doublyLinkedList.add(12);
        doublyLinkedList.add(76);
        doublyLinkedList.insert(3, 200);

        Assertions.assertEquals(doublyLinkedList.size(), 5);
    }

    @Test
    public void correctRemoveTest() {
        DoublyLInkedList<Integer> doublyLinkedList = new DoublyLInkedList<>();
        doublyLinkedList.add(1);
        doublyLinkedList.add(2);
        doublyLinkedList.add(3);
        doublyLinkedList.add(4);
        doublyLinkedList.add(5);
        doublyLinkedList.add(6);
        doublyLinkedList.remove(4);

        Assertions.assertEquals(doublyLinkedList.get(4), 6);
    }
}
