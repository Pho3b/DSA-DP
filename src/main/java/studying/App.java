package studying;

import studying.data_structures.hash_table.HashTableOpenAddressing;

public class App {

    public static void main(String[] args) {
        String osName = System.getProperty("os.name").toLowerCase();
        System.out.println("This is your current operating system: " + osName);

        currentWorkingOnIssueTest();
    }

    public static void currentWorkingOnIssueTest() {
        HashTableOpenAddressing<String, Integer> htOpenAddressing = new HashTableOpenAddressing<>();
        htOpenAddressing.add("andrea", 29);
        htOpenAddressing.add("andrea", 29);
        htOpenAddressing.add("andrea", 29);
        htOpenAddressing.add("andrea", 29);
        htOpenAddressing.add("federica", 30);
        htOpenAddressing.add("luigi", 36);
        htOpenAddressing.add("luigi", 36);
        htOpenAddressing.add("luigi", 36);
        htOpenAddressing.add("andrea", 29);
        htOpenAddressing.add("andrea", 29);
        htOpenAddressing.add("andrea", 29);
        htOpenAddressing.add("andrea", 29);
        htOpenAddressing.add("federica", 30);

        htOpenAddressing.print();
    }
}
