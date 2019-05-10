package com.github.yucdong.javabootcamp.jdbc;

import java.sql.*;

public class BasicExample {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url      = "jdbc:mysql://13.78.98.63:3306/yucdongdemo";   //database specific url.
            String user     = "yucdong";
            String password = "password";

            System.out.println("Hello");

            // Note: mysql server should not run on 127.0.0.1
            try(Connection connection = DriverManager.getConnection(url, user, password)) {

                // You need to close statement
                try(Statement statement = connection.createStatement()){
                    String sql = "select * from people";

                    // You need to close resultset
                    try(ResultSet result = statement.executeQuery(sql)){
                        while(result.next()) {
                            String name = result.getString("name");
                            long   age  = result.getLong  ("age");
                            System.out.println("Name: " + name + ", age: " + age);
                        }
                    }
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
