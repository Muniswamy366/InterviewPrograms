package org.arya.simple;

import java.util.Arrays;
import java.util.List;

public class ArrayToListToArray {

	public static void main(String[] args) {

		String[] names = {"muni", "swamy", "arya", "ramesh"};
		List<String> list1 = Arrays.asList(names);
		System.out.println(list1);

		String[] strings1 = listToArrayJava8(list1);
		System.out.println(Arrays.toString(strings1));
	}

	public static String[] listToArrayJava8(List<String> list) {
		return list.stream().toArray(String[]::new);
	}

}
