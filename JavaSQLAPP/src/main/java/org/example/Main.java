package org.example;
import org.example.controller.UserController;
import org.example.model.UserModel;
import org.example.service.UserService;
import java.sql.Timestamp;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserService userService = new UserService();
        UserController userController = new UserController(userService);

        while (true) {
            System.out.println("\n===== USER MANAGEMENT MENU =====");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    // Registration
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();

                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();

                    UserModel newUser = new UserModel();
                    newUser.setUserName(username);
                    newUser.setEmail(email);
                    newUser.setStatus("ACTIVE");
                    newUser.setCreatedAT(new Timestamp(System.currentTimeMillis()));

                    boolean registered = userService.register(newUser, password);
                    if (registered) {
                        System.out.println("User registered successfully!");
                    } else {
                        System.out.println("Registration failed! User may already exist.");
                    }
                    break;
                case 2:
                    // Login via Controller
                    userController.login();
                    break;

                case 3:
                    System.out.println("Exiting application...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid option, try again.");
            }
        }
    }
}
