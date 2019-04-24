package com.github.yucdong.javabootcamp.jdbc;

import java.sql.*;

public class TransactionDemo {
    public static void main(String[] args) throws java.lang.ClassNotFoundException, java.sql.SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url      = "jdbc:mysql://52.246.179.108:3306/yucdongdemo";   //database specific url.
        String user     = "yucdong";
        String password = "password";

        System.out.println("Hello");

        Connection connection = DriverManager.getConnection(url, user, password);
        try{
            connection.setAutoCommit(false);
            Statement statement1 = null;
            try{
                statement1 = connection.createStatement();
                statement1.executeUpdate(
                        "update people set age=30 where id=1");
            } finally {
                if(statement1 != null) {
                    statement1.close();
                }
            }

            Statement statement2 = null;
            try{
                statement2 = connection.createStatement();
                int rowAffected = statement2.executeUpdate(
                        "update people set age=29 where id=1");

                System.out.println("Rows affected: " + rowAffected);
            } finally {
                if(statement2 != null) {
                    statement2.close();
                }
            }

            connection.commit();
        } catch(Exception e) {
            connection.rollback();
        } finally {
            if(connection != null) {
                connection.close();
            }
        }
    }
}
