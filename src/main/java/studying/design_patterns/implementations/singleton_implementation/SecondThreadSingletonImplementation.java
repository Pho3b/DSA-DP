package studying.design_patterns.implementations.singleton_implementation;

import studying.design_patterns.singleton.UniqueLogger;

public class SecondThreadSingletonImplementation extends Thread {

    public UniqueLogger uniqueLogger = UniqueLogger.getInstance();;

    public void run() {
        System.out.println("Second started running...");
        uniqueLogger.setLoggedMessages(10);
    }
}
