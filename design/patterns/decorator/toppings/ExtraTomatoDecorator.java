package design.patterns.decorator.toppings;

import design.patterns.decorator.baseclasses.PizzaBase;

public class ExtraTomatoDecorator extends ToppingsBaseDecorator{

    PizzaBase pizzaBase;
    public ExtraTomatoDecorator(PizzaBase pizzaBase) {
        this.pizzaBase = pizzaBase;
    }

    @Override
    public int cost() {
        return this.pizzaBase.cost() + 7;
    }
}
