package design_patterns.implementations.observer_implementation;

import design_patterns.observer.Observable;
import design_patterns.observer.Observer;

public class Foul implements Observer {
    private int currentFoulsNumber;
    private Observable observable;


    public Foul(Observable observable) {
        this.observable = observable;
        this.observable.registerObserver(this);
    }

    @Override
    public void update(Observable observable, Object obj) {
        if (obj instanceof MatchScoresObservablePayload) {
            MatchScoresObservablePayload payload = (MatchScoresObservablePayload) obj;
            this.currentFoulsNumber = payload.fouls;
            this.displayData();
        }
    }

    private void displayData() {
        System.out.println(this.getClass().getSimpleName() + " : " + this.currentFoulsNumber + "\n");
    }
}
