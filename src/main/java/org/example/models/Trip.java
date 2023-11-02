package org.example.models;

import java.util.Date;

public class Trip {
    private int trip_id;
    private String from_location;
    private String to_destination;
    private Date date;
    private String time;
    private int driver_id;

    public Trip(int trip_id, String from_location, String to_destination, Date date, String time, int driver_id) {
        this.trip_id = trip_id;
        this.from_location = from_location;
        this.to_destination = to_destination;
        this.date = date;
        this.time = time;
        this.driver_id = driver_id;
    }

    public int getTrip_id() {
        return trip_id;
    }

    public void setTrip_id(int trip_id) {
        this.trip_id = trip_id;
    }

    public String getFrom_location() {
        return from_location;
    }

    public void setFrom_location(String from_location) {
        this.from_location = from_location;
    }

    public String getTo_destination() {
        return to_destination;
    }

    public void setTo_destination(String to_destination) {
        this.to_destination = to_destination;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getDriver_id() {
        return driver_id;
    }

    public void setDriver_id(int driver_id) {
        this.driver_id = driver_id;
    }
}
