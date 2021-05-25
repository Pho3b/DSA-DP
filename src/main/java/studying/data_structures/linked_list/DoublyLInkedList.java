package studying.data_structures.linked_list;

public class DoublyLInkedList<T> {
    Node head = null;
    // For the doublyLinkedList we will keep a pointer to the tail of the list
    // in order to increase the performance for some tasks, starting from the get() action
    Node tail = null;
    int size = 0;


    /**
     * Node item class,only accessible from the DoublyLinkedList class
     */
    private class Node {
        public T data;
        public Node next;
        public Node prev;

        public Node(T data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }

        public Node(T data, Node prev) {
            this.data = data;
            this.prev = prev;
            this.next = null;
        }

        public Node(T data, Node prev, Node next) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    /**
     * Adds the given element at the first position of the LinkedList
     *
     * @param data T
     */
    public void addFirst(T data) {
        Node toAddNode = new Node(data, null, this.head);

        this.tail = this.head == null ? toAddNode : this.head;
        this.head = toAddNode;
        this.size++;
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

            node.next = new Node(data, node);
            this.tail = node.next;
            this.size++;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * Adds a node at the given index of the LinkedList
     * In case the specified index is out of range it throws an IndexOutOfBoundsException
     *
     * @param index int
     * @param data  T
     */
    public void insert(int index, T data) throws IndexOutOfBoundsException {
        this.checkIfIndexIsViable(index);
        Node nextNode = this.head;
        Node currentNode = null;

        for (int i = 0; i < index; i++) {
            currentNode = nextNode;
            nextNode = currentNode.next;
        }

        assert currentNode != null;
        currentNode.next = new Node(data, currentNode, nextNode);
        this.size++;

        if (nextNode == null) {
            this.tail = currentNode.next;
        } else {
            nextNode.prev = currentNode.next;
        }
    }

    /**
     * Returns the Object at the given index in the LinkedList, if the index
     * is out of range an IndexOutOfBoundsException is thrown
     * Because here we are working with a doublyLinkedList we can cut the time complexity to O(n/2)
     *
     * @param index int
     * @return T
     * @throws IndexOutOfBoundsException out of range index
     */
    public T get(int index) throws IndexOutOfBoundsException {
        checkIfIndexIsViable(index);
        Node currentNode;

        if (index < this.size / 2) {
            currentNode = this.head;

            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
        } else {
            currentNode = this.tail;

            for (int i = this.size - 1; i > index; i--) {
                currentNode = currentNode.prev;
            }
        }

        return currentNode.data;
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
        if (index == 0 && this.head.next != null) {
            this.head = this.head.next;
            this.head.prev = null;
            this.size--;
            return;
        }

        Node currentNode = this.head;
        Node prevNode = currentNode;

        for (int i = 0; i < index; i++) {
            prevNode = currentNode;
            currentNode = currentNode.next;
        }

        assert prevNode != null;
        prevNode.next = currentNode.next;

        if (prevNode.next != null) {
            prevNode.next.prev = prevNode;
        } else {
            this.tail = prevNode;
        }

        currentNode = null; // Unsetting the removed element. Pretending to use the C language
        this.size--;
    }

    /**
     * If the list is not empty, it removes and returns the last element of the list
     *
     * @return T
     * @throws IndexOutOfBoundsException in bounds index
     */
    public T removeLast() throws IndexOutOfBoundsException {
        T res = this.get(this.size - 1);
        this.remove(this.size - 1);

        return res;
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
     * O(1)
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

    /**
     * Prints the internal properties of a node
     *
     * @param currentNode Node
     */
    private void debugPrintNode(Node currentNode) {
        T prev = currentNode.prev != null ? currentNode.prev.data : null;
        T next = currentNode.next != null ? currentNode.next.data : null;
        System.out.println(prev + " " + currentNode.data + " " + next + " Tail: " + this.tail.data);
    }
}
