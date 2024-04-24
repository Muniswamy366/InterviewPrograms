package org.arya.interview;

import java.util.ArrayList;
import java.util.List;

public class FindAllPalindrome647 {
    public static void main(String[] args) {
        //String input = "abaab"; // "aba" , "aa" , "baab"
        String input = "abbaeae"; // "bb" , "abba" ,"aea","eae"
        List<String> list = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            StringBuilder subStr = new StringBuilder();
            for (int j = i; j < input.length(); j++) {
                subStr.append(input.charAt(j));
                if(subStr.length()>=2 && isPalindrome(subStr.toString())) {
                    list.add(subStr.toString());
                }
            }
        }
        System.out.println(list);
    }

    private static boolean isPalindrome(String subStr) {
        StringBuilder revStr = new StringBuilder();
        for (int i = subStr.length()-1; i >=0 ; i--) {
            revStr.append(subStr.charAt(i));
        }
        return subStr.equals(revStr.toString());
    }
}
