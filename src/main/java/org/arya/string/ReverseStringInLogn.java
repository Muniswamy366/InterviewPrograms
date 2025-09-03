package org.arya.string;

public class ReverseStringInLogn {

    public static void main(String[] args) {

        String name = "abcdef";
        char[] chars = name.toCharArray();
        int n = chars.length-1;

        for (int i = 0; i < chars.length / 2; i++) {
            char ch = chars[n - i];
            chars[n - i] = chars[i];
            chars[i] = ch;
        }

        System.out.println(String.valueOf(chars));
    }
}
