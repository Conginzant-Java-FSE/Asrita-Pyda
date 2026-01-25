package org.example;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class WordFrequency {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter sentence:");
        String sen= s.nextLine();

        String[] words = sen.split("\\s+");
        Map<String, Integer> map = new TreeMap<>();

        for (String w : words) {
            w= w.toLowerCase();
            map.put(w, map.getOrDefault(w, 0) + 1);
        }

        System.out.println("Word Frequencies:");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
