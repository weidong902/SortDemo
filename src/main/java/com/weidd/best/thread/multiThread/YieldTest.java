package com.weidd.best.thread.multiThread;

import org.junit.Test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: SortDemo
 * @author: weidd
 * @date: 2021-03-04 10:37
 **/
public class YieldTest {
    private static volatile Map<String, AtomicInteger> count = new ConcurrentHashMap<>();

    static class Y implements Runnable {
        private String name;
        private boolean isYield;

        public Y(String name, boolean isYield) {
            this.name = name;
            this.isYield = isYield;
        }

        @Override
        public void run() {
            long l = System.currentTimeMillis();
            for (int i = 0; i < 1000; i++) {
                if (isYield) Thread.yield();
                AtomicInteger atomicInteger = count.get(name);
                if (null == atomicInteger) {
                    count.put(name, new AtomicInteger(1));
                    continue;
                }
                atomicInteger.addAndGet(1);
                count.put(name, atomicInteger);
            }
            System.out.println("􏳃􏰴􏲟号:" + name + " 执􏱆完成􏳝时: " + (System.currentTimeMillis() - l) + "(毫􏽰)" + (isYield ? "􏰥出CPU ----" : " 不􏰥 CPU "));
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            if (i < 10) {
                new Thread(new Y(String.valueOf(i), true)).start();
                continue;
            }
            new Thread(new Y(String.valueOf(i), false)).start();
        }
    }


    @Test
    public void test() throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("thread before");
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("thread after");
        });
        thread.start();
        System.out.println("main begin!");

        thread.join();
        System.out.println("main end!");
    }

}
