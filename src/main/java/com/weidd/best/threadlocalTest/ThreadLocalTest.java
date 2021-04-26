package com.weidd.best.threadlocalTest;

/**
 * @program: SortDemo
 * @author: weidd
 * @date: 2021-04-18 18:14
 **/
public class ThreadLocalTest {
    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal();
        threadLocal.set("key");
        String s = threadLocal.get();
        System.out.println(s);
        System.out.println("-------------------");
        threadLocal.remove();
        
        System.out.println(threadLocal.get());
    }
}
