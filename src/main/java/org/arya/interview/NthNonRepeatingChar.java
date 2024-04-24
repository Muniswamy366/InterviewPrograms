package org.arya.interview;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NthNonRepeatingChar {
    public static void main(String[] args) {
        String input = "abacus";

        Map<String, Long> collect1 = Arrays.stream(input.split("")).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
        System.out.println(collect1);

        Map.Entry<String, Long> stringLongEntry = collect1.entrySet().stream().filter(entry -> entry.getValue() == 1).skip(2).findFirst().orElseThrow(IllegalStateException::new);
        System.out.println(stringLongEntry.getKey());
    }
}
