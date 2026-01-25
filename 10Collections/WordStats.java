package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class WordStats {
    long allw;
    long dw;

    public WordStats(long allw, long dw) {
        this.allw = allw;
        this.dw = dw;
    }
    @Override
    public String toString() {
        return "Total Words: " + allw +
                ", Distinct Words: " + dw;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of sentences: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        List<String> sentences = new ArrayList<>();

        System.out.println("Enter sentences:");
        for (int i = 0; i < n; i++) {
            sentences.add(sc.nextLine());
        }

        WordStats stats = sentences.stream().flatMap(s -> Arrays.stream(s.split("\\s+"))).collect(Collectors.collectingAndThen(Collectors.toList(), list -> new WordStats(list.size(), list.stream().distinct().count())));
        System.out.println(stats);
    }
}
