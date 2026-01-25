package org.example;
import java.util.*;
import java.util.stream.*;
class Employee1 {
    int id;
    String name;
    String department;
    double salary;

    Employee1(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
}
public class StreamFilterMap {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Employee1> employees = new ArrayList<>();

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details of employee " + (i + 1));

            System.out.print("ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Department: ");
            String department = sc.nextLine();

            System.out.print("Salary: ");
            double salary = sc.nextDouble();

            employees.add(new Employee1(id, name, department, salary));
        }

        List<String> names = employees.stream()
                .filter(e -> e.salary > 75000)
                .map(e -> e.name)
                .sorted()
                .toList();

        System.out.println("\nEmployees with salary > 75000:");
        System.out.println(names);
    }
}
