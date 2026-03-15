package org.arya.advance;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class ValueComparator2<K, V extends Comparable<V>> implements Comparator<K> {

	Map<K, V> map = new HashMap<>();

	public ValueComparator2(HashMap<K, V> map) {
		this.map.putAll(map);
	}

	@Override
	public int compare(K s1, K s2) {
		return map.get(s1).compareTo(map.get(s2));
	}
}

class KeyComparator2<K, V extends Comparable<V>> implements Comparator<K> {

	Map<K, V> map = new HashMap<>();

	public KeyComparator2(HashMap<K, V> map) {
		this.map.putAll(map);
	}

	@Override
	public int compare(K s1, K s2) {
		return s1.toString().compareTo(s2.toString());
	}
}

public class MapSortUsingTreeMap {

	public static void main(String[] args) {

		// <String, Integer> Map
		HashMap<String, Integer> map = new HashMap<>();
		map.put("a", 10);
		map.put("b", 30);
		map.put("c", 50);
		map.put("d", 40);
		map.put("e", 20);
		System.out.println("Unsorted map: ");
		System.out.println(map);

		Comparator<String> valueComparator = new ValueComparator2<>(map);
		TreeMap<String, Integer> sortByValue = new TreeMap<>(valueComparator);
		sortByValue.putAll(map);

		System.out.println("Sort bye value: ");
		System.out.println(sortByValue);

		Comparator<String> keyComparator = new KeyComparator2<>(map);
		TreeMap<String, Integer> sortByKey = new TreeMap<>();
		sortByKey.putAll(map);

		System.out.println("Sort bye key: ");
		System.out.println(sortByKey);


	}
}
