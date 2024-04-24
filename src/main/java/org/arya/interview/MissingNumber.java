package org.arya.interview;

import java.util.Arrays;
import java.util.IntSummaryStatistics;

public class MissingNumber {
    public static void main(String[] args) {
        int[] input = { 1, 1, 2, 3, 5, 5, 7, 9, 9, 9 };
        //approach1(input);
        approach2();
    }

    private static void approach1(int[] input) {
        // let's create another array with same length
        // by default all index will contain zero

        int[] register = new int[input.length];

        // now let's iterate over given array to
        // mark all present numbers in our register

        for (int i : input) {
            register[i] = 1;
        }

        System.out.println("missing numbers in given array");
        for (int i = 1; i < register.length; i++) {
            if (register[i] == 0) {
                System.out.println(i);
            }
        }
    }


    private static void approach2() {
        int n;
        int[] numbers = new int[]{1,2,3,4,6,7};
        n = 7;
        int expected_num_sum = n * ((n + 1) / 2);
        int num_sum = 0;
        for (int i: numbers) {
            num_sum += i;
        }
        System.out.println( expected_num_sum - num_sum);
    }

    private static void approach3() {
        int[] numbers = new int[]{1,2,3,4,6,7};
        int n = numbers.length;
        int xor = n;

        for (int i=0;i<n;i++) {
            xor ^=numbers[i]^i;
        }
        System.out.println( xor);
    }

    private static void approach4() {
        int[] arr = new int[]{2, 3, 3, 5, 6, 8, 9}; // 1, 4, 7

        IntSummaryStatistics statistics = Arrays.stream(arr).summaryStatistics();
        int maxNum = statistics.getMax() + 1;

        int[] temp = new int[maxNum];

        for (Integer num : arr) {
            temp[num] = 1;
        }

        for (int i = statistics.getMin(); i < maxNum; i++) {
            if (temp[i] == 0) {
                System.out.println(i);
            }
        }
    }
}
