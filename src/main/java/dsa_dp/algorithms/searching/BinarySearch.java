package dsa_dp.algorithms.searching;

public class BinarySearch {

    public int search(int[] inputArr, int toSearch) {
        int l = 0;
        int r = inputArr.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (toSearch == inputArr[mid]) return mid;
            if (toSearch < inputArr[mid]) r = mid - 1;
            else l = mid + 1;
        }

        return -1;
    }
}
