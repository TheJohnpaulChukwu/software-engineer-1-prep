package com.jworks.algo.breadthfirstsearch;

import com.jworks.algo.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class BFSIsSymmetric {


    /*
     * Approach:
     * The problem involves checking whether a binary tree is symmetric around its root.
     * We use an iterative Breadth-First Search (BFS) approach with a queue to compare nodes level by level:
     *
     * 1. **Initialization**:
     *    - If the tree is empty (root is null), it is symmetric, so return true.
     *    - Otherwise, initialize a queue and enqueue the left and right children of the root.
     *
     * 2. **Iterative BFS**:
     *    - Dequeue two nodes at a time (node1 and node2) and compare them:
     *      - If both are null, continue to the next pair in the queue.
     *      - If only one is null or their values are not equal, the tree is not symmetric; return false.
     *    - Enqueue the children of these nodes in mirrored order:
     *      - Left child of node1 with right child of node2.
     *      - Right child of node1 with left child of node2.
     *
     * 3. **Completion**:
     *    - If all node pairs are processed without mismatch, the tree is symmetric, so return true.
     *
     * Explanation:
     * This approach simulates a level-by-level traversal using a queue, ensuring that corresponding nodes
     * in the left and right subtrees are checked for symmetry.
     *
     * Time Complexity: O(n)
     * - Each node is enqueued and dequeued exactly once, resulting in O(n) operations, where n is the total number of nodes.
     *
     * Space Complexity: O(n)
     * - The queue can hold up to n/2 nodes at the widest level of the tree (typically the bottom level), leading to O(n) space usage.
     *
     * This method ensures efficient traversal while maintaining simplicity and avoiding recursion, making it suitable for large trees.
     */

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.getLeft());
        queue.add(root.getRight());

        while (!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();

            // If both are null, continue
            if (node1 == null && node2 == null) continue;

            // If only one is null or values are not the same, it's not symmetric
            if (node1 == null || node2 == null || !node1.getData().equals(node2.getData())) return false;

            // Enqueue children in mirrored order
            queue.add(node1.getLeft());
            queue.add(node2.getRight());
            queue.add(node1.getRight());
            queue.add(node2.getLeft());
        }

        return true;
    }

    public static void main(String[] args) {
        BFSIsSymmetric solution = new BFSIsSymmetric();

        // Test 1: Symmetric Tree
        TreeNode root1 = new TreeNode(1);
        root1.setLeft(new TreeNode(2));
        root1.setRight(new TreeNode(2));
        root1.getLeft().setLeft(new TreeNode(3));
        root1.getLeft().setRight(new TreeNode(4));
        root1.getRight().setLeft(new TreeNode(4));
        root1.getRight().setRight(new TreeNode(3));
        boolean result1 = solution.isSymmetric(root1);
        System.out.println("Test 1: Symmetric Tree - Expected: true, Actual: " + result1 + " - " + (result1 == true ? "Passed" : "Failed"));

        // Test 2: Non-Symmetric Tree
        TreeNode root2 = new TreeNode(1);
        root2.setLeft(new TreeNode(2));
        root2.setRight(new TreeNode(2));
        root2.getLeft().setRight(new TreeNode(3));
        root2.getRight().setRight(new TreeNode(3));
        boolean result2 = solution.isSymmetric(root2);
        System.out.println("Test 2: Non-Symmetric Tree - Expected: false, Actual: " + result2 + " - " + (result2 == false ? "Passed" : "Failed"));

        // Test 3: Single Node Tree
        TreeNode root3 = new TreeNode(1);
        boolean result3 = solution.isSymmetric(root3);
        System.out.println("Test 3: Single Node Tree - Expected: true, Actual: " + result3 + " - " + (result3 == true ? "Passed" : "Failed"));

        // Test 4: Empty Tree
        TreeNode root4 = null;
        boolean result4 = solution.isSymmetric(root4);
        System.out.println("Test 4: Empty Tree - Expected: true, Actual: " + result4 + " - " + (result4 == true ? "Passed" : "Failed"));

        // Test 5: Larger Symmetric Tree
        TreeNode root5 = new TreeNode(1);
        root5.setLeft(new TreeNode(2));
        root5.setRight(new TreeNode(2));
        root5.getLeft().setLeft(new TreeNode(3));
        root5.getLeft().setRight(new TreeNode(4));
        root5.getRight().setLeft(new TreeNode(4));
        root5.getRight().setRight(new TreeNode(3));
        root5.getLeft().getLeft().setLeft(new TreeNode(5));
        root5.getRight().getRight().setRight(new TreeNode(5));
        boolean result5 = solution.isSymmetric(root5);
        System.out.println("Test 5: Larger Symmetric Tree - Expected: true, Actual: " + result5 + " - " + (result5 == true ? "Passed" : "Failed"));

        // Summary of Tests
        int passed = 0;
        passed += (result1 == true) ? 1 : 0;
        passed += (result2 == false) ? 1 : 0;
        passed += (result3 == true) ? 1 : 0;
        passed += (result4 == true) ? 1 : 0;
        passed += (result5 == true) ? 1 : 0;

        System.out.println("\nTotal Tests Passed: " + passed + " out of 5");
    }
}