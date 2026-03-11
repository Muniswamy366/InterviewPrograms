package org.arya.simple;

public class ArmStrongNum {

    // number that equals the sum of its digits each raised to the power of the number of digits.
    // 153 = 1³ + 5³ + 3³ = 1 + 125 + 27 = 153 ✓

    public static void main(String[] args) {

        int number = 153, armstrongSum = 0, originalNumber = number;

        while (number > 0) {
            armstrongSum = (int) (armstrongSum + Math.pow(number % 10, 3));
            number = number / 10;
        }
        if (originalNumber == armstrongSum) {
            System.out.println(originalNumber + " is an Armstrong number");
        } else {
            System.out.println(originalNumber + " is not an Armstrong number");
        }
    }

}
