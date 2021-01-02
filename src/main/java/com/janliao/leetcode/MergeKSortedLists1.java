package com.janliao.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedLists1 {
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
        ListNode res = new MergeKSortedLists1().mergeKLists(arr);
        while(res != null){
            System.out.println(res.val);
            res = res.next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        Comparator<ListNode> cmp = new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        };
        ListNode head = new ListNode(0);
        ListNode pre = head;
        Queue<ListNode> queue = new PriorityQueue<>(cmp);
        for(ListNode node : lists){
            if(node != null){
                queue.add(node);
            }
        }
        while(!queue.isEmpty()){
            ListNode node = queue.poll();
            head.next = node;
            head = head.next;
            if(node != null){
                if(node.next != null){
                    queue.add(node.next);
                }
            }
        }
        return pre.next;
    }
}
