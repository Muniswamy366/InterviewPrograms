package org.arya.string;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatedCharInString {

    public static void main(String[] args) {
        String[] testCases = {"mumnin", "programming", "aabbcc", "swiss"};
        
        for (String test : testCases) {
            System.out.println("\"" + test + "\" -> " + findFirstNonRepeating(test));
        }
    }

    // Optimized: Best for ASCII strings - O(n) time, O(1) space
    public static Character findFirstNonRepeating(String str) {
        if (str == null || str.isEmpty()) return null;
        
        int[] freq = new int[128];

        for (char c : str.toCharArray()) {
            freq[c]++;
        }

        for (char c : str.toCharArray()) {
            if (freq[c] == 1) {
                return c;
            }
        }

        return null;
    }

    // Alternative: Best for Unicode strings - O(n) time, O(k) space
    public static Character getFirstNonRepeatedChar(String str) {
        if (str == null || str.isEmpty()) return null;
        
        Map<Character, Integer> counts = new LinkedHashMap<>();

        for (char c : str.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : counts.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return null;
    }

}
