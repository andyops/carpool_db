package org.example.models;

public class Booking {
    private int booking_id;
    private int user_id;
    private int trip_id;
    private String booking_status;

    public Booking(int booking_id, int user_id, int trip_id, String booking_status) {

        this.booking_id = booking_id;
        this.user_id = user_id;
        this.trip_id = trip_id;
        this.booking_status = booking_status;
    }

    public int getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(int booking_id) {
        this.booking_id = booking_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getTrip_id() {
        return trip_id;
    }

    public void setTrip_id(int trip_id) {
        this.trip_id = trip_id;
    }

    public String getBooking_status() {
        return booking_status;
    }

    public void setBooking_status(String booking_status) {
        this.booking_status = booking_status;
    }
}
