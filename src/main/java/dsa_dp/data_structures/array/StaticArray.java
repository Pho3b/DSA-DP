package dsa_dp.data_structures.array;

import java.lang.reflect.Array;

/*
 * For static arrays, Insertion Appending and Deletion don't really make sense.
 * To perform these actions the Dynamic Array is the choice
 *
 * Access - O(1)
 * Search - O(n)
 * Insertion - N/A
 * Appending - N/A
 * Deletion - N/A
 */
@SuppressWarnings("unchecked")

public class StaticArray {
    private final int[] staticIntegerArray = new int[]{12, 34, 54, 12, 67, 2};
    private final float[] staticFloatArray = new float[5];
    private final int size;
    private final String type;


    /**
     * @param size of the array
     * @param type of the array
     */
    public StaticArray(int size, String type) {
        this.size = size;
        this.type = type;
    }

    /**
     * Returns a new array of the current instance 'type'.
     *
     * @return T[]
     */
    public <T> T[] retrieveStaticArray() {
        switch (this.type.toLowerCase()) {
            case "integer":
                return (T[]) Array.newInstance(Integer.class, this.size);
            case "string":
                return (T[]) Array.newInstance(String.class, this.size);
            case "character":
                return (T[]) Array.newInstance(Character.class, this.size);
            case "float":
                return (T[]) Array.newInstance(Float.class, this.size);
            default:
                return (T[]) new Object[]{};
        }
    }
}
