package com.jworks.algo.depthfirstsearch;

import com.jworks.algo.TreeNode;

public class InversionOfTree {

//    Statement
//    Given the root node of a binary tree, transform the tree by swapping each node’s left and
//    right subtrees, thus creating a mirror image of the original tree. Return the root of the
//    transformed tree.



    public static TreeNode<Integer> invertTree(TreeNode<Integer> root){
       return performInvert(root);
    }


    private static TreeNode<Integer> performInvert(TreeNode<Integer> node){

        if(node == null){
            return null;
        }

        TreeNode<Integer> leftNode = performInvert(node.getLeft());
        TreeNode<Integer> rightNode = performInvert(node.getRight());

        node.setLeft(rightNode);
        node.setRight(leftNode);

        return node;
    }
}