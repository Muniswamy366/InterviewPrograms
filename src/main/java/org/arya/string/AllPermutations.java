package org.arya.string;

public class AllPermutations {

	public static void main(String[] args) {
		// Test cases
		System.out.println("Permutations of ABC:");
		findPermutations("ABC");

		System.out.println("\nPermutations of AAC:");
		findPermutations("AAC");

		System.out.println("\nPermutations of ABCD:");
		findPermutations("ABCD");
	}

	// Main method to generate all permutations
	public static void findPermutations(String str) {
		if (str == null || str.isEmpty()) {
			return;
		}
		generatePermutations("", str);
	}

	// Recursive helper method
	private static void generatePermutations(String prefix, String remaining) {
		if (remaining.isEmpty()) {
			System.out.println(prefix);
			return;
		}

		for (int i = 0; i < remaining.length(); i++) {
			// Take current character
			char current = remaining.charAt(i);
			// Create new prefix by adding current char
			// Create new remaining string by excluding current char
			String newRemaining = remaining.substring(0, i) +
					remaining.substring(i + 1);
			generatePermutations(prefix + current, newRemaining);
		}
	}

}