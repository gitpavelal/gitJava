package com.paveal.testDB;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class Main {
    private final static String url ="jdbc:mysql://localhost:3306/bookmanager";
    private final static String userName ="root";
    private final static String password ="";

    public static void main(String[] args) {

        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            System.err.println("Нет соединения с БД");
        }

        try(Connection connection = DriverManager.getConnection(url,userName,password); Statement statement
        = connection.createStatement()) {
        statement.executeQuery()


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
