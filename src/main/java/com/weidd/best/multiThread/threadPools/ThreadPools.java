package com.weidd.best.multiThread.threadPools;

import java.util.concurrent.*;

/**
 * @program: SortDemo
 * @author: weidd
 * @date: 2021-03-04 11:09
 **/
public class ThreadPools {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10, 0L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(10));
        ExecutorService executorService = Executors.newFixedThreadPool(10);
//        executorService.execute();

        threadPoolExecutor.execute(() -> {
            System.out.println("Hi 􏳃􏰴线程池!");
        });
        threadPoolExecutor.shutdown();
    }


}
