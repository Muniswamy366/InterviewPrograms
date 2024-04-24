package org.arya.advance;

public class CountDuplicateNumArray {

    public CountDuplicateNumArray() {
    }

    public static void main(String[] args) {

        int[] values = {2, 4, 2, 6, 4, 4};
        int[] temp = new int[128];
        int max = 0;

        for (int value : values) {
            temp[value] = ++temp[value];
            if (max < temp[value])
                max = temp[value];
        }

        for (int value : values) {
            if (temp[value] == max)
                System.out.println(value + " is repeted " + temp[value] + " times.");
        }

    }

}
