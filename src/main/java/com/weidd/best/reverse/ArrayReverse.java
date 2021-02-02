package com.weidd.best.reverse;

/**
 * @program: SortDemo
 * @author: weidd
 * @date: 2021-01-07 14:14
 **/
public class ArrayReverse {
    //    数组反转
    public static void main(String[] args) {
        String[] strArr = {"asd", "wewe", "wefdf", "fdfv", "fdsada", "trtw"};
        for (String str : strArr) {
            System.out.print(str + "\t");
        }
        System.out.println();
        for (int i = 0, j = strArr.length - 1; i < j; i++, j--) {
            String temp = strArr[i];
            strArr[i] = strArr[j];
            strArr[j] = temp;
        }

        for (String str : strArr) {
            System.out.print(str + "\t");
        }

    }
}
