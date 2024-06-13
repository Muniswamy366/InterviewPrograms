package org.arya.java8.code.examples;

@FunctionalInterface
public interface ProductFilter {
    boolean filter(Product product);
}
