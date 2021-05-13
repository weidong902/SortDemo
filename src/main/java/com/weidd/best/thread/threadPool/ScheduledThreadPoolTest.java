package com.weidd.best.thread.threadPool;


import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @program: SortDemo
 * @author: weidd
 * @date: 2021-04-16 18:51
 **/
public class ScheduledThreadPoolTest {

    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
        long initialDelay = 1, delay = 1;
        // 应用启动1s后,每隔1s执行一次
        executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+System.currentTimeMillis());
            }
        }, initialDelay, delay, TimeUnit.SECONDS);

        executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }, initialDelay, delay, TimeUnit.SECONDS);
    }
}
