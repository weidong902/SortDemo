package com.weidd.best.multiThread;

/**
 * @program: SortDemo
 * @author: weidd
 * @date: 2021-03-04 14:50
 **/
public class StateTestThread implements Runnable {

    public StateTestThread() {
        // 此时的线程还是 main
        System.out.println(Thread.currentThread().getName() + " state in Constructor:" +
                Thread.currentThread().getState());
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + " state in Run:" +
                Thread.currentThread().getState());
    }
}
