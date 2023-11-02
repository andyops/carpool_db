package org.example;

import org.example.database.DatabaseConnector;
import org.example.database.UserDAO;
import org.example.models.User;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        DatabaseConnector databaseConnector = new DatabaseConnector();
        Connection connection = databaseConnector.getConnection();

        //insert user
        UserDAO userDAO = new UserDAO( connection );
        //String query = "INSERT INTO User (username, email, password, is_driver) VALUES (?, ?, ?, ?)";
        userDAO.deleteUserById(3);
    }
}