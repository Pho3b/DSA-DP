package Studying.design_patterns.implementations.singleton_implementation;

import Studying.design_patterns.singleton.UniqueLogger;

public class SecondSingletonImplementation extends Thread {

    public void run() {
        System.out.println("Second thread is running...");

        UniqueLogger uniqueLogger = UniqueLogger.getInstance();
        System.out.println("Logging from " + this.getClass() + " " + uniqueLogger.getLoggedMessages());

        SingletonImplementation singletonImplementation = new SingletonImplementation();
        uniqueLogger.setLoggedMessages(10);

        System.out.println("Logging2 from " + this.getClass() + " " + uniqueLogger.getLoggedMessages());
        singletonImplementation.printSingletonData();
    }
}
