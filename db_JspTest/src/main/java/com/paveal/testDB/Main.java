package com.paveal.testDB;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.*;

public class Main {


    public static void main(String[] args) {
        DbWorker worker = new DbWorker();
        FileWriter writer = null;


        try {

            Statement statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "SELECT username, tittle_latter, uses_pattern_letter.id   " +
                            "FROM users, uses_pattern_letter WHERE uses_pattern_letter.id=1");

            while (resultSet.next()) {
                User user = new User();
                Letter letter = new Letter();

                user.setUserName(resultSet.getString("username"));
                letter.setLetterTittle(resultSet.getString("tittle_latter"));

                writer = new FileWriter("E:\\" + user.getUserName() + ".txt", true);
                writer.write((letter.getLetterTittle().replace("письмо", user.getUserName())));

                System.out.println(user.getUserName());
                writer.close();
            }


            if (worker.getConnection().isClosed()) {
                System.out.println("Connection on");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("writer error");
            ;
        }


    }
}
