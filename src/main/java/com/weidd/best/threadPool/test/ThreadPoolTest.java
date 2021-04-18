package com.weidd.best.threadPool.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @program: SortDemo
 * @author: weidd
 * @date: 2021-04-16 19:20
 **/
public class ThreadPoolTest {
    public static void main(String[] args) {
//        通过手动创建线程
        /*for (int i = 0; i < 100; i++) {
            int finalI = i;
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "开始执行..." + finalI);
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "结束执行...");

            }).start();

        }*/
        // 使用线程池:
        /**
         * 开启一个线程池  默认线程是10个
         * 使用默认线程工厂
         * 拒绝策略为CallerRunsPolicy策略，让后面的线程先等待
         */
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 20, 1000L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(10), Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardPolicy());
        for (int i = 0; i < 100; i++) {
            threadPoolExecutor.execute(() -> {
                System.out.println(Thread.currentThread().getName() + "线程池Start....");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "线程池ending....");
            });
        }
    }
}
