package dsa_dp.data_structures.sparse_table.range_combination_function_strategy;

public class MaxCombinationFunction<T extends Comparable<T>> implements CombinationFunctionStrategy<T> {

    /**
     * Returns the 'maximum' value between i and j
     *
     * @param i T
     * @param j T
     * @return T
     */
    @Override
    public T combine(T i, T j) {
        return i.compareTo(j) > 0 ? i : j;
    }
}
