package com.weidd.best.javabasic.InnerClass;

/**
 * @program: SortDemo
 * @author: weidd
 * @date: 2021-03-21 12:51
 **/
public class OuterClass {
    public static long CURRENT_TIME = System.currentTimeMillis();


    public OuterClass() {
        System.out.println("外部类构造方法~" + System.currentTimeMillis());
    }

    static {
        System.out.println("外部类的静态代码块~" + System.currentTimeMillis());
    }

    public static void staticMethod() {
        System.out.println("静态方法staticMethod~" + System.currentTimeMillis());
    }

    public void method() {
        System.out.println("成员方法method~" + System.currentTimeMillis());
    }

    public static class InnerClass {
        public static long aLong = 10;

        public InnerClass() {
            System.out.println("内部类的构造方法~" + System.currentTimeMillis());
        }
    }

    public static void main(String[] args) {

        System.out.println("CURRENT_TIME静态成员变量--> " + CURRENT_TIME);
        OuterClass outter = new OuterClass();
//        System.out.println("OuterClass.InnerClass.aLong-> " + OuterClass.InnerClass.aLong);

    }
}
