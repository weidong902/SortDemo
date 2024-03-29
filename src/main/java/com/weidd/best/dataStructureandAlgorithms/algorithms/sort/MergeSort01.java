package com.weidd.best.dataStructureandAlgorithms.algorithms.sort;

/**
 * @program: SortDemo
 * @author: weidd
 * @date: 2020-12-08 11:08
 * 两种最重要的排序算法（归并+快排）
 * 三：归并排序  MergeSort01
 * 和所有递归一样，将数据的量级最小化，化繁为简，从小处反推到大。将大的复杂的问题转变为与之相似的小的问题。
 * <p>
 * 使用递归的知识分解，合并时候为两个有序数组的合并。
 * a：将大的量级的数组转换成两个均包含一个元素数组(递归)
 * b：将小范围的有序数据进行合并（有序数组的合并）
 **/
public class MergeSort01 {
    public static int[] mergeSort(int[] nums, int l, int h) {
        if (l == h)
            return new int[]{nums[l]};
        int mid = l + (h - l) / 2;
        int[] leftArr = mergeSort(nums, l, mid); //左有序数组
        int[] rightArr = mergeSort(nums, mid + 1, h); //右有序数组
        int[] newNum = new int[leftArr.length + rightArr.length]; //新有序数组
        int m = 0, i = 0, j = 0;
        while (i < leftArr.length && j < rightArr.length) {
            newNum[m++] = leftArr[i] < rightArr[j] ? leftArr[i++] : rightArr[j++];
        }
        while (i < leftArr.length)
            newNum[m++] = leftArr[i++];
        while (j < rightArr.length)
            newNum[m++] = rightArr[j++];
        return newNum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 10};
        int[] newNums = mergeSort(nums, 0, nums.length - 1);
        for (int x : newNums) {
            System.out.print(x+" ,");
        }
    }

}
