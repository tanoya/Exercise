package com.toy.thread;

public class Application {


    public static void main(String[] args) {

        final SortTransaction transaction = new SortTransaction();

        new Thread(new Runnable() {
            public void run() {
                transaction.printC();
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                transaction.printA();
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                transaction.printB();
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                transaction.init();
            }
        }).start();
    }

}
