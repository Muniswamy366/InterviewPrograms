package org.arya.string;

import java.util.Stack;

public class StringReverse {

	public static void main(String[] args) {

		System.out.println("Reverse String in Java using StringBuffer: " + reverse("muni"));
		System.out.println("Reverse String in Java using StringBuffer: " + reverse("arya"));

	}

	public static String reverse(String str) {
		StringBuilder strBuilder = new StringBuilder();
		char[] strChars = str.toCharArray();

		for (int i = strChars.length - 1; i >= 0; i--) {
			strBuilder.append(strChars[i]);
		}

		return strBuilder.toString();
	}

	public static String reverseWithStack(String str) {
		Stack<Character> stack = new Stack<>();
		StringBuilder stringBuilder = new StringBuilder();

		for (int i = 0; i < str.length(); i++)
			stack.push(str.charAt(i));

		for (int j = 0; j < str.length(); j++) {
			char ch = stack.pop();
			stringBuilder.append(ch);
		}
		return stringBuilder.toString();
	}

	// METHOD 1: StringBuilder.reverse() - BEST APPROACH (Most Efficient)
	public static String reverseUsingStringBuilder(String str) {
		if (str == null || str.isEmpty()) {
			return str;
		}
		return new StringBuilder(str).reverse().toString();
	}

	// METHOD 2: Two Pointer Approach - Second Best (In-place style)
	public static String reverseUsingTwoPointers(String str) {
		if (str == null || str.isEmpty()) {
			return str;
		}

		char[] charArray = str.toCharArray();
		int left = 0;
		int right = charArray.length - 1;

		while (left < right) {
			// Swap characters
			char temp = charArray[left];
			charArray[left] = charArray[right];
			charArray[right] = temp;

			left++;
			right--;
		}

		return new String(charArray);
	}


}
