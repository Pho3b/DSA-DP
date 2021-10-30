package studying;

import studying.data_structures.sparse_table.SparseTable;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {
        System.out.println("This is your current operating system: " + System.getProperty("os.name") + "\n");
        currentWorkingOnIssueTest();
    }

    public static void currentWorkingOnIssueTest() {
        int[] primitiveArr = new int[]{4, 2, 3, 7, 1, 5, 3, 3, 9, 6, 7, -1, 4};
        Integer[] boxedArray = Arrays.stream(primitiveArr).boxed().toArray(Integer[]::new);

        SparseTable<Integer> sparseTable = new SparseTable<>(boxedArray);
        sparseTable.print();
    }
}
