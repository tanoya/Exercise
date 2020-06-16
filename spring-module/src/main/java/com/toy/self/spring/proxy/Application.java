package com.toy.self.spring.proxy;

import java.lang.reflect.Proxy;

public class Application {

    public static void main(String[] args){
        System.out.println(" start ...");
        LogProxy lp = new LogProxy();
        WorkFunction wf = new WorkFunction();
        lp.bind(wf);
        Work work = (Work)Proxy.newProxyInstance(wf.getClass().getClassLoader(), wf.getClass().getInterfaces(), lp);
        System.out.println(work.hello("jetty"));
    }
}
