package com.weidd.best.multiThread;

/**
 * @program: SortDemo
 * @author: weidd
 * @date: 2021-03-04 15:56
 * 实现Runnable接口来创建线程
 **/
public class ImplementRunnableThreadTest implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " ** " + i);
        }
    }

    public static void main(String[] args) {
        ImplementRunnableThreadTest run = new ImplementRunnableThreadTest();
        for (int i = 0; i < 5; i++) {
            new Thread(run, "线程--" + i).start();
        }

    }
}
