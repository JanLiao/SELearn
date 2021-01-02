package com.janliao.leetcode;

public class CycleList {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(5);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(2);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        //n4.next = n2;
        boolean flag = new CycleList().hasCycle(n1);
        System.out.println(flag);
    }

    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        boolean flag = false;
        if(head.next == null) return false;
        if(head.next.next == null) return false;
        ListNode node1 = head;
        ListNode node2 = head.next.next;
        while(node2 != null){
            if(node1 != node2){
                node1 = node1.next;
                if(node2.next != null){
                    node2 = node2.next.next;
                } else{
                    break;
                }
            } else{
                flag = true;
                break;
            }
        }
        return flag;
    }
}
