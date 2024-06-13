package org.arya.java8;

import org.arya.java8.code.examples.TriFunction;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Random;
import java.util.function.*;


public class InbuiltFunctions {

    public static void main(String[] args) {

        // Function<T, R> accepts one argument and produces a result.
        Function<String, Integer> stringLengthFunction = String::length;
        Integer length = stringLengthFunction.apply("muni");
        System.out.println("Length of the string: " + length); // Output: 4

        // Predicate<T> accepts one argument and return a boolean.
        Predicate<Integer> isEven = n -> n % 2 == 0;
        boolean result3 = isEven.test(4);
        System.out.println(result3); // Output: true

        // Consumer<T> accepts a single input argument and returns no result.
        Consumer<String> consumer1 = s -> System.out.println(s);
        Consumer<String> consumer2 = System.out::println;
        Comparator<Integer> consumer3 = (i1, i2) -> Integer.compare(i1, i2);
        Comparator<Integer> consumer4 = Integer::compare;

        // Supplier<T> Represents a supplier of results.
        Supplier<LocalDateTime> s = LocalDateTime::now;
        LocalDateTime time = s.get();
        System.out.println(time);

        Supplier<Integer> randomNumberSupplier = () -> new Random().nextInt(100);
        Integer randomNumber = randomNumberSupplier.get();
        System.out.println("Random number: " + randomNumber);

        // BiFunction<T, U, R> accepts two arguments and return a result.
        BiFunction<String, String, String> concatenate = (s1, s2) -> s1 + s2;
        String result = concatenate.apply("Hello", "World");
        System.out.println(result); // Output: Hello, World!


        // BiPredicate<T, U> accepts two arguments and return a boolean.
        BiPredicate<String, String> equalsIgnoreCase = String::equalsIgnoreCase;
        boolean result1 = equalsIgnoreCase.test("java", "JAVA");
        System.out.println("Strings are equal (ignoring case): " + result1); // Output: true


        TriFunction<Integer, Integer, Integer, Integer> addThreeNumbers = (a, b, c) -> a + b + c;
        Integer result2 = addThreeNumbers.apply(1, 2, 3);
        System.out.println("Sum of three numbers: " + result2); // Output: 6
    }

}
