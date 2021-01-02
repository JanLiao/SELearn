package com.janliao.leetcode;

public class MergeKSortedLists2 {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);
        ListNode n8 = new ListNode(8);
        ListNode n9 = new ListNode(9);
        ListNode n10 = new ListNode(10);
        n1.next = n2;n2.next = n3;n3.next = n4;
        n5.next = n6;n6.next = n7;
        n8.next = n9;
        ListNode[] arr = {n1, n5, n8, n10};
        ListNode res = new MergeKSortedLists2().mergeKLists(arr);
        while(res != null){
            System.out.println(res.val);
            res = res.next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 1) return lists[0];
        if(lists.length == 0) return null;
        while(lists.length > 1){
            int lens = lists.length;
            ListNode[] arr = null;
            if((lens & 1) == 1){
                arr = new ListNode[lens / 2 + 1];
                int idx = 0;
                for(int i = 0; i < (lens - 1) / 2; i++){
                    ListNode p = mergeTwoLists(lists[2 * i], lists[2 * i + 1]);
                    arr[idx++] = p;
                }
                arr[idx] = lists[lens - 1];
                lists = arr;
            } else {
                arr = new ListNode[lens / 2];
                int idx = 0;
                for(int i = 0; i < lens / 2; i++){
                    ListNode p = mergeTwoLists(lists[2 * i], lists[2 * i + 1]);
                    arr[idx++] = p;
                }
                lists = arr;
            }
        }
        return lists[0];
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
