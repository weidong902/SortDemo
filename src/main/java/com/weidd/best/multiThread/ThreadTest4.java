package com.weidd.best.multiThread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @program: SortDemo
 * @author: weidd
 * @date: 2021-02-23 19:14
 **/
public class ThreadTest4 {

    //定义一个成员变量初始值为0
    private static int number = 0;
    // 定义一把锁,当某一线程获取到此对象,其他线程只能处于等待状态直至锁释放
//    private static final Object lock = new Object();
    //使用ReentrantLock替换synchronized
//    static ReentrantLock recent = new ReentrantLock();
    //增加读写锁,使写的时候别的线程阻塞,读的时候线程不阻塞.
    private final static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private final static Lock readLock = readWriteLock.readLock();//读锁
    private final static Lock writeLock = readWriteLock.writeLock();
    private final static Condition condition = writeLock.newCondition();
    // 使用Condition中的await和 signal替换synchronized中的wait/notify
//    static Condition condition = recent.newCondition();

    static boolean complete = false;

    private static void read() {
        readLock.lock();
        while (!complete) {
            System.out.println("还未写完 ");
//            readLock.wait();
            try {
                condition.await(); // TODO 此处存疑
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("等着吧,但不阻塞 ");
        }
        System.out.println("number **** = " + number);
        readLock.unlock();
    }

    private static void write(int change) {
        writeLock.lock();
        number += change;
        writeLock.unlock();

    }

    public static void main(String[] args) throws InterruptedException {
        //开启线程加1000次
        new Thread(() -> {
            complete=false;
            for (int i = 0; i < 100; i++) {
                write(1);
                System.out.println("写入 " + number);
            }
            complete = true;

            writeLock.lock();
            condition.signal();
            writeLock.unlock();
            System.out.println("加1操作完成");
        }).start();

        //开启线程读100次
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                read();
            }
            System.out.println("读取结束");
        }).start();

        Thread.sleep(1000);
    }

}
