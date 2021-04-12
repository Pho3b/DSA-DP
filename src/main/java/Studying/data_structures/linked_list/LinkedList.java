package Studying.data_structures.linked_list;

public abstract class LinkedList<T> {
    SinglyLinkedList<T>.Node head = null;
    int size = 0;


    /**
     * Prints the LinkedList in a suitable format
     */
    public void print() {
        SinglyLinkedList<T>.Node node = this.head;
        StringBuilder sb = new StringBuilder(this.size);
        sb.append("[");

        while (node != null) {
            sb.append(node.data).append(",");
            node = node.next;
        }

        sb.deleteCharAt(sb.length() - 1).append("]");
        System.out.print(sb);
    }

    /**
     * Returns the current size of the LinkedList
     *
     * @return int
     */
    public int size() {
        return this.size;
    }
}
