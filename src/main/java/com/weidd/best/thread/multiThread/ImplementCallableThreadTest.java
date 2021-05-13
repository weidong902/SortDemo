package com.weidd.best.thread.multiThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @program: SortDemo
 * @author: weidd
 * @date: 2021-03-04 15:32
 * 使用实现callable接口来创建线程
 **/
public class ImplementCallableThreadTest implements Callable {

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName()+"  -- call");
        return 2 * 4;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<Integer> future = new FutureTask<Integer>(new ImplementCallableThreadTest());
        new Thread(future).start();
        System.out.println(Thread.currentThread().getName()+"  ** main");
        Integer integer = future.get();
        System.out.println(integer);
    }

}