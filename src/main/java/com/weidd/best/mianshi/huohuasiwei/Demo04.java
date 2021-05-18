package com.weidd.best.mianshi.huohuasiwei;

/**
 * @program: SortDemo
 * @author: weidd
 * @date: 2021-05-17 19:55
 **/
public class Demo04 {

    public static void main(String[] args) {

        String str = "abaa";
        String substring = str.substring(0, 3);
        System.out.println("--------" + substring);
        boolean b = maxLength(str);
        System.out.println(b);


    }

    private static boolean maxLength(String str) {
        int length = str.length();
        int left = 0, right = length - 1;
        while (left < right) {
            if (Character.toLowerCase(str.charAt(left)) != Character.toLowerCase(str.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
