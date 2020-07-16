package design_patterns.decorator.salad_decorators;

import decorator_implementation.Salad;

public abstract class CondimentDecorator extends Salad {
    protected Salad salad;

    public CondimentDecorator(Salad salad) {
        this.salad = salad;
    }
}
