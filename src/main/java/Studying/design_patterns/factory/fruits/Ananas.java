package Studying.design_patterns.factory.fruits;

public class Ananas extends AbstractFruit implements Fruit {

    public Ananas() {
        this.name = "Ananas";
        this.color = new String[] {"Yellow"};
        this.vitaminsQuantity = 28;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String[] getColor() {
        return this.color;
    }

    @Override
    public int getVitaminsQuantity() {
        return this.vitaminsQuantity;
    }
}
