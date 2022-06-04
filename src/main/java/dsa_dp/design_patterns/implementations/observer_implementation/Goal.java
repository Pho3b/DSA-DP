package dsa_dp.design_patterns.implementations.observer_implementation;

import dsa_dp.design_patterns.observer.Observable;
import dsa_dp.design_patterns.observer.Observer;

public class Goal implements Observer {
    private int currentGoalsNumber;
    private Observable observable;


    public Goal(Observable observable) {
        this.observable = observable;
        this.observable.registerObserver(this);
    }

    @Override
    public String update(Observable observable, Object obj) {
        if (obj instanceof MatchScoresObservablePayload) {
            MatchScoresObservablePayload payload = (MatchScoresObservablePayload) obj;
            this.currentGoalsNumber = payload.goals;
            return displayData();
        }

        return "";
    }

    private String displayData() {
        return this.getClass().getSimpleName() + " : " + this.currentGoalsNumber;
    }
}
