package com.janliao.leetcode;

import java.util.List;

public class MiddleLinkedList {
    public static void main(String[] args) {

    }

    public ListNode middleNode(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;
        //if(head.next.next == null) return head.next;
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
