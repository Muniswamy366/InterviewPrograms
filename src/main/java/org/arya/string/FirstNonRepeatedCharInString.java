package org.arya.string;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class FirstNonRepeatedCharInString {

	public static void main(String[] args) {

		System.out.println(getFirstNonRepeatedChar("mumnin"));

	}

	public static char getFirstNonRepeatedChar(String str) {
		Map<Character, Integer> counts = new LinkedHashMap<>();

		for (char c : str.toCharArray()) {
			counts.put(c, counts.getOrDefault(c, 0) + 1);
		}

		for (var entry : counts.entrySet()) {
			if (entry.getValue() == 1) {
				return entry.getKey();
			}
		}

		throw new RuntimeException("No non-repeated character found");
	}

}
