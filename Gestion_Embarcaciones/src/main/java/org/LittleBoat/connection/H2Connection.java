package org.LittleBoat.connection;

import org.flywaydb.core.Flyway;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class H2Connection implements ConnectionManager {

    private static H2Connection instance;

    private static Connection connection;

    private static final String url = "jdbc:h2:mem:testdb";

    private static final String username = "sa";

    private static final String password = "";

    static {
        connect();
        Flyway flyway = Flyway.configure().dataSource(url, username, password)
                .locations("classpath:db.migration.h2")
                .load();
        flyway.migrate();
    }

    private H2Connection() {
    }

    public static H2Connection getInstance() {
        return instance == null ? instance = new H2Connection() : instance;
    }

    @Override
    public Connection getConnection() {
        return connection;
    }

    private static void connect() {
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("La base de datos no pudo conectarse");
            System.out.println(e.getSQLState());
        }
    }

    @Override
    public void closeConnection(Connection connection) {
        System.out.println("Dummy Function");
    }

}