package org.arya.advance;


import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class DistinctArray {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 1, 1, 2, 2, 3, 4, 5};
        int[] temp = new int[9];

        // Usage:
        int[] nums = {1, 2, 3, 2, 4, 5, 1, 6, 1, 3};
        System.out.println(removeDuplicatesSorted(nums));
        // Output: [1, 2, 3, 4, 5, 6]

    }


    public static int removeDuplicatesSorted(int[] nums) {
        Arrays.sort(nums);
        int index = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[index++] = nums[i];
            }
        }

        // Print result
        System.out.println(Arrays.toString(Arrays.copyOf(nums, index)));
        return index; // New length
    }

    public static int[] getDistinctUsingArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new int[0];
        }

        int distinctCount = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                distinctCount++;
            }
        }

        int[] result = new int[distinctCount];
        result[0] = arr[0];
        int index = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                result[index++] = arr[i];
            }
        }
        return result;
    }

    public static int[] getDistinctElements(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new int[0];
        }

        Set<Integer> distinctSet = new LinkedHashSet<>();
        for (int num : arr) {
            distinctSet.add(num);
        }

        // Convert Set to array
        int[] result = new int[distinctSet.size()];
        int index = 0;
        for (int num : distinctSet) {
            result[index++] = num;
        }
        return result;
    }
}
