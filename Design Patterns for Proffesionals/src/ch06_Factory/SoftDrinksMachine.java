package ch06_Factory;

public class SoftDrinksMachine extends DrinksMachine {
    @Override
    public Drink dispenseDrink() {
        return new SoftDrink();
    }
}
