package org.arya.string;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class RemoveDuplicates {

    public static String removeDuplicates1(String str) {
        Set<Character> seen = new LinkedHashSet<>();
        for (char c : str.toCharArray()) {
            seen.add(c);
        }

        StringBuilder sb = new StringBuilder();
        for (char c : seen) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static String removeDuplicates2(String str) {
        Set<Character> seen = new LinkedHashSet<>();
        StringBuilder sb = new StringBuilder();

        for (char c : str.toCharArray()) {
            if(seen.add(c)){
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static String removeDuplicatesStream(String s) {
        return s.chars()
                .distinct()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
    }

    public static String removeDuplicatesAscii(String s) {
        //boolean[] seen = new boolean[256];     // good if you know input is ASCII
        boolean[] seen = new boolean[128];
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (!seen[c]) {
                sb.append(c);
                seen[c] = true;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String input = "programming";
        System.out.println(removeDuplicatesStream(input));  // Output: progamin
    }
}
