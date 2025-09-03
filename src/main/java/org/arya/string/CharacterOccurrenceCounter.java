package org.arya.string;

import java.util.HashMap;
import java.util.Map;

public class CharacterOccurrenceCounter {
    // Using array (efficient for ASCII characters)
    public static void countCharsArray(String str) {
        int[] freq = new int[128];  // Assuming ASCII characters
        
        // Count frequencies
        for (char c : str.toCharArray()) {
            freq[c]++;
        }
        
        // Print non-zero counts
        /*for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {
                System.out.println((char)i + ": " + freq[i]);
            }
        }*/
        for (char c: str.toCharArray()) {
            if (freq[c] > 0) {
                System.out.println(c + ": " + freq[c]);
                freq[c] = 0; // To avoid printing duplicates
            }
        }
    }

    public static void countChars(String input) {
        Map<Character, Integer> countMap = new HashMap<>();

        for (char c : input.toCharArray()) {
            if (c != ' ') { // skip spaces if needed
                countMap.put(c, countMap.getOrDefault(c, 0) + 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            System.out.println("'" + entry.getKey() + "' → " + entry.getValue());
        }
    }


    public static void main(String[] args) {
        String str = "munim";
        System.out.println("Using array:");
        countCharsArray(str);
    }

    public static class StringReverseRecursive {

        public static void main(String[] args) {
            StringReverseRecursive obj = new StringReverseRecursive();
            String str = "Muni";
            System.out.println("Reverse of '" + str + "' is '" + obj.reverse(str) + "'");
        }

        public String reverse(String str) {
            if ((str == null) || (str.length() <= 1))
                return str;
            return reverse(str.substring(1)) + str.charAt(0);
        }

        // Here the 'reverse' method takes the first character of the String
        // str.charAt(0) puts it at the end and then calls itself, on the remainder
        // str.substring(1), and adding those things together to get the result
        // reverse(str.substring(1)) + str.charAt(0)
        //reverse("Muni")
        //(reverse("uni")) + "M"
        //((reverse("ni")) + "u") + "M"
        //(((reverse("i")) + "n") + "u") + "M"
        //(((("i") + "n") + "u") + "Q"
    }
}