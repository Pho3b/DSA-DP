package Studying.data_structures;

@SuppressWarnings("unchecked")
public class DynamicArray<E> {
    private static final int DEFAULT_SIZE = 10;
    private int capacity;
    private Object[] concreteArray;


    /**
     * Default empty param constructor
     */
    public DynamicArray() {
        this.initInternalConcreteArray(DynamicArray.DEFAULT_SIZE);
    }

    /**
     * User specified size constructor
     *
     * @param size int
     */
    public DynamicArray(int size) {
        this.initInternalConcreteArray(size);
    }

    /**
     * Retrieves the object at the specified index
     *
     * @param i int
     * @return Object
     * @throws IndexOutOfBoundsException index doesn't exist
     */
    public E get(int i) throws IndexOutOfBoundsException {
        final E e = (E)concreteArray[i];
        return e;
    }

    /**
     * Insert the given data at the specified index
     *
     * @param data E
     * @param index int
     * @throws IndexOutOfBoundsException index doesn't exist
     */
    public void push(E data, int index) throws IndexOutOfBoundsException {
        this.concreteArray[index] = data;
    }

    /**
     * Initializes the internal concrete Array with default or user given size
     * And the internal capacity with double the current concrete size
     *
     * @param size int
     */
    private void initInternalConcreteArray(int size) {
        this.capacity = size * 2;
        this.concreteArray = new Object[size];
    }

}
