package dsa_dp.design_patterns.template;

/**
 *  Methods that will be implemented in the child classes: [wakeUp(), work()]
 *  Hook methods: [gotToGym()]
 */
public abstract class Worker {
    abstract void wakeUp();
    abstract void work();

    /**
     * TEMPLATE method.
     */
    public void dailyRoutine() {
        wakeUp();
        getPrepared();
        goToWork();
        work();
        goToGym();
        goBackHome();
        sleep();
    }

    private void getPrepared() {
        System.out.println("2. Had breakfast and all dressed up");
    }

    private void goToWork() {
        System.out.println("3. Going to work ...");
    }

    /**
     * 'Hook' method, implement it if needed.
     */
    public void goToGym() { }

    private void goBackHome() {
        System.out.println("5. Returning back home");
    }

    private void sleep() {
        System.out.println("6. Going to sleep, have a good night");
    }
}
