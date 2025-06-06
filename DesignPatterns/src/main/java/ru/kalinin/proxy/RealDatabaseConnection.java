package ru.kalinin.proxy;

public class RealDatabaseConnection implements IDatabaseConnection {
    private final String fullUrl;

    public RealDatabaseConnection(String fullUrl) {
        this.fullUrl = fullUrl;
    }

    @Override
    public void connect() {
        System.out.println("Подключено: " + fullUrl);
    }
}
