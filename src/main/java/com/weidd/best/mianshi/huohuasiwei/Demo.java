package com.weidd.best.mianshi.huohuasiwei;

/**
 * @program: SortDemo
 * @author: weidd
 * @date: 2021-04-27 18:45
 * 火花思维: 去除重复项,保证数组中没有重叠.
 **/
public class Demo {
    public static void main(String[] args) {

        int[][] arr = {{1, 2}, {2, 4}, {4, 5}, {4, 7}, {8, 9}, {8, 9}, {8, 9}, {8, 9}};
        int cout = 0;
        int len = arr.length - 1;
        for (int i = 0; i < arr.length - 2; i++) {
            if (arr[i][arr[i].length - 1] > arr[i + 1][0]) {
                arr[i + 1] = arr[i + 2];
                cout++;
            }
        }
        for (int i = 0; i < cout; i++) {
            arr[len--] = null;
        }
        for (int i = 0; i < arr.length - cout; i++) {
            System.out.print(arr[i][0]);
            System.out.print(",");
            System.out.print(arr[i][1]);
            System.out.println();
        }
    }
}
