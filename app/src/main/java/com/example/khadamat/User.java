package com.example.khadamat;


import java.util.List;

public class User {
    private String username,email,password;
    private Service service;
    private String imagePath;
    public User() {
    }

    public User(String username, String email, String password, Service service,String imagePath) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.service = service;
        this.imagePath = imagePath;
    }

    public String getUsername() {
        return username;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
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

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}


