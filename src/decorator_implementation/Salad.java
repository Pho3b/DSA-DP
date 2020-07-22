package decorator_implementation;

public abstract class Salad {
    protected String description;
    protected double cost;

    public String getDescription() {
        return description;
    }

    public double getCost() {
        return cost;
    };

    public void printDetails() {
        System.out.println(getDescription() + "  :   " + (double) Math.round(getCost() * 100) / 100);
    }
}
