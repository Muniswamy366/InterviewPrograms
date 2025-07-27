package org.arya.array;

import java.util.ArrayList;
import java.util.List;

public class RepeatedNumbers {

    public static List<Integer> findRepeatedNumbers(int[] arr) {
        List<Integer> duplicates = new ArrayList<>();
        int n = arr.length;

        // Check each element and mark its presence
        for (int i = 0; i < n; i++) {
            int num = Math.abs(arr[i]);
            if (num <= n) {  // Only process numbers within array bounds
                if (arr[num - 1] > 0) {
                    arr[num - 1] = -arr[num - 1];
                } else {
                    duplicates.add(num);
                }
            }
        }

        // Restore array to original state
        for (int i = 0; i < n; i++) {
            arr[i] = Math.abs(arr[i]);
        }

        return duplicates;
    }

    public static List<Integer> findRepeatedNumbersUsingMax1(int[] arr) {
        List<Integer> duplicates = new ArrayList<>();
        int[] count = new int[arr.length + 1];

        // Count frequency of each number
        for (int num : arr) {
            if (num <= arr.length) {
                count[num]++;
                if (count[num] == 2) {
                    duplicates.add(num);
                }
            }
        }

        return duplicates;
    }

    public static List<Integer> findRepeatedNumbersUsingMax2(int[] arr) {
        List<Integer> duplicates = new ArrayList<>();
        int max = findMax(arr);
        int[] count = new int[max + 1];

        for (int num : arr) {
            count[num]++;
            if (count[num] == 2) {
                duplicates.add(num);
            }
        }

        return duplicates;
    }

    private static int findMax(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 7, 8, 2, 3};
        System.out.println("Repeated numbers: " + findRepeatedNumbersUsingMax1(arr));
    }
}