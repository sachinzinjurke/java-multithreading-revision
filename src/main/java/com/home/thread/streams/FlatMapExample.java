package com.home.thread.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapExample {

    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1,2,3,4,5);
        List<Integer> list2 = Arrays.asList(6,7,8);
        List<Integer> list3 = Arrays.asList(9,10,11);
        List<List<Integer>> list = Arrays.asList(list1,list2,list3);

        Function<List<Integer>,Integer> mapper = List::size;
        Function<List<Integer>, Stream<Integer>> flatMapper = l->l.stream();

        list.stream()
                //.map(mapper)
                .map(flatMapper)
                //.flatMap(flatMapper)
                .forEach(System.out::println);

    //
        String line = "My Name is Sachin and I am big data developer";
        Function<String,char[]> strFunction= s -> s.toCharArray();
       // Function<char[],Stream<Character>> strFlatMapFunction= c -> Arrays.stream(c.length);

        Arrays.stream(line.split(" "))
                .map(strFunction)
                .peek(System.out::println)
                .forEach(System.out::println);

       /* String word = "My Name is Sachin";
        List<Character> characters = Arrays.stream(word.split(""))
                .map(s -> s.charAt(0))
                .collect(Collectors.toList());
        System.out.println(characters);
        System.out.println("Again");

        Arrays.stream(word.split(""))
                .map(s -> s.charAt(0))
                .forEach(System.out::println);
*/
    }

}
