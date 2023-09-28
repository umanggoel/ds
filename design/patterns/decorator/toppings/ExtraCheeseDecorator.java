package design.patterns.decorator.toppings;

import design.patterns.decorator.baseclasses.PizzaBase;

public class ExtraCheeseDecorator extends ToppingsBaseDecorator{

    PizzaBase pizzaBase;
    public ExtraCheeseDecorator(PizzaBase pizzaBase) {
        this.pizzaBase = pizzaBase;
    }

    @Override
    public int cost() {
        return this.pizzaBase.cost() + 5;
    }
}
