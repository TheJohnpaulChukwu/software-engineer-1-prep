package com.jworks.algo.hashmaps;

import java.util.*;

public class NextGreater {


    /**
     * Efficient Approach: Stack + Hash Map
     * <p>
     * Description:
     * 1. Use a stack to efficiently find the next greater element for each number in nums2.
     * 2. Traverse nums2 from right to left:
     * - For each element, pop elements from the stack that are smaller (they cannot be the "next greater").
     * - The element at the top of the stack (if any) is the next greater element for the current number.
     * - Push the current number onto the stack for future comparisons.
     * 3. Store the results for nums2 in a hash map for quick lookups.
     * 4. Build the result array for nums1 by directly looking up precomputed values in the hash map.
     * <p>
     * Time Complexity:
     * - Processing nums2: O(n), where n = nums2.length. Each element is pushed and popped from the stack once.
     * - Building the result for nums1: O(m), where m = nums1.length.
     * Total: O(n + m).
     * <p>
     * Space Complexity:
     * - O(n) for the stack and hash map.
     * <p>
     * Best For:
     * - Large inputs where efficiency is important.
     */

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // Map to store the next greater element for each number in nums2
        Map<Integer, Integer> nextGreaterMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        // Precompute next greater elements for nums2
        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {
                nextGreaterMap.put(stack.pop(), num);
            }
            stack.push(num);
        }

        // Any remaining numbers in the stack don't have a greater element
        while (!stack.isEmpty()) {
            nextGreaterMap.put(stack.pop(), -1);
        }

        // Construct the result array for nums1
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = nextGreaterMap.get(nums1[i]);
        }

        return result;
    }

    /**
     * Naive Approach: Hash Map Alone
     * <p>
     * Description:
     * 1. Preprocess nums2:
     * - For each element in nums2, find its next greater element by scanning the array to the right.
     * - Store the result in a hash map, where the key is the number and the value is its next greater element.
     * - If no greater element exists, store -1.
     * 2. Build the result array for nums1 by looking up each element's next greater value in the hash map.
     * <p>
     * Time Complexity:
     * - Preprocessing nums2: O(n^2), where n = nums2.length, because for each element, we scan the remaining array.
     * - Building the result for nums1: O(m), where m = nums1.length.
     * Total: O(n^2 + m).
     * <p>
     * Space Complexity:
     * - O(n) for the hash map.
     * <p>
     * Best For:
     * - Simpler logic and small inputs, where performance is less critical.
     */

    public static int[] nextGreaterElementNaive(int[] nums1, int[] nums2) {

        HashMap<Integer, Integer> numMap = new HashMap<>();
        int[] result = new int[nums1.length];

        for (int i = 0; i < nums2.length; i++) {
            int numGreaterInListAfterIndex = getNumGreaterInListAfterIndex(i, nums2);
            numMap.put(nums2[i], numGreaterInListAfterIndex);
        }

        for (int i = 0; i < nums1.length; i++) {
            result[i] = numMap.get(nums1[i]);
        }

        return result;
    }

    private static int getNumGreaterInListAfterIndex(int curIndex, int[] arr) {
        int greaterNum = arr[curIndex];

        for (int i = curIndex + 1; i < arr.length; i++) {
            if (arr[i] > greaterNum) {
                greaterNum = arr[i];
                break;
            }
        }

        return greaterNum == arr[curIndex] ? -1 : greaterNum;
    }

    public static void main(String[] args) {
        NextGreater nextGreater = new NextGreater();

        // Define test cases
        int[][] nums1Cases = {
                {4, 1, 2},
                {2, 4},
                {1, 3},
                {1},
                {100}
        };
        int[][] nums2Cases = {
                {4, 1, 2, 3},
                {4, 3, 2, 1},
                {1, 2, 3, 4},
                {1, 3, 5},
                {50, 100, 150}
        };
        int[][] expectedResults = {
                {-1, 2, 3},
                {-1, -1},
                {2, 4},
                {3},
                {150}
        };

        // Run and compare each test case
        for (int i = 0; i < nums1Cases.length; i++) {
            int[] nums1 = nums1Cases[i];
            int[] nums2 = nums2Cases[i];
            int[] expected = expectedResults[i];

            // Get the actual result
            int[] actual = nextGreater.nextGreaterElement(nums1, nums2);

            // Print test case details and result
            System.out.println("Test Case " + (i + 1) + ":");
            System.out.println("  nums1: " + java.util.Arrays.toString(nums1));
            System.out.println("  nums2: " + java.util.Arrays.toString(nums2));
            System.out.println("  Expected: " + java.util.Arrays.toString(expected));
            System.out.println("  Actual:   " + java.util.Arrays.toString(actual));

            // Compare actual and expected values
            if (java.util.Arrays.equals(expected, actual)) {
                System.out.println("  Result: PASSED");
            } else {
                System.out.println("  Result: FAILED");
            }

            System.out.println(); // Blank line between test cases
        }
    }


}