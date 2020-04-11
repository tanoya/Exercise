package com.toy.threadpool;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {
    private static ExecutorService threadPool = null;
    static {
        threadPool = Executors.newFixedThreadPool(10);
    }

    public static void main(String[] args){
        System.out.println("hello,world!");

        for (int i = 0; i < 10; i++) {
            threadPool.submit(new Runnable() {
                public void run() {
                    System.out.println(" thread1 : " + Thread.currentThread().getName());
                }
            });
        }
        try {
            Thread.sleep(1000 * 1);
        } catch (Exception e) {

        }
        System.out.println("hello, end!");

    }
}
