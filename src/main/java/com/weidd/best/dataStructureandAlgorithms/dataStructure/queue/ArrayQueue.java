package com.weidd.best.dataStructureandAlgorithms.dataStructure.queue;

import com.weidd.best.dataStructureandAlgorithms.dataStructure.Array.ArrayDemo;

/**
 * @program: SortDemo
 * @author: weidd
 * @date: 2021-05-14 09:27
 *
 * 基于数组实现的队列.
 * 在出队的操作中时间复杂度是O(n)级别的.
 **/
public class ArrayQueue<E> implements QueueDemo<E> {

    private ArrayDemo<E> arrayDemo;//基于自定义动态数组实现

    public ArrayQueue(int capacity) {
        arrayDemo = new ArrayDemo<>(capacity);
    }

    public ArrayQueue() {
        arrayDemo = new ArrayDemo<>();
    }

    //队列中元素的个数
    @Override
    public int getSize() {
        return arrayDemo.getSize();
    }

    // 队列是否为空
    @Override
    public boolean isEmpty() {
        return arrayDemo.isEmpty();
    }

    //传入元素
    @Override
    public void enqueue(E e) {
        arrayDemo.addLast(e);
    }

    //取出元素
    @Override
    public E dequeue() {
        return arrayDemo.deleteFirst();
    }

    // 获取队首元素
    @Override
    public E getFront() {
        return arrayDemo.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ArrayQueue: front [");
        for (int i = 0; i < arrayDemo.getSize(); i++) {
            sb.append(arrayDemo.get(i));
            if (i != arrayDemo.getSize() - 1)
                sb.append(", ");
        }
        sb.append("] tail");
        return sb.toString();
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        for (int i = 0; i < 10; i++) {
            arrayQueue.enqueue(i);
            System.out.println(arrayQueue);

            if (i % 3 == 2) {
                arrayQueue.dequeue();
                System.out.println(arrayQueue);
            }
        }


    }
}
