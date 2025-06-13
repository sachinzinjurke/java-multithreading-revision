package com.home.thread.asynch;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class SupplyTest {

    public static void main(String[] args) {

        Supplier<String> supplier= ()->Thread.currentThread().getName();

        CompletableFuture<String> future = CompletableFuture.supplyAsync(supplier);
        String result = future.join();
        System.out.println(result);
    }
}
