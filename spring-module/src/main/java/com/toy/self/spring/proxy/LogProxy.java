package com.toy.self.spring.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LogProxy implements InvocationHandler {

    private Object delegate;

    public void bind(Object delegate){
        this.delegate = delegate;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        try{
            if("hello".equals(method.getName())){
                System.out.println(" I will log just now ! ----> " + method.getName());
            }
            result = method.invoke(this.delegate, args);
        }catch (Exception e){

        }
        return result;
    }
}
