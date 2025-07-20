package org.arya.advance;

import java.util.HashMap;
import java.util.Map;

public class CountDuplicateNumArray {
    public static void main(String[] args) {
        int[] numbers = {2, 4, 2, 6, 4, 4};
        findMaxOccurrences(numbers);
    }

    public static void findMaxOccurrences(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            System.out.println("Array is empty or null");
            return;
        }

        // Count occurrences using HashMap
        Map<Integer, Integer> countMap = new HashMap<>();
        int maxCount = 0;

        for (int num : numbers) {
            // num is the key, and its count is the value
            int count = countMap.getOrDefault(num, 0) + 1;
            countMap.put(num, count);
            maxCount = Math.max(maxCount, count);
        }

        // Print numbers with maximum occurrences
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == maxCount) {
                System.out.printf("Number %d appears %d times%n",
                        entry.getKey(), entry.getValue());
            }
        }
    }
}