package com.jworks.algo.twopointers;

import java.util.Arrays;

public class SumOfThree {

    /*
    *
    * Given an array of integers, nums, and an integer value, target, determine if there are any three integers
    *  in nums whose sum is equal to the target, that is, nums[i] + nums[j] + nums[k] == target.
    * Return TRUE if three such integers exist in the array. Otherwise, return FALSE.
    *
    *
    * 3,7,1,2,8,4,5
    * 1,2,3,4,5,7,8
    * */

    /**
     * Approach: Two Pointers Technique
     *
     * 1. Sort the array:
     *    - Sorting ensures the array is in ascending order, which is necessary for the two-pointer technique.
     *    - This allows us to efficiently move pointers to find the required sum.
     *
     * 2. Iterate through the array:
     *    - Use a loop to select the first element of the triplet (nums[i]).
     *    - Stop the loop at nums.length - 2 since we need at least two more elements to form a triplet.
     *
     * 3. Initialize two pointers:
     *    - Set `left` to the element immediately after `nums[i]` (i.e., i + 1).
     *    - Set `right` to the last element of the array.
     *
     * 4. Check the sum of the triplet:
     *    - Calculate the sum of nums[i], nums[left], and nums[right].
     *    - If the sum matches the target, return true.
     *    - If the sum is less than the target, move the `left` pointer one step to the right (to increase the sum).
     *    - If the sum is greater than the target, move the `right` pointer one step to the left (to decrease the sum).
     *
     * 5. Repeat until the two pointers meet:
     *    - Continue adjusting the `left` and `right` pointers until `left` >= `right`.
     *
     * 6. Move to the next iteration of the loop:
     *    - After processing nums[i], move to the next element in the array and repeat the process.
     *
     * 7. Return false if no triplet is found:
     *    - If the loop completes and no triplet with the desired sum is found, return false.
     *
     * Time Complexity:
     * - Sorting takes O(n log n).
     * - The two-pointer search within the loop runs in O(n^2).
     * - Total time complexity: O(n^2).
     *
     * Space Complexity:
     * - Only a constant amount of extra space is used: O(1).
     */


    public static void main(String[] args) {
        // Test cases
        int[][] testCases = {
                {3, 7, 1, 2, 8, 4, 5}, // Regular case with positive numbers
                {-1, 2, 1, -4, 6, 3},   // Mixed positive and negative numbers
                {0, 0, 0, 0},           // All zeros
                {1, 1, 1, 1},           // All identical numbers but target can't be met
                {5},                    // Single element array
                {},                     // Empty array
                {3, 7, 1, 2, 8, 4, 5, 10, 12, 14, 20}, // Larger array with no solution
        };

        int[] targets = {20, 4, 0, 10, 5, 3, 50};
        boolean[] expectedResults = {true, true, true, false, false, false, false};

        // Run test cases
        for (int i = 0; i < testCases.length; i++) {
            boolean result = SumOfThree.findSumOfThree(testCases[i], targets[i]);
            boolean isCorrect = result == expectedResults[i];

            System.out.println("Test case " + (i + 1) + ":");
            System.out.println("Array: " + Arrays.toString(testCases[i]));
            System.out.println("Target: " + targets[i]);
            System.out.println("Expected Result: " + expectedResults[i]);
            System.out.println("Actual Result: " + result);
            System.out.println("Method Correct: " + (isCorrect ? "Yes" : "No"));
            System.out.println("------------------------------------------------");
        }
    }

    public static boolean naiveApproachFindSumOfThree(int[] nums, int target) {

        int length  = nums.length;

        for (int i = 0; i < length - 2; i++) {

            for (int j = i + 1; i < length - 1; i++) {

                for (int k =  j + 1; i < length; i++) {
                    int sum = nums [i] + nums [j] + nums[k];

                    if(target == sum) return true;
                }
            }

        }

        return false;
    }
    public static boolean findSumOfThree(int[] nums, int target) {

        Arrays.sort(nums);

        int sum,left,right;


        //we loop till length -2 because we don't want left, right to ever be equals to i
        for (int i = 0; i < nums.length - 2; i++) {

             left = i+1;
             right = nums.length -1;

             while (left < right){
                 sum = nums[i] + nums[left] + nums[right];

                 if(target == sum){
                     return true;
                 }else if(sum < target){
                     left++;
                 }else{
                     right--;
                 }
             }
        }

        return false;
    }
}
