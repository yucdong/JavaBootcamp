package com.github.yucdong.javabootcamp.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ResultSetDemo {
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
                // ResultSet metadata is determined by statement
                try(Statement statement = connection.createStatement(
                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_UPDATABLE, // The resultset is updatable
                        ResultSet.CLOSE_CURSORS_AT_COMMIT)){
                    String sql = "select * from people";

                    // You need to close resultset
                    try(ResultSet result = statement.executeQuery(sql)){
                        System.out.println(result.getType());

                        while(result.next()) {
                            String name = result.getString("name");
                            long   age  = result.getLong  ("age");
                            System.out.println("Name: " + name + ", age: " + age);

                            if (name.equals("Yuchen Dong")) {
                                result.updateString("name", "Yucdong");
                                result.updateRow(); // Call updateRow to actually update the database
                            }
                        }

                        result.beforeFirst();
                        while(result.next()) {
                            String name = result.getString("name");
                            long   age  = result.getLong  ("age");
                            System.out.println("Name: " + name + ", age: " + age);

                            if (name.equals("Yucdong")) {
                                result.updateString("name", "Yuchen Dong");
                                result.updateRow();
                            }
                        }

                        // Insert row
                        result.moveToInsertRow();
                        result.updateInt(1, 2);
                        result.updateString("name", "Jeff");
                        result.updateInt(3, 30);
                        result.insertRow();
                    }
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
