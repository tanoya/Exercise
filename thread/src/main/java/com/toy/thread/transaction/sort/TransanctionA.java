package com.toy.thread.transaction.sort;

public class TransanctionA implements Runnable{

    private Thread wait;

    public void run() {

        try {
            if (wait != null) {
                wait.join();
            }
        } catch (InterruptedException e) {

        }
        System.out.println( "A" );
    }

    public void setWait(Thread wait) {
        this.wait = wait;
    }
}
