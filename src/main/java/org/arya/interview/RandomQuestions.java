package org.arya.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomQuestions {

    public static void main(String[] args) {

        // 1
        Integer arr1[] = new Integer[]{1, 14, 23, 51, 55, 91, 99};
        Integer arr2[] = new Integer[]{0, 3, 10, 19, 22, 35, 45, 60, 71, 90, 100};

        List<Integer> list1 = Arrays.asList(arr1);
        List<Integer> list2 = Arrays.asList(arr2);

        List<Integer> collect = Stream.of(list1, list2).flatMap(list -> list.stream()).sorted().collect(Collectors.toList());
        System.out.println(collect);

        // 2
        // find sum of largest 2 numbers using Stream.limit(); method
        int sum = list1.stream()
                .sorted(Comparator.reverseOrder())
                .limit(2)
                .reduce(0, Integer::sum);
        System.out.println(sum);

        // 3
        List<String> names = new ArrayList<>();
        names.add("Deepinder Goyal");
        names.add("Vinay Sanghi");
        names.add("Bipin Preet Singh");
        names.add("Vijay Shekhar Sharma");
        names.add("Falguni Nayar");

        // findFirst() - find First element in ArrayList
        String first = names.stream().findFirst().get();

        // reduce() - find Last element in ArrayList
        String last = names.stream().reduce((one, two) -> two).get();

        // print to console
        System.out.println("First name in the List is = " + first);
        System.out.println("Last name in the List is = " + last);

        // 4 find max salary
        List<Employee> list = Arrays.asList(new Employee(1, "a", 100),
                new Employee(2, "b", 200),
                new Employee(3, "c", 300));
        Employee employee = list.stream().max(Comparator.comparing(Employee::getSalary)).get();
        System.out.println(employee);

        // 5 find max salary
        employee = list.stream().sorted(Comparator.comparing(Employee::getSalary, Comparator.reverseOrder())).skip(1).findFirst().get();
        System.out.println(employee);

        // 6 get all employees from one department
        List<Employee> list3 = Arrays.asList(new Employee(1, "a", 100),
                new Employee(2, "b", 200),
                new Employee(3, "c", 300));

        List<Employee> list4 = Arrays.asList(new Employee(4, "d", 400),
                new Employee(5, "e", 500),
                new Employee(6, "f", 600));

        List<Department> departments = Arrays.asList(new Department(1, "dept1", list3),
                new Department(2, "dept2", list4));
        List<Employee> collect1 = departments.stream().filter(dept -> "dept2".equals(dept.getName())).flatMap(dept -> dept.getEmployees().stream()).collect(Collectors.toList());
        System.out.println(collect1);

        // 7
        //From the given input string array, write a program in Java 8 streams api to convert them as Integer list in sorted order.
        // input : ["1","3","4","2", "5", "11"]
        // output : [1,2,3,4,5,11]
        // input : ["1","3","7abc","4","2","xyz8", "5"]
        // output : [1,2,3,4,5]

        //List<String> strings = Arrays.asList("1", "3", "4", "2", "5", "11");
        List<String> strings = Arrays.asList("", "0", "1", "3", "7abc", "4", "2", "xyz8", "5");

        List<Integer> collect2 = strings.stream().map(string -> {
            try {
                return Integer.parseInt(string);
            } catch (NumberFormatException e) {
                return null;
            }
        }).filter(num -> num != null).sorted().collect(Collectors.toList());
        System.out.println(collect2);

    }
}
