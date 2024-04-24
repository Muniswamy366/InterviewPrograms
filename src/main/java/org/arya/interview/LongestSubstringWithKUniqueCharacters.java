package org.arya.interview;

import java.util.*;

// Java program to find the longest substring
// with k unique characters in a given string
public class LongestSubstringWithKUniqueCharacters {
    static String longestKSubstr(String s, int k) {

        Set<String> result = new TreeSet<>();
        int n = s.length();
        int answer = -1;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                HashSet<Character> distinct = new HashSet<>();
                for (int x = i; x < j; x++) {
                    distinct.add(s.charAt(x));
                }
                if (distinct.size() == k) {
                    answer = Math.max(answer, j - i);
                    result.add(s.substring(i, j));
                }
            }
        }

        result.stream().sorted(Comparator.comparing(String::length, Comparator.reverseOrder())).forEach(str -> System.out.print(str+", "));
        System.out.println();

        Optional<String> first = result.stream().sorted(Comparator.comparing(String::length, Comparator.reverseOrder())).findFirst();

        return first.get();
    }

    public static void main(String[] args) {

        System.out.println(longestKSubstr("aabbacbaa", 2).equals("aabba") );
        System.out.println(longestKSubstr("aabacbebebe", 3).equals("cbebebe") );
        System.out.println(longestKSubstr("aabbcbbbadef", 2).equals("bbcbbb") );

    }
}