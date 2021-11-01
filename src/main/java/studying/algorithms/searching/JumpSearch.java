package studying.algorithms.searching;

import java.util.Arrays;

public class JumpSearch {

    public int search(int[] inputArr, int toSearch) {
        Arrays.sort(inputArr);
        int jumpSpan = (int) Math.sqrt(inputArr.length);
        int counter = 0;

        while (counter < inputArr.length && toSearch >= inputArr[counter]) {
            if (toSearch == inputArr[counter]) {
                return counter;
            }

            counter += jumpSpan;
        }

        // We start the linear search of length (counter - 1)
        for (int i = (counter - (jumpSpan - 1)); i < inputArr.length; i++) {
            if (toSearch == inputArr[i]) {
                return i;
            }
        }

        return -1;
    }
}
