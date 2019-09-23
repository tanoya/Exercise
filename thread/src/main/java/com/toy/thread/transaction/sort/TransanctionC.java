package com.toy.thread.transaction.sort;

public class TransanctionC implements Runnable{

    Thread wait;

    public void run() {
        try {
            wait.join();
        } catch (InterruptedException e) {

        }
        System.out.println( "C" );
    }

    public void setWait(Thread wait) {
        this.wait = wait;
    }

}
