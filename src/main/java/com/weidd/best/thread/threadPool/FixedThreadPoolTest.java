package com.weidd.best.thread.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: SortDemo
 * @author: weidd
 * @date: 2021-04-16 13:43
 **/
public class FixedThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 1000; i++) {
            executorService.submit(
                    new Runnable() {
                        @Override
                        public void run() {

                            System.out.println("线程-->" + Thread.currentThread().getName());
                        }
                    }
            );
        }
        executorService.shutdown();
    }
}
