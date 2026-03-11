package org.arya.string;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CharacterOccurrenceCounter {

    public static void main(String[] args) {
        String str = "munim";
        System.out.println("Using array:");
        countCharsMap(str);
        countCharsJava8(str);
        countCharsArrayASCII(str);
    }

    // Time: O(n) | Space: O(k) where k = unique characters
    public static void countCharsMap(String input) {
        Map<Character, Integer> countMap = new HashMap<>();

        for (char c : input.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        countMap.forEach((key, value) -> 
            System.out.println("'" + key + "' → " + value)
        );
    }

    // Time: O(n) | Space: O(k)
    public static void countCharsJava8(String input) {
        Map<Character, Long> charCount = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(charCount);
    }

    // Time: O(n) | Space: O(1) - fixed size array
    public static void countCharsArrayASCII(String str) {
        int[] freq = new int[128];  // Assuming ASCII characters

        for (char c : str.toCharArray()) {
            freq[c]++;
        }

        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {
                System.out.println((char) i + ": " + freq[i]);
            }
        }
    }

}