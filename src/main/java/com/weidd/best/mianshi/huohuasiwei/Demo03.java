package com.weidd.best.mianshi.huohuasiwei;

import java.lang.reflect.Field;
import java.util.ArrayList;

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

        System.out.println("-------------");
        ArrayList<Integer> list =new ArrayList<>();
        list.add(1);
        list.add(2);
        System.out.println(list.size());

    }
}
