package Studying.data_structures.linked_list;

public class DoublyLInkedList<T> extends LinkedList<T> {

    /**
     * Node item class,only accessible from the LinkedListClass
     */
    public class Node {
        public T data;
        public Node next;
        public Node prev;

        public Node(T data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }

        public Node(T data, Node next, Node prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }
}
