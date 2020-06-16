package com.toy.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class Application {


//    public static void main(String[] args) {
//
//        final SortTransaction transaction = new SortTransaction();
//
//        new Thread(new Runnable() {
//            public void run() {
//                transaction.printC();
//            }
//        }).start();
//
//        new Thread(new Runnable() {
//            public void run() {
//                transaction.printA();
//            }
//        }).start();
//
//        new Thread(new Runnable() {
//            public void run() {
//                transaction.printB();
//            }
//        }).start();
//
//        new Thread(new Runnable() {
//            public void run() {
//                transaction.init();
//            }
//        }).start();
//    }


    // 自己实现线程池？
    public static void main(String[] args){
        final Application a = new Application();
        final AtomicInteger ai = new AtomicInteger();
        for(int i=0; i<100; i++){
            Thread t = new Thread(){
                @Override
                public void run(){
                    ai.incrementAndGet();
                }
            };
            t.start();
            try{
                t.join();
            }catch (Exception e){

            }
        }
        System.out.println(ai.get());
    }
}
