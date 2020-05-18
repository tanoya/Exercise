package com.toy.data.structure.string;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TestString {

    // 使用栈
    public boolean legalBrace(String src){
        if(src == null || src.trim().length() == 0){
            return false;
        }

        // 单数出现，所以不符合成对的要求
        if(src.length() % 2 != 0){
            return false;
        }

        Stack<Character> stack = new Stack<Character>();
        char[] chars = src.toCharArray();
        for(int i=0; i<src.length(); i++){
            if( stack.isEmpty() && '}' == chars[i] ){
                return false;
            }
            if('{' == chars[i]){
                stack.push(chars[i]);
            }else{
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    // 使用状态码
    public boolean legalBrace01(String src){
        if(src == null || src.trim().length() == 0){
            return false;
        }

        // 单数出现，所以不符合成对的要求
        if(src.length() % 2 != 0){
            return false;
        }

        int container = 0;
        char[] chars = src.toCharArray();
        for(int i=0; i<src.length(); i++){
            if( container == 0 && '}' == chars[i] ){
                return false;
            }
            if('{' == chars[i]){
                container++;
            }else{
                container--;
            }
        }
        return container==0;
    }

    public static void main(String[] args){
        TestString ts = new TestString();
        List<String> test = new ArrayList<String>();
        test.add("}{}{}{");
        test.add("{}{}{}");
        test.add("{{}}{}");
        for(String item : test){
            if(ts.legalBrace01(item)){
                System.out.println("legal");
            }else{
                System.out.println("illegal");
            }
        }
    }
}
