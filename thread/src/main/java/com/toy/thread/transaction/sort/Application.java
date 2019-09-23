package com.toy.thread.transaction.sort;

public class Application {

    public static void main(String[] args) {

        TransanctionA a = new TransanctionA();
        TransanctionB b = new TransanctionB();
        TransanctionC c = new TransanctionC();

        Thread t1 = new Thread(a);
        Thread t2 = new Thread(b);
        Thread t3 = new Thread(c);

        b.setWait(t1);
        c.setWait(t2);

        t1.start();
        t2.start();
        t3.start();
    }
}
