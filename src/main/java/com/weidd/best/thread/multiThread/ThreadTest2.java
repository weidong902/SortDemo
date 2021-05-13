package com.weidd.best.thread.multiThread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: SortDemo
 * @author: weidd
 * @date: 2021-02-23 09:10
 **/
public class ThreadTest2 {

    //定义一个成员变量初始值为0
    private static int number = 0;
    // 定义一把锁,当某一线程获取到此对象,其他线程只能处于等待状态直至锁释放
//    private static final Object lock = new Object();
    //使用ReentrantLock替换synchronized
    static ReentrantLock recent = new ReentrantLock();

    static boolean complete = false;

    private static void read() throws InterruptedException {
        recent.lock();
        while (!complete) {
            System.out.println("还未写完 ");
            Thread.sleep(500);
        }
        System.out.println("number**** = " + number);
        recent.unlock();
    }

    private static void write(int change) throws InterruptedException {
        if (recent.tryLock(1, TimeUnit.SECONDS)) {
            number += change;
            recent.unlock();
        } else {
            //1秒后再次尝试获取锁,如果还是获取不到,就不再等待
            System.out.println("1秒了还是没有获的锁,不等了...");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //开启线程加1000次
        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                try {
                    write(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("写入 " + number);
            }
            complete = true;
            System.out.println("加1操作完成");
        }).start();

        //开启线程读100次
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    read();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("读取结束");
        }).start();
    }
}
