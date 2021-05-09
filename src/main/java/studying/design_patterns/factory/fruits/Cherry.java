package studying.design_patterns.factory.fruits;

public class Cherry extends AbstractFruit implements Fruit {

    public Cherry() {
        this.name = "Cherry";
        this.color = new String[]{"Red", "Pinky"};
        this.vitaminsQuantity = 10;
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
