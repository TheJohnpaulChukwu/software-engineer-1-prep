package com.jworks.algo.breadthfirstsearch;

import com.jworks.algo.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class BFSTraversal {

    /*
     * Approach:
     * This method performs a level order traversal (Breadth-First Search) on a binary tree.
     * - If the tree is empty (root is null), return "None".
     * - Otherwise, use a queue to traverse the tree level by level.
     * - Append node values separated by commas for the same level and colons for different levels.
     *
     * Steps:
     * 1. Initialize an empty queue and add the root node to it.
     * 2. Use a loop to process nodes level by level.
     * 3. For each level, enqueue its child nodes and append values to the result string in the required format.
     * 4. Return the formatted result string.
     *
     * Time Complexity: O(n)
     * - Each node is enqueued and dequeued exactly once, where n is the number of nodes.
     *
     * Space Complexity: O(n)
     * - The queue holds up to n/2 nodes at the last level in the worst case for a complete binary tree.
     */

    public static String levelOrderTraversal(TreeNode<Integer> root) {
        if (root == null) {
            return "None"; // If the tree is empty, return "None".
        }

        StringBuilder result = new StringBuilder();
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root); // Start with the root node.

        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // Number of nodes at the current level.
            StringBuilder levelResult = new StringBuilder();

            for (int i = 0; i < levelSize; i++) {
                TreeNode<Integer> currentNode = queue.poll();

                // Append the current node's value to the level result.
                levelResult.append(currentNode.getData());
                if (i < levelSize - 1) {
                    levelResult.append(", "); // Add a comma for all but the last node in the level.
                }

                // Enqueue the left and right children if they exist.
                if (currentNode.getLeft() != null) {
                    queue.add(currentNode.getLeft());
                }
                if (currentNode.getRight() != null) {
                    queue.add(currentNode.getRight());
                }
            }

            // Append the level result to the main result, separated by a colon if there are more levels.
            result.append(levelResult);
            if (!queue.isEmpty()) {
                result.append(" : ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        // Test cases to validate the implementation
        int passedTests = 0;

        // Test 1: Non-Empty Tree
        TreeNode<Integer> root1 = new TreeNode<>(100);
        root1.setLeft(new TreeNode<>(50));
        root1.setRight(new TreeNode<>(200));
        root1.getLeft().setLeft(new TreeNode<>(25));
        root1.getLeft().setRight(new TreeNode<>(75));
        root1.getRight().setLeft(new TreeNode<>(300));
        root1.getRight().setRight(new TreeNode<>(10));
        String result1 = levelOrderTraversal(root1);
        System.out.println("Test 1: Non-Empty Tree - Expected: 100 : 50, 200 : 25, 75, 300, 10, Actual: " + result1);
        if (result1.equals("100 : 50, 200 : 25, 75, 300, 10")) passedTests++;

        // Test 2: Single Node Tree
        TreeNode<Integer> root2 = new TreeNode<>(1);
        String result2 = levelOrderTraversal(root2);
        System.out.println("Test 2: Single Node Tree - Expected: 1, Actual: " + result2);
        if (result2.equals("1")) passedTests++;

        // Test 3: Empty Tree
        TreeNode<Integer> root3 = null;
        String result3 = levelOrderTraversal(root3);
        System.out.println("Test 3: Empty Tree - Expected: None, Actual: " + result3);
        if (result3.equals("None")) passedTests++;

        // Test 4: Unbalanced Tree
        TreeNode<Integer> root4 = new TreeNode<>(1);
        root4.setRight(new TreeNode<>(2));
        root4.getRight().setRight(new TreeNode<>(3));
        String result4 = levelOrderTraversal(root4);
        System.out.println("Test 4: Unbalanced Tree - Expected: 1 : 2 : 3, Actual: " + result4);
        if (result4.equals("1 : 2 : 3")) passedTests++;

        // Test 5: Larger Tree
        TreeNode<Integer> root5 = new TreeNode<>(10);
        root5.setLeft(new TreeNode<>(5));
        root5.setRight(new TreeNode<>(15));
        root5.getLeft().setLeft(new TreeNode<>(3));
        root5.getLeft().setRight(new TreeNode<>(7));
        root5.getRight().setLeft(new TreeNode<>(12));
        root5.getRight().setRight(new TreeNode<>(18));
        String result5 = levelOrderTraversal(root5);
        System.out.println("Test 5: Larger Tree - Expected: 10 : 5, 15 : 3, 7, 12, 18, Actual: " + result5);
        if (result5.equals("10 : 5, 15 : 3, 7, 12, 18")) passedTests++;

        // Summary of Results
        System.out.println("\nTotal Tests Passed: " + passedTests + " out of 5");
    }
}