package dsa_dp.data_structures.hash_table;

/**
 * A container of probing methods that can be used in the OpenAddressing hashTable type.
 */
public class Probe {

    /**
     * Returns a new index based on the given key and index pair,
     * the new index is calculated using a linear function
     * <p>
     * NOTE: In order to make it possible for the method to return a full cycle for N, we need to make
     * sure that 'index' and N(table capacity) are relatively prime numbers
     * <p>
     * RELATIVELY PRIME NUMBERS DEFINITION: Two numbers that have 1 as they're greatest common denominator(GCD)
     *
     * @param index int
     * @return int
     */
    public static int linearProbing(int index) {
        return 5 * index;
    }
}
