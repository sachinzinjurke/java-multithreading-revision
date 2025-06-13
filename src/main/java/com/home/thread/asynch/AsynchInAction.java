package com.home.thread.asynch;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class AsynchInAction {

    public static void main(String[] args) {

        Supplier<List<Long>> idSupplier = ()->{
            sleep(200);
            return Arrays.asList(1L,2L,3l);
        };

        Function<List<Long>,List<User>> fetchUsers = idList -> {
            sleep(300);
            return idList.stream().map(User::new).collect(Collectors.toList());
        };

        Consumer<List<User>> displayer = users -> users.forEach(System.out::println);

        CompletableFuture.supplyAsync(idSupplier).thenApply(fetchUsers).thenAccept(displayer);
        sleep(1000);

    }

    public static void sleep(int timeout){

        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
