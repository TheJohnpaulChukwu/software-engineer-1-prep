package com.jworks.algo;

public class TreeNode<T> {
     T data;
     TreeNode<T> left;
     TreeNode<T> right;

     public TreeNode(T data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }

    public T getData() {
        return data;
    }

    public TreeNode<T> getLeft() {
        return left;
    }

    public TreeNode<T> getRight() {
        return right;
    }

    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    public void setRight(TreeNode<T> right) {
        this.right = right;
    }

    // Helper method to print the tree in-order (left-root-right) for testing
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (left != null) sb.append(left).append(", ");
        sb.append(data);
        if (right != null) sb.append(", ").append(right);
        return sb.toString();
    }
}