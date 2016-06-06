package com.paveal.testDB;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.Pipe;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class Main {

    public static void main(String[] args) {
        DbWorker worker = new DbWorker();
//        FileWriter writer = null;
        String SQL = "SELECT username, tittle_latter, uses_pattern_letter.id   \" +\n" +
                "                            \"FROM users, uses_pattern_letter WHERE uses_pattern_letter.id=1";
        String SQL1 = "SELECT username FROM users";
        Collection<String> strings = new ArrayList<>();

        try {

            Statement statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(SQL1);

            while (resultSet.next()) {
                User user = new User();
//                Letter letter = new Letter();

                user.setUserName(resultSet.getString("username"));
//                letter.setLetterTittle(resultSet.getString("tittle_latter"));

//                writer = new FileWriter("E:\\" + user.getUserName() + ".txt", true);
//                writer.write((letter.getLetterTittle().replace("письмо", user.getUserName())));
                    strings.add(user.getUserName());
//                System.out.println(user.getUserName());
//                writer.close();
            }
            for (String i: strings
                 ) {
                System.out.println(i);
            }

            if (worker.getConnection().isClosed()) {
                System.out.println("Connection on");
            }
        } catch (SQLException e) {
            e.printStackTrace();
//        } catch (IOException e) {
//            System.err.println("writer error");
//
//        }


    }
}}
