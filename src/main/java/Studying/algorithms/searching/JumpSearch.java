package Studying.algorithms.searching;

import java.util.Arrays;

public class JumpSearch {

    public int search(int[] inputArr, int toSearch) {
        Arrays.sort(inputArr);  // Works only with sorted arrays
        int jumpSpan = (int) Math.sqrt(inputArr.length);    // Best jump size.
        int counter = 0;

        while (counter < inputArr.length && toSearch >= inputArr[counter]) {
            if (toSearch == inputArr[counter]) {
                return counter;
            }

            counter += jumpSpan;
        }

        for (int i = (counter - (jumpSpan - 1)); i <= inputArr.length; i++) { // We start the linear search of length (counter - 1)
            System.out.println("linear searching: " + inputArr[i]);
            if (toSearch == inputArr[i]) {
                return i;
            }
        }

        return -1;
    }
}
