package com.github.yucdong.javabootcamp.jdbc;

import java.sql.*;

public class PreparedStatementDemo {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url      = "jdbc:mysql://52.246.179.108:3306/yucdongdemo";   //database specific url.
            String user     = "yucdong";
            String password = "password";

            System.out.println("Hello");

            // Note: mysql server should not run on 127.0.0.1
            try(Connection connection = DriverManager.getConnection(url, user, password)) {
                String sql = "select * from people where name=?";
                PreparedStatement pstmt = connection.prepareStatement(sql);
                pstmt.setString(1, "Yuchen Dong");

                try (ResultSet result = pstmt.executeQuery()) {
                    while (result.next()) {
                        String name = result.getString("name");
                        int age = result.getInt("age");
                        System.out.println("Age is " + age + ", name is " + name);
                    }
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
