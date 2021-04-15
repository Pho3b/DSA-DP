package Studying.data_structures.stack;

public interface IStack<T> {
    public void push(T item);
    public T pop();
    public T peek();
    public T top();
    public boolean isEmpty();
}
