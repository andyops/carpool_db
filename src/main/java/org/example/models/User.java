package org.example.models;

public class User {
//    -- Create the User table
//    CREATE TABLE  User (
//            user_id INT NOT NULL AUTO_INCREMENT,
//            username VARCHAR(50) NOT NULL,
//    email VARCHAR(100) NOT NULL,
//    password VARCHAR(50) NOT NULL,
//    is_driver BOOLEAN NOT NULL,
//    PRIMARY KEY (user_id)
//);
    private int user_id;
    private String username;
    private String email;
    private String password;

    public User() {
    }

    private boolean is_driver;

    public User(int user_id, String username, String email, String password, boolean is_driver) {
        this.user_id = user_id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.is_driver = is_driver;
    }

    public User(String username, String email, String password, boolean is_driver) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.is_driver = is_driver;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isIs_driver() {
        return is_driver;
    }

    public void setIs_driver(boolean is_driver) {
        this.is_driver = is_driver;
    }
}
