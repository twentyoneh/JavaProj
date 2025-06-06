package ru.kalinin.proxy;

public class DatabaseConnectionProxy implements IDatabaseConnection{
    private final String dbName;
    private RealDatabaseConnection realConnection;

    public DatabaseConnectionProxy(String dbName) {
        this.dbName = dbName;
    }

    @Override
    public void connect() {
        if (realConnection == null) {
            // Можно вынести в конфиг или передавать как аргумент
            String fullUrl = "localhost:5432/" + dbName;
            realConnection = new RealDatabaseConnection(fullUrl);
        }
        realConnection.connect();
    }
}
