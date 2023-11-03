package org.example;

import org.example.database.DatabaseConnector;
import org.example.database.UserDAO;
import org.example.models.User;
import org.example.screens.LoginScreen;

import javax.swing.*;
import java.sql.Connection;

public class Main {
    public static void main(String[] args) {



        //login screen and login
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Login");
                DatabaseConnector databaseConnector = new DatabaseConnector();
                Connection connection = databaseConnector.getConnection();
                LoginScreen loginScreen = new LoginScreen(connection);
                frame.setContentPane(loginScreen.LoginPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });

    }
}