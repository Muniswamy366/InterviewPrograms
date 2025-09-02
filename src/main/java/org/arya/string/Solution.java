package org.arya.string;

import java.util.*;

public class Solution {
    public String longestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int maxLen = 0;
        int startIndex = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            if (map.containsKey(c) && map.get(c) >= left) {
                left = map.get(c) + 1;
            }

            map.put(c, right);

            if (right - left + 1 > maxLen) {
                maxLen = right - left + 1;
                startIndex = left;
            }
        }

        return s.substring(startIndex, startIndex + maxLen);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String input = "abcabcbb";
        String result = sol.longestSubstring(input);
        System.out.println("Longest substring: " + result);
    }
}
