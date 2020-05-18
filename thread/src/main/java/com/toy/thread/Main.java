package com.toy.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Main {


    int left = 0;
    int right = 0;
    public void findMaxStrNotMulti(String s){
        if(s == null || s.length() == 0){
            return ;
        }
        char[] temps = s.toCharArray();
        int maxLength = 0;
        Queue<Character> result = new ArrayBlockingQueue<Character>(s.length());
        for(int i=0; i< temps.length; i++){
            for(int j=i; j< temps.length; j++){
                if(!result.contains(temps[j])){
                    result.add(temps[j]);
                }else{
                    if( j - i > maxLength){
                        maxLength = j-i;
                        left = i;
                        right = j;
                    }
                    while(temps[j] != result.remove()){

                    }
                    result.add(temps[j]);
                }
            }
        }
    }

    public static void main(String[] args){

    }

}