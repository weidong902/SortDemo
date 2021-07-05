package com.weidd.best.mianshi.huohuasiwei;

/**
 * @program: SortDemo
 * @author: weidd
 * @date: 2021-05-11 20:27
 **/
//    @Data
public class Node {
    private Integer value;
    private Node next;

    public Node() {
    }

    public Node(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public static void main(String[] args) {

        // 初始化node1
        //4>5>6
        Node node1 = new Node(4);
        Node node12 = new Node(5);
        Node node13 = new Node(6);
        node1.next = node12;
        node12.next = node13;

        //初始化Node2
        //4>6>7>9
        Node node2 = new Node(4);
        Node node22 = new Node(6);
        Node node23 = new Node(7);
        Node node24 = new Node(9);
        node2.next = node22;
        node22.next = node23;
        node23.next = node24;

        //结果5>1>3>5
        Node node3 = add(node1, node2);//做加法
        Node reverse = reverse(node3);//对数据进行翻转

        while (reverse != null) {
            System.out.print(reverse.value);
            System.out.print("-->");
            reverse = reverse.next;
        }
    }

    public static Node add(Node node1, Node node2) {
        //TODO node3=node1+node2;
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }

        Node node11 = reverse(node1);//翻转
        Node node22 = reverse(node2);//翻转
        return addM(node11, node22);//翻转后的node进行加法
    }

    public static Node addM(Node node11, Node node22) {
        //TODO node3=node1+node2;
        int crry = 0;
        Node pre = new Node(0);
        Node node3 = pre;
        while (node11 != null && node22 != null) {
            int sum = node11.value + node22.value + crry;
            crry = sum / 10;
            Node node = new Node((sum % 10));
            pre.next = node;
            node11 = node11.next;
            node22 = node22.next;
            pre = pre.next;
        }

        while(node11 != null) {
            int i = node11.value + crry;
            crry = i / 10;
            Node node = new Node(i % 10);
            pre.next = node;
            node11 = node11.next;
            pre = pre.next;

        }
        while(node22 != null) {
            int i = node22.value + crry;
            crry = i / 10;
            Node node = new Node(i % 10);
            pre.next = node;
            node22 = node22.next;
            pre = pre.next;
        }
        if (crry > 0) {
            pre.next = new Node(crry);
        }
        return node3.next;
    }

    //翻转
    public static Node reverse(Node node) {
        Node pre = null, cur = node, tem = null;
        while (cur != null) {
            tem = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tem;
        }
        return pre;
    }
}
