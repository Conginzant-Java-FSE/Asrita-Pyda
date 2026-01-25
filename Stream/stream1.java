package org.example;
//Problem 1: You are given a list of employee names with their salaries in the format
//"Name:Salary".
//
//Perform the following using Java Streams:
//
//1) Extract only salaries greater than 50,000
//2) Convert the salaries to annual salary (salary × 12)
//3) Remove duplicate salary values
//4) Sort the salaries in descending order
//5) Skip the top highest salary
//6) Limit the result to next 2 salaries
//7) Count how many salaries remain
//
//SAMPLE INPUT
//List<String> employees = List.of(
//    "Alice:60000",
//    "Bob:45000",
//    "Charlie:75000",
//    "David:60000",
//    "Eva:90000"
//);
//
//SAMPLE OUTPUT
//Annual Salaries After Processing: [900000, 720000]
//Count: 2


import java.util.*;
import java.util.stream.*;

public class stream1 {
    public static void main(String[] args) {
        List<String> employees = List.of(
                    "Alice:60000",
                    "Bob:45000",
                    "Charlie:75000",
                    "David:60000",
                    "Eva:90000"
        );
        List<Integer> emp = employees.stream().map(e->e.split(":")[1]).map(Integer::parseInt).filter(s->s>50000).map(s->s*12).distinct().sorted(Comparator.reverseOrder()).skip(1).limit(2).collect(Collectors.toList());
        int c = emp.size();
        System.out.println("Annual Salaries After Processing: " +emp);
        System.out.println("Count: "+c);
    }
}

