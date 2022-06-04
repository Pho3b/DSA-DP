package dsa_dp.design_patterns.iterator.iterators;

public interface Iterator {
    Object next();
    boolean hasNext();
    void remove();
}
