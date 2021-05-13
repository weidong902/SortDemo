package com.weidd.best.dataStructureandAlgorithms.algorithms.sort;

import java.util.Arrays;

/**
 * @program: SortDemo
 * @author: weidd
 * @date: 2020-12-07 18:53
 * 两种最重要的排序算法（归并+快排）
 * 三：归并排序  MergeSort
 * 和所有递归一样，将数据的量级最小化，化繁为简，从小处反推到大。将大的复杂的问题转变为与之相似的小的问题。
 * <p>
 * 使用递归的知识分解，合并时候为两个有序数组的合并。
 * a：将大的量级的数组转换成两个均包含一个元素数组(递归)
 * b：将小范围的有序数据进行合并（有序数组的合并）
 **/
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {1, 34, 5, 32, 88, 5, 6, 7, 3, 7, 66};
        long start = System.currentTimeMillis();
        int[] tegerArr = sort(arr);
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(arr == tegerArr);
        for (int i = 0; i < tegerArr.length; i++) {
            System.out.print(tegerArr[i] + " ,");
        }

    }

    private static int[] sort(int[] sourceArr) {
        //当原数组的长度小于2是，直接返回当前数组，作为递归的结束条件（递归出口）
        if (sourceArr.length < 2) {
            return sourceArr;
        }
        int[] arr = Arrays.copyOf(sourceArr, sourceArr.length);
        int middle = arr.length / 2;
        // 从from开始to到middle，前包后不包。
        int[] left = Arrays.copyOfRange(arr, 0, middle);
        int[] right = Arrays.copyOfRange(arr, middle, arr.length);
        // 通过递归直至排出两个数的有序数组，再进行向上合并。
        return merge(sort(left), sort(right));

    }

    // 使用两个有序数组合并的方式
    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int lIndex = left.length - 1, rIndex = right.length - 1;
        for (int mergeIndex = result.length - 1; lIndex >= 0 && rIndex >= 0; mergeIndex--) {
            result[mergeIndex] = left[lIndex] > right[rIndex] ? left[lIndex--] : right[rIndex--];

        }
        while (lIndex >= 0) {
            result[lIndex] = left[lIndex--];
        }

        while (rIndex >= 0) {
            result[rIndex] = right[rIndex--];
        }
        /*int i = 0;//初始化合并数组的下标值
        while (left.length > 0 && right.length > 0) {
            if (left[0] <= right[0]) {
                result[i++] = left[0];
                left = Arrays.copyOfRange(left, 1, left.length);
            } else {
                result[i++] = right[0];
                right = Arrays.copyOfRange(right, 1, right.length);
            }
        }

        while (left.length > 0) {
            result[i++] = left[0];
            left = Arrays.copyOfRange(left, 1, left.length);
        }
        while (right.length > 0) {
            result[i++] = right[0];
            right = Arrays.copyOfRange(right, 1, right.length);
        }*/

        return result;
    }

}
