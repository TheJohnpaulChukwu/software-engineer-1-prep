package com.jworks.algo.twopointers;

import java.util.Arrays;

public class PairwithTargetSum {

    /*
    * Given an array of sorted numbers and a target sum,
    * find a pair in the array whose sum is equal to the given target.
    *
    *   Input: [1, 2, 3, 4, 6], target=6
        Output: [1, 3]
        Explanation: The numbers at index 1 and 3 add up to 6: 2+4=6
     *
    * */

    public static void main(String[] args) {
        // Test input
        int[] arr = {1, 2, 3, 4, 6};
        int targetSum = 6;

        // Test the Naive Approach
        int[] resultNaive = searchNaiveApproach(arr, targetSum);
        System.out.println("Naive Approach Result: " + Arrays.toString(resultNaive));

        // Test the More Optimal Approach
        int[] resultOptimal = searchMoreOptimalApproach(arr, targetSum);
        System.out.println("More Optimal Approach Result: " + Arrays.toString(resultOptimal));
    }


    public static int[] searchNaiveApproach(int[] arr, int targetSum) {

        int length = arr.length;

        for (int i = 0; i < length; i++) {

            for (int j = 0; j < length; j++) {

                if(arr[i] + arr[j] == targetSum){
                    return new int[]{i,j};
                }
            }
        }

        //nothing found
        return new int[]{-1,-1};
    }

    public static int[] searchMoreOptimalApproach(int[] arr, int targetSum) {

        int length = arr.length;

        int leftPointer = 0;
        int rightPointer = length - 1;

        for (int i = 0; i < length; i++) {

            int currentLeftValue = arr[leftPointer];
            int currentRightValue = arr[rightPointer];

            int sumValue = currentLeftValue + currentRightValue;

            if(sumValue == targetSum){
                return new int[]{leftPointer,rightPointer};
            }else if(sumValue > targetSum){
                rightPointer -=1;
            }else {
                leftPointer +=1;
            }
        }

        return new int[]{-1,-1};
    }
}
