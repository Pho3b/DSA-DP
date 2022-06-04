package dsa_dp.design_patterns.decorator.salad_decorators;

import dsa_dp.design_patterns.implementations.decorator_implementation.Salad;

public class MeatPieces extends CondimentDecorator {

    public MeatPieces(Salad salad) {
        super(salad);
    }

    @Override
    public String getDescription() {
        return this.salad.getDescription() + " - Meat";
    }

    @Override
    public double getCost() {
        return this.salad.getCost() + 1.1;
    }
}
