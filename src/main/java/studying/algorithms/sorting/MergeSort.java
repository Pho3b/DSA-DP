package studying.algorithms.sorting;

import java.util.ArrayList;
import java.util.Collections;

public class MergeSort<T extends Comparable<T>> {

    /**
     * Sorts the given array using the 'MergeSort' algorithm
     *
     * @param arr the input arrayList that needs to be sorted
     */
    public void sort(ArrayList<T> arr) {
        int size = arr.size();

        if (size > 1) {
            int halfSize = size / 2;
            ArrayList<T> leftHalf = new ArrayList<>(Collections.nCopies(halfSize, null));
            ArrayList<T> rightHalf = new ArrayList<>(Collections.nCopies(size - halfSize, null));

            populateHalves(arr, leftHalf, rightHalf, size, halfSize);

            sort(leftHalf);
            sort(rightHalf);

            merge(arr, leftHalf, rightHalf);
        }
    }

    /**
     * Populates the two given halves array with the
     * correct values of the input array
     *
     * @param inputArr  reference to the input array
     * @param leftHalf  left half of the input array
     * @param rightHalf right half of the input array
     * @param size      size of the input array
     * @param halfSize  half of the input array size
     */
    private void populateHalves(
            ArrayList<T> inputArr,
            ArrayList<T> leftHalf,
            ArrayList<T> rightHalf,
            int size,
            int halfSize
    ) {
        // Populating the left half
        for (int i = 0; i < halfSize; i++) {
            leftHalf.set(i, inputArr.get(i));
        }

        // Populating the right half
        for (int i = halfSize; i < size; i++) {
            rightHalf.set(i - halfSize, inputArr.get(i));
        }
    }

    /**
     * Merges the two given arrays into the input array sorting it while merging
     *
     * @param inputArr  reference to the input array
     * @param leftHalf  left half of the input array
     * @param rightHalf right half of the input array
     */
    private void merge(ArrayList<T> inputArr, ArrayList<T> leftHalf, ArrayList<T> rightHalf) {
        int i = 0, j = 0, k = 0;
        int lSize = leftHalf.size();
        int rSize = rightHalf.size();

        while (k < (lSize + rSize)) {
            if (j >= rSize || (i < lSize && leftHalf.get(i).compareTo(rightHalf.get(j)) <= 0)) {
                inputArr.set(k, leftHalf.get(i));
                i++;
            } else {
                inputArr.set(k, rightHalf.get(j));
                j++;
            }

            k++;
        }
    }
}
