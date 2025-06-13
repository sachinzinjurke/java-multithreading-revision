package com.home.thread.streams;

import java.util.Arrays;
import java.util.List;

public class BiFunctionExample {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1,2,3,4,5,6);

        Integer reduce = list.stream().reduce(0, (i1, i2) -> i1 + i2);
        System.out.println(reduce);
    }
}
