package ch06_Factory;

public interface AbstractDrinksMachineFactory {
    DrinksMachine createCoffeeMachine();

    DrinksMachine createSoftDrinksMachine();
}
