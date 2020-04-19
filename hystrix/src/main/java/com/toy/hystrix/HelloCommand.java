package com.toy.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.apache.commons.lang.StringUtils;

import java.util.concurrent.Future;

public class HelloCommand extends HystrixCommand<String> {

    private String name;

    public HelloCommand(String name){
        super(HystrixCommandGroupKey.Factory.asKey("HelloGroup"));
        this.name = name;
    }

    protected String run() throws Exception {
        if (StringUtils.isNotBlank(name)) {
            throw new Exception("exception");
        }
        return "Hello, run " + name + " current thread " + Thread.currentThread().getName();
    }

    @Override
    protected String getFallback() {
        return "yes, current thread " + Thread.currentThread().getName() + " encounter some error. so fallback! ";
    }

    public static void main(String[] args) {
//        HelloCommand command = new HelloCommand("hystrix-group");
//        String result = command.execute();
//
//        System.out.println(" halo " + result);
//
//        HelloCommand asyCommand = new HelloCommand("hystrix-gg");
//        Future<String> future = asyCommand.queue();
//        try {
//            String rr = future.get();
//            System.out.println(" halo, halo " + rr);
//        } catch (Exception e) {
//            System.out.println(" catch error ");
//        }
        String i = "i";
        String i1 = new String("i");
        StringBuilder sb = new StringBuilder(i1);
        sb.reverse();

        StringBuffer buffer = new StringBuffer(i);
        buffer.reverse();

        StringUtils.reverse(i);
        i.intern();
        System.out.println(i.hashCode() + ":" + i1.hashCode());

    }
}
