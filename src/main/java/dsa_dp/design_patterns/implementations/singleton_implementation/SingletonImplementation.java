package dsa_dp.design_patterns.implementations.singleton_implementation;

import dsa_dp.design_patterns.singleton.UniqueLogger;

public class SingletonImplementation {
    public UniqueLogger uniqueLogger;

    public SingletonImplementation() {
        uniqueLogger = UniqueLogger.getInstance();
        uniqueLogger.setLoggedMessages(32);
    }
}


