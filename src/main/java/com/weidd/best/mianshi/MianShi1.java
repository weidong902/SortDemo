package com.weidd.best.mianshi;

/**
 * @program: SortDemo
 * @author: weidd
 * @date: 2021-01-06 14:08
 **/
public class MianShi1 {
    /**
     * 创建一个长度为6的int数组,要求数组中元素值在1~30,且随机赋值不重复
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[6];
        while (true) {
            for (int i = 0; i < 6; i++) {
                arr[i] = (int) (Math.random() * 30 + 1);
            }
        }

    }
}
