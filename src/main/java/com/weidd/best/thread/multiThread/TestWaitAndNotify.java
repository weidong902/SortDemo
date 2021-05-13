package com.weidd.best.thread.multiThread;

/**
 * @program: SortDemo
 * @author: weidd
 * @date: 2021-03-04 13:19
 **/
public class TestWaitAndNotify {

    public static void main(String[] args) {
        Object obj = new Object();
        Thread thread = new Thread(() -> {
            synchronized (obj){
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });
        thread.start();

        System.out.println(thread.getState());

        obj.notify();
        System.out.println(thread.getState());

    }
}
