package org.arya.simple;

/**
 * A simple program to check if a given integer is a palindrome.
 * Negative numbers are not considered palindromes.
 */
public class NumberPalindrome {

    public static void main(String[] args) {

        int inputNumber = 121;

        long reversedNum = reverse(inputNumber);

        if (reversedNum == -1) {
            System.out.println("Negative numbers are not considered palindromes");
        } else if (reversedNum == inputNumber) {
            System.out.println("palindrome");
        } else {
            System.out.println("not palindrome");
        }
    }

    /**
     * Reverses the digits of the given integer.
     * If the input number is negative, returns -1.
     *
     * @param number the integer to reverse
     * @return the reversed number, or -1 if input is negative
     */
    private static long reverse(int number) {
        if (number < 0) {
            return -1;
        }
        long reverse = 0;

        while (number != 0) {
            reverse = reverse * 10 + number % 10;
            number = number / 10;
        }

        return reverse;
    }

}
