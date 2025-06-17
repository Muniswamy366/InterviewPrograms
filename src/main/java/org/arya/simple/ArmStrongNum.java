package org.arya.simple;

public class ArmStrongNum {

    public static void main(String[] args) {

        int number = 371, armstrongSum = 0, originalNumber = number;

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
