package com.toy.data.structure;

public class Application {

    public static void main(String[] args) {
        System.out.println("Halo world!");

        System.out.println(test(0));
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
        return 1;
    }
}
