package com.weidd.best.huohuasiwei;

import java.lang.reflect.Field;

/**
 * @program: SortDemo
 * @author: weidd
 * @date: 2021-05-12 13:32
 **/
public class Demo03 {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Integer.class.getDeclaredClasses()[0];
        Field field = clazz.getDeclaredField("cache");
        field.setAccessible(true);
        Integer[] cache = (Integer[]) field.get(clazz);
        cache[132] = cache[133];
        int a = 2;
        int b = a + a;
        System.out.printf("%d+%d=%d", a, a, b);
        System.out.println();
        System.out.println(a + "+" + a + "=" + b);
    }
}
