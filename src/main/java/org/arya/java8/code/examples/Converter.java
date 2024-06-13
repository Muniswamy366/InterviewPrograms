package org.arya.java8.code.examples;

@FunctionalInterface
public interface Converter<F, T> {
    T convert(F from);
}
