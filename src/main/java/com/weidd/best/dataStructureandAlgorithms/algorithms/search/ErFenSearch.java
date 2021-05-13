package com.weidd.best.dataStructureandAlgorithms.algorithms.search;

import org.junit.Test;

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
        int des = 23;
        int left = 0;//初始首索引
        int right = arr.length - 1;//初始尾索引
        boolean flag = false;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (arr[middle] == des) {
                System.out.println("找到目标元素,所在的索引为: " + middle);
                flag = true;
                break;
            } else if (arr[middle] < des) {
                left = middle + 1;

            } else {
                right = middle - 1;
            }
        }
        if (!flag) {
            System.out.println("未找到目标元素");
        }
    }

    // LeetCode 题型,二分查找的变种.
    // 给定一个有序数组和一个目标值.在数组中找到目标值,返回目标值的下标,若无,则返回目标值插入的下标
    @Test
    public void testErFen() {
        //前提是数组必须是有序的
        int[] arr = {1, 3, 4, 6, 7, 11, 23, 45, 67};
        int target = 3;
//        int[] arr = {1};
//        int target = 0;
        int index = getIndex(arr, target);
        System.out.println(index);
        System.out.println("-------------------");

        int i = searchInsert(arr, target);
        System.out.println(i);
    }

    private int getIndex(int[] arr, int des) {
        // 定义左右指针,

        return 0;
    }

    public int searchInsert1(int[] nums, int target) {
        // 方式1：暴力解题，时间复杂读为O(n)
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
        //是否是使用2分法查找。
    }

    public int searchInsert(int[] nums, int target) {
        // 方式1：暴力解题，时间复杂度为O(n)
    /*for(int i =0; i<nums.length;i++){
        if(nums[i]>=target){
            return i;
        }
    }
    return nums.length;*/
        //方式2:使用二分查找，将时间复杂度降至O(logn)

        int left =0, right =nums.length-1;

        while(left<=right){
            int middle =(left+right)/2;
            if(nums[middle]==target){
                return middle;
            }else if(nums[middle]<target){
                left = middle+1;
            }else{
                right =middle-1;
            }
        }
        return left;
    }
}
