package org.arya.string;

import java.util.*;

public class LongestUniqueSubstring {

    public static String longestSubstring(String s) {
        int start = 0, maxLen = 0, maxStart = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int end = 0; end < s.length(); end++) {
            char current = s.charAt(end);

            if (map.containsKey(current) && map.get(current) >= start) {
                start = map.get(current) + 1;
            }

            map.put(current, end);

            if (end - start + 1 > maxLen) {
                maxLen = end - start + 1;
                maxStart = start;
            }
        }

        return s.substring(maxStart, maxStart + maxLen);
    }

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            if (set.contains(s.charAt(right))) {
                set.remove(s.charAt(right));
            }else {
                set.add(s.charAt(right));
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String input = "abcabcbb";
        System.out.println("Longest Unique Substring: " + lengthOfLongestSubstring(input));  // Output: abc
    }
}
