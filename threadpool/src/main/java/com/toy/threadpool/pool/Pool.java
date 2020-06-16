package com.toy.threadpool.pool;

public interface Pool {

    /**
     * 提交任务到线程池
     */
    boolean submit(Runnable runnable);

    /**
     * 关闭线程池中的线程
     * @return
     */
    boolean shutdown();

}
