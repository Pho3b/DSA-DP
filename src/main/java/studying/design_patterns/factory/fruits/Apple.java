package studying.design_patterns.factory.fruits;

public class Apple extends AbstractFruit implements Fruit {

    public Apple() {
        this.name = "Apple";
        this.color = new String[]{"Red", "Yellow", "Green"};
        this.vitaminsQuantity = 12;
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
