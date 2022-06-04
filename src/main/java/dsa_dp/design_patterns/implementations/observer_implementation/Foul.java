package dsa_dp.design_patterns.implementations.observer_implementation;

import dsa_dp.design_patterns.observer.Observable;
import dsa_dp.design_patterns.observer.Observer;

public class Foul implements Observer {
    private int currentFoulsNumber;
    private final Observable observable;


    public Foul(Observable observable) {
        this.observable = observable;
        this.observable.registerObserver(this);
    }

    @Override
    public String update(Observable observable, Object obj) {
        if (obj instanceof MatchScoresObservablePayload) {
            MatchScoresObservablePayload payload = (MatchScoresObservablePayload) obj;
            this.currentFoulsNumber = payload.fouls;
            return displayData();
        }

        return "";
    }

    private String displayData() {
        return this.getClass().getSimpleName() + " : " + this.currentFoulsNumber;
    }
}
