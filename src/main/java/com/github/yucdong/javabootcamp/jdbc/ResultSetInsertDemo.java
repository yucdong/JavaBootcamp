package com.github.yucdong.javabootcamp.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ResultSetInsertDemo {
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
                        ResultSet.CLOSE_CURSORS_AT_COMMIT)){ // holdability (what happens when connection is commited)
                    String sql = "select * from people";

                    try(ResultSet result = statement.executeQuery(sql)){
                        System.out.println(result.getType());

                        // Insert row
                        result.moveToInsertRow();
                        result.updateInt(1, 2);
                        result.updateString("name", "Jeff");
                        result.updateInt(3, 30);
                        result.insertRow();

                        // Iterate and see the inserted row
                        result.beforeFirst();
                        while(result.next()) {
                            String name = result.getString("name");
                            long   age  = result.getLong  ("age");
                            System.out.println("Name: " + name + ", age: " + age);
                        }
                    }

                    String deleteSql = "delete from people where name='Jeff'";
                    int rowsAffected = statement.executeUpdate(deleteSql);
                    System.out.println("Rows deleted: " + rowsAffected);
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
