package studying.data_structures.sparse_table;

import studying.data_structures.sparse_table.range_combination_function_strategy.CombinationFunctionStrategy;
import studying.data_structures.sparse_table.range_combination_function_strategy.MaxCombinationFunction;
import studying.data_structures.sparse_table.range_combination_function_strategy.MinCombinationFunction;

import java.util.ArrayList;

public class SparseTable<T extends Comparable<T>> {
    private CombinationFunctionStrategy<T> cf;
    private ArrayList<ArrayList<T>> table;


    /**
     * Default constructor.
     * A Minimum sparse table is initialized by default
     */
    public SparseTable(T[] inputArr) {
        this(inputArr, SparseTableType.MIN);
    }

    /**
     * Constructor with given sparse table type (min, max, prod, gcd ecc...)
     *
     * @param inputArr T[]
     * @param type     TableType
     */
    public SparseTable(T[] inputArr, SparseTableType type) {
        switch (type) {
            case MAX:
                setCombinationFunction(new MaxCombinationFunction<>());
                break;
            case MIN:
            default:
                setCombinationFunction(new MinCombinationFunction<>());
        }

        this.constructTable(inputArr);
    }

    /**
     * Returns the result of the instantiated range query between the given indexes.
     * The result depends on the type of the instantiated sparse table.
     * TODO: A lookup table with all the pre-computed log2 values can be implemented in order to reduce the overhead
     *
     * @param i int
     * @param j int
     * @return T
     * @exception  IndexOutOfBoundsException if the given index is out of the table range
     */
    public T rangeQuery(int i, int j) {
        if (i < 0 || j > table.size())
            throw new IndexOutOfBoundsException();

        int range = (j - i) + 1;
        int p = (int) Math.floor(SparseTable.log2(range)); // Maximum power of 2 that fits into 'range'
        int k = (int) Math.pow(2, p);

        return cf.combine(table.get(i).get(p), table.get((j - k) + 1).get(p));
    }

    /**
     * Console prints the underlying sparse table data structure
     */
    public void print() {
        System.out.println(table);
    }

    /**
     * Returns the string format of the underlying sparse table data structure
     */
    public String toString() {
        return table.toString();
    }

    /**
     * Constructs the table with P+1 rows and N columns (The +1 is for the original values row), and then
     * populates it with the results of the chosen range combination function (min, max, prod, gcd ecc...)
     *
     * @param inputArr T[]
     */
    private void constructTable(T[] inputArr) {
        int n = inputArr.length; // Length of the input array
        int p = SparseTable.log2(n); // Max power of two that fits into N
        table = new ArrayList<>(n);

        // Constructing the empty table and populating the first Row
        for (int i = 0; i < n; i++) {
            ArrayList<T> tempColumn = new ArrayList<>(p + 1);
            tempColumn.add(inputArr[i]);
            table.add(tempColumn);

            for (int j = 1; j < p + 1; j++) {
                table.get(i).add(null);
            }
        }

        // Populating the sparse table with the combinationFunction resulting values
        for (int x = 1; x <= p; x++) {
            for (int i = 0; i + (1 << x) <= n; i++) { // The (1 << x) = Bitwise operator, left shift
                T combinationRes = cf.combine(table.get(i).get(x - 1), table.get(i + (1 << (x - 1))).get(x - 1));
                table.get(i).set(x, combinationRes);
            }
        }
    }

    /**
     * Sets the current strategy object 'combinationFunction' to the given implementation
     *
     * @param function CombinationFunctionStrategy<T>
     */
    private void setCombinationFunction(CombinationFunctionStrategy<T> function) {
        this.cf = function;
    }

    /**
     * Returns the base 2 logarithm of the given value as the nearest resulting Integer
     *
     * @param n int
     * @return int
     */
    static private int log2(int n) {
        return (int) Math.floor(Math.log(n) / Math.log(2));
    }

}
