package org.littleboat.connection;

import java.sql.Connection;

public interface ConnectionManager {
    public Connection getConnection();

    public void closeConnection(Connection connection);
}
