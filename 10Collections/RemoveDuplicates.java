package org.example;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.Scanner;
public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter size: ");
        int n = s.nextInt();
        List<Integer> li = new ArrayList<>();
        System.out.println("Enter elements: ");
        for (int i = 0; i <n; i++) {
            li.add(s.nextInt());
        }
        Set<Integer> set = new LinkedHashSet<>(li);
        List<Integer> r=new ArrayList<>(set);
        System.out.println("after removing duplicates: " + r);
    }

}
