package com.weidd.best.sort;

/**
 * @program: SortDemo
 * @author: weidd
 * @date: 2020-12-19 18:28
 **/
public class QuickSort1 {

    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 8, 0, 10,3, 7, 2, 6, 9};
        quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(i + " ,");
        }
    }

    private static void quickSort(int[] arr, int left, int right) {

        if (left >= right)// 递归的结束条件，重要。
            return;
        // 重要操作：获取基准值对应的数组下标，此过程完成以基准为分界的左右分区。
        int middleIndex = getMiddleIndex(arr, left, right);
        quickSort(arr, left, middleIndex - 1);
        quickSort(arr, middleIndex + 1, right);
    }

    private static int getMiddleIndex(int[] arr, int left, int right) {
        //以数组起始位置值作为基准值。
        int temp = arr[left];
        while (left != right) {

            while (right > left && arr[right] >= temp)
                right--;
            arr[left] = arr[right];
            while (right > left && arr[left] <= temp)
                left++;
            arr[right] = arr[left];
        }
        arr[left] = temp;
        return left;
    }
}
