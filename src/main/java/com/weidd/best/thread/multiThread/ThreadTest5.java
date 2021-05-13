package com.weidd.best.thread.multiThread;

import org.junit.Test;

import java.util.HashMap;
import java.util.Stack;
import java.util.concurrent.locks.StampedLock;

/**
 * @program: SortDemo
 * @author: weidd
 * @date: 2021-02-23 19:14
 **/
public class ThreadTest5 {

    //定义一个成员变量初始值为0
    private static int number = 0;
    // 定义一把锁,当某一线程获取到此对象,其他线程只能处于等待状态直至锁释放
//    private static final Object lock = new Object();
    //使用ReentrantLock替换synchronized
//    static ReentrantLock recent = new ReentrantLock();
    //增加读写锁,使写的时候别的线程阻塞,读的时候线程不阻塞.
//    private final static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
//    private final static Lock readLock = readWriteLock.readLock();//读锁
//    private final static Lock writeLock = readWriteLock.writeLock();
//    private final static Condition condition = writeLock.newCondition();
    static StampedLock stampedLock = new StampedLock();
    // 使用Condition中的await和 signal替换synchronized中的wait/notify
//    static Condition condition = recent.newCondition();

    static boolean complete = false;

    private static void read() {
        // 尝试乐观读取
        long stamp = stampedLock.tryOptimisticRead();
        int readNumber = number;
        System.out.println("乐观读取到:readNumber **** = " + readNumber);

        // 检查乐观锁读取的值是是否有误
        if (!stampedLock.validate(stamp)) {
            stamp = stampedLock.readLock();
            System.out.println("乐观锁读取的值" + readNumber + "有误改用悲观锁" + number);
            stampedLock.unlockRead(stamp);
        }
    }

    private static void write(int change) {
        long stamp = stampedLock.writeLock();
        number += change;
        stampedLock.unlockWrite(stamp);
    }

    public static void main(String[] args) throws InterruptedException {
        //开启线程加1000次
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                write(1);
                System.out.println("写入 " + number);
            }
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

    @Test
    public void test1(){
        String s="(){}[]";
        int length = s.length();
        System.out.println(length);
        int n = s.length()/2;
        System.out.println(n);
        String str1 =s.substring(0,n);
        System.out.println(str1);
        HashMap hashMap =new HashMap();
//        hashMap.containsKey()

        Stack<Integer> stack = new Stack<>();
        stack.peek();
        boolean bl=true;
    }
}
