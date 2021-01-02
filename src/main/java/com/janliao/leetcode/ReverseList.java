package com.janliao.leetcode;

class Node{
    public int value;
    public Node next;

    public Node() {
    }

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
public class ReverseList {
    private static int age = 0;
    public static void get(){
        System.out.println(age);
    }
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        n1.next = n2;n2.next = n3;n3.next = n4;n4.next = n5;
        Node res = new ReverseList().reverse(n1);
        while(res != null){
            System.out.print(res.value + "\t");
            res = res.next;
        }
        System.out.println();
    }

    public Node reverse(Node root){
        //if(root.next == null) return root;
        if(root == null) return null;
        // 搞一个哨兵节点
        Node sem = new Node();
        Node pre = root.next;
        sem.next = root;
        while(pre != null){
            Node tmp = pre.next;
            pre.next = sem.next;
            sem.next = pre;
            pre = tmp;
        }
        root.next = null;
        return sem.next;
    }
}
