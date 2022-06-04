package dsa_dp.design_patterns.implementations.decorator_implementation;

public abstract class Salad {
    protected String description;
    protected double cost;

    public String getDescription() {
        return description;
    }

    public double getCost() {
        return cost;
    }

    public String printDetails() {
        String res = getDescription() + "  :   " + (double) Math.round(getCost() * 100) / 100;
        System.out.println(res);

        return res;
    }
}
