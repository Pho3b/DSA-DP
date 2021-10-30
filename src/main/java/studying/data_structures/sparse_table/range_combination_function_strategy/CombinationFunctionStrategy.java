package studying.data_structures.sparse_table.range_combination_function_strategy;

public interface CombinationFunctionStrategy<T extends Comparable<T>> {
    T combine(T i, T j);
}
