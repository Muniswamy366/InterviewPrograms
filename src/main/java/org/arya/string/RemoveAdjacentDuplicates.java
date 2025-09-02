package org.arya.string;

public class RemoveAdjacentDuplicates {
    public static void main(String[] args) {
        String str = "aabbccdd";
        StringBuilder sb = new StringBuilder();
        sb.append(str.charAt(0)); // Append the first character

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(i - 1)) {
                sb.append(str.charAt(i));
            }
        }

        System.out.println("Original String: " + str);
        System.out.println("String after removing adjacent duplicates: " + sb);
    }
}
