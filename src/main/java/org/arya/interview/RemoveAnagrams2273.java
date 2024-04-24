package org.arya.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class RemoveAnagrams2273 {

    // https://leetcode.com/problems/find-resultant-array-after-removing-anagrams/

    public static void main(String[] args) {
        System.out.println(removeAnagrams(new String[]{"abba","baba","bbaa","cd","cd"}));
        System.out.println(removeAnagrams(new String[]{"abba","baba","bbaa","cd","dc", "ef"}));
    }
    public static List<String> removeAnagrams(String[] words) {
        List<String> result = new ArrayList<>();
        if (words == null || words.length == 0) {
            return result;
        }
        int uniqueWordIdx = 0;
        int currIdx = 1;
        result.add(words[uniqueWordIdx]);
        while (currIdx < words.length) {
            if (!isAnagram(words[currIdx], words[uniqueWordIdx])) {
                uniqueWordIdx = currIdx;
                result.add(words[uniqueWordIdx]);
            }
            currIdx++;
        }
        return result;
    }

    /*
    Utility to check if the 2 words are anagrams or not
    */
    private static boolean isAnagram(String word1, String word2) {

        char [] char1 = word1.toCharArray();
        char [] char2 = word2.toCharArray();

        Arrays.sort(char1);
        Arrays.sort(char2);

        /*String str1 = new String(char1);
        String str2 = new String(char2);

        if(str1.equals(str2)) {
            return true;
        }
        return false;*/
        return Arrays.equals(char1, char2);
    }
}