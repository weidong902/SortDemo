package com.weidd.best.dataStructureandAlgorithms.dataStructure.Array;

/**
 * @program: SortDemo
 * @author: weidd
 * @date: 2021-05-13 10:59
 * <p>
 * 验证自己的数组
 **/
public class ArrayMain {
    public static void main(String[] args) {
        ArrayDemo<Integer> ArrayDemo = new ArrayDemo<>();
        for (int i = 0; i < 11; i++) {
            ArrayDemo.addLast(i);
        }
        System.out.println(ArrayDemo);
//        ArrayDemo.add(1, 100);
//        System.out.println(ArrayDemo);
//        ArrayDemo.addFirst(-1);
//        System.out.println(ArrayDemo);

        System.out.println("获取索引为2的元素: " + ArrayDemo.get(2));

        System.out.println("是否存在: " + ArrayDemo.contains(1));
        ArrayDemo.deleteIndex(0);
//        ArrayDemo.deleteIndex(0);
        System.out.println(ArrayDemo);
        ArrayDemo.deleteElment(4);
        System.out.println(ArrayDemo);

    }

}
