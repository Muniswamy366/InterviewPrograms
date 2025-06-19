package org.arya.simple;

/**
 * The PerfectNum class provides a method to check if a given number is a perfect number.
 * A perfect number is a positive integer that is equal to the sum of its proper divisors.
 */
public class PerfectNum {

    public static void main(String[] args) {
        int num = 6;
        int sum = 0;

        // Check if the number is less than 1
        if (num < 1) {
            System.out.println(num + " is not a perfect number");
            return;
        }

        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
                sum = sum + i;
            }
        }

        if (sum == num) {
            System.out.println(num + " is a perfect number");
        }
        else {
            System.out.println(num + " is not a perfect number");
        }

    }

}
