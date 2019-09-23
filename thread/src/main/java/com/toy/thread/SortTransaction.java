package com.toy.thread;

public class SortTransaction {

    private Object lock = new Object();

    private volatile int flag = 0;

    public void printA() {
        while (flag != 0) {
            try {
                lock.wait();
            } catch (Exception e) {

            }
        }
        System.out.println( String.format(" execute A(). flag=%d", flag));
        flag = 1;
        lock.notify();
    }

    public void printB() {
        while (flag != 1) {
            try {
                lock.wait();
            } catch (Exception e) {

            }
        }
        System.out.println( String.format(" execute B(). flag=%d", flag));
        flag = 2;
        lock.notify();
    }

    public void printC() {
        while (flag != 2) {
            try {
                lock.wait();
            } catch (Exception e) {

            }
        }
        System.out.println( String.format(" execute C(). flag=%d", flag));
        flag = 3;
        lock.notify();
    }

    public void init() {
        while (flag != 3) {
            try {
                lock.wait();
            } catch (Exception e) {

            }
        }
        System.out.println( String.format(" exceute init(). flag=%d", flag));
        flag = 0;
        lock.notify();
    }
}
