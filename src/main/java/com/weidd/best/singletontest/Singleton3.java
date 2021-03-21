package com.weidd.best.singletontest;

/**
 * @program: SortDemo
 * @author: weidd
 * @date: 2021-03-21 12:23
 **/
public class Singleton3 {

    private Singleton3() {}
   private  static class Hodler {
        static Singleton3 instance = new Singleton3();
    }

    public static Singleton3 getInstance() {
        return Hodler.instance;
    }

}
