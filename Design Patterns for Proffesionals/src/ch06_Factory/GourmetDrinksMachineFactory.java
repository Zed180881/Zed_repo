package ch06_Factory;

public class GourmetDrinksMachineFactory implements AbstractDrinksMachineFactory {
    @Override
    public DrinksMachine createCoffeeMachine() {
        return new GourmetCoffeeMachine();
    }

    @Override
    public DrinksMachine createSoftDrinksMachine() {
        return new GourmetSoftDrinksMachine();
    }
}
