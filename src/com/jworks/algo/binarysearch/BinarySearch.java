package com.jworks.algo.binarysearch;

public class BinarySearch{

    public static int binarySearch (int []nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end){

            int middle = start + (end - start) / 2;

            // Check if target is found
            if (nums[middle] == target) {
                return middle;
            }

            if(target > nums[middle]){
                start = middle + 1;
            }else{
                end = middle -1;
            }

        }

        // If target is not found
        return -1;
    }
}