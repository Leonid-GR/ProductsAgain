package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Product> products = Arrays.asList(
                new Product("iPhone", "Electronics", 40000),
                new Product("Samsung", "Electronics", 30000),
                new Product("Laptop", "Computers", 50000),
                new Product("PC", "Computers", 60000),
                new Product("T-shirt", "Clothes", 800),
                new Product("Jacket", "Clothes", 2000)
        );

        Map<String, Double> averages = products.stream()
                .collect(Collectors.groupingBy(
                        p -> p.category,
                        Collectors.averagingDouble(p -> p.price)
                ));

        averages.forEach((category, average) ->
                System.out.println(category + ": " + average));

        String maxCategory = averages.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .get().getKey();

        System.out.println("Highest average price: " + maxCategory);
    }
}
