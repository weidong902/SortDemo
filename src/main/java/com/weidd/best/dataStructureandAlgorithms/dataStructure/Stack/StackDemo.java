package com.weidd.best.dataStructureandAlgorithms.dataStructure.Stack;

/**
 * @program: SortDemo
 * @author: weidd
 * @date: 2021-05-13 15:32
 * <p>
 * 自定义一个Stack 接口.
 * 后期基于不同的数据结构去实现该接口.
 **/
public interface StackDemo<E> {
    // 判断是否为空
    public boolean isEmpty();

    // 新增
    public E push(E e);

    // 删除
    public E pop();

    //查询
    public E peek();

    // 获取元素个数
    public int getSize();
}
