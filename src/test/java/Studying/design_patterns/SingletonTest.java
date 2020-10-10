package Studying.design_patterns;

import Studying.design_patterns.implementations.singleton_implementation.SecondThreadSingletonImplementation;
import Studying.design_patterns.implementations.singleton_implementation.SingletonImplementation;
import org.junit.jupiter.api.Test;

public class SingletonTest {
    SingletonImplementation singletonImplementation = new SingletonImplementation();
    SecondThreadSingletonImplementation secondThreadSingletonImplementation = new SecondThreadSingletonImplementation();

    @Test
    public void testSingletonWithMultiThreading() {
        secondThreadSingletonImplementation.start();

        org.junit.Assert.assertEquals(singletonImplementation.uniqueLogger.getLoggedMessages(),
                secondThreadSingletonImplementation.uniqueLogger.getLoggedMessages());
    }

}
