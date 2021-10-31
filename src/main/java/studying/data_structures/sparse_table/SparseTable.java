package studying.data_structures.sparse_table;

import studying.data_structures.sparse_table.range_combination_function_strategy.CombinationFunctionStrategy;
import studying.data_structures.sparse_table.range_combination_function_strategy.MinCombinationFunction;

import java.util.ArrayList;

public class SparseTable<T extends Comparable<T>> {
    private CombinationFunctionStrategy<T> combinationFunction;
    private final T[] inputArr;
    private ArrayList<ArrayList<T>> table;


    /**
     * Default constructor.
     * A Minimum sparse table is initialized by default
     */
    public SparseTable(T[] inputArr) {
        this(SparseTableType.MIN, inputArr);
    }

    /**
     * Constructor with given sparse table type (min, max, prod, gcd ecc...)
     *
     * @param type     TableType
     * @param inputArr T[]
     */
    public SparseTable(SparseTableType type, T[] inputArr) {
        switch (type) {
            case MAX:
                break;
            case MIN:
            default:
                setCombinationFunction(new MinCombinationFunction<>());
        }

        this.inputArr = inputArr;
        this.constructTable();
    }

    /**
     * Sets the current strategy object 'combinationFunction' to the given implementation
     *
     * @param function CombinationFunctionStrategy<T>
     */
    public void setCombinationFunction(CombinationFunctionStrategy<T> function) {
        this.combinationFunction = function;
    }

    /**
     * Console prints the underlying sparse table data structure
     */
    public void print() {
        System.out.println(table);
    }

    /**
     * Constructs the table with P+1 rows and N columns (The +1 is for the original values row), and then
     * populates it with the results of the chosen range combination function (min, max, prod, gcd ecc...)
     * TODO: A lookup table with all the pre-computed log2 values can be implemented in order to reduce the overhead
     */
    private void constructTable() {
        int n = inputArr.length; // Length of the input array
        int p = SparseTable.log2(n); // Max power of two that fits into N
        table = new ArrayList<>(n);

        // Constructing the empty table and populating only the first Row
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
                T combinationRes = combinationFunction
                        .combine(table.get(i).get(x - 1), table.get(i + (1 << (x - 1))).get(x - 1));
                table.get(i).set(x, combinationRes);
            }
        }
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
