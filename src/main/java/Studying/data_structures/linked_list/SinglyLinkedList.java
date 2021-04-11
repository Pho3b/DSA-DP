package Studying.data_structures.linked_list;

public class SinglyLinkedList<T> {
    Node head = null;
    int size = 0;


    /**
     * Node item class,only accessible from the LinkedListClass
     */
    private class Node {
        public T data;
        public Node next = null;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    /**
     * Adds a new node to the end of the LinkedList, returns true if it succeeds, false otherwise
     * If it's the first element, it sets it as the LinkedList 'head'
     *
     * @param data T
     * @return boolean
     */
    public boolean add(T data) {
        if (this.head == null) {
            this.head = new Node(data);
            this.size++;
            return true;
        }

        Node node = this.head;

        try {
            while (node.next != null) {
                node = node.next;
            }

            node.next = new Node(data);
            this.size++;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * Adds the given element at the first position of the LinkedList
     *
     * @param data T
     */
    public void addFirst(T data) {
        this.head = new Node(data, this.head);
        this.size++;
    }

    /**
     * Adds a node at the given index of the LinkedList
     * If the LinkedList is empty the Node will be set as the head
     * In case the specified index is out of range it throws an IndexOutOfBoundsException
     *
     * @param index int
     * @param data  T
     */
    public void insert(int index, T data) throws IndexOutOfBoundsException {
        Node currentNode = this.head;
        Node prevNode = null;

        for (int i = 0; i < index; i++) {
            if (currentNode == null) {
                throw new IndexOutOfBoundsException();
            }

            prevNode = currentNode;
            currentNode = currentNode.next;
        }

        assert prevNode != null;
        // Here the new Node is created.
        // The previous node will point to the new Node while the new node
        // will point to the node that the previous node was pointing to before.
        // Sorry for the pun :)
        prevNode.next = new Node(data, currentNode);
        this.size++;
    }

    /**
     * Returns the Object at the given index in the LinkedList, if the index
     * is out of range an IndexOutOfBoundsException is thrown
     *
     * @param index int
     * @return T
     * @throws IndexOutOfBoundsException out of range index
     */
    public T get(int index) throws IndexOutOfBoundsException {
        Node currentNode = this.head;

        for (int i = 0; i < index; i++) {
            if (currentNode == null) {
                throw new IndexOutOfBoundsException();
            }

            currentNode = currentNode.next;
        }

        return currentNode.data;
    }

    /**
     * Updates the object at the specified index with the given value
     *
     * @param index int
     * @param data  T
     */
    public void set(int index, T data) throws IndexOutOfBoundsException {
        Node currentNode = this.head;

        for (int i = 0; i < index; i++) {
            if (currentNode == null) {
                throw new IndexOutOfBoundsException();
            }

            currentNode = currentNode.next;
        }

        currentNode.data = data;
    }

    /**
     * Returns and also removes the object at the given index of the LinkedList.
     *
     * @param index int
     * @return T
     * @throws IndexOutOfBoundsException out of range index
     */
    public T remove(int index) throws IndexOutOfBoundsException {
        Node currentNode = this.head;

        for (int i = 0; i < index; i++) {
            if (currentNode == null) {
                throw new IndexOutOfBoundsException();
            }

            currentNode = currentNode.next;
        }

        T res = currentNode.data;
        currentNode = null; // Unsetting the removed element
        this.size--;

        return res;
    }

    /**
     * Prints the LinkedList in a suitable format
     */
    public void print() {
        Node node = this.head;
        StringBuilder sb = new StringBuilder(this.size);
        sb.append("[");

        while (node.next != null) {
            sb.append(node.data).append(",");
        }

        sb.deleteCharAt(sb.length() - 1).append("]");
        System.out.print(sb);
    }
}
