package com.weidd.best.mianshi.huohuasiwei;

/**
 * @program: SortDemo
 * @author: weidd
 * @date: 2021-05-11 18:22
 **/
public class Demo01 {
    public static void main(String[] args) {
        // User ID  name
        //  张三 1

        Object o = new Object();
        Integer aa = 100;
        Integer bb = 100;

        System.out.println(aa == bb);
        Integer aa1 = 200;
        Integer bb1 = 200;

        System.out.println(aa1 == bb1);

        System.out.println("--------------");
       /* String
        StrignBuilder
        StringBuffer

        Spring bean生命周期
        1: 客户端携带syn信息到服务端 ,
        2 服务器端拿到客户端的请求,解析. 包装自己的信息ack加上客户端发来的syn
        3:客户端会把ack,再发给服务端 ,告诉他
            user
            id name  grade ,age
            name varchar

            索引
            age
            name  grade ,age

            select * from user where name='100' and age=20
            select * from user where age=30 or  age=20*/

        Integer a = 100;
        Integer b = 200;
//        a=a+b;
//        b=a-b;
//        a=a-b;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println(a);
        System.out.println(b);


    }
}
