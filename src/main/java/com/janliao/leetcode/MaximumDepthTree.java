package com.janliao.leetcode;

public class MaximumDepthTree {
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
        int res = new MaximumDepthTree().maxDepth(n1);
        System.out.println(res);
    }

    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}
