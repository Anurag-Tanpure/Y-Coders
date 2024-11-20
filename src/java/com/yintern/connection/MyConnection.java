/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yintern.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Lenovo
 */
public class MyConnection {
    static Connection con = null;

    static {
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.jdbc.Driver");

            // Database URL, Username, and Password
            String url = "jdbc:mysql://localhost:3306/y_intern";
            String username = "root";
            String password = "anurag";

            // Establish Connection
            con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection to y_intern database established successfully!");

        } catch (ClassNotFoundException e) {
            System.err.println("MySQL Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error connecting to the database: " + e.getMessage());
        }
    }

    // Method to retrieve the connection object
    public static Connection getConnection() {
        return con;
    }
}
