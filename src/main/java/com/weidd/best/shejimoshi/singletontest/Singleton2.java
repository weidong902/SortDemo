package com.weidd.best.shejimoshi.singletontest;

/**
 * @program: SortDemo
 * @author: weidd
 * @date: 2021-03-21 11:03
 **/
public class Singleton2 {
    private Singleton2() {
    }

    private static volatile Singleton2 instance;

    public static Singleton2 getInstance() {
        if (null == instance) {
            synchronized (Singleton2.class) {
                if (null == instance) {
                    instance = new Singleton2();
                }
            }
        }
        return instance;
    }
}
