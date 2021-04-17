package Studying.data_structures.stack;

import Studying.data_structures.linked_list.DoublyLInkedList;

public class Stack<T> implements IStack<T> {
    private final DoublyLInkedList<T> list = new DoublyLInkedList<>();


    /**
     * Pushes a new item on top of the Stack
     *
     * @param item T
     */
    public void push(T item) {
        this.list.add(item);
    }

    /**
     * Removes and Returns the last inserted element
     *
     * @return T
     */
    public T pop() {
        return this.list.removeLast();
    }

    /**
     * Reads the top element of the Stack without removing it
     *
     * @return T
     * @throws IndexOutOfBoundsException in bound index
     */
    public T peek() throws IndexOutOfBoundsException {
        return this.list.get(this.list.size() - 1);
    }

    /**
     * Reads the top element of the Stack without removing it
     *
     * @return T
     * @throws IndexOutOfBoundsException in bound index
     */
    public T top() throws IndexOutOfBoundsException {
        return this.list.get(this.list.size() - 1);
    }

    /**
     * Returns true if the current Stack size is less or equal to zero
     *
     * @return boolean
     */
    public boolean isEmpty() {
        return this.list.size() <= 0;
    }

    /**
     * Returns the current size of the Stack
     * O(1)
     *
     * @return int
     */
    public int size() {
        return this.list.size();
    }

    /**
     * Prints the Stack internal values in a chronological insertion order
     */
    public void print() {
        this.list.print();
    }
}
