package com.home.thread.semaphores;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

enum Downloader{
    INSTANCE;
    private Semaphore semaphore = new Semaphore(3,true);

    public void download() throws InterruptedException {
       try{
           semaphore.acquire();
           downloadData();
       }finally {
           semaphore.release();
       }


    }

    private void downloadData() throws InterruptedException {
        System.out.println("Downloading data");
        Thread.sleep(3000);
    }
}
public class SemaphoreExample {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(12);
        for (int i=0; i <12;i++){
            service.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        Downloader.INSTANCE.download();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            });

        }
        service.shutdown();
    }

}
