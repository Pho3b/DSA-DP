package dsa_dp.algorithms.puzzle;

public class ClockWiseSpiral {

    /**
     * The objective of this function is to receive an integer N and return an NxN two-dimensional array
     * with numbers 1 through NxN represented as a clockwise spiral.
     *
     * Example:
     * N = 3 Output: [[1,2,3],[8,9,4],[7,6,5]]
     * 1    2    3
     * 8    9    4
     * 7    6    5
     *
     * @param N matrix side length
     * @return the newly generated matrix or an empty one if the given 'N' is less than 1
     */
    public int[][] createSpiral(int N) {
        if (N < 1)
            return new int[][]{};

        int x = 0;
        int y = 0;
        int offset = 0;
        int circleCounter = 1;
        int[][] res = new int[N][N];

        for (int i = 1; i < (N * N) + 1; i++) {
            int revOffset = (N - offset) - 1;
            res[y][x] = i;
            circleCounter++;

            // Updating coordinates according to the current position
            if (y == offset && x < revOffset) {
                x++;
            } else if (x == revOffset && y < revOffset) {
                y++;
            } else if (y == revOffset && x > offset) {
                x--;
            } else if (x == offset && y > offset) {
                y--;
            }

            // Checking if we completed a clockwise circle
            if (circleCounter == (revOffset - offset) * 4) {
                offset++;
                circleCounter = 0;
            }
        }

        return res;
    }
}
