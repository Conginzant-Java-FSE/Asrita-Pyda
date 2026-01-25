//Problem 2: You are given a list of product prices.
//Using Java Streams, perform the following:
//
//        1) Filter prices greater than 1000
//        2) Remove duplicate prices
//         3) Sort prices in descending order
//         4) Count how many prices are greater than 2000
//
//SAMPLE INPUT:
//List<Integer> prices = List.of(
//        500, 1200, 2500, 1200, 3000, 800, 2500
//);
//
//SAMPLE OUTPUT:
//Processed Prices: [3000, 2500, 1200]
//Count of prices > 2000: 2
package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class stream2 {
    public static void main(String[] args) {
        List<Integer> prices = List.of(
                500, 1200, 2500, 1200, 3000, 800, 2500);
        List<Integer> pri = prices.stream().filter(e->e>1000).distinct().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        List<Integer> p = pri.stream().filter(e->e>2000).collect(Collectors.toList());
        int c = p.size();
        System.out.println("Processed Prices: " + pri);
        System.out.println("Count of prices > 2000: " + c);
    }
}
