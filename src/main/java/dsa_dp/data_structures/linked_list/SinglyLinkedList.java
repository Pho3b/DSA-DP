package dsa_dp.data_structures.linked_list;

public class SinglyLinkedList<T> {
    Node head = null;
    int size = 0;


    /**
     * Node item class,only accessible from the singlyLinkedList class
     */
    private class Node {
        public T data;
        public Node next;

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
            this.addFirst(data);
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
        checkIfIndexIsViable(index);
        Node currentNode = this.head;
        Node prevNode = null;

        for (int i = 0; i < index; i++) {
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
        checkIfIndexIsViable(index);
        Node currentNode = this.head;

        for (int i = 0; i < index; i++) {
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
        checkIfIndexIsViable(index);
        Node currentNode = this.head;

        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }

        currentNode.data = data;
    }

    /**
     * Removes the object at the given index of the LinkedList.
     *
     * @param index int
     * @throws IndexOutOfBoundsException out of range index
     */
    public void remove(int index) throws IndexOutOfBoundsException {
        checkIfIndexIsViable(index);

        // Handling the head removing case
        if (index == 0) {
            this.head = this.head.next;
            this.size--;
            return;
        }

        Node currentNode = this.head;
        Node prevNode = currentNode;

        for (int i = 0; i < index; i++) {
            prevNode = currentNode;
            currentNode = currentNode.next;
        }

        prevNode.next = currentNode.next;
        currentNode = null; // Unsetting the removed element
        this.size--;
    }

    /**
     * Prints the LinkedList in a suitable format
     * O(n)
     */
    public void print() {
        if (this.size > 0) {
            Node node = this.head;
            StringBuilder sb = new StringBuilder(this.size);
            sb.append("[");

            while (node != null) {
                sb.append(node.data).append(",");
                node = node.next;
            }

            sb.deleteCharAt(sb.length() - 1).append("]");
            System.out.println(sb);
        } else {
            System.out.println("[]");
        }
    }

    /**
     * Returns the current size of the LinkedList
     *
     * @return int
     */
    public int size() {
        return this.size;
    }

    /**
     * Throws an IndexOutOfBoundsException if the given index is out of the list boundaries
     *
     * @param index int
     */
    private void checkIfIndexIsViable(int index) {
        if (index > this.size - 1 || index < 0) throw new IndexOutOfBoundsException();
    }
}
