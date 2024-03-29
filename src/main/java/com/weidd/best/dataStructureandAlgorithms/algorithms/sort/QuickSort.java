package com.weidd.best.dataStructureandAlgorithms.algorithms.sort;

/**
 * @program: SortDemo
 * @author: weidd
 * @date: 2020-12-07 20:53
 * 快速排序：  QuickSort 思想：分治
 * 指针交换法、挖坑法
 * <p>
 * 1：从数组中找出一个元素作为基准（pivot）。
 * 2：排序，将所有比基准数小的放到基准的左侧，比基准大的放到基准的右侧。该操作称为分区（partition）
 * 3：递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序；
 * <p>
 * 指针交换：
 * 1：
 **/
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {1, 34, 88, 5, 6, 7, 3, 7, 66};
        long start = System.currentTimeMillis();
        sort(arr, 0, arr.length - 1);
        System.out.println(System.currentTimeMillis() - start);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ,");
        }

    }

    private static void sort(int[] arr, int left, int right) {

        if (left >= right)//递归的结束条件，非常重要
            return;

        //重要是先获取基准对应下标，在获取基准下标的过程中将数组分成两个分区
        int pivotIndex = getPivotIndex(arr, left, right);
        // 然后再用递归，排出左右分区。
        sort(arr, left, pivotIndex - 1);
        sort(arr, pivotIndex + 1, right);
    }

    //获取基准值对应数组下标
    private static int getPivotIndex(int[] arr, int left, int right) {
        // 定义一组变量，i,j为左右指针，temp为左右交换时的临时变量，pivot为基准值。
        int i, j, temp, pivot;
        i = left;
        j = right;
        pivot = arr[left];

        while (i != j) {
            while (pivot <= arr[j] && j > i)
                j--;
            while (pivot >= arr[i] && j > i)
                i++;
            // 交换左右指针对应的值
            if (j > i) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        arr[left] = arr[i];
        arr[i] = pivot;
        return i;
    }
}

