package com.weidd.best.jvm.ClassLoader;

/**
 * @program: SortDemo
 * @author: weidd
 * @date: 2021-05-15 10:42
 * 验证类加载顺序
 **/
public class Test1 {
}

class Father2 {
    public static String strFather = "HelloJVM_Father";

    static {
        System.out.println("Father静态代码块");
    }
}

class Son2 extends Father2 {
    public static String strSon = "HelloJVM_Son";

    static {
        System.out.println("Son静态代码块");
    }
}

class InitativeUseTest2 {
    public static void main(String[] args) {

        System.out.println(Son2.strSon);
    }
}
