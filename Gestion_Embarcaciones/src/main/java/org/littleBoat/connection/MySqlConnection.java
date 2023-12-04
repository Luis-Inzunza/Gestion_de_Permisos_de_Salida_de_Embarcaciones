package org.littleboat.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySqlConnection implements ConnectionManager{
    private static final Logger LOGGER = Logger.getLogger(MySqlConnection.class.getName());

    private static MySqlConnection instance;

    private static Connection mySqlConnection;

    private static final String url = "jdbc:mysql://bfqi5lpcbyzizmap4utb-mysql.services.clever-cloud.com/bfqi5lpcbyzizmap4utb";

    private static final String userName = "ukfdrhqlz0or7pxv";

    private static final String password = "9u8rB7PfDrMFcb7ZnaQy";

    private MySqlConnection () { }

    public static MySqlConnection getInstance() {
        return instance == null ? instance = new MySqlConnection() : instance;
    }


    @Override
    public Connection getConnection () {
        try {

            if(mySqlConnection == null || mySqlConnection.isClosed()) {
                mySqlConnection = DriverManager.getConnection(url, userName, password);
            }
            

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, e.getSQLState());
        }
        return mySqlConnection;
    }

    @Override
    public void closeConnection(Connection connection) {
        try {
            mySqlConnection.close();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, e.getSQLState());
        }
    }

}
