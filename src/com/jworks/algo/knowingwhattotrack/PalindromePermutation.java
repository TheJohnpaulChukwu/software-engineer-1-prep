package com.jworks.algo.knowingwhattotrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PalindromePermutation {

    public static void main(String[] args) {
        // Test cases
        String[][] testCases = {
                {"civic", "true"},   // Already a palindrome
                {"ivicc", "true"},   // Can be rearranged to "civic"
                {"hello", "false"},  // Cannot form a palindrome
                {"aabb", "true"},  // Can be rearranged to "abba"
                {"racecar", "true"}, // Already a palindrome
                {"", "true"},        // Empty string is a palindrome
                {"abcdef", "false"}, // Cannot form a palindrome
                {"a", "true"},       // Single character is a palindrome
                {"abac", "false"},    // Can be rearranged to "abba"
                {"aabbccdde", "true"} // Too many odd frequencies
        };

        System.out.println("Running Test Cases for canPermutePalindrome:\n");

        // Run each test case
        for (String[] testCase : testCases) {
            String input = testCase[0];
            boolean expected = Boolean.parseBoolean(testCase[1]);
            boolean actual = permutePalindrome(input);

            // Print the result
            if (expected == actual) {
                System.out.println("✅ Test Passed | Input: '" + input + "' | Expected: " + expected + " | Actual: " + actual);
            } else {
                System.out.println("❌ Test Failed | Input: '" + input + "' | Expected: " + expected + " | Actual: " + actual);
            }
        }
    }

    /**
     * Optimal Approach:
     * - Use frequency counting to determine if the string can be rearranged into a palindrome.
     * - A string can form a palindrome if at most one character has an odd frequency.
     *
     * Steps:
     * 1. Count the frequency of each character in the string. This takes O(n) time for a string of length n.
     * 2. Traverse the frequency counts to count how many characters have odd frequencies. This takes O(1)
     *    because the character set (lowercase English letters) is fixed at 26.
     * 3. If there is more than one odd frequency, the string cannot be rearranged into a palindrome.
     *
     * Time Complexity: O(n)
     * - Efficient because it requires only a single traversal of the string and a fixed set of frequency checks.
     *
     * Space Complexity: O(1)
     * - Uses a fixed-size frequency array (of size 26 for lowercase English letters).
     *
     * Advantages:
     * - This approach is fast and scalable, suitable for real-world applications.
     * - It avoids the need to generate all permutations, making it much more efficient.
     */
    public static boolean permutePalindrome(String word) {
        HashMap<Character, Integer> hashMapDict = new HashMap<> ();
        for (int i = 0; i < word.length(); i++) {
            if (hashMapDict.containsKey(word.charAt(i))) {
                hashMapDict.put(word.charAt(i), hashMapDict.get(word.charAt(i)) + 1);
            }
            else {
                hashMapDict.put(word.charAt(i), 1);
            }
        }
        int oddFrequencyCount = 0;

        for (Integer characterCount : hashMapDict.values()) {
            if (characterCount % 2 != 0) {
                oddFrequencyCount += 1;
            }
        }
        return oddFrequencyCount <=1;
    }



    /**
     * Naive Approach:
     * - Generate all possible permutations of the string.
     * - For each permutation, check if it is a palindrome.
     *
     * Steps:
     * 1. Generate permutations of the string. This requires O(n!) time for a string of length n.
     * 2. Check each permutation to see if it reads the same forwards and backwards,
     *    which takes O(n) per permutation.
     *
     * Time Complexity: O(n! * n)
     * - Due to the exponential growth of permutations and the cost of checking each one.
     *
     * Space Complexity: O(n!)
     * - All permutations are stored in memory during execution.
     *
     * Drawbacks:
     * - This approach is computationally expensive and impractical for larger strings.
     * - Use this method only for conceptual understanding or very small inputs.
     */
    public static boolean permutePalindromeNaive(String st) {
        // Step 1: Generate all permutations of the string
        List<String> permutations = new ArrayList<>();
        generatePermutations("", st, permutations);

        // Step 2: Check each permutation to see if it's a palindrome
        for (String perm : permutations) {
            if (isPalindrome(perm)) {
                return true;
            }
        }

        // If no permutation is a palindrome, return false
        return false;
    }

    // Helper method to generate all permutations of a string
    private static void generatePermutations(String prefix, String remaining, List<String> result) {
        if (remaining.isEmpty()) {
            result.add(prefix);
        } else {
            for (int i = 0; i < remaining.length(); i++) {
                generatePermutations(
                        prefix + remaining.charAt(i),
                        remaining.substring(0, i) + remaining.substring(i + 1),
                        result
                );
            }
        }
    }

    // Helper method to check if a string is a palindrome
    private static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
