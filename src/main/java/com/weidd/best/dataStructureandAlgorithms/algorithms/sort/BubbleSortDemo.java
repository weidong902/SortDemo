package com.weidd.best.dataStructureandAlgorithms.algorithms.sort;

import java.util.Arrays;

/**
 * @program: SortDemo
 * @author: weidd
 * @date: 2020-12-04 16:17
 * 一：冒泡排序 BubbleSortDemo
 * 1.比较相邻两个元素，如果前一个比后一个大，则交换；
 * 2.对每一对相邻的元素进行比较，从第一对到最后一对，首次完成后，最后一位的元素值就是最大值；
 * 3.对所有的元素重复以上操作，除最后一个外；
 **/
public class BubbleSortDemo {
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

    /**
     * @param sourceArr
     * @return
     */
    private static int[] sort(int[] sourceArr) {
        int[] arr = Arrays.copyOf(sourceArr, sourceArr.length);
        for (int i = arr.length - 1; i >= 0; i--) {
            boolean flag = true;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
        return arr;
    }
}
