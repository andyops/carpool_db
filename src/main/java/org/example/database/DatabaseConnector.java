package org.example.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    private static final String URL = "jdbc:mysql://localhost:3306/carpool_db"; // Replace with your database URL
    private static final String USER = "root"; // Replace with your username
    private static final String PASSWORD = "password"; // Replace with your password

    private Connection connection;

    public DatabaseConnector() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            if (connection != null) {
                System.out.println("Connected to the database!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to connect to the database!");
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
