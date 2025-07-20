package org.arya.java8.code.examples;

import java.util.Arrays;
import java.util.List;

public class FilterTest {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Laptop", 1200, "Electronics"),
            new Product("Shoes", 80, "Fashion"),
            new Product("Phone", 800, "Electronics"),
            new Product("T-shirt", 20, "Fashion"),
            new Product("Headphones", 100, "Electronics")
        );

        // Complex filter criteria: Electronics products costing more than $500
        ProductFilter expensiveElectronicsFilter = product ->
            product.getCategory().equalsIgnoreCase("Electronics") && product.getPrice() > 500;

        List<Product> filteredProducts = products.stream().filter(expensiveElectronicsFilter::filter).toList();

        filteredProducts.forEach(System.out::println);
    }
}
