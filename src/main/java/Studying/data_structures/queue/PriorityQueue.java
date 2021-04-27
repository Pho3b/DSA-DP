package Studying.data_structures.queue;

import Studying.data_structures.heap.BinaryHeap;

public class PriorityQueue<T extends Comparable<T>> {
    private final BinaryHeap<T> heap;


    /**
     * Default constructor
     */
    public PriorityQueue() {
        heap = new BinaryHeap<>();
    }

    /**
     * Constructor with given size
     *
     * @param size int
     */
    public PriorityQueue(int size) {
        heap = new BinaryHeap<>(size);
    }

    /**
     * Adds a new element inside the priorityQueue
     *
     * @param data T
     */
    public void enqueue(T data) {
        heap.insert(data);
    }

    /**
     * Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
     *
     * @return T
     */
    public T peek() {
        return heap.peek();
    }

    /**
     * Retrieves and removes the head of this queue, or returns null if this queue is empty.
     *
     * @return T
     */
    public T dequeue() {
        return heap.poll();
    }

    /**
     * Removes a single instance of the specified element from this queue, if it is present.
     *
     * @return T
     */
    public T remove(T data) {
        return heap.remove(data);
    }

    /**
     * Returns whether the priorityQueue contains the given element or not
     *
     * @param data T
     * @return boolean
     */
    public boolean contains(T data) {
        return heap.contains(data);
    }

    /**
     * Prints the PriorityQueue in a suitable format
     * O(n)
     */
    public void print() {
        this.heap.linearPrint();
    }
}
