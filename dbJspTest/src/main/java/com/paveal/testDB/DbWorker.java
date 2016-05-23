package com.paveal.testDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbWorker {
    private final static String url ="jdbc:mysql://localhost:3306/bookmanager";
    private final static String userName ="root";
    private final static String password ="";
    private Connection connection;

    public DbWorker() {
        try {
            connection = DriverManager.getConnection(url,userName,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
