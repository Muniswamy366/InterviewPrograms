package org.arya.advance;

import java.util.Map;
import java.util.HashMap;
import java.util.Stack;

public class BalancedParenthesis {
	private static final Map<Character, Character> BRACKETS = new HashMap<>();

	static {
		BRACKETS.put('}', '{');
		BRACKETS.put(']', '[');
		BRACKETS.put(')', '(');
	}

	public static void main(String[] args) {

		System.out.println(isBalanced("{(a,b)}"));
		System.out.println(isBalanced("{(a},b)"));
		System.out.println(isBalanced("{)(a,b}"));
	}

	public static boolean isBalanced(String input) {
		if (input == null) return false;

		Stack<Character> stack = new Stack<>();

		for (char current : input.toCharArray()) {
			if (isOpenBracket(current)) {
				stack.push(current);
			} else if (isCloseBracket(current)) {
				if (stack.isEmpty() || stack.pop() != BRACKETS.get(current)) {
					return false;
				}
			}
		}

		return stack.isEmpty();
	}

	private static boolean isOpenBracket(char c) {
		return c == '{' || c == '[' || c == '(';
	}

	private static boolean isCloseBracket(char c) {
		return c == '}' || c == ']' || c == ')';
	}
}