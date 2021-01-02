package com.janliao.leetcode;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n1.next = n2;n2.next = n3;n3.next = n4;
        Node n5 = new Node(1);
        Node n6 = new Node(3);
        Node n7 = new Node(5);
        Node n8 = new Node(7);
        Node n9 = new Node(8);
        Node n10 = new Node(10);
        Node n11 = new Node(11);
        Node n12 = new Node(12);
        n5.next = n6;n6.next = n7;n7.next = n8;
        n8.next = n9;n9.next = n10;n10.next = n11;
        n11.next = n12;
        Node res = new MergeTwoSortedLists().mergeTwoLists(n1, n5);
        while(res != null){
            System.out.println(res.value);
            res = res.next;
        }
    }

    public Node mergeTwoLists(Node l1, Node l2) {
        // 哨兵节点
        Node root = new Node();
        Node pre = root;
        while(l1 != null && l2 != null){
            if(l1.value > l2.value){
                root.next = l2;
                l2 = l2.next;
            } else {
                root.next = l1;
                l1 = l1.next;
            }
            root = root.next;
        }
//        while(l1 != null){
//            root.next = l1;
//            l1 = l1.next;
//            root = root.next;
//        }
        if(l1 != null){
            root.next = l1;
        }
//        while(l2 != null){
//            root.next = l2;
//            l2 = l2.next;
//            root = root.next;
//        }
        if(l2 != null){
            root.next = l2;
        }
        return pre.next;
    }
}
