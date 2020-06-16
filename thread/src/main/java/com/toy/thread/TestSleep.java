package com.toy.thread;

/**
 * 主线程在sleep 之后确实会让出来cpu，时间长的话，则在定长时间内不参与竞争
 */
public class TestSleep {


    public static void main(String[] args){

        System.out.println(" main thread is begin !!!");
        for(int i=0; i<100; i++){
            final int key = i;
            Runnable t = new Runnable(){

                public void run(){
                    System.out.println("I am running t" + key );
                }
            };
            Thread runner = new Thread(t);
            runner.start();
        }
        try{
            Thread.sleep(0);
        }catch (Exception e){

        }
        System.out.println(" main thread is running !!!");
    }
}
