package org.LittleBoat.connection;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MySQLConnectionTest {
    @Test
    void connectTest () {
        MySqlConnection connectionManager = MySqlConnection.getInstance();
        Connection connection = connectionManager.getConnection();
        Assertions.assertNotNull(connection);
    }

    @Test
    void isSingelton () {
        MySqlConnection connectionManager = MySqlConnection.getInstance();
        Connection connectionOne = connectionManager.getConnection();
        Connection connectionTwo = connectionManager.getConnection();
        Assertions.assertTrue(connectionOne == connectionTwo);
    }

    @Test
    void disconnectTest () throws SQLException {
        MySqlConnection connectionManager = MySqlConnection.getInstance();
        Connection connection = connectionManager.getConnection();
        connectionManager.closeConnection(connection);
        Assertions.assertTrue(connection.isClosed());
    }
}
