package ru.kalinin.singleton;

import java.time.LocalDate;

public class SingletonLogger {

    private static SingletonLogger instance;

    private SingletonLogger() {}

    public static SingletonLogger getInstance(){
        if(instance == null){
            instance = new SingletonLogger();
        }
        return instance;
    }

    public void classLogg(Object obj, String info) {
        System.out.println("Log info: " + LocalDate.now() +" - " + obj.getClass().getName() + ": " + info);
    }
}
