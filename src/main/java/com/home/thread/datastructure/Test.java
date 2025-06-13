package com.home.thread.datastructure;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.LinkedList;

public class Test {

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();

        Instant start = Instant.now();

        for(int i=0;i < 500000;i++){
           // list.add(i);
            list.add(0,i);
        }
        Instant end =Instant.now();
        long durationInMillis = Duration.between(start, end).toMillis();
        System.out.println("Diff :: " + durationInMillis);

        LinkedList<Integer> llist = new LinkedList<>();

        Instant lstart = Instant.now();

        for(int i=0;i < 500000;i++){
            //llist.add(i);
            llist.add(i);
        }
        Instant lend =Instant.now();
        long ldurationInMillis = Duration.between(lstart, lend).toMillis();
        System.out.println("List Diff :: " + ldurationInMillis);
    }
}
