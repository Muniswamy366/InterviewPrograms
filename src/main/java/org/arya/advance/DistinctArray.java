package org.arya.advance;


import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class DistinctArray {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 1, 1, 2, 2, 3, 4, 5};
        int[] temp = new int[9];


	/*	int[] result = new int[arr.length];
		int previous = arr[0];
		result[0] = previous;
		int count =0;

		for (int i = 1; i < arr.length; i++) {
			int ch = arr[i];

			if (previous != ch) {
				result[count++] = previous;
			}
			previous = ch;
		}*/

        //System.out.println(Arrays.toString(result));


        for (int i = 1; i < arr.length; i++) {
            boolean isDistinct = false;
            for (int j = i - 1; j < i; j++) {
                if (arr[i] == arr[j]) {
                    isDistinct = true;
                    break;
                }
            }
            if (!isDistinct) {
                System.out.print(arr[i - 1] + " ");
            }
        }

        System.out.println();
        System.out.println(Arrays.toString(getDistinctUsingArray(arr)));

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
