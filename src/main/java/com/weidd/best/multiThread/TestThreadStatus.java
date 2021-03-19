package com.weidd.best.multiThread;

/**
 * @program: SortDemo
 * @author: weidd
 * @date: 2021-03-02 19:48
 **/
public class TestThreadStatus {
    //测试线程的状态
    public static void main(String[] args) throws InterruptedException {
        Object obj = new Object();
        /*new Thread(() -> {
            synchronized (obj) {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();*/

        Thread thread = new Thread(() -> {
        });
        thread.start();
        System.out.println(thread.getState());
        System.out.println(thread.getState());
        System.out.println(thread.getState());
    }
}
