package com.toy.data.structure;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Application {

    public static void main(String[] args) {
        String key="abc";
        int hashCode = key.hashCode();
        System.out.println(String.format("%d,   %s", hashCode, Integer.toBinaryString(hashCode)));
        int h;
        System.out.println(Integer.toBinaryString(key.hashCode()>>>16));
    }

    public static int test(int mark){
        try {
            System.out.println("running~");
            return innerTest(-1);
        } catch (Exception e) {
            System.out.println("exception");
        } finally {
            System.out.println("finally");
        }
        return 0;
    }

    public static int innerTest(int mark) throws Exception{
        if (mark == -1) {
            System.out.println(" error happened !");
            throw new Exception("inner error!");
        }

        Queue<Character> queue = new LinkedBlockingQueue<Character>();

        return 1;
    }


}
