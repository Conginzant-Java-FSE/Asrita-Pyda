package org.example;

import java.util.*;

public class MostFrequent {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = s.nextInt();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(s.nextInt());
        }

        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : list) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int maxFreq = 0;
        int result = Integer.MAX_VALUE;

        for (Map.Entry<Integer, Integer> e: freq.entrySet()) {
            if (e.getValue() > maxFreq ||
                    (e.getValue() == maxFreq && e.getKey() < result)) {
                maxFreq = e.getValue();
                result = e.getKey();
            }
        }

        System.out.println("Most frequent element: " + result);
    }
}
