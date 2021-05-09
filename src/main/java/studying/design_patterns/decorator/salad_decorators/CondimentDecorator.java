package studying.design_patterns.decorator.salad_decorators;

import studying.design_patterns.implementations.decorator_implementation.Salad;

public abstract class CondimentDecorator extends Salad {
    protected Salad salad;

    public CondimentDecorator(Salad salad) {
        this.salad = salad;
    }
}
