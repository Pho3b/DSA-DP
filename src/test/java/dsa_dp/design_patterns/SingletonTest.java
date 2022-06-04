package dsa_dp.design_patterns;

import dsa_dp.design_patterns.implementations.singleton_implementation.SecondThreadSingletonImplementation;
import dsa_dp.design_patterns.implementations.singleton_implementation.SingletonImplementation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SingletonTest {
    SingletonImplementation singletonImplementation = new SingletonImplementation();
    SecondThreadSingletonImplementation secondThreadSingletonImplementation = new SecondThreadSingletonImplementation();

    @Test
    public void testSingletonWithMultiThreading() {
        secondThreadSingletonImplementation.start();

        Assertions.assertEquals(singletonImplementation.uniqueLogger.getLoggedMessages(),
                secondThreadSingletonImplementation.uniqueLogger.getLoggedMessages());
    }

}
