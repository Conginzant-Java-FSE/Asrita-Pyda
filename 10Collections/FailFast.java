package org.example;

import java.util.*;

public class FailFast {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        System.out.println("Original List: " + list);

        try {
            for (Integer num : list) {
                if (num == 2) {
                    list.remove(num);
                }
            }
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e);
        }
    }
}


class FailSafe {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        System.out.println("Original List: " + list);

        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            Integer num = it.next();
            if (num == 2) {
                it.remove();
            }
        }

        System.out.println("After removal: " + list);
    }
}


