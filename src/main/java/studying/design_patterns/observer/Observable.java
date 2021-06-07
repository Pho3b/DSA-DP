package studying.design_patterns.observer;

import java.util.ArrayList;

/**
 * Observable is called Subject in the default Design Pattern implementation
 */
public interface Observable {
    /**
     * This variable is useful when you need to regulate
     * when to actually update the Observers
     */
    boolean isChanged = false;
    void registerObserver(Observer observer);
    void unregisterObserver(Observer observer);
    ArrayList<String> notifyObservers();
}
