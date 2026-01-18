package org.example.controller;

import org.example.model.UserModel;
import org.example.service.UserService;

import java.util.Scanner;

public class UserController {
    UserService service;
    public UserController(UserService service){
        this.service=service;
    }
    public void login(){
        Scanner s = new Scanner(System.in);

        System.out.print("UserName: ");
        String userName = s.next();

        System.out.print("Password: ");
        String password = s.next();

        UserModel user = service.login(userName, password);

        if (user != null) {
            System.out.println("Login successful");
            System.out.println("Welcome, " + user.getUserName());
        } else {
            System.out.println("Invalid credentials");
        }
    }
}
