package com.janliao.leetcode;

public class MergeTwoSortedLists1 {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;n2.next = n3;n3.next = n4;
        ListNode n5 = new ListNode(1);
        ListNode n6 = new ListNode(3);
        ListNode n7 = new ListNode(5);
        ListNode n8 = new ListNode(7);
        ListNode n9 = new ListNode(8);
        ListNode n10 = new ListNode(10);
        ListNode n11 = new ListNode(11);
        ListNode n12 = new ListNode(12);
        n5.next = n6;n6.next = n7;n7.next = n8;
        n8.next = n9;n9.next = n10;n10.next = n11;
        n11.next = n12;
        ListNode res = new MergeTwoSortedLists1().mergeTwoLists(n1, n5);
        while(res != null){
            System.out.println(res.val);
            res = res.next;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode head = null;
        if(l1.val < l2.val){
            head = l1;
            head.next = mergeTwoLists(l1.next, l2);
        } else {
            head = l2;
            head.next = mergeTwoLists(l1, l2.next);
        }
        return head;
    }
}
