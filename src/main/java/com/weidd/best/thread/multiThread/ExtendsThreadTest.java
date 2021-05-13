package com.weidd.best.thread.multiThread;

/**
 * @program: SortDemo
 * @author: weidd
 * @date: 2021-03-04 15:50
 **/
// 使用继承的方式创建线程
public class ExtendsThreadTest extends Thread {
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "**" + i);
        }
    }
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new ExtendsThreadTest().start();
        }
    }
}
