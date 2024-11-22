package com.jworks.algo.fastandslowpointers;

import java.util.HashSet;

public class HappyNumber {

    /*
    Any number will be called a happy number if, after repeatedly replacing it with a number equal to the sum of
     the square of all of its digits, leads us to number ‘1’. All other (not-happy) numbers will never reach ‘1’.
     Instead, they will be stuck in a cycle of numbers which does not include ‘1’.
    * */

    /**
     * The Happy Number problem is solved using the Fast and Slow Pointers pattern.
     * <p>
     * Approach:
     * 1. A number is called "happy" if repeatedly replacing it with the sum of the squares
     * of its digits eventually leads to 1. If it enters a cycle that does not include 1,
     * it is not a happy number.
     * <p>
     * 2. To detect whether the process leads to 1 or enters a cycle, we use two pointers:
     * - Slow Pointer: Moves one step at a time (calculates the sum of squares of digits once).
     * - Fast Pointer: Moves two steps at a time (calculates the sum of squares of digits twice).
     * <p>
     * 3. The steps involved are:
     * - Initialize both pointers to the input number.
     * - In a loop, update the slow pointer once and the fast pointer twice using the
     * helper method `findSquareSum`.
     * - If the two pointers meet, it means the process has entered a cycle.
     * - Exit the loop and check if the slow pointer equals 1.
     * <p>
     * 4. The helper method `findSquareSum` computes the sum of squares of the digits of a number:
     * - Extract each digit using modulo 10.
     * - Square the digit and add it to the sum.
     * - Remove the last digit using integer division by 10.
     * <p>
     * 5. If the slow pointer equals 1 at the end of the loop, the number is a happy number.
     * Otherwise, it is not a happy number (it is stuck in a cycle).
     * <p>
     * Time Complexity:
     * - Each step reduces the number towards 1 or a cycle. Since there are a limited number
     * of unique sums possible for digits (based on the properties of numbers), the algorithm
     * runs in constant time.
     * <p>
     * Space Complexity:
     * - O(1) as we only use two variables (fastPointer and slowPointer) for tracking state.
     */


    public static void main(String[] args) {
        System.out.println(HappyNumber.find(23));
        System.out.println(HappyNumber.find(12));
    }


    public static boolean find(int num) {

        int fastPointer = num, slowPointer = num;

        do{

            slowPointer = findSquareSum(slowPointer);
            fastPointer = findSquareSum(findSquareSum(fastPointer));
        }while (fastPointer != slowPointer);

        return slowPointer == 1;
    }

    /*
     * The brute force approach to check if a number is happy:
     * - Repeatedly calculate the sum of the squares of its digits.
     * - Store each computed sum in a HashSet.
     * - If the sum is already present in the HashSet, a cycle is detected, and the number is not happy.
     * - If the sum converges to 1, the number is happy.
     */
    public static boolean findNaive(int num) {
        HashSet<Integer> seenSums = new HashSet<>();

        while (num != 1 && !seenSums.contains(num)) {
            seenSums.add(num); // Add the current number to the set
            num = findSquareSum(num); // Compute the next sum of squares
        }

        return num == 1; // If num equals 1, it is a happy number
    }

    private static int findSquareSum(int num) {

        int digit;
        int sum = 0;
        while(num > 0){

            digit = num % 10;// Get the last digit
            sum += digit * digit;// Add the square of the digit to the sum
            num = num / 10;// Remove the last digit
        }

        return sum;
    }
}
