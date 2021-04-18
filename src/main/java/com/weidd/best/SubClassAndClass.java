package com.weidd.best;

/**
 * @program: SortDemo
 * @author: weidd
 * @date: 2021-04-15 12:29
 **/
public class SubClassAndClass {
    /**
     * 多态中,父类的引用指向子类的对象,
     * 当子类重写父类的方法时,父类的对象引用调用子类的方法.
     * 如果子类未重写父类的方法,则父类的对象的引用还是调用服了的方法.
     */
    public static void main(String[] args) {
        A a = new B();
        B b = new B();
        System.out.println("Result=" + a.func1(100, 50));//Result=150
        System.out.println("Result=" + a.func2(100, 50));//Result=50
        System.out.println("Result=" + b.func1(100, 50));//Result=150
    }
}

class A {
    public int func1(int a, int b) {
        return a - b;
    }

    public int func2(int a, int b) {
        return a - b;
    }
}

class B extends A {
    public int func1(int a, int b) {
        return a + b;
    }
}

