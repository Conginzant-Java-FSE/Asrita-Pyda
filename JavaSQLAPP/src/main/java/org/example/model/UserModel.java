package org.example.model;

import java.sql.Timestamp;

public class UserModel {
    private int id;
    private String userName;
    private String email;
    private String password;
    private String status;
    private Timestamp createdAt;
    public UserModel(int id, String userName, String email,String password, String status, Timestamp createdAt) {
        this.id = id;
        this.userName=userName;
        this.email= email;
        this.password=password;
        this.status=status;
        this.createdAt=createdAt;
    }
    public UserModel() {}

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAT(Timestamp createdAT) {this.createdAt = createdAt;}
}
