package com.weidd.best.sort;

import java.util.Arrays;

/**
 * @program: SortDemo
 * @author: weidd
 * @date: 2020-12-04 17:36
 * <p>
 * 二：选择排序  SelectSort
 * 1：首先从数组中选出最小值，将最小值放置到数组的起始位置；
 * 2：再从剩下未排序的数组中找出最小值，放置到已排序的尾部；
 * 3：重复上一步操作，直至数组完成排序
 * （有种递归的感觉）
 **/
public class SelectSort {
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
        int[] arr = Arrays.copyOf(sourceArr, sourceArr.length);
        // 两层循环，外层循环推动遍历前进，内层循环取最小值
        // 遍历arr.length-1次，即可排出顺序
        for (int i = 0; i < arr.length - 1; i++) {
            //首次取数组中第一个值作为最小值，去和数组中其他的值做比较
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {// 判断数组值的大小
                    min = j;
                }
            }
            // 将最小值与数组相应的进行交换
            if (i != min) {
                // 还是需要做交换的，因为操作的是同一个数组，每次只找出未排序中中最小的。
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
        return arr;
    }
}

