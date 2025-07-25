package org.arya.advance;

import java.util.Arrays;
import java.util.HashSet;

public class RemoveDuplicatesArray {

    static void removeDuplicates(int[] arrayWithDuplicates) {
        System.out.println("Array With Duplicates : ");

        for (int i = 0; i < arrayWithDuplicates.length; i++) {
            System.out.print(arrayWithDuplicates[i] + "\t");
        }

        // Assuming all elements in input array are unique

        int noOfUniqueElements = arrayWithDuplicates.length;

        // Comparing each element with all other elements

        for (int i = 0; i < noOfUniqueElements; i++) {
            for (int j = i + 1; j < noOfUniqueElements; j++) {
                // If any two elements are found equal

                if (arrayWithDuplicates[i] == arrayWithDuplicates[j]) {
                    // Replace duplicate element with last unique element

                    arrayWithDuplicates[j] = arrayWithDuplicates[noOfUniqueElements - 1];

                    // Decrementing noOfUniqueElements

                    noOfUniqueElements--;

                    // Decrementing j

                    j--;
                }
            }
        }

        // Copying only unique elements of arrayWithDuplicates into
        // arrayWithoutDuplicates

        int[] arrayWithoutDuplicates = Arrays.copyOf(arrayWithDuplicates, noOfUniqueElements);

        // Printing arrayWithoutDuplicates

        System.out.println();

        System.out.println("Array Without Duplicates : ");

        for (int i = 0; i < arrayWithoutDuplicates.length; i++) {
            System.out.print(arrayWithoutDuplicates[i] + "\t");
        }

        System.out.println();

        System.out.println("==============================");
    }

    public static void main(String[] args) {

        removeDuplicates(new int[]{4, 3, 2, 4, 9, 2});

        removeDuplicates(new int[]{1, 2, 1, 2, 1, 2});

        removeDuplicates(new int[]{15, 21, 11, 21, 51, 21, 11});

        removeDuplicates(new int[]{7, 3, 21, 7, 34, 18, 3, 21});

    }

    public static void removeDuplicatesUsingSet(int[] array) {
        System.out.println("Original Array: " + Arrays.toString(array));

        // Use HashSet to store unique elements
        HashSet<Integer> set = new HashSet<>();
        for (int num : array) {
            set.add(num);
        }

        // Convert set back to array
        int[] uniqueArray = new int[set.size()];
        int index = 0;
        for (int num : set) {
            uniqueArray[index++] = num;
        }

        System.out.println("Array Without Duplicates: " + Arrays.toString(uniqueArray));
        System.out.println("==============================");
    }

    public static int[] removeDuplicatesUsingSort(int[] array) {
        // First sort the array
        Arrays.sort(array);

        // Edge cases
        if (array.length <= 1) return array;

        // Use two pointers: i for placing unique elements, j for scanning array
        int i = 0;
        for (int j = 1; j < array.length; j++) {
            if (array[j] != array[i]) {
                i++;
                array[i] = array[j];
            }
        }

        // Create new array with only unique elements
        return Arrays.copyOf(array, i + 1);
    }
}
