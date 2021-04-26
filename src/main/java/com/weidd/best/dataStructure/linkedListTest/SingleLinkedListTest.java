package com.weidd.best.dataStructure.linkedListTest;

/**
 * @program: SortDemo
 * @author: weidd
 * @date: 2021-04-17 18:53
 * 单链表的反转
 **/
public class SingleLinkedListTest {

    static class Node {
        String data;
        Node next;

        public Node(String data) {
            this.data = data;
        }

        public Node next(Node next) {
            this.next = next;
            return next;
        }
    }

    public static void main(String[] args) {

        Node first = new Node("1");
        Node second = new Node("2");
        Node third = new Node("3");
        Node fourth = new Node("4");
        Node five = new Node("5");
        first.next(second);
        second.next(third);
        third.next(fourth);
        fourth.next(five);
        five.next(null);
        Node node=first;
        while (first != null) {
            System.out.print(first.data);
            first = first.next;
            System.out.print("-->");
        }
        System.out.println();
        System.out.println("--------链表反转---------");
        Node cur =node,pre=null,temp=null;
        while(cur!=null){
            temp=cur.next;
            cur.next=pre;
            pre=cur;
            cur=temp;
        }
        while(pre!=null){
            System.out.print(pre.data);
            pre=pre.next;
            System.out.print("->");
        }
    }
}
