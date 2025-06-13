package com.home.thread.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class LambdaExamples {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("Sachin","Sampat","Nikhil","Pasha");
        List<String> result = new ArrayList<>();
        Consumer<String> c1 = System.out::println;
        Consumer<String> c2 = result::add;
        list.forEach(c1.andThen(c2));
        System.out.println("result size ::" + result.size());

        Predicate<String> p1 = Predicate.isEqual("Sachin");
        Predicate<String> p2 = Predicate.isEqual("Sampat");

        list.stream().filter(p1.or(p2)).forEach(System.out::println);

    }
}
