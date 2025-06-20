package org.arya.simple;

public class SubArrayWhoseSumIsNumber {

    public static void main(String[] args) {

        int[] arr = new int[]{11, 7, -2, 4, 6, 65, 99};
        int num = 8;
        int sum = arr[0];
        int start = 0;

        for (int i = 1; i < arr.length; i++) {
            sum = sum + arr[i];

            if (sum > num) {
                sum = sum - arr[start++];
            }

            /*while (sum > num) {
                sum -= arr[start++];
            }*/

            if (sum == num) {
                // Print the sum and the indices of the subarray
                System.out.println("Subarray with Number " + num + " found from index " + start + " to " + i);
            }
        }

    }
}
