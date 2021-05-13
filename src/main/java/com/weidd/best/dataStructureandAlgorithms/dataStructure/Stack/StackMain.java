package com.weidd.best.dataStructureandAlgorithms.dataStructure.Stack;

/**
 * @program: SortDemo
 * @author: weidd
 * @date: 2021-05-13 20:59
 **/
public class StackMain {
    public static void main(String[] args) {
        ArrrayStack<Integer> arrrayStack = new ArrrayStack<>();
        for (int i = 0; i < 10; i++) {
            arrrayStack.push(i);
        }
        System.out.println(arrrayStack);

        arrrayStack.push(111);
        System.out.println(arrrayStack);
        arrrayStack.pop();
        System.out.println(arrrayStack);
        
    }
}
