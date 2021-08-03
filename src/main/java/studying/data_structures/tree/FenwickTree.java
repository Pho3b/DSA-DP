package studying.data_structures.tree;

public class FenwickTree {


    FenwickTree(int[] tree) {

    }


    /**
     * Returns the value of the least significant bit of the given integer
     * It basically works because of how the "Two’s Complement" method (That is used to store binaries in memory) works.
     *
     * @return int
     */
    public static int lsb(int i) {
        return i & -i; // bit manipulation
    }
}
