package org.example;

import java.util.*;
import java.util.stream.*;

class Employee2 {
    int id;
    String name;
    String department;
    double salary;

    Employee2(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
}

public class GroupingAvgSalary {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Employee2> employees = new ArrayList<>();

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Employee " + (i + 1));

            System.out.print("ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Department: ");
            String department = sc.nextLine();

            System.out.print("Salary: ");
            double salary = sc.nextDouble();
            sc.nextLine();
            employees.add(new Employee2(id, name, department, salary));
        }
        Map<String, Double> avgSalary =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                e -> e.department,
                                Collectors.averagingDouble(e -> e.salary)
                        ));
        System.out.println("\nAverage Salary by Department:");
        avgSalary.forEach((dept, avg) ->
                System.out.println(dept + " = " + avg));
    }
}
