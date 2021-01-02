package com.janliao.compare;

class Node{
    public int value;
    public Node left;
    public Node right;
    public Node(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
    public Node getLeft() {
        return left;
    }
    public void setLeft(Node left) {
        this.left = left;
    }
    public Node getRight() {
        return right;
    }
    public void setRight(Node right) {
        this.right = right;
    }
}
public class Reverse {
    public static void main(String[] args) {
        float f = 3.4f;
        long a = 20;
        int b = 10;
        System.out.println(Integer.MAX_VALUE);
        Node n1 = new Node(4);
        Node n2 = new Node(1);
        Node n3 = new Node(2);
        Node n4 = new Node(3);
        Node n5 = new Node(6);
        Node n6 = new Node(7);
        Node n7 = new Node(9);
        n1.left = n4;n1.right = n6;
        n4.left = n2;n4.right = n3;
        n6.left = n5;n6.right = n7;
        n2.left = null;n2.right = null;
        n3.left = null;n3.right = null;
        n5.left = null;n5.right = null;
        n7.left = null;n7.right = null;
        //print(n1);
        Node res = new Reverse().reverse(n1);
        print(res);
    }
    private Node reverse(Node root) {
        if(root == null){
            return null;
        }
        // 后序遍历递归
        Node left = root.left;
        Node right = root.right;
        reverse(left);
        reverse((right));
        root.left = right;
        root.right = left;
        return root;
    }
    private static void print(Node res) {
        if(res == null) return;
        // 前序遍历打印
        System.out.println(res.value);
        print(res.left);
        print(res.right);
    }
}
