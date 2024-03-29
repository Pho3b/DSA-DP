package dsa_dp.design_patterns.decorator.salad_decorators;

import dsa_dp.design_patterns.implementations.decorator_implementation.Salad;

public class Ananas extends CondimentDecorator {

    public Ananas(Salad salad) {
        super(salad);
    }

    @Override
    public String getDescription() {
        return this.salad.getDescription() + " - Ananas";
    }

    @Override
    public double getCost() {
        return this.salad.getCost() + 1.20;
    }
}
