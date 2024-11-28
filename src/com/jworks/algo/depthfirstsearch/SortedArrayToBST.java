package com.jworks.algo.depthfirstsearch;


import com.jworks.algo.TreeNode;

public class SortedArrayToBST {

    /**
     * Approach to Construct a Height-Balanced BST from a Sorted Array:
     *
     * A height-balanced Binary Search Tree (BST) is a tree where the difference in height
     * between the left and right subtrees of any node is at most 1.
     *
     * To construct a height-balanced BST from a sorted array:
     *
     * 1. **Divide and Conquer**:
     *    - The middle element of the array naturally becomes the root of the tree,
     *      ensuring the left and right subtrees are of roughly equal size.
     *    - The elements to the left of the middle form the left subtree.
     *    - The elements to the right of the middle form the right subtree.
     *
     * 2. **Recursive Construction**:
     *    - Use a helper function that takes the start and end indices of the subarray:
     *         a. Base Case: If the subarray is empty (start > end), return null.
     *         b. Recursive Case:
     *              - Select the middle element as the root.
     *              - Recursively construct the left subtree with the left half of the array.
     *              - Recursively construct the right subtree with the right half of the array.
     *
     * 3. **Why This Works**:
     *    - The middle element ensures the tree remains balanced.
     *    - Recursively dividing the array ensures that all nodes are processed,
     *      and the tree is constructed efficiently.
     *
     * Runtime Complexity:
     *    - The array is divided into halves at each recursive step.
     *    - Each element is processed once during the recursion.
     *    - Total runtime: **O(n)**, where n is the length of the array.
     *
     * Space Complexity:
     *    - The recursion stack height corresponds to the height of the tree.
     *    - For a balanced tree, the height is **O(log n)**.
     *    - Total space complexity: **O(log n)** (recursion stack).
     */
    public static TreeNode<Integer> sortedArrayToBST(int[] nums) {
        return convertToBST(nums, 0, nums.length - 1);
    }


    public static TreeNode<Integer> convertToBST(int[] nums, int start, int end){

        if(start > end){
            return null;
        }

        int mid = start + (end - start) / 2;

        TreeNode<Integer> root =new TreeNode<>(nums[mid]);

        TreeNode<Integer> leftNode = convertToBST(nums, start, mid - 1);
        TreeNode<Integer> rightNode = convertToBST(nums, mid + 1, end);
        root.setLeft(leftNode);
        root.setLeft(rightNode);

        return root;

    }

    public static void main(String[] args) {
        // Test cases
        int[][] testInputs = {
                {-10, -3, 0, 5, 9},    // Test 1
                {1, 2, 3, 4, 5},       // Test 2
                {0},                   // Test 3
                {-5, -3, -1},          // Test 4
                {-10, -5, -1, 0, 3, 5} // Test 5
        };

        String[] expectedOutputs = {
                "-10, -3, 0, 5, 9",    // Expected for Test 1
                "1, 2, 3, 4, 5",       // Expected for Test 2
                "0",                   // Expected for Test 3
                "-5, -3, -1",          // Expected for Test 4
                "-10, -5, -1, 0, 3, 5" // Expected for Test 5
        };

        int passedCount = 0;

        System.out.println("Starting tests...");

        for (int i = 0; i < testInputs.length; i++) {
            TreeNode<Integer> root = sortedArrayToBST(testInputs[i]);
            String actualOutput = root.toString(); // Use in-order traversal to verify structure
            boolean passed = actualOutput.equals(expectedOutputs[i]);

            System.out.println("Test " + (i + 1) + ":");
            System.out.println("Input: " + java.util.Arrays.toString(testInputs[i]));
            System.out.println("Expected Output: " + expectedOutputs[i]);
            System.out.println("Actual Output: " + actualOutput);
            System.out.println("Test " + (passed ? "PASSED" : "FAILED"));
            System.out.println();

            if (passed) {
                passedCount++;
            }
        }

        System.out.println("Tests Completed: " + passedCount + " out of " + testInputs.length + " tests passed.");
    }

}