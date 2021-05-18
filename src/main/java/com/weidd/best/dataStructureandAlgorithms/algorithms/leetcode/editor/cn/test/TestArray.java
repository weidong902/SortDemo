package com.weidd.best.dataStructureandAlgorithms.algorithms.leetcode.editor.cn.test;

import org.junit.Test;

public class TestArray {

    @Test
    public void test3(){
        String str="nini";
        int length = str.length();

    }
    @Test
    public void test2Array(){
        // TODO Auto-generated method stub
        int[][] arr = {{1,2,3},{4,5,7},{6,8,9}};//动态创建：2个元素(外围数组),每一个元素中各有3个元素(内围数组)
//        arr[0] = new int[]{1,2,3};//给第1个元素(外围数组)，赋值1,2,3
//        arr[1][0] = 22;//给第2个元素中的第1个元素赋值22
//        arr[1][1] = 13;//给第2个元素中的第2个元素赋值13
//        arr[1][2] = 81;//给第2个元素中的第3个元素值81
        for(int i = 0;i < arr.length;i++){
            //System.out.println(arr[i]);//arr中元素：2个数组的地址
            //遍历arr[0]，arr中元素第一个数组
            for(int j = 0;j < arr[i].length;j++){
                System.out.print(arr[i][j] + " ");
            }
        }

    }


    @Test
    public void testArray1(){
        int[] arr =new int[]{1,2,3,4,5};
        for (int i = 0; i < arr.length; i++) {
            System.out.println("i="+ i);
        }

        System.out.println("=========================");
        String[] strings =new String[10];
        for (String string : strings) {
            System.out.println(string);
        }

    }
}
