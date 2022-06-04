package dsa_dp.design_patterns;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import dsa_dp.design_patterns.implementations.observer_implementation.Foul;
import dsa_dp.design_patterns.implementations.observer_implementation.Goal;
import dsa_dp.design_patterns.implementations.observer_implementation.MatchScores;

public class ObserverTest {

    @Test
    public void correctMultipleNotificationTest() {
        MatchScores matchScores = new MatchScores();
        Goal goal = new Goal(matchScores);
        Foul foul = new Foul(matchScores);

        matchScores.payload.goals = 3;
        matchScores.payload.fouls = 12;
        Assertions.assertEquals("[Goal : 3, Foul : 12]", matchScores.notifyObservers().toString());

        matchScores.unregisterObserver(goal);
        Assertions.assertEquals("[Foul : 12]", matchScores.notifyObservers().toString());

        matchScores.unregisterObserver(foul);
        Assertions.assertEquals("[]", matchScores.notifyObservers().toString());
    }

    @Test
    public void correctUnregisterTest() {
        MatchScores matchScores = new MatchScores();
        Goal goal = new Goal(matchScores);
        Foul foul = new Foul(matchScores);

        matchScores.payload.goals = 3;
        matchScores.payload.fouls = 12;
        Assertions.assertEquals(2, matchScores.notifyObservers().size());

        matchScores.unregisterObserver(goal);
        Assertions.assertEquals(1, matchScores.notifyObservers().size());

        matchScores.unregisterObserver(foul);
        Assertions.assertEquals(0, matchScores.notifyObservers().size());
    }
}
