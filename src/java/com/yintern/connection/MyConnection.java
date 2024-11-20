
package com.yintern.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MyConnection {
    static Connection con = null;

    static {
        try {
<<<<<<< HEAD
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.jdbc.Driver");

            // Database URL, Username, and Password
            String url = "jdbc:mysql://localhost:3306/y_intern";
=======
         
            Class.forName("com.mysql.cj.jdbc.Driver");

            
            String url = "jdbc:mysql://localhost:3307/y_intern";
>>>>>>> f902f5460aae893c29b8333eefb521339f5d7224
            String username = "root";
            String password = "anurag";

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
