package com.janliao.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree1 {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(2);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(3);
        TreeNode n8 = new TreeNode(5);
        TreeNode n9 = new TreeNode(5);
        n1.left = n2;n1.right = n3;
        n2.left = n4;n2.right = n5;
        n3.left = n6;n3.right = n7;
        n4.left = n8;n7.right = n9;
        boolean res = new SymmetricTree1().isSymmetric(n1);
        System.out.println(res);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();
            if(t1 == null && t2 == null) continue;
            if(t1 == null || t2 == null) return false;
            if(t1.val != t2.val) return false;
            queue.add(t1.left);
            queue.add(t2.right);
            queue.add(t1.right);
            queue.add(t2.left);
        }
        return true;
    }

    public boolean isSymmetric1(TreeNode root){
        if(root == null) return true;
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.add(root.left);
        queue1.add(root.right);
        while(queue1.size() > 0 || queue2.size() > 0){
            if(queue1.size() > 0){
                TreeNode[] arr = new TreeNode[queue1.size()];
                int idx = 0;
                while(!queue1.isEmpty()){
                    TreeNode tmp = queue1.poll();
                    arr[idx++] = tmp;
                    if(tmp != null){
                        queue2.add(tmp.left);
                        queue2.add(tmp.right);
                    }
                }
                if(!checkArr(arr)) return false;
            }
            if(queue2.size() > 0){
                TreeNode[] arr = new TreeNode[queue2.size()];
                int idx = 0;
                while(!queue2.isEmpty()){
                    TreeNode tmp = queue2.poll();
                    arr[idx++] = tmp;
                    if(tmp != null){
                        queue1.add(tmp.left);
                        queue1.add(tmp.right);
                    }
                }
                if(!checkArr(arr)) return false;
            }
        }
        return true;
    }

    public boolean checkArr(TreeNode[] arr){
        int lens = arr.length;
        for(int i = 0; i < lens / 2; i++){
            TreeNode t1 = arr[i];
            TreeNode t2 = arr[lens - i - 1];
            if(t1 == null && t2 == null){
                continue;
            } else if(t1 == null && t2 != null){
                return false;
            } else if(t1 != null && t2 == null){
                return false;
            } else {
                if(t1.val == t2.val){
                    continue;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
