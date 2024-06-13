package org.arya.simple;

public class ArmStrongNum {

    public static void main(String[] args) {

        int n = 371, sum = 0, temp = n;

        while (n > 0) {
            sum = (int) (sum + Math.pow(n % 10, 3));
            n = n / 10;
        }
        if (temp == sum) {
            System.out.println("armstrong");
        } else
            System.out.println("not");
    }

}
