package com.toy.self.spring.proxy;

public class WorkFunction implements Work{

    public String hello(String name){
        return String.format("say hello to %s", name);
    }

}
