package design_patterns.decorator.salad_decorators;

import design_patterns.implementations.decorator_implementation.Salad;

public class CheesePieces extends CondimentDecorator {

    public CheesePieces(Salad salad) {
        super(salad);
    }

    @Override
    public String getDescription() {
        return this.salad.getDescription() + " - Cheese pieces";
    }

    @Override
    public double getCost() {
        return this.salad.getCost() + 0.85;
    }
}
