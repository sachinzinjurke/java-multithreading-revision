package com.home.thread.common;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Locking {



    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();
        Runnable runnable = ()->{
            try {
                if(lock.tryLock(300, TimeUnit.MILLISECONDS)){
                    System.out.println("I got the ::" +Thread.currentThread().getName());
                    try {
                        System.out.println("Sleeping");
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }else{
                    System.out.println("I did not get the hold on lock " +Thread.currentThread().getName());
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }finally {
                lock.unlock();
            }

        };

        ExecutorService service = Executors.newFixedThreadPool(3);
        service.execute(runnable);
        Thread.sleep(50);
        service.execute(runnable);
        service.shutdown();

    }
}
