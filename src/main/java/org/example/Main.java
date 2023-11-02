package org.example;

import org.example.database.DatabaseConnector;

public class Main {
    public static void main(String[] args) {
        DatabaseConnector databaseConnector = new DatabaseConnector();
        databaseConnector.getConnection();
    }
}