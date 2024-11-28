package com.jworks.algo.depthfirstsearch;

import com.jworks.algo.TreeNode;

public class DiameterOfTree {

    /*
        Problem
    Given a binary tree, you need to compute the length of the tree’s diameter.
    The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
    This path may or may not pass through the root.
    Note: The length of the path between two nodes is represented by the number of edges between them.
     */


    /**
     * Approach to Solve Diameter of a Binary Tree:
     *
     * The diameter of a binary tree is the longest path between any two nodes in the tree.
     * This path may or may not pass through the root.
     *
     * To calculate the diameter, we use a recursive function with the following steps:
     *
     * 1. **Definition of Height**:
     *    - The height of a node is the number of edges on the longest path from that node to a leaf.
     *    - Example:
     *         For a node with no children, height = 0.
     *         For a node with two children, height = 1 + max(leftChildHeight, rightChildHeight).
     *
     * 2. **Diameter Through a Node**:
     *    - The diameter passing through a node is the sum of the heights of its left and right subtrees.
     *    - Formula: diameterThroughNode = leftHeight + rightHeight.
     *
     * 3. **Overall Diameter**:
     *    - The overall diameter for a node is the maximum of:
     *         a. The diameter passing through the current node.
     *         b. The maximum diameter in the left subtree.
     *         c. The maximum diameter in the right subtree.
     *
     * 4. **Recursive Function**:
     *    - Traverse the tree in a postorder manner (process children before the parent).
     *    - For each node:
     *         a. Recursively calculate the height of the left and right subtrees.
     *         b. Compute the diameter passing through the node.
     *         c. Find the maximum diameter by comparing the diameter through the node with diameters from the subtrees.
     *
     * 5. **Returning Values**:
     *    - The recursive function returns both:
     *         a. The height of the current node (used by its parent).
     *         b. The maximum diameter found in the subtree rooted at the current node.
     *
     * 6. **Final Result**:
     *    - The diameter of the entire tree is stored as the result of the root node's diameter calculation.
     *
     * Why This Approach Works:
     * - By calculating the height and diameter together, we efficiently ensure that every possible longest path
     *   in the tree is considered.
     * - The recursive structure allows us to traverse the tree in a clean and modular way.
     */
    public static int diameterOfBinaryTree(TreeNode<Integer> root) {
        return calculateHeight(root).diameter;

    }

    private static Result calculateHeight(TreeNode<Integer> node){
        if(node == null){
            return new Result(0,0);
        }

        Result left = calculateHeight(node.getLeft());
        Result right = calculateHeight(node.getRight());

        int height = 1+ Math.max(left.height,right.height);

        // Calculate the diameter passing through the current node
        int diameterThroughNode = left.height + right.height;


        // The maximum diameter is the largest among:
        // 1. Diameter through the current node
        // 2. The maximum diameter in the left subtree
        // 3. The maximum diameter in the right subtree
        int maxDiameter = Math.max(diameterThroughNode, Math.max(left.diameter, right.diameter));


        return new Result(height, maxDiameter);
    }

    // Helper class to store height and diameter together
    private static class Result {
        int height;
        int diameter;

        Result(int height, int diameter) {
            this.height = height;
            this.diameter = diameter;
        }
    }
}