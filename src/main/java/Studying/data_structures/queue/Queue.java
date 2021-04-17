package Studying.data_structures.queue;

import Studying.data_structures.linked_list.SinglyLinkedList;

public class Queue<T> implements IQueue<T> {
    private final SinglyLinkedList<T> list = new SinglyLinkedList<>();
    private int maxSize = -1;


    /**
     * Default constructor
     */
    public Queue() {
    }

    /**
     * Given max size constructor
     *
     * @param maxSize int
     */
    public Queue(int maxSize) {
        this.maxSize = maxSize;
    }

    /**
     * Adds a new item to the head of the list
     *
     * @param item T
     */
    public void enqueue(T item) {
        this.list.add(item);
    }

    /**
     * Removes and returns the first element added to the queue
     * (Front of the Queue)
     *
     * @return T
     * @throws IndexOutOfBoundsException exception
     */
    public T dequeue() throws IndexOutOfBoundsException {
        T data = this.list.get(0);
        this.list.remove(0);

        return data;
    }

    /**
     * Reads the element at the front of the queue without removing it
     *
     * @return T
     */
    public T peek() {
        return this.list.get(0);
    }

    /**
     * Returns true if the Queue reached it's max size
     * A queue with a -1 max size doesn't reach a 'full' state
     *
     * @return boolean
     */
    public boolean isFull() {
        return this.maxSize != -1 && this.list.size() >= this.maxSize;
    }

    /**
     * Returns true if the Queue size is equal to 0
     *
     * @return boolean
     */
    public boolean isEmpty() {
        return this.list.size() <= 0;
    }

    /**
     * Returns the current Queue size
     *
     * @return int
     */
    public int size() {
        return this.list.size();
    }

    /**
     * Prints the Queue in a suitable format
     * O(n)
     */
    public void print() {
        this.list.print();
    }
}
