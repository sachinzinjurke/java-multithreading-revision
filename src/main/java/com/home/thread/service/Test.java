package com.home.thread.service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Test {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService service = Executors.newFixedThreadPool(2);
        Runnable runnable = () -> System.out.println("I am done");

        Future<?> future = service.submit(runnable);
        System.out.println(future.get());
        System.out.println("main completed!!");

    }
}
