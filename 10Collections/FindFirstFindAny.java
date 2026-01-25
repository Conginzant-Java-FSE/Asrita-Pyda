package org.example;

import java.util.*;
import java.util.stream.*;

public class FindFirstFindAny {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        List<Integer> list = new ArrayList<>();
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        Optional<Integer> f =
                list.stream()
                        .filter(num -> num % 2 == 0)
                        .findFirst();

        Optional<Integer> a =
                list.parallelStream()
                        .filter(num -> num % 2 == 0)
                        .findAny();

        System.out.println("findFirst even: " +
                f.orElse(null));

        System.out.println("findAny even: " +
                a.orElse(null));
    }
}

