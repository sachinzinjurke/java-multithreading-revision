package com.home.thread.common;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerWithLoack {

    public static void main(String[] args) {

        Lock lock = new ReentrantLock();
        Condition isFull = lock.newCondition();
        Condition isEmpty = lock.newCondition();
        List<Integer> buffer = new ArrayList<>();
         class Producer implements Callable<String> {
            @Override
            public String call() throws Exception {
                int count=0;
                try{
                    while(count++ < 50){
                        lock.lock();
                        while(isFull(buffer)){
                            //park the thread
                            System.out.println("Buffer is full ..waiting to be signed by consumer");
                            isFull.await();
                        }
                        buffer.add(1);
                        isEmpty.signalAll();
                    }
                }finally {
                    lock.unlock();
                }

                return "Producer thread " + Thread.currentThread().getName() + " elements:: " +buffer.size();
            }

             private boolean isFull(List<Integer> buffer) {
                return buffer.size()==50;
             }
         }
        class Consumer implements Callable<String>{
            @Override
            public String call() throws Exception {
                int count=0;
                try{
                    while(count++ < 50){
                        lock.lock();
                        while(isEmpty(buffer)){
                            //park the thread
                            System.out.println("Buffer is empty ..waiting to be signed by producer");
                            isEmpty.await();
                        }
                        buffer.remove(buffer.size()-1);
                        isFull.signalAll();
                    }
                }finally {
                    lock.unlock();
                }
                return "Consumer thread " + Thread.currentThread().getName() + " elements:: " +buffer.size();
            }
            private boolean isEmpty(List<Integer> buffer) {
                return buffer.size()==0;
            }
        }

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        List<Callable<String>>producerList = new ArrayList<>();
        List<Callable<String>>consumerList = new ArrayList<>();
        List<Callable<String>>combinedList = new ArrayList<>();
        List<Future<String>> futures=new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            producerList.add(new Producer());
        }
        for (int i = 0; i < 2; i++) {
            consumerList.add(new Consumer());
        }
        combinedList.addAll(producerList);
        combinedList.addAll(consumerList);

        try {
            futures = executorService.invokeAll(combinedList);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for (Future<String> future:futures) {

            try {
                future.get();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
        executorService.shutdown();
    }
}
