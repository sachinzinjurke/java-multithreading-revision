package com.home.thread.asynch;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(1);

      //  CompletableFuture.runAsync(()-> System.out.println(Thread.currentThread().getName() + "I am running aysnch"),executorService);
        Runnable task= ()-> System.out.println("Running in aysnch " + Thread.currentThread().getName());
        CompletableFuture.runAsync(task,executorService);
        //Thread.sleep(100);
        executorService.shutdown();
    }
}
