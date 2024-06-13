package org.arya.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class StringToIntException {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.stream(new String[]{"-1", "a", "3", "4", "5"})
                .map(StringToIntException::convertStringToInt).filter(Objects::nonNull).collect(Collectors.toList());

        System.out.println(integerList);
    }

    private static Integer convertStringToInt(String s) {
        int num;
        try {
            num = Integer.parseInt(s);
            if(num < 0){
                return null;
            }
        } catch (NumberFormatException e) {
            return null;
        }
        return num;
    }
}
