package Studying.design_patterns.implementations.observer_implementation;

import Studying.design_patterns.observer.Observable;
import Studying.design_patterns.observer.Observer;

public class Goal implements Observer {
    private int currentGoalsNumber;
    private Observable observable;


    public Goal(Observable observable) {
        this.observable = observable;
        this.observable.registerObserver(this);
    }

    @Override
    public void update(Observable observable, Object obj) {
        if (obj instanceof MatchScoresObservablePayload) {
            MatchScoresObservablePayload payload = (MatchScoresObservablePayload) obj;
            this.currentGoalsNumber = payload.goals;
            this.displayData();
        }
    }

    private void displayData() {
        System.out.println(this.getClass().getSimpleName() + " : " + this.currentGoalsNumber);
    }
}
