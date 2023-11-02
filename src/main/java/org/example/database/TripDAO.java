package org.example.database;


import org.example.models.Trip;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.Timestamp;

public class TripDAO {
    private final Connection connection;

    public TripDAO(Connection connection) {
        this.connection = connection;
    }

    public boolean addTrip(Trip trip) {
        String query = "INSERT INTO Trip (from_location, to_destination, date, time, driver_id) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, trip.getFrom_location());
            preparedStatement.setString(2, trip.getTo_destination());

            // Automatically allocate current date and time
            Date currentDate = new Date();
            Timestamp timestamp = new Timestamp(currentDate.getTime());

            preparedStatement.setTimestamp(3, timestamp);
            preparedStatement.setString(4, timestamp.toString().split(" ")[1]); // Extracts time from the timestamp
            preparedStatement.setInt(5, trip.getDriver_id());

            int affectedRows = preparedStatement.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Trip> getAllTrips() {
        List<Trip> trips = new ArrayList<>();
        String query = "SELECT * FROM Trip";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                trips.add(extractTripFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trips;
    }

    private Trip extractTripFromResultSet(ResultSet resultSet) throws SQLException {
        Trip trip = new Trip();
        trip.setTrip_id(resultSet.getInt("trip_id"));
        trip.setFrom_location(resultSet.getString("from_location"));
        trip.setTo_destination(resultSet.getString("to_destination"));
        trip.setDate(resultSet.getDate("date"));
        trip.setTime(resultSet.getString("time"));
        trip.setDriver_id(resultSet.getInt("driver_id"));
        return trip;
    }
}
