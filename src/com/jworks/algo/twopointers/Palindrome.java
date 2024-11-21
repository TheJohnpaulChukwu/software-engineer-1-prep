package com.jworks.algo.twopointers;

public class Palindrome {

    /**
     * Approach Explanation:
     *
     * 1. Two Pointers Technique:
     *    - The algorithm uses two pointers: `p1` starts from the beginning of the string,
     *      and `p2` starts from the end.
     *    - These pointers move towards the center of the string.
     *
     * 2. Comparison Logic:
     *    - At each step, the characters at `p1` and `p2` are compared.
     *    - If the characters differ, the string is not a palindrome, and the method returns `false` immediately.
     *    - If the characters match, the pointers are moved closer to each other (`p1` is incremented, and `p2` is decremented).
     *
     * 3. Stopping Condition:
     *    - The loop stops when `p1` is no longer less than `p2`, which means the entire string
     *      has been successfully checked, and it is a palindrome.
     *
     * 4. Return Result:
     *    - If all characters match, the method returns `true`.
     */

    public static void main(String[] args) {
        // Test cases
        String testString1 = "hello";
        String testString2 = "madam";
        String testString3 = "racecar";
        String testString4 = "world";

        // Test reverseString method
        System.out.println("Testing reverseString method:");
        System.out.println("Original: " + testString1 + " | Reversed: " + reverseString(testString1));
        System.out.println("Original: " + testString3 + " | Reversed: " + reverseString(testString3));

        // Test isPalindrome method
        System.out.println("\nTesting isPalindrome method:");
        System.out.println(testString2 + " is palindrome: " + Palindrome.isPalindromeOptimal(testString2));
        System.out.println(testString4 + " is palindrome: " + Palindrome.isPalindromeOptimal(testString4));
    }


    public static String reverseString(String s) {
        StringBuilder reversed = new StringBuilder();

        for (int i = s.length() - 1; i >= 0; i--) {
            reversed.append(s.charAt(i));
        }

        return reversed.toString();
    }

    public static boolean naiveIsPalindrome(String word){

        String reversedWord = reverseString(word);

        return reversedWord.equals(word);

    }

    public static boolean isPalindromeOptimal(String s) {
        /*

        * We make use of two pointers P1 and P2
        * P1 starts from the beginning of the string
        * P2 starts from the end of the string
        *
        * At each iteration we compare P1 and P2
        * if P2 does not P1 at any point we return false
        *
        * if P1 and P2 match and are both are the middle we return true
        * */


        int p1 = 0;
        int p2 = s.length() - 1;

       while (p2 > p1){

           if(s.charAt(p2) != s.charAt(p1)){
               return false;
           }

           p2--;
           p1++;

       }

       return true;
    }
}
