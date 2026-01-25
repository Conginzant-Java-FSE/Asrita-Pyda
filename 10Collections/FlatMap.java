package org.example;

import java.util.*;
import java.util.stream.*;

public class FlatMap {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<List<String>> data = new ArrayList<>();

        System.out.print("Enter number of lists: ");
        int outerSize = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < outerSize; i++) {
            System.out.print("Enter number of elements in list " + (i + 1) + ": ");
            int innerSize = sc.nextInt();
            sc.nextLine();

            List<String> innerList = new ArrayList<>();
            System.out.println("Enter elements:");

            for (int j = 0; j < innerSize; j++) {
                innerList.add(sc.nextLine());
            }

            data.add(innerList);
        }
        List<String> result =
                data.stream()
                        .flatMap(List::stream)
                        .distinct()
                        .sorted(Comparator.reverseOrder())
                        .toList();

        System.out.println("Final Result:");
        System.out.println(result);
    }
}
