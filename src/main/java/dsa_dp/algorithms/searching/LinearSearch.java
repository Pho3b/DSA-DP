package dsa_dp.algorithms.searching;

public class LinearSearch {

    public int search(int[] inputArr, int toSearch) {
        for (int i = 0; i < inputArr.length; i++) {
            if (inputArr[i] == toSearch) return i;
        }

        return -1;
    }
}
