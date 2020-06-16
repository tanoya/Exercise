package com.toy.threadpool.pool;

import com.sun.tools.javac.util.Assert;
import java.util.concurrent.LinkedBlockingQueue;

public class PoolImpl implements Pool {

    private LinkedBlockingQueue<Runnable> core;
    private LinkedBlockingQueue<Runnable> extra;
    private int coreSize;
    private int maxSize;
    private boolean fixed;

    public PoolImpl(boolean fixed, int coreSize, int maxSize)throws Exception{
        if(coreSize < 0 || maxSize < 0){
            throw new Exception("should init size");
        }
        if(!fixed && maxSize < coreSize){
            throw new Exception("max size should be init");
        }

        core = new LinkedBlockingQueue(coreSize);
        if(fixed) return;
        extra = new LinkedBlockingQueue(maxSize - coreSize);
        this.coreSize = coreSize;
        this.maxSize = maxSize;
        this.fixed = fixed;
    }



    public boolean submit(Runnable runnable) {

        Assert.checkNull(runnable, "job can not be null");
        boolean result = false;
        if(core.size() < coreSize){
            result = core.add(runnable);
        }

        if(!fixed && extra.size() < (maxSize - coreSize)){
            result = extra.add(runnable);
        }
        return result;

    }

    public boolean shutdown() {
        return false;
    }


}
