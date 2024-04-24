package org.arya.interview;

import java.util.HashMap;
import java.util.Map;

// https://www.youtube.com/watch?v=-0P9julJV8c
// https://www.youtube.com/watch?v=AmlVSNBHzJg
public class SubArraySumEqualsK560 {
    public static void main(String[] args) {
        approach1();
        approach2();
    }

    private static void approach1() {
        int arr[] = new int[]{1,2,3,7,5}; // 1, 3 // 3, 4
        int num = 12;

        for (int i = 0; i < arr.length; i++) {
            int sum = arr[i];
            for (int j = i+1; j < arr.length; j++) {
                sum = sum + arr[j];
                if (sum == num) {
                    System.out.println(i +" "+j);
                }
            }
        }
    }

    private static void approach2() {
        int[] arr = new int[]{4, 1, 6, 2, 1, 1, 1, 9};
        int k = 5;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum - k)) {
                //count += map.get(sum - k); or
                count++;
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        System.out.println(count);
    }
}
