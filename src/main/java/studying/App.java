package studying;

import studying.data_structures.graph.model.Vertex;

public class App {

    public static void main(String[] args) {
        System.out.println("This is your current operating system: " + System.getProperty("os.name") + "\n");
        currentWorkingOnIssueTest();
    }

    public static void currentWorkingOnIssueTest() {
        Vertex v = new Vertex(0);
        System.out.println(v.getClass().getSimpleName());
    }
}
