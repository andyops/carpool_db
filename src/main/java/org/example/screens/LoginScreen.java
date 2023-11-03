package org.example.screens;

import org.example.database.UserDAO;
import org.example.database.TripDAO;
import org.example.models.Trip;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Timestamp;

public class LoginScreen {
    public JPanel LoginPanel;
    private JTextField Username;
    private JPasswordField PasswordField;
    private JButton Login;
    private JButton Register;
    private JTextField Destination;
    private JTextField Location;
    private JRadioButton isDriver;

    public LoginScreen(Connection connection) {
        Login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = Username.getText();
                String password = new String(PasswordField.getPassword());
                int userid =validateLogin(username, password, connection);
                int driverid = 0;

                if (userid>=0) {

                    JOptionPane.showMessageDialog(null, "Login successful!");
                    if (isDriver.isSelected()) {
                        // Code to create a trip if the user is marked as a driver
                        driverid = userid;
                        createTrip(connection , driverid);
                    }
                    // Code to open the main dashboard or perform other actions upon successful login
                    DashboardScreen dashboardScreen = new DashboardScreen(connection);
                    JFrame frame = new JFrame("Dashboard");
                    frame.setContentPane(dashboardScreen.DashboardPanel);
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Dispose the dashboard window
                    frame.pack();
                    frame.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password. Please try again.");
                }
            }
        });

        Register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegistrationScreen registrationScreen = new RegistrationScreen();
                JFrame frame = new JFrame("Registration");
                frame.setContentPane(registrationScreen.RegistrationPanel);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Dispose the registration window
                frame.pack();
                frame.setVisible(true);
            }
        });
    }

    private int validateLogin(String username, String password, Connection connection) {
        // Replace this with actual validation logic using UserDAO
        // For example:
        UserDAO userDAO = new UserDAO(connection);
        int isValid = userDAO.validateUser(username, password);
        return isValid;
    }

    private void createTrip(Connection connection, int driverid) {
        // Add code to create a trip using TripDAO or relevant methods
        TripDAO tripDAO = new TripDAO(connection);
        // Example: tripDAO.createTrip(username, Location.getText(), Destination.getText(), date, time);
        Trip newTrip = new Trip();
        newTrip.setFrom_location(Location.getText()); // Assuming Location is a JTextField
        newTrip.setTo_destination(Destination.getText()); // Assuming Destination is a JTextField

        // Automatically allocate current date and time
        java.util.Date currentDate = new java.util.Date(); // Current date and time
        Timestamp timestamp = new Timestamp(currentDate.getTime()); // Current timestamp

        newTrip.setDate(new java.sql.Date(currentDate.getTime()));
        newTrip.setTime(timestamp.toLocalDateTime().toLocalTime().toString()); // Extracts time from the timestamp

        // Get driver ID from the authenticated user or any other source
        int driverId = driverid; // Replace this with the actual driver ID

        newTrip.setDriver_id(driverId);

        boolean isTripAdded = tripDAO.addTrip(newTrip);

        if (isTripAdded) {
            JOptionPane.showMessageDialog(null, "Trip created successfully!");
        } else {
            JOptionPane.showMessageDialog(null, "Failed to create the trip. Please try again.");
        }
    }
}
