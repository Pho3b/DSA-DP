package studying.design_patterns.observer;

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
    void notifyObservers();
}
