package org.arya.interview;

import java.util.HashMap;
import java.util.Map;

public class FindMissingRepeating {

    public static void main(String[] args) {

        int[] arr = {4, 3, 6, 2, 1, 1};
        int max = arr.length;

        Map<Integer, Boolean> numberMap = new HashMap<>();

        for (Integer i : arr) {
            if (numberMap.get(i) == null) {
                numberMap.put(i, true);
            } else {
                System.out.println("Repeating = " + i);
            }
        }

        for (int i = 1; i <= max; i++) {
            if (numberMap.get(i) == null) {
                System.out.println("Missing = " + i);
            }
        }

    }
}
