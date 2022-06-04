package dsa_dp.algorithms.string;

public class PermutationInString {
    private final static int ALPHABET_SIZE = 26;


    /**
     * Checks if any permutation of the first string is contained in the second string.
     *
     * @param s1 String which permutations will be searched for
     * @param s2 The string where we will search for permutations of the 's1' string
     * @return true or false whether a valid permutation is found or not
     */
    public boolean check(String s1, String s2) {
        if (s1.length() <= s2.length()) {
            int[] charCounts = generateCharCountsArray(s1);

            for (int i = 0; i < s2.length(); i++) {
                if (charCounts[s2.charAt(i) - 'a'] > 0) {
                    int[] windowCharsCount = generateCharCountsArray(s1);
                    int j = i;

                    while (j < s2.length()) {
                        char c = s2.charAt(j);

                        if (windowCharsCount[c - 'a'] > 0) {
                            windowCharsCount[c - 'a'] -= 1;
                            j++;

                            if (j - i == s1.length())
                                return true;
                        } else
                            break;
                    }
                }
            }
        }

        return false;
    }

    /**
     * Generates an array where each index represents a lowercase alphabet letter
     * and each value represents the number of occurrences of that letter in the given string
     *
     * @param s the string we will construct the array on
     * @return an integer array containing the number of occurrences for every char of the given string
     */
    private int[] generateCharCountsArray(String s) {
        int[] res = new int[ALPHABET_SIZE];

        for (int i = 0; i < s.length(); i++)
            res[s.charAt(i) - 'a'] += 1;

        return res;
    }
}
