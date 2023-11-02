package org.example.models;

public class Car {
    private int car_id;
    private int driver_id;
    private String make;
    private String model;
    private int year;

    public Car(int car_id, int driver_id, String make, String model, int year) {
        this.car_id = car_id;
        this.driver_id = driver_id;
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public int getCar_id() {
        return car_id;
    }

    public Car(int driver_id, String make, String model, int year) {
        this.driver_id = driver_id;
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public Car() {
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }

    public int getDriver_id() {
        return driver_id;
    }

    public void setDriver_id(int driver_id) {
        this.driver_id = driver_id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
