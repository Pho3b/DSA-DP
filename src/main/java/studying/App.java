package studying;

import studying.data_structures.hash_table.HashTableSeparateChaining;
import studying.design_patterns.implementations.observer_implementation.Foul;
import studying.design_patterns.implementations.observer_implementation.Goal;
import studying.design_patterns.implementations.observer_implementation.MatchScores;


public class App {

    public static void main(String[] args) {
        String osName = System.getProperty("os.name").toLowerCase();
        System.out.println("This is your current operating system: " + osName);

        currentWorkingOnIssueTest();
    }

    public static void currentWorkingOnIssueTest() {
        HashTableSeparateChaining<String, Integer> hashTableSeparateChaining = new HashTableSeparateChaining<>(3);
        hashTableSeparateChaining.add("andrea", 29);
        hashTableSeparateChaining.add("federica", 30);
        hashTableSeparateChaining.add("luigi", 36);
        hashTableSeparateChaining.add("riccardo", 12);
        hashTableSeparateChaining.add("giacomo", 29);
        hashTableSeparateChaining.add("laura", 15);

        hashTableSeparateChaining.print();

        hashTableSeparateChaining.remove("riccardo");
        hashTableSeparateChaining.print();
    }

    /**
     * Observer design pattern demonstration
     */
    public void testObserverDesignPatter() {
        MatchScores matchScores = new MatchScores();
        Goal goal = new Goal(matchScores);
        Foul foul = new Foul(matchScores);

        matchScores.payload.goals = 3;
        matchScores.payload.fouls = 12;
        matchScores.notifyObservers();

        matchScores.unregisterObserver(goal);
        matchScores.notifyObservers();

        matchScores.unregisterObserver(foul);
        matchScores.notifyObservers();
    }
}
