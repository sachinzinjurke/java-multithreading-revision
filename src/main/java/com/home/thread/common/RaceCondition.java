package com.home.thread.common;

public class RaceCondition {
    public static void main(String[] args) throws InterruptedException {
        LongWrapper wrapper =  new LongWrapper(0L);

        Runnable runnable = () ->{
            for (int i=0; i<1000;i++){
                wrapper.incrementValue();
            }
        };

        Thread[] threads = new Thread[1000];
        for (int i=0;i<threads.length;i++) {
            threads[i] = new Thread(runnable);
            threads[i].start();
        }
        System.out.println("Completed array :: " +threads.length);
        int count=0;
        for (int i=0;i<threads.length;i++) {
                count++;
                threads[i].join();
            }
        System.out.println("Non null count:: "+ count);
        System.out.println("Final Value : " + wrapper.getValue());
    }
}
