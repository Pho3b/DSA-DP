package studying.data_structures.tree;

import java.util.Arrays;

public class FenwickTree {
    private final int[] tree;


    /**
     * Default constructor
     * It constructs the Fenwick Tree in linear time by updating the first parent every iteration
     *
     * @param arr int[]
     */
    public FenwickTree(int[] arr) {
        this.tree = new int[arr.length];
        System.arraycopy(arr, 0, tree, 0, arr.length);

        for (int i = 1; i < tree.length; i++) {
            int lsb = FenwickTree.lsb(i);
            int parentIndex = i + lsb;

            if (parentIndex <= tree.length) {
                tree[parentIndex] = (tree[i] + tree[i + lsb]);
            }
        }
    }

    /**
     * Returns the sum of the elements between the given indexes range
     *
     * @return int
     */
    public int rangeQuery(int i, int j) {
        return this.prefixSum(j) - this.prefixSum(i - 1);
    }

    /**
     * Returns the sum of the elements from zero to a given index
     *
     * @return int
     */
    public int prefixSum(int i) {
        int res = 0;

        while (i >= 1) {
            res += this.tree[i];
            i -= FenwickTree.lsb(i);
        }

        return res;
    }

    /**
     * Updates the value of the given index of the tree.
     * It (Under the hood) also updates all the chosen index related values, in order
     * to keep the FenwickTree invariant
     *
     * @param i     index
     * @param toAdd int to add
     */
    public void add(int i, int toAdd) {
        while (i <= this.tree.length - 1) {
            this.tree[i] += toAdd;
            i += FenwickTree.lsb(i);
        }
    }

    /**
     * Just a name variation of the 'add()' method.
     * Refer to the 'add' method doc.
     *
     * @param i     index
     * @param toAdd int to add
     */
    public void update(int i, int toAdd) {
        this.add(i, toAdd);
    }

    /**
     * Prints the data structure in a suitable format
     */
    public void print() {
        System.out.println(Arrays.toString(this.tree));
    }

    /**
     * Returns the value of the "least significant bit" of the given integer
     * It basically works because of how the "Two’s Complement" method works.
     *
     * @return int
     */
    private static int lsb(int i) {
        return i & -i; // bit manipulation
    }
}
