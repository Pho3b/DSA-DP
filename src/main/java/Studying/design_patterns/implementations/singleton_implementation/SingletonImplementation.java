package Studying.design_patterns.implementations.singleton_implementation;

import Studying.design_patterns.singleton.UniqueLogger;

public class SingletonImplementation {
    UniqueLogger uniqueLogger = UniqueLogger.getInstance();

    public SingletonImplementation() {
        uniqueLogger.setLoggedMessages(32);
        this.printSingletonData();
    }

    public void printSingletonData() {
        System.out.println("Logging from " + this.getClass() + " " + uniqueLogger.getLoggedMessages());
    }
}


