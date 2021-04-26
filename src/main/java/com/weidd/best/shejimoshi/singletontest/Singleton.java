package com.weidd.best.shejimoshi.singletontest;

/**
 * @program: SortDemo
 * @author: weidd
 * @date: 2021-03-21 00:19
 * 饿汉式:线程安全
 **/
public class Singleton {
    private Singleton() {

    }

    private static final Singleton instance = new Singleton();
    // 静态工厂方法
    public static Singleton getInstance() {
        return instance;
    }

    public void doSomething(){
        System.out.println("doSomething~");
    }

    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();
        System.out.println(instance==instance1);
    }
}