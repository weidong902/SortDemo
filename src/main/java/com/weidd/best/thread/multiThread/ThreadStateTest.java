package com.weidd.best.thread.multiThread;

/**
 * @program: SortDemo
 * @author: weidd
 * @date: 2021-03-04 14:50
 **/
public class ThreadStateTest {

    /*public static void main(String[] args) {

        StateTestThread stateTestThread = new StateTestThread();

        Thread thread = new Thread(stateTestThread);

        System.out.println(thread.getName() + " state after constructor:"
                + thread.getState());
        try {
            Thread.sleep(1000L);
            thread.start();
            Thread.sleep(1000L);
            System.out.println(thread.getName() + " state after run:"
                    + thread.getState());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }*/

    /*public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                long begin = System.currentTimeMillis();
                for (int i = 0; i < (1 << 25); i++) {
                    int j = (int) Math.sqrt(i);
                    // 该条件永远不成立， 只是为了计算
                    if (j * j > i) {
                        break;
                    }
                }
                long end = System.currentTimeMillis();
                System.out.println("calculate end:" + (end - begin));
                try {
                    System.out.println("begin sleep");
                    Thread.sleep(5000L);
                    System.out.println("end sleep");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        try {
            thread.start();
            Thread.sleep(100L);
            System.out.println(thread.getName() + " state A :"
                    + thread.getState());
            Thread.sleep(1000L);
            System.out.println(thread.getName() + " state  B :"
                    + thread.getState());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }*/
    public static void main(String[] args) {
        final Object lock = new Object();
        Thread thread = new Thread(new Runnable() {
            public void run() {
                synchronized (lock) {
                    try {
                        lock.wait();//等待状态
                    } catch (InterruptedException e) {

                    }
                }
            }
        });
        thread.start();

        System.out.println(thread.getName() + " state A:"
                + thread.getState());
        try {
            Thread.sleep(5000L);//睡眠5秒
            synchronized (lock) {
                lock.notify();//唤醒等待
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(thread.getName() + " state B:"
                + thread.getState());

        System.out.println(thread.getName() + " state C:"
                + thread.getState());

        System.out.println(thread.getName() + " state D:"
                + thread.getState());

        System.out.println(thread.getName() + " state E:"
                + thread.getState());
    }
}
