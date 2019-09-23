package com.toy.thread.transaction.sort;

public class TransanctionB implements Runnable {

    Thread wait;

    public void run() {

        try {
            wait.join();
        } catch (InterruptedException e) {

        }
        System.out.println( "B" );
    }

    public void setWait(Thread wait) {
        this.wait = wait;
    }
}
