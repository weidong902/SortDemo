package com.weidd.best.dataStructureandAlgorithms.dataStructure.Stack;

import com.weidd.best.dataStructureandAlgorithms.dataStructure.Array.ArrayDemo;

/**
 * @program: SortDemo
 * @author: weidd
 * @date: 2021-02-02 20:54
 * 基于动态数组是实现的自定义Stack
 **/
public class ArrrayStack<E> implements StackDemo<E> {
    //基于自定义动态数组实现的栈
    private ArrayDemo<E> arrayDemo;

    public ArrrayStack(int capacity) {
        arrayDemo = new ArrayDemo<>(capacity);
    }

    public ArrrayStack() {
        arrayDemo = new ArrayDemo<>();
    }

    // 判断是否为空
    public boolean isEmpty() {
        return arrayDemo.isEmpty();
    }

    // 新增
    public void push(E e) {
        arrayDemo.addLast(e);
    }

    // 删除栈顶
    public E pop() {
        return arrayDemo.deleteLast();
    }

    //查询栈顶元素
    public E peek() {
        return arrayDemo.getLast();
    }


    // 获取元素个数
    public int getSize() {
        return arrayDemo.getSize();
    }

    // 获取容量
    public int getCapacity() {
        return arrayDemo.getCapacity();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ArrayStrack: [");
        for (int i = 0; i < arrayDemo.getSize(); i++) {
            sb.append(arrayDemo.get(i));
            if (i != arrayDemo.getSize() - 1)
                sb.append(", ");
        }
        sb.append("] top");
        return sb.toString();

    }

}
