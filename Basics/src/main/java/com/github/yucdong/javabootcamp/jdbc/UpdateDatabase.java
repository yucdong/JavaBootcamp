package com.github.yucdong.javabootcamp.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class UpdateDatabase {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url      = "jdbc:mysql://52.246.179.108:3306/yucdongdemo";   //database specific url.
            String user     = "yucdong";
            String password = "password";

            System.out.println("Hello");

            // Note: mysql server should not run on 127.0.0.1
            try(Connection connection = DriverManager.getConnection(url, user, password)) {

                // You need to close statement
                try(Statement statement = connection.createStatement()){
                    String sql = "update people set name='Yuchen Dong' where id=1";

                    // You need to close resultset
                    int affectedRows = statement.executeUpdate(sql);
                    System.out.println("Affected rows: " + affectedRows);
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
