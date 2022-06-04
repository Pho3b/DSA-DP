package dsa_dp.design_patterns.factory;

import dsa_dp.design_patterns.factory.fruits.Ananas;
import dsa_dp.design_patterns.factory.fruits.Apple;
import dsa_dp.design_patterns.factory.fruits.Cherry;
import dsa_dp.design_patterns.factory.fruits.Fruit;

public class FruitFactory {

    public Fruit generateFruit(String fruitType) {
        switch(fruitType) {
            case "Cherry":
                return new Cherry();
            case "Apple":
                return new Apple();
            case "Ananas":
                return new Ananas();
            default:
                return null;
        }
    }
}
