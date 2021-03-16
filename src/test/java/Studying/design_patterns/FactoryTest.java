package Studying.design_patterns;

import Studying.design_patterns.factory.FruitFactory;
import Studying.design_patterns.factory.fruits.Fruit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FactoryTest {

    @Test
    public void factoryGeneratedObjectNameTest() {
        FruitFactory fruitFactory = new FruitFactory();

        Fruit fruit = fruitFactory.generateFruit("Cherry");
        Assertions.assertEquals(fruit.getVitaminsQuantity(), 10);

        fruit = fruitFactory.generateFruit("Apple");
        Assertions.assertEquals(fruit.getVitaminsQuantity(), 12);

        fruit = fruitFactory.generateFruit("Ananas");
        Assertions.assertNotEquals(fruit.getVitaminsQuantity(), 2);
    }

}
