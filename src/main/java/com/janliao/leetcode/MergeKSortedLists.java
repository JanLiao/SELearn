package com.janliao.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedLists {
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
        ListNode res = new MergeKSortedLists().mergeKLists(arr);
        while(res != null){
            System.out.println(res.val);
            res = res.next;
        }
        PriorityQueue<ListNode> q = new PriorityQueue<ListNode>();
        q.add(n1);
        q.poll();
    }

    public ListNode mergeKLists(ListNode[] lists) {
        // 哨兵节点
        ListNode head = new ListNode(0);
        ListNode pre = head;
        while(!checkNull(lists)){
            ListNode n1 = check3Null(lists);
            if(n1 == null){
                if(get4Null(lists) != lists.length){
                    ListNode n2 = getListNode(lists);
                    //System.out.println("ts = " + n2.val);
                    head.next = n2;
                    head = head.next;
                }
            } else {
                head.next = n1;
                break;
            }
        }
        return pre.next;
    }
    public ListNode getListNode(ListNode[] lists){
        ListNode node = null;
        int idx = 0;
        for(int i = 0; i < lists.length; i++){
            ListNode n = lists[i];
            if(n != null){
                if(node == null){
                    node = n;
                    idx = i;
                } else {
                    if(n.val < node.val){
                        node = n;
                        idx = i;
                        //n = n.next;
                    }
                }
            }
        }
        ListNode res = node;
        ListNode tmp = lists[idx];
        lists[idx] = tmp.next;
        return res;
    }
    public int get4Null(ListNode[] lists){
        int sum = 0;
        for(ListNode node : lists){
            if(node == null){
                sum++;
            }
        }
        return sum;
    }
    public ListNode check3Null(ListNode[] lists){
        int sum = 0;
        int idx = 0;
        for(int i = 0; i < lists.length; i++){
            ListNode node = lists[i];
            if(node == null){
                sum++;
            } else {
                idx = i;
            }
        }
        if(sum == lists.length - 1){
            return lists[idx];
        }
        return null;
    }
    public boolean checkNull(ListNode[] list){
        for(ListNode node : list){
            if(node != null){
                return false;
            }
        }
        return true;
    }
}
