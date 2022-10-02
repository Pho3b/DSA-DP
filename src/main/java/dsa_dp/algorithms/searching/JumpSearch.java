package dsa_dp.algorithms.searching;

public class JumpSearch {

    public int search(int[] inputArr, int toSearch) {
        int jumpSpan = (int) Math.sqrt(inputArr.length);
        int counter = 0;

        // jump search section
        while (counter < inputArr.length && toSearch >= inputArr[counter]) {
            if (toSearch == inputArr[counter])
                return counter;

            counter += jumpSpan;
        }

        // linear search section
        for (int i = (counter - jumpSpan); i < inputArr.length; i++) {
            if (i < 0) break;
            if (toSearch == inputArr[i]) return i;
        }

        return -1;
    }
}
