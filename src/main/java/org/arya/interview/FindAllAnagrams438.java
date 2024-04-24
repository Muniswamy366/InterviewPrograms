package org.arya.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class FindAllAnagrams438 {

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc")); // [0,6]
        System.out.println(findAnagrams("abab", "ab")); // [0,1,2]
    }
    public static boolean isAnagram(char[] s, char t[]) {
        int[] arr = new int[26];
        for (char ch : s)
            arr[ch - 97] += 1;
        for (char ch : t)
            arr[ch - 97] -= 1;
        for (int count : arr)
            if (count != 0) return false;
        return true;
    }


    /*private static boolean isAnagram(char [] char1, char [] char2) {
        Arrays.sort(char1);
        Arrays.sort(char2);
        return Arrays.equals(char1, char2);
    }*/

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> indexList = new ArrayList<>();
        if (s.length() < p.length())
            return indexList;
        char[] pStr = p.toCharArray();
        char[] sStr = s.toCharArray();
        int start = 0;
        int end = p.length();
        while (end <= s.length()) {
            // array ranges 0 3, 1 4, 2 5, 3 6, 4 7, 5 8, 6 9, 7 10
            if (isAnagram(Arrays.copyOfRange(sStr, start++, end++), pStr))
                indexList.add(start-1);
        }
        return indexList;
    }
}