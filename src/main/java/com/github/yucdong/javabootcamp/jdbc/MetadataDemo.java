package com.github.yucdong.javabootcamp.jdbc;

import java.sql.*;

public class MetadataDemo {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url      = "jdbc:mysql://52.246.179.108:3306/yucdongdemo";   //database specific url.
            String user     = "yucdong";
            String password = "password";

            System.out.println("Hello");

            // Note: mysql server should not run on 127.0.0.1
            try(Connection connection = DriverManager.getConnection(url, user, password)) {
                DatabaseMetaData metadata = connection.getMetaData();
                System.out.println("Database Major Version: " + metadata.getDatabaseMajorVersion());
                System.out.println("Database Minor Version: " + metadata.getDatabaseMinorVersion());

                String   catalog          = null;
                String   schemaPattern    = null;
                String   tableNamePattern = null;
                String[] types            = null;

                ResultSet result = metadata.getTables(
                        catalog, schemaPattern, tableNamePattern, types );

                while(result.next()) {
                    String tableName = result.getString(3);
                    System.out.println("Table: " + tableName);
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
