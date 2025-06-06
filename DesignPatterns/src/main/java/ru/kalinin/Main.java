package ru.kalinin;

import ru.kalinin.adapter.CardReader;
import ru.kalinin.adapter.IUsb;
import ru.kalinin.adapter.MemoryCard;
import ru.kalinin.factory.Coffee;
import ru.kalinin.factory.CoffeeFactory;
import ru.kalinin.factory.CoffeeType;
import ru.kalinin.proxy.DatabaseConnectionProxy;
import ru.kalinin.proxy.IDatabaseConnection;
import ru.kalinin.singleton.SingletonLogger;

import java.util.Date;


public class Main {

    public static void main(String[] args) {

        /*
        - Singelton
        Создать класс логирования. Метод в нем должен выводить имя переданного класса и дополнительную информацию.
        classLogg(Object obj, String info)
        Пример вывода в методе: Log info: 21.07.23 - TestClass - Some info
        */
        SingletonLogger singletonLogger = SingletonLogger.getInstance();
        singletonLogger.classLogg(Date.class, "Some info");

        /*
        - Factory
        Создать класс кофе, от него наследовать два вида кофе, в зависимости от того какой тип кофе мы хотим,
        создавать именно его через фабрику. (espresso, americano)
         */
        Coffee americano = CoffeeFactory.createCoffee(CoffeeType.AMERICANO);
        Coffee espresso = CoffeeFactory.createCoffee(CoffeeType.ESPRESSO);

        /*
        - Adapter
        Компьютер может читать информацию только с USB, нужно прочитать через usb адаптер информацию с карты памяти.
        (создаю карту, адаптер и с компьютера читаю)
         */
        IUsb cardReader = new CardReader(new MemoryCard());
        cardReader.connectWithUsbCable();

        /*
        - Proxy
        Создание класса который хранит название бд и "подключается" к ней по полному url. Подключаться через proxy,
        который добавляет к названию полный адрес. (через proxy обращаюсь к названию бд, вижу строчку подключено localhost:port/название бд)
        */
        IDatabaseConnection connection = new DatabaseConnectionProxy("my_database");
        connection.connect();
    }
}