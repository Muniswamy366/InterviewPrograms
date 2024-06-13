package org.arya.java8.code.examples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapTest {
    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("1", "2", "3");
        List<String> list2 = Arrays.asList("muni", "swamy");

        // string to integer
        Converter<String, Integer> strToInt = Integer::parseInt;
        // string to upper case
        Converter<String, String> strToUpper = String::toUpperCase;
        // Reverse the string
        Converter<String, String> reverseString = str -> new StringBuilder(str).reverse().toString();

        List<Integer> collect1 = list1.stream().map(strToInt::convert).collect(Collectors.toList());
        System.out.println(collect1);

        List<String> collect2 = list2.stream().map(strToUpper::convert).collect(Collectors.toList());
        System.out.println(collect2);

        List<String> collect3 = list2.stream().map(reverseString::convert).collect(Collectors.toList());
        System.out.println(collect3);

    }
}