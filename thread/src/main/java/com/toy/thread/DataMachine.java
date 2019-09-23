package com.toy.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DataMachine {

    public static int Mark = 0;

    public static List<String> DATA = null;

    volatile List<String> result = DATA;

    public java.util.concurrent.locks.Lock Lock = new ReentrantLock();

//    public List<String> pullData(){
//
//        if (DATA != null) {
//            return DATA;
//        }
//
//        if (DATA == null || DATA.size() == 0) {
//            DATA = getDataFromDatabase();
//        }
//        return DATA;
//    }
//
//    private synchronized List<String> getDataFromDatabase(){
//        try {
//            if (DATA == null || DATA.size() == 0) {
//                for (long counter = 0; counter < 50000000L; counter++) {
//                    // 进来的线程睡眠500ms
//                }
//
//                if (DATA == null) {
//                    DATA = new ArrayList<String>();
//                    DATA.add("HELLO");
//                    DATA.add("world");
//                    DATA.add("HELLO");
//                    DATA.add("world");
//                    DATA.add("HELLO");
//                }
//                System.out.println(Thread.currentThread().getName());
//            }
//        } catch (Exception e) {
//            // todo nothing
//        }
//        return DATA;
//    }


    public List<String> pullData(){

        result = DATA;

        if (result != null) {
            return result;
        }

        if (result == null || result.size() == 0) {
            try {
                synchronized (this) {
                    if (result == null || result.size() == 0) {
                        for (long counter = 0; counter < 50000000L; counter++) {
                            // 进来的线程睡眠500ms
                        }

                        if (DATA == null) {
                            DATA = new ArrayList<String>();
                            DATA.add("HELLO");
                            DATA.add("world");
                            DATA.add("HELLO");
                            DATA.add("world");
                            DATA.add("HELLO");
                        }
                        System.out.println(Thread.currentThread().getName());
                    }
                }
            } catch (Exception e) {
                // todo nothing
            }
        }
        return DATA;
    }
}