package studying.design_patterns.singleton;

public class UniqueLogger {
    /**
     * EAGER INITIALIZATION: We can use this when the program always use the instance of this class
     * or when instantiating it doesn't really take to much time or memory
     *
     * Example:  public static UniqueLogger uniqueLoggerInstance = getInstance();
     */
    public volatile static UniqueLogger uniqueLoggerInstance = null;
    public int loggedMessages = 0;

    /**
     * Setting up a private constructor so that no
     * other classes can instantiate this class except for itself.
     */
    private UniqueLogger() {}

    /**
     * DOUBLE CHECKED LOCKING INITIALIZATION: This way we only synchronize the code the first time.
     * Reducing a big part of the performance issue of the LAZY INITIALIZATION.
     *
     * @return UniqueLogger
     */
    public static UniqueLogger getInstance() {
        if(uniqueLoggerInstance == null) {
            synchronized (UniqueLogger.class) {
                if (uniqueLoggerInstance == null) {
                    uniqueLoggerInstance = new UniqueLogger();
                }
            }
        }

        return uniqueLoggerInstance;
    }

    /**
     * LAZY INITIALIZATION: No waste of resources but can cause problem in multi threaded applications.
     * 'synchronized' keyword can be a solution but we need to keep in mind that it will slow down the
     * application.
     *
     *      public static synchronized UniqueLogger getInstance() {
     *         if(uniqueLoggerInstance == null) {
     *             uniqueLoggerInstance = new UniqueLogger();
     *         }
     *
     *         return uniqueLoggerInstance;
     *     }
     *
     * @return UniqueLogger
     */

    public int getLoggedMessages() {
        return loggedMessages;
    }

    public void setLoggedMessages(int loggedMessages) {
        this.loggedMessages = loggedMessages;
    }
}
