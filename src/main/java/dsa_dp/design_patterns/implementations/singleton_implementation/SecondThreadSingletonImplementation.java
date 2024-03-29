package dsa_dp.design_patterns.implementations.singleton_implementation;

import dsa_dp.design_patterns.singleton.UniqueLogger;

public class SecondThreadSingletonImplementation extends Thread {

    public UniqueLogger uniqueLogger = UniqueLogger.getInstance();;

    public void run() {
        System.out.println("Second started running...");
        uniqueLogger.setLoggedMessages(10);
    }
}
