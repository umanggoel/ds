package design.patterns.decorator.toppings;

import design.patterns.decorator.baseclasses.PizzaBase;

public abstract class ToppingsBaseDecorator extends PizzaBase {
    public abstract int cost();
}
