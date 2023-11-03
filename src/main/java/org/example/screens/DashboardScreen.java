package org.example.screens;

import org.example.database.TripDAO;
import org.example.models.Trip;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class DashboardScreen {
    public JPanel DashboardPanel;
    private JTextField tripid;
    private JButton selectTripButton;
    private JTable triptable;

    public DashboardScreen(Connection connection) {
        // Create a table model for the triptable
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Trip ID");
        tableModel.addColumn("From Location");
        tableModel.addColumn("To Destination");
        // Add more columns as needed

        // Populate the triptable with available trips
        TripDAO tripDAO = new TripDAO(connection);
        for (Trip trip : tripDAO.getAllTrips()) {
            tableModel.addRow(new Object[]{trip.getTrip_id(), trip.getFrom_location(), trip.getTo_destination()});
            // Add more columns as needed
        }
        triptable.setModel(tableModel);

        selectTripButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = triptable.getSelectedRow();
                if (selectedRow >= 0) {
                    int selectedTripId = (int) triptable.getValueAt(selectedRow, 0); // Assuming the first column is the Trip ID
                    // Code to handle booking confirmation
                    handleBookingConfirmation(selectedTripId, connection);
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a trip from the list.");
                }
            }
        });
    }

    private void handleBookingConfirmation(int tripId, Connection connection) {
        // Code to handle booking confirmation and navigate to BookingConfirmationScreen
        BookingConfirmationScreen bookingConfirmationScreen = new BookingConfirmationScreen(tripId, connection);
        JFrame frame = new JFrame("Booking Confirmation");
        frame.setContentPane(bookingConfirmationScreen.BookingConfirmationPanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Dispose the confirmation window
        frame.pack();
        frame.setVisible(true);
    }
}
