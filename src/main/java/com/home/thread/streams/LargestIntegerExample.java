package com.home.thread.streams;

import java.util.*;
import java.util.stream.Collectors;

public class LargestIntegerExample {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(4, 2, 8, 6, 10);
        Optional<Integer> first = numbers.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst();
        System.out.println(first.get());
        List<String> strings = Arrays.asList("apple", "banana", "kiwi", "orange", "pear");
        List<String> list = Arrays.asList("apple", "banana", "kiwi", "orange", "pear");
        Collections.reverse(list);
        System.out.println("Reversed list: " + list);

        String name="sachin";
        long count = name.chars().distinct().count();
        System.out.println(count);

        String name1="apple";
        long count1 = name1.chars().distinct().count();
        System.out.println(count1);
        List<String> list2 = Arrays.asList("apple", "banana", "kiwi", "orange", "pear", "strawberry", "watermelon");

        List<String> collect = list2.stream().filter(s -> s.length() != s.chars().distinct().count()).collect(Collectors.toList());
        System.out.println(collect);

        List<Integer> frequencyList = Arrays.asList(1, 2, 3, 3, 4, 4, 4, 5, 5);
        Map<Integer, Long> collect1 = frequencyList.stream().collect(Collectors.groupingBy(i -> i, Collectors.counting()));
        System.out.println(collect1);


    }
}
