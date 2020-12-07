package com.weidd.best.sort;

/**
 * @program: SortDemo
 * @author: weidd
 * @date: 2020-12-07 20:53
 * 快速排序：  QuickSort
 *
 **/
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {1, 34, 5, 32, 88, 5, 6, 7, 3, 7, 66};
        long start = System.currentTimeMillis();
        int[] tegerArr = sort(arr);
        System.out.println(System.currentTimeMillis()-start);
        System.out.println(arr == tegerArr);
        for (int i = 0; i < tegerArr.length; i++) {
            System.out.print(tegerArr[i] + " ,");
        }

    }

    private static int[] sort(int[] sourceArr) {
        return null;
    }
}
