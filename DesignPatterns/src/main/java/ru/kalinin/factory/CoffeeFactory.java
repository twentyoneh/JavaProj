package ru.kalinin.factory;

public class CoffeeFactory {
    public static Coffee createCoffee(CoffeeType coffeeType) {
        Coffee coffee;
        switch (coffeeType) {
            case ESPRESSO -> coffee = new Espresso();
            case AMERICANO -> coffee = new Americano();
            default -> throw new IllegalStateException("Неверное значение: " + coffeeType);
        }
        System.out.println("Создали кофе: " + coffee.getClass());
        return coffee;
    }
}
