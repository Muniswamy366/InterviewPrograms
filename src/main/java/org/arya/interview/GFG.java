package org.arya.interview;// Java code for the above approach

import java.io.*;
import java.util.*;

class GFG {

    // lowerBound implementation
    public static int lowerBound(int[] arr, int start,
                                 int end, int key) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] < key) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    // upperBound implementation
    public static int upperBound(int[] arr, int start,
                                 int end, int key) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] <= key) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    // Function to find the count of pairs
    public static int getPairsCount(int[] arr, int n, int k) {
        Arrays.sort(arr);
        int c = 0;
        for (int i = 0; i < n - 1; i++) {
            int x = k - arr[i];
            int y = lowerBound(arr, i + 1, n, x);
            int z = upperBound(arr, i + 1, n, x);
            c = c + z - y;
        }
        return c;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int n = arr.length;
        int k = 4;

        // Function call
        System.out.println("Count of pairs is " + getPairsCount(arr, n, k));
    }
}

// This code is contributed by lokeshmvs21.
