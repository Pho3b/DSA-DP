package dsa_dp;

import dsa_dp.algorithms.puzzle.ClockWiseSpiral;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {
        System.out.println("This is your current operating system: " + System.getProperty("os.name") + "\n");

        // Your code here
        ClockWiseSpiral cws = new ClockWiseSpiral();
        System.out.println(Arrays.deepToString(cws.createSpiral(4)));
    }
}
