package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Employee {
    int id;
    String name;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    double salary;

}
public class EmployeeSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Employee> list = new ArrayList<>();

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for employee " + (i + 1) +" :-");
            System.out.println("ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Salary: ");
            double salary = sc.nextDouble();

            list.add(new Employee(id, name, salary));
        }
        Collections.sort(list, (e1, e2) -> {
            if (Double.compare(e1.salary, e2.salary) != 0)
                return Double.compare(e2.salary, e1.salary);
            if (!e1.name.equals(e2.name))
                return e1.name.compareTo(e2.name);
            return Integer.compare(e1.id, e2.id);
        });

        System.out.println("\nSorted Employees:");
        for (Employee e : list) {
            System.out.println(e.id + " " + e.name + " " + e.salary);
        }
    }
}
