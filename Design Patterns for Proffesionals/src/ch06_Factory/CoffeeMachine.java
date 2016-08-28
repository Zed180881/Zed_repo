package ch06_Factory;

public class CoffeeMachine extends DrinksMachine {
    @Override
    public Drink dispenseDrink() {
        return new Coffee();
    }
}
