package org.arya.simple;

public class MaxTwoNumInArray {

    public static void main(String[] args) {

        int[] num = {5, 34, 78, 2, 45, 1, 99, 23};
        MaxTwoNumInArray tmn = new MaxTwoNumInArray();
        tmn.printTwoMaxNumbers(num);

    }

    public void printTwoMaxNumbers(int[] nums) {

        int firstMax = 0;
        int secondMax = 0;
        int thirdMax = 0;

        // or use quick sort then find element.

        for (int num : nums) {

            if (firstMax < num) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = num;
            } else if (secondMax < num) {
                thirdMax = secondMax;
                secondMax = num;
            } else if (thirdMax < num) {
                thirdMax = num;
            }

        }

        System.out.println("First Max Number: " + firstMax);
        System.out.println("Second Max Number: " + secondMax);
        System.out.println("Second Max Number: " + thirdMax);

    }

}
