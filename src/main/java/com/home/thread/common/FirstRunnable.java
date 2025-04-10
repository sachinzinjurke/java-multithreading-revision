package com.home.thread.common;

public class FirstRunnable {
    public static void main(String[] args) {

        Runnable runnable = ()-> System.out.println("I am running in " + Thread.currentThread().getName());
        Thread thread = new Thread(runnable);
        thread.start();
        System.out.println("Main completed");
    }
}
