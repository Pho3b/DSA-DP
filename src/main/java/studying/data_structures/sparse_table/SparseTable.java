package studying.data_structures.sparse_table;

import studying.data_structures.sparse_table.range_combination_function_strategy.CombinationFunctionStrategy;
import studying.data_structures.sparse_table.range_combination_function_strategy.MinCombinationFunction;

import java.util.ArrayList;

public class SparseTable<T extends Comparable<T>> {
    // N = Length of the input array
    // P = max power of two that fits into N

    // Init table with P+1 rows and N columns (The +1 is for the original values row)

    // Then each cell (i, j) represents the answer for the range [j, j+2*i] in the original array
    // EXAMPLE: cell (2, 5) represents the answer for the range [5, 9] non inclusive (9). The value depends on which
    //          type of sparse table we built (min, max ecc..)

    // When constructing a new sparse table we need to define a 'range combination function' that will set
    // what type of sparse table (or which query result) we want to obtain. Minimum, max, multiplication ecc..
    // EXAMPLE of 'range combination function for a min sparse table: f(x, y) = min(x, y)
    private CombinationFunctionStrategy<T> combinationFunction;
    private final T[] inputArr;
    private ArrayList<ArrayList<T>> table;

    /**
     * Default constructor.
     * A Minimum sparse table is initialized by default
     */
    public SparseTable(T[] inputArr) {
        this(TableType.MIN, inputArr);
    }

    public SparseTable(TableType type, T[] inputArr) {
        switch (type) {
            case MAX:
                break;
            case MIN:
            default:
                setCombinationFunction(new MinCombinationFunction<>());
        }

        this.inputArr = inputArr;
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
     * Simple print of the Sparse table
     */
    public void print() {
        System.out.println(table);
    }

    private void constructTable() {
        int n = inputArr.length;
        int p = SparseTable.log2(n);

        this.initTable(n, p);
        this.populateTable(n, p);
    }

    // N = Length of the input array
    // P = max power of two that fits into N
    // Init table with P+1 rows and N columns (The +1 is for the original values row)
    private void initTable(int n, int p) {
        table = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            ArrayList<T> tempColumn = new ArrayList<>(p + 1);
            tempColumn.add(inputArr[i]); // Setting the first value of the column
            table.add(tempColumn); // Adding the column to the table

            for (int j = 1; j < p + 1; j++) {
                table.get(i).add(null);
            }
        }
    }

    private void populateTable(int n, int p) {
//        for (int i = 0; i < n; i++) {
//            for (int j = 1; j < p + 1; j++) {
//                int y = (int) (j + (Math.pow(2, i)));
//                table.get(j).set(y, );
//            }
//        }
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
