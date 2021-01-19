package com.example.khadamat;


public class User {
    private String username,email,password;
    private Service service;
    public User() {
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public User(String username, String email, String password, Service service) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.service=service;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

}
