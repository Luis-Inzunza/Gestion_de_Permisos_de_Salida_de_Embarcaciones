package org.LittleBoat.connection;

import java.sql.Connection;

public interface ConnectionManager {
    public Connection getConnection();

    public void closeConnection(Connection connection);
}
