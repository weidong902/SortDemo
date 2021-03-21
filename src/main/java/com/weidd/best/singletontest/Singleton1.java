package com.weidd.best.singletontest;

/**
 * @program: SortDemo
 * @author: weidd
 * @date: 2021-03-21 10:47
 *
 * 线程不安全
 **/
public class Singleton1 {

    private Singleton1() {
    }

    private static Singleton1 instance = null;

    public static Singleton1 getInstance() {
        if (null == instance) {
            instance = new Singleton1();
        }
        return instance;
    }
    private void doSomething(){
        System.out.println("dosomething~");
    }

    public static void main(String[] args) {
        Singleton1 instance = Singleton1.getInstance();


    }
}
