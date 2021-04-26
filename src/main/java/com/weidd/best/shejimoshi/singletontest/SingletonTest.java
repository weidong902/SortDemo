package com.weidd.best.shejimoshi.singletontest;

/**
 * @program: SortDemo
 * @author: weidd
 * @date: 2021-03-20 17:20
 **/
public class SingletonTest {
    private static volatile SingletonTest instance;

    private SingletonTest() {
    }


    public static SingletonTest getInstance() {
        if (null != instance)
            return instance;
        synchronized (SingletonTest.class) {
            if (null == instance) {
                instance = new SingletonTest();
            }
        }
        return instance;
    }

    public static void main(String[] args) {

    }

}

