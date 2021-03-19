package com.weidd.best.dataStructure.Stack;

/**
 * @program: SortDemo
 * @author: weidd
 * @date: 2021-02-02 20:48
 **/
interface Stack1<E> {
    int getSize();
    boolean isEmpty();
    E push();
    E pop();

    boolean peek();
}
