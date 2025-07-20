package org.arya.advance;

import java.util.Arrays;

public class PermutationExp {

	public static void main(String[] args) {
		// Test cases
		System.out.println(isPermutation("abc", "cba")); // true
		System.out.println(isPermutation("hello", "lloeh")); // true
		System.out.println(isPermutation("hello", "world")); // false
		System.out.println(isPermutation("", "")); // true
		System.out.println(isPermutation("test", "tset")); // true
		System.out.println(isPermutation("test", "sets")); // false
	}

	// Approach 1: Using character counting (most efficient)
	public static boolean isPermutation(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}

		int[] charCount = new int[128]; // Assuming ASCII

		// Count characters in first string
		for (char c : s1.toCharArray()) {
			charCount[c]++;
		}

		// Verify with second string
		for (char c : s2.toCharArray()) {
			charCount[c]--;
			if (charCount[c] < 0) {
				return false;
			}
		}
		return true;
	}

	// Approach 2: Using sorting
	public static boolean isPermutationBySorting(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}

		char[] str1 = s1.toCharArray();
		char[] str2 = s2.toCharArray();

		Arrays.sort(str1);
		Arrays.sort(str2);

		return Arrays.equals(str1, str2);
	}

}