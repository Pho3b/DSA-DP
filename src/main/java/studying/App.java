package studying;

import studying.algorithms.sorting.MergeSort;

import java.util.ArrayList;
import java.util.Random;

public class App {

    public static void main(String[] args) {
        System.out.println("This is your current operating system: " + System.getProperty("os.name") + "\n");
        currentWorkingOnIssueTest();
    }

    public static void currentWorkingOnIssueTest() {
        MergeSort<Integer> ms = new MergeSort<>();
        int capacity = 10;
        Random rand = new Random();
        ArrayList<Integer> temp = new ArrayList<>(capacity);

        for (int i = 0; i < capacity; i++) {
            temp.add(rand.nextInt(101));
        }

        System.out.println(temp);
        ms.sort(temp);
        System.out.println(temp);
    }
}
