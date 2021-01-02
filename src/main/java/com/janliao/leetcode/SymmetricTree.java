package com.janliao.leetcode;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val){
        this.val = val;
    }
}
public class SymmetricTree {
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
        boolean res = new SymmetricTree().isSymmetric(n1);
        System.out.println(res);
    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
//        if(root.left == null && root.right == null) return true;
//        if(root.left == null && root.right != null) return false;
//        if(root.left != null && root.right == null) return false;
//        if(root.left.val != root.right.val) return false;
        return isMirror(root.left, root.right);
    }

    public boolean isMirror(TreeNode l1, TreeNode l2){
        if(l1 == null && l2 == null) return true;
        if(l1 == null && l2 != null) return false;
        if(l1 != null && l2 == null) return false;
        if(l1.val != l2.val) return false;
        boolean left = isMirror(l1.left, l2.right);
        boolean right = isMirror(l1.right, l2.left);
        return left && right;
    }
}
