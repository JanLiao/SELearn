package com.janliao.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LCABT {
    static List<TreeNode> list = new ArrayList<>();
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);
        n1.left = n2;n1.right = n3;
        n2.left = n4;n2.right = n5;
        n3.left = n6;n3.right = n7;
        n4.left = n8;n7.right = n9;
        TreeNode res = new LCABT().lowestCommonAncestor(n1, n6, n9);
        System.out.println(res.val);
//        boolean ress = new LCABT().isNode(n1, n9);
//        System.out.println(ress);
//        for(TreeNode n : list){
//            System.out.println(n.val);
//        }
    }

    public boolean isNode(TreeNode root, TreeNode p){
        if(root == null){
            return false;
        }
        if(root == p){
            list.add(root);
            return true;
        } else{
            boolean left = isNode(root.left, p);
            boolean right = isNode(root.right, p);
            if(left || right) {
                list.add(root);
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean isNode(TreeNode root, TreeNode p, List<TreeNode> list){
        if(root == null){
            return false;
        }
        if(root == p){
            list.add(root);
            return true;
        } else{
            boolean left = isNode(root.left, p, list);
            boolean right = isNode(root.right, p, list);
            if(left || right) {
                list.add(root);
                return true;
            } else {
                return false;
            }
        }
    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        //if(root.left == null || root.right == null) return root;
        List<TreeNode> list = new ArrayList<>();
        isNode(root, p, list);
        List<TreeNode> list1 = new ArrayList<>();
        isNode(root, q, list1);
        int i = list.size() - 1;
        int j = list1.size() - 1;
        while(i >= 0 && j >= 0){
            if(list.get(i) == list1.get(j)){
                i--;
                j--;
            } else {
                break;
            }
        }
        return list.get(i + 1);
    }

    private TreeNode node;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        //if(root.left == null || root.right == null) return root;
        checkCommonAncestor(root, p, q);
        return this.node;
    }

    public boolean checkCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return false;
        }
        boolean left = checkCommonAncestor(root.left, p, q);
        boolean right = checkCommonAncestor(root.right, p, q);
        boolean cur = (root == p || root == q);
        // pq位于root的左右两边
        if(left && right){
            this.node = root;
        }
        // pq中一节点为root节点
        if(cur && (left || right)){
            this.node = root;
        }
        return (left || right || cur);
    }
}
