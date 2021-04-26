package com.weidd.best.hashMapTest;

import org.junit.Test;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: SortDemo
 * @author: weidd
 * @date: 2021-04-24 13:06
 **/
public class ConCurrentHashMapTest {
    public static void main(String[] args) {

        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<Integer, String>();
        for (int i = 0; i < 10000; i++) {
            map.put(i, "java");
        }
        String s = map.get(1);
        System.out.println(s);
    }

    @Test
    public void test() {
        AtomicInteger integer = new AtomicInteger();
        int i = integer.addAndGet(1);
        boolean b = integer.compareAndSet(1, 2);
        System.out.println(b);

    }
}
