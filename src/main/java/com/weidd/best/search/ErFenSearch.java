package com.weidd.best.search;

/**
 * @program: SortDemo
 * @author: weidd
 * @date: 2021-01-07 13:58
 **/
public class ErFenSearch {
    public static void main(String[] args) {
        //二分查找
        //前提是数组必须是有序的
        int[] arr = {1, 3, 4, 6, 7, 11, 23, 45, 67};
        int des = 22;
        int head = 0;//初始首索引
        int end = arr.length - 1;//初始尾索引
        boolean flag = false;
        while (head <= end) {
            int middle = (head + end) / 2;
            if (arr[middle] == des) {
                System.out.println("找到目标元素,所在的索引为: " + middle);
                flag = true;
            } else if (arr[middle] < des) {
                head = middle + 1;

            } else {
                end = middle - 1;
            }
        }
        if (!flag) {
            System.out.println("未找到目标元素");
        }
    }
}
