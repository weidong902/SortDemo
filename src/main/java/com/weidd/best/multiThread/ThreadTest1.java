package com.weidd.best.multiThread;

import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: SortDemo
 * @author: weidd
 * @date: 2021-02-20 10:29
 **/
public class ThreadTest1 {

    //定义一个成员变量初始值为0
    private int number = 0;
    // 定义一把锁,当某一线程获取到此对象,其他线程只能处于等待状态直至锁释放
    private final Object lock = new Object();
    //使用ReentrantLock替换synchronized
    ReentrantLock reent = new ReentrantLock();


    boolean complete = false;

    /*private void read() {
        synchronized (lock) {
            while (!complete) {
                System.out.println("还未完成写...");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("number = " + number);
        }
    }*/
    private void read() {
//        reent.lock();
        synchronized (lock) {
            while (!complete) {
                System.out.println("还未写完 ");
            }
            System.out.println("number**** = " + number);

        }

//        reent.unlock();
    }

    //使用synchronized 对方法进行加锁
    /*private void write(int change) {
        synchronized (lock) {
            number += change;
        }
    }*/


    private void write(int change) throws InterruptedException {
        if (reent.tryLock(1, TimeUnit.SECONDS)) {
            number += change;
            reent.unlock();
        } else {
            //1秒后再次尝试获取锁,如果还是获取不到,就不再等待
            System.out.println("1秒了还是没有获的锁,不等了...");
        }
    }

    @Test
    public void test4() throws InterruptedException {
        System.out.println("ceshi");
        //开启线程加10000次
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
                read();
            }
            System.out.println("读取结束");
        }).start();
        Thread.sleep(100000);
    }


    // 在write方法执行时,实际执行三个语句,(load,add,store 即不是一个原子操作.)

    /*两个线程一个线程做加法一个线程读取.测试使用wait()和notify()方法实现,
      当写线程未完成时,使用wait()方法使当前线程处于等待状态,但是不阻塞,不占用CPU资源,
      当写线程完成后,使用notify()方法来唤醒处于等待状态的线程.
      注意: wait()和notify()方法均必须在synchronized中执行.*/
    @Test
    public void test3() throws InterruptedException {
        //开启线程加10000次
        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                try {
                    write(1);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("写入 " + number);
            }
            System.out.println("加1操作完成");
            //complete = true;
            // 写入完成，唤醒读取线程，wait/notify 操作必须在 synchronized 中执行。 否则不能成功唤醒线程.
            synchronized (lock) {
                lock.notify();
            }
        }).start();

        //开启线程读100次
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                read();
            }
            System.out.println("读取结束");
        }).start();
        Thread.sleep(100000);
    }


    // 在write方法执行时,实际执行三个语句,(load,add,store 即不是一个原子操作.)
    @Test//两个线程一个线程做加法一个线程读取.测试使用 synchronized来实
    public void test2() throws InterruptedException {
        //开启线程加10000次
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    write(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("写入 " + number);
            }
            System.out.println("加1操作完成");
        }).start();

        //开启线程减10000次
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                read();
            }
            System.out.println("读取结束");
        }).start();
        Thread.sleep(1000);
    }

    //两个线程,一个线程做加法,一个线程做减法,测试最终结果为0
    @Test
    public void test1() throws InterruptedException {
        //开启线程加10000次
        new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                try {
                    write(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("加1操作完成");
        }).start();

        //开启线程减10000次
        new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                try {
                    write(-1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("减1操作完成");
        }).start();

        //睡眠1秒保证线程执行完成
        Thread.sleep(1000);
        read();
    }

}
