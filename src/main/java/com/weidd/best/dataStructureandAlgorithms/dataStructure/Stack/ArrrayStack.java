package com.weidd.best.dataStructureandAlgorithms.dataStructure.Stack;

import com.weidd.best.dataStructureandAlgorithms.dataStructure.Array.ArrayDemo;

/**
 * @program: SortDemo
 * @author: weidd
 * @date: 2021-02-02 20:54
 **/
public class ArrrayStack<E> implements StackDemo {
    //基于自定义动态数组实现的栈
    private ArrayDemo<E> arrayDemo;

    public ArrrayStack(int capacity) {
        arrayDemo = new ArrayDemo<>(capacity);
    }

    // 判断是否为空
    public boolean isEmpty() {
        return false;
    }

    // 新增
    public E push(Object o) {
        return null;
    }

    // 删除栈顶
    public E pop() {
        return null;
    }

    //查询栈顶元素
    public E peek() {
        return null;
    }

    // 获取元素个数
    public int getSize() {
        return 0;
    }

}
