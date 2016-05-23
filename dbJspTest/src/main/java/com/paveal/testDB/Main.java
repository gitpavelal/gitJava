package com.paveal.testDB;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class Main {


    public static void main(String[] args) {
        DbWorker worker = new DbWorker();


        try {
            Statement statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT id, password ,username  FROM users");

            while (resultSet.next()) {
                User user = new User();
                user.setUserId(resultSet.getInt("id"));
                user.setUserPassword(resultSet.getString("password"));
                user.setUserName(resultSet.getString("username"));

                System.out.print(user.getUserId() + " ");
                System.out.print(user.getUserPassword() + " ");
                System.out.println(user.getUserName());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
