package com.home.thread.asynch;

import java.util.concurrent.CompletableFuture;

public class CompletionTest {

    public static void main(String[] args) {
        CompletableFuture<Void> cf = new CompletableFuture<>();

        Runnable task= ()-> {

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            cf.complete(null);

        };

        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(task);
        voidCompletableFuture.join();
        System.out.println("void complted also");
        cf.join();
        System.out.println("We are done");
    }
}
