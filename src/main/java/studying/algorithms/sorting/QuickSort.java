package studying.algorithms.sorting;

import java.util.ArrayList;
import java.util.Random;

public class QuickSort<T extends Comparable<T>> {

    /**
     * Publicly exposed method that sorts the given array using the 'Quicksort' algorithm
     *
     * @param arr The array you want to sort
     */
    public void sort(ArrayList<T> arr) {
        quicksort(arr, 0, arr.size() - 1);
    }

    /**
     * Inner method that sorts the given array using the 'Quicksort' algorithm
     *
     * @param arr  the input arrayList that needs to be sorted
     * @param low  lower bound of the array section that we want to partition
     * @param high upper bound of the array section that we want to partition
     */
    private void quicksort(ArrayList<T> arr, int low, int high) {
        if (low >= high)
            return;

        // We get a random pivot in order to increase the average time complexity
        int pivotIndex = new Random().nextInt(high - low) + low;
        T pivot = arr.get(pivotIndex);
        swap(arr, pivotIndex, high);

        int lp = partition(arr, low, high, pivot);

        quicksort(arr, low, lp - 1);
        quicksort(arr, lp + 1, high);
    }

    /**
     * Executes the partitioning part of the Quicksort algorithm.
     * It basically moves all the element less than the given pivot to the left of it,
     * and all the elements that are greater to it's right.
     *
     * @param arr   The array that will be partitioned
     * @param low   lower bound of the array section that we want to partition
     * @param high  upper bound of the array section that we want to partition
     * @param pivot The value that will be compared to move all the other elements
     * @return The index where the right index and the left index met
     * (we chose to return 'lp' but returning 'rp' would be the same in this case)
     */
    private int partition(ArrayList<T> arr, int low, int high, T pivot) {
        int lp = low;
        int rp = high;

        while (lp < rp) {
            while (arr.get(lp).compareTo(pivot) <= 0 && lp < rp) {
                lp++;
            }

            while (arr.get(rp).compareTo(pivot) >= 0 && lp < rp) {
                rp--;
            }

            swap(arr, lp, rp);
        }

        if (lp < high)
            swap(arr, lp, high); // Moving the pivot to the correct position

        return lp;
    }

    /**
     * Given an arraylist swaps the values corresponding to the given indexes
     *
     * @param arr array where the swap will happen
     * @param i   the index of the first element to swap
     * @param j   the index of the second element to swap
     */
    private void swap(ArrayList<T> arr, int i, int j) {
        T temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }

}
