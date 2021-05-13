package com.weidd.best.dataStructureandAlgorithms.algorithms.sort;


/**
 * @program: SortDemo
 * @author: weidd
 * @date: 2020-12-07 19:14
 **/
public class TestSort {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 0, 5, 9, 4, 11, 6, 8, 9};
        int[] sortArr = sort1(arr);
        for (int i = 0; i <= sortArr.length - 1; i++) {
            System.out.print(sortArr[i] + "\t");
        }
    }

    /**
     * 冒泡排序:
     * 1:思路. 比较数组的相邻两个元素值的大小,值大的放后面
     * 2:两层循环,第一层步进,第二层找出最大值
     *
     * @param arr
     * @return
     */
    public static int[] sort1(int[] arr) {

        for (int i = arr.length - 1; i >= 0; i--) {
            boolean flag = true;// 定义一个标志,外层首次循环值不变,则该数组为有序数组
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
