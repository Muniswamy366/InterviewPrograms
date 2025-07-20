package org.arya.string;

import java.util.Arrays;

public class StringAnagram {

    public static void main(String[] args) {
        System.out.println(isPermutationBest("word", "wrdo"));
    }

    public static boolean isAnagramBest(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        int[] counts = new int[256]; // ASCII

        for (int i = 0; i < s1.length(); i++) {
            counts[s1.charAt(i)]++;
            counts[s2.charAt(i)]--;
        }

        for (int count : counts) {
            if (count != 0) return false;
        }

        return true;
    }

    public static boolean isAnagram(String word, String anagram) {
        char[] charFromWord = word.toCharArray();
        char[] charFromAnagram = anagram.toCharArray();
        Arrays.sort(charFromWord);
        Arrays.sort(charFromAnagram);

        return Arrays.equals(charFromWord, charFromAnagram);
    }

    public static boolean checkAnagram(String first, String second) {

        char[] characters = first.toCharArray();
        StringBuilder sbSecond = new StringBuilder(second);

        for (char ch : characters) {
            int index = sbSecond.indexOf("" + ch);
            if (index != -1) {
                sbSecond.deleteCharAt(index);
            } else {
                return false;
            }
        }

        return sbSecond.isEmpty();
    }


    // Approach 1: Using character counting (most efficient)
    // This is best approach.
    public static boolean isPermutationBest(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int[] charCount = new int[128]; // Assuming ASCeII

        // Count characters in first string
        for (char c : s1.toCharArray()) {
            charCount[c]++;
        }

        // Verify with second string
        for (char c : s2.toCharArray()) {
            charCount[c]--;
            if (charCount[c] < 0) {
                return false;
            }
        }
        return true;
    }

    // Approach 2: Using sorting
    public static boolean isPermutationBySorting(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();

        Arrays.sort(str1);
        Arrays.sort(str2);

        return Arrays.equals(str1, str2);
    }
}
