package Studying.data_structures.queue;

public interface IQueue<T> {
    public void enqueue(T item);
    public T dequeue();
    public T peek();
    public boolean isFull();
    public boolean isEmpty();
}
