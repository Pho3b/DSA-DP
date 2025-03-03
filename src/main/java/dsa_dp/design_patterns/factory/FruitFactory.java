package dsa_dp.design_patterns.factory;

import dsa_dp.design_patterns.factory.fruits.Ananas;
import dsa_dp.design_patterns.factory.fruits.Apple;
import dsa_dp.design_patterns.factory.fruits.Cherry;
import dsa_dp.design_patterns.factory.fruits.Fruit;

public class FruitFactory {

    public Fruit generateFruit(String fruitType) {
        return switch (fruitType) {
            case "Cherry" -> new Cherry();
            case "Apple" -> new Apple();
            case "Ananas" -> new Ananas();
            default -> null;
        };
    }
}
