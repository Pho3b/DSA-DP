package Studying.data_structures;

/*
 * Access - O(1)
 * Search - O(n)
 * Insertion - O(1)
 * Appending - { Best case O(1) Worst case O(n) }
 * Deletion - { O(1) with Pop }
 */
@SuppressWarnings("unchecked")

public class DynamicArray<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private int capacity;
    private int size = 0;
    private Object[] concreteArray;


    /**
     * Default constructor
     */
    public DynamicArray() {
        this.initInternalsData(DynamicArray.DEFAULT_CAPACITY);
    }

    /**
     * Specified capacity constructor
     *
     * @param capacity int
     */
    public DynamicArray(int capacity) {
        this.initInternalsData(capacity);
    }

    /**
     * Retrieves the object at the specified index
     *
     * @param i int
     * @return Object
     * @throws IndexOutOfBoundsException index doesn't exist
     */
    public E get(int i) throws IndexOutOfBoundsException {
        return (E) concreteArray[i];
    }

    /**
     * Updates the internal size variable and try to push the given element at the end of the array.
     * If we run out of space, it first calls the method to double the size of the array and re-copy
     * all the objects inside of it.
     *
     * @param data E
     */
    public void push(E data) {
        this.size++;

        if (this.size >= this.capacity) {
            this.concreteArray = this.doubleConcreteArraySize();
        }

        this.concreteArray[this.size - 1] = data;
    }

    /**
     * Insert the given data at the specified index
     *
     * @param data  E
     * @param index int
     * @throws IndexOutOfBoundsException index doesn't exist
     */
    public void push(E data, int index) throws IndexOutOfBoundsException {
        this.concreteArray[index] = data;
    }

    /**
     * Deletes the last element of the array
     */
    public void pop() {
        if (this.size > 0) {
            this.concreteArray[this.size - 1] = null;
            this.size--;
        }
    }

    /**
     * Returns the current size of the array (
     *
     * @return int size
     */
    public int size() {
        return this.size;
    }

    /**
     * Prints the array in a suitable format
     */
    public void print() {
        StringBuilder sb = new StringBuilder(this.capacity);
        sb.append("[");

        for (int i = 0; i < this.size; i++) {
            sb.append(this.concreteArray[i]).append(",");
        }

        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        System.out.print(sb);
    }

    /**
     * Doubles the size of the internal 'capacity' property and returns a new array having
     * double the size of the 'this.concreteArray' initial one.
     * The returned array will still have all the previous object elements.
     *
     * @return Object[] temp
     */
    private Object[] doubleConcreteArraySize() {
        this.capacity *= 2;
        Object[] temp = new Object[this.capacity];

        if (this.size >= 0) System.arraycopy(this.concreteArray, 0, temp, 0, this.size);

        return temp;
    }

    /**
     * Initializes the internal concrete Array size and capacity with the given size
     *
     * @param capacity int
     */
    private void initInternalsData(int capacity) {
        this.capacity = capacity;
        this.concreteArray = new Object[capacity];
    }
}
