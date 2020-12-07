package com.weidd.best.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @program: SortDemo
 * @author: weidd
 * @date: 2020-12-07 19:14
 **/
public class Test01 {
    @Test
    public void test01() {
        int[] arr = {1, 2, 3, 4};
        int middle = arr.length / 2;
        int model1 = (int) Math.floor(arr.length / 2);
        System.out.println(middle);
        System.out.println(model1);

        int[] left = Arrays.copyOfRange(arr, 0, middle);
        int[] right = Arrays.copyOfRange(arr, middle, arr.length);

    }

}
