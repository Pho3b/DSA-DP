package Studying.design_patterns;

import Studying.design_patterns.factory.FruitFactory;
import Studying.design_patterns.factory.fruits.Fruit;
import org.junit.jupiter.api.Test;

public class FactoryTest {
    FruitFactory fruitFactory = new FruitFactory();

    @Test
    public void factoryGeneratedObjectNameTest() {
        Fruit fruit = fruitFactory.generateFruit("Cherry");
        org.junit.Assert.assertEquals(fruit.getVitaminsQuantity(), 10);

        fruit = fruitFactory.generateFruit("Apple");
        org.junit.Assert.assertEquals(fruit.getVitaminsQuantity(), 12);

        fruit = fruitFactory.generateFruit("Ananas");
        org.junit.Assert.assertNotEquals(fruit.getVitaminsQuantity(), 2);
    }

}
