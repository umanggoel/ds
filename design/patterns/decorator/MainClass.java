package design.patterns.decorator;

import design.patterns.decorator.baseclasses.Margheritta;
import design.patterns.decorator.baseclasses.PizzaBase;
import design.patterns.decorator.toppings.ExtraCheeseDecorator;
import design.patterns.decorator.toppings.ExtraTomatoDecorator;

public class MainClass {
    public static void main(String[] args) {

        PizzaBase pizzaBase = new ExtraTomatoDecorator(new ExtraCheeseDecorator(new Margheritta()));
        System.out.println(pizzaBase.cost());
    }
}
