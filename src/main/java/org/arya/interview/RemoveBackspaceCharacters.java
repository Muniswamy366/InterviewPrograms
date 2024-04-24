package org.arya.interview;

import java.util.Stack;

public class RemoveBackspaceCharacters {
    public static void main(String[] args) {
        String input = "abc#de#f#ghi#jklmn#op#";
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '#') {
                stack.pop();
            } else {
                stack.push(input.charAt(i));
            }
        }

        // convert stack to string
        StringBuilder builder = new StringBuilder(stack.size());

        for (Character c : stack) {
            builder.append(c);
        }
        System.out.println(builder);
    }
}
