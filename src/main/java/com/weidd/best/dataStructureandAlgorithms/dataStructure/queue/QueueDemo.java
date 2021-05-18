package com.weidd.best.dataStructureandAlgorithms.dataStructure.queue;

/**
 * @program: SortDemo
 * @author: weidd
 * @date: 2021-05-14 09:20
 * 自定义队列Queue接口: FIFO
 **/
public interface QueueDemo<E> {
    //队列中元素的个数
    int getSize();

    // 队列是否为空
    boolean isEmpty();

    //传入元素
    void enqueue(E e);

    //取出元素
    E dequeue();

    // 获取队首元素
    E getFront();


}
