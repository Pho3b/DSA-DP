package Studying.design_patterns.decorator.salad_decorators;

import Studying.design_patterns.implementations.decorator_implementation.Salad;

public class Oil extends CondimentDecorator {

    public Oil(Salad salad) {
        super(salad);
    }

    @Override
    public String getDescription() {
        return this.salad.getDescription() + "- Oil";
    }

    @Override
    public double getCost() {
        return this.salad.getCost() + 0.2;
    }
}
