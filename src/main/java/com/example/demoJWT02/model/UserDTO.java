package com.example.demoJWT02.model;


/**
 * UserDTO model class is responsible for getting values from user and passing it to the DAO layer for inserting in database..
 */
public class UserDTO {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //testing version control
}
