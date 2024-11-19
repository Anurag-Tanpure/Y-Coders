
package com.yintern.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MyConnection {
    static Connection con = null;

    static {
        try {
         
            Class.forName("com.mysql.cj.jdbc.Driver");

            
            String url = "jdbc:mysql://localhost:3307/y_intern";
            String username = "root";
            String password = "root";

            con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection to y_intern database established successfully!");

        } catch (ClassNotFoundException e) {
            System.err.println("MySQL Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error connecting to the database: " + e.getMessage());
        }
    }


    public static Connection getConnection() {
        return con;
    }
}
