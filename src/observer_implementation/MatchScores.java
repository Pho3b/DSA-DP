package observer_implementation;

import design_patterns.observer.Observable;
import design_patterns.observer.Observer;

import java.util.ArrayList;

public class MatchScores implements Observable {
    public ArrayList<Observer> observers;
    public MatchScoresObservablePayload payload;

    public MatchScores() {
        payload = new MatchScoresObservablePayload();
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        try {
            this.observers.add(observer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void unregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    /**
     * PULL method: We select here what to pass to every kind of Observer,
     * it is useful when you don't have more than, let's say (5 types of Observer)
     *
     * PUSH: We pass the same object containing the whole payload data to everyone,
     * it will be the Observer responsibility to select which data to grab from the object
     */
    @Override
    public void notifyObservers() {
        for (Observer observer: observers) {
            observer.update(this, payload);
        }
    }
}
