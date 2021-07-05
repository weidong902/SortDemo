package com.weidd.best.test;

import org.junit.Test;

import java.io.*;

/**
 * @program: SortDemo
 * @author: weidd
 * @date: 2021-03-17 11:14
 **/
public class Demo01 {
    public static void main(String[] args) throws IOException {
        String str=new String("你好".getBytes("utf-8"),"utf-8");
        String s = new String(str.getBytes("gbk"), "gbk");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("1.txt"));
        bufferedOutputStream.write(s.getBytes(),0,s.getBytes().length);
        bufferedOutputStream.flush();

        System.out.println(s);

    }

    @Test
    public void test1(){
        Integer i =3;
        String s = Integer.toBinaryString(i);
        System.out.println(s);
    }
}
