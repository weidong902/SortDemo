package com.weidd.best.mianshi;

/**
 * @program: SortDemo
 * @author: weidd
 * @date: 2021-01-09 18:21
 **/
public class Jvmtest {
    public static void main(String[] args) {
        first();
    }

    public static void first() {
        int i = 5;
        Value v = new Value();
        v.i = 25;
        second(v, i);
        System.out.println(v.i);
    }

    private static void second(Value v, int i) {
        i = 0;
        v.i = 20;
        Value val = new Value();
        v = val;
        System.out.println(v.i + "  " + i);
    }


}

class Value {

    int i = 15;
}
